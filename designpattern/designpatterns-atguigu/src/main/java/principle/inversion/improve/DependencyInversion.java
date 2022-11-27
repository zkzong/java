package principle.inversion.improve;

public class DependencyInversion {
    public static void main(String[] args) {
        // 客户端无需改变
        Person person = new Person();
        person.receive(new Email());

        person.receive(new WeiXin());
    }
}

// 定义接口
interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件信息：hello, world";
    }
}

class WeiXin implements IReceiver {

    @Override
    public String getInfo() {
        return "微信信息：hello, world";
    }
}

// 方式2
class Person {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
