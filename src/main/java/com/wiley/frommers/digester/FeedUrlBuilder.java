package com.wiley.frommers.digester;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple URL builder class
 */
public class FeedUrlBuilder {

    private final String urlRoot;
    private final String feedCode;
    private final Map<String, String> paramMap = new HashMap<String, String>();
    
    public FeedUrlBuilder(String urlRoot, String feedCode) {
        this.urlRoot = urlRoot;
        this.feedCode = feedCode;
    }
    
    public void addParameter(String name, String val) {
        paramMap.put(name, val);
    }
    
    public void addParameter(String name, Object val) {
        addParameter(name, String.valueOf(val));
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(urlRoot);
        sb.append("/").append(feedCode).append(".feed");
        
        if (paramMap.size() > 0) {
            sb.append("?");
            for (String name : paramMap.keySet()) {
                sb.append(name).append("=").append(paramMap.get(name)).append("&");
            }
            sb.deleteCharAt(sb.length() - 1); // Remove last &
        }
        
        return sb.toString();
    }
    
}
