package com.atlandes.productCode.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

//import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.atlandes.productCode.common.*;
import com.atlandes.productCode.dao.*;
import com.atlandes.productCode.entity.BaseCheckResult;
import com.atlandes.productCode.entity.Dict;
import com.atlandes.productCode.entity.ProductDict;
import com.atlandes.productCode.entity.ProductFeeRequest;
import com.atlandes.productCode.mapper.OrdersMapper;
import com.atlandes.productCode.mapper.PolicyorderMapper;
import com.atlandes.productCode.mapper.TradetaskMapper;
import com.atlandes.productCode.vo.ProductPriceReqTr;
import com.google.common.base.Joiner;
import com.jd.baoxian.order.trade.export.dto.PolicyDto;
import com.jd.baoxian.order.trade.export.dto.PolicyQueryDto;
import com.jd.baoxian.order.trade.export.dto.base.OperDto;
import com.jd.baoxian.order.trade.export.req.PolicyInfoQueryReq;
import com.jd.baoxian.order.trade.export.req.PolicyQueryReq;
import com.jd.baoxian.order.trade.export.res.PolicyInfoQueryRes;
import com.jd.baoxian.order.trade.export.res.PolicyQueryRes;
import com.jd.baoxian.product.export.pojo.ProductFee;
import com.jd.baoxian.product.export.vo.res.ProductAlternative;
import com.jd.baoxian.service.platform.domain.bean.*;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jd.baoxian.order.trade.export.resource.OrderCreateService;
import com.jd.baoxian.order.trade.export.resource.PolicyQueryService;
import com.jd.baoxian.product.export.pojo.ProductRenewal;
import com.jd.baoxian.product.export.vo.base.BaseClass;
import com.jd.baoxian.product.export.vo.res.ProductDetail;
import com.jd.baoxian.service.platform.domain.enums.AccountTypeEnum;
import com.jd.baoxian.service.platform.domain.request.IssueRequest;
import com.jd.baoxian.service.platform.domain.request.ProductRequest;
import com.jd.baoxian.service.platform.domain.request.UnderWriteRequest;
import com.jd.baoxian.service.platform.domain.response.BaseResponse;
import com.jd.baoxian.service.platform.domain.response.UnderWriteResponse;
import com.jd.baoxian.service.platform.export.resource.contract.IssueResource;
import com.jd.baoxian.service.platform.export.resource.contract.UnderWriteResource;
import com.jd.baoxian.service.platform.export.resource.product.ProductResource;
import com.jd.baoxian.trade.export.contract.vo.ClientInfo;
import org.springframework.stereotype.Service;

@Service

public class ProductBaseInfo extends BaseConfig {
    @Autowired
    public ProductResource jsfProductResource;
    @Autowired
    public UnderWriteResource jsfUnderWriteResource;
    @Autowired
    public OrderCreateService orderCreateService;
    @Autowired
    public IssueResource jsfIssueResource;
    @Autowired
    public PolicyQueryService policyQueryService;
    @Autowired
    public PolicyorderMapper policyorderMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private TradetaskMapper tradetaskMapper;


    public BaseResponse<ProductDetail> getProductDetailBySkuId(String itemId) {
        Merchant merchant = new Merchant();
        merchant.setMerchantNo("1018120001");
        merchant.setMerchantName("京东金融");

        ProductRequest preq = new ProductRequest();
        preq.setMerchant(merchant);
        preq.setItemId(itemId);
        BaseResponse<ProductDetail> resProductDetail = jsfProductResource.productInfoV1(preq);
        return resProductDetail;
    }

    public ProductDict getProductDict(String sku) {
        ProductDict productDict = new ProductDict();
        BaseResponse<ProductDetail> resProductDetail = getProductDetailBySkuId(sku);

        //投被保人关系
        if (CollectionUtils.isNotEmpty(resProductDetail.getResponse().getProductBase().getHolderInsuredRelations())) {
            List<Dict> holderInsuredRelations = resProductDetail.getResponse().getProductBase().getHolderInsuredRelations().stream().map(relation -> {
                Dict holderInsuredRelation = new Dict();
                holderInsuredRelation.setCode(relation.getValue());
                holderInsuredRelation.setDesc(relation.getDisplay());
                return holderInsuredRelation;
            }).collect(Collectors.toList());
            productDict.setHolderInsuredRelations(holderInsuredRelations);
        }

        //获取投保的最大最小年龄
        String minAge = resProductDetail.getResponse().getProductSerialsList().get(0).getProductRule().getMinAge().toString();
        String maxAge = resProductDetail.getResponse().getProductSerialsList().get(0).getProductRule().getMaxAge().toString();

        if (minAge != null) {
            productDict.setMinAge(minAge);
        } else {
            productDict.setMinAge("0");
        }
        if (maxAge != null) {
            productDict.setMaxAge(maxAge);
        } else {
            productDict.setMaxAge("100");
        }

        //获取费率试算因子
        ProductFee productFee = resProductDetail.getResponse().getProductFee();
        if (productFee != null) {
            if (CollectionUtils.isNotEmpty(productFee.getSex())) {
                List<Dict> Sex = productFee.getSex().stream().map(baseClass -> {
                    Dict sex = new Dict();
                    sex.setCode(baseClass.getValue());
                    sex.setDesc(baseClass.getDisplay());
                    return sex;
                }).collect(Collectors.toList());
                productDict.setSex(Sex);
            }
            if (CollectionUtils.isNotEmpty(productFee.getPeriods())) {
                List<Dict> periods = productFee.getPeriods().stream().map(baseClass -> {
                    Dict period = new Dict();
                    period.setCode(baseClass.getValue());
                    period.setDesc(baseClass.getDisplay());
                    return period;
                }).collect(Collectors.toList());
                productDict.setPeriods(periods);
            }
            if (CollectionUtils.isNotEmpty(productFee.getPayPeriod())) {
                List<Dict> payPeriod = productFee.getPayPeriod().stream().map(baseClass -> {
                    Dict payperiod = new Dict();
                    payperiod.setCode(baseClass.getValue());
                    payperiod.setDesc(baseClass.getDisplay());
                    return payperiod;
                }).collect(Collectors.toList());
                productDict.setPayPeriod(payPeriod);
            }
            if (CollectionUtils.isNotEmpty(productFee.getSocialSecurity())) {
                List<Dict> socialSecurity = productFee.getSocialSecurity().stream().map(baseClass -> {
                    Dict socialsecurity = new Dict();
                    socialsecurity.setCode(baseClass.getValue());
                    socialsecurity.setDesc(baseClass.getDisplay());
                    return socialsecurity;
                }).collect(Collectors.toList());
                productDict.setSocialSecurity(socialSecurity);
            }
            //获取保额方案
            if (CollectionUtils.isNotEmpty(resProductDetail.getResponse().getProductSerialsList().get(0).getPlancode())) {
                List<Dict> amounts = resProductDetail.getResponse().getProductSerialsList().get(0).getPlancode().stream().filter(planCode -> {
                    return StringUtils.isNotEmpty(planCode.getValue()) && StringUtils.isNotEmpty(planCode.getDisplay());
                }).map(planCode -> {
                    Dict planCodes = new Dict();
                    planCodes.setCode(planCode.getValue());
                    planCodes.setDesc(planCode.getDisplay());
                    return planCodes;
                }).collect(Collectors.toList());
                productDict.setAmount(amounts);
            }
        }

        return productDict;
    }

