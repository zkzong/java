package org.example.test;

/**
 * Created by Zong on 2017/3/12.
 */
enum Gender {
    MALE(1, "男"),
    FEMALE(2, "女");

    private Integer code;
    private String sex;

    Gender(Integer code, String sex) {
        this.code = code;
        this.sex = sex;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Gender.MALE); // MALE
        System.out.println(Gender.MALE.ordinal()); // 0

        System.out.println(Gender.MALE.getCode()); // 1
        System.out.println(Gender.MALE.getSex()); // 男

        System.out.println("===遍历Enum===");
        for (Gender gender : Gender.values()) {
            System.out.println(gender.getCode() + " : " + gender.getSex());
        }
    }
}
