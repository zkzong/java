package com.zkzong.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Map;

/**
 * Created by Zong on 16/12/21.
 */
public class HttpRequestWapper extends HttpServletRequestWrapper {


    public HttpRequestWapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        return super.getParameter(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return super.getParameterMap();
    }

    @Override
    public String[] getParameterValues(String name) {
        return super.getParameterValues(name);
    }
}
