package com.wiley.frommers.digester.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A very basic in-memory object cache. It's useful for storing objects that are
 * expensive to create between servlet invocations. Caches are created with a
 * maximum size and an object expiration interval. If the cache is full, objects
 * are removed in LRU (Least Recently Used) order to make room for new objects.
 * If an object whose timout has passed is requested, the object is removed and
 * <code>null</code> is returned.
 * <p>
 * Wraps a HashMap, most methods are shoot-throughs to it. All the
 * state-changing methods are synchronized. The order of the keys, values or
 * elements is not guaranteed. See the API docs for java.util.HashMap for
 * comments on methods not commented here.
 * <p>
 * Please keep in mind that cached objects are stored in the JVM's allocated
 * memory, and will contribute to the overall footprint of your application.
 * <p>
 * The application code might look like this:
 * 
 * <pre>
 * 
 * public class MyServlet extends HttpServlet {
 * 
 *     // Create the cache in the static initializer, so it stays around beteween
 *     // invocations
 *     private static SimpleObjectCache myCache = new SimpleObjectCache(200, // Up
 *                                                                           // to
 *                                                                           // 200
 *                                                                           // objects
 *             60000 // 10 minute expiration on objects
 *     );
 * 
 *     public void processRequest(
 *              HttpServletRequest request, HttpServletResponse response
 *          ) throws ServletException, IOException {
 *              
 *              String key = &quot;MyKey&quot;; // For a web app, probably based on something in the URL
 *              MyValueType value = (MyValueType)myCache.get(key);
 *              
 *              if (value == null) {
 *                  value = buildAValue(request); // This is the slow code we're avoiding
 *                  cache.put(key, value);
 *              }
 *              
 *              // use the value in some way...
 *              .
 *              .
 *              .
 *          
 *          }}
 * </pre>
 * 
 * @author nuglov, created Jan 2, 2004 at 3:28:19 PM
 * @version $Id: SimpleObjectCache.java,v 1.1 2004/09/20 15:26:49 gkreftin Exp $
 */
public class SimpleObjectCache {

    private int maxSize;
    private long expireAfterMS;
    private HashMap<String, Object> map;

    /**
     * Create new SimpleObjectCache.
     * 
     * @param maxSize
     *            Maximum number of elements to retain in cache.
     * @param expireAfterMS
     *            Number of milliseconds before a given element expires.
     */
    public SimpleObjectCache(int maxSize, long expireAfterMS) {
        this.maxSize = maxSize;
        this.expireAfterMS = expireAfterMS;
        this.map = new HashMap<String, Object>(maxSize, 1);
    }

    /**
     * @see java.util.HashMap#clear()
     */
    public synchronized void clear() {
        map.clear();
    }

    /**
     * @see java.util.HashMap#containsKey(java.lang.Object)
     */
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    /**
     * @see java.util.HashMap#containsValue(java.lang.Object)
     */
    public boolean containsValue(Object value) {
        SimpleObjectCacheValue socValue = new SimpleObjectCacheValue(value);
        return map.containsValue(socValue);
    }

    /**
     * @see java.util.HashMap#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        return map.equals(o);
    }

    /**
     * Looks up an object for the specified key and returns it if it has not
     * expired yet. Returns null if not found or expired.
     * 
     * @see java.util.HashMap#get(java.lang.Object)
     */
    public synchronized Object get(Object key) {
        SimpleObjectCacheValue socValue = (SimpleObjectCacheValue) map.get(key);
        if (socValue == null) {
            return null;
        } else if (System.currentTimeMillis() - socValue.getUpdateTimestamp() > expireAfterMS) {
            map.remove(key);
            return null;
        } else {
            return socValue.getValue();
        }
    }

    /**
     * @see java.util.HashMap#hashCode()
     */
    public int hashCode() {
        return map.hashCode();
    }

    /**
     * @see java.util.HashMap#isEmpty()
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * Returns a <b>synchronized </b>, <b>unmodifiable </b> Colection of values.
     * 
     * @see java.util.HashMap#keySet()
     */
    public Set<String> keySet() {
        return Collections.unmodifiableSet(Collections.synchronizedSet(map
                .keySet()));
    }

    /**
     * Puts a new key/value pair into the map. If the map is already of the
     * maximum size, performs a removeLRU() prior to putting the new enry in.
     * 
     * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
     */
    public synchronized Object put(String key, Object value) {
        SimpleObjectCacheValue socValue = (SimpleObjectCacheValue) map.get(key);
        Object result = null;
        if (socValue != null) {
            result = socValue.getValue();
            socValue.setValue(value);
        } else {
            if (map.size() >= maxSize) {
                removeLRU();
            }
            socValue = new SimpleObjectCacheValue(value);
            map.put(key, socValue);
        }
        return result;
    }

