package com.tmall.service;

import com.tmall.pojo.Category;

import java.util.List;

public interface ProductService extends BaseService {
    /*
    为多个分类填充产品集合
     */
    public void fill(List<Category> categorys);
    /*
    为分类填充产品集合
     */
    public void fill(Category category);
    /*
    为多个分类填充推荐产品集合，即把分类下的产品集合，按照8个为一行，拆成多行，以利于后续页面上进行显示
     */
    public void fillByRow(List<Category> categorys);
}
