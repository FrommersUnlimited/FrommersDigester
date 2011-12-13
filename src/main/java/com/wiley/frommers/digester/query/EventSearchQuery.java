/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.query;

/**
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */
public class EventSearchQuery extends LocationSearchQuery {

    public EventSearchQuery() {
        super();

        setNPerPage(10);
    }

    public void setStartDate(String date) {
        queryParams.put("startDate", date);
    }

    public void setEndDate(String date) {
        queryParams.put("endDate", date);

    }

}
