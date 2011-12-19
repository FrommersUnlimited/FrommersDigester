/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.thoughtworks.xstream.converters.SingleValueConverter;

/**
 * Override the xstream default DateConverter to supply a standard date format. It uses a format
 * (yyyy-MM-dd) recognised by XSD schema as xs:date and recognised by ISO 8601 conventions.
 * 
 * @author rwatts, created 20 Oct 2009
 */
public class FriendlyDoubleConverter implements SingleValueConverter {

    private static final NumberFormat FORMATTER = new DecimalFormat("#.0000", new DecimalFormatSymbols(Locale.US));

    @Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
        return clazz.equals(Double.class);
    }

    @Override
    public Object fromString(String arg) {
        try {
            // just because all the Numbers are Float
            return FORMATTER.parse(arg).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse " + arg + " as number", e);
        }
    }

    @Override
    public String toString(Object obj) {
        return FORMATTER.format(obj);
    }
}
