package com.tmall.service.impl;

import com.tmall.pojo.Product;
import com.tmall.pojo.Property;
import com.tmall.pojo.PropertyValue;
import com.tmall.service.PropertyService;
import com.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueServiceImpl extends BaseServiceImpl implements PropertyValueService{
    @Autowired
    PropertyService propertyService;

    @Override
    public void init(Product product) {
        //得到所属目录的全部属性
        List<Property> propertys= propertyService.listByParent(product.getCategory());
        /*
        得到每个product的property，如果为null，则初始化。
         */
        for (Property property: propertys) {
            PropertyValue propertyValue = get(property,product);
            if(null==propertyValue){
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                save(propertyValue);
            }
        }
    }

    private PropertyValue get(Property property, Product product) {
        List<PropertyValue> result= this.list("property",property, "product",product);
        if(result.isEmpty())
            return null;
        return result.get(0);

    }
}