    /**
     * Calls put(key,value) for each entry in Map t.
     * 
     * @see java.util.HashMap#putAll(java.util.Map)
     */
    public synchronized void putAll(Map<String, Object> t) {
        for (Iterator<Map.Entry<String, Object>> it = t.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Object> entry = it.next();
            this.put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * @see java.util.HashMap#remove(java.lang.Object)
     */
    public synchronized Object remove(Object key) {
        SimpleObjectCacheValue socValue = (SimpleObjectCacheValue) map
                .remove(key);
        return (socValue == null ? null : socValue.getValue());
    }

    /**
     * Remove one least recently used entry and return the value.
     */
    public synchronized Object removeLRU() {
        Object lruKey = null;
        long lruTimestamp = Long.MAX_VALUE;
        for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
            Object key = it.next();
            SimpleObjectCacheValue socValue = (SimpleObjectCacheValue) map
                    .get(key);
            if (lruTimestamp > socValue.getGetTimestamp()) {
                lruTimestamp = socValue.getGetTimestamp();
                lruKey = key;
            }
        }
        if (lruKey == null) {
            throw new IllegalStateException("Cannot find LRU entry");
        } else {
            return ((SimpleObjectCacheValue) map.remove(lruKey)).getValue();
        }
    }

    /**
     * @see java.util.HashMap#size()
     */
    public synchronized int size() {
        return map.size();
    }

    /**
     * @return a String with basic stats aboit the current cache contents.
     */
    public synchronized String getStatSummary() {
        StringBuffer message = new StringBuffer();
        message.append("SimpleObjectCache: size=").append(map.size());

        // Sort the map entries by getCount
        SortedSet<Map.Entry<String, Object>> sortedSet = new TreeSet<Map.Entry<String, Object>>(
                new SimpleObjectCacheEntryGetCountComparator());
        for (Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Object> entry = it.next();
            sortedSet.add(entry);
        }

        // walk through the sorted set
        for (Iterator<Map.Entry<String, Object>> it = sortedSet.iterator(); it.hasNext();) {
            Map.Entry<String, Object> entry = it.next();
            Object key = entry.getKey();
            SimpleObjectCacheValue socValue = (SimpleObjectCacheValue) entry
                    .getValue();
            message.append('\n').append(key);
            message.append(" : ").append(socValue.getGetTimestamp());
            message.append(" / ").append(socValue.getGetCount());
        }

        return message.toString();
    }

    //
    // Utility inner classes
    //

    /**
     * Comparator: first by "getCount" (reverse), then by key (reverse)
     */
    private class SimpleObjectCacheEntryGetCountComparator implements
            Comparator<Map.Entry<String, Object>> {

        public int compare(Map.Entry<String, Object> t0, Map.Entry<String, Object> t1) {
            SimpleObjectCacheValue v0 = (SimpleObjectCacheValue) (t0.getValue());
            SimpleObjectCacheValue v1 = (SimpleObjectCacheValue) (t1.getValue());
            Long getCount0 = new Long(v0.getGetCount());
            Long getCount1 = new Long(v1.getGetCount());
            int result = getCount1.compareTo(getCount0);
            if (result == 0) {
                // if count is the same, then compare by key
                Integer keyHash0 = new Integer(t0.getKey().hashCode());
                Integer keyHash1 = new Integer(t1.getKey().hashCode());
                result = keyHash1.compareTo(keyHash0);
            }
            return result;
        }
    }

    /**
     * Wrapper for values of SimpleObjectCache. Besides the value itself, stores
     * the "get count" and the last update timestamp.
     * 
     * @author nuglov, created Jan 2, 2004 at 3:47:49 PM
     * @version $Id: SimpleObjectCache.java,v 1.1 2004/09/20 15:26:49 gkreftin
     *          Exp $
     */
    private class SimpleObjectCacheValue {

        private Object value;
        private long getCount;
        private long getTimestamp;
        private long updateTimestamp;

        public SimpleObjectCacheValue(Object value) {
            this.value = value;
            this.getCount = 0;
            this.getTimestamp = 0;
            this.updateTimestamp = System.currentTimeMillis();
        }

        /**
         * Returns the underlying value, increments the "get count", resets the
         * "get timestamp".
         */
        public Object getValue() {
            getCount++;
            getTimestamp = System.currentTimeMillis();
            return value;
        }

        /**
         * Updates the underlying value and resets the updateTimestamp.
         */
        public void setValue(Object value) {
            this.value = value;
            this.updateTimestamp = System.currentTimeMillis();
        }

        /**
         * Returns the "get count"
         */
        public long getGetCount() {
            return getCount;
        }

        /**
         * Returns the "update timestamp"
         */
        public long getGetTimestamp() {
            return getTimestamp;
        }

        /**
         * Returns the "update timestamp"
         */
        public long getUpdateTimestamp() {
            return updateTimestamp;
        }

        /**
         * Compares this object to the specified object. The result is
         * <code>true</code> if and only if the argument is not
         * <code>null</code> and is a <code>SimpleObjectCacheValue</code> object
         * that has the same <code>value</code> as this object.
         */
        public boolean equals(Object obj) {
            if ((obj != null) && (obj instanceof SimpleObjectCacheValue)) {
                SimpleObjectCacheValue another = (SimpleObjectCacheValue) obj;
                return this.getValue().equals(another.getValue());
            }
            return false;
        }

    }

}