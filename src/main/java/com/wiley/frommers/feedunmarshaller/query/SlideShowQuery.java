/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.query;

/**
 * @author fzerdoudi, created 13 Nov 2011
 * 
 */
public class SlideShowQuery extends LocalizedQuery {

    public SlideShowQuery() {
        super();
    }

    public void setSlideShowId(String slideShowId) {
        queryParams.put("slideShowId", slideShowId);
    }

    public String getSlideShowId() {
        return queryParams.get("slideShowId");
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return getLocationId();
    }

}
