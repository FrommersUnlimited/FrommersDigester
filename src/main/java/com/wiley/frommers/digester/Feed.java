package com.wiley.frommers.digester;

/**
 * Enum of all feed codes
 */
public enum Feed {

    DESTINATION_MENU_FEED("destination_menu"),
    GUIDE_STRUCTURE("guide_structure", "guideStructureId"),
    ITEM_OF_INTEREST("item_of_interest", "itemOfInterestId"),
    LOCATION("location", "locationId"),
    MEDIA("media", "mediaId"),
    SLIDESHOW("slideshow", "slideshowId"),
    AUDIENCE_INTEREST_SEARCH("audience_interest_search"),
    EVENT_SEARCH("event_search"),
    LOCATION_SEARCH("location_search"),
    MAIN_SEARCH("main_search"),
    MEDIA_SEARCH("media_search"),
    POI_SEARCH("poi_search"),
    SLIDESHOW_SEARCH("slideshow_search");
    
    private final String code;
    private final String idName;
    
    private Feed(String code) {
        this.code = code;
        this.idName = null;
    }
    
    private Feed(String code, String idName) {
        this.code = code;
        this.idName = idName;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getIdName() {
        return idName;
    }
}
