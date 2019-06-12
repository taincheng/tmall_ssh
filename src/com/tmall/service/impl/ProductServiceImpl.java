package com.tmall.service.impl;

import com.tmall.pojo.Category;
import com.tmall.pojo.Product;
import com.tmall.service.ProductImageService;
import com.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {
    @Autowired
    ProductImageService productImageService;

    @Override
    public void fill(List<Category> categorys) {
        for (Category category : categorys) {
            fill(category);
        }
    }

    @Override
    public void fill(Category category) {
        List<Product> products = listByParent(category);

        for (Product product : products) {
            productImageService.setFirstProdutImage(product);
        }
        category.setProducts(products);
    }

    @Override
    public void fillByRow(List<Category> categorys) {
        int productNumberEachRow = 8;
        for (Category category : categorys) {
            //得到category下的所有product
            List<Product> products =  category.getProducts();
            //用数组加链表的方式存储category下的所有产品下的所有产品
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                //subList() 切割list
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            category.setProductsByRow(productsByRow);
        }
    }
}
