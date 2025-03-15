package com.example.json;

import com.example.json.entity.AccountBean;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zong on 2017/2/25.
 * 将java对象转换成JSON字符串，也可以将JSON字符串转换成java对象
 */
public class JacksonTest {
    private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;
    private AccountBean bean = null;

    @Before
    public void init() {
        bean = new AccountBean();
        bean.setAddress("beijing");
        bean.setEmail("zong@163.com");
        bean.setId(1);
        bean.setName("zong");

        objectMapper = new ObjectMapper();
        try {
            jsonGenerator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory() {
        try {
            if (jsonGenerator != null) {
                jsonGenerator.flush();
            }
            if (!jsonGenerator.isClosed()) {
                jsonGenerator.close();
            }
            jsonGenerator = null;
            objectMapper = null;
            bean = null;
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将java对象转换成json字符串
     * <p>
     * 下面分别利用JsonGenerator的writeObject方法和ObjectMapper的writeValue方法完成对Java对象的转换，二者传递的参数及构造的方式不同；
     * JsonGenerator的创建依赖于ObjectMapper对象。也就是说如果要使用JsonGenerator来转换JSON，那么你必须创建一个ObjectMapper。
     * 但是用ObjectMapper来转换JSON，则不需要JSONGenerator。
     */
    @Test
    public void writeEntiryJSON() {
        try {
            System.out.println("jsonGenerator");
            // writeObject可以转换java对象，eg:JavaBean/Map/List/Array等
            jsonGenerator.writeObject(bean);
            System.out.println();

            System.out.println("ObjectMapper");
            // writeValue具有和writeObject相同的功能
            objectMapper.writeValue(System.out, bean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将map转换成json字符串
     */
    @Test
    public void writeMapJSON() {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", bean.getName());
            map.put("account", bean);
            bean = new AccountBean();
            bean.setAddress("beijing");
            bean.setEmail("zong@163.com");
            map.put("account2", bean);

            System.out.println("jsonGenerator");
            jsonGenerator.writeObject(map);
            System.out.println("");

            System.out.println("objectMapper");
            objectMapper.writeValue(System.out, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将list集合转换成json字符串
     */
    @Test
    public void writeListJSON() {
        try {
            List<AccountBean> list = new ArrayList<AccountBean>();
            list.add(bean);

            bean = new AccountBean();
            bean.setId(2);
            bean.setAddress("address2");
            bean.setEmail("email2");
            bean.setName("haha2");
            list.add(bean);

            System.out.println("jsonGenerator");
            // list转换成JSON字符串
            jsonGenerator.writeObject(list);
            System.out.println();
            System.out.println("ObjectMapper");
            // 用objectMapper直接返回list转换成的JSON字符串
            System.out.println("1###" + objectMapper.writeValueAsString(list));
            System.out.print("2###");
            // objectMapper list转换成JSON字符串
            objectMapper.writeValue(System.out, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeOthersJSON() {
        try {
            String[] arr = {"a", "b", "c"};
            System.out.println("jsonGenerator");
            String str = "hello world jackson!";
            // byte
            jsonGenerator.writeBinary(str.getBytes("UTF-8"));
            // boolean
            jsonGenerator.writeBoolean(true);
            // null
            jsonGenerator.writeNull();
            // float
            jsonGenerator.writeNumber(2.2f);
            // char
            jsonGenerator.writeRaw("c");
            // String
            jsonGenerator.writeRaw(str, 5, 10);
            // String
            jsonGenerator.writeRawValue(str, 5, 5);
            // String
            jsonGenerator.writeString(str);
            jsonGenerator.writeTree(JsonNodeFactory.instance.pojoNode(str));
            System.out.println();

            // Object
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectFieldStart("user");
            jsonGenerator.writeStringField("name", "jackson");
            jsonGenerator.writeBooleanField("sex", true);
            jsonGenerator.writeNumberField("age", 22);
            jsonGenerator.writeEndObject();

            jsonGenerator.writeArrayFieldStart("infos");
            jsonGenerator.writeNumber(22);
            jsonGenerator.writeString("this is array");
            jsonGenerator.writeEndArray();

            jsonGenerator.writeEndObject();

            AccountBean bean = new AccountBean();
            bean.setAddress("address");
            bean.setEmail("email");
            bean.setId(1);
            bean.setName("haha");
            //complex Object
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("user", bean);
            jsonGenerator.writeObjectField("infos", arr);
            jsonGenerator.writeEndObject();

//            {"user":{"name":"jackson","sex":true,"age":22},"infos":[22,"this is array"]} {"user":{"id":1,"name":"haha","email":"email","address":"address","birthday":null},"infos":["a","b","c"]}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将json字符串转换成JavaBean对象
     */
    @Test
    public void readJson2Entity() {
        String json = "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}";

        try {
            AccountBean acc = objectMapper.readValue(json, AccountBean.class);
            System.out.println(acc.getName());
            System.out.println(acc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将json字符串转换成List<Map>集合
     */
    @Test
    public void readJson2List() {
        String json = "[{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"}," +
                "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}]";
        try {
            List<Map<String, Object>> list = objectMapper.readValue(json, List.class);
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                Set<String> set = map.keySet();
                for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
                    String key = it.next();
                    System.out.println(key + ":" + map.get(key));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * json字符串转换成Array
     */
    @Test
    public void readJson2Array() {
        String json = "[{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"}," +
                "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}]";

        try {
            AccountBean[] arr = objectMapper.readValue(json, AccountBean[].class);
            System.out.println(arr.length);
            for (int i = 0; i < arr.length; i++) {
                AccountBean accountBean = arr[i];
                System.out.println(accountBean);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * json字符串转换Map集合
     */
    @Test
    public void readJson2Map() {
        String json = "{\"success\":true,\"A\":{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"}," +
                "\"B\":{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}}";
        try {
            Map<String, Map<String, Object>> maps = objectMapper.readValue(json, Map.class);
            System.out.println(maps.size());
            Set<String> key = maps.keySet();
            Iterator<String> iter = key.iterator();
            while (iter.hasNext()) {
                String field = iter.next();
                System.out.println(field + ":" + maps.get(field));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeObject2Xml() {
        System.out.println("XmlMapper");
        XmlMapper xml = new XmlMapper();

        try {
            // javaBean转换成xml
//            xml.writeValue(System.out, bean);
            StringWriter sw = new StringWriter();
            xml.writeValue(sw, bean);
            System.out.println(sw.toString());

            // List转换成xml
            List<AccountBean> list = new ArrayList<AccountBean>();
            list.add(bean);
            list.add(bean);
            System.out.println(xml.writeValueAsString(list));

            // Map转换xml文档
            Map<String, AccountBean> map = new HashMap<String, AccountBean>();
            map.put("A", bean);
            map.put("B", bean);
            System.out.println(xml.writeValueAsString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
