/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wiley.frommers.digester.domain.util.FeedDateConverter;

/**
 * A range with a start and end date that defines occurance of something
 * temporal like an Event. Flags can also be set if an the range is applicable
 * for a given date or yet to be confirmed.
 * 
 * @see ItemOfInterest
 * @author rwatts, created 18 Nov 2009
 */
@XStreamAlias("dateRange")
public class DateRange {

    @XStreamAsAttribute
    @XStreamConverter(FeedDateConverter.class)
    private Date startDate;
    @XStreamAsAttribute
    @XStreamConverter(FeedDateConverter.class)
    private Date endDate;
    @XStreamAsAttribute
    private boolean isTbc;
    @XStreamAsAttribute
    private boolean isOneOff;
    @XStreamAsAttribute
    private boolean isOccurMonday;
    @XStreamAsAttribute
    private boolean isOccurTuesday;
    @XStreamAsAttribute
    private boolean isOccurWednesday;
    @XStreamAsAttribute
    private boolean isOccurThursday;
    @XStreamAsAttribute
    private boolean isOccurFriday;
    @XStreamAsAttribute
    private boolean isOccurSaturday;
    @XStreamAsAttribute
    private boolean isOccurSunday;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isTbc() {
        return isTbc;
    }

    public void setTbc(boolean isTbc) {
        this.isTbc = isTbc;
    }

    public boolean isOneOff() {
        return isOneOff;
    }

    public void setOneOff(boolean isOneOff) {
        this.isOneOff = isOneOff;
    }

    public boolean isOccurMonday() {
        return isOccurMonday;
    }

    public void setOccurMonday(boolean isOccurMonday) {
        this.isOccurMonday = isOccurMonday;
    }

    public boolean isOccurTuesday() {
        return isOccurTuesday;
    }

    public void setOccurTuesday(boolean isOccurTuesday) {
        this.isOccurTuesday = isOccurTuesday;
    }

    public boolean isOccurWednesday() {
        return isOccurWednesday;
    }

    public void setOccurWednesday(boolean isOccurWednesday) {
        this.isOccurWednesday = isOccurWednesday;
    }

    public boolean isOccurThursday() {
        return isOccurThursday;
    }

    public void setOccurThursday(boolean isOccurThursday) {
        this.isOccurThursday = isOccurThursday;
    }

    public boolean isOccurFriday() {
        return isOccurFriday;
    }

    public void setOccurFriday(boolean isOccurFriday) {
        this.isOccurFriday = isOccurFriday;
    }

    public boolean isOccurSaturday() {
        return isOccurSaturday;
    }

    public void setOccurSaturday(boolean isOccurSaturday) {
        this.isOccurSaturday = isOccurSaturday;
    }

    public boolean isOccurSunday() {
        return isOccurSunday;
    }

    public void setOccurSunday(boolean isOccurSunday) {
        this.isOccurSunday = isOccurSunday;
    }
}
