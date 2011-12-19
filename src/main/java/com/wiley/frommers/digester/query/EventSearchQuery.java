package com.wiley.frommers.digester.query;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class encapsulating a query for the event_search feed.
 * 
 * @see <a href="http://support.frommers.biz/api-reference/#event_search">API</a>
 */
public class EventSearchQuery extends ItemOfInterestSearchQuery {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("YYYYMMDD");

    public void setStartDate(Date startDate) {
        addParameter(QueryParams.START_DATE.getName(), SDF.format(startDate));
    }

    public void setEndDate(Date endDate) {
        addParameter(QueryParams.END_DATE.getName(), SDF.format(endDate));
    }

    public void setDaysAhead(int daysAhead) {
        addParameter(QueryParams.DAYS_AHEAD.getName(),
                String.valueOf(daysAhead));
    }

}
