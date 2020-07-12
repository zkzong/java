package com.zkzong.job.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "foo")
public class Foo implements Serializable {

    private static final long serialVersionUID = 2706842871078949451L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String location;

    private String status;

    public Foo() {
    }

    public Foo(long id, String location, String status) {
        this.id = id;
        this.location = location;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("id: %s, location: %s, status: %s", id, location, status);
    }

}
