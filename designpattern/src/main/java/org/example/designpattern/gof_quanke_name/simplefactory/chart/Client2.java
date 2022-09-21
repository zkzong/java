package org.example.designpattern.gof_quanke_name.simplefactory.chart;

/**
 * Created by Zong on 2016/11/25.
 */
public class Client2 {
    public static void main(String[] args) {
        Chart chart;
        String type = XMLUtil.getChartType(); // 读取配置文件中的参数
        chart = ChartFactory.getChart(type); // 创建产品对象
        chart.display();
    }
}
