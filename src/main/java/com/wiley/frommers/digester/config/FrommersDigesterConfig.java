package com.wiley.frommers.digester.config;

/**
 * Class encapsulating configuration options for the FrommersDigester.
 */
public class FrommersDigesterConfig {
    
    private String rootUrl;
    private boolean cacheActive;
    
    public String getRootUrl() {
        return rootUrl;
    }
    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }
    public boolean isCacheActive() {
        return cacheActive;
    }
    public void setCacheActive(boolean cacheActive) {
        this.cacheActive = cacheActive;
    }

}
