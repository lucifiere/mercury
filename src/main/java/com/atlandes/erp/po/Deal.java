package com.atlandes.erp.po;

import java.util.Date;

/**
 * 交易表实体
 * Created by Max on 2019/02/24.
 */
public class Deal {

    /**
     * 交易编号
     */
    private Integer id;

    private Date beginDealDate;

    private Date endDealDate;

    private Integer needFetchGoods;

    private Integer needJG;

    private Integer complete;

    private Integer xhOrderId;

    private Integer thOrderId;

    private Integer xqOrderId;

    private Integer cgOrderId;

    private Integer qhOrderId;

    private Integer jgOrderId;

    private Integer rkOrderId;

    private Integer osOrderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBeginDealDate() {
        return beginDealDate;
    }

    public void setBeginDealDate(Date beginDealDate) {
        this.beginDealDate = beginDealDate;
    }

    public Date getEndDealDate() {
        return endDealDate;
    }

    public void setEndDealDate(Date endDealDate) {
        this.endDealDate = endDealDate;
    }

    public Integer getNeedFetchGoods() {
        return needFetchGoods;
    }

    public void setNeedFetchGoods(Integer needFetchGoods) {
        this.needFetchGoods = needFetchGoods;
    }

    public Integer getNeedJG() {
        return needJG;
    }

    public void setNeedJG(Integer needJG) {
        this.needJG = needJG;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public Integer getXhOrderId() {
        return xhOrderId;
    }

    public void setXhOrderId(Integer xhOrderId) {
        this.xhOrderId = xhOrderId;
    }

    public Integer getThOrderId() {
        return thOrderId;
    }

    public void setThOrderId(Integer thOrderId) {
        this.thOrderId = thOrderId;
    }

    public Integer getXqOrderId() {
        return xqOrderId;
    }

    public void setXqOrderId(Integer xqOrderId) {
        this.xqOrderId = xqOrderId;
    }

    public Integer getCgOrderId() {
        return cgOrderId;
    }

    public void setCgOrderId(Integer cgOrderId) {
        this.cgOrderId = cgOrderId;
    }

    public Integer getQhOrderId() {
        return qhOrderId;
    }

    public void setQhOrderId(Integer qhOrderId) {
        this.qhOrderId = qhOrderId;
    }

    public Integer getJgOrderId() {
        return jgOrderId;
    }

    public void setJgOrderId(Integer jgOrderId) {
        this.jgOrderId = jgOrderId;
    }

    public Integer getRkOrderId() {
        return rkOrderId;
    }

    public void setRkOrderId(Integer rkOrderId) {
        this.rkOrderId = rkOrderId;
    }

    public Integer getOsOrderId() {
        return osOrderId;
    }

    public void setOsOrderId(Integer osOrderId) {
        this.osOrderId = osOrderId;
    }
}
