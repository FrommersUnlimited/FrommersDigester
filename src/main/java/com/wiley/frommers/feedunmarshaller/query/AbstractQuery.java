/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.query;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public abstract class AbstractQuery {
    protected Map<String, String> queryParams;

    public AbstractQuery() {
        queryParams = new HashMap<String, String>();
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public void setNPerPage(int i) {
        queryParams.put("nPerPage", String.valueOf(i));
    }

    public void showMax(boolean showMax) {
        queryParams.put("showMax", String.valueOf(showMax));
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
