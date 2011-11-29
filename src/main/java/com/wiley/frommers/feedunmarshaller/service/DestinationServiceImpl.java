/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.xstream.XStreamMarshaller;
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
import com.wiley.frommers.feedunmarshaller.domain.SlideshowSearchResult;
import com.wiley.frommers.feedunmarshaller.exception.SispException;
import com.wiley.frommers.feedunmarshaller.exception.SispHttpException;
import com.wiley.frommers.feedunmarshaller.query.AbstractQuery;
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
@Service
@SuppressWarnings("unchecked")
public class DestinationServiceImpl implements DestinationService {

    private static final String EVENT_SEARCH_FEED = "event_search.feed";
    private static final String DESTINATION_MENU_FEED = "destination_menu.feed";
    private static final String AUDIENCE_INTEREST_SEARCH_FEED = "audience_interest_search.feed";
    private static final String ITEM_OF_INTEREST_FEED = "item_of_interest.feed";
    private static final String LOCATION_SEARCH_FEED = "location_search.feed";
    private static final String GUIDE_STRUCTURE_FEED = "guide_structure.feed";
    private static final String SLIDE_SHOW_FEED = "slideshow.feed";
    private static final String SLIDE_SHOW_SEARCH_FEED = "slideshow_search.feed";
    private static final String POI_SEARCH_FEED = "poi_search.feed";
    private static final String LOCATION_FEED = "location.feed";

    private String odfUrl;

    public void setOdfUrl(String odfUrl) {
        this.odfUrl = odfUrl;
    }

    public void setMarshaller(XStreamMarshaller marshaller) {
        this.marshaller = marshaller;
    }

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired(required = true)
    private XStreamMarshaller marshaller;

    private InputStream getHttpInputStream(String url) throws SispHttpException {

        try {
            URL _url = new URL(url);

            InputStream stream = _url.openConnection().getInputStream();

            return stream;
        } catch (IOException e) {
            logger.error(e);
            throw new SispHttpException(e);
        }

    }

    private <T> T executeQuery(String feed, AbstractQuery query)
            throws SispHttpException {

        final String feedUrl = buildFullFeedUrl(query, odfUrl + feed);

        final InputStream stream = getHttpInputStream(feedUrl);

        final T eventResponse = (T) marshaller.getXStream().fromXML(stream);

        return eventResponse;
    }

    private static String buildFullFeedUrl(AbstractQuery query, String feed) {
        String paramUrl = query.toUrl();
        String fullUrl;
        if (paramUrl != null)
            fullUrl = feed + paramUrl;
        else
            fullUrl = feed;

        return fullUrl;

    }

    public SearchResponse<EventSearchResult> getEventsByQuery(EventQuery query)
            throws SispException {

        final SearchResponse<EventSearchResult> eventResponse = executeQuery(
                EVENT_SEARCH_FEED, query);

        return eventResponse;
    }

    public SearchResponse<AudienceInterestResult> getCategoriesByQuery(
            CategoryQuery query) throws SispException {

        final SearchResponse<AudienceInterestResult> eventResponse = executeQuery(
                AUDIENCE_INTEREST_SEARCH_FEED, query);

        return eventResponse;

    }

    public DestinationMenu getDestinationMenuByQuery(DestinationMenuQuery query)
            throws SispException {

        final DestinationMenu destinationMenu = executeQuery(
                DESTINATION_MENU_FEED, query);

        return destinationMenu;
    }

    public ItemOfInterest getItemOfInterestById(String id) throws SispException {

        final String feedUrl = odfUrl + ITEM_OF_INTEREST_FEED
                + "?itemOfInterestId=" + id;

        final InputStream stream = getHttpInputStream(feedUrl);

        ItemOfInterest itemOfInterest = (ItemOfInterest) marshaller
                .getXStream().fromXML(stream);
        return itemOfInterest;
    }

    public SearchResponse<LocationSearchResult> getLocationsByQuery(
            LocationQuery query) throws SispException {

        final SearchResponse<LocationSearchResult> eventResponse = executeQuery(
                LOCATION_SEARCH_FEED, query);

        return eventResponse;

    }

    public GuideStructure getGuideStructureByQuery(GuideQuery query)
            throws SispException {

        final GuideStructure guide = executeQuery(GUIDE_STRUCTURE_FEED, query);

        return guide;
    }

    public Slideshow getSildesShowByQuery(SlideShowQuery query)
            throws SispException {

        SearchResponse<SlideshowSearchResult> slidesResult = executeQuery(
                SLIDE_SHOW_SEARCH_FEED, query);

        logger.debug("getSildesShowByQuery() SlideshowSearchResult found = "
                + "(" + slidesResult.getTotalResultCount() + ")");

        if (slidesResult == null || slidesResult.getTotalResultCount() == 0)
            return null;

        String feedUrl = odfUrl + SLIDE_SHOW_FEED + "?slideshowId="
                + slidesResult.getResults().get(0).getId();

        InputStream stream = getHttpInputStream(feedUrl);

        Slideshow slideshow = (Slideshow) marshaller.getXStream().fromXML(
                stream);

        logger.debug("getSildesShowByQuery() slideshow found = " + "("
                + slideshow.getSlideCount() + ")");

        return slideshow;
    }

    public SearchResponse<POISearchResult> getPoisByQuery(PoiQuery query)
            throws SispException {

        final SearchResponse<POISearchResult> eventResponse = executeQuery(
                POI_SEARCH_FEED, query);

        return eventResponse;
    }

    public Location getLocationById(String id) throws SispException {
        final String feedUrl = odfUrl + LOCATION_FEED + "?locationId=" + id;

        final InputStream stream = getHttpInputStream(feedUrl);

        Location location = (Location) marshaller.getXStream().fromXML(stream);
        return location;
    }

}
