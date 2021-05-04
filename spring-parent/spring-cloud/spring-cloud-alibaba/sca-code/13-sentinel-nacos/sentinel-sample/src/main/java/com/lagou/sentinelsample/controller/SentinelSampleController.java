package com.lagou.sentinelsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SentinelSampleController {
    //演示用的业务逻辑类
    @Resource
    private SampleService sampleService;

    /**
     * 流控测试接口
     *
     * @return
     */
    @GetMapping("/test_flow_rule")
    public ResponseObject testFlowRule() {
        //code=0代表服务器处理成功
        return new ResponseObject("0", "success!");
    }

    /**
     * 熔断测试接口
     *
     * @return
     */
    @GetMapping("/test_degrade_rule")
    public ResponseObject testDegradeRule() {
        try {
            sampleService.createOrder();
        } catch (IllegalStateException e) {
            //当createOrder业务处理过程中产生异常时，对外抛出异常
            //IllegalStateException是JAVA内置状态异常，在项目开发时可以更换为自己项目的自定义异常
            return new ResponseObject(e.getClass().getSimpleName(), e.getMessage());
        }
        return new ResponseObject("0", "order created!");
    }
}
