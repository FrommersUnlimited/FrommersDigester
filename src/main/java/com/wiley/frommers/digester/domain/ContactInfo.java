/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Contact information for a given Event or POI. Generally used for Events to
 * provide alternative contact information, e.g. a ticket contact.
 * 
 * @see ItemOfInterest
 * @author rwatts, created 16 Mar 2010
 */
@XStreamAlias("contactInfo")
public class ContactInfo {

    @XStreamAsAttribute
    private String address;
    @XStreamAsAttribute
    private String email;
    @XStreamAsAttribute
    private String fax;
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String telephone1;
    @XStreamAsAttribute
    private String telephone2;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

}
