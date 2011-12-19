package com.wiley.frommers.digester;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
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
import com.wiley.frommers.digester.query.MainSearchQuery;
import com.wiley.frommers.digester.query.Query;

/**
 * Implementation of FeedService interface.
 */
public class FrommersDigester {

	protected static final Logger LOGGER = Logger.getLogger(FrommersDigester.class);
	
	protected static final Class<?>[] ANNOTATED_CLASSES = new Class[] {
			SearchResponse.class, MainSearchResult.class,
			EventSearchResult.class, ItemOfInterest.class,
			DestinationMenu.class, AudienceInterestResult.class,
			LocationSearchResult.class, GuideStructure.class, Slideshow.class,
			SlideshowSearchResult.class, POISearchResult.class, Location.class };
    private static FrommersDigester instance;

    private final String rootUrl;
    private final boolean cacheActive;
    private final XStream xstream;
    
    // --------------------------------------------------------
    // static singleton instance methods
    // --------------------------------------------------------
    
    /**
     * Singleton access method.  Provide rootUrl and cacheActive to 
     * configure instance.
     */
    public static final FrommersDigester getInstance(String rootUrl, boolean cacheActive) {
    	if (instance == null || !rootUrl.equals(instance.rootUrl) 
    			|| cacheActive != instance.cacheActive) {
    		LOGGER.debug("FeedService.getInstance creating new FeedService instance");
    		instance = new FrommersDigester(rootUrl, cacheActive);
    	}
    	return instance;
    }
    
	/**
	 * Returns pre-initialized instance. If an instance has not be initialized
	 * this method will thrown an exception.
	 * 
	 * @return
	 * @throws FrommersFeedException
	 */
    public static final FrommersDigester getInstance() throws FrommersFeedException {
    	if (instance == null) {
    		throw new FrommersFeedException("rootUrl and cacheActive not configured");
    	}
    	return instance;
    }
    
    // --------------------------------------------------------
    // private constructor to restrict creation
    // --------------------------------------------------------
    
    private FrommersDigester(String rootUrl, boolean cacheActive) {
    	this.rootUrl = rootUrl;
    	this.cacheActive = cacheActive;
    	this.xstream = new XStream();
    	this.xstream.processAnnotations(ANNOTATED_CLASSES);
    }

    /**
     * Call feed using an ID name and value.  Used mostly for get* methods.
     * 
     * @param feedCode
     * @param idName
     * @param idVal
     * @return
     * @throws FrommersFeedException
     */
    @SuppressWarnings("unchecked")
    private <T> T getById(String feedCode, String idName, Long idVal) throws FrommersFeedException {
        T result = null;

        result = (T) getFeedResponse(FeedUrlBuilder.createUrl(rootUrl, feedCode, idName, idVal));

        return result;
    }
    
    /**
     * Call feed using a custom Query object.  Used mostly for search* methods.
     * 
     * @param feedCode
     * @param query
     * @return
     * @throws FrommersFeedException
     */
    @SuppressWarnings("unchecked")
    private <T> T getByQuery(String feedCode, Query query) throws FrommersFeedException {
        return (T) getFeedResponse(FeedUrlBuilder.createUrl(rootUrl, feedCode, query));
    }
    
    /**
     * Simple method that takes a URL and executes a HTTP request to the feed
     * server.
     * 
     * @param urlStr
     * @return
     * @throws FrommersFeedException
     */
    @SuppressWarnings("unchecked")
    private <T> T getFeedResponse(String urlStr) throws FrommersFeedException {
        
        if (cacheActive) {
            // TODO: Implement URL based caching.  Different cache configurations for different
            // feed types (configurable)
        }
        
        URL url;
        try {
            url = new URL(urlStr);
        } catch(MalformedURLException e) {
            throw new FrommersFeedException("Unable to construct url: " + urlStr);
        }
        LOGGER.trace("executeFeedRequest: " + urlStr);
        T result = (T) xstream.fromXML(url); 
        
        if (cacheActive && result != null) {
            // TODO: Implement URL based caching
        }
        
        return result;
    }
    
    // --------------------------------------------------------
    // get methods that return 1 object
    // --------------------------------------------------------
    
    public Slideshow getSlideshowById(Long slideshowId) throws FrommersFeedException {
        return (Slideshow) getById(Feed.SLIDESHOW.getCode(), Feed.SLIDESHOW.getIdName(), 
                slideshowId);
    }
    public Location getLocationById(Long locationId) throws FrommersFeedException {
        return (Location) getById(Feed.LOCATION.getCode(), Feed.LOCATION.getIdName(), 
                locationId);
    }

    public GuideStructure getGuideStructureById(Long guideStructureId)
            throws FrommersFeedException {
        return (GuideStructure) getById(Feed.GUIDE_STRUCTURE.getCode(), Feed.GUIDE_STRUCTURE.getIdName(), 
                guideStructureId);
    }

    public ItemOfInterest getItemOfInterestById(Long itemOfInterestId)
            throws FrommersFeedException {
        return (ItemOfInterest) getById(Feed.ITEM_OF_INTEREST.getCode(), Feed.ITEM_OF_INTEREST.getIdName(), 
                itemOfInterestId);
    }
    
    // --------------------------------------------------------
    // search based methods that return SearchResponse objects
    // --------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    public SearchResponse<MainSearchResult> mainSearch(MainSearchQuery query)
            throws FrommersFeedException {
        return (SearchResponse<MainSearchResult>) getByQuery(
                Feed.MAIN_SEARCH.getCode(), query);
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
