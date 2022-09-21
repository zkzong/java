package org.example.call;

/**
 * @Author: zong
 * @Date: 2022/1/9
 */
public class CallByValue2 {
    private static User user = null;

    public static void updateUser(User student) {
        student.setName("Lishen");
        student.setAge(18);
    }


    public static void main(String[] args) {
        user = new User("zhangsan", 26);
        System.out.println("调用前user的值：" + user.toString());
        updateUser(user);
        System.out.println("调用后user的值：" + user.toString());
    }

    //调用前user的值：User(name=zhangsan, age=26)
    //调用后user的值：User(name=Lishen, age=18)
}