    /**
     * 组装普通产品核保参数
     *
     * @param productDetail
     * @return
     */
    public UnderWriteRequest getGeneralUnderWriteOb(BaseResponse<ProductDetail> productDetail,
                                                    String age, String relation,
                                                    String payperiod, String period,
                                                    String insuredAmount) {
        UnderWriteRequest underWriteRequest = new UnderWriteRequest();
        underWriteRequest.setAccount("cpjcpin");
        underWriteRequest.setAccountType("JD_PIN");
        //判断是否是续期产品
        if (productDetail.getResponse().getProductRenewal() != null) {
            CardSign cardsign = new CardSign();
            if (productDetail.getResponse().getProductRenewal().getCollection() != null) {
                cardsign.setBankAccountNo("6228480030820693718");
                cardsign.setBankCode("103");
                cardsign.setBankHolderName("投保人姓名");
            }
            underWriteRequest.setCardSign(cardsign);
        }
        //投被保人关系列表，即给 本人、子女、父母、配偶
        List<BaseClass> holderRelationList = productDetail.getResponse().getProductBase().getHolderInsuredRelations();
        //0-本人 ,1-父母, 2-子女, 5-配偶
        String holderRelation = "0";
        if (holderRelationList.size() == 1) {
            holderRelation = holderRelationList.get(0).getValue();
        } else {
            if (StringUtils.isNotEmpty(relation)) {
                holderRelation = relation;
            } else {
                holderRelation = "0";//默认给本人
            }

        }
        boolean isLimitSex = false;
        String sex = "2";
        //产品是否限制性别购买 sex =2 是女  1是男
        if (productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getLimitSex() != null && productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getLimitSex() != "") {
            if (productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getLimitSex().equalsIgnoreCase("2")) {
                isLimitSex = false;    //限制女性购买
            } else {
                isLimitSex = true;//限制男性购买
                sex = "1";
            }

        } else {
            isLimitSex = false;//默认女
            sex = "2";
        }

        int minAge = productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getMinAge();
        int maxAge = productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getMaxAge();
        Calendar ageHolderInsuerd = null;
        Calendar ageInsuer = null;

        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isNotEmpty(age) && StringUtils.isNotEmpty(relation)) {
            map.put("age", age);
            if (relation.equals("0")) {
                ageHolderInsuerd = GetAgeUtil.getBirthDayByAge(age);
            } else {
                ageHolderInsuerd = GetAgeUtil.getBirthDayByAge("24");
                ageInsuer = GetAgeUtil.getBirthDayByAge(age);
            }
        } else {
            ageHolderInsuerd = GetAgeUtil.getAgeInsured(holderRelation, minAge);
        }
        //投保人信息
        Applicant applicant = getApplicantInfo(ageHolderInsuerd, isLimitSex);
        underWriteRequest.setApplicant(applicant);
        map.put("sex", sex);
        if (StringUtils.isNotEmpty(payperiod)) {
            map.put("payperiod", payperiod);
        }
        if (StringUtils.isNotEmpty(period)) {
            map.put("period", period);
        }
        if (StringUtils.isNotEmpty(insuredAmount)) {
            map.put("InsuredAmount", insuredAmount);
        }
        // 获取产品试算参数对象 int age,ProductDetail productDetail,int sex
        String trialParam = getPriceParamBySkuId(productDetail, map, holderRelation);
        String defaultPriceYuan = null;
        if (productDetail.getResponse().getProductFee() != null) {
            if ((productDetail.getResponse().getProductFee().getSocialSecurity() != null && productDetail.getResponse().getProductFee().getSocialSecurity().size() >= 1) || (productDetail.getResponse().getProductFee().getPeriods() != null && productDetail.getResponse().getProductFee().getPeriods().size() > 1) || (productDetail.getResponse().getProductFee().getPayPeriod() != null && productDetail.getResponse().getProductFee().getPayPeriod().size() > 1) || (productDetail.getResponse().getProductFee().getInsureAmount() != null && productDetail.getResponse().getProductFee().getInsureAmount().size() > 1) || (productDetail.getResponse().getProductFee().getAge() != null && productDetail.getResponse().getProductFee().getAge().size() > 1) || (productDetail.getResponse().getProductFee().getSex() != null && productDetail.getResponse().getProductFee().getSex().size() > 1) || (productDetail.getResponse().getProductFee().getExtend() != null && productDetail.getResponse().getProductFee().getExtend().size() > 1)) {
                if (trialParam != null) {
                    defaultPriceYuan = getPriceBySkuId(HttpClientUtils.PREMIUM_TRIAL_URL, trialParam);
                    if (StringUtils.isEmpty(defaultPriceYuan)) {
                        return null;
                    }
                }
            } else {
                defaultPriceYuan = getPriceBySkuId(HttpClientUtils.PREMIUM_TRIAL_URL, trialParam);
                if (StringUtils.isEmpty(defaultPriceYuan)) {
                    defaultPriceYuan =productDetail.getResponse().getProductBase().getDefaultPrice();
                }
            }

        }
        BigDecimal bigDecimal = new BigDecimal(defaultPriceYuan).multiply(new BigDecimal("100"));
        Long defaultPrice = bigDecimal.longValue();

