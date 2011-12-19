package com.wiley.frommers.digester.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Query. Allows subclassing for particular search feed
 * queries.
 */
public abstract class AbstractSearchQuery implements Query {
    
    private Map<String, String> paramMap = new HashMap<String, String>();

    @Override
    public Map<String, String> getQueryParameters() {
        return paramMap;
    }

    protected void addParameter(String name, String val) {
        paramMap.put(name, val);
    }

    public void setPage(int page) {
        addParameter(QueryParams.PAGE.getName(), String.valueOf(page));
    }

    public void setNPerPage(int nPerPage) {
        addParameter(QueryParams.N_PER_PAGE.getName(), String.valueOf(nPerPage));
    }

    public void setQuery(String query) {
        addParameter(QueryParams.QUERY.getName(), query);
    }

}
