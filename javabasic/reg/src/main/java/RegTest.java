import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @Author: zong
 * @Date: 2021/11/23
 */
public class RegTest {

    @Test
    public void digit() {
        // 字符串为数字
        final boolean matches = Pattern.matches("[0-9]+", "3284323493a");
        System.out.println(matches);
    }
}
