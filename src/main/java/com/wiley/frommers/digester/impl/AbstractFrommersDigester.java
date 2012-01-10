package com.wiley.frommers.digester.impl;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.wiley.frommers.digester.Feed;
import com.wiley.frommers.digester.FeedUrlBuilder;
import com.wiley.frommers.digester.FrommersDigester;
import com.wiley.frommers.digester.FrommersDigesterConfig;
import com.wiley.frommers.digester.FrommersFeedException;
import com.wiley.frommers.digester.domain.AudienceInterestResult;
import com.wiley.frommers.digester.domain.CalendarResult;
import com.wiley.frommers.digester.domain.DestinationMenu;
import com.wiley.frommers.digester.domain.EventSearchResult;
import com.wiley.frommers.digester.domain.GuideStructure;
import com.wiley.frommers.digester.domain.ItemOfInterest;
import com.wiley.frommers.digester.domain.Location;
import com.wiley.frommers.digester.domain.LocationSearchResult;
import com.wiley.frommers.digester.domain.MainSearchResult;
import com.wiley.frommers.digester.domain.Media;
import com.wiley.frommers.digester.domain.MediaSearchResult;
import com.wiley.frommers.digester.domain.POISearchResult;
import com.wiley.frommers.digester.domain.SearchResponse;
import com.wiley.frommers.digester.domain.Slideshow;
import com.wiley.frommers.digester.domain.SlideshowSearchResult;
import com.wiley.frommers.digester.query.AudienceInterestSearchQuery;
import com.wiley.frommers.digester.query.CalendarEventSearchQuery;
import com.wiley.frommers.digester.query.EventSearchQuery;
import com.wiley.frommers.digester.query.LocationSearchQuery;
import com.wiley.frommers.digester.query.MainSearchQuery;
import com.wiley.frommers.digester.query.MediaSearchQuery;
import com.wiley.frommers.digester.query.POISearchQuery;
import com.wiley.frommers.digester.query.Query;
import com.wiley.frommers.digester.query.QueryParams;
import com.wiley.frommers.digester.query.SlideshowSearchQuery;

/**
 * Implementation of FeedService interface.
 */
public abstract class AbstractFrommersDigester implements FrommersDigester {

	protected static final Logger LOGGER = Logger.getLogger(AbstractFrommersDigester.class);
	
	private FrommersDigesterConfig config;
	private String rootUrl;
    
