package org.example.json.importnew;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by zong on 2017/3/23.
 */
public class Category {
    @Expose
    public int id;
    @Expose
    public String name;
    @Expose
    public List<Category> children;
    // 不需要序列化,所以不加 @Expose 注解，
    // 等价于 @Expose(deserialize = false,serialize = false)
    public Category parent;
}
