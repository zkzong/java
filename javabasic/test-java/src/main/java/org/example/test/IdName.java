package org.example.test;

/**
 * Created by Administrator on 2017/6/19.
 */
class Person {
    private Integer sex;
    private String sexName;

    public Person(Integer sex) {
        this.sex = sex;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexName() {
//        if (sex == 1) {
//            return  "男";
//        } else {
//            return  "女";
//        }
        return sexName;
    }

    public void setSexName(String sexName) {
        if (sex == 1) {
            this.sexName = "男";
        } else {
            this.sexName =  "女";
        }
//        this.sexName = sexName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "sex=" + sex +
                ", sexName='" + sexName + '\'' +
                '}';
    }
}

public class IdName {
    public static void main(String[] args) {
        Person p = new Person(1);
        p.setSexName("");
//        System.out.println(p.getSexName());
        System.out.println(p);
    }
}
