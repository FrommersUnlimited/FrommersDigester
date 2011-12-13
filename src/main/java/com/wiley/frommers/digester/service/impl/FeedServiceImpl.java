/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Service;

import com.wiley.frommers.digester.cache.MapCache;
import com.wiley.frommers.digester.domain.AudienceInterestResult;
import com.wiley.frommers.digester.domain.DestinationMenu;
import com.wiley.frommers.digester.domain.EventSearchResult;
import com.wiley.frommers.digester.domain.GuideStructure;
import com.wiley.frommers.digester.domain.ItemOfInterest;
import com.wiley.frommers.digester.domain.Location;
import com.wiley.frommers.digester.domain.LocationSearchResult;
import com.wiley.frommers.digester.domain.MainSearchResult;
import com.wiley.frommers.digester.domain.POISearchResult;
import com.wiley.frommers.digester.domain.SearchResponse;
import com.wiley.frommers.digester.domain.Slideshow;
import com.wiley.frommers.digester.domain.SlideshowSearchResult;
import com.wiley.frommers.digester.exception.SispException;
import com.wiley.frommers.digester.exception.SispHttpException;
import com.wiley.frommers.digester.query.AudienceInterestQuery;
import com.wiley.frommers.digester.query.DestinationMenuQuery;
import com.wiley.frommers.digester.query.EventSearchQuery;
import com.wiley.frommers.digester.query.FeedQuery;
import com.wiley.frommers.digester.query.GuideQuery;
import com.wiley.frommers.digester.query.LocationSearchQuery;
import com.wiley.frommers.digester.query.PoiSearchQuery;
import com.wiley.frommers.digester.query.SlideShowSearchQuery;
import com.wiley.frommers.digester.service.FeedService;

/**
 * Implementation of FeedService interface.
 */
@Service
public class FeedServiceImpl implements FeedService {

    // TODO how to use a caching interface
    private static final MapCache MAP_CACHE = new MapCache();

    private static final String EVENT_SEARCH_FEED = "event_search.feed";
    private static final String DESTINATION_MENU_FEED = "destination_menu.feed";
    private static final String AUDIENCE_INTEREST_SEARCH_FEED = "audience_interest_search.feed";
    private static final String ITEM_OF_INTEREST_FEED = "item_of_interest.feed";
    private static final String LOCATION_SEARCH_FEED = "location_search.feed";
    private static final String GUIDE_STRUCTURE_FEED = "guide_structure.feed";
    private static final String SLIDE_SHOW_FEED = "slideshow.feed";
    private static final String SLIDE_SHOW_SEARCH_FEED = "slideshow_search.feed";
    private static final String POI_SEARCH_FEED = "poi_search.feed";
    private static final String LOCATION_FEED = "location.feed";

    protected static final Log LOGGER = LogFactory.getLog(FeedServiceImpl.class);

    @Value("${rootUrl}")
    private String rootUrl;

    @Value("${cacheActive}")
    private boolean cacheActive;

    @Autowired(required = true)
    private XStreamMarshaller marshaller;

    /**
     * Gets the http input stream of the feed.
     * 
     * @param url
     *            the feeds url
     * @return the http input stream
     * @throws SispHttpException
     *             the sisp http exception
     */
    private InputStream getHttpInputStream(String url) throws SispHttpException {

        try {
            URL _url = new URL(url);

            InputStream stream = _url.openConnection().getInputStream();

            return stream;
        } catch (IOException e) {
            LOGGER.error(e);
            throw new SispHttpException(e);
        }

    }

    /**
     * Execute query and unmarshal the inputStream to a java object.
     * 
     * @param <T>
     *            the java object type
     * @param feed
     *            the feed name
     * @param query
     *            the query
     * @return the t
     * @throws SispHttpException
     *             the sisp http exception
     */
    private <T> T executeQuery(String feed, FeedQuery query)
            throws SispHttpException {

        final String feedUrl = buildFullFeedUrl(query, rootUrl + feed);

        final InputStream stream = getHttpInputStream(feedUrl);

        @SuppressWarnings("unchecked")
        final T result = (T) marshaller.getXStream().fromXML(stream);

        return result;
    }

    /**
     * Builds the full feed url from the feed name and the query parameters.
     * 
     * @param query
     *            the query
     * @param feed
     *            the feed
     * @return the string
     */
    private static String buildFullFeedUrl(FeedQuery query, String feed) {
        String paramUrl = query.toUrl();
        String fullUrl;
        if (paramUrl != null)
            fullUrl = feed + paramUrl;
        else
            fullUrl = feed;

        return fullUrl;

    }

    public SearchResponse<EventSearchResult> searchEvents(EventSearchQuery query)
            throws SispException {
        // TODO see if we cache the search results
        final SearchResponse<EventSearchResult> result = executeQuery(
                EVENT_SEARCH_FEED, query);

        return result;
    }

