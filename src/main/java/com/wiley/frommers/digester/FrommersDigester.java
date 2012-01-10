package com.wiley.frommers.digester;

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
import com.wiley.frommers.digester.query.SlideshowSearchQuery;

/**
 * Main interface which provides access to the Frommers API methods.
 */
public interface FrommersDigester {

    public abstract FrommersDigesterConfig getConfig();

    public abstract Slideshow getSlideshowById(Long slideshowId)
            throws FrommersFeedException;

    public abstract Media getMediaById(Long mediaId)
            throws FrommersFeedException;

    public abstract Location getLocationById(Long locationId)
            throws FrommersFeedException;

    public abstract GuideStructure getGuideStructureById(Long guideStructureId)
            throws FrommersFeedException;

    public abstract GuideStructure getGuideStructureByGuideStructureTypeIdAndLocationId(
            Long guideStructureTypeId, Long locationId)
            throws FrommersFeedException;

    public abstract ItemOfInterest getItemOfInterestById(Long itemOfInterestId)
            throws FrommersFeedException;

    public abstract DestinationMenu getDestinationMenuByLocationId(
            Long locationId, boolean autoHide) throws FrommersFeedException;

    public abstract DestinationMenu getDestinationMenuByGuideStructureId(
            Long guideStructureId, boolean autoHide)
            throws FrommersFeedException;

    public abstract DestinationMenu getDestinationMenuByGuideId(Long guideId,
            boolean autoHide) throws FrommersFeedException;

    public abstract DestinationMenu getDestinationMenuByItemOfInterestId(
            Long itemOfInterestId, boolean autoHide)
            throws FrommersFeedException;

    public abstract SearchResponse<MainSearchResult> searchMain(
            MainSearchQuery query) throws FrommersFeedException;

    public abstract SearchResponse<EventSearchResult> searchEvents(
            EventSearchQuery query) throws FrommersFeedException;

    public abstract SearchResponse<POISearchResult> searchPOIs(
            POISearchQuery query) throws FrommersFeedException;

    public abstract SearchResponse<AudienceInterestResult> searchAudienceInterests(
            AudienceInterestSearchQuery query) throws FrommersFeedException;

    public abstract SearchResponse<LocationSearchResult> searchLocations(
            LocationSearchQuery query) throws FrommersFeedException;

    public abstract SearchResponse<SlideshowSearchResult> searchSlideshows(
            SlideshowSearchQuery query) throws FrommersFeedException;

    public abstract SearchResponse<CalendarResult> searchCalendarEvents(
            CalendarEventSearchQuery query) throws FrommersFeedException;

    public abstract SearchResponse<MediaSearchResult> searchMedia(
            MediaSearchQuery query) throws FrommersFeedException;

}