package com.zkzong.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

/**
 * @Author: zkzong
 * @Date: 2018.8.29
 * @link https://www.cnblogs.com/softidea/p/9140204.html
 */
public class Template {
    public static String processTemplate(String template, Map<String, Object> params){
        StringBuffer sb = new StringBuffer();
        Matcher m = compile("\\$\\{\\w+\\}").matcher(template);
        while (m.find()) {
            String param = m.group();
            Object value = params.get(param.substring(2, param.length() - 1));
            m.appendReplacement(sb, value==null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args){
        Map map = new HashMap();
        map.put("name", "张三");
        map.put("money", String.format("%.2f", 10.155));
        map.put("point", 10);
        String message = processTemplate("您好${name}，晚上好！您目前余额：${money}元，积分：${point}", map);
        System.out.println(message);
        //您好张三，晚上好！您目前余额：10.16元，积分：10
    }

}
