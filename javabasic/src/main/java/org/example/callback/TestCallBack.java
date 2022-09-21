package org.example.callback;

/**
 * Created by Zong on 2016/7/29.
 */
public class TestCallBack {
    public void compute(int n, ComputeCallBack callBack) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
        callBack.onComputeEnd();
    }
}
