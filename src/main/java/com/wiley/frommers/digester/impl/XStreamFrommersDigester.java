package com.wiley.frommers.digester.impl;

import java.net.URL;

import com.thoughtworks.xstream.XStream;
import com.wiley.frommers.digester.config.FrommersDigesterConfig;
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
 * XStream implementation of FrommersDigester.
 */
public class XStreamFrommersDigester extends AbstractFrommersDigester {
    
    protected static final Class<?>[] ANNOTATED_CLASSES = new Class[] {
        SearchResponse.class, MainSearchResult.class,
        EventSearchResult.class, ItemOfInterest.class,
        DestinationMenu.class, AudienceInterestResult.class,
        LocationSearchResult.class, GuideStructure.class, Slideshow.class,
        SlideshowSearchResult.class, POISearchResult.class, Location.class };
    
    private final XStream xstream;

    public XStreamFrommersDigester(FrommersDigesterConfig config) {
        super(config);
        this.xstream = new XStream();
        this.xstream.processAnnotations(ANNOTATED_CLASSES);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T> T executeFeedRequest(URL url) {
        return (T) xstream.fromXML(url);
    }

}
