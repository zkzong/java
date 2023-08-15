package com.example.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Zong on 2016/8/11.
 */
public class Json2OthersTest {

    @Test
    public void parseArray() {
        String str = "[{\"id\":1,\"name\":\"zong\"},{\"id\":2,\"name\":\"liu\"},{\"id\":3,\"name\":\"ma\"}]";

        System.out.println("转换成List<User>对象");
        List<User> users = JSON.parseArray(str, User.class);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println("id:" + user.getId() + ", name:" + user.getName());
        }

        List userList = JSON.parseArray(str);

        System.out.println("转换成List<Map>");
        for (int i = 0; i < userList.size(); i++) {
            Map map = (Map) userList.get(i);
            System.out.println("id:" + map.get("id") + ", name:" + map.get("name"));
        }

        System.out.println("转换成List<JSONObject>");
        for (int i = 0; i < userList.size(); i++) {
            JSONObject jsonObject = (JSONObject) userList.get(i);
            System.out.println("id:" + jsonObject.get("id") + ", name:" + jsonObject.get("name"));
        }

        System.out.println("转换成数组");
        String strArr = "[\"zong\", \"liu\", \"ma\"]";
        JSONArray jsonArray = JSON.parseArray(strArr);
        for (int i = 0; i < jsonArray.size(); i++) {
            String o = (String) jsonArray.get(i);
            System.out.println(o);
        }
    }

    @Test
    public void json2Map() {
        String s = "{\"id\":1, \"name\":\"zong\"}";
        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();

        try {
//            map = mapper.readValue(s, new TypeReference(){});
//            System.out.println(map);
            JSONObject jasonObject = JSONObject.parseObject(s);
            map = (Map) jasonObject;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println("key=" + entry.getKey() + " and value=" + entry.getValue());
            }
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void json2Other() {
        String s = "{\"jumpType\":\"1\", \"travelSelected\":{\"travelArea\":[1,2], \"travelInOut\":[\"100000\"], \"travelId\":[]}, \"tabText\":\"\"}";
        JSONObject jsonObject = JSON.parseObject(s);

        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        String jumpType = jsonObject.get("jumpType").toString(); // 跳转类型
        resultMap.put("jumpType", jumpType);
        String tabText = jsonObject.get("tabText").toString(); // 搜索内容
        resultMap.put("tabText", tabText);

        // 选择条件
        String travelSelected = jsonObject.get("travelSelected").toString();
        Map m = JSON.parseObject(travelSelected);
        String travelArea = m.get("travelArea").toString();
        String travelInOut = m.get("travelInOut").toString();
        String travelId = m.get("travelId").toString();

        List list = new LinkedList();

        // 区域
        Map travelAreaMap = new LinkedHashMap();
        JSONArray travelAreas = JSON.parseArray(travelArea);
        if (travelAreas.size() > 0) {
            travelAreaMap.put("travelAreaId", travelAreas.get(0));
//            Area area = areaService.get(Long.parseLong(travelAreaArr[0]));
            travelAreaMap.put("travelAreaName", "zong");
            list.add(travelAreaMap);
        } else {
            travelAreaMap.put("travelAreaId", "");
            travelAreaMap.put("travelAreaName", "");
            list.add(travelAreaMap);
        }

        // 出境游/国内游
        Map travelInOutMap = new LinkedHashMap();
        JSONArray travelInOuts = JSON.parseArray(travelInOut);
        if (travelInOuts.size() > 0) {
            travelInOutMap.put("travelInOutId", travelInOuts.get(0));
            if ("100000".equals(travelInOuts.get(0))) {
                travelInOutMap.put("travelInOutName", "出境游");
            } else if ("200000".equals(travelInOuts.get(0))) {
                travelInOutMap.put("travelInOutName", "国内游");
            }
            list.add(travelInOutMap);
        } else {
            travelInOutMap.put("travelInOutId", "");
            travelInOutMap.put("travelInOutName", "");
            list.add(travelInOutMap);
        }

        // 供应商
        Map travelIdResultMap = new LinkedHashMap();
        JSONArray travelIds = JSON.parseArray(travelId);
        List travelIdList = new ArrayList();
        if (travelIds.size() > 0) {
            for (int i = 0; i < travelIds.size(); i++) {
                Map travelIdMap = new LinkedHashMap();
                String travelIdStr = travelIds.get(i).toString();
                travelIdMap.put("travelId", travelIdStr);
//                Office office = officeService.get(Long.parseLong(travelIdStr));
                travelIdMap.put("travelName", "lldldl");
                travelIdList.add(travelIdMap);
            }
        }
        travelIdResultMap.put("travelList", travelIdList);
        list.add(travelIdResultMap);

        resultMap.put("travelSelected", list);

        // 返回结果Map
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("results", resultMap);
        // 转换成json
        String json = JSON.toJSONString(results);
        System.out.println(json);
    }

    @Test
    public void tt() {
        String ss = "id=" + "1" + ",name=" + "zong";
        System.out.println(JSON.toJSONString(ss));
    }

    /**
     * 泛型
     */
    @Test
    public void resp() {
        Resp<User> resp = new Resp<>();
        resp.setCode("0000");
        resp.setMsg("S");
        User user = new User();
        user.setId(1L);
        user.setName("zong");
        resp.setData(user);

        String s = JSON.toJSONString(resp);

        Resp r = JSON.parseObject(s, Resp.class);
        System.out.println(r);
        Resp<User> rr = JSON.parseObject(s, new TypeReference<Resp<User>>() {});
        System.out.println(rr);

    }


    @Test
    public void aa() {
        Resp<A> resp = new Resp<>();
        resp.setCode("0000");
        resp.setMsg("S");
        A a = new A();
        a.setBalance(new BigDecimal("1111"));
        resp.setData(a);


        Resp r = resp;


        Map<String, Object> map = (Map<String, Object>) r.getData();
        Object balance = map.get("balance");
        System.out.println(balance);

        //System.out.println(JSON.toJSONString(resp));
        //
        //String s = JSON.toJSONString(resp.getData());
        //JSONObject jsonObject = JSONObject.parseObject(s);
        //BigDecimal balance = jsonObject.getBigDecimal("balance");
        //System.out.println(balance);


    }

    @Data
    @ToString
    class A {
        private BigDecimal balance;
    }

}
