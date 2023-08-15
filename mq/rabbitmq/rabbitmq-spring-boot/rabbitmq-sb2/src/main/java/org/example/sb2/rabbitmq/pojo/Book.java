package com.example.sb2.rabbitmq.pojo;

import lombok.Data;

@Data
public class Book implements java.io.Serializable {

    private static final long serialVersionUID = -2164058270260403154L;

    private String id;
    private String name;

}
