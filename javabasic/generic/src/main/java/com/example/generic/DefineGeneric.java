package com.example.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zong on 2017/4/12.
 * http://weibo.com/ttarticle/p/show?id=2309404090994130863880
 */
public class DefineGeneric {

    @Test
    public void testClassGeneric() {
        ClassGeneric<String> cg = new ClassGeneric<String>();
        cg.setField("zong");
        System.out.println(cg.getField());
    }

    @Test
    public void testMethodWithNoParam() {
        MethodWithNoParam mwnp = new MethodWithNoParam();
        List<String> list = mwnp.newArrayList();
        list.add("zong");
        list.add("mo");
//        list.add(1); // 报错，只能添加String
        for (String str : list) {
            System.out.println(str);
        }
    }

    @Test
    public void testMethodWithParam() {
        MethodWithParam mwp = new MethodWithParam();
        mwp.showClass("123");
        mwp.showClass(123);
    }

    @Test
    public void testWildCard() {
        WildCard wc = new WildCard();
        List<String> listStr = new ArrayList<String>();
        listStr.add("abc");
        wc.show(listStr);
        List<Long> listLong = new ArrayList<Long>();
        listLong.add(123L);
        wc.show(listLong);

        wc.showClass(123);
        wc.showClass(123f);
        wc.showClass(123L);
//        wc.showClass("123"); // 报错，参数的类型只能是Number或者其子类型


    }
}

/**
 * 类定义时，使用泛型
 * 在定义类的时候，可以使用泛型。
 * 类名后面增加，说明是泛型类。T可以视为类型的占位符。泛型类的代码就可以使用这个占位符T。
 *
 * @param <T>
 */
class ClassGeneric<T> {
    T field;

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }
}

/**
 * 无参数方法定义时，使用泛型
 * 无论在泛型类，还是普通类中，我们都可以在方法中使用泛型。
 * 方法的返回值前面，修饰符后面增加，表示为泛型方法。这样，就可以在方法的代码中使用T代表类型。
 * 没有参数的泛型方法，类型的确定，是根据等号左边的类型推导泛型的最终类型。
 */
class MethodWithNoParam {
    public <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }
}

/**
 * 有参数方法定义时，使用泛型
 * 有参数的泛型方法，类型的确定，是根据参数类型自动推导。
 */
class MethodWithParam {
    public <T> void showClass(T t) {
        System.out.println(t.getClass());
    }
}

class WildCard {
    /**
     * 方法定义时，使用通配符 ？
     * 1、只能往集合中add null。
     * 2、因为集合中的类型不确定。因此，为了安全，转换为Object。
     *
     * @param list
     */
    public void show(List<?> list) {
        list.add(null);
//        list.add(123); // 编译错误
        for (Object object : list) {
            System.out.println(object);
        }
    }

    /**
     * 类或者方法定义时，使用通配符
     * 表示传入的类型必须是Number或者其子类型。
     *
     * @param t
     * @param <T>
     */
    public <T extends Number> void showClass(T t) {
        System.out.println(t.getClass());
    }
}


