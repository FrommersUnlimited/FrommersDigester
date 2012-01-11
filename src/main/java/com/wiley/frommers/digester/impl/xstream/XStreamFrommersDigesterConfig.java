package com.wiley.frommers.digester.impl.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wiley.frommers.digester.FrommersDigesterConfig;

@XStreamAlias("config")
public class XStreamFrommersDigesterConfig implements FrommersDigesterConfig {
    
    private String rootUrl;
    private boolean cacheActive;
    private int cacheSize;
    private long cacheMaxAge;

    public XStreamFrommersDigesterConfig(String rootUrl) {
        super();
        this.rootUrl = rootUrl;
    }

    public XStreamFrommersDigesterConfig(String rootUrl, boolean cacheActive,
            int cacheSize, long cacheMaxAge) {
        super();
        this.rootUrl = rootUrl;
        this.cacheActive = cacheActive;
        this.cacheSize = cacheSize;
        this.cacheMaxAge = cacheMaxAge;
    }

    @Override
    public String getRootUrl() {
        return rootUrl;
    }

    @Override
    public boolean isCacheActive() {
        return cacheActive;
    }

    @Override
    public int getCacheSize() {
        return cacheSize;
    }

    @Override
    public long getCacheMaxAge() {
        return cacheMaxAge;
    }

}
