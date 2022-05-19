package com.example.demo.attach.domain;

import com.example.demo.attach.filter.AttachFilter;
import com.example.demo.attach.filter.AttachFilterChain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DefaultReferenceType implements ReferenceType, Serializable {
    private Map<String, MapCode> filterListMap = new HashMap();

    abstract public String getTypeName();

    public MapCode getMapCode(String mapCode) {
        return filterListMap.get(mapCode);
    }

    public MapCode addMapCode(String mapCode) {
        MapCode obj = new MapCode(mapCode);
        filterListMap.put(mapCode, obj);
        return obj;
    }

    public MapCode addMapCode(String mapCode, List<AttachFilter> attachFilterList) {
        MapCode obj = new MapCode(mapCode);
        filterListMap.put(mapCode, obj);
        return obj;
    }

    public MapCode addFilter(String mapCode, AttachFilter attachFilter) {
        MapCode obj = filterListMap.get(mapCode);
        return obj;
    }

    public AttachFilterChain getFilterList(String mapCode) {
        MapCode obj = filterListMap.get(mapCode);
        return obj.getFilterChain();
    }

}
