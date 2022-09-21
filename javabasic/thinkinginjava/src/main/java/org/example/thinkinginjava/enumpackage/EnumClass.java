package org.example.thinkinginjava.enumpackage;

import static org.example.thinkinginjava.util.Print.print;
import static org.example.thinkinginjava.util.Print.printnb;

/**
 * Created by zong on 2016/8/25.
 */
enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            print(s + " ordinal: " + s.ordinal());
            printnb(s.compareTo(Shrubbery.CRAWLING) + " ");
            printnb(s.equals(Shrubbery.CRAWLING) + " ");
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass());
            print(s.name());
            print("----------------------------");
        }

        // name()方法返回enum实例声明时的名字，这与使用toString()方法效果相同。

        // Produce an enum value from a string name:
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            print(shrub);
        }
    }
}
