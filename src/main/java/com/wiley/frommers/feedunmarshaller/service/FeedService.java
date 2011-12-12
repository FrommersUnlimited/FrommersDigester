/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.service;

import com.wiley.frommers.feedunmarshaller.domain.AudienceInterestResult;
import com.wiley.frommers.feedunmarshaller.domain.DestinationMenu;
import com.wiley.frommers.feedunmarshaller.domain.EventSearchResult;
import com.wiley.frommers.feedunmarshaller.domain.GuideStructure;
import com.wiley.frommers.feedunmarshaller.domain.ItemOfInterest;
import com.wiley.frommers.feedunmarshaller.domain.Location;
import com.wiley.frommers.feedunmarshaller.domain.LocationSearchResult;
import com.wiley.frommers.feedunmarshaller.domain.MainSearchResult;
import com.wiley.frommers.feedunmarshaller.domain.POISearchResult;
import com.wiley.frommers.feedunmarshaller.domain.SearchResponse;
import com.wiley.frommers.feedunmarshaller.domain.Slideshow;
import com.wiley.frommers.feedunmarshaller.exception.SispException;
import com.wiley.frommers.feedunmarshaller.query.AudienceInterestQuery;
import com.wiley.frommers.feedunmarshaller.query.DestinationMenuQuery;
import com.wiley.frommers.feedunmarshaller.query.EventSearchQuery;
import com.wiley.frommers.feedunmarshaller.query.GuideQuery;
import com.wiley.frommers.feedunmarshaller.query.LocationQuery;
import com.wiley.frommers.feedunmarshaller.query.PoiQuery;
import com.wiley.frommers.feedunmarshaller.query.SlideShowQuery;

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
    SearchResponse<EventSearchResult> searchEvents(EventSearchQuery query)
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
    SearchResponse<MainSearchResult> searchMains(EventSearchQuery query)
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
    SearchResponse<POISearchResult> searchPois(PoiQuery query)
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
    SearchResponse<AudienceInterestResult> searchAudienceInterests(
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
    DestinationMenu getDestinationMenuByQuery(DestinationMenuQuery query)
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
    ItemOfInterest getItemOfInterestById(Long id) throws SispException;

    /**
     * Gets the locations by query.
     * 
     * @param query
     *            the query
     * @return the locations by query
     * @throws SispException
     *             the sisp exception
     */
    SearchResponse<LocationSearchResult> searchLocations(LocationQuery query)
            throws SispException;

    /**
     * Gets the guide structure by query.
     * 
     * @param query
     *            the query
     * @return the guide structure by query
     * @throws SispException
     *             the sisp exception
     */
    GuideStructure getGuideStructureByQuery(GuideQuery query)
            throws SispException;

    /**
     * Gets the sildes show by query.
     * 
     * @param query
     *            the query
     * @return the sildes show by query
     * @throws SispException
     *             the sisp exception
     */
    Slideshow getSildesShowByQuery(SlideShowQuery query) throws SispException;

    /**
     * Gets the location by id.
     * 
     * @param id
     *            the id
     * @return the location by id
     * @throws SispException
     *             the sisp exception
     */
    Location getLocationById(Long id) throws SispException;

}
