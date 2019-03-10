package com.atlandes.productCode.controller;

import com.atlandes.productCode.entity.*;
import com.atlandes.productCode.service.ProductBaseInfo;

import com.jd.baoxian.product.export.pojo.ProductFee;
import com.jd.baoxian.product.export.vo.res.ProductDetail;
import com.jd.baoxian.service.platform.domain.response.BaseResponse;
import com.jd.baoxian.service.platform.domain.response.UnderWriteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
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
                BaseCheckResult issueOnceMoreRes = productBaseInfo.getIssueOnceMoreRes(sku);
                productCheckResult.setIssueOnceMoreResult(issueOnceMoreRes);
            }
            if (Objects.equals(btnId, "issueIdempotent")) {
                BaseCheckResult issueIdempotentRes = productBaseInfo.getIssueIdempotentRes(sku);
                productCheckResult.setIssueIdempotentResult(issueIdempotentRes);
            }
        }
        return productCheckResult;
    }

    @RequestMapping("displayFeeType")
    @ResponseBody
    public ProductDict displayFeeType(String sku) {
        ProductDict productDict;
        productDict = productBaseInfo.getProductDict(sku);
        return productDict;
    }

    @RequestMapping("startFeeCheck")
    @ResponseBody
    public List<BaseCheckResult> startFeeCheck(@RequestBody ProductFeeRequest request) {
        List<BaseCheckResult> feeCheckResult = new ArrayList<>();

            BaseResponse<ProductDetail> productdetail = productBaseInfo.getProductDetailBySkuId(request.getProductCode());
            for (int i = Integer.valueOf(request.getMinAge()); i <= Integer.valueOf(request.getMaxAge()); i++) {
                BaseCheckResult feeUnderWriteResult = productBaseInfo.feeUnderWrite(productdetail, String.valueOf(i),
                        request.getHolderInsuredRelations(), request.getPayPeriod(),
                        request.getPeriods(), request.getAmount());
                feeCheckResult.add(feeUnderWriteResult);
            }
            return feeCheckResult;


    }
}
