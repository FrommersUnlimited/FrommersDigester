/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.wiley.frommers.feedunmarshaller.service.DestinationService;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
@Service
public class FeedProxy implements DestinationService {

    @Autowired(required = true)
    private DestinationService destinationService;

    protected final Log logger = LogFactory.getLog(getClass());

    private static final MapCache MAP_CACHE = new MapCache();

    public SearchResponse<EventSearchResult> getEventsByQuery(EventQuery query)
            throws SispException {

        return destinationService.getEventsByQuery(query);
    }

    public SearchResponse<AudienceInterestResult> getCategoriesByQuery(
            CategoryQuery query) throws SispException {

        return destinationService.getCategoriesByQuery(query);
    }

    public DestinationMenu getDestinationMenuByQuery(DestinationMenuQuery query)
            throws SispException {
        DestinationMenu result = MAP_CACHE.getDestinationMenu(query.getId());

        if (result == null) {
            result = destinationService.getDestinationMenuByQuery(query);
            if (result != null)
                MAP_CACHE.addDestinationMenu(result);
            logger.info("getDestinationMenuByQuery from http");
        } else
            logger.info("getDestinationMenuByQuery from sisp cache");

        return result;
    }

    public ItemOfInterest getItemOfInterestById(String id) throws SispException {

        ItemOfInterest result = MAP_CACHE.getItemOfInterest(id);

        if (result == null) {
            result = destinationService.getItemOfInterestById(id);
            if (result != null)
                MAP_CACHE.addItemOfInterest(result);
            logger.info("getItemOfInterestById from network");
        } else
            logger.info("getItemOfInterestById from cache");

        return result;

    }

    public void setDestinationService(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    public SearchResponse<LocationSearchResult> getLocationsByQuery(
            LocationQuery query) throws SispException {

        return destinationService.getLocationsByQuery(query);
    }

    public GuideStructure getGuideStructureByQuery(GuideQuery query)
            throws SispException {

        GuideStructure result = MAP_CACHE.getGuideStructure(query.getId());

        if (result == null) {
            result = destinationService.getGuideStructureByQuery(query);
            if (result != null)
                MAP_CACHE.addGuideStructure(result);
            logger.info("getGuideStructureByQuery from http");
        } else
            logger.info("getGuideStructureByQuery from sisp cache");

        return result;

    }

    public Slideshow getSildesShowByQuery(SlideShowQuery query)
            throws SispException {
        Slideshow result = MAP_CACHE.getSlideshow(query.getId());

        if (result == null) {
            result = destinationService.getSildesShowByQuery(query);
            if (result != null)
                MAP_CACHE.addSlideshow(query.getId(), result);
            logger.info("getSildesShowByQuery from http");
        } else
            logger.info("getSildesShowByQuery from sisp cache");

        return result;
    }

    public Location getLocationById(String id) throws SispException {
        Location result = MAP_CACHE.getLocation(id);

        if (result == null) {
            result = destinationService.getLocationById(id);
            if (result != null)
                MAP_CACHE.addLocation(result);
            logger.info("getSildesShowByQuery from http");
        } else
            logger.info("getSildesShowByQuery from sisp cache");

        return result;
    }

    public SearchResponse<POISearchResult> getPoisByQuery(PoiQuery query)
            throws SispException {

        return destinationService.getPoisByQuery(query);
    }

}
