/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.query;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public class DestinationMenuQuery extends LocalizedQuery {

    public DestinationMenuQuery() {
        super();

    }

    public void setGuideStructureId(String guideStructureId) {
        queryParams.put("guideStructureId", guideStructureId);
    }

    public void setAutoHide(Boolean autoHide) {
        queryParams.put("autoHide", autoHide.toString());
    }

    @Override
    public String getId() {

        return "DestinationMenu" + getLocationId();
    }

}
