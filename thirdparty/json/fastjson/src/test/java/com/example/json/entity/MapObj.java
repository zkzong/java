package com.example.json.entity;

import java.util.HashMap;
import java.util.Map;

public class MapObj {
    private Map<String, String> map;

    public MapObj() {
        this.map = new HashMap<>();
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setInfo(String key, String value) {
        map.put(key, value);
    }

    public String getInfo(String key) {
        return map.get(key);
    }
}
