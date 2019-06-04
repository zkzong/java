package com.zkzong.callback;

/**
 * Created by Zong on 2016/7/29.
 */
public class Main {
    public static void main(String[] args) {
        new TestCallBack().compute(1000, new ComputeCallBack() {
            @Override
            public void onComputeEnd() {
                System.out.println("end back!!!");
            }
        });
    }
}
