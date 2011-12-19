package com.wiley.frommers.digester.query;

/**
 * Query parameters used to call the feeds.
 */
public enum QueryParams {

    PARAM_NAME_PAGE("page"),
    PARAM_NAME_N_PER_PAGE("nPerPage"),
    PARAM_NAME_QUERY("query"),
    PARAM_NAME_TYPE("type"),
    PARAM_NAME_SUB_TYPE("type"),
    PARAM_NAME_AUDIENCE_INTEREST_ID("audienceInterestId"),
    PARAM_NAME_LOCATION_ID("locationId"),
    PARAM_NAME_LOC_QUERY("locQuery"),
    PARAM_NAME_MAPPED_LOCATION_TYPE("mappedLocationType"),
    PARAM_NAME_MAPPED_LOCATION_ID("mappedLocationId"),
    PARAM_NAME_SHOW_COUNT("showCount"),
    PARAM_NAME_SHOW_CHILDREN("showChildren"),
    PARAM_NAME_DEPTH("depth"),
    PARAM_NAME_START_DATE("startDate"),
    PARAM_NAME_END_DATE("endDate");
    
    
    private String name;
    
    private QueryParams(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
