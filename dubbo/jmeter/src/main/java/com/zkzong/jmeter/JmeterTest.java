package com.zkzong.jmeter;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class JmeterTest extends AbstractJavaSamplerClient {
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult sr = new SampleResult();
        sr.sampleStart();
        sr.setResponseData("Jmeter", null);
        sr.setDataType(SampleResult.TEXT);
        sr.setSuccessful(true);
        sr.sampleEnd();
        return sr;
    }
}
