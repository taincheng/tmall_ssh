package com.tmall.action;

import com.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Method;

import org.apache.commons.lang3.text.WordUtils;

public class Action4Service extends Action4Pojo{
    @Autowired
    CategoryService categoryService;

    @Autowired
    PropertyService propertyService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductImageService productImageService;

    @Autowired
    PropertyValueService propertyValueService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    /**
     * transient to persistent
     * 瞬时对象转换为持久对象
     * @param o
     */
    public void t2p(Object o){
        try {
            Class clazz = o.getClass();
            int id = (Integer)clazz.getMethod("getId").invoke(o);//得到对象id，
            Object persistentBean = categoryService.get(clazz, id);//通过id得到相应category对象

            String beanName = clazz.getSimpleName();//得到对象类型名
            Method setMethod = getClass().getMethod("set" + WordUtils.capitalize(beanName), clazz);//将对象更新
            setMethod.invoke(this, persistentBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
