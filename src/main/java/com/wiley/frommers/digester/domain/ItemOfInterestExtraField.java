/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * This is a way to expand the attributes of an IOI by providing extra
 * name/value pairs as fields.
 * 
 * @author rwatts, created 18 Nov 2009
 */
@XStreamAlias("field")
public class ItemOfInterestExtraField {

    @XStreamAsAttribute()
    private String fieldKey;
    @XStreamAsAttribute()
    private String name;
    @XStreamAsAttribute()
    private String value;

    public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
