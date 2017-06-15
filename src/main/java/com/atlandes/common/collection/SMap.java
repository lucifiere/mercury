package com.atlandes.common.collection;

import com.alibaba.druid.util.StringUtils;

import java.io.Serializable;
import java.util.*;

/**
 * Created by XD.Wang on 2017/6/15.
 * 序列化Map
 */
@SuppressWarnings("unchecked")
public class SMap<K, V> implements Map<K, V>, Serializable {

    private final Map<K, V> map;

    public static <K, V> SMap<K, V> getSMap(Map<K, V> map) {
        return map instanceof SMap ? (SMap) map : (map != null ? new SMap(map) : new SMap());
    }

    public SMap() {
        this(new HashMap(), true);
    }

    public SMap(int size) {
        this(new HashMap(size), true);
    }

    public SMap(int size, float loadFactor) {
        this(new HashMap(size, loadFactor), true);
    }

    public SMap(Map<K, V> map) {
        this(map, true);
    }

    public SMap(Map<K, V> map, boolean proxy) {
        if (map == null) {
            this.map = new HashMap();
        } else if (proxy) {
            this.map = map;
        } else {
            this.map = new HashMap(map);
        }

    }

    public SMap getSMap(Object o) {
        Object map = this.get(o);
        return map instanceof SMap ? (SMap) map : (map instanceof Map ? new SMap((Map) map) : null);
    }

    public V getFirstValue() {
        Iterator<V> it = this.map.values().iterator();
        return it.hasNext() ? it.next() : null;
    }

    public String getString(Object o) {
        Object obj = this.get(o);
        return obj != null ? obj.toString() : null;
    }

    public V putNotNull(K key, V v) {
        return v == null ? null : this.put(key, v);
    }

    public V putNotEmpty(K key, V v) {
        return v == null ? null : (v instanceof String && StringUtils.isEmpty(v.toString()) ? null : this.put(key, v));
    }

    public Boolean getBoolean(Object o) {
        Object v = this.get(o);
        return v instanceof Boolean ? (Boolean) v : (v instanceof String ? Boolean.parseBoolean(v.toString()) : null);
    }

    public Integer getInt(Object o) {
        return parseInt(this.get(o));
    }

    public Long getLong(Object o) {
        return parseLong(this.get(o));
    }

    public Double getDouble(Object o) {
        return parseDouble(this.get(o));
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    public V get(Object key) {
        return this.map.get(key);
    }

    public V put(K key, V value) {
        return this.map.put(key, value);
    }

    public V remove(Object key) {
        return this.map.remove(key);
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        this.map.putAll(m);
    }

    public void clear() {
        this.map.clear();
    }

    public Set<K> keySet() {
        return this.map.keySet();
    }

    public Collection<V> values() {
        return this.map.values();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return this.map.entrySet();
    }

    public boolean equals(Object o) {
        return this.map.equals(o);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return this.map.toString();
    }

    public static Integer parseInt(Object o) {
        if (o instanceof Number) {
            return ((Number) o).intValue();
        } else {
            if (o instanceof String) {
                try {
                    return Integer.parseInt((String) o);
                } catch (NumberFormatException var3) {
                    Double d = parseDouble(o);
                    if (d != null) {
                        return d.intValue();
                    }
                }
            }

            return null;
        }
    }

    public static Double parseDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        } else {
            if (o instanceof String) {
                try {
                    return Double.parseDouble((String) o);
                } catch (NumberFormatException ignored) {

                }
            }

            return null;
        }
    }

    public static Long parseLong(Object o) {
        if (o instanceof Number) {
            return ((Number) o).longValue();
        } else {
            if (o instanceof String) {
                try {
                    return Long.parseLong((String) o);
                } catch (NumberFormatException var3) {
                    Double d = parseDouble(o);
                    if (d != null) {
                        return d.longValue();
                    }
                }
            }

            return null;
        }
    }
}
