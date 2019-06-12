package com.tmall.service.impl;

import com.tmall.pojo.Product;
import com.tmall.pojo.ProductImage;
import com.tmall.service.ProductImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl extends BaseServiceImpl implements ProductImageService {

    @Override
    public void setFirstProdutImage(Product product) {
        if(null!=product.getFirstProductImage())
            return;
        List<ProductImage> pis= list("product", product, "type", ProductImageService.type_single);
        if(!pis.isEmpty())
            product.setFirstProductImage(pis.get(0));
    }
}
