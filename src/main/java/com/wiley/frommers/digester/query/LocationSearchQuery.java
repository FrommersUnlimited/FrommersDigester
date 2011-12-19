package com.wiley.frommers.digester.query;

/**
 * Class encapsulating a query for the location_search feed.
 * 
 * @see <a
 *      href="http://support.frommers.biz/api-reference/#location_search">API</a>
 */
public class LocationSearchQuery extends AbstractSearchQuery {
    
    public void setType(String type) {
        addParameter(QueryParams.TYPE.getName(), type);
    }

    public void setParentId(Long parentId) {
        addParameter(QueryParams.PARENT_ID.getName(), String.valueOf(parentId));
    }

    public void setLongitude(Double longitude) {
        addParameter(QueryParams.LONGITUDE.getName(), String.valueOf(longitude));
    }

    public void setLatitude(Double latitude) {
        addParameter(QueryParams.LATITUDE.getName(), String.valueOf(latitude));
    }

    public void setMiles(Double miles) {
        addParameter(QueryParams.MILES.getName(), String.valueOf(miles));
    }

    public void setHasGuide(boolean hasGuide) {
        addParameter(QueryParams.HAS_GUIDE.getName(), String.valueOf(hasGuide));
    }

}