        //保单信息
        Insurance insureance = new Insurance();
        if (StringUtils.isNotEmpty(insuredAmount)) {
            insureance.setAmount(insuredAmount);
        } else {
            insureance.setAmount(productDetail.getResponse().getProductFee().getInsureAmount().get(0).getValue());
        }

        Integer validDay = null;

        if (productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getMinValidDays() == null) {
            insureance.setBeginDate(getNextDay(1));
        } else {
            validDay = productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getMinValidDays();
            insureance.setBeginDate(getNextDay(validDay));
        }

        if (StringUtils.isNotEmpty(period)) {
            insureance.setInsurancePeriod(period);
        } else {
            insureance.setInsurancePeriod(productDetail.getResponse().getProductFee().getPeriods().get(0).getValue());
        }
        insureance.setInsurancePeriodType(productDetail.getResponse().getProductFee().getPeriods().get(0).getValueType());
        insureance.setItemId(productDetail.getResponse().getProductBase().getProductCode());
        if (productDetail.getResponse().getProductRenewal() != null) {
            insureance.setPaymentFrequency(productDetail.getResponse().getProductRenewal().getPayFrequency().get(0).getValue());
        }

        if (StringUtils.isNotEmpty(payperiod)) {
            insureance.setPaymentPeriod(payperiod);
            insureance.setPaymentPeriodType(productDetail.getResponse().getProductFee().getPayPeriod().get(0).getValueType());
        } else {
            if (productDetail.getResponse().getProductFee().getPayPeriod() != null) {
                insureance.setPaymentPeriodType(productDetail.getResponse().getProductFee().getPayPeriod().get(0).getValueType());
                insureance.setPaymentPeriod(productDetail.getResponse().getProductFee().getPayPeriod().get(0).getValue());
            }
        }

        if (productDetail.getResponse().getProductSerialsList().get(0).getPlancode() != null) {
            insureance.setPlanCode(productDetail.getResponse().getProductSerialsList().get(0).getPlancode().get(0).getValue());
        }
//		productDetail.getResponse().getProductSerialsList().get(0).getPlancode();
        insureance.setTotalPrice(defaultPrice);
        underWriteRequest.setInsurance(insureance);
        underWriteRequest.setIp("127.0.0.1");
//        productDetail.getResponse()..getProductFee().getSocialSecurity().get(0).getValue();

        //被保人信息
        List<Insured> insuredList = getInsuredInfo(holderRelation, ageInsuer, applicant, isLimitSex, defaultPrice);
        underWriteRequest.setInsuredList(insuredList);

