/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester;

import org.apache.log4j.Logger;

import com.wiley.frommers.digester.domain.Location;
import com.wiley.frommers.digester.domain.LocationNode;
import com.wiley.frommers.digester.domain.MainSearchResult;
import com.wiley.frommers.digester.domain.SearchResponse;
import com.wiley.frommers.digester.query.MainSearchQuery;

/**
 * Tests for digester
 */
public class FeedServiceTest extends AbstractFeedTest {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger
            .getLogger(FeedServiceTest.class);

    /** The destination service. */
    private FrommersDigester digester;

    /** The PARI s_ id. */
    private static Long PARIS_ID = (long) 151160;

    public void setUp() throws FrommersFeedException {
        digester = FrommersDigesterFactory.getInstance(FrommersDigesterUnmarshaller.XSTREAM,
                "classpath:frommers-digester-config.xml");
    }

    public void testGetLocationById() throws FrommersFeedException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("testGetLocationById() - start");
        }

        Location location = digester.getLocationById(PARIS_ID);

        assertNotNull(location);
        assertNotNull(location.getId());
        assertEquals(PARIS_ID, location.getId());

        LocationNode temp = location.getParent();
        while (temp != null) {

            assertNotNull(temp);
            assertNotNull(temp.getName());

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("testGetLocationById() - location : "
                        + temp.getName());
            }

            temp = temp.getParent();
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("testGetLocationById() - end");

        }
    }

    public void testGetMainSearchSimple() throws FrommersFeedException {
        MainSearchQuery query = new MainSearchQuery();
        SearchResponse<MainSearchResult> resp = digester.searchMain(query);
        assertNotNull(resp);
        assertTrue(resp.getCurrentPage() == 1);
        assertTrue(resp.getTotalResultCount() > 0);
    }

    /*
     * public void testGetEventByQuery() throws SispException { if
     * (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetEventByQuery() - start"); }
     * 
     * EventSearchQuery query = new EventSearchQuery(); // search paris event
     * query.setLocationId(PARIS_ID.toString());
     * 
     * // page size query.setNPerPage(15);
     * 
     * SearchResponse<EventSearchResult> eventResult = digester
     * .searchEvents(query);
     * 
     * assertNotNull(eventResult); assertTrue(eventResult.getTotalPageCount() >
     * 0);
     * 
     * for (EventSearchResult event : eventResult.getResults()) {
     * assertNotNull(event.getName()); assertNotNull(event.getId());
     * 
     * if (IOI_ID == null) IOI_ID = event.getId();
     * 
     * }
     * 
     * if (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetEventByQuery() - end"); } }
     * 
     * public void testGetCategoriesByQuery() throws SispException { if
     * (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetCategoriesByQuery() - start"); }
     * 
     * AudienceInterestQuery query = new AudienceInterestQuery();
     * 
     * SearchResponse<AudienceInterestResult> categories = digester
     * .searchAudienceInterests(query);
     * 
     * assertNotNull(categories); assertTrue(categories.getTotalPageCount() >
     * 0);
     * 
     * if (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetCategoriesByQuery() - end"); } }
     * 
     * public void testGetDestinationMenuByQuery() throws SispException { if
     * (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetDestinationMenuByQuery() - start"); }
     * 
     * DestinationMenuQuery query = new DestinationMenuQuery();
     * 
     * // destination menu of Paris query.setLocationId(PARIS_ID.toString());
     * 
     * DestinationMenu destinationMenu = digester
     * .getDestinationMenuByQuery(query);
     * 
     * assertNotNull(destinationMenu); assertEquals(PARIS_ID,
     * destinationMenu.getLocationId());
     * 
     * if (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetDestinationMenuByQuery() - end"); } }
     * 
     * public void testGetItemOfInterestById() throws SispException { if
     * (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetItemOfInterestById() - start"); }
     * 
     * ItemOfInterest ioi = digester.getItemOfInterestById(IOI_ID);
     * 
     * assertNotNull(ioi.getName()); assertNotNull(ioi.getId());
     * assertNotNull(ioi.getTypeCode());
     * 
     * if (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetItemOfInterestById() - end"); } }
     * 
     * public void testGetLocationsByQuery() throws SispException { if
     * (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetLocationsByQuery() - start"); }
     * 
     * LocationSearchQuery query = new LocationSearchQuery();
     * 
     * query.setLocationType(COUNTRY);
     * 
     * SearchResponse<LocationSearchResult> locations = digester
     * .searchLocations(query); assertNotNull(locations);
     * 
     * for (LocationSearchResult loc : locations.getResults()) {
     * assertNotNull(loc.getName()); assertNotNull(loc.getId());
     * 
     * assertEquals(COUNTRY, loc.getType());
     * 
     * }
     * 
     * if (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetLocationsByQuery() - end"); } }
     * 
     * public void testGetGuideStructureByQuery() throws SispException { if
     * (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetGuideStructureByQuery() - start"); }
     * 
     * GuideQuery query = new GuideQuery();
     * query.setGuideStructureTypeId(GuideQuery.INTRODUCTION_TYPE_ID);
     * query.setLocationId(PARIS_ID.toString());
     * 
     * GuideStructure guideStructure = digester
     * .getGuideStructureByQuery(query);
     * 
     * assertNotNull(guideStructure);
     * assertNotNull(guideStructure.getGuideStructureType());
     * assertEquals(GuideQuery.INTRODUCTION_TYPE_ID, guideStructure
     * .getGuideStructureType().getId().toString());
     * 
     * if (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetGuideStructureByQuery() - end"); } }
     * 
     * public void testGetSildesShowByQuery() throws SispException { if
     * (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetSildesShowByQuery() - start"); }
     * 
     * SlideShowSearchQuery query = new SlideShowSearchQuery();
     * query.setLocationId(PARIS_ID.toString());
     * 
     * SearchResponse<SlideshowSearchResult> slideshowsResult = digester
     * .searchSildeshows(query);
     * 
     * assertNotNull(slideshowsResult);
     * assertNotNull(slideshowsResult.getResults());
     * 
     * assertNotNull(slideshowsResult.getTotalResultCount());
     * assertTrue(slideshowsResult.getTotalResultCount() > 0);
     * 
     * for (SlideshowSearchResult slide : slideshowsResult.getResults()) {
     * assertNotNull(slide.getName());
     * 
     * Slideshow slidShow = digester.getSildeshowById(slide.getId());
     * assertNotNull(slidShow); }
     * 
     * if (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetSildesShowByQuery() - end"); } }
     * 
     * public void testGetPoisByQuery() throws SispException { if
     * (LOGGER.isDebugEnabled()) { LOGGER.debug("testGetPoisByQuery() - start");
     * }
     * 
     * PoiSearchQuery query = new PoiSearchQuery();
     * query.setLocationId(PARIS_ID.toString()); query.setType("HOTEL");
     * 
     * SearchResponse<POISearchResult> searchResponse = digester
     * .searchPois(query);
     * 
     * assertNotNull(searchResponse);
     * assertNotNull(searchResponse.getResults());
     * 
     * for (POISearchResult poi : searchResponse.getResults()) {
     * assertNotNull(poi.getName()); assertNotNull(poi.getType());
     * assertEquals("HOTEL", poi.getType());
     * 
     * }
     * 
     * <<<<<<< HEAD if (LOGGER.isDebugEnabled()) {
     * LOGGER.debug("testGetPoisByQuery() - end"); ======= if
     * (logger.isDebugEnabled()) { logger.debug("testGetPoisByQuery() - end");
     * >>>>>>> 4a717f0ec2a3db4e675ee3f7ea6312d05d773aaf } }
     */
}
