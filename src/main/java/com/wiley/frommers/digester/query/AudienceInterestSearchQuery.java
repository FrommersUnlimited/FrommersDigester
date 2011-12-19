package com.wiley.frommers.digester.query;

/**
 * Class encapsulating a query for the audience_interest_search feed.
 * 
 * @see <a
 *      href="http://support.frommers.biz/api-reference/#audience_interest_search">API</a>
 */
public class AudienceInterestSearchQuery extends AbstractSearchQuery {

    public void setShowCount(boolean showCount) {
        addParameter(QueryParams.SHOW_COUNT.getName(),
                String.valueOf(showCount));
    }

    public void setShowChildren(boolean showChildren) {
        addParameter(QueryParams.SHOW_CHILDREN.getName(),
                String.valueOf(showChildren));
    }

    public void setDepth(int depth) {
        addParameter(QueryParams.SHOW_DEPTH.getName(), String.valueOf(depth));
    }

    public void setType(String type) {
        addParameter(QueryParams.TYPE.getName(), type);
    }
    
    public void setSubType(String subType) {
        addParameter(QueryParams.SUB_TYPE.getName(), subType);
    }

    public void setLocQuery(String locQuery) {
        addParameter(QueryParams.LOC_QUERY.getName(), locQuery);
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
