package com.example.demo.attach.domain;

import com.example.demo.attach.filter.AttachFilter;
import com.example.demo.attach.filter.AttachFilterChain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper=false)
public class MapCode implements Serializable {

    private String mapCode;

    private AttachFilterChain filterChain;

    public MapCode(String mapCode) {
        this.mapCode = mapCode;
        filterChain = new AttachFilterChain();
    }

    public MapCode addFilter(Class<? extends AttachFilter> klass, Map<String, Object> config) throws Exception {
        filterChain.addFilter(klass, config);
        return this;
    }

    public AttachFilterChain getFilterChain() {
        return filterChain;
    }

    public void startFilter(File file) throws Exception {
        filterChain.startFilter(file);
    }

}
