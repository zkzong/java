package com.kafka.action.chapter6.topic;

import kafka.admin.AdminUtils;
import kafka.admin.BrokerMetadata;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;
import scala.collection.JavaConverters;
import scala.collection.Map;
import scala.collection.Seq;

import java.util.*;
import java.util.Map.Entry;

/**
 * Description:主题API应用 <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class TopicManager {

    /**
     * 连接Zk
     */
    private static final String ZK_CONNECT = "server-1:2181,server-2:2181,server-3:2181";

    /**
     * session过期时间
     */
    private static final int SESSION_TIMEOUT = 30000;

    /**
     * 连接超时时间
     */
    private static final int CONNECT_TIMEOUT = 30000;

    /**
     * 主题名
     */
    private static final String TOPIC = "topic-api-test";

    /**
     * 创建主题
     *
     * @param topic      主题名
     * @param partition  分区数
     * @param repilca    副本数
     * @param properties topic级别的配置
     */
    public static void createTopic(String topic, int partition, int repilca,
                                   Properties properties) {
        ZkUtils zkUtils = null;
        try {
            // 实例化ZkUtils
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT,
                    CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            // 创建Topic
            if (!AdminUtils.topicExists(zkUtils, topic)) {
                AdminUtils.createTopic(zkUtils, topic, partition, repilca,
                        properties, AdminUtils.createTopic$default$6());
            } else {
                // TODO 做相应处理，如打印日志等
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkUtils.close();
        }
    }

    /**
     * 删除主题
     *
     * @param topic
     */
    public static void deleteTopic(String topic) {
        ZkUtils zkUtils = null;
        try {
            // 实例化ZkUtils,获取与Zookeeper的连接
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT,
                    CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            // 删除Topic
            AdminUtils.deleteTopic(zkUtils, topic);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkUtils.close();
        }
    }

    /**
     * 修改主题级别配置
     *
     * @param topic
     * @param properties
     */
    public static void modifyTopicConfig(String topic, Properties properties) {
        ZkUtils zkUtils = null;
        try {
            // 实例化ZkUtils,获取与Zookeeper的连接及实例化一个ZkClient对象
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT,
                    CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            // 首先获取当前的已有配置
            Properties curProp = AdminUtils.fetchEntityConfig(zkUtils,
                    ConfigType.Topic(), topic);
            // 添加新修改的配置
            curProp.putAll(properties);

            AdminUtils.changeTopicConfig(zkUtils, topic, curProp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkUtils.close();
        }
    }

    /**
     * 增加分区
     *
     * @param topic
     * @param partition
     * @param replicaAssignment
     */
    public static void addPartition(String topic, int partition,
                                    String replicaAssignment) {
        ZkUtils zkUtils = null;
        try {
            // 实例化ZkUtils,获取与Zookeeper的连接及实例化一个ZkClient对象
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT,
                    CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            // 增加分区
			/*AdminUtils.addPartitions(zkUtils, topic, partition,
					replicaAssignment, true,
					AdminUtils.addPartitions$default$6());*/
            // {"3:1", "2:1"}
            java.util.Map<Object, ArrayList<Object>> map = new HashMap<>();
            Map<Object, Seq<Object>> assignMap = JavaConverters.mapAsScalaMapConverter(map).asScala();
            String[] assignments = replicaAssignment.split(",");
            Map<Object, Seq<Object>> existingAssignment =
                    AdminUtils.addPartitions(zkUtils, topic, assignMap, null, partition, AdminUtils.addPartitions$default$6(), true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkUtils.close();
        }
    }

    /**
     * 增加副本
     */
    public static void addReplica() {
        ZkUtils zkUtils = null;
        try {
            // 1.实例化ZkUtils,获取与Zookeeper的连接及实例化一个ZkClient对象
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT,
                    CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            // 2.获取Broker元数据信息
            Seq<BrokerMetadata> brokerMeta = AdminUtils.getBrokerMetadatas(
                    zkUtils, AdminUtils.getBrokerMetadatas$default$2(),
                    AdminUtils.getBrokerMetadatas$default$3());
            // 3.生成分区副本分配方案
            Map<Object, Seq<Object>> replicaAssign = AdminUtils
                    .assignReplicasToBrokers(brokerMeta, 2, 3,
                            AdminUtils.assignReplicasToBrokers$default$4(),
                            AdminUtils.assignReplicasToBrokers$default$5());
            // 4.修改分区副本分配方案
            AdminUtils.createOrUpdateTopicPartitionAssignmentPathInZK(zkUtils,
                    "partition-api-foo", replicaAssign, null, true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkUtils.close();
        }
    }

    /**
     * 获取主题级别的配置
     */
    public static Properties queryTopicInfo(String topic) {
        ZkUtils zkUtils = null;
        try {
            // 实例化ZkUtils,获取与Zookeeper的连接及实例化一个ZkClient对象
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT,
                    CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            // 查询主题信息
            return AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(),
                    topic);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkUtils.close();
        }
        return null;
    }

    public static void main(String[] args) {
        // 创建主题
        createTopic("partition-api-foo", 1, 2, AdminUtils.createTopic$default$5());

        // 查询主题
        Properties properties = queryTopicInfo(TOPIC);
        Iterator<Entry<Object, Object>> iterator = properties.entrySet()
                .iterator();
        while (iterator.hasNext()) {
            Entry<Object, Object> entry = iterator.next();
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }

        // 修改主题级别配置
        Properties topicPro = new Properties();
        topicPro.put("flush.messages", "1");
        modifyTopicConfig(TOPIC, topicPro);

        // 增加分区
        // {"0":[3]}
        String replicaAssignment = "3:1,2:1";
        addPartition("partition-api-foo", 2, replicaAssignment);
        //增加副本，分区或是分区重分配
        addReplica();
        // 删除主题
        deleteTopic("partition-api-foo");
    }
}
