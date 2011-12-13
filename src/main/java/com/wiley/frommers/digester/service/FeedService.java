/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.service;

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
import com.wiley.frommers.digester.query.AudienceInterestQuery;
import com.wiley.frommers.digester.query.DestinationMenuQuery;
import com.wiley.frommers.digester.query.EventSearchQuery;
import com.wiley.frommers.digester.query.GuideQuery;
import com.wiley.frommers.digester.query.LocationSearchQuery;
import com.wiley.frommers.digester.query.PoiSearchQuery;
import com.wiley.frommers.digester.query.SlideShowSearchQuery;

/**
 * The Interface DestinationService.
 * 
 * @author fzerdoudi, created 7 Nov 2011
 */
public interface FeedService {

    /**
     * Gets the events by query.
     * 
     * @param query
     *            the query
     * @return the events by query
     * @throws SispException
     *             the sisp exception
     */
    public SearchResponse<EventSearchResult> searchEvents(EventSearchQuery query)
            throws SispException;

    /**
     * Search items of interests (event and poi).
     * 
     * @param query
     *            the query
     * @return the search response
     * @throws SispException
     *             the sisp exception
     */
    public SearchResponse<MainSearchResult> searchMains(EventSearchQuery query)
            throws SispException;

    /**
     * Gets the pois by query.
     * 
     * @param query
     *            the query
     * @return the pois by query
     * @throws SispException
     *             the sisp exception
     */
    public SearchResponse<POISearchResult> searchPois(PoiSearchQuery query)
            throws SispException;

    /**
     * Gets the categories by query.
     * 
     * @param query
     *            the query
     * @return the categories by query
     * @throws SispException
     *             the sisp exception
     */
    public SearchResponse<AudienceInterestResult> searchAudienceInterests(
            AudienceInterestQuery query) throws SispException;

    /**
     * Gets the destination menu by query.
     * 
     * @param query
     *            the query
     * @return the destination menu by query
     * @throws SispException
     *             the sisp exception
     */
    public DestinationMenu getDestinationMenuByQuery(DestinationMenuQuery query)
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
    public ItemOfInterest getItemOfInterestById(Long id) throws SispException;

    /**
     * Gets the locations by query.
     * 
     * @param query
     *            the query
     * @return the locations by query
     * @throws SispException
     *             the sisp exception
     */
    public SearchResponse<LocationSearchResult> searchLocations(
            LocationSearchQuery query) throws SispException;

    /**
     * Gets the guide structure by query.
     * 
     * @param query
     *            the query
     * @return the guide structure by query
     * @throws SispException
     *             the sisp exception
     */
    public GuideStructure getGuideStructureByQuery(GuideQuery query)
            throws SispException;

    /**
     * Search sildes show.
     * 
     * @param query
     *            the query
     * @return the search response
     * @throws SispException
     *             the sisp exception
     */
    public SearchResponse<SlideshowSearchResult> searchSildeshows(
            SlideShowSearchQuery query) throws SispException;

    /**
     * Gets the sildes show by query.
     * 
     * @param query
     *            the query
     * @return the sildes show by query
     * @throws SispException
     *             the sisp exception
     */
    public Slideshow getSildeshowById(Long id) throws SispException;

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

}
