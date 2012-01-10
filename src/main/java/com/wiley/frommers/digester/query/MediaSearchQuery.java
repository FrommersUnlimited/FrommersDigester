package com.wiley.frommers.digester.query;

/**
 * Class encapsulating a query for the media_search feed.
 * 
 * @see <a
 *      href="http://support.frommers.biz/api-reference/#media_search">API</a>
 */
public class MediaSearchQuery extends AbstractSearchQuery {

    public void setType(String type) {
        addParameter(QueryParams.TYPE.getName(), type);
    }

    public void setIsGuide(Boolean isGuide) {
        addParameter(QueryParams.IS_GUIDE.getName(), String.valueOf(isGuide));
    }

    public void addAudienceInterestId(Long audienceInterestId) {
        addParameter(QueryParams.AUDIENCE_INTEREST_ID.getName(),
                String.valueOf(audienceInterestId));
    }

    public void addLocationId(Long locationId) {
        addParameter(QueryParams.LOCATION_ID.getName(),
                String.valueOf(locationId));
    }

    public void addGuideStructureId(Long guideStructureId) {
        addParameter(QueryParams.GUIDE_STRUCTURE_ID.getName(),
                String.valueOf(guideStructureId));
    }

    public void addGuideId(Long guideId) {
        addParameter(QueryParams.GUIDE_ID.getName(), String.valueOf(guideId));
    }

}
