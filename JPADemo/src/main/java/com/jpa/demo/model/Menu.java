package com.jpa.demo.model;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * @Description:一句话的功能说明
 * @Author: chendom
 * @Date: 2019/11/19 15:13
 * @Version 1.0
 */
@Entity
@Data
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private Integer pid;

    private Integer sort;

    private String url;

    private Boolean hide;

    private String tip;

    private Integer group;

    private Boolean isDev;

    private Boolean status;

    private String ico;







}
