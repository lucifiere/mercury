package com.atlandes.productCode.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

//import org.junit.Test;

import com.atlandes.productCode.common.Constants;
import com.atlandes.productCode.entity.BaseCheckResult;
import com.google.common.base.Joiner;
import com.jd.baoxian.order.trade.export.dto.PolicyDto;
import com.jd.baoxian.order.trade.export.dto.PolicyQueryDto;
import com.jd.baoxian.order.trade.export.dto.base.OperDto;
import com.jd.baoxian.order.trade.export.req.PolicyInfoQueryReq;
import com.jd.baoxian.order.trade.export.req.PolicyQueryReq;
import com.jd.baoxian.order.trade.export.res.PolicyInfoQueryRes;
import com.jd.baoxian.order.trade.export.res.PolicyQueryRes;
import com.jd.baoxian.service.platform.domain.bean.*;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.atlandes.productCode.common.BaseConfig;
import com.atlandes.productCode.common.StringUtils;

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

    public UnderWriteRequest getGeneralUnderWriteOb(BaseResponse<ProductDetail> productDetail) {
        UnderWriteRequest underWriteRequest = new UnderWriteRequest();
        underWriteRequest.setAccount("cpjcpin");
        underWriteRequest.setAccountType("JD_PIN");
        //判断是否是续期产品
        ProductRenewal productRenewal = productDetail.getResponse().getProductRenewal();

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
        int holderRelation = 0;
        if (holderRelationList.size() == 1) {
            holderRelation = Integer.parseInt(holderRelationList.get(0).getValue());
        } else {
            holderRelation = 0;//默认给本人
        }
        boolean isLimitSex = false;
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

        Calendar ageInsuerd = getAgeInsured(holderRelation + "", minAge);
        //投保人信息
        Applicant applicant = getApplicantInfo(ageInsuerd, isLimitSex);
        underWriteRequest.setApplicant(applicant);


        //默认价格
        String dde = productDetail.getResponse().getProductBase().getDefaultPrice();
        BigDecimal df = new BigDecimal(dde);
        BigDecimal hs = df.multiply(new BigDecimal("100"));
        Long defaultPrice = hs.longValue();

        //保单信息
        Insurance insureance = new Insurance();
        insureance.setAmount(productDetail.getResponse().getProductFee().getInsureAmount().get(0).getValue());
        insureance.setBeginDate(getNextDay(1));
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
        List<Insured> insuredList = getInsuredInfo(holderRelation, ageInsuerd, applicant, isLimitSex, defaultPrice);
        underWriteRequest.setInsuredList(insuredList);

        //平台商户
        Merchant merchant = new Merchant();
        merchant.setMerchantNo("1018120001");
        merchant.setMerchantName("京东金融");
        underWriteRequest.setMerchant(merchant);
        return underWriteRequest;
    }

    public Applicant getApplicantInfo(Calendar age, boolean isLimitSex) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String birthAge = sdf.format(age.getTime());
        String certificateNo = StringUtils.getIdNo(birthAge, isLimitSex);
        Applicant application = new Applicant();
        application.setName("晓卉");
        application.setCertificateType("1");
        application.setBirthday(sdf1.format(age.getTime()));
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

    public List<Insured> getInsuredInfo(int holderRelation, Calendar dateOfBirth, Applicant applicant, boolean isLimitSex, Long defaultPrice) {

        List<Insured> insuredList = new ArrayList<Insured>();
        Insured insured = new Insured();
        if (holderRelation == 0) {
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
            String certificateNo = StringUtils.getIdNo(sdf.format(dateOfBirth.getTime()), isLimitSex);
            insured.setBirthday(sdf1.format(dateOfBirth.getTime()));
            insured.setCertificateNo(certificateNo);
            insured.setCertificateType("1");
            insured.setCount(1);
            insured.setEmail(applicant.getEmail());
            insured.setMainPrice(1L);
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

    public Calendar getAgeInsured(String holderRelation, int minAge) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 解析用格式
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String ageInsured = null;
        if (holderRelation.equals("0")) { //得到本人的出生日期
            calendar.add(Calendar.YEAR, -23);//当前时间减去23年
            calendar.add(Calendar.MONTH, -2);//当前时间前去2个月
//			   ageInsured = sdf.format(calendar.getTime());
        } else if (holderRelation.equals("1")) {//得到父母的出生日期
            calendar.add(Calendar.YEAR, -(minAge - 1));//当前时间减去23年
            calendar.add(Calendar.MONTH, -2);//当前时间前去2个月
//			   ageInsured = sdf.format(calendar.getTime());

        } else if (holderRelation.equals("2")) {//得到子女的出生日期
            calendar.add(Calendar.YEAR, -10);
            calendar.add(Calendar.MONTH, -2);
//			   ageInsured = sdf.format(calendar.getTime());
        } else {//得到配偶的出生日期
            calendar.add(Calendar.YEAR, -25);
            calendar.add(Calendar.MONTH, -2);
//			   ageInsured = sdf.format(calendar.getTime());
        }
        return calendar;
    }

    public IssueRequest issuePolicy(BaseResponse<UnderWriteResponse> res) {
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
        return ireq;
    }

    //保单生效日期
    public String getNextDay(int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +day + 3);
        String nextDay = sdf.format(calendar.getTime()) + " 00:00:00";
        return nextDay;
    }

    // @Test
    public void test() {

        BaseResponse<ProductDetail> productdetail = getProductDetailBySkuId("2019011001");
        UnderWriteRequest under = getGeneralUnderWriteOb(productdetail);
        BaseResponse<UnderWriteResponse> res = jsfUnderWriteResource.underwrite(under);
        issuePolicy(res);
        System.out.println("Fdfds" + res.toString());

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
        UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes);
        BaseResponse<UnderWriteResponse> underwriteRes = jsfUnderWriteResource.underwrite(under);
        if (underwriteRes.isSuccess()) {
            underCheckCheckResult.setCheckItem("核保检测");
            if (Objects.equals(underwriteRes.getCode(), "0000")) {
                underCheckCheckResult.setCheckResult("检测通过");
                underCheckCheckResult.setCheckResultDesc(underwriteRes.getResponse().getUnderWriteOrder().getOrderId());
                underCheckCheckResult.setCheckMark("");
            } else {
                underCheckCheckResult.setCheckResult("检测失败");
                underCheckCheckResult.setCheckResultDesc(underwriteRes.getResponse().getUnderWriteOrder().getOrderId());
                underCheckCheckResult.setCheckMark(underwriteRes.getMessage());
            }
            return underCheckCheckResult;
        } else {
            return null;
        }
    }


    /*
     * 获取出单结果
     * */
    public BaseCheckResult getIssueRes(String sku) {
        BaseCheckResult issueCheckResult = new BaseCheckResult();
        IssueRequest issReq;
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes);
        BaseResponse<UnderWriteResponse> underwriteResp = jsfUnderWriteResource.underwrite(under);
        if (underwriteResp != null) {
            issueCheckResult.setCheckItem("出单检测");
            issReq = issuePolicy(underwriteResp);
            BaseResponse issueRes = jsfIssueResource.issue(issReq);
            if (Objects.equals(issueRes.getCode(), "0000")) {
                issueCheckResult.setCheckResult("检测通过");
                issueCheckResult.setCheckResultDesc(issueRes.getResponse().toString());
                issueCheckResult.setCheckMark("");
            } else {
                issueCheckResult.setCheckResult("检测失败");
                issueCheckResult.setCheckResultDesc(issueRes.getResponse().toString());
                issueCheckResult.setCheckMark("");
            }
            return issueCheckResult;
        } else {
            return null;
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
        IssueRequest issReq;
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes);
        BaseResponse<UnderWriteResponse> underwriteResp = jsfUnderWriteResource.underwrite(under);
        if (underwriteResp != null) {
            issReq = issuePolicy(underwriteResp);
            BaseResponse issueRes = jsfIssueResource.issue(issReq);
            if (issueRes != null) {
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
                    }
                    if (policyIdList != null) {
                        onLinePolicyCheckResult.setCheckResult("检测通过");
                        String policyDownloadUrl = Joiner.on(",").join(policyIdList);
                        onLinePolicyCheckResult.setCheckResultDesc(policyDownloadUrl);
                        onLinePolicyCheckResult.setCheckMark("");
                    }
                    else {
                        onLinePolicyCheckResult.setCheckResult("检测失败");
                        onLinePolicyCheckResult.setCheckResultDesc(res.getResultMsg());
                        onLinePolicyCheckResult.setCheckMark("");
                    }
                }

            } else {
                return null;
            }
        } else {
            return null;
        }
        return onLinePolicyCheckResult;
    }

    public String getUnderWriteOnceMoreRes(String sku) {
        IssueRequest issReq;
        BaseResponse<ProductDetail> productdetailRes = getProductDetailBySkuId(sku);
        UnderWriteRequest under = getGeneralUnderWriteOb(productdetailRes);
        BaseResponse<UnderWriteResponse> underwriteResp = jsfUnderWriteResource.underwrite(under);
        if (underwriteResp != null) {
            issReq = issuePolicy(underwriteResp);
            BaseResponse issueRes = jsfIssueResource.issue(issReq);
            if (issueRes != null) {
                String orderIdFirst = issReq.getOrderId();
                BaseResponse<UnderWriteResponse> underwriteOnceMoreResp = jsfUnderWriteResource.underwrite(under);
                if (underwriteOnceMoreResp != null) {
                    if (underwriteOnceMoreResp.getCode() == "0000") {
                        return "重复核保检测失败，订单号：" + orderIdFirst;
                    } else {
                        return "重复核保检测通过";
                    }
                }
            }
        }
        return null;
    }
}
