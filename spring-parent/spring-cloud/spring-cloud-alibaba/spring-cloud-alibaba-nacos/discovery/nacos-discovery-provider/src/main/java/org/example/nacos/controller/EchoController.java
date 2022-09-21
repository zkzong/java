package org.example.nacos.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Author: zong
 * @Date: 2020/1/7
 */
@RestController
public class EchoController {

    @NacosInjected
    private NamingService namingService;

    @RequestMapping(value = "/echo/{string}", method = GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    // todo NullPointerException
    @RequestMapping(value = "/get", method = GET)
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }
}
