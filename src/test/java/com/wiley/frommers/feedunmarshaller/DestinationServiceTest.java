/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.frommers.feedunmarshaller.domain.AudienceInterestResult;
import com.wiley.frommers.feedunmarshaller.domain.DestinationMenu;
import com.wiley.frommers.feedunmarshaller.domain.EventSearchResult;
import com.wiley.frommers.feedunmarshaller.domain.GuideStructure;
import com.wiley.frommers.feedunmarshaller.domain.ItemOfInterest;
import com.wiley.frommers.feedunmarshaller.domain.Location;
import com.wiley.frommers.feedunmarshaller.domain.LocationNode;
import com.wiley.frommers.feedunmarshaller.domain.LocationSearchResult;
import com.wiley.frommers.feedunmarshaller.domain.POISearchResult;
import com.wiley.frommers.feedunmarshaller.domain.SearchResponse;
import com.wiley.frommers.feedunmarshaller.domain.Slide;
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
 * The Class DestinationServiceTest.
 */
public class DestinationServiceTest extends AbstractFeedTest {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(DestinationServiceTest.class);

    /** The destination service. */
    @Autowired(required = true)
    DestinationService destinationService;

    /** The PARI s_ id. */
    private static String PARIS_ID = "151160";

    private static String IOI_ID;

    private static final String COUNTRY = "COUNTRY";

    public void testGetEventByQuery() throws SispException {
        if (logger.isDebugEnabled()) {
            logger.debug("testGetEventByQuery() - start");
        }

        EventQuery query = new EventQuery();
        // search paris event
        query.setLocationId(PARIS_ID);

        // page size
        query.setNPerPage(15);

        SearchResponse<EventSearchResult> eventResult = destinationService
                .getEventsByQuery(query);

        assertNotNull(eventResult);
        assertTrue(eventResult.getTotalPageCount() > 0);

        for (EventSearchResult event : eventResult.getResults()) {
            assertNotNull(event.getName());
            assertNotNull(event.getId());

            if (IOI_ID == null)
                IOI_ID = event.getId().toString();

        }

        if (logger.isDebugEnabled()) {
            logger.debug("testGetEventByQuery() - end");
        }
    }

    public void testGetCategoriesByQuery() throws SispException {
        if (logger.isDebugEnabled()) {
            logger.debug("testGetCategoriesByQuery() - start");
        }

        CategoryQuery query = new CategoryQuery();

        SearchResponse<AudienceInterestResult> categories = destinationService
                .getCategoriesByQuery(query);

        assertNotNull(categories);
        assertTrue(categories.getTotalPageCount() > 0);

        if (logger.isDebugEnabled()) {
            logger.debug("testGetCategoriesByQuery() - end");
        }
    }

    public void testGetDestinationMenuByQuery() throws SispException {
        if (logger.isDebugEnabled()) {
            logger.debug("testGetDestinationMenuByQuery() - start");
        }

        DestinationMenuQuery query = new DestinationMenuQuery();

        // destination menu of Paris
        query.setLocationId(PARIS_ID);

        DestinationMenu destinationMenu = destinationService
                .getDestinationMenuByQuery(query);

        assertNotNull(destinationMenu);
        assertEquals(PARIS_ID, destinationMenu.getLocationId().toString());

        if (logger.isDebugEnabled()) {
            logger.debug("testGetDestinationMenuByQuery() - end");
        }
    }

    public void testGetItemOfInterestById() throws SispException {
        if (logger.isDebugEnabled()) {
            logger.debug("testGetItemOfInterestById() - start");
        }

        ItemOfInterest ioi = destinationService.getItemOfInterestById(IOI_ID);

        assertNotNull(ioi.getName());
        assertNotNull(ioi.getId());
        assertNotNull(ioi.getTypeCode());

        if (logger.isDebugEnabled()) {
            logger.debug("testGetItemOfInterestById() - end");
        }
    }

    public void testGetLocationsByQuery() throws SispException {
        if (logger.isDebugEnabled()) {
            logger.debug("testGetLocationsByQuery() - start");
        }

        LocationQuery query = new LocationQuery();

        query.setLocationType(COUNTRY);

        SearchResponse<LocationSearchResult> locations = destinationService
                .getLocationsByQuery(query);
        assertNotNull(locations);

        for (LocationSearchResult loc : locations.getResults()) {
            assertNotNull(loc.getName());
            assertNotNull(loc.getId());

            assertEquals(COUNTRY, loc.getType());

        }

        if (logger.isDebugEnabled()) {
            logger.debug("testGetLocationsByQuery() - end");
        }
    }

    public void testGetGuideStructureByQuery() throws SispException {
        if (logger.isDebugEnabled()) {
            logger.debug("testGetGuideStructureByQuery() - start");
        }

        GuideQuery query = new GuideQuery();
        query.setGuideStructureTypeId(GuideQuery.INTRODUCTION_TYPE_ID);
        query.setLocationId(PARIS_ID);

        GuideStructure guideStructure = destinationService
                .getGuideStructureByQuery(query);

        assertNotNull(guideStructure);
        assertNotNull(guideStructure.getGuideStructureType());
        assertEquals(GuideQuery.INTRODUCTION_TYPE_ID, guideStructure
                .getGuideStructureType().getId().toString());

        if (logger.isDebugEnabled()) {
            logger.debug("testGetGuideStructureByQuery() - end");
        }
    }

    public void testGetSildesShowByQuery() throws SispException {
        if (logger.isDebugEnabled()) {
            logger.debug("testGetSildesShowByQuery() - start");
        }

        SlideShowQuery query = new SlideShowQuery();
        query.setLocationId(PARIS_ID);

        Slideshow slideshow = destinationService.getSildesShowByQuery(query);

        assertNotNull(slideshow);
        assertNotNull(slideshow.getName());
        assertNotNull(slideshow.getSlides());
        assertNotNull(slideshow.getLocationNodes());

        for (Slide slide : slideshow.getSlides()) {
            assertNotNull(slide.getName());
            assertNotNull(slide.getMedia());

        }

        if (logger.isDebugEnabled()) {
            logger.debug("testGetSildesShowByQuery() - end");
        }
    }

    public void testGetPoisByQuery() throws SispException {
        if (logger.isDebugEnabled()) {
            logger.debug("testGetPoisByQuery() - start");
        }

        PoiQuery query = new PoiQuery();
        query.setLocationId(PARIS_ID);
        query.setType("HOTEL");

        SearchResponse<POISearchResult> searchResponse = destinationService
                .getPoisByQuery(query);

        assertNotNull(searchResponse);
        assertNotNull(searchResponse.getResults());

        for (POISearchResult poi : searchResponse.getResults()) {
            assertNotNull(poi.getName());
            assertNotNull(poi.getType());

            assertEquals("HOTEL", poi.getType());

        }

        if (logger.isDebugEnabled()) {
            logger.debug("testGetPoisByQuery() - end");
        }
    }

    public void testGetLocationById() throws SispException {
        if (logger.isDebugEnabled()) {
            logger.debug("testGetLocationById() - start");
        }

        Location location = destinationService.getLocationById(PARIS_ID);

        assertNotNull(location);
        assertNotNull(location.getId());

        assertEquals(PARIS_ID, location.getId().toString());

        LocationNode temp = location.getParent();
        while (temp != null) {

            assertNotNull(temp);
            assertNotNull(temp.getName());

            if (logger.isDebugEnabled()) {
                logger.debug("testGetLocationById() - location : "
                        + temp.getName());
            }

            temp = temp.getParent();
        }

        if (logger.isDebugEnabled()) {
            logger.debug("testGetLocationById() - end");
        }
    }

}
