package com.wiley.frommers.digester.impl.xstream;

import java.net.URL;

import com.thoughtworks.xstream.XStream;
import com.wiley.frommers.digester.FrommersDigesterConfig;
import com.wiley.frommers.digester.impl.AbstractFrommersDigester;

/**
 * XStream implementation of FrommersDigester.
 */
public class XStreamFrommersDigester extends AbstractFrommersDigester {
    
    private XStream xstream;
    
    public XStreamFrommersDigester(FrommersDigesterConfig config, XStream xstream) {
        super(config);
        this.xstream = xstream;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T> T executeFeedRequest(URL url) {
        return (T) xstream.fromXML(url);
    }

}
