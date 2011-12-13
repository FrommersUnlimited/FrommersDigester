/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.service;

import com.wiley.frommers.digester.domain.GuideStructure;
import com.wiley.frommers.digester.domain.ItemOfInterest;
import com.wiley.frommers.digester.domain.Location;
import com.wiley.frommers.digester.domain.Slideshow;
import com.wiley.frommers.digester.exception.SispException;

/**
 * The Interface DestinationService.
 * 
 * @author fzerdoudi, created 7 Nov 2011
 */
public interface FeedService {
    
    /**
     * Gets the slideshow by id.
     * 
     * @param query
     *            the query
     * @return the sildes show by query
     * @throws SispException
     *             the sisp exception
     */
    public Slideshow getSlideshowById(Long id) throws SispException;

    /**
     * Gets the location by id.
     * 
     * @param id
     *            the id
     * @return the location by id
     * @throws SispException
     *             the sisp exception
     */
    public Location getLocationById(Long id) throws SispException;
    
    /**
     * Gets the guide structure by id.
     * 
     * @param query
     *            the query
     * @return the guide structure by query
     * @throws SispException
     *             the sisp exception
     */
    public GuideStructure getGuideStructureById(Long guideStructureId)
            throws SispException;
    
    /**
     * Gets the item of interest by id.
     * 
     * @param id
     *            the id
     * @return the item of interest by id
     * @throws SispException
     *             the sisp exception
     */
    public ItemOfInterest getItemOfInterestById(Long itemOfInterestId) throws SispException;
    
    
    /**
     * Gets the destination menu by location id.
     * 
     * @param query
     *            the query
     * @return the destination menu by query
     * @throws SispException
     *             the sisp exception
     */
//    public DestinationMenu getDestinationMenuByLocationId(Long locationId)
//            throws SispException;

    /**
     * Gets the events by query.
     * 
     * @param query
     *            the query
     * @return the events by query
     * @throws SispException
     *             the sisp exception
     */
//    public SearchResponse<EventSearchResult> searchEvents(EventSearchQuery query)
//            throws SispException;

    /**
     * Search items of interests (event and poi).
     * 
     * @param query
     *            the query
     * @return the search response
     * @throws SispException
     *             the sisp exception
     */
//    public SearchResponse<MainSearchResult> searchMains(EventSearchQuery query)
//            throws SispException;

    /**
     * Gets the pois by query.
     * 
     * @param query
     *            the query
     * @return the pois by query
     * @throws SispException
     *             the sisp exception
     */
//    public SearchResponse<POISearchResult> searchPois(PoiSearchQuery query)
//            throws SispException;

    /**
     * Gets the categories by query.
     * 
     * @param query
     *            the query
     * @return the categories by query
     * @throws SispException
     *             the sisp exception
     */
//    public SearchResponse<AudienceInterestResult> searchAudienceInterests(
//            AudienceInterestQuery query) throws SispException;

    /**
     * Gets the locations by query.
     * 
     * @param query
     *            the query
     * @return the locations by query
     * @throws SispException
     *             the sisp exception
     */
//    public SearchResponse<LocationSearchResult> searchLocations(
//            LocationSearchQuery query) throws SispException;

    /**
     * Search sildes show.
     * 
     * @param query
     *            the query
     * @return the search response
     * @throws SispException
     *             the sisp exception
     */
//    public SearchResponse<SlideshowSearchResult> searchSlideshows(
//            SlideShowSearchQuery query) throws SispException;

    

}
