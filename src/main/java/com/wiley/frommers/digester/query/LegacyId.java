package com.wiley.frommers.digester.query;

/**
 * Legacy id parameters used to call the feeds.
 */
public enum LegacyId {

    WHATSONWHEN_ID("whatsonwhenId"),
    FROMMERS_DESTINATION_ID("frommersDestinationId"),
    FROMMERS_ACCOMMODATION_ID("frommersAccommodationId"),
    FROMMERS_DINING_ID("frommersDiningId"),
    FROMMERS_NIGHTLIFE_ID("frommersNightlifeId"),
    FROMMERS_SHOPPING_ID("frommersShoppingId"),
    FROMMERS_ATTRACTION_ID("frommersAttractionId");
    
    private String name;
    
    private LegacyId(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
