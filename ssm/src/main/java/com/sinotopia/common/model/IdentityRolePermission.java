package com.sinotopia.common.model;

import java.io.Serializable;

import net.sf.json.JSONObject;

/**
 */
public class IdentityRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * {@link IdentityRole.id}
     */
    private Long rid;
    /**
     * {@link IdentityPermission.id}
     */
    private Long pid;

    public IdentityRolePermission() {
    }

    public IdentityRolePermission(Long rid, Long pid) {
        this.rid = rid;
        this.pid = pid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}