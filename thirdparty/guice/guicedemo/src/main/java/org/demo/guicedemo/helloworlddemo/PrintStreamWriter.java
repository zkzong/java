package org.demo.guicedemo.helloworlddemo;

import javax.inject.Inject;
import java.io.PrintStream;

public class PrintStreamWriter implements MyDestination {

    private PrintStream destination;

    @Inject
    public PrintStreamWriter(PrintStream destination) {
        super();
        this.destination = destination;
    }

    @Override
    public void write(String string) {
        destination.println(string);
    }

}
