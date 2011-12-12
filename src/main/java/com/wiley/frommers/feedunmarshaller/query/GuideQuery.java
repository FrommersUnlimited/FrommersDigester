/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.query;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public class GuideQuery extends LocationSearchQuery {

    public static String INTRODUCTION_TYPE_ID = "557449";

    public GuideQuery() {
        super();
    }

    public void setGuideStructureTypeId(String type) {
        queryParams.put("guideStructureTypeId", type);

    }

    public String getGuideStructureTypeId() {
        return queryParams.get("guideStructureTypeId");
    }

    public void setGuideStructureId(String guideStructureId) {
        queryParams.put("guideStructureId", guideStructureId);
    }

    public String getGuideStructureId() {
        return queryParams.get("guideStructureId");
    }

    public String getId() {
        String id = getGuideStructureId();

        if (id == null) {
            id = getGuideStructureTypeId() + getLocationId();
        }

        return id;
    }

}
