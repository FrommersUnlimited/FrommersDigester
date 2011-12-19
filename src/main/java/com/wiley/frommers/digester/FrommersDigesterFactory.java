package com.wiley.frommers.digester;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.wiley.frommers.digester.impl.xstream.XStreamFrommersDigester;
import com.wiley.frommers.digester.impl.xstream.XStreamFrommersDigesterConfig;
import com.wiley.frommers.digester.impl.xstream.XStreamManager;

/**
 * Factory class that creates an instance of FrommersDigester.
 */
public class FrommersDigesterFactory {
    
    protected static final Logger LOGGER = Logger.getLogger(FrommersDigesterFactory.class);
    protected static final ClasspathURLStreamHandler defaultHandler = new ClasspathURLStreamHandler();
    
    private static FrommersDigester instance;
    
    /**
     * If necessary, create a new FrommersDigester instance.
     * 
     * @param unmarshaller your choice of unmarshaller library to use
     * @param configLocation the URL location of the config file 
     * @return
     * @throws FrommersFeedException
     */
    public static final FrommersDigester getInstance(FrommersDigesterUnmarshaller unmarshaller, String configLocation) 
        throws FrommersFeedException {
        return getInstance(unmarshaller, configLocation, defaultHandler);
    }
    
    /**
     * If necessary, create a new FrommersDigester instance.
     * 
     * @param unmarshaller your choice of unmarshaller library to use
     * @param configLocation the URL location of the config file 
     * @param loader a custom ClassLoader to use when loading the config URL from the classpath.
     * @return
     * @throws FrommersFeedException
     */
    public static final FrommersDigester getInstance(FrommersDigesterUnmarshaller unmarshaller, String configLocation, ClassLoader loader) 
        throws FrommersFeedException {
        return getInstance(unmarshaller, configLocation, new ClasspathURLStreamHandler(loader));
    }
    
    /**
     * If necessary, create a new FrommersDigester instance.
     * 
     * @param unmarshaller your choice of unmarshaller library to use
     * @param configLocation the URL location of the config file
     * @param handler a customer URLStreamHandler to use when loading the config URL.
     * @return
     * @throws FrommersFeedException
     */
    public static final FrommersDigester getInstance(FrommersDigesterUnmarshaller unmarshaller, String configLocation, URLStreamHandler handler) throws FrommersFeedException{
        
        try {
            switch (unmarshaller) {
                case XSTREAM:
                    XStream xstream = XStreamManager.getInstance();
                    URL configUrl = new URL(null, configLocation, handler);
                    FrommersDigesterConfig config = (XStreamFrommersDigesterConfig) 
                            xstream.fromXML(configUrl);
                    
                    // Check if there isn't an instance already configured
                    if (instance != null && instance instanceof XStreamFrommersDigester && 
                            instance.getConfig().equals(config)) {
                        return instance;
                    }
                    
                    instance = new XStreamFrommersDigester(config, xstream);
            }
        } catch (MalformedURLException e) {
            throw new FrommersFeedException("Unable to iniatize instance: " + unmarshaller + " with config: " + configLocation);
        }
        
        if (instance == null) {
            throw new FrommersFeedException("Cannot initialize FrommersDigester: null");
        }
        
        return instance;
    }
    
    /**
     * If necessary, create a new FrommersDigester instance.
     * 
     * @param unmarshaller your choice of unmarshaller library to use
     * @param config custom configuration class, which must implement the equals() method
     * @return
     * @throws FrommersFeedException
     */
    public static final FrommersDigester getInstance(FrommersDigesterUnmarshaller unmarshaller, FrommersDigesterConfig config) throws FrommersFeedException{
        switch (unmarshaller) {
            case XSTREAM:
                if (instance != null && instance instanceof XStreamFrommersDigester &&
                    instance.getConfig().equals(config)) {
                    return instance;
                }
                XStream xstream = XStreamManager.getInstance();
                instance = new XStreamFrommersDigester(config, xstream);
        }
        
        if (instance == null) {
            throw new FrommersFeedException("Cannot initialize FrommersDigester: null");
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
            throw new FrommersFeedException("Previous instance of FrommersDigester not initialized.");
        }
        return instance;
    }
    
    /**
     * Inner class that allows custom classpaths loaders to resolve URLs.
     */
    private static final class ClasspathURLStreamHandler extends URLStreamHandler {
        /** The classloader to find resources from. */
        private final ClassLoader classLoader;

        public ClasspathURLStreamHandler() {
            this.classLoader = getClass().getClassLoader();
        }

        public ClasspathURLStreamHandler(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }

        @Override
        protected URLConnection openConnection(URL u) throws IOException {
            final URL resourceUrl = classLoader.getResource(u.getPath());
            return resourceUrl.openConnection();
        }
    }

}
