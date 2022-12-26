package org.example.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

/**
 * Created by zong on 2016/8/10.
 */
public class TableTest {

    @Test
    public void table() {
        Table<String, String, Integer> table = HashBasedTable.create();

        //存放元素
        table.put("Hydra", "Jan", 20);
        table.put("Hydra", "Feb", 28);

        table.put("Trunks", "Jan", 28);
        table.put("Trunks", "Feb", 16);

        //取出元素
        Integer dayCount = table.get("Hydra", "Feb");
        System.out.println(dayCount);

    }
}
