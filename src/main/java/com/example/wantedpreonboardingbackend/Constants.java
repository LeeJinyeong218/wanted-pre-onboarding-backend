package com.example.wantedpreonboardingbackend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    // constants
    public static Countries COUNTRIES = new Countries(new Country[]{
            new Country(new KeyValuePair(1, "한국"), new KeyValuePair[]{
                    new KeyValuePair(1, "서울"),
                    new KeyValuePair(2, "경기"),
                    new KeyValuePair(3, "인천"),
                    new KeyValuePair(4, "충청"),
                    new KeyValuePair(5, "대구"),
                    new KeyValuePair(6, "부산"),
                    new KeyValuePair(7, "광주"),
                    new KeyValuePair(8, "전라"),
                    new KeyValuePair(9, "대전"),
                    new KeyValuePair(10, "울산"),
                    new KeyValuePair(11, "경상"),
                    new KeyValuePair(12, "세종"),
                    new KeyValuePair(13, "강원"),
                    new KeyValuePair(14, "제주"),
            })
    });

    // declare classes for constants definition
    public static class KeyValuePair {
        private Integer key;
        private String value;

        public KeyValuePair(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static class PairList {
        private Map<Integer, KeyValuePair> map = new HashMap<>();
        private List<KeyValuePair> list;

        public PairList(KeyValuePair[] pairList) {
            this.list = new ArrayList<KeyValuePair>(List.of(pairList));
            for (KeyValuePair pair : pairList) {
                this.map.put(pair.getKey(), pair);
            }
        }
    }

    public static class Country {
        private KeyValuePair country;
        private PairList locations;

        public Country(KeyValuePair country, KeyValuePair[] locations) {
            this.country = country;
            this.locations = new PairList(locations);
        }

        public Integer getKey() {
            return this.country.getKey();
        }

        public String getCountryName() {
            return this.country.getValue();
        }

        public PairList getLocations() {
            return this.locations;
        }
    }

    public static class Countries {
        private Map<Integer, Country> map = new HashMap<>();
        private List<Country> list;

        public Countries(Country[] countryList) {
            this.list = new ArrayList<Country>(List.of(countryList));
            for (Country country : countryList) {
                this.map.put(country.getKey(), country);
            }
        }
    }
}
