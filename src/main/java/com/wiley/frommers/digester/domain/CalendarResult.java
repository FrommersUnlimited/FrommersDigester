/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * 
 * @author fzerdoudi, created 19 Oct 2011
 * 
 */
@XStreamAlias("calendarResult")
public class CalendarResult implements SearchResult {

    @XStreamOmitField()
    private Date date;

    @XStreamAsAttribute()
    private String day;

    @XStreamAsAttribute()
    private int count;

    public Long getId() {
        return date.getTime();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

}
