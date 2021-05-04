import com.alibaba.csp.sentinel.cluster.flow.rule.ClusterFlowRuleManager;
import com.alibaba.csp.sentinel.cluster.server.ClusterTokenServer;
import com.alibaba.csp.sentinel.cluster.server.SentinelDefaultTokenServer;
import com.alibaba.csp.sentinel.cluster.server.config.ClusterServerConfigManager;
import com.alibaba.csp.sentinel.cluster.server.config.ServerTransportConfig;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.property.SentinelProperty;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TokenServerApplication {
    public static void main(String[] args) throws Exception {
        Set<String> applyNamespaces = new HashSet<>(Arrays.asList("test"));
// 创建集群限流的独立服务端对象并设置端口，这个端口是集群客户端将要使用到的端口
        ClusterTokenServer server = new SentinelDefaultTokenServer();
        ClusterServerConfigManager.loadGlobalTransportConfig(new ServerTransportConfig().setPort(9102));

// 这是可选向，用于动态配置这个限流在哪个应用（project.name）上
        SentinelProperty<Set<String>> namespaceProperty = new NacosDataSource<>(
                "localhost",        // 配置Nacos ip
                "DEFUALT",          // 配置Nacos data的分组
                "dubb-sentinel-cluster-server-namespaces-config.json",  // data id
                namespacesConverter()).getProperty(); // 获取property属性
        /*
// 这是必选项，配置集群的限流规则，
        ClusterFlowRuleManager.setPropertySupplier(namespace -> {
            NacosDataSource<List<FlowRule>> dataSource = new NacosDataSource<>(
                    "localhost",        // 配置Nacos ip
                    "DEFUALT",          // 配置Nacos data的分组
                    "dubb-sentinel-cluster-server-config.json",     // data id
                    flowRulesConverter());
            return dataSource.getProperty();
        });*/
// 集群服务配置管理器应用一下当前所应用服务名配置做初始值
        ClusterServerConfigManager.loadServerNamespaceSet(applyNamespaces);
        ClusterServerConfigManager.registerNamespaceSetProperty(namespaceProperty);

// 启动独立的服务
        server.start();
// server.stop(); // 停止服务
    }
}
