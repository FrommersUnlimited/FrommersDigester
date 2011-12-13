/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.query;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public abstract class FeedQuery {
    protected Map<String, String> queryParams;

    public FeedQuery() {
        queryParams = new HashMap<String, String>();
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public String toUrl() {
        String urlParams = null;

        for (Entry<String, String> entry : queryParams.entrySet()) {
            if (urlParams == null)
                urlParams = "?";
            else
                urlParams += "&";

            urlParams += entry.getKey() + "=" + entry.getValue();
        }

        return urlParams;
    }

    public String getId() {
        return toUrl();
    }

}
