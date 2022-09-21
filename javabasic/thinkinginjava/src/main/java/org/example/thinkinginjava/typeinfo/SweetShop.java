package org.example.thinkinginjava.typeinfo;

import static org.example.thinkinginjava.util.Print.print;

/**
 * Created by Zong on 2016/9/19.
 */
class Candy {
    static {
        print("Loading Candy");
    }
}

class Gum {
    static {
        print("Loading Gum");
    }
}

class Cookie {
    static {
        print("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        print("inside main");
        new Candy();
        print("After creating Candy");
        try {
            Class.forName("org.example.thinkinginjava.typeinfo.Gum");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"Gum\")");
        new Cookie();
        print("After creating Cookie");
    }
}
