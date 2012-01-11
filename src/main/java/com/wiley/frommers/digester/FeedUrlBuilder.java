package com.wiley.frommers.digester;

import java.util.HashMap;
import java.util.Map;

import com.wiley.frommers.digester.query.Query;

/**
 * Simple URL builder class that collects parameters and creates a URL to send
 * to the feed server.
 */
public class FeedUrlBuilder {

    // --------------------------------------------------------
    // static singleton instance methods
    // --------------------------------------------------------

    public static final String createUrl(String urlRoot, String feedCode,
            String idName, Long idVal) {
        FeedUrlBuilder url = new FeedUrlBuilder(urlRoot, feedCode);
        url.paramMap.put(idName, String.valueOf(idVal));
        return url.toString();
    }
    
    public static final String generateKey(String feedCode,
            String idName, Long idVal) {
        StringBuilder sb = new StringBuilder(feedCode);
        sb.append(":").append(idName).append(":").append(idVal);
        
        return sb.toString();
    }

    public static final String createUrl(String urlRoot, String feedCode,
            Query query) {
        return new FeedUrlBuilder(urlRoot, feedCode, query).toString();
    }

    private final String urlRoot;
    private final String feedCode;
    private final Map<String, String> paramMap = new HashMap<String, String>();

    public FeedUrlBuilder(String urlRoot, String feedCode) {
        this.urlRoot = urlRoot;
        this.feedCode = feedCode;
    }

    private FeedUrlBuilder(String urlRoot, String feedCode, Query query) {
        this.urlRoot = urlRoot;
        this.feedCode = feedCode;
        this.paramMap.putAll(query.getQueryParameters());
    }
    
    public void addParameter(String name, String val) {
        this.paramMap.put(name,  val);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(urlRoot);
        sb.append("/").append(feedCode).append(".feed");

        if (paramMap.size() > 0) {
            sb.append("?");
            for (String name : paramMap.keySet()) {
                sb.append(name).append("=").append(paramMap.get(name))
                        .append("&");
            }
            sb.deleteCharAt(sb.length() - 1); // Remove last &
        }

        return sb.toString();
    }

}
