package com.wiley.frommers.digester.query;

import java.util.Map;

import com.wiley.frommers.digester.FeedUrlBuilder;

/**
 * Simple interface that provides a query parameters to FeedUrlBuilder
 * 
 * @see FeedUrlBuilder
 */
public interface Query {

    public Map<String, String> getQueryParameters();
}
