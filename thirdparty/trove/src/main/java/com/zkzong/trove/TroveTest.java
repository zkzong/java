package com.zkzong.trove;

import gnu.trove.map.TIntDoubleMap;
import gnu.trove.map.hash.TIntDoubleHashMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zong on 2017/4/13.
 */
public class TroveTest {
    @Test
    public void testMap() {
        int i = 1;
        Map map = new HashMap();
        map.put(i, "a");
        TIntDoubleMap tMap = new TIntDoubleHashMap();
        tMap.put(1, 2.3);
    }

}
