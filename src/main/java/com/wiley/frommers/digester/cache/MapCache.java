package com.wiley.frommers.digester.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * First implementation of the cahce usin hash map
 * 
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */

public class MapCache implements FeedCache {

    static Map<String, Object> CACHE = new HashMap<String, Object>();

    public <T> void put(String key, T value) {
        CACHE.put(key, value);

    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) CACHE.get(key);
    }

    public void clear() {
        CACHE.clear();
    }

    public boolean contains(String key) {
        return CACHE.containsKey(key);
    }

}