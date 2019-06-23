package com.zkzong.thread;

import java.util.ArrayList;
import java.util.List;

class UserSendThread implements Runnable {
    private List<UserEntity> listUser;

    public UserSendThread(List<UserEntity> listUser) {
        this.listUser = listUser;
    }

    @Override
    public void run() {
        for (UserEntity userEntity : listUser) {
            System.out.println(Thread.currentThread().getName() + "," + userEntity.toString());
        }
        System.out.println();
    }
}

public class BatchSms {

    public static void main(String[] args) {
        // 1.初始化数据
        List<UserEntity> initUser = initUser();
        // 2.定义每个线程分批发送大小
        int userCount = 2;
        // 3.计算每个线需要分配跑的数据
        List<List<UserEntity>> splitList = ListUtils.splitList(initUser, userCount);
        for (int i = 0; i < splitList.size(); i++) {
            List<UserEntity> list = splitList.get(i);
            UserSendThread userSendThread = new UserSendThread(list);
            // 4.分配发送
            Thread thread = new Thread(userSendThread, "线程" + i);
            thread.start();
        }

    }

    static private List<UserEntity> initUser() {
        List<UserEntity> list = new ArrayList<UserEntity>();
        for (int i = 1; i <= 11; i++) {
            list.add(new UserEntity("userId:" + i, "userName:" + i));
        }
        return list;
    }

}
