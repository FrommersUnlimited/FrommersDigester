package com.wiley.frommers.digester.query;

/**
 * Class encapsulating a query for the main_search feed.
 * 
 * @see <a href="http://support.frommers.biz/api-reference/#main_search">Main
 *      Search API</a>
 */
public class MainSearchQuery extends AbstractSearchQuery {
    
    public void setType(String type) {
        addParameter(QueryParams.TYPE.getName(), type);
    }

    public void setSubType(String subType) {
        addParameter(QueryParams.SUB_TYPE.getName(),
                String.valueOf(subType));
    }

    public void addAudienceInterestId(Long audienceInterestId) {
        addParameter(QueryParams.AUDIENCE_INTEREST_ID.getName(),
                String.valueOf(audienceInterestId));
    }

    public void addLocationId(Long locationId) {
        addParameter(QueryParams.LOCATION_ID.getName(),
                String.valueOf(locationId));
    }

    public void setMappedLocationType(String mappedLocationType) {
        addParameter(QueryParams.MAPPED_LOCATION_TYPE.getName(),
                String.valueOf(mappedLocationType));
    }

    public void setMappedLocationId(String mappedLocationId) {
        addParameter(QueryParams.MAPPED_LOCATION_ID.getName(),
                String.valueOf(mappedLocationId));
    }

}
