
package org.example.sj5.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer userId;

    private String userName;

    private String pwd;

}
