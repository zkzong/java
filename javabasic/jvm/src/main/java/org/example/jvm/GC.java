package org.example.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * 内存泄漏
 * -Xms20m -Xmx20m -XX:+PrintGC -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=heap.bin
 */
public class GC {
    public static void main(String[] args) {
        List list = new LinkedList();
        do {
            list.add(new String("Hello World"));
        } while (true);
    }
}
