package com.wiley.frommers.digester;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.wiley.frommers.digester.domain.EventSearchResult;
import com.wiley.frommers.digester.domain.Location;
import com.wiley.frommers.digester.domain.LocationNode;
import com.wiley.frommers.digester.domain.MainSearchResult;
import com.wiley.frommers.digester.domain.MediaSearchResult;
import com.wiley.frommers.digester.domain.SearchResponse;
import com.wiley.frommers.digester.query.EventSearchQuery;
import com.wiley.frommers.digester.query.MainSearchQuery;
import com.wiley.frommers.digester.query.MediaSearchQuery;

/**
 * Tests for the FrommersDigester
 */
public class FrommersDigesterTest extends AbstractDigesterTest {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(
    		FrommersDigesterTest.class.getName());

    /** The destination service. */
    private FrommersDigester digester;

    /** The PARI s_ id. */
    private static Long PARIS_ID = (long) 151160;

    public void setUp() throws FrommersFeedException {
        digester = FrommersDigesterFactory.getInstance(FrommersDigesterUnmarshaller.XSTREAM,
                "classpath:frommers-digester-config.xml");
    }

    public void testGetLocationById() throws FrommersFeedException {
        if (LOGGER.isLoggable(Level.FINE)) {
            LOGGER.log(Level.FINE, "testGetLocationById() - start");
        }

        Location location = digester.getLocationById(PARIS_ID);

        assertNotNull(location);
        assertNotNull(location.getId());
        assertEquals(PARIS_ID, location.getId());

        LocationNode temp = location.getParent();
        while (temp != null) {

            assertNotNull(temp);
            assertNotNull(temp.getName());

            if (LOGGER.isLoggable(Level.FINE)) {
                LOGGER.log(Level.FINE, "testGetLocationById() - location : " + temp.getName());
            }
            temp = temp.getParent();
        }

        if (LOGGER.isLoggable(Level.FINE)) {
            LOGGER.log(Level.FINE, "testGetLocationById() - end");
        }    
    }

    public void testGetMainSearchSimple() throws FrommersFeedException {
        MainSearchQuery query = new MainSearchQuery();
        SearchResponse<MainSearchResult> resp = digester.searchMain(query);
        assertNotNull(resp);
        assertTrue(resp.getCurrentPage() == 1);
        assertTrue(resp.getTotalResultCount() > 0);
    }
    
    public void testGetImagesForQueryRome() throws FrommersFeedException {
        MediaSearchQuery query = new MediaSearchQuery();
        query.setQuery("rome");
        LOGGER.log(Level.FINE, "Checking for photos matching query 'rome'");
        
        SearchResponse<MediaSearchResult> resp = digester.searchMedia(query);
        assertNotNull(resp);        
        assertTrue(resp.getCurrentPage() == 1);
        assertTrue(resp.getTotalResultCount() > 0);
        
        // Loop through checking the thumb URLs are indeed null
        for (MediaSearchResult media :resp.getResults()) {
        	assertNull(media.getThumbnailUrl());
        }
    	
    }
    
    public void testEventSearchShowMaxReturnsMoreThanFiftyResults() throws FrommersFeedException{
    	// Construct a 'global' event search
    	EventSearchQuery query = new EventSearchQuery();
    	query.setShowMax(true);
        LOGGER.log(Level.FINE, "Searching for all event with showMax=true");

    	SearchResponse<EventSearchResult> resp = digester.searchEvents(query);
        assertNotNull(resp);        
        assertTrue(resp.getCurrentPage() == 1);
        
        // Ensure we have more than the standard 50 results
        assertTrue(resp.getTotalResultCount() > 50);
        
        // For large result sets, the currentPageResultCount has a hard limit of 1000
        assertEquals(1000, resp.getCurrentPageResultCount());
    }

}
