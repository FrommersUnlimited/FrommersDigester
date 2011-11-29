package com.wiley.frommers.feedunmarchaller;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.frommers.feedunmarshaller.domain.EventSearchResult;
import com.wiley.frommers.feedunmarshaller.domain.SearchResponse;
import com.wiley.frommers.feedunmarshaller.exception.SispException;
import com.wiley.frommers.feedunmarshaller.query.EventQuery;
import com.wiley.frommers.feedunmarshaller.service.DestinationService;

public class DestinationServiceTest extends AbstractFeedTest {

    @Autowired(required = true)
    DestinationService destinationService;

    public void testGetEventByQuery() throws SispException {

        EventQuery query = new EventQuery();

        SearchResponse<EventSearchResult> events = destinationService
                .getEventsByQuery(query);

        assertNotNull(events);

    }

}
