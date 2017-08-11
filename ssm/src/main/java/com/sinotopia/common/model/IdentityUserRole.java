package com.sinotopia.common.model;

import java.io.Serializable;

import net.sf.json.JSONObject;

/**

 */
public class IdentityUserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * {@link IdentityUser.id}
     */
    private Long uid;
    /**
     * {@link IdentityRole.id}
     */
    private Long rid;

    public IdentityUserRole(Long uid, Long rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public IdentityUserRole() {
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}