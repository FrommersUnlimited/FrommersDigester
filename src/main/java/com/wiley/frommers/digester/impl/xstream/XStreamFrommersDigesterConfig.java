package com.wiley.frommers.digester.impl.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wiley.frommers.digester.FrommersDigesterConfig;

@XStreamAlias("config")
public class XStreamFrommersDigesterConfig implements FrommersDigesterConfig {
    
    private String rootUrl;
    private boolean cacheActive;

    public XStreamFrommersDigesterConfig(String rootUrl, boolean cacheActive) {
        this.rootUrl = rootUrl;
        this.cacheActive = cacheActive;
    }

    @Override
    public String getRootUrl() {
        return rootUrl;
    }

    @Override
    public boolean isCacheActive() {
        return cacheActive;
    }

}
