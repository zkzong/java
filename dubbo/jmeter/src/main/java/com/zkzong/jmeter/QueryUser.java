package com.zkzong.jmeter;

import com.zkzong.dubbo.web.entity.User;
import com.zkzong.dubbo.web.facade.UserFacade;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;

public class QueryUser extends AbstractJavaSamplerClient {

    //需要测试的接口
    @Autowired
    private UserFacade userFacade;

    private long start = 0;//记录测试开始时间；
    private long end = 0;//记录测试结束时间；
//    private String hosCode = "T113411";
//    private String cardNo = "98000001004327";


    //初始化操作
    @Override
    public void setupTest(JavaSamplerContext arg0) {
        DubboInit init = DubboInit.getInstance();
        init.initApplicationContext();
        userFacade = (UserFacade) init.getBean("userFacade");
    }

    /**
     * 设置默认值
     *
     * @return
     */
//    public Arguments getDefaultParameters() {
//        Arguments params = new Arguments();
//        params.addArgument("hosCode", hosCode);
//        params.addArgument("cardNo", cardNo);
//        return params;
//    }

    /**
     * 获取jmeter输入的参数值
     *
     * @return
     */
//    public void setValues(JavaSamplerContext arg0) {
//        hosCode = arg0.getParameter("hosCode", hosCode);
//        cardNo = arg0.getParameter("cardNo", cardNo);
//    }
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult sr = new SampleResult();
//        setValues(javaSamplerContext);
        sr.sampleStart();
        start = System.currentTimeMillis();
        try {

            User user = userFacade.queryUser();
            if (user != null) {
                sr.setSuccessful(true);
                sr.setResponseData(user.toString(), null);
                sr.setDataType(SampleResult.TEXT);
            } else {
                sr.setSuccessful(false);
                getLogger().error("LqueryTakeRegNo response is null");
            }
        } catch (Exception e) {
            getLogger().error("LqueryTakeRegNo response error : " + e.getMessage());
            sr.setSuccessful(false);
        } finally {
            sr.sampleEnd();
        }
        return sr;
    }

    @Override
    public void teardownTest(JavaSamplerContext arg0) {
        end = System.currentTimeMillis();
        getLogger().info("    cost time: " + (end - start) + "ms");
    }
}
