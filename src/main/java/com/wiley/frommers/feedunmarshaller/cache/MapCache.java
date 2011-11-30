/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.feedunmarshaller.cache;

import java.util.HashMap;
import java.util.Map;

import com.wiley.frommers.feedunmarshaller.domain.DestinationMenu;
import com.wiley.frommers.feedunmarshaller.domain.GuideStructure;
import com.wiley.frommers.feedunmarshaller.domain.ItemOfInterest;
import com.wiley.frommers.feedunmarshaller.domain.Location;
import com.wiley.frommers.feedunmarshaller.domain.Slideshow;

/**
 * First implementation of the cahce usin hash map
 * 
 * @author fzerdoudi, created 7 Nov 2011
 * 
 */

public class MapCache {

    static Map<String, DestinationMenu> DESTINATION_MENU = new HashMap<String, DestinationMenu>();
    static Map<String, GuideStructure> GUIDE_STRUCTURE = new HashMap<String, GuideStructure>();
    static Map<String, Slideshow> SLIDE_SHOW = new HashMap<String, Slideshow>();
    static Map<String, Location> LOCATIONS = new HashMap<String, Location>();
    static Map<String, ItemOfInterest> ITEM_OF_INTEREST = new HashMap<String, ItemOfInterest>();

    public DestinationMenu getDestinationMenu(String id) {
        return DESTINATION_MENU.get(id);
    }

    public GuideStructure getGuideStructure(String id) {
        return GUIDE_STRUCTURE.get(id);
    }

    public void addGuideStructure(GuideStructure guideStructure) {
        if (guideStructure != null && guideStructure.getId() != null)
            GUIDE_STRUCTURE.put(guideStructure.getId().toString(),
                    guideStructure);
    }

    public void addDestinationMenu(DestinationMenu destinationMenu) {
        DESTINATION_MENU.put(destinationMenu.getLocationId().toString(),
                destinationMenu);
    }

    public Slideshow getSlideshow(String id) {
        return SLIDE_SHOW.get(id);
    }

    public void addSlideshow(String id, Slideshow slideShow) {
        SLIDE_SHOW.put(id, slideShow);
    }

    public Location getLocation(String id) {
        return LOCATIONS.get(id);
    }

    public void addLocation(Location location) {
        LOCATIONS.put(location.getId().toString(), location);
    }

    public void addItemOfInterest(ItemOfInterest itemOfInterest) {
        ITEM_OF_INTEREST.put(itemOfInterest.getId().toString(), itemOfInterest);
    }

    public ItemOfInterest getItemOfInterest(String id) {
        return ITEM_OF_INTEREST.get(id);
    }

}
