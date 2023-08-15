package com.example.json.importnew;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zong on 2017/3/23.
 * <p>
 * 参考文章
 * http://www.importnew.com/23862.html
 */
public class GsonTest {

    Gson gson = new Gson();

    /**
     * 属性重命名 @SerializedName 注解的使用
     */
    @Test
    public void testSerializedName() {
        String s = "{\"name\":\"宗\",\"age\":24,\"email_address\":\"ikidou@example.com\"}";
        User user = gson.fromJson(s, User.class);
        System.out.println(user);
    }

    /**
     * Gson中使用泛型
     */
    @Test
    public void testGeneric() {
        String str = "[\"Android\",\"Java\",\"PHP\"]";
        System.out.println("原始数据" + str);

        String[] strArr = gson.fromJson(str, String[].class);
        System.out.println("===转成数组===");
        for (String s : strArr) {
            System.out.println(s);
        }

        // 对于List将上面的代码中的 String[].class 直接改为 List<String>.class 是行不通的。
        // 对于Java来说List<String> 和List<User> 这俩个的字节码文件只一个那就是List.class，
        // 这是Java泛型使用时要注意的问题 - 泛型擦除。
        // 为了解决的上面的问题，Gson为我们提供了TypeToken来实现对泛型的支持
        List<String> strList = gson.fromJson(str, new TypeToken<List<String>>() {
        }.getType());
        System.out.println("===转成List===");
        for (String s : strList) {
            System.out.println(s);
        }
        // 注：TypeToken的构造方法是protected修饰的,
        // 所以上面才会写成new TypeToken<List<String>>() {}.getType()
        // 而不是 new TypeToken<List<String>>().getType()
    }

    /**
     * Gson的流式反序列化
     *
     * @throws IOException
     */
    @Test
    public void testJsonReader() throws IOException {
        String json = "{\"name\":\"宗\",\"age\":\"24\",\"email\":\"zong@gmail.com\"}";
        User user = new User();
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginObject();
        while (reader.hasNext()) {
            String s = reader.nextName();
            switch (s) {
                case "name":
                    user.setName(reader.nextString());
                    break;
                case "age":
                    user.setAge(reader.nextInt());
                    break;
                case "email":
                    user.setEmailAddress(reader.nextString());
                    break;
                default:
                    break;
            }
        }
        reader.endObject();
        System.out.println(user);
    }

    /**
     * Gson的流式序列化
     */
    @Test
    public void testJsonWrite() throws IOException {
        User user = new User("zong", 30, "zong@163");
        gson.toJson(user, System.out);

        JsonWriter writer = new JsonWriter(new OutputStreamWriter(System.out, "UTF-8"));
        writer.beginObject()
                .name("name").value("zong")
                .name("age").value(22)
                .name("email").nullValue()
                .endObject();
        writer.flush();
    }

    /**
     * 使用GsonBuilder导出null值、格式化输出、日期时间
     */
    @Test
    public void testGsonBuilder() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        User user = new User("mo", 1);
        System.out.println(gson.toJson(user));

