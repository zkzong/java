package com.example.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.example.json.entity.MapObj;
import com.example.json.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2016/8/11.
 */
public class Others2JsonTest {
    public static void main(String[] args) {
        User u1 = new User(1L, "zong");
        User u2 = new User(2L, "liu");
        User u3 = new User(3L, "ma");

        List<User> list = new ArrayList<User>();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        System.out.println("List转JSON");
        String jsonString = JSONArray.toJSONString(list);
        System.out.println(jsonString);
        jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);

        System.out.println("Map转JSON");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("name", "zong");
        System.out.println(JSON.toJSON(map));

        System.out.println("Array转JSON");
        String[] strArray = {"zong", "liu", "ma"};
        String s = JSON.toJSONString(strArray);
        System.out.println(s);

    }

    class Person {
        Long id;
        String name;
        String email;

        public Person(Long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    @Test
    public void null2Json() {
        Map m = new HashMap();
        m.put("null", null);
        // 默认属性值为null的字段不返回
        String jsonString = JSON.toJSONString(m);
        System.out.println(jsonString);

        // 属性值为null的字段返回，值为null
        jsonString = JSON.toJSONString(m, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNonStringValueAsString);
        System.out.println(jsonString);

        ValueFilter filter = new ValueFilter() {
            @Override
            public Object process(Object obj, String s, Object v) {
                if (v == null) {
                    return "";
                }
                return v;
            }
        };
        // 属性值为null的字段返回，值为""
        jsonString = JSON.toJSONString(m, filter);
        System.out.println(jsonString);

        Person person = new Person(1L, null, "zong@163.com");
        Map map = new HashMap();
        map.put("person", person);
        jsonString = JSON.toJSONString(person, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNonStringValueAsString);
        System.out.println(jsonString);

        System.out.println(JSON.toJSONString(map, filter));

    }

    @Test
    public void toJsonWithDate() {
        Map m = new HashMap();
        m.put("date", "1986-08-08");
        String jsonString = JSON.toJSONString(m);
        System.out.println(jsonString);

        String jsonStringWithDate = JSON.toJSONStringWithDateFormat(m, "yyyy-MM-dd");
        System.out.println(jsonStringWithDate);
    }

    @Test
    public void changeKey() {
        Map m = new HashMap();
        m.put("name", "zong");
        String s = JSON.toJSONString(m);
        System.out.println(s);

        NameFilter filter = new NameFilter() {
            @Override
            public String process(Object object, String name, Object value) {
                if ("name".equals(name)) {
                    name = "username";
                }
                return name;
            }
        };

        s = JSON.toJSONString(m, filter);
        System.out.println(s);
    }

    @Test
    public void mapObj() {
        // MapObj的Map加上get、set方法才能使用json
        MapObj mapObj = new MapObj();
        mapObj.setInfo("a", "a");
        mapObj.setInfo("b", "b");
        mapObj.setInfo("c", "c");
        mapObj.setInfo("d", "d");
        System.out.println(JSON.toJSONString(mapObj));

//        MapObj mo = new MapObj();
//        Map<String, String> map = mo.getMap();
//        map.put("a", "a");
//        map.put("b", "b");
//        map.put("c", "c");
//        map.put("d", "d");
//        System.out.println(JSON.toJSONString(mo));
    }

    @Test
    public void getJsonValue() {
        String s = "{\"statusCode\":\"000000\",\"templateSMS\":{\"smsMessageSid\":\"047a08c0e29a4432a63f8c96ce35ff90\",\"dateCreated\":\"20191231172901\"}}";

        JSONObject jsonObject = JSON.parseObject(s);
        Object statusCodeObj = jsonObject.get("statusCode");
        String statusCode = "";
        if (statusCodeObj != null) {
            statusCode = statusCodeObj.toString();
        }
        //if (ChannelResultEnum.CLOOPEN_SUBMIT_RESULT.getCode().equals(statusCode)) {
            Object templateSMSObj = jsonObject.get("templateSMS");
            if (statusCodeObj != null) {
                JSONObject template = JSON.parseObject(templateSMSObj.toString());
                Object smsMessageSidObj = template.get("smsMessageSid");
                if (smsMessageSidObj != null) {
                    String smsMessageSid = smsMessageSidObj.toString();
                    //sms.setBatchNo(smsMessageSid);
                    // 保存批次号
                    //smsMapper.updateByPrimaryKey(sms);
                }
            //}
        }


    }
}
