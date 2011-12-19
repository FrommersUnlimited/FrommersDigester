/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain.util;

import com.thoughtworks.xstream.converters.basic.DateConverter;

/**
 * Override the xstream default DateConverter to supply a standard date format.
 * It uses a format (yyyy-MM-dd) recognised by XSD schema as xs:date and
 * recognised by ISO 8601 conventions.
 * 
 * @author rwatts, created 20 Oct 2009
 */
public class FeedDateConverter extends DateConverter {

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd";
    private static final String[] BACKUP_FORMATS = new String[0];

    public FeedDateConverter() {
        super(DEFAULT_FORMAT, BACKUP_FORMATS);
    }
}