        //平台商户
        Merchant merchant = new Merchant();
        merchant.setMerchantNo("1018120001");
        merchant.setMerchantName("京东金融");
        underWriteRequest.setMerchant(merchant);
        return underWriteRequest;
    }

    public Applicant getApplicantInfo(Calendar birthAge, boolean isLimitSex) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String certificateNo = GetAgeUtil.getIdNo(sdf.format(birthAge.getTime()), isLimitSex);
        Applicant application = new Applicant();
        application.setName("晓卉");
        application.setCertificateType("1");
        application.setBirthday(sdf1.format(birthAge.getTime()));
        application.setCertificateNo(certificateNo);
        if (isLimitSex) {
            application.setSex("1");
        } else {
            application.setSex("2");
        }
        application.setEmail("59105@qq.com");
        application.setMobile("13246477320");
        application.setProvinceId("110000");
        application.setAreaId("110106");
        application.setCityId("110100");
        application.setAddress("经济开发区科创11街京东大厦A座");
        return application;

    }

    /**
     * 组装被保人信息
     *
     * @param holderRelation
     * @param dateOfBirth
     * @param applicant
     * @param isLimitSex
     * @param defaultPrice
     * @return
     */
    public List<Insured> getInsuredInfo(String holderRelation, Calendar dateOfBirth, Applicant applicant,
                                        boolean isLimitSex, Long defaultPrice) {
        List<Insured> insuredList = new ArrayList<Insured>();
        Insured insured = new Insured();
        if ("0".equals(holderRelation)) {
            insured.setBirthday(applicant.getBirthday());
            insured.setCertificateNo(applicant.getCertificateNo());
            insured.setCertificateType(applicant.getCertificateType());
            insured.setCount(1);
            insured.setEmail(applicant.getEmail());
//		  insured.setHeight(1L);
            insured.setMainPrice(defaultPrice);
            insured.setMobile(applicant.getMobile());
            insured.setName(applicant.getName());
            insured.setNumber("1");
//		  insured.setOccupation("");
            insured.setRelation(holderRelation + "");
            insured.setSex(applicant.getSex());
//		  insured.setSocialSecurity();
//		  insured.setSpecialPrice(specialPrice);
//		  insured.setUseSpecial(useSpecial);
//		  insured.setWeight(weight);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            String certificateNo = GetAgeUtil.getIdNo(sdf.format(dateOfBirth.getTime()), isLimitSex);
            insured.setBirthday(sdf1.format(dateOfBirth.getTime()));
            insured.setCertificateNo(certificateNo);
            insured.setCertificateType("1");
            insured.setCount(1);
            insured.setEmail(applicant.getEmail());
            insured.setMainPrice(defaultPrice);
            insured.setMobile(applicant.getMobile());
            insured.setName("晓卉二 ");
            insured.setNumber("1");
            insured.setRelation(holderRelation + "");
            if (isLimitSex) {
                insured.setSex("1");
            } else {
                insured.setSex("2");
            }
        }
        insuredList.add(insured);
        return insuredList;
    }

    /**
     * 核保
     *
     * @param
     * @return
     */
    public BaseCheckResult feeUnderWrite(BaseResponse<ProductDetail> productDetail,
                                         String age, String relation,
                                         String payperiod, String period,
                                         String insuredAmount) {
        String amount = getTransParam(productDetail, insuredAmount);
        UnderWriteRequest underWriteReq = getGeneralUnderWriteOb(productDetail, age, relation, payperiod, period, amount);
        BaseResponse<UnderWriteResponse> underWriteRes = jsfUnderWriteResource.underwrite(underWriteReq);
        BaseCheckResult feeUnderWriteResult = new BaseCheckResult();
        feeUnderWriteResult.setCheckAge(age);
        if (underWriteRes.isSuccess() && Objects.equals(underWriteRes.getCode(), "0000")) {
            feeUnderWriteResult.setCheckPremium(underWriteRes.getResponse().getUnderWriteOrder().getOrderPrice().toString());
            feeUnderWriteResult.setCheckMark("订单号" + underWriteRes.getResponse().getUnderWriteOrder().getOrderId());
            feeUnderWriteResult.setCheckResult("核保成功");
        } else {
            feeUnderWriteResult.setCheckPremium(underWriteReq.getInsurance().getTotalPrice().toString());
            feeUnderWriteResult.setCheckMark(underWriteRes.getMessage());
            feeUnderWriteResult.setCheckResult("核保失败");
        }
        return feeUnderWriteResult;
    }

    /**
     * 出单
     *
     * @param res
     */
    public BaseResponse issuePolicy(BaseResponse<UnderWriteResponse> res) {
        IssueRequest ireq = new IssueRequest();
        ireq.setAccount("cpjcpin");//pin
        ireq.setAccountType(AccountTypeEnum.JD_PIN.code());
        ireq.setChannel("test");
        ireq.setConfirmResultType("full");
        ireq.setIp("127.0.0.0");
        Merchant merchant = new Merchant();
        merchant.setMerchantNo("1018120001");
        merchant.setMerchantName("京东金融");
        merchant.setSceneCode("0001");
        ireq.setMerchant(merchant);
        ireq.setMerchantId("500");
        ireq.setOrderConfirmTime(new Date());
        ireq.setOrderId(res.getResponse().getUnderWriteOrder().getOrderId());
        ireq.setPayEnum(758);
        ireq.setPayId("75823319022210032102813");
        ireq.setPayTime(new Date());
        ireq.setRealPayPrice(res.getResponse().getUnderWriteOrder().getOrderPrice());

        BaseResponse rese = jsfIssueResource.issue(ireq);
        System.out.println("issue" + rese.toString());
        return rese;
    }

    //保单生效日期
    public String getNextDay(int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +day);
        String nextDay = sdf.format(calendar.getTime()) + " 00:00:00";
        return nextDay;
    }

    public String getPriceParamBySkuId(BaseResponse<ProductDetail> productDetail, Map mapParam, String
            holderRelation) {
        ProductPriceReqTr pprt = new ProductPriceReqTr();
        if (mapParam.get("age") != null) {
            String insuredAge = mapParam.get("age").toString();
            pprt.setAge(Integer.parseInt(insuredAge));
        } else {
            if (holderRelation.equals("0")) {
                pprt.setAge(23);
            } else if (holderRelation.equals("1")) {
                pprt.setAge(productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getMinAge() + 1);
            } else if (holderRelation.equals("2")) {
                pprt.setAge(10);
            } else {
                pprt.setAge(25);
            }
        }
        if (mapParam.get("InsuredAmount") != null) {
            pprt.setAmount(mapParam.get("InsuredAmount").toString());
        } else {
            pprt.setAmount(productDetail.getResponse().getProductFee().getInsureAmount().get(0).getValue());
        }
        if (mapParam.get("sex") != null) {
            pprt.setGender(Integer.parseInt(mapParam.get("sex").toString()));//性别
        }
        if (mapParam.get("payperiod") != null) {
            pprt.setPayPeriod(mapParam.get("payperiod").toString());
        } else {
            if (productDetail.getResponse().getProductFee().getPayPeriod() != null) {
                pprt.setPayPeriod(productDetail.getResponse().getProductFee().getPayPeriod().get(0).getValue());
                pprt.setPayPeriodType(productDetail.getResponse().getProductFee().getPayPeriod().get(0).getValueType());
            }
        }

        pprt.setPin("testpin");
        if (productDetail.getResponse().getProductSerialsList() != null) {
            if (productDetail.getResponse().getProductSerialsList().get(0).getPlancode() != null) {
                pprt.setPlanCode(productDetail.getResponse().getProductSerialsList().get(0).getPlancode().get(0).getValue());
            } else {
                pprt.setPlanCode("0");
            }
        } else {
            pprt.setPlanCode("0");
        }
        pprt.setProductCode(productDetail.getResponse().getProductBase().getProductCode());
        if (mapParam.get("period") != null) {
            pprt.setProductPeriod(mapParam.get("period").toString());
        } else {
            if (productDetail.getResponse().getProductFee().getPeriods() != null) {
                pprt.setProductPeriod(productDetail.getResponse().getProductFee().getPeriods().get(0).getValue());//保障期间
            }
        }
        //      pprt.setSocialSecurity("true");
        String json = JSON.toJSONString(pprt);
        return json;
    }

    public String getPriceBySkuId(String url, String json) {
        ProductAlternative pa = null;
        String price = null;
        try {
            pa = HttpClientUtils.HttpClientGet(url, json);
            if (pa != null) {
                price = pa.getDefaultPrice();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }

    public String getTransParam(BaseResponse<ProductDetail> productDetail,
                                String insuredAmount) {
        Map<String, Object> extend;
        extend = productDetail.getResponse().getProductSerialsList().get(0).getExtend();
        String key = getPlanCodeKey(extend, insuredAmount);
        return key;
    }

    /**
     * 根据planCode extend里的value值获取key值
     *
     * @param value
     * @return
     */
    public String getPlanCodeKey(Map<String, Object> extendMap, String value) {
        for (Map.Entry<String, Object> extend : extendMap.entrySet()) {
            if (Objects.equals(extend.getValue().toString(), value)) {
                return extend.getKey();
            }
        }
        return null;
    }

    /**
     * 获取核保结果
     *
     * @param sku
     * @return
     */
    public BaseCheckResult getUnderWriteRes(String sku) {
        BaseCheckResult underCheckCheckResult = new BaseCheckResult();
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        if (Objects.equals(productdetailRes.getCode(), "0000")) {
            UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes, null, null, null, null, null);
            BaseResponse<UnderWriteResponse> underwriteRes = jsfUnderWriteResource.underwrite(under);
            underCheckCheckResult.setCheckItem("核保检测");
            if (underwriteRes.isSuccess() && Objects.equals(underwriteRes.getCode(), "0000")) {
                String orderId = underwriteRes.getResponse().getUnderWriteOrder().getOrderId();
                if(!("没有获取到投保单号".equals(getProposalNoByOrderId(orderId)) ||"没有获取到相应保单".equals(getProposalNoByOrderId(orderId)))){
                    underCheckCheckResult.setCheckResult("检测通过");
                    underCheckCheckResult.setCheckResultDesc("订单号：" + orderId + "<br>" + "投保单号：" + getProposalNoByOrderId(orderId));
                    underCheckCheckResult.setCheckMark("");
                }
                else{
                    underCheckCheckResult.setCheckResult("检测失败");
                    underCheckCheckResult.setCheckResultDesc("订单号：" + orderId + "<br>" + "投保单号：" + getProposalNoByOrderId(orderId));
                    underCheckCheckResult.setCheckMark("");
                }
                underCheckCheckResult.setCheckResult("检测通过");
                underCheckCheckResult.setCheckResultDesc("订单号：" + orderId + "<br>" + "投保单号：" + getProposalNoByOrderId(orderId));
                underCheckCheckResult.setCheckMark("");
            } else {
                underCheckCheckResult.setCheckResult("检测失败");
                underCheckCheckResult.setCheckResultDesc(underwriteRes.getCode());
                underCheckCheckResult.setCheckMark(underwriteRes.getMessage());
            }
        } else {
            underCheckCheckResult.setCheckItem("核保检测");
            underCheckCheckResult.setCheckResult("检测失败");
            underCheckCheckResult.setCheckResultDesc(productdetailRes.getMessage());
        }
        return underCheckCheckResult;
    }

    /**
     * 根据orderId获取投保单号
     *
     * @param orderId
     * @return
     */
    private String getProposalNoByOrderId(String orderId) {
        PolicyorderExample policyorderExample = new PolicyorderExample();
        PolicyorderExample.Criteria queryCond = policyorderExample.createCriteria();
        queryCond.andOrderidEqualTo(orderId);
        List<Policyorder> policyorderList = policyorderMapper.selectByExample(policyorderExample);
        if (CollectionUtils.isNotEmpty(policyorderList)) {
            if(policyorderList.get(0).getProposalno()!=null){
                return policyorderList.get(0).getProposalno();
            }
           else{
                return "没有获取到投保单号";
            }
        } else {
            return "没有获取到相应保单";
        }
    }

    /**
     * 根据orderId获得保单号
     *
     * @param orderId
     * @return
     */
    private String getPolicyNoByOrderId(String orderId) {
        PolicyorderExample policyorderExample = new PolicyorderExample();
        PolicyorderExample.Criteria queryCond = policyorderExample.createCriteria();
        queryCond.andOrderidEqualTo(orderId);
        List<Policyorder> policyorderList = policyorderMapper.selectByExample(policyorderExample);
        if (CollectionUtils.isNotEmpty(policyorderList)) {
            if(policyorderList.get(0).getPolicyno() !=null)
            {
                return policyorderList.get(0).getPolicyno();
            }
            else{
                return "没有获取到保单号";
            }
        } else {
            return "没有获取到相应保单";
        }
    }

    /*
     * 获取出单结果
     * */
    public BaseCheckResult getIssueRes(String sku) {
        BaseCheckResult issueCheckResult = new BaseCheckResult();
        BaseResponse issueRes;
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        if (Objects.equals(productdetailRes.getCode(), "0000")) {
            UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes, null, null, null, null, null);
            BaseResponse<UnderWriteResponse> underwriteResp = jsfUnderWriteResource.underwrite(under);
            if (underwriteResp != null) {
                if (Objects.equals(underwriteResp.getCode(), "0000")) {
                    issueCheckResult.setCheckItem("出单检测");
                    issueRes = issuePolicy(underwriteResp);
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String orderId = underwriteResp.getResponse().getUnderWriteOrder().getOrderId();
                    if (Objects.equals(issueRes.getCode(), "0000")) {
                        if(!("没有获取到保单号".equals(getPolicyNoByOrderId(orderId))||"没有获取到相应保单".equals(getPolicyNoByOrderId(orderId)))){
                            issueCheckResult.setCheckResult("检测通过");
                            issueCheckResult.setCheckResultDesc("订单号：" + orderId + "<br>" + "保单号：" + getPolicyNoByOrderId(orderId));
                            issueCheckResult.setCheckMark(issueRes.getMessage());
                        }
                        else{
                            issueCheckResult.setCheckResult("检测失败");
                            issueCheckResult.setCheckResultDesc("订单号：" + orderId + "<br>" + "保单号：" + getPolicyNoByOrderId(orderId));
                            issueCheckResult.setCheckMark(issueRes.getMessage());
                        }
                    } else {
                        issueCheckResult.setCheckResult("检测失败");
                        issueCheckResult.setCheckResultDesc("订单号：" + orderId);
                        issueCheckResult.setCheckMark(issueRes.getMessage());
                    }

                } else {
                    issueCheckResult.setCheckItem("出单检测");
                    issueCheckResult.setCheckResult("核保失败");
                    issueCheckResult.setCheckResultDesc(underwriteResp.getMessage());
                    issueCheckResult.setCheckMark("");
                }
            }
        } else {
            issueCheckResult.setCheckItem("出单检测");
            issueCheckResult.setCheckResult(productdetailRes.getResponse().toString());
            issueCheckResult.setCheckResultDesc(productdetailRes.getMessage());
        }
        return issueCheckResult;
    }

    /**
     * 根据orderId获取电子保单
     *
     * @param orderId
     * @return
     */
    private String getOnLinePolicyByOrderId(String orderId) {
        PolicyorderExample policyorderExample = new PolicyorderExample();
        PolicyorderExample.Criteria queryCond = policyorderExample.createCriteria();
        queryCond.andOrderidEqualTo(orderId);
        List<Policyorder> policyorderList = policyorderMapper.selectByExample(policyorderExample);
        if (CollectionUtils.isNotEmpty(policyorderList)) {
            if(policyorderList.get(0).getDownloadurl()!=null){
                return policyorderList.get(0).getDownloadurl();
            }
            else {
                return "没有获取到电子保单";
            }
        } else {
            return "没有获取到相应保单";
        }
    }

    /**
     * 获取电子保单检测结果
     *
     * @param sku 入参
     * @return
     */
    public BaseCheckResult getOnLinePolicyRes(String sku) {
        BaseCheckResult onLinePolicyCheckResult = new BaseCheckResult();
        onLinePolicyCheckResult.setCheckItem("电子保单检测");
        BaseResponse issueRes;
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        if (Objects.equals(productdetailRes.getCode(), "0000")) {
            UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes, null, null, null, null, null);
            BaseResponse<UnderWriteResponse> underwriteResp = jsfUnderWriteResource.underwrite(under);

            if (Objects.equals(underwriteResp.getCode(), "0000")) {
                String orderId = underwriteResp.getResponse().getUnderWriteOrder().getOrderId();
                issueRes = issuePolicy(underwriteResp);
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String proposalNo = getProposalNoByOrderId(orderId);
                if (Objects.equals(issueRes.getCode(), "0000")) {
                    String policyNo = getPolicyNoByOrderId(orderId);
                    String policyUrl = getOnLinePolicyByOrderId(orderId);
                    if ("没有获取到电子保单".equals(policyUrl) ||"没有获取到相应保单".equals(policyUrl)) {
                        onLinePolicyCheckResult.setCheckResult("检测失败");
                        onLinePolicyCheckResult.setCheckResultDesc("订单号：" + orderId + "<br>" + "保单号：" + policyNo + "<br>" + "电子保单：" + policyUrl);
                        onLinePolicyCheckResult.setCheckMark("");
                    } else {
                        onLinePolicyCheckResult.setCheckResult("检测通过");
                        onLinePolicyCheckResult.setCheckResultDesc("订单号：" + orderId + "<br>" + "保单号：" + policyNo + "<br>" + " 电子保单" + policyUrl);
                        onLinePolicyCheckResult.setCheckMark("");
                    }
                } else {
                    onLinePolicyCheckResult.setCheckResult("检测失败");
                    onLinePolicyCheckResult.setCheckResultDesc("订单号：" + orderId + "<br>" + " 投保单号：" + proposalNo);
                    onLinePolicyCheckResult.setCheckMark("出单失败。" + issueRes.getMessage());
                }
            } else {
                onLinePolicyCheckResult.setCheckResult("检测失败");
                onLinePolicyCheckResult.setCheckResultDesc(underwriteResp.getMessage());
                onLinePolicyCheckResult.setCheckMark("核保失败。");
            }
        } else {
            onLinePolicyCheckResult.setCheckResult("检测失败");
            onLinePolicyCheckResult.setCheckResultDesc(productdetailRes.getResponse().toString());
            onLinePolicyCheckResult.setCheckMark(productdetailRes.getMessage());
        }
        return onLinePolicyCheckResult;
    }

    /**
     * 重复核保case调用
     *
     * @param sku
     * @return
     */
    public BaseCheckResult getUnderWriteOnceMoreRes(String sku) {
        BaseCheckResult underWriteOnceMoreCheckResult = new BaseCheckResult();
        underWriteOnceMoreCheckResult.setCheckItem("重复核保检测");
        BaseResponse issueRes;
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        if (Objects.equals(productdetailRes.getCode(), "0000")) {
            UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes, null, null, null, null, null);
            BaseResponse<UnderWriteResponse> underwriteResp = jsfUnderWriteResource.underwrite(under);
            if (underwriteResp.isSuccess() && Objects.equals(underwriteResp.getCode(), "0000")) {
                String firstOrderId = underwriteResp.getResponse().getUnderWriteOrder().getOrderId();
                issueRes = issuePolicy(underwriteResp);
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (issueRes.isSuccess() && Objects.equals(issueRes.getCode(), "0000")) {
                    String firstPolicyNo = getPolicyNoByOrderId(firstOrderId);
                    if("没有获取到保单号".equals(firstPolicyNo)||"没有获取到相应保单".equals(firstPolicyNo)){
                        underWriteOnceMoreCheckResult.setCheckResult("检测失败");
                        underWriteOnceMoreCheckResult.setCheckResultDesc("第一次核保订单号：" + firstOrderId + "<br>" + "第一次承保保单号：" + firstPolicyNo);
                        underWriteOnceMoreCheckResult.setCheckMark("第一次出单失败");
                    }
                    else{
                        BaseResponse<UnderWriteResponse> underwriteOnceMoreResp = jsfUnderWriteResource.underwrite(under);
                        if (Objects.equals(underwriteOnceMoreResp.getCode(), "0000")) {
                            String secondOrderId = underwriteOnceMoreResp.getResponse().getUnderWriteOrder().getOrderId();
                            String secondProposalNo = getProposalNoByOrderId(secondOrderId);
                            underWriteOnceMoreCheckResult.setCheckResult("检测失败");
                            underWriteOnceMoreCheckResult.setCheckResultDesc("第一次核保订单号：" + firstOrderId + "<br>" + "第一次承保保单号：" + firstPolicyNo + "<br>" + "第二次核保订单号：" + secondOrderId + "<br>" + "第二次投保单号：" + secondProposalNo);
                            underWriteOnceMoreCheckResult.setCheckMark("第二次核保成功");
                        } else {
                            underWriteOnceMoreCheckResult.setCheckResult("检测成功");
                            underWriteOnceMoreCheckResult.setCheckResultDesc("第一次核保订单号：" + firstOrderId + "<br>" + "第一次承保保单号：" + firstPolicyNo);
                            underWriteOnceMoreCheckResult.setCheckMark("第二次核保没有通过" + underwriteOnceMoreResp.getMessage());
                        }
                    }

                } else {
                    underWriteOnceMoreCheckResult.setCheckResult("检测失败");
                    underWriteOnceMoreCheckResult.setCheckResultDesc("第一次核保订单号：" + firstOrderId);
                    underWriteOnceMoreCheckResult.setCheckMark("第一次出单失败。" + issueRes.getMessage());
                }
            } else {
                underWriteOnceMoreCheckResult.setCheckResult("检测失败");
                underWriteOnceMoreCheckResult.setCheckResultDesc(underwriteResp.getMessage());
                underWriteOnceMoreCheckResult.setCheckMark("核保失败");
            }
        } else {
            underWriteOnceMoreCheckResult.setCheckResult("检测失败");
            underWriteOnceMoreCheckResult.setCheckResultDesc(productdetailRes.getResponse().toString());
            underWriteOnceMoreCheckResult.setCheckMark(productdetailRes.getMessage());
        }
        return underWriteOnceMoreCheckResult;
    }

    /**
     * 获取重复出单结果
     *
     * @param sku
     * @return
     */
    public BaseCheckResult getIssueOnceMoreRes(String sku) {
        BaseCheckResult issueOnceMoreCheckResult = new BaseCheckResult();
        issueOnceMoreCheckResult.setCheckItem("重复出单检测");
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        if (Objects.equals(productdetailRes.getCode(), "0000")) {
            UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes, null, null, null, null, null);
            BaseResponse<UnderWriteResponse> underwriteResp1 = jsfUnderWriteResource.underwrite(under);
            if (underwriteResp1.isSuccess() && Objects.equals(underwriteResp1.getCode(), "0000")) {
                String firstOrderId = underwriteResp1.getResponse().getUnderWriteOrder().getOrderId();
                BaseResponse<UnderWriteResponse> underwriteResp2 = jsfUnderWriteResource.underwrite(under);
                String secondOrderId = underwriteResp2.getResponse().getUnderWriteOrder().getOrderId();
                BaseResponse issueRes1;
                BaseResponse issueRes2;
                issueRes1 = issuePolicy(underwriteResp1);
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                issueRes2 = issuePolicy(underwriteResp2);
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String firstPolicyNo = getPolicyNoByOrderId(firstOrderId);
                String secongPolicyNo = getPolicyNoByOrderId(secondOrderId);
                if (issueRes1.isSuccess() && Objects.equals(issueRes1.getCode(), "0000")) {
                    if(!("没有获取到保单号".equals(firstPolicyNo)||"没有获取到相应保单".equals(firstPolicyNo))){
                        if (issueRes2.isSuccess() && Objects.equals(issueRes2.getCode(), "0000")) {
                            if("没有获取到保单号".equals(secongPolicyNo)||"没有获取到相应保单".equals(secongPolicyNo)){
                                issueOnceMoreCheckResult.setCheckResult("检测成功");
                                issueOnceMoreCheckResult.setCheckResultDesc("第一次核保订单号：" + firstOrderId + "<br>" + "第一次承保保单号：" + firstPolicyNo + "<br>" + "第二次核保订单号：" + secondOrderId+ "<br>" + "第二次承保保单号：" + secongPolicyNo);
                                issueOnceMoreCheckResult.setCheckMark("第二次出单失败。" + issueRes2.getMessage());
                            }
                            else{
                                issueOnceMoreCheckResult.setCheckResult("检测失败");
                                issueOnceMoreCheckResult.setCheckResultDesc("第一次核保订单号：" + firstOrderId + "<br>" + "第一次承保保单号：" + firstPolicyNo + "<br>" + "第二次核保订单号：" + secondOrderId + "<br>" + "第二次承保保单号：" + secongPolicyNo);
                                issueOnceMoreCheckResult.setCheckMark("第二次出单成功");
                            }
                        } else {
                            issueOnceMoreCheckResult.setCheckResult("检测成功");
                            issueOnceMoreCheckResult.setCheckResultDesc("第一次核保订单号：" + firstOrderId + "<br>" + "第一次承保保单号：" + firstPolicyNo + "<br>" + "第二次核保订单号：" + secondOrderId);
                            issueOnceMoreCheckResult.setCheckMark("第二次出单失败。" + issueRes2.getMessage());
                        }
                    }
                   else{
                        issueOnceMoreCheckResult.setCheckResult("检测失败");
                        issueOnceMoreCheckResult.setCheckResultDesc("第一次核保订单号：" + firstOrderId+ "<br>" + "第一次承保保单号：" + firstPolicyNo);
                        issueOnceMoreCheckResult.setCheckMark("第一次出单失败。" + issueRes1.getMessage());
                    }
                } else {
                    issueOnceMoreCheckResult.setCheckResult("检测失败");
                    issueOnceMoreCheckResult.setCheckResultDesc("第一次核保订单号：" + firstOrderId);
                    issueOnceMoreCheckResult.setCheckMark("第一次出单失败。" + issueRes1.getMessage());
                }
            } else {
                issueOnceMoreCheckResult.setCheckResult("检测失败");
                issueOnceMoreCheckResult.setCheckResultDesc(underwriteResp1.getMessage());
                issueOnceMoreCheckResult.setCheckMark("第一次核保失败");
            }
        } else {
            issueOnceMoreCheckResult.setCheckResult("检测失败");
            issueOnceMoreCheckResult.setCheckResultDesc(productdetailRes.getResponse().toString());
            issueOnceMoreCheckResult.setCheckMark(productdetailRes.getMessage());
        }
        return issueOnceMoreCheckResult;
    }

    /**
     * 获取出单幂等结果
     *
     * @param sku
     * @return
     */
    public BaseCheckResult getIssueIdempotentRes(String sku) {
        BaseCheckResult issueIdempotentResult = new BaseCheckResult();
        issueIdempotentResult.setCheckItem("出单幂等检测");
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        if (StringUtils.equals(productdetailRes.getCode(), "0000")) {
            UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes, null, null, null, null, null);
            BaseResponse<UnderWriteResponse> underwriteResp = jsfUnderWriteResource.underwrite(under);
            if (underwriteResp.isSuccess() && Objects.equals(underwriteResp.getCode(), "0000")) {
                String orderId = underwriteResp.getResponse().getUnderWriteOrder().getOrderId();
                BaseResponse issueRes1 = issuePolicy(underwriteResp);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (issueRes1.isSuccess() && Objects.equals(issueRes1.getCode(), "0000")) {
                    String firstPolicyNo = getPolicyNoByOrderId(orderId);
                    if(!("没有获取到保单号".equals(firstPolicyNo)||"没有获取到相应保单".equals(firstPolicyNo))){
                        PolicyorderExample policyorderExample = new PolicyorderExample();
                        PolicyorderExample.Criteria criteria = policyorderExample.createCriteria();
                        criteria.andOrderidEqualTo(orderId);
                        //更新订单表状态
                        OrdersExample ordersExample = new OrdersExample();
                        OrdersExample.Criteria ordersExampleCriteria = ordersExample.createCriteria();
                        ordersExampleCriteria.andOrderidEqualTo(orderId);
                        Orders orders = new Orders();
                        orders.setStatus(Short.valueOf("4"));
                        int updateOrderResult = ordersMapper.updateByExampleSelective(orders, ordersExample);
                        //更新保单表状态
                        Policyorder policyorder1 = new Policyorder();
                        policyorder1.setStatus(Short.valueOf("1"));
                        int updatePolicyResult = policyorderMapper.updateByExampleSelective(policyorder1, policyorderExample);
                        //删除tradetask  中任务42
                        TradetaskExample tradetaskExample = new TradetaskExample();
                        TradetaskExample.Criteria tradeTaskCriteria = tradetaskExample.createCriteria();
                        tradeTaskCriteria.andOrderidEqualTo(orderId);
                        tradeTaskCriteria.andBiztypeEqualTo("42");
                        int deleteResult = tradetaskMapper.deleteByExample(tradetaskExample);
                        if (updateOrderResult == 1 && updatePolicyResult == 1 && deleteResult == 1) {//修改成功
                            BaseResponse issueRes2 = issuePolicy(underwriteResp);
                            try {
                                Thread.sleep(2000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if ("0000".equals(issueRes2.getCode())) {
                                //订单状态查询
                                List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
                                Orders ordersRepeat = ordersList.get(0);
                                Short orderStatusRepeat = ordersRepeat.getStatus();
                                //保单号及状态查询
                                List<Policyorder> policyorders2 = policyorderMapper.selectByExample(policyorderExample);
                                String secondPolicyNo = getPolicyNoByOrderId(orderId);
                                if (firstPolicyNo.equals(secondPolicyNo)) {
                                    issueIdempotentResult.setCheckResult("检测通过");
                                    issueIdempotentResult.setCheckResultDesc("第一次核保订单号：" + orderId + "<br>" + "第一次承保单号：" + firstPolicyNo + "<br>" + "第二次承保单号：" + secondPolicyNo);
                                    issueIdempotentResult.setCheckMark("");
                                } else {
                                    issueIdempotentResult.setCheckResult("检测失败");
                                    issueIdempotentResult.setCheckResultDesc("第一次核保订单号：" + orderId + "<br>" + "第一次承保单号：" + firstPolicyNo + "<br>" + "第二次承保单号：" + secondPolicyNo);
                                    issueIdempotentResult.setCheckMark("");
                                }
                            } else {
                                issueIdempotentResult.setCheckResult("检测失败");
                                issueIdempotentResult.setCheckResultDesc("第一次核保订单号：" + orderId + "<br>" + "第一次承保单号：" + firstPolicyNo);
                                issueIdempotentResult.setCheckMark("第二次出单失败" + issueRes2.getMessage());
                            }

                        } else {
                            issueIdempotentResult.setCheckResult("检测失败");
                            issueIdempotentResult.setCheckResultDesc("第一次核保订单号：" + orderId + "<br>" + "第一次承保单号：" + firstPolicyNo);
                            issueIdempotentResult.setCheckMark("数据库更新失败，出单幂等未执行");
                        }
                    }
                    else{
                        issueIdempotentResult.setCheckResult("检测失败");
                        issueIdempotentResult.setCheckResultDesc("第一次核保订单号：" + orderId+ "<br>" + "第一次承保单号：" + firstPolicyNo);
                        issueIdempotentResult.setCheckMark("第一次出单失败。" + issueRes1.getMessage());
                    }
                } else {
                    issueIdempotentResult.setCheckResult("检测失败");
                    issueIdempotentResult.setCheckResultDesc("第一次核保订单号：" + orderId);
                    issueIdempotentResult.setCheckMark("第一次出单失败。" + issueRes1.getMessage());
                }
            } else {
                issueIdempotentResult.setCheckResult("检测失败");
                issueIdempotentResult.setCheckResultDesc(underwriteResp.getMessage());
                issueIdempotentResult.setCheckMark("核保失败");
            }
        } else {
            issueIdempotentResult.setCheckResult("检测失败");
            issueIdempotentResult.setCheckResultDesc(productdetailRes.getResponse().toString());
            issueIdempotentResult.setCheckMark(productdetailRes.getMessage());
        }
        return issueIdempotentResult;
    }

}
