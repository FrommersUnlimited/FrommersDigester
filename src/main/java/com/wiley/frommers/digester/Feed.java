package com.wiley.frommers.digester;

/**
 * Enum of all feed codes
 */
public enum Feed {

    ITEM_OF_INTEREST("item_of_interest", "itemOfInterestId"),
    DESTINATION_MENU_FEED("destination_menu"),
    GUIDE_STRUCTURE("guide_structure", "guideStructureId"),
    LOCATION("location", "locationId"),
    SLIDESHOW("slideshow", "slideshowId"),
    MEDIA("media", "mediaId"),
    AUDIENCE_INTEREST_SEARCH("audience_interest_search"),
    POI_SEARCH("poi_search"),
    EVENT_SEARCH("event_search"),
    LOCATION_SEARCH("location_search"),
    MEDIA_SEARCH("media_search"),
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
