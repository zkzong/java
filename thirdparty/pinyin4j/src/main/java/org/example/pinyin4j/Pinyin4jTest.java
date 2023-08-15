package com.example.pinyin4j;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by Zong on 2016/9/22.
 */
public class Pinyin4jTest {
    public static void main(String[] args) {
        // 基本用法
        String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray('宗');
        for (int i = 0; i < pinyinArray.length; ++i) {
            System.out.println(pinyinArray[i]);
        }

        // 格式支持
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

        format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

//        String[] pinyinArray = null;

        try {
            pinyinArray = PinyinHelper.toHanyuPinyinStringArray('黄', format);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }

        for (int i = 0; i < pinyinArray.length; ++i) {
            System.out.println(pinyinArray[i]);
        }
    }
}
