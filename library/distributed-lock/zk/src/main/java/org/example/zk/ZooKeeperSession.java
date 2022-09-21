//package org.example.zk;
//
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.WatchedEvent;
//import org.apache.zookeeper.Watcher;
//import org.apache.zookeeper.ZooDefs;
//import org.apache.zookeeper.ZooKeeper;
//import org.apache.zookeeper.data.Stat;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.TimeUnit;
//
///**
// * ZooKeeperSession
// *
// * @Author: zong
// * @Date: 2021/3/1
// */
//public class ZooKeeperSession {
//
//    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
//    private ZooKeeper zookeeper;
//    private CountDownLatch latch;
//
//    public ZooKeeperSession() {
//        try {
//            this.zookeeper = new
//                    ZooKeeper("192.168.31.187:2181,192.168.31.19:2181,192.168.31.227:2181", 50000, new
//                    ZooKeeperWatcher());
//            try {
//                connectedSemaphore.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("ZooKeeper session established......");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 获取分布式锁
//     *
//     * @param productId
//     */
//    public Boolean acquireDistributedLock(Long productId) {
//        String path = "/product-lock-" + productId;
//        try {
//            zookeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
//                    CreateMode.EPHEMERAL);
//            return true;
//        } catch (Exception e) {
//            while (true) {
//                try {
//                    // 相当于是给 node 注册一个***，去看看这个***是否存在
//                    Stat stat = zk.exists(path, true);
//                    if (stat != null) {
//                        this.latch = new CountDownLatch(1);
//                        this.latch.await(waitTime, TimeUnit.MILLISECONDS);
//                        this.latch = null;
//                    }
//                    zookeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
//                            CreateMode.EPHEMERAL);
//                    return true;
//                } catch (Exception ee) {
//                    continue;
//                }
//            }
//        }
//        return true;
//    }
//
//    /**
//     * 释放掉一个分布式锁
//     *
//     * @param productId
//     */
//    public void releaseDistributedLock(Long productId) {
//        String path = "/product-lock-" + productId;
//        try {
//            zookeeper.delete(path, -1);
//            System.out.println("release the lock for product[id=" + productId +
//                    "]......");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 建立 zk session 的 watcher
//     *
//     * @Author: zong
//     * @Date: 2021/3/1
//     */
//    private class ZooKeeperWatcher implements Watcher {
//        @Override
//        public void process(WatchedEvent event) {
//            System.out.println("Receive watched event: " + event.getState());
//            if (Event.KeeperState.SyncConnected == event.getState()) {
//                connectedSemaphore.countDown();
//            }
//            if (this.latch != null) {
//                this.latch.countDown();
//            }
//        }
//    }
//
//    /**
//     * 封装单例的静态内部类
//     *
//     * @author bingo
//     * @since 2018/11/29
//     */
//    private static class Singleton {
//        private static ZooKeeperSession instance;
//
//        static {
//            instance = new ZooKeeperSession();
//        }
//
//        public static ZooKeeperSession getInstance() {
//            return instance;
//        }
//    }
//
//    /**
//     * 获取单例
//     *
//     * @return
//     */
//    public static ZooKeeperSession getInstance() {
//        return Singleton.getInstance();
//    }
//
//    /**
//     * 初始化单例的便捷方法
//     */
//    public static void init() {
//        getInstance();
//    }
//}
