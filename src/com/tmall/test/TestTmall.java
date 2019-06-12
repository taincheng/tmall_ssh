package com.tmall.test;

import com.tmall.dao.impl.DAOImpl;
import com.tmall.pojo.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTmall {
    @Autowired
    DAOImpl dao;

    @Test
    public void delete(){
        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
        List<Category> cs = dao.findByCriteria(dc);
        for(Category c : cs){
            dao.delete(c);
        }
    }

    @Test
    public void test(){
        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
        List<Category> cs = dao.findByCriteria(dc);
        if(cs.size() == 0){
            for (int i = 0; i < 10; i++){
                Category c = new Category();
                c.setName("测试分类" + i);
                dao.save(c);
            }
            System.out.println("成功添加10个分类");
        }
    }
}
