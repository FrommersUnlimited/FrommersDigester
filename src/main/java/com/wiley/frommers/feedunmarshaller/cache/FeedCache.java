package com.wiley.frommers.feedunmarshaller.cache;

public interface FeedCache {

    <T> void put(String key, T o);

    <T> T get(String id);

    void clear();

    boolean contains(String id);
}
