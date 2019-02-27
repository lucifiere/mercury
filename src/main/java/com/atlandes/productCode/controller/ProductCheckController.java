package com.atlandes.productCode.controller;

//import com.atlandes.productCode.service.ProductBaseInfo;

import com.atlandes.productCode.entity.ProductCheckResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import com.jd.baoxian.product.export.vo.res.ProductDetail;
//import com.jd.baoxian.service.platform.domain.response.BaseResponse;
//import com.jd.baoxian.service.platform.domain.response.UnderWriteResponse;

@Controller
@RequestMapping("productCheck")
public class ProductCheckController {

//    private ProductBaseInfo productBaseInfo;

    @RequestMapping(value = "productCheck", produces = "text/plain;charset=UTF-8")
    public ModelAndView toProductCheckPage() {
        ModelAndView modelAndView = new ModelAndView("productcheck/productcheck");
        return modelAndView;
    }

    @RequestMapping("startCheck")
    @ResponseBody
    public ProductCheckResult startCheck(String sku) {

//        String underWriteRes = productBaseInfo.getUnderWriteRes(sku);
        String underWriteRes ="";
        ProductCheckResult productCheckResult = new ProductCheckResult();
        productCheckResult.setUnderWriteResult(underWriteRes);
        productCheckResult.setIssueResult("出单结果");
        return productCheckResult;
    }

}
