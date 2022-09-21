package org.example.designpattern.gof_quanke_name.simplefactory.chart;

/**
 * Created by Zong on 2016/11/25.
 * 饼状图类：具体产皮品类
 */
public class PieChart implements Chart {
    public PieChart() {
        System.out.println("创建饼状图！");
    }

    @Override
    public void display() {
        System.out.println("显示饼状图！");
    }
}
