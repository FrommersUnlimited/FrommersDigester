package com.wiley.frommers.digester.query;

/**
 * Class encapsulating a query for the main_search feed.
 * 
 * @see <a href="http://support.frommers.biz/api-reference/#main_search">Main
 *      Search API</a>
 */
public class MainSearchQuery extends AbstractSearchQuery {

    public void setSubType(String subType) {
        addParameter(QueryParams.PARAM_NAME_SUB_TYPE.getName(),
                String.valueOf(subType));
    }

    public void addAudienceInterestId(Long audienceInterestId) {
        addParameter(QueryParams.PARAM_NAME_AUDIENCE_INTEREST_ID.getName(),
                String.valueOf(audienceInterestId));
    }

    public void addLocationId(Long locationId) {
        addParameter(QueryParams.PARAM_NAME_LOCATION_ID.getName(),
                String.valueOf(locationId));
    }

    public void setMappedLocationType(String mappedLocationType) {
        addParameter(QueryParams.PARAM_NAME_MAPPED_LOCATION_TYPE.getName(),
                String.valueOf(mappedLocationType));
    }

    public void setMappedLocationId(String mappedLocationId) {
        addParameter(QueryParams.PARAM_NAME_MAPPED_LOCATION_ID.getName(),
                String.valueOf(mappedLocationId));
    }

}
