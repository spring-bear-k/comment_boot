package com.dxt.comment_boot.entity;

import javax.persistence.*;

@Table(name = "sys_group_action")
public class SysGroupAction {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "action_id")
    private Integer actionId;

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
     * @return group_id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * @return action_id
     */
    public Integer getActionId() {
        return actionId;
    }

    /**
     * @param actionId
     */
    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }
}