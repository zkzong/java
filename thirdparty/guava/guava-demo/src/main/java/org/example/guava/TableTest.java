package org.example.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

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

        // 获得key或value的集合
        //rowKey或columnKey的集合
        Set<String> rowKeys = table.rowKeySet();
        System.out.println("rowKeySet = " + rowKeys);
        Set<String> columnKeys = table.columnKeySet();
        System.out.println("columnKeySet = " + columnKeys);

        //value集合
        Collection<Integer> values = table.values();
        System.out.println("values = " + values);

        // 计算key对应的所有value的和
        for (String key : table.rowKeySet()) {
            Set<Map.Entry<String, Integer>> rows = table.row(key).entrySet();
            int total = 0;
            for (Map.Entry<String, Integer> row : rows) {
                total += row.getValue();
            }
            System.out.println(key + ": " + total);
        }

        // 转换rowKey和columnKey
        Table<String, String, Integer> table2 = Tables.transpose(table);
        Set<Table.Cell<String, String, Integer>> cells = table2.cellSet();
        cells.forEach(cell ->
                System.out.println(cell.getRowKey() + "," + cell.getColumnKey() + ":" + cell.getValue())
        );

        // 转为嵌套的Map
        Map<String, Map<String, Integer>> rowMap = table.rowMap();
        System.out.println(rowMap);
        Map<String, Map<String, Integer>> columnMap = table.columnMap();
        System.out.println(columnMap);


    }
}
