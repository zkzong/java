package com.zkzong.dubbo.zookeeper.e1;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by Zong on 2016/12/25.
 */
public class ZooKeeperClient {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        Watcher watcher = new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println("触发了" + watchedEvent.getType() + "事件！");
            }
        };

        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, watcher);

        zooKeeper.create("/RootNode", "RootNodeData".getBytes("UTF-8"), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("“/RootNode”节点状态：" + zooKeeper.exists("/RootNode", true));
        System.out.println("“RootNode”节点上数据：" + new String(zooKeeper.getData("/RootNode", false, null), "UTF-8"));

        zooKeeper.create("/RootNode/ChildNode1", "ChildNode1Data".getBytes("UTF-8"), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.create("/RootNode/ChildNode2", "ChildNode2Data".getBytes("UTF-8"), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("目录节点“RootNode”下的所有子目录节点有：" + zooKeeper.getChildren("/RootNode", true));

        zooKeeper.setData("/RootNode/ChildNode2", "NewChildNode2Data".getBytes("UTF-8"), -1);
        zooKeeper.delete("/RootNode/ChildNode1", -1);
        System.out.println("“/RootNode/ChildNode1”节点状态：" + zooKeeper.exists("/RootNode/ChildNode1", false));

        zooKeeper.delete("/RootNode/ChildNode2", -1);
        zooKeeper.delete("/RootNode", -1);
        zooKeeper.close();
    }
}
