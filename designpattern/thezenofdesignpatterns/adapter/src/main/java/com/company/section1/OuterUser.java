package com.company.section1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 * 外系统的用户信息的实现类
 */
@SuppressWarnings("all")
public class OuterUser implements IOuterUser {

    /*
     * 用户的基本信息
     */
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap();

        baseInfoMap.put("userName", "这个员工叫混世魔王....");
        baseInfoMap.put("mobileNumber", "这个员工电话是....");

        return baseInfoMap;
    }

    /*
     * 员工的家庭信息
     */
    public Map getUserHomeInfo() {
        HashMap homeInfo = new HashMap();

        homeInfo.put("homeTelNumbner", "员工的家庭电话是....");
        homeInfo.put("homeAddress", "员工的家庭地址是....");

        return homeInfo;
    }

    /*
     * 员工的工作信息，比如职位了等
     */
    public Map getUserOfficeInfo() {
        HashMap officeInfo = new HashMap();

        officeInfo.put("jobPosition", "这个人的职位是BOSS...");
        officeInfo.put("officeTelNumber", "员工的办公电话是....");

        return officeInfo;
    }

}
