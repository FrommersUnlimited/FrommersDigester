package com.wiley.frommers.digester;

import org.apache.log4j.Logger;

import com.wiley.frommers.digester.config.FrommersDigesterConfig;
import com.wiley.frommers.digester.impl.AbstractFrommersDigester;
import com.wiley.frommers.digester.impl.XStreamFrommersDigester;

/**
 * Factory class that creates an instance of FrommersDigester.
 */
public class FrommersDigesterFactory {
    
    protected static final Logger LOGGER = Logger.getLogger(FrommersDigesterFactory.class);
    
    private static AbstractFrommersDigester instance;
    
    /**
     * Singleton access method.  Provide rootUrl and cacheActive to 
     * configure instance.
     */
    public static final FrommersDigester getInstance(FrommersDigesterConfig config, 
            FrommersDigesterUnmarshaller unmarshaller) {
        if (instance == null || !instance.getConfig().equals(config) 
                || !instance.getClass().equals(unmarshaller.getUnmarshallingDigesterClass())) {
            LOGGER.debug("FeedService.getInstance creating new FeedService instance");
            switch (unmarshaller) {
                case XSTREAM:
                    instance = new XStreamFrommersDigester(config);
                    
            }
        }
        return instance;
    }
    
    /**
     * Returns pre-initialized instance. If an instance has not be initialized
     * this method will thrown an exception.
     * 
     * @return
     * @throws FrommersFeedException
     */
    public static final FrommersDigester getInstance() throws FrommersFeedException {
        if (instance == null) {
            throw new FrommersFeedException("rootUrl and cacheActive not configured");
        }
        return instance;
    }

}
