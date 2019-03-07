package com.atlandes.productCode.dao;

import java.math.BigDecimal;
import java.util.Date;

public class Policyorder {
    private Long id;

    private String orderid;

    private String policyno;

    private String proposalno;

    private String uuid;

    private String skuid;

    private String partnerenum;

    private String partnerproductcode;

    private String customermapping;

    private BigDecimal policyprice;

    private String downloadurl;

    private Date insbegindate;

    private Date insenddate;

    private Short insquantity;

    private Short status;

    private Date proposaldate;

    private Date policydate;

    private Date cretedate;

    private Date lastupdatedate;

    private Short version;

    private String skuname;

    private Long policylimitprice;

    private Short policytype;

    private Short policynum;

    private Short yn;

    private Short groupflag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getPolicyno() {
        return policyno;
    }

    public void setPolicyno(String policyno) {
        this.policyno = policyno == null ? null : policyno.trim();
    }

    public String getProposalno() {
        return proposalno;
    }

    public void setProposalno(String proposalno) {
        this.proposalno = proposalno == null ? null : proposalno.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getSkuid() {
        return skuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = skuid == null ? null : skuid.trim();
    }

    public String getPartnerenum() {
        return partnerenum;
    }

    public void setPartnerenum(String partnerenum) {
        this.partnerenum = partnerenum == null ? null : partnerenum.trim();
    }

    public String getPartnerproductcode() {
        return partnerproductcode;
    }

    public void setPartnerproductcode(String partnerproductcode) {
        this.partnerproductcode = partnerproductcode == null ? null : partnerproductcode.trim();
    }

    public String getCustomermapping() {
        return customermapping;
    }

    public void setCustomermapping(String customermapping) {
        this.customermapping = customermapping == null ? null : customermapping.trim();
    }

    public BigDecimal getPolicyprice() {
        return policyprice;
    }

    public void setPolicyprice(BigDecimal policyprice) {
        this.policyprice = policyprice;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl == null ? null : downloadurl.trim();
    }

    public Date getInsbegindate() {
        return insbegindate;
    }

    public void setInsbegindate(Date insbegindate) {
        this.insbegindate = insbegindate;
    }

    public Date getInsenddate() {
        return insenddate;
    }

    public void setInsenddate(Date insenddate) {
        this.insenddate = insenddate;
    }

    public Short getInsquantity() {
        return insquantity;
    }

    public void setInsquantity(Short insquantity) {
        this.insquantity = insquantity;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getProposaldate() {
        return proposaldate;
    }

    public void setProposaldate(Date proposaldate) {
        this.proposaldate = proposaldate;
    }

    public Date getPolicydate() {
        return policydate;
    }

    public void setPolicydate(Date policydate) {
        this.policydate = policydate;
    }

    public Date getCretedate() {
        return cretedate;
    }

    public void setCretedate(Date cretedate) {
        this.cretedate = cretedate;
    }

    public Date getLastupdatedate() {
        return lastupdatedate;
    }

    public void setLastupdatedate(Date lastupdatedate) {
        this.lastupdatedate = lastupdatedate;
    }

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
    }

    public String getSkuname() {
        return skuname;
    }

    public void setSkuname(String skuname) {
        this.skuname = skuname == null ? null : skuname.trim();
    }

    public Long getPolicylimitprice() {
        return policylimitprice;
    }

    public void setPolicylimitprice(Long policylimitprice) {
        this.policylimitprice = policylimitprice;
    }

    public Short getPolicytype() {
        return policytype;
    }

    public void setPolicytype(Short policytype) {
        this.policytype = policytype;
    }

    public Short getPolicynum() {
        return policynum;
    }

    public void setPolicynum(Short policynum) {
        this.policynum = policynum;
    }

    public Short getYn() {
        return yn;
    }

    public void setYn(Short yn) {
        this.yn = yn;
    }

    public Short getGroupflag() {
        return groupflag;
    }

    public void setGroupflag(Short groupflag) {
        this.groupflag = groupflag;
    }
}