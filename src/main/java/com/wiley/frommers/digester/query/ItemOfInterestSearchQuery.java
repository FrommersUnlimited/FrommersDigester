package com.wiley.frommers.digester.query;

/**
 * Common search methods shared by {@link EventSearchQuery} and {@link POISearchQuery}
 */
public abstract class ItemOfInterestSearchQuery extends MainSearchQuery {

    public void setLongitude(Double longitude) {
        addParameter(QueryParams.LONGITUDE.getName(), String.valueOf(longitude));
    }

    public void setLatitude(Double latitude) {
        addParameter(QueryParams.LATITUDE.getName(), String.valueOf(latitude));
    }

    public void setMiles(Double miles) {
        addParameter(QueryParams.MILES.getName(), String.valueOf(miles));
    }

    public void setRankId(int rankId) {
        addParameter(QueryParams.RANK_ID.getName(), String.valueOf(rankId));
    }

    public void setMinRankId(int minRankId) {
        addParameter(QueryParams.MIN_RANK_ID.getName(),
                String.valueOf(minRankId));
    }

    public void setMaxRankId(int maxRankId) {
        addParameter(QueryParams.MAX_RANK_ID.getName(),
                String.valueOf(maxRankId));
    }

}
