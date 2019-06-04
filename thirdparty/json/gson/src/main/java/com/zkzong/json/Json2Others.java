package com.zkzong.json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2016/8/11.
 */
public class Json2Others {
    public static void main(String[] args) {
        String str = "[{\"name\":\"zong\",\"age\":1},{\"name\":\"liu\",\"age\":2},{\"name\":\"ma\",\"age\":3}]";

        Gson gson = new Gson();

        System.out.println("转换成Person对象");
        List<Person> personList = gson.fromJson(str, new TypeToken<List<Person>>() {
        }.getType());
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            System.out.println("name:" + person.getName() + ", age:" + person.getAge());
        }

        System.out.println("转换成Map");
        List<Map> mapList = gson.fromJson(str, new TypeToken<List<Map>>() {
        }.getType());
        for (int i = 0; i < mapList.size(); i++) {
            Map map = mapList.get(i);
            System.out.println("name:" + map.get("name") + ", age:" + map.get("age"));
        }

        System.out.println("转换成JSONObject");
        List<JsonObject> jsonObjectList = gson.fromJson(str, new TypeToken<List<JsonObject>>() {
        }.getType());
        for (int i = 0; i < jsonObjectList.size(); i++) {
            JsonObject jsonObject = jsonObjectList.get(i);
            System.out.println("name:" + jsonObject.get("name") + ", age:" + jsonObject.get("age"));
        }

        System.out.println("转换成数组");
        String strArr = "[\"zong\", \"liu\", \"ma\"]";
        String[] strings = gson.fromJson(strArr, String[].class);
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            System.out.print(string + " ");
        }
    }

    /**
     * 简单
     */
    @Test
    public void json2Map1() {
        String s = "{\"tourOutIn\":\"100000\", \"tourDistrictId\":\"\"}";

        Gson gson = new Gson();
        Map m = gson.fromJson(s, new TypeToken<Map>() {
        }.getType());
        String tourOutIn = m.get("tourOutIn").toString();
        String tourDistrictId = m.get("tourDistrictId").toString();
        System.out.println(tourOutIn);
        System.out.println(tourDistrictId);
    }

    /**
     * 复杂
     */
    @Test
    public void json2Map2() {
        String s = "{\"keyword\":\"\", \"tourOutIn\":\"100000\", \"startCityPara\":\"[]\", " +
                "\"endCityPara\":\"[]\", \"targetCity\":\"[]\", \"linePlay\":\"[]\", " +
                "\"supplierPara\":\"[]\", \"groupDatePara\":\"[]\", \"dayPara\":\"[]\", \"pricePara\":\"[]\"," +
                " \"freePara\":\"[]\", \"pageNo\":\"100000\", \"pageSize\":\"100000\", \"orderBy\":\"100000\"}";
        Gson gson = new Gson();
        Map m = gson.fromJson(s, new TypeToken<Map>() {
        }.getType());
        System.out.println("keyword:" + m.get("keyword"));
        System.out.println("tourOutIn:" + m.get("tourOutIn"));

        String startCityPara = m.get("startCityPara").toString();
        String[] strings = gson.fromJson(startCityPara, String[].class);
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            System.out.print(string + " ");
        }
    }

    /**
     * 更复杂
     */
    @Test
    public void json2Map3() {
        String s = "{\"jumpType\":\"1\", \"travelSelected\":{\"travelArea\":[1], \"travelInOut\":[\"100000\"], \"travelId\":[]}, \"tabText\":\"\"}";

        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(s, new TypeToken<Map<String, Object>>() {
        }.getType());
        String jumpType = map.get("jumpType").toString(); // 跳转类型
        String tabText = map.get("tabText").toString(); // 搜索内容

        String travelSelected = map.get("travelSelected").toString();
        Map<String, Object> m = gson.fromJson(travelSelected, new TypeToken<Map<String, Object>>() {
        }.getType());
        String travelArea = m.get("travelArea").toString();
        String travelInOut = m.get("travelInOut").toString();
        String travelId = m.get("travelId").toString();

        Map resultMap = new LinkedHashMap();
        List list = new LinkedList();

        Map travelAreaMap = new LinkedHashMap();
        String[] travelAreaArr = gson.fromJson(travelArea, String[].class);
        if (travelAreaArr.length > 0) {
            travelAreaMap.put("travelAreaId", travelAreaArr[0]);
            travelAreaMap.put("travelAreaName", "");
            list.add(travelAreaMap);
        } else {
            travelAreaMap.put("travelAreaId", "");
            travelAreaMap.put("travelAreaName", "");
            list.add(travelAreaMap);
        }

        Map travelInOutMap = new LinkedHashMap();
        String[] travelInOutArr = gson.fromJson(travelInOut, String[].class);
        if (travelInOutArr.length > 0) {
            travelInOutMap.put("travelInOutId", travelInOutArr[0]);
            if ("100000".equals(travelInOutArr[0])) {
                travelInOutMap.put("travelInOutName", "出境游");
            } else if ("200000".equals(travelInOutArr[0])) {
                travelInOutMap.put("travelInOutName", "国内游");
            }
            list.add(travelInOutMap);
        } else {
            travelInOutMap.put("travelInOutId", "");
            travelInOutMap.put("travelInOutName", "");
            list.add(travelInOutMap);
        }

        Map travelIdResultMap = new LinkedHashMap();
        String[] travelIdArr = gson.fromJson(travelId, String[].class);
        List travelIdList = new ArrayList();
        if (travelIdArr.length > 0) {
            for (int i = 0; i < travelIdArr.length; i++) {
                Map travelIdMap = new LinkedHashMap();
                String travelIdStr = travelIdArr[i];
                travelIdMap.put("travelId", travelIdStr);
                travelIdMap.put("travelName", "");
                travelIdList.add(travelIdMap);
            }
        }
        travelIdResultMap.put("travelList", travelIdList);
        list.add(travelIdResultMap);

        resultMap.put("travelSelected", list);

        Map results = new HashMap();
        results.put("results", resultMap);
        System.out.println(gson.toJson(results));
    }
}
