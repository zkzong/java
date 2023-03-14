package org.example.interfaces;

/**
 * Created by Zong on 2016/7/23.
 */
class Father {
    public int strong() {
        return 9;
    }
}

class Mother {
    public int kind() {
        return 8;
    }
}

public class Son {

    class Father_1 extends Father {
        @Override
        public int strong() {
            return super.strong() + 1;
        }
    }

    class Mother_1 extends Mother {
        @Override
        public int kind() {
            return super.kind() - 2;
        }
    }

    public int getStrong() {
        return new Father_1().strong();
    }

    public int getKind() {
        return new Mother_1().kind();
    }
}
