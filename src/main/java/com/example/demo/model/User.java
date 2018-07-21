package com.example.demo.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

/**
 * User
 * @author corey
 * @date 2018/7/9
 */
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date birthday;

    private String mobile;

    private String remark;

    @Column(name = "is_enable")
    private Boolean isEnable;

}