/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.service.impl;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Service;

import com.wiley.frommers.digester.cache.MapCache;
import com.wiley.frommers.digester.domain.GuideStructure;
import com.wiley.frommers.digester.domain.ItemOfInterest;
import com.wiley.frommers.digester.domain.Location;
import com.wiley.frommers.digester.domain.Slideshow;
import com.wiley.frommers.digester.exception.SispException;
import com.wiley.frommers.digester.exception.SispHttpException;
import com.wiley.frommers.digester.service.FeedService;
import com.wiley.frommers.digester.util.Feed;
import com.wiley.frommers.digester.util.FeedUrlBuilder;

/**
 * Implementation of FeedService interface.
 */
@Service
public class FeedServiceImpl implements FeedService {

    // TODO how to use a caching interface
    private static final MapCache MAP_CACHE = new MapCache();

    protected static final Log LOGGER = LogFactory.getLog(FeedServiceImpl.class);

    @Value("${rootUrl}")
    private String rootUrl;
    
    @Value("${cacheActive}")
    private boolean cacheActive;

    @Autowired(required = true)
    private XStreamMarshaller marshaller;

    /**
     * Execute query and unmarshal the inputStream to a java object.
     * 
     * @param <T>
     *            the java object type
     * @param url
     *            the url
     * @throws SispHttpException
     *             the sisp http exception
     */
    @SuppressWarnings("unchecked")
    private <T> T executeFeedRequest(URL url) {
        return (T) marshaller.getXStream().fromXML(url);
    }

    @SuppressWarnings("unchecked")
    private <T> T getById(String feedCode, String idName, Long idVal) throws SispException {
        T result = null;

        if (cacheActive) {
            result = MAP_CACHE.get(idVal.toString());
            if (result != null) {
                return result;
            }
        }

        FeedUrlBuilder urlBuilder = new FeedUrlBuilder(rootUrl, feedCode);
        urlBuilder.addParameter(idName, idVal);
        
        URL url;
        try {
            url = urlBuilder.toURL();
        } catch(MalformedURLException e) {
            throw new SispException("Unable to construct url: " + urlBuilder.toString());
        }
        
        result = (T) executeFeedRequest(url);

        if (cacheActive && result != null) {
            MAP_CACHE.put(idVal.toString(), result);
        }

        return result;
    }
    
    
    @Override
    public Slideshow getSlideshowById(Long slideshowId) throws SispException {
        return (Slideshow) getById(Feed.SLIDESHOW.getCode(), Feed.SLIDESHOW.getIdName(), 
                slideshowId);
    }

    @Override
    public Location getLocationById(Long locationId) throws SispException {
        return (Location) getById(Feed.LOCATION.getCode(), Feed.LOCATION.getIdName(), 
                locationId);
    }

    @Override
    public GuideStructure getGuideStructureById(Long guideStructureId)
            throws SispException {
        return (GuideStructure) getById(Feed.GUIDE_STRUCTURE.getCode(), Feed.GUIDE_STRUCTURE.getIdName(), 
                guideStructureId);
    }

    @Override
    public ItemOfInterest getItemOfInterestById(Long itemOfInterestId)
            throws SispException {
        return (ItemOfInterest) getById(Feed.ITEM_OF_INTEREST.getCode(), Feed.ITEM_OF_INTEREST.getIdName(), 
                itemOfInterestId);
    }

    /*
    @Override
    public DestinationMenu getDestinationMenuByLocationId(Long locationId)
            throws SispException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResponse<EventSearchResult> searchEvents(EventSearchQuery query)
            throws SispException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResponse<MainSearchResult> searchMains(EventSearchQuery query)
            throws SispException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResponse<POISearchResult> searchPois(PoiSearchQuery query)
            throws SispException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResponse<AudienceInterestResult> searchAudienceInterests(
            AudienceInterestQuery query) throws SispException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResponse<LocationSearchResult> searchLocations(
            LocationSearchQuery query) throws SispException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResponse<SlideshowSearchResult> searchSlideshows(
            SlideShowSearchQuery query) throws SispException {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
    
    /*

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

    }*/

}
