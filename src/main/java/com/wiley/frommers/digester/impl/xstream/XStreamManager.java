package com.wiley.frommers.digester.impl.xstream;

import com.thoughtworks.xstream.XStream;
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

/**
 * Simple XStream Manager to manages the XStream instance to share around.
 */
public class XStreamManager {

    protected static final Class<?>[] ANNOTATED_CLASSES = new Class[] {
        SearchResponse.class, MainSearchResult.class,
        EventSearchResult.class, ItemOfInterest.class,
        DestinationMenu.class, AudienceInterestResult.class,
        LocationSearchResult.class, GuideStructure.class, Slideshow.class,
        SlideshowSearchResult.class, POISearchResult.class, Location.class,
        XStreamFrommersDigesterConfig.class};
    
    private static XStream xstream;
    
    public static final XStream getInstance() {
        if (xstream == null) {
            xstream = new XStream();
            xstream.processAnnotations(ANNOTATED_CLASSES);
        }
        
        return xstream;
    }
}
