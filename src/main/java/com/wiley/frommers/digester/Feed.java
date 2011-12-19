package com.wiley.frommers.digester;

/**
 * Enum of all feed codes
 */
public enum Feed {

    DESTINATION_MENU("destination_menu"),
    GUIDE_STRUCTURE("guide_structure"),
    ITEM_OF_INTEREST("item_of_interest"),
    LOCATION("location"),
    MEDIA("media"),
    SLIDESHOW("slideshow"),
    AUDIENCE_INTEREST_SEARCH("audience_interest_search"),
    CALENDAR_EVENT_SEARCH("calendar_event_search"),
    EVENT_SEARCH("event_search"),
    LOCATION_SEARCH("location_search"),
    MAIN_SEARCH("main_search"),
    MEDIA_SEARCH("media_search"),
    POI_SEARCH("poi_search"),
    SLIDESHOW_SEARCH("slideshow_search");
    
    private final String code;
    
    private Feed(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
}
