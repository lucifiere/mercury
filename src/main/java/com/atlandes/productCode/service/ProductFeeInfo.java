package com.atlandes.productCode.service;

import com.atlandes.productCode.common.BaseConfig;
import com.jd.baoxian.product.export.pojo.ProductFee;
import com.jd.baoxian.product.export.vo.base.BaseClass;
import com.jd.baoxian.product.export.vo.res.ProductDetail;
import com.jd.baoxian.service.platform.domain.bean.Merchant;
import com.jd.baoxian.service.platform.domain.request.ProductRequest;
import com.jd.baoxian.service.platform.domain.response.BaseResponse;
import com.jd.baoxian.service.platform.export.resource.product.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductFeeInfo extends BaseConfig {
    @Autowired
    public ProductResource jsfProductResource;

    public ProductFee getProductFeeBySkuId(String sku) {

        ProductFee productFee;
        Merchant merchant = new Merchant();
        merchant.setMerchantNo("1018120001");
        merchant.setMerchantName("京东金融");

        ProductRequest req = new ProductRequest();
        req.setMerchant(merchant);
        req.setItemId(sku);
        BaseResponse<ProductDetail> resProductDetail = jsfProductResource.productInfoV1(req);
        productFee = resProductDetail.getResponse().getProductFee();
       return productFee;
    }
}
