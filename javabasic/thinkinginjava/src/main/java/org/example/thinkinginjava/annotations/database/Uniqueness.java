package org.example.thinkinginjava.annotations.database;

/**
 * Created by Zong on 2016/9/18.
 * 嵌套注解--修改默认值
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
