package com.wiley.frommers.digester.cache;

public interface FeedCache {

    <T> void put(String key, T o);

    <T> T get(String key);

    void clear();

    boolean contains(String key);
}
