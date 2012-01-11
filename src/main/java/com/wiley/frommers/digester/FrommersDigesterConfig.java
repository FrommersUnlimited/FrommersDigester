package com.wiley.frommers.digester;

/**
 * Class encapsulating configuration options for the FrommersDigester.
 */
public interface FrommersDigesterConfig {
    /**
     * The Http Url of the xml feed
     * @return the feedUrl
     */
    public String getRootUrl();
    /**
     * Is the caching active or not
     * @return isCacheActive
     */
    public boolean isCacheActive();
    /**
     * Size of the cache .
     * @return Maximum number of elements to retain in cache
     */
    public int getCacheSize();
    /**
     * Cache life time
     * @return Number of milliseconds before a given element expires
     */
    public long getCacheMaxAge();

}
