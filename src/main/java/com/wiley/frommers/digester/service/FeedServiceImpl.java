/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
@Service
@SuppressWarnings("unchecked")
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

    private String odfUrl;

    private boolean cacheActive = true;

    public void setOdfUrl(String odfUrl) {
        this.odfUrl = odfUrl;
    }

    public void setMarshaller(XStreamMarshaller marshaller) {
        this.marshaller = marshaller;
    }

    protected final Log logger = LogFactory.getLog(getClass());

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
            logger.error(e);
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

        final String feedUrl = buildFullFeedUrl(query, odfUrl + feed);

        final InputStream stream = getHttpInputStream(feedUrl);

        final T eventResponse = (T) marshaller.getXStream().fromXML(stream);

        return eventResponse;
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
        final SearchResponse<EventSearchResult> eventResponse = executeQuery(
                EVENT_SEARCH_FEED, query);

        return eventResponse;
    }

    public SearchResponse<MainSearchResult> searchMains(EventSearchQuery query)
            throws SispException {
        final SearchResponse<MainSearchResult> eventResponse = executeQuery(
                EVENT_SEARCH_FEED, query);

        return eventResponse;
    }

    public SearchResponse<AudienceInterestResult> searchAudienceInterests(
            AudienceInterestQuery query) throws SispException {

        final SearchResponse<AudienceInterestResult> eventResponse = executeQuery(
                AUDIENCE_INTEREST_SEARCH_FEED, query);

        return eventResponse;

    }

    public DestinationMenu getDestinationMenuByQuery(DestinationMenuQuery query)
            throws SispException {

        DestinationMenu result = null;

        if (cacheActive) {
            result = MAP_CACHE.get(query.getId());
            if (result != null) {
                logger.info("getDestinationMenuByQuery from sisp cache");
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
                logger.info("getItemOfInterestById from sisp cache");
                return result;
            }
        }

        final String feedUrl = odfUrl + ITEM_OF_INTEREST_FEED
                + "?itemOfInterestId=" + id;

        final InputStream stream = getHttpInputStream(feedUrl);

        result = (ItemOfInterest) marshaller.getXStream().fromXML(stream);
        if (cacheActive && result != null)
            MAP_CACHE.put(result.getId().toString(), result);
        logger.info("getItemOfInterestById from network");

        return result;
    }

    public SearchResponse<LocationSearchResult> searchLocations(
            LocationSearchQuery query) throws SispException {

        final SearchResponse<LocationSearchResult> eventResponse = executeQuery(
                LOCATION_SEARCH_FEED, query);

        return eventResponse;

    }

    public GuideStructure getGuideStructureByQuery(GuideQuery query)
            throws SispException {

        GuideStructure result = null;

        if (cacheActive) {
            result = MAP_CACHE.get(query.getId());
            if (result != null) {
                logger.info("getGuideStructureByQuery from sisp cache");
                return result;
            }
        }

        result = executeQuery(GUIDE_STRUCTURE_FEED, query);

        if (cacheActive && result != null)
            MAP_CACHE.put(result.getId().toString(), result);
        logger.info("getGuideStructureByQuery from http");

        return result;
    }

    public SearchResponse<POISearchResult> searchPois(PoiSearchQuery query)
            throws SispException {

        final SearchResponse<POISearchResult> eventResponse = executeQuery(
                POI_SEARCH_FEED, query);

        return eventResponse;
    }

    public Location getLocationById(Long id) throws SispException {
        final String feedUrl = odfUrl + LOCATION_FEED + "?locationId=" + id;
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

        logger.info("getLocationById from http");

        return result;
    }

    public void setCacheActive(boolean useCache) {
        this.cacheActive = useCache;
    }

    public SearchResponse<SlideshowSearchResult> searchSildeshows(
            SlideShowSearchQuery query) throws SispException {
        final SearchResponse<SlideshowSearchResult> slidesResult = executeQuery(
                SLIDE_SHOW_SEARCH_FEED, query);

        logger.debug("getSildesShowByQuery() SlideshowSearchResult found = "
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

        String feedUrl = odfUrl + SLIDE_SHOW_FEED + "?slideshowId=" + id;

        final InputStream stream = getHttpInputStream(feedUrl);

        result = (Slideshow) marshaller.getXStream().fromXML(stream);

        if (cacheActive && result != null)
            MAP_CACHE.put(id.toString(), result);

        logger.debug("getSildesShowById() slideshow found = " + "("
                + result.getSlideCount() + ")");

        return result;
    }

}
