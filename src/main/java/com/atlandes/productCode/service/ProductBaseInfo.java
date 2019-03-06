package com.atlandes.productCode.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

//import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.atlandes.productCode.common.*;
import com.atlandes.productCode.entity.BaseCheckResult;
import com.atlandes.productCode.entity.Dict;
import com.atlandes.productCode.entity.ProductDict;
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

import io.netty.util.internal.StringUtil;
import org.apache.commons.collections.CollectionUtils;
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
                List<Dict> amounts = resProductDetail.getResponse().getProductSerialsList().get(0).getPlancode().stream().map(planCode -> {
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
    public UnderWriteRequest getGeneralUnderWriteOb(BaseResponse<ProductDetail> productDetail, String age, String relation, String payperiod, String period, String InsuredAmount, String planCode) {
        UnderWriteRequest underWriteRequest = new UnderWriteRequest();
        underWriteRequest.setAccount("cpjcpin");
        underWriteRequest.setAccountType("JD_PIN");
        //判断是否是续期产品
        if (productDetail.getResponse().getProductRenewal() != null) {
            CardSign cardsign = new CardSign();
            if (productDetail.getResponse().getProductRenewal().getCollection() != null) {
                cardsign.setBankAccountNo("银行卡号");
                cardsign.setBankCode("银行编码");
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
            if (!StringUtil.isNullOrEmpty(relation)) {
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
            }

        } else {
            isLimitSex = false;//默认女
        }

        int minAge = productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getMinAge();
        int maxAge = productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getMaxAge();
        Calendar ageHolderInsuerd = null;
        Calendar ageInsuer = null;

        Map<String, String> map = new HashMap<String, String>();
        if (!StringUtil.isNullOrEmpty(age) && !StringUtil.isNullOrEmpty(relation)) {
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
        if (!StringUtil.isNullOrEmpty(payperiod)) {
            map.put("payperiod", payperiod);
        }
        if (!StringUtil.isNullOrEmpty(period)) {
            map.put("period", period);
        }
        if (!StringUtil.isNullOrEmpty(InsuredAmount)) {
            map.put("InsuredAmount", InsuredAmount);
        }
        // 获取产品试算参数对象 int age,ProductDetail productDetail,int sex
        String trialParam = getPriceParamBySkuId(productDetail, map, holderRelation);
        String defaultPriceYuan = null;
        if (trialParam != null) {
            defaultPriceYuan = getPriceBySkuId(HttpClientUtils.PREMIUM_TRIAL_URL, trialParam);
            if (StringUtil.isNullOrEmpty(defaultPriceYuan)) {
                defaultPriceYuan = productDetail.getResponse().getProductBase().getDefaultPrice();
            }
        } else {
            //默认价格
            defaultPriceYuan = productDetail.getResponse().getProductBase().getDefaultPrice();
        }


        BigDecimal bigDecimal = new BigDecimal(defaultPriceYuan).multiply(new BigDecimal("100"));
        Long defaultPrice = bigDecimal.longValue();

        //保单信息
        Insurance insureance = new Insurance();
        insureance.setAmount(productDetail.getResponse().getProductFee().getInsureAmount().get(0).getValue());
        insureance.setBeginDate(getNextDay(4));
        insureance.setInsurancePeriod(productDetail.getResponse().getProductFee().getPeriods().get(0).getValue());
        insureance.setInsurancePeriodType(productDetail.getResponse().getProductFee().getPeriods().get(0).getValueType());
        insureance.setItemId(productDetail.getResponse().getProductBase().getProductCode());
//		insureance.setPaymentFrequency("");
//		insureance.setPaymentPeriodType(productDetail.getResponse().getProductFee().getPayPeriod().get(0).getValueType());
//		insureance.setPaymentPeriod(productDetail.getResponse().getProductFee().getPayPeriod().get(0).getValue());
//		insureance.setPlanCode("");
//		productDetail.getResponse().getProductSerialsList().get(0).getPlancode();
        insureance.setTotalPrice(defaultPrice);
        underWriteRequest.setInsurance(insureance);
        underWriteRequest.setIp("127.0.0.1");

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
        application.setAddress("经济开发区科创十一街京东大厦A座");
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
    public List<Insured> getInsuredInfo(String holderRelation, Calendar dateOfBirth, Applicant applicant, boolean isLimitSex, Long defaultPrice) {
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
     * @param sku
     * @return
     */
    public BaseResponse<UnderWriteResponse> underWrite(String sku) {
        BaseResponse<ProductDetail> productDetail = getProductDetailBySkuId(sku);
        UnderWriteRequest underWriteReq = new UnderWriteRequest();
        underWriteReq = getGeneralUnderWriteOb(productDetail, null, null, null, null, null, null);
        BaseResponse<UnderWriteResponse> underWriteRes = jsfUnderWriteResource.underwrite(underWriteReq);
        return underWriteRes;
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

    public String getPriceParamBySkuId(BaseResponse<ProductDetail> productDetail, Map mapParam, String holderRelation) {
        ProductPriceReqTr pprt = new ProductPriceReqTr();
        if (mapParam.get("age") != null) {
            String insuredAge = mapParam.get("age").toString();
            pprt.setAge(Integer.parseInt(insuredAge));
        } else {
            if (holderRelation.equals("0")) {
                pprt.setAge(24);
            } else if (holderRelation.equals("1")) {
                pprt.setAge(productDetail.getResponse().getProductSerialsList().get(0).getProductRule().getMinAge() + 1);
            } else if (holderRelation.equals("2")) {
                pprt.setAge(11);
            } else {
                pprt.setAge(26);
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
        pprt.setSocialSecurity("true");
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

    /**
     * 获取核保结果
     *
     * @param sku
     * @return
     */
    public BaseCheckResult getUnderWriteRes(String sku) {
        BaseCheckResult underCheckCheckResult = new BaseCheckResult();
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes, null, null, null, null, null, null);
        BaseResponse<UnderWriteResponse> underwriteRes = jsfUnderWriteResource.underwrite(under);
        underCheckCheckResult.setCheckItem("核保检测");
        if (underwriteRes.isSuccess() && Objects.equals(underwriteRes.getCode(), "0000")) {
            underCheckCheckResult.setCheckResult("检测通过");
            underCheckCheckResult.setCheckResultDesc(underwriteRes.getResponse().getUnderWriteOrder().getOrderId());
            underCheckCheckResult.setCheckMark("");
        } else {
            underCheckCheckResult.setCheckResult("检测失败");
            underCheckCheckResult.setCheckResultDesc(underwriteRes.getCode());
            underCheckCheckResult.setCheckMark(underwriteRes.getMessage());
        }
        return underCheckCheckResult;
    }


    /*
     * 获取出单结果
     * */
    public BaseCheckResult getIssueRes(String sku) {
        BaseCheckResult issueCheckResult = new BaseCheckResult();
        BaseResponse issueRes;
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes, null, null, null, null, null, null);
        BaseResponse<UnderWriteResponse> underwriteResp = jsfUnderWriteResource.underwrite(under);
        if (underwriteResp != null) {
            if (Objects.equals(underwriteResp.getCode(), "0000")) {
                issueCheckResult.setCheckItem("出单检测");
                issueRes = issuePolicy(underwriteResp);

                if (Objects.equals(issueRes.getCode(), "0000")) {
                    issueCheckResult.setCheckResult("检测通过");
                    issueCheckResult.setCheckResultDesc(issueRes.getResponse().toString());
                    issueCheckResult.setCheckMark("");
                } else {
                    issueCheckResult.setCheckResult("检测失败");
                    issueCheckResult.setCheckResultDesc(issueRes.getResponse().toString());
                    issueCheckResult.setCheckMark("");
                }

            } else {
                issueCheckResult.setCheckItem("出单检测");
                issueCheckResult.setCheckResult("核保失败");
                issueCheckResult.setCheckResultDesc(underwriteResp.getResponse().getUnderWriteOrder().getOrderId());
                issueCheckResult.setCheckMark("");
            }
        }
        return issueCheckResult;
    }

    /**
     * 获取电子保单检测结果
     *
     * @param sku 入参
     * @return
     */
    public BaseCheckResult getOnLinePolicyRes(String sku) {
        BaseCheckResult onLinePolicyCheckResult = new BaseCheckResult();
        BaseResponse issueRes;
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes, null, null, null, null, null, null);
        BaseResponse<UnderWriteResponse> underwriteResp = jsfUnderWriteResource.underwrite(under);
        if (Objects.equals(underwriteResp, "0000")) {
            issueRes = issuePolicy(underwriteResp);
            if (issueRes != null) {
                if (Objects.equals(issueRes, "0000")) {
                    onLinePolicyCheckResult.setCheckItem("电子保单检测");
                    PolicyQueryReq policyQueryReq = new PolicyQueryReq();
                    OperDto operDto = new OperDto();
                    operDto.setOperAccount(Constants.OPER_ACCOUNT);
                    operDto.setOperAccountType(Constants.OPER_ACCOUNT_TYPE);
                    operDto.setSourceSystem(Constants.SOURCE_TYPE);
                    operDto.setRequestSeq(String.valueOf(System.currentTimeMillis()));
                    PolicyQueryDto policyQueryDto = new PolicyQueryDto();
                    policyQueryDto.setBuyerAccount(Constants.ACCOUNT);
                    policyQueryDto.setOrderId(underwriteResp.getResponse().getUnderWriteOrder().getOrderId());
                    policyQueryDto.setBuyerType(Constants.ACCOUNT_TYPE);
                    policyQueryReq.setPolicyQueryDto(policyQueryDto);
                    PolicyQueryRes res = policyQueryService.queryPolicy(policyQueryReq, operDto);
                    List<String> policyIdList = new ArrayList<>();

                    if (Objects.equals(res.getResultCode(), "0000")) {
                        List<PolicyDto> policyDtoList = res.getList();
                        if (CollectionUtils.isNotEmpty(policyDtoList)) {
                            policyDtoList.forEach(policyDto -> {
                                policyIdList.add(policyDto.getPolicyDownloadUrl());
                            });
                            if (policyIdList != null) {
                                onLinePolicyCheckResult.setCheckResult("检测通过");
                                String policyDownloadUrl = Joiner.on(",").join(policyIdList);
                                onLinePolicyCheckResult.setCheckResultDesc(policyDownloadUrl);
                                onLinePolicyCheckResult.setCheckMark("");
                            } else {
                                onLinePolicyCheckResult.setCheckResult("检测失败");
                                onLinePolicyCheckResult.setCheckResultDesc(res.getResultMsg());
                                onLinePolicyCheckResult.setCheckMark("没有电子保单");
                            }
                        } else {
                            onLinePolicyCheckResult.setCheckResult("检测失败");
                            onLinePolicyCheckResult.setCheckResultDesc(underwriteResp.getResponse().getUnderWriteOrder().getOrderId());
                            onLinePolicyCheckResult.setCheckMark("保单信息为空");
                        }
                    } else {
                        onLinePolicyCheckResult.setCheckResult("检测失败");
                        onLinePolicyCheckResult.setCheckResultDesc(underwriteResp.getResponse().getUnderWriteOrder().getOrderId());
                        onLinePolicyCheckResult.setCheckMark("获取保单信息失败");
                    }
                } else {
                    onLinePolicyCheckResult.setCheckResult("检测失败");
                    onLinePolicyCheckResult.setCheckResultDesc(issueRes.getResponse().toString());
                    onLinePolicyCheckResult.setCheckMark("出单失败 " + issueRes.getMessage());
                }
            } else {
                onLinePolicyCheckResult.setCheckResult("检测失败");
                onLinePolicyCheckResult.setCheckResultDesc(underwriteResp.getResponse().getUnderWriteOrder().getOrderId());
                onLinePolicyCheckResult.setCheckMark("出单接口调用失败");

            }
        } else {
            onLinePolicyCheckResult.setCheckResult("检测失败");
            onLinePolicyCheckResult.setCheckResultDesc(underwriteResp.getResponse().getUnderWriteOrder().getOrderId());
            onLinePolicyCheckResult.setCheckMark("核保失败 " + underwriteResp.getMessage());
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
        BaseResponse issueRes;
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes, null, null, null, null, null, null);
        BaseResponse<UnderWriteResponse> underwriteResp = jsfUnderWriteResource.underwrite(under);
        underWriteOnceMoreCheckResult.setCheckItem("重复核保检测");
        if (underwriteResp != null) {
            if (Objects.equals(underwriteResp, "0000")) {
                issueRes = issuePolicy(underwriteResp);
                if (issueRes != null) {
                    if (Objects.equals(issueRes, "0000")) {
                        BaseResponse<UnderWriteResponse> underwriteOnceMoreResp = jsfUnderWriteResource.underwrite(under);
                        if (Objects.equals(underWriteOnceMoreCheckResult, "0000")) {
                            underWriteOnceMoreCheckResult.setCheckResult("检测失败");
                            underWriteOnceMoreCheckResult.setCheckResultDesc(underwriteResp.getResponse().getUnderWriteOrder().getOrderId() + "\n" + underwriteOnceMoreResp.getResponse().getUnderWriteOrder().getOrderId());
                            underWriteOnceMoreCheckResult.setCheckMark("第二次核保成功");
                        } else {
                            underWriteOnceMoreCheckResult.setCheckResult("检测成功");
                            underWriteOnceMoreCheckResult.setCheckResultDesc(underwriteResp.getResponse().getUnderWriteOrder().getOrderId());
                            underWriteOnceMoreCheckResult.setCheckMark(underwriteOnceMoreResp.getMessage() + underwriteOnceMoreResp.getResponse().toString());
                        }
                    } else {
                        underWriteOnceMoreCheckResult.setCheckResult("检测失败");
                        underWriteOnceMoreCheckResult.setCheckResultDesc(issueRes.getResponse().toString());
                        underWriteOnceMoreCheckResult.setCheckMark("出单失败");
                    }
                } else {
                    underWriteOnceMoreCheckResult.setCheckResult("检测失败");
                    underWriteOnceMoreCheckResult.setCheckResultDesc(underwriteResp.getResponse().getUnderWriteOrder().getOrderId());
                    underWriteOnceMoreCheckResult.setCheckMark("出单接口调用失败");
                }
            } else {
                underWriteOnceMoreCheckResult.setCheckResult("检测失败");
                underWriteOnceMoreCheckResult.setCheckResultDesc(underwriteResp.getResponse().getUnderWriteOrder().getOrderId());
                underWriteOnceMoreCheckResult.setCheckMark("核保失败 " + underwriteResp.getMessage());
            }
        } else {
            underWriteOnceMoreCheckResult.setCheckResult("检测失败");
            underWriteOnceMoreCheckResult.setCheckResultDesc("核保接口调用失败");
            underWriteOnceMoreCheckResult.setCheckMark("");
        }
        return underWriteOnceMoreCheckResult;
    }

}