    public AbstractFrommersDigester(FrommersDigesterConfig config) {
    	this.config = config;
    	this.rootUrl = config.getRootUrl();
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
        return (T) getFeedResponse(FeedUrlBuilder.createUrl(rootUrl, feedCode, idName, idVal));
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
    private <T> T getFeedResponse(String urlStr) throws FrommersFeedException {
        
        // TODO: Implement URL based caching.  Different cache configurations for different
        // feed types (configurable)
        
        URL url;
        try {
            url = new URL(urlStr);
        } catch(MalformedURLException e) {
            throw new FrommersFeedException("Unable to construct url: " + urlStr);
        }
        
        LOGGER.trace("executeFeedRequest: " + urlStr);
        T result = executeFeedRequest(url); 

        // TODO: Add to cache
        
        return result;
    }
    
    protected abstract <T> T executeFeedRequest(URL url);
    
    // --------------------------------------------------------
    // get methods that return 1 object
    // --------------------------------------------------------
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#getSlideshowById(java.lang.Long)
     */
    @Override
    public Slideshow getSlideshowById(Long slideshowId) throws FrommersFeedException {
        return (Slideshow) getById(
                Feed.SLIDESHOW.getCode(), 
                QueryParams.SLIDESHOW_ID.getName(), 
                slideshowId);
    }
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#getMediaById(java.lang.Long)
     */
    @Override
    public Media getMediaById(Long mediaId) throws FrommersFeedException {
        return (Media) getById(
                Feed.MEDIA.getCode(), 
                QueryParams.MEDIA_ID.getName(), 
                mediaId);
    }
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#getLocationById(java.lang.Long)
     */
    @Override
    public Location getLocationById(Long locationId) throws FrommersFeedException {
        return (Location) getById(
                Feed.LOCATION.getCode(), 
                QueryParams.LOCATION_ID.getName(), 
                locationId);
    }

    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#getGuideStructureById(java.lang.Long)
     */
    @Override
    public GuideStructure getGuideStructureById(Long guideStructureId)
            throws FrommersFeedException {
        return (GuideStructure) getById(
                Feed.GUIDE_STRUCTURE.getCode(), 
                QueryParams.GUIDE_STRUCTURE_ID.getName(), 
                guideStructureId);
    }
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#getGuideStructureByGuideStructureTypeIdAndLocationId(java.lang.Long, java.lang.Long)
     */
    @Override
    public GuideStructure getGuideStructureByGuideStructureTypeIdAndLocationId(
            Long guideStructureTypeId, Long locationId)
            throws FrommersFeedException {
        FeedUrlBuilder urlBuilder = new FeedUrlBuilder(rootUrl,
                Feed.GUIDE_STRUCTURE.getCode());
        urlBuilder.addParameter(QueryParams.GUIDE_STRUCTURE_TYPE_ID.getName(),
                String.valueOf(guideStructureTypeId));
        urlBuilder.addParameter(QueryParams.LOCATION_ID.getName(),
                String.valueOf(locationId));
        return (GuideStructure) getFeedResponse(urlBuilder.toString());
    }
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#getItemOfInterestById(java.lang.Long)
     */
    @Override
    public ItemOfInterest getItemOfInterestById(Long itemOfInterestId)
            throws FrommersFeedException {
        return (ItemOfInterest) getById(
                Feed.ITEM_OF_INTEREST.getCode(), 
                QueryParams.ITEM_OF_INTEREST_ID.getName(), 
                itemOfInterestId);
    }
    
    // --------------------------------------------------------
    // destination menu methods
    // --------------------------------------------------------
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#getDestinationMenuByLocationId(java.lang.Long, boolean)
     */
    @Override
    public DestinationMenu getDestinationMenuByLocationId(Long locationId, boolean autoHide)
            throws FrommersFeedException {
        return getDestinationMenu(QueryParams.LOCATION_ID.getName(), locationId, autoHide);
    }
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#getDestinationMenuByGuideStructureId(java.lang.Long, boolean)
     */
    @Override
    public DestinationMenu getDestinationMenuByGuideStructureId(Long guideStructureId, boolean autoHide)
            throws FrommersFeedException {
        return getDestinationMenu(QueryParams.GUIDE_STRUCTURE_ID.getName(), guideStructureId, autoHide);
    }
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#getDestinationMenuByGuideId(java.lang.Long, boolean)
     */
    @Override
    public DestinationMenu getDestinationMenuByGuideId(Long guideId, boolean autoHide)
            throws FrommersFeedException {
        return getDestinationMenu(QueryParams.GUIDE_ID.getName(), guideId, autoHide);
    }
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#getDestinationMenuByItemOfInterestId(java.lang.Long, boolean)
     */
    @Override
    public DestinationMenu getDestinationMenuByItemOfInterestId(Long itemOfInterestId, boolean autoHide)
            throws FrommersFeedException {
        return getDestinationMenu(QueryParams.ITEM_OF_INTEREST_ID.getName(), itemOfInterestId, autoHide);
    }
    
    private DestinationMenu getDestinationMenu(String idName, Long idVal,
            boolean autoHide) throws FrommersFeedException {
        FeedUrlBuilder urlBuilder = new FeedUrlBuilder(rootUrl,
                Feed.DESTINATION_MENU.getCode());
        urlBuilder.addParameter(QueryParams.AUTO_HIDE.getName(),
                String.valueOf(autoHide));
        urlBuilder.addParameter(idName, String.valueOf(idVal));
        return (DestinationMenu) getFeedResponse(urlBuilder.toString());
    }
    
    // --------------------------------------------------------
    // search based methods that return SearchResponse objects
    // --------------------------------------------------------
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#searchMain(com.wiley.frommers.digester.query.MainSearchQuery)
     */
    @Override
    @SuppressWarnings("unchecked")
    public SearchResponse<MainSearchResult> searchMain(MainSearchQuery query)
            throws FrommersFeedException {
        return (SearchResponse<MainSearchResult>) getByQuery(
                Feed.MAIN_SEARCH.getCode(), query);
    }
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#searchEvents(com.wiley.frommers.digester.query.EventSearchQuery)
     */
    @Override
    @SuppressWarnings("unchecked")
    public SearchResponse<EventSearchResult> searchEvents(EventSearchQuery query)
            throws FrommersFeedException {
        return (SearchResponse<EventSearchResult>) getByQuery(
                Feed.EVENT_SEARCH.getCode(), query);
    }
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#searchPOIs(com.wiley.frommers.digester.query.POISearchQuery)
     */
    @Override
    @SuppressWarnings("unchecked")
    public SearchResponse<POISearchResult> searchPOIs(POISearchQuery query)
            throws FrommersFeedException {
        return (SearchResponse<POISearchResult>) getByQuery(
                Feed.POI_SEARCH.getCode(), query);
    }

    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#searchAudienceInterests(com.wiley.frommers.digester.query.AudienceInterestSearchQuery)
     */
    @Override
    @SuppressWarnings("unchecked")
    public SearchResponse<AudienceInterestResult> searchAudienceInterests(
            AudienceInterestSearchQuery query) throws FrommersFeedException {
        return (SearchResponse<AudienceInterestResult>) getByQuery(
                Feed.AUDIENCE_INTEREST_SEARCH.getCode(), query);
    }

    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#searchLocations(com.wiley.frommers.digester.query.LocationSearchQuery)
     */
    @Override
    @SuppressWarnings("unchecked")
    public SearchResponse<LocationSearchResult> searchLocations(
            LocationSearchQuery query) throws FrommersFeedException {
        return (SearchResponse<LocationSearchResult>) getByQuery(
                Feed.LOCATION_SEARCH.getCode(), query);
    }

    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#searchSlideshows(com.wiley.frommers.digester.query.SlideshowSearchQuery)
     */
    @Override
    @SuppressWarnings("unchecked")
    public SearchResponse<SlideshowSearchResult> searchSlideshows(
            SlideshowSearchQuery query) throws FrommersFeedException {
        return (SearchResponse<SlideshowSearchResult>) getByQuery(
                Feed.SLIDESHOW_SEARCH.getCode(), query);
    }
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.impl.FrommersDigister#searchCalendarEvents(com.wiley.frommers.digester.query.CalendarEventSearchQuery)
     */
    @Override
    @SuppressWarnings("unchecked")
    public SearchResponse<CalendarResult> searchCalendarEvents(CalendarEventSearchQuery query)
            throws FrommersFeedException {
        return (SearchResponse<CalendarResult>) getByQuery(
                Feed.CALENDAR_EVENT_SEARCH.getCode(), query);
    }
    
    
    /* (non-Javadoc)
     * @see com.wiley.frommers.digester.FrommersDigester#searchMedia(com.wiley.frommers.digester.query.MediaSearchQuery)
     */
    @Override
    @SuppressWarnings("unchecked")
    public SearchResponse<MediaSearchResult> searchMedia(MediaSearchQuery query)
            throws FrommersFeedException {
        return (SearchResponse<MediaSearchResult>) getByQuery(
                Feed.MEDIA_SEARCH.getCode(), query);
    }

    public FrommersDigesterConfig getConfig() {
        return config;
    }

}
