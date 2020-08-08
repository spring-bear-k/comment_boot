package com.dxt.comment_boot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_param")
public class SysParam {
    @Column(name = "param_key")
    private String paramKey;

    @Column(name = "param_value")
    private Date paramValue;

    @Column(name = "param_desc")
    private String paramDesc;

    /**
     * @return param_key
     */
    public String getParamKey() {
        return paramKey;
    }

    /**
     * @param paramKey
     */
    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    /**
     * @return param_value
     */
    public Date getParamValue() {
        return paramValue;
    }

    /**
     * @param paramValue
     */
    public void setParamValue(Date paramValue) {
        this.paramValue = paramValue;
    }

    /**
     * @return param_desc
     */
    public String getParamDesc() {
        return paramDesc;
    }

    /**
     * @param paramDesc
     */
    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }
}