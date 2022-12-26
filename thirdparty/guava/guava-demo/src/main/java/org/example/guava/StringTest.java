package org.example.guava;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Zong on 2016/11/22.
 */
public class StringTest {

    // Joiner
    @Test
    public void joinerTest() {
        String join = Joiner.on(",").skipNulls().join(Arrays.asList(1, 2, 3, 4, 5, null, 6));
        System.out.println(join);
        // 1,2,3,4,5,6
    }

    // Spiltter
    @Test
    public void spiltterTest() {
        Iterable<String> split = Splitter.on(",").trimResults().omitEmptyStrings().
                split("the ,quick, ,brown, fox, jumps, over, the, lazy, little dog.");
        System.out.println(split);
        // [the, quick, brown, fox, jumps, over, the, lazy, little dog.]
    }

    // CharMatcher
    @Test
    public void charMatcherTest() {
        System.out.println(CharMatcher.DIGIT.retainFrom("mahesh123")); // 123
        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("     Mahesh     Parashar ", ' ')); // Mahesh Parashar
        System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom("mahesh123", "*"));// mahesh***
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("mahesh123")); // mahesh123
    }

    // CaseFormat
    @Test
    public void caseFormatTest() {
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data")); // testData
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data")); // testData
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data")); // TestData
    }
}
