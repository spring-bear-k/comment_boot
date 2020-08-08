package com.dxt.comment_boot.entity;

import javax.persistence.*;

@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    @Column(name = "nameZh")
    private String namezh;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return nameZh
     */
    public String getNamezh() {
        return namezh;
    }

    /**
     * @param namezh
     */
    public void setNamezh(String namezh) {
        this.namezh = namezh;
    }
}