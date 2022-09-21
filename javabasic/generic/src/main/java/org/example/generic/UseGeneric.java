package org.example.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Zong on 2017/4/12.
 */
public class UseGeneric {
    /**
     * 指定固定的类型
     * 对于泛型来说，Long是Number的子类。但是，List<Number>并不是List<Long>的子类。
     */
    @Test
    public void specifyType() {
        List<Long> list = new ArrayList<Long>();
//        List<Number> list = new ArrayList<Long>(); // 编译错误
    }

    /**
     * 使用通配符 ？
     * 1、只能添加null。
     * 2、获取的值只能赋值给Object类型。
     */
    @Test
    public void testWildCard() {
        List<?> list = new ArrayList<Fruit>();
//        list.add(new Food()); // 编译错误
//        list.add(new Fruit()); // 编译错误
//        list.add(new Apple()); // 编译错误
        list.add(null);
//        Food food = list.get(0);
//        Fruit fruit = list.get(0);
//        Apple apple = list.get(0);
        Object obj = list.get(0);
    }

    /**
     * 使用上界通配符
     * 上界通配符，一般用于读取的场景。
     * 1、为泛型指定的类型只能是Fruit类型或者其子类。
     * 2、只能为其列表添加null。
     * 3、get方法获取的值只能赋值给Fruit类或者其超类。
     */
    @Test
    public void upWildCard() {
        List<? extends Fruit> list = new ArrayList<Fruit>();
        list.add(null);
//        list.add(new Fruit());  // 编译错误
//        list.add(new Apple()); // 编译错误

//        List<? extends Fruit> list2 = new ArrayList<Food>(); // 编译错误

        List<? extends Fruit> list3 = new ArrayList<Apple>();
        Fruit fruit = list3.get(0);
        Food food = list3.get(0);
//        Apple apple = list3.get(0); // 编译错误，get方法获取的值只能赋值给Fruit类或者其超类
        list3.remove(0);

    }

    /**
     * 使用下界通配符
     * 下界通配符，一般用于写入的场景。
     * 1、为泛型指定的类型必须为Fruit，或者其超类。
     * 2、可以为其列表添加任意Fruit类型，或者其子类。
     * 3、get方法获取的类型，只能赋值给Object类型。
     */
    @Test
    public void downWildCard() {
        List<? super Fruit> list = new ArrayList<Fruit>();
        List<? super Fruit> listA = new ArrayList<Food>();
//        List<? super Fruit> listN = new ArrayList<Apple>(); // 编译错误
        listA.add(new Fruit());
//        listA.add(new Food()); // 编译错误，不能为父类
        listA.add(new Apple());
        Object object = listA.get(0);
//        Fruit fruit = list.get(0); // 编译错误
//        Food food = list.get(0); // 编译错误
//        Apple apple = list.get(0); // 编译错误
    }

    /**
     * 泛型类型是被所有调用共享的
     * 所有泛型类的实例都共享同一个运行时类，类型参数信息会在编译时被擦除。
     * 因此考虑如下代码，虽然ArrayList和ArrayList类型参数不同，但是他们都共享ArrayList类，所以结果会是true。
     */
    @Test
    public void share() {
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass() == l2.getClass());
    }

    /**
     * instanceof
     * 不能对确切的泛型类型使用instanceOf操作。
     * 如下面的操作是非法的，编译时会出错。
     */
    public void instanceofTest() {
        Collection cs = new ArrayList<String>();
//        if (cs instanceof Collection<String>) { // 编译错误
//
//        }
    }

    /**
     * 泛型数组问题
     * 不能创建一个确切泛型类型的数组。
     * 能创建带通配符的泛型数组。
     */
    @Test
    public void array() {
//        List<String>[] lsa = new ArrayList<String>[10]; // 编译错误

        List<?>[] lsa = new ArrayList<?>[10];
    }

}

class Food {
}

class Fruit extends Food {
}

class Apple extends Fruit {
}

