package com.zkzong.job.fixture.entity;

import java.io.Serializable;

public class Foo implements Serializable {
    private long id;
    private String location;
    private Status status;

    public Foo(long id, String location, Status status) {
        this.id = id;
        this.location = location;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("id: %s, location: %s, status: %s", id, location, status);
    }

    public enum Status {
        /**
         * 未完成
         */
        TODO,
        /**
         * 完成
         */
        COMPLETED
    }
}