        gson = new GsonBuilder()
                // 序列化null
                .serializeNulls()
                // 设置日期时间格式，另有2个重载方法
                // 在序列化和反序化时均生效
                .setDateFormat("yyyy-MM-dd")
                // 禁此序列化内部类
                .disableInnerClassSerialization()
                // 生成不可执行的Json（多了 )]}' 这4个字符）
                .generateNonExecutableJson()
                // 禁止转义html标签
                .disableHtmlEscaping()
                // 格式化输出
                .setPrettyPrinting()
                .create();
        Date date = new Date();
        System.out.println(date);
        System.out.println(gson.toJson(date));
    }

    /**
     * 字段过滤的几种方法
     * 1. 基于@Expose注解，该注解必须和GsonBuilder配合使用。
     * 2. 基于版本：Gson在对基于版本的字段导出提供了两个注解 @Since 和 @Until,和GsonBuilder.setVersion(Double)配合使用。
     * 3. 基于访问修饰符
     * 4. 基于策略（自定义规则）
     */
    @Test
    public void testExpose() {
        Category category = generateCategory();

        System.out.println("===基于@Expose注解===");
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println(gson.toJson(category));

        System.out.println("===基于版本===");
        SinceUntilSample sinceUntilSample = new SinceUntilSample();
        sinceUntilSample.since = "since";
        sinceUntilSample.until = "until";
        gson = new GsonBuilder().setVersion(4).create();
        System.out.println(gson.toJson(sinceUntilSample));
        // 当version <4时，结果：{"until":"until"}
        // 当version >=4 && version <5时，结果：{"since":"since","until":"until"}
        // 当version >=5时，结果：{"since":"since"}

        System.out.println("===基于访问修饰符===");
        ModifierSample modifierSample = new ModifierSample();
        gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.STATIC, Modifier.PRIVATE)
                .create();
        System.out.println(gson.toJson(modifierSample));

        System.out.println("===基于策略（自定义规则）===");
        gson = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                // 这里作判断，决定要不要排除该字段,return true为排除
                if ("finalField".equals(fieldAttributes.getName())) {
                    return true; //按字段名排除
                }
                Expose expose = fieldAttributes.getAnnotation(Expose.class);
                if (expose != null && expose.deserialize() == false) {
                    return true; //按注解排除
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                // 直接排除某个类 ，return true为排除
                return (clazz == int.class || clazz == Integer.class);
            }
        }).create();

    }

    public Category generateCategory() {
        Category category = new Category();
        category.id = 1;
        category.name = "电脑";

        List<Category> list = new ArrayList<Category>();
        Category c1 = new Category();
        c1.id = 100;
        c1.name = "笔记本";
        list.add(c1);
        Category c2 = new Category();
        c2.id = 101;
        c2.name = "台式机";
        list.add(c2);
        category.children = list;

        Category parent = new Category();
        parent.id = 001;
        parent.name = "3";
        category.parent = parent;

        return category;
    }

    /**
     * POJO与JSON的字段映射规则
     */
    @Test
    public void testFieldNaming() {
        // 默认实现
        User user = new User("zong", 30, "zong@163");
        user.setFamilyAddress("北京");
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        System.out.println(gson.toJson(user)); // {"name":"zong","age":30,"emailAddress":"zong@163","family_address":"北京"}

        // 自定义实现
        gson = new GsonBuilder().setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                // 实现自己的规则
                return field.getName().toUpperCase();
            }
        }).create();
        System.out.println(gson.toJson(user)); // {"NAME":"zong","AGE":30,"emailAddress":"zong@163","FAMILYADDRESS":"北京"}
    }

    /**
     * TypeAdapter
     * 注意：TypeAdapter 以及 JsonSerializer 和 JsonDeserializer
     * 都需要与 GsonBuilder.registerTypeAdapter 或GsonBuilder.registerTypeHierarchyAdapter配合使用
     */
    @Test
    public void testTypeAdapter() {
        User user = new User("zong", 30, "zong@163.com");
        gson = new GsonBuilder()
                .registerTypeAdapter(User.class, new UserTypeAdapter())
                .create();
        System.out.println(gson.toJson(user));

        gson = new GsonBuilder().registerTypeAdapter(Integer.class, new TypeAdapter<Integer>() {
            @Override
            public void write(JsonWriter out, Integer value) throws IOException {
                out.value(String.valueOf(value));
            }

            @Override
            public Integer read(JsonReader in) throws IOException {
                try {
                    return Integer.parseInt(in.nextString());
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
        }).create();
        System.out.println(gson.toJson(100)); // 100
        System.out.println(gson.fromJson("\"\"", Integer.class)); // -1
    }

    @Test
    public void testJsonSerializer() {
        gson = new GsonBuilder().registerTypeAdapter(Integer.class, new JsonDeserializer<Integer>() {
            @Override
            public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                try {
                    return json.getAsInt();
                } catch (Exception e) {
                    return -1;
                }
            }
        }).create();
        System.out.println(gson.toJson(100)); // 100
        System.out.println(gson.fromJson("\"\"", Integer.class)); // -1

        JsonSerializer<Number> numberJsonSerializer = new JsonSerializer<Number>() {
            @Override
            public JsonElement serialize(Number src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(String.valueOf(src));
            }
        };
        gson = new GsonBuilder()
                .registerTypeAdapter(Integer.class, numberJsonSerializer)
                .registerTypeAdapter(Long.class, numberJsonSerializer)
                .registerTypeAdapter(Float.class, numberJsonSerializer)
                .registerTypeAdapter(Double.class, numberJsonSerializer)
                .create();
        System.out.println(gson.toJson(100.0f)); // "100.0"

        Type type = new TypeToken<List<User>>() {
        }.getType();
        TypeAdapter typeAdapter = new TypeAdapter<List<User>>() {
            @Override
            public void write(JsonWriter out, List<User> value) throws IOException {

            }

            @Override
            public List<User> read(JsonReader in) throws IOException {
                return null;
            }
        };
        gson = new GsonBuilder()
                .registerTypeAdapter(type, typeAdapter)
                .create();
        List<User> list = new ArrayList<>();
        list.add(new User("a", 11));
        list.add(new User("b", 22));
        // 注意，多了个type参数
        String result = gson.toJson(list, type);
    }

    /**
     * TypeAdapterFactory
     */
    @Test
    public void testTypeAdapterFactory() {
        gson = new GsonBuilder()
                .registerTypeAdapterFactory(new TypeAdapterFactory() {
                    @Override
                    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
                        return null;
                    }
                })
                .create();
    }

    /**
     * @JsonAdapter注解
     */
    @Test
    public void testJsonAdapter() {
        gson = new Gson();
        User user = new User("zong", 30, "zong@163.com");
        System.out.println(gson.toJson(user));
    }

}
