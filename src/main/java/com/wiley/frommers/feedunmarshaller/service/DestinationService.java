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
import com.wiley.frommers.feedunmarshaller.domain.POISearchResult;
import com.wiley.frommers.feedunmarshaller.domain.SearchResponse;
import com.wiley.frommers.feedunmarshaller.domain.Slideshow;
import com.wiley.frommers.feedunmarshaller.exception.SispException;
import com.wiley.frommers.feedunmarshaller.query.CategoryQuery;
import com.wiley.frommers.feedunmarshaller.query.DestinationMenuQuery;
import com.wiley.frommers.feedunmarshaller.query.EventQuery;
import com.wiley.frommers.feedunmarshaller.query.GuideQuery;
import com.wiley.frommers.feedunmarshaller.query.LocationQuery;
import com.wiley.frommers.feedunmarshaller.query.PoiQuery;
import com.wiley.frommers.feedunmarshaller.query.SlideShowQuery;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public interface DestinationService {

    SearchResponse<EventSearchResult> getEventsByQuery(EventQuery query)
            throws SispException;

    SearchResponse<AudienceInterestResult> getCategoriesByQuery(
            CategoryQuery query) throws SispException;

    DestinationMenu getDestinationMenuByQuery(DestinationMenuQuery query)
            throws SispException;

    ItemOfInterest getItemOfInterestById(String id) throws SispException;

    SearchResponse<LocationSearchResult> getLocationsByQuery(LocationQuery query)
            throws SispException;

    GuideStructure getGuideStructureByQuery(GuideQuery query)
            throws SispException;

    Slideshow getSildesShowByQuery(SlideShowQuery query) throws SispException;

    SearchResponse<POISearchResult> getPoisByQuery(PoiQuery query)
            throws SispException;

    Location getLocationById(String id) throws SispException;

}
