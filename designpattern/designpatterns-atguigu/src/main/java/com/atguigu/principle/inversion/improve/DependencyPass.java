package com.atguigu.principle.inversion.improve;

public class DependencyPass {
    public static void main(String[] args) {
        ChangHong changHong = new ChangHong();
        //OpenAndClose openAndClose = new OpenAndClose();
        //openAndClose.open(changHong);

        //OpenAndClose openAndClose = new OpenAndClose(changHong);
        //openAndClose.open();

        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.setTv(changHong);
        openAndClose.open();
    }
}

//// 方式1：通过接口传递实现依赖
//// 开关的接口
//interface IOpenAndClose {
//    // 抽象方法，接收接口
//    public void open(ITV tv);
//}
//
//// ITV接口
//interface ITV {
//    public void play();
//}
//
//class ChangHong implements ITV {
//
//    @Override
//    public void play() {
//        System.out.println("长虹电视机，打开");
//    }
//}
//
//// 实现接口
//class OpenAndClose implements IOpenAndClose {
//
//    @Override
//    public void open(ITV tv) {
//        tv.play();
//    }
//}

//// 方式2：通过构造方法依赖传递
//interface IOpenAndClose {
//    // 抽象方法
//    public void open();
//}
//
//// ITV接口
//interface ITV {
//    public void play();
//}
//
//class ChangHong implements ITV {
//
//    @Override
//    public void play() {
//        System.out.println("长虹电视机，打开");
//    }
//}
//
//// 实现接口
//class OpenAndClose implements IOpenAndClose {
//
//    // 成员
//    public ITV tv;
//
//    // 构造器
//    public OpenAndClose(ITV tv) {
//        this.tv = tv;
//    }
//
//    @Override
//    public void open() {
//        tv.play();
//    }
//}

//方式3，通过setter方法传递
interface IOpenAndClose {
    public void open(); // 抽象方法

    public void setTv(ITV tv);
}

// ITV接口
interface ITV {
    public void play();
}

class ChangHong implements ITV {

    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}

class OpenAndClose implements IOpenAndClose {

    private ITV tv;

    @Override
    public void open() {
        this.tv.play();
    }

    @Override
    public void setTv(ITV tv) {
        this.tv = tv;
    }
}