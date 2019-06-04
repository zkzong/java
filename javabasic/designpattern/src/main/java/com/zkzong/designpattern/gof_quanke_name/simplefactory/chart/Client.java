package com.zkzong.designpattern.gof_quanke_name.simplefactory.chart;

/**
 * Created by Zong on 2016/11/25.
 */
public class Client {
    public static void main(String[] args) {
        Chart chart;
        chart = ChartFactory.getChart("histogram");
        chart.display();
    }
}
