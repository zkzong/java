package org.example.json.request;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Author: zong
 * @Date: 2020/1/11
 */
public class BeanTest {

    @Test
    public void test() {
        Request request = new Request();
        request.setAction("1");
        request.setSmsType("1");
        request.setApiVersion("1");
        request.setContent("1");
        request.setFromNum("1");
        request.setDateSent("1");
        request.setDeliverCode("1");
        request.setRecvTime("1");
        request.setStatus("1");
        request.setReqId("1");
        request.setSmsCount("1");

        JsonRootBean jsonRootBean = new JsonRootBean();
        jsonRootBean.setRequest(request);
        String json = JSON.toJSONString(jsonRootBean);
        System.out.println(json);

        json = "{\n" +
                "    \"Request\":{\n" +
                "        \"action\":\"SMSArrived\",\n" +
                "        \"smsType\":\"1\",\n" +
                "        \"apiVersion\":\"2013-12-26\",\n" +
                "        \"content\":\"4121908f3d1b4edb9210f0eb4742f62c\",\n" +
                "        \"fromNum\":\"13912345678\",\n" +
                "        \"dateSent\":\"20130923010000\",\n" +
                "        \"deliverCode\":\"DELIVRD\",\n" +
                "        \"recvTime\":\"20130923010010\",\n" +
                "        \"status\":\"0\",\n" +
                "        \"reqId\":\"123\",\n" +
                "        \"smsCount\":\"2\"\n" +
                "    }\n" +
                "}";

        JsonRootBean bean = JSON.parseObject(json, JsonRootBean.class);
        System.out.println(bean);

    }
}
