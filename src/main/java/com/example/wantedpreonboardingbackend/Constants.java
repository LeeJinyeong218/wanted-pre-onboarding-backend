package com.example.wantedpreonboardingbackend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    // constants
    public static final MapAndList<String, String[]> COUNTRIES_LOCATIONS = new MapAndList<>(){{
        put("한국", new String[]{"서울", "경기", "인천", "세종", "강원", "부산", "대구",
                                "광주", "대전", "울산", "충청", "전라", "경상", "제주"});
    }};


    // define classes for constants
    public static class MapAndList<K, V> {
        private Map<K, V> map = new HashMap<K, V>();
        private List<K> list = new ArrayList<>();

        public void put(K key, V value) {
            this.list.add(key);
            this.map.put(key, value);
        }

        public Map<K, V> getMap() {
            return this.map;
        }

        public List<K> getList() {
            return this.list;
        }

        public V getValueByKey(K key) {
            return this.map.get(key);
        }
    }
}
