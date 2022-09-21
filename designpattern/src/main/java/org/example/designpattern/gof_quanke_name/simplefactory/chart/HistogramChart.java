package org.example.designpattern.gof_quanke_name.simplefactory.chart;

/**
 * Created by Zong on 2016/11/25.
 * 柱状图类：具体产皮品类
 */
public class HistogramChart implements Chart {
    public HistogramChart() {
        System.out.println("创建柱状图！");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图！");
    }
}
