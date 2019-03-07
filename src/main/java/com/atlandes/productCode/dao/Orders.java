package com.atlandes.productCode.dao;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private Long id;

    private String orderid;

    private String pin;

    private String customername;

    private Short paytype;

    private String province;

    private String city;

    private String county;

    private String adress;

    private String zip;

    private String phone;

    private String email;

    private String sourcetype;

    private Short deliverytype;

    private Long ordertype;

    private String operatorip;

    private BigDecimal totalprice;

    private BigDecimal dicount;

    private BigDecimal postage;

    private String partnerenum;

    private Date createdate;

    private Date paytime;

    private Short status;

    private String payid;

    private Long payenum;

    private Date completedate;

    private Date insbegindate;

    private Date insenddate;

    private String insuranceperiod;

    private String insuranceperiodtype;

    private Date lastupdatedate;

    private Short yn;

    private Short version;

    private String skuid;

    private String skuname;

    private String remark;

    private String ext1;

    private String insureddigest;

    private String paycardno;

    private String paybankno;

    private String paycardid;

    private String buyplan;

    private Date forcebegindate;

    private Date forceenddate;

    private String businesscode;

    private String comorderid;

    private String errorinfo;

    private String activitytype;

    private String keyvalue;

    private BigDecimal withdrawmoney;

    private String channelcode;

    private String thirdorderid;

    private Integer agentflag;

    private String resourceplace;

    private String rePurchaseOrderId;

    private String rePurchaseOrderTo;

    private String sourceNotify;

    private Short deleteFlag;

    private String partnerpayid;

    private String attributetype;

    private String uuid;

    private Short groupflag;

    private String erpid;

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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin == null ? null : pin.trim();
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public Short getPaytype() {
        return paytype;
    }

    public void setPaytype(Short paytype) {
        this.paytype = paytype;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype == null ? null : sourcetype.trim();
    }

    public Short getDeliverytype() {
        return deliverytype;
    }

    public void setDeliverytype(Short deliverytype) {
        this.deliverytype = deliverytype;
    }

    public Long getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Long ordertype) {
        this.ordertype = ordertype;
    }

    public String getOperatorip() {
        return operatorip;
    }

    public void setOperatorip(String operatorip) {
        this.operatorip = operatorip == null ? null : operatorip.trim();
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public BigDecimal getDicount() {
        return dicount;
    }

    public void setDicount(BigDecimal dicount) {
        this.dicount = dicount;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public String getPartnerenum() {
        return partnerenum;
    }

    public void setPartnerenum(String partnerenum) {
        this.partnerenum = partnerenum == null ? null : partnerenum.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid == null ? null : payid.trim();
    }

    public Long getPayenum() {
        return payenum;
    }

    public void setPayenum(Long payenum) {
        this.payenum = payenum;
    }

    public Date getCompletedate() {
        return completedate;
    }

    public void setCompletedate(Date completedate) {
        this.completedate = completedate;
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

    public String getInsuranceperiod() {
        return insuranceperiod;
    }

    public void setInsuranceperiod(String insuranceperiod) {
        this.insuranceperiod = insuranceperiod == null ? null : insuranceperiod.trim();
    }

    public String getInsuranceperiodtype() {
        return insuranceperiodtype;
    }

    public void setInsuranceperiodtype(String insuranceperiodtype) {
        this.insuranceperiodtype = insuranceperiodtype == null ? null : insuranceperiodtype.trim();
    }

    public Date getLastupdatedate() {
        return lastupdatedate;
    }

    public void setLastupdatedate(Date lastupdatedate) {
        this.lastupdatedate = lastupdatedate;
    }

    public Short getYn() {
        return yn;
    }

    public void setYn(Short yn) {
        this.yn = yn;
    }

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
    }

    public String getSkuid() {
        return skuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = skuid == null ? null : skuid.trim();
    }

    public String getSkuname() {
        return skuname;
    }

    public void setSkuname(String skuname) {
        this.skuname = skuname == null ? null : skuname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getInsureddigest() {
        return insureddigest;
    }

    public void setInsureddigest(String insureddigest) {
        this.insureddigest = insureddigest == null ? null : insureddigest.trim();
    }

    public String getPaycardno() {
        return paycardno;
    }

    public void setPaycardno(String paycardno) {
        this.paycardno = paycardno == null ? null : paycardno.trim();
    }

    public String getPaybankno() {
        return paybankno;
    }

    public void setPaybankno(String paybankno) {
        this.paybankno = paybankno == null ? null : paybankno.trim();
    }

    public String getPaycardid() {
        return paycardid;
    }

    public void setPaycardid(String paycardid) {
        this.paycardid = paycardid == null ? null : paycardid.trim();
    }

    public String getBuyplan() {
        return buyplan;
    }

    public void setBuyplan(String buyplan) {
        this.buyplan = buyplan == null ? null : buyplan.trim();
    }

    public Date getForcebegindate() {
        return forcebegindate;
    }

    public void setForcebegindate(Date forcebegindate) {
        this.forcebegindate = forcebegindate;
    }

    public Date getForceenddate() {
        return forceenddate;
    }

    public void setForceenddate(Date forceenddate) {
        this.forceenddate = forceenddate;
    }

    public String getBusinesscode() {
        return businesscode;
    }

    public void setBusinesscode(String businesscode) {
        this.businesscode = businesscode == null ? null : businesscode.trim();
    }

    public String getComorderid() {
        return comorderid;
    }

    public void setComorderid(String comorderid) {
        this.comorderid = comorderid == null ? null : comorderid.trim();
    }

    public String getErrorinfo() {
        return errorinfo;
    }

    public void setErrorinfo(String errorinfo) {
        this.errorinfo = errorinfo == null ? null : errorinfo.trim();
    }

    public String getActivitytype() {
        return activitytype;
    }

    public void setActivitytype(String activitytype) {
        this.activitytype = activitytype == null ? null : activitytype.trim();
    }

    public String getKeyvalue() {
        return keyvalue;
    }

    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue == null ? null : keyvalue.trim();
    }

    public BigDecimal getWithdrawmoney() {
        return withdrawmoney;
    }

    public void setWithdrawmoney(BigDecimal withdrawmoney) {
        this.withdrawmoney = withdrawmoney;
    }

    public String getChannelcode() {
        return channelcode;
    }

    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode == null ? null : channelcode.trim();
    }

    public String getThirdorderid() {
        return thirdorderid;
    }

    public void setThirdorderid(String thirdorderid) {
        this.thirdorderid = thirdorderid == null ? null : thirdorderid.trim();
    }

    public Integer getAgentflag() {
        return agentflag;
    }

    public void setAgentflag(Integer agentflag) {
        this.agentflag = agentflag;
    }

    public String getResourceplace() {
        return resourceplace;
    }

    public void setResourceplace(String resourceplace) {
        this.resourceplace = resourceplace == null ? null : resourceplace.trim();
    }

    public String getRePurchaseOrderId() {
        return rePurchaseOrderId;
    }

    public void setRePurchaseOrderId(String rePurchaseOrderId) {
        this.rePurchaseOrderId = rePurchaseOrderId == null ? null : rePurchaseOrderId.trim();
    }

    public String getRePurchaseOrderTo() {
        return rePurchaseOrderTo;
    }

    public void setRePurchaseOrderTo(String rePurchaseOrderTo) {
        this.rePurchaseOrderTo = rePurchaseOrderTo == null ? null : rePurchaseOrderTo.trim();
    }

    public String getSourceNotify() {
        return sourceNotify;
    }

    public void setSourceNotify(String sourceNotify) {
        this.sourceNotify = sourceNotify == null ? null : sourceNotify.trim();
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getPartnerpayid() {
        return partnerpayid;
    }

    public void setPartnerpayid(String partnerpayid) {
        this.partnerpayid = partnerpayid == null ? null : partnerpayid.trim();
    }

    public String getAttributetype() {
        return attributetype;
    }

    public void setAttributetype(String attributetype) {
        this.attributetype = attributetype == null ? null : attributetype.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Short getGroupflag() {
        return groupflag;
    }

    public void setGroupflag(Short groupflag) {
        this.groupflag = groupflag;
    }

    public String getErpid() {
        return erpid;
    }

    public void setErpid(String erpid) {
        this.erpid = erpid == null ? null : erpid.trim();
    }
}