package org.example.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by zong on 2017/2/7.
 */
public class URLDecoderTest {
    public static void main(String[] args) {
        String s = "jsonData=%7B%22address%22%3A%22111%22%2C%22agentCompanyId%22%3A%22mh878%22%2C%22agentCompanyName%22%3A%22%40%40%22%2C%22agentId%22%3A%22mh80587%22%2C%22agentName%22%3A%22aa%22%2C%22agentPhone%22%3A%2213000000000%22%2C%22appName%22%3A%22aa%22%2C%22appNo%22%3A%22MH201702071400018463%22%2C%22area%22%3A%2211%22%2C%22channelId%22%3A%22mh10010533%22%2C%22channelName%22%3A%22%E5%BC%A0%E4%B8%89%E4%B8%B0%22%2C%22channelPersonId%22%3A%22110101198909090110%22%2C%22channelPhone%22%3A%2218212340000%22%2C%22city%22%3A%22110100%22%2C%22cityName%22%3A%22%E5%B8%82%E8%BE%96%E5%8C%BA%22%2C%22district%22%3A%22110101%22%2C%22districtName%22%3A%22%E4%B8%9C%E5%9F%8E%E5%8C%BA%22%2C%22floorId%22%3A%221%22%2C%22houseNo%22%3A%2211%22%2C%22houseToward%22%3A%22towards%22%2C%22orgCode%22%3A%22V286114%22%2C%22plannedUse%22%3A%22F1%22%2C%22propertyType%22%3A%22F101%22%2C%22province%22%3A%22110000%22%2C%22provinceName%22%3A%22%E5%8C%97%E4%BA%AC%E5%B8%82%22%2C%22residentName%22%3A%22sjw%E6%B5%8B%E8%AF%95%E5%B0%8F%E5%8C%BA1%22%2C%22storeNo%22%3A%22601030401%22%2C%22totalFloor%22%3A%2211%22%7D";
        String s1 = " asdk kdf";
        try {
            System.out.println(URLDecoder.decode(s, "UTF-8"));
//            jsonData={"address":"111","agentCompanyId":"mh878","agentCompanyName":"@@","agentId":"mh80587","agentName":"aa","agentPhone":"13000000000","appName":"aa","appNo":"MH201702071400018463","area":"11","channelId":"mh10010533","channelName":"张三丰","channelPersonId":"110101198909090110","channelPhone":"18212340000","city":"110100","cityName":"市辖区","district":"110101","districtName":"东城区","floorId":"1","houseNo":"11","houseToward":"towards","orgCode":"V286114","plannedUse":"F1","propertyType":"F101","province":"110000","provinceName":"北京市","residentName":"sjw测试小区1","storeNo":"601030401","totalFloor":"11"}

            System.out.println(URLDecoder.decode(s1, "UTF-8"));
//             asdk kdf
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
