package com.atlandes.productCode.controller;

import com.atlandes.productCode.entity.BaseCheckResult;
import com.atlandes.productCode.service.ProductBaseInfo;

import com.atlandes.productCode.entity.ProductCheckResult;
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
                //todo 调用核保检测case
                String underWriteRes = productBaseInfo.getUnderWriteRes(sku);
                BaseCheckResult underWriteResult = new BaseCheckResult();
                underWriteResult.setCheckItem("核保检测");
//                underWriteResult.setCheckMark();
                productCheckResult.setUnderWriteResult(underWriteResult);
            }

            if (Objects.equals(btnId, "issue")) {
                //todo 调用出单检测case
                String issueRes = productBaseInfo.getIssueRes(sku);
//                productCheckResult.setIssueResult(issueRes);
            }
            if (Objects.equals(btnId, "onLinePolicy")) {
                //todo 调用电子保单检测case
                String onLinePolicyRes = productBaseInfo.getOnLinePolicyRes(sku);
//                productCheckResult.setOnLinePolicyResult(onLinePolicyRes);
            }
            if (Objects.equals(btnId, "underWriteOnceMore")) {
                String underWriteOnceMoreRes = productBaseInfo.getOnLinePolicyRes(sku);
//                productCheckResult.setUnderWriteOnceMoreResult(underWriteOnceMoreRes);
                //todo 调用重复核保检测case

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
}
