package com.example.demo.attach.domain;

import com.example.demo.attach.filter.AttachFilter;
import com.example.demo.attach.filter.AttachFilterChain;

import java.util.List;

public interface ReferenceType {

    String getTypeName();

    MapCode getMapCode(String mapCode);

    MapCode addMapCode(String mapCode);

    MapCode addMapCode(String mapCode, List<AttachFilter> attachFilterList);

    MapCode addFilter(String mapCode, AttachFilter attachFilter);

    AttachFilterChain getFilterList(String mapCode);

}
