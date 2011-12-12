/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.query;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public class AudienceInterestQuery extends FeedQuery {

    public AudienceInterestQuery() {
        super();
        // TODO do it in the context bean file
        queryParams.put("audienceInterestId", "530006");
        queryParams.put("showChildren", "true");
    }

    public void setShowChildren(Boolean showChildren) {
        queryParams.put("showChildren", showChildren.toString());
    }
}
