package com.example.thinkinginjava.enumpackage;

import com.example.thinkinginjava.util.Print;

/**
 * Created by zong on 2016/8/25.
 */
public enum OzWitch {
    // Instances must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private String description;

    // Constructor must be package or private access:
    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            Print.print(witch + ": " + witch.getDescription());
        }
    }
}
