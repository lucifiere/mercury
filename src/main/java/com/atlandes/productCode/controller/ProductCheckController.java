package com.atlandes.productCode.controller;

import com.atlandes.productCode.entity.BaseCheckResult;
import com.atlandes.productCode.service.ProductBaseInfo;

import com.atlandes.productCode.entity.ProductCheckResult;
import com.atlandes.productCode.service.ProductFeeInfo;
import com.jd.baoxian.product.export.pojo.ProductFee;
import com.jd.baoxian.product.export.vo.res.ProductDetail;
import com.jd.baoxian.service.platform.domain.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequestMapping("productCheck")
public class ProductCheckController {

    @Autowired
    private ProductBaseInfo productBaseInfo;
    @Autowired
    private ProductFeeInfo productFeeInfo;

    @RequestMapping(value = "productCheck", produces = "text/plain;charset=UTF-8")
    public ModelAndView toProductCheckPage() {
        ModelAndView modelAndView = new ModelAndView("productcheck/productcheck");
        return modelAndView;
    }

    @RequestMapping("startCheck")
    @ResponseBody
    public ProductCheckResult startCheck(String sku, String baseCheckIds) {
        ProductCheckResult productCheckResult = new ProductCheckResult();
        String[] baseCheckItem = baseCheckIds.split(",");
        for (String btnId : baseCheckItem) {
            if (Objects.equals(btnId, "underWrite")) {
                BaseCheckResult underWriteRes = productBaseInfo.getUnderWriteRes(sku);
                productCheckResult.setUnderWriteResult(underWriteRes);
            }

            if (Objects.equals(btnId, "issue")) {
                BaseCheckResult issueRes = productBaseInfo.getIssueRes(sku);
                productCheckResult.setIssueResult(issueRes);
            }
            if (Objects.equals(btnId, "onLinePolicy")) {
                BaseCheckResult onLinePolicyRes = productBaseInfo.getOnLinePolicyRes(sku);
                productCheckResult.setOnLinePolicyResult(onLinePolicyRes);
            }
            if (Objects.equals(btnId, "underWriteOnceMore")) {
                BaseCheckResult underWriteOnceMoreRes = productBaseInfo.getUnderWriteOnceMoreRes(sku);
                productCheckResult.setUnderWriteOnceMoreResult(underWriteOnceMoreRes);
            }
            if (Objects.equals(btnId, "issueOnceMore")) {
                //todo 调用重复出单检测case

            }
            if (Objects.equals(btnId, "issueIdempotent")) {
                //todo 调用出单幂等检测case
            }
        }
        return productCheckResult;
    }

    @RequestMapping("displayFeeType")
    @ResponseBody
    public ProductFee displayFeeType(String sku){

        ProductFee productFee = new ProductFee();
        BaseResponse<ProductDetail> productDetailRes = productBaseInfo.getProductDetailBySkuId(sku);
        productFee.setPayPeriod(productDetailRes.getResponse().getProductFee().getPayPeriod());
        productFee.setPeriods(productDetailRes.getResponse().getProductFee().getPeriods());
        productFee.setSocialSecurity(productDetailRes.getResponse().getProductFee().getSocialSecurity());
        return productFee;
    }
}
