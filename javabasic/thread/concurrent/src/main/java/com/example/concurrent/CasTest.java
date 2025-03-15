//package com.example.concurrent;
//
/// **
// * @Author: zongz
// * @Date: 2024/4/16
// */
//public class CasTest {
//    private volatile int a;
//
//    public static void main(String[] args) {
//        CasTest casTest = new CasTest();
//        new Thread(() -> {
//            for (int i = 1; i < 5; i++) {
//                casTest.increment(i);
//                System.out.print(casTest.a + " ");
//            }
//        }).start();
//        new Thread(() -> {
//            for (int i = 5; i < 10; i++) {
//                casTest.increment(i);
//                System.out.print(casTest.a + " ");
//            }
//        }).start();
//    }
//
//    private void increment(int x) {
//        while (true) {
//            try {
//                long fieldOffset = unsafe.objectFieldOffset(CasTest.class.getDeclaredField("a"));
//                if (unsafe.compareAndSwapInt(this, fieldOffset, x - 1, x))
//                    break;
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