    public SearchResponse<MainSearchResult> searchMains(EventSearchQuery query)
            throws SispException {
        final SearchResponse<MainSearchResult> result = executeQuery(
                EVENT_SEARCH_FEED, query);

        return result;
    }

    public SearchResponse<AudienceInterestResult> searchAudienceInterests(
            AudienceInterestQuery query) throws SispException {

        final SearchResponse<AudienceInterestResult> result = executeQuery(
                AUDIENCE_INTEREST_SEARCH_FEED, query);

        return result;

    }

    public DestinationMenu getDestinationMenuByQuery(DestinationMenuQuery query)
            throws SispException {

        DestinationMenu result = null;

        if (cacheActive) {
            result = MAP_CACHE.get(query.getId());
            if (result != null) {
                LOGGER.info("getDestinationMenuByQuery from sisp cache");
                return result;
            }
        }

        result = executeQuery(DESTINATION_MENU_FEED, query);

        if (cacheActive && result != null)
            MAP_CACHE.put(query.getId(), result);

        return result;
    }

    public ItemOfInterest getItemOfInterestById(Long id) throws SispException {

        ItemOfInterest result = null;
        if (cacheActive) {
            result = MAP_CACHE.get(id.toString());
            if (result != null) {
                LOGGER.info("getItemOfInterestById from sisp cache");
                return result;
            }
        }

        final String feedUrl = rootUrl + ITEM_OF_INTEREST_FEED
                + "?itemOfInterestId=" + id;

        final InputStream stream = getHttpInputStream(feedUrl);

        result = (ItemOfInterest) marshaller.getXStream().fromXML(stream);
        if (cacheActive && result != null)
            MAP_CACHE.put(result.getId().toString(), result);
        LOGGER.info("getItemOfInterestById from network");

        return result;
    }

    public SearchResponse<LocationSearchResult> searchLocations(
            LocationSearchQuery query) throws SispException {

        final SearchResponse<LocationSearchResult> result = executeQuery(
                LOCATION_SEARCH_FEED, query);

        return result;

    }

    public GuideStructure getGuideStructureByQuery(GuideQuery query)
            throws SispException {

        GuideStructure result = null;

        if (cacheActive) {
            result = MAP_CACHE.get(query.getId());
            if (result != null) {
                LOGGER.info("getGuideStructureByQuery from sisp cache");
                return result;
            }
        }

        result = executeQuery(GUIDE_STRUCTURE_FEED, query);

        if (cacheActive && result != null)
            MAP_CACHE.put(result.getId().toString(), result);
        LOGGER.info("getGuideStructureByQuery from http");

        return result;
    }

    public SearchResponse<POISearchResult> searchPois(PoiSearchQuery query)
            throws SispException {

        final SearchResponse<POISearchResult> result = executeQuery(
                POI_SEARCH_FEED, query);

        return result;
    }

    public Location getLocationById(Long id) throws SispException {
        final String feedUrl = rootUrl + LOCATION_FEED + "?locationId=" + id;
        Location result = null;

        if (cacheActive) {
            result = MAP_CACHE.get(id.toString());
            if (result != null)
                return result;

        }

        final InputStream stream = getHttpInputStream(feedUrl);

        result = (Location) marshaller.getXStream().fromXML(stream);

        if (cacheActive && result != null)
            MAP_CACHE.put(result.getId().toString(), result);

        LOGGER.info("getLocationById from http");

        return result;
    }

    public void setCacheActive(boolean useCache) {
        this.cacheActive = useCache;
    }

    public SearchResponse<SlideshowSearchResult> searchSildeshows(
            SlideShowSearchQuery query) throws SispException {
        final SearchResponse<SlideshowSearchResult> slidesResult = executeQuery(
                SLIDE_SHOW_SEARCH_FEED, query);

        LOGGER.debug("getSildesShowByQuery() SlideshowSearchResult found = "
                + "(" + slidesResult.getTotalResultCount() + ")");

        return slidesResult;
    }

    public Slideshow getSildeshowById(Long id) throws SispException {

        Slideshow result = null;

        if (cacheActive) {

            result = MAP_CACHE.get(id.toString());
            if (result != null)
                return result;

        }

        String feedUrl = rootUrl + SLIDE_SHOW_FEED + "?slideshowId=" + id;

        final InputStream stream = getHttpInputStream(feedUrl);

        result = (Slideshow) marshaller.getXStream().fromXML(stream);

        if (cacheActive && result != null)
            MAP_CACHE.put(id.toString(), result);

        LOGGER.debug("getSildesShowById() slideshow found = " + "("
                + result.getSlideCount() + ")");

        return result;
    }

}
