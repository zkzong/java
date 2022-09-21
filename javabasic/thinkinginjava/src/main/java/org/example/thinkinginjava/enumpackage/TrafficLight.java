package org.example.thinkinginjava.enumpackage;

import org.example.thinkinginjava.util.Print;

/**
 * Created by zong on 2016/8/25.
 */
enum Signal {
    GREEN, YELLOW, RED,
}

public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            Print.print(t);
            t.change();
        }
    }
}
