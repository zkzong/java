package com.example.collection.map;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Zong on 2016/7/16.
 */
public class HashMapStructure {
    public static void main(String[] args) {
        Country india = new Country("India", 1000);
        Country japan = new Country("Japan", 10000);

        Country france = new Country("France", 2000);
        Country russia = new Country("Russia", 20000);

        HashMap<Country, String> countryCapitalMap = new HashMap<Country, String>();
        countryCapitalMap.put(india, "Delhi");
        countryCapitalMap.put(japan, "Tokyo");
        countryCapitalMap.put(france, "Paris");
        countryCapitalMap.put(russia, "Moscow");

        Iterator<Country> countryCapitalIter = countryCapitalMap.keySet().iterator();
        while (countryCapitalIter.hasNext()) {
            Country countryObj = countryCapitalIter.next();
            String capital = countryCapitalMap.get(countryObj);
            System.out.println(countryObj.getName() + "----" + capital);
        }
    }
}
