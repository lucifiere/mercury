package com.atlandes.productCode.dao;

import java.util.Date;

public class Tradetask {
    private Long id;

    private String bizno;

    private String biztype;

    private String orderid;

    private String uuid;

    private String taskinfo;

    private Short taskstatus;

    private Date createdate;

    private Date lastupdatedate;

    private Short retrytime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizno() {
        return bizno;
    }

    public void setBizno(String bizno) {
        this.bizno = bizno == null ? null : bizno.trim();
    }

    public String getBiztype() {
        return biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype == null ? null : biztype.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getTaskinfo() {
        return taskinfo;
    }

    public void setTaskinfo(String taskinfo) {
        this.taskinfo = taskinfo == null ? null : taskinfo.trim();
    }

    public Short getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(Short taskstatus) {
        this.taskstatus = taskstatus;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getLastupdatedate() {
        return lastupdatedate;
    }

    public void setLastupdatedate(Date lastupdatedate) {
        this.lastupdatedate = lastupdatedate;
    }

    public Short getRetrytime() {
        return retrytime;
    }

    public void setRetrytime(Short retrytime) {
        this.retrytime = retrytime;
    }
}