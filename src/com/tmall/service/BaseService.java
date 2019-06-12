package com.tmall.service;

import com.tmall.util.Page;

import java.util.List;

public interface BaseService {
    /*
    添加对象
     */
    public Integer save(Object object);
    /*
    更新对象
     */
    public void update(Object object);
    /*
    删除对象
     */
    public void delete(Object object);
    /*
    通过ID得到相应的对象
     */
    public Object get(Class clazz,int id);
    public Object get(int id);

    /*
    得到全部的对象
     */
    public List list();
    /*
    分页得到对象
     */
    public List listByPage(Page page);
    /*
    得到全部对象的总数
     */
    public int total();


    /*
    根据父类对象查询所有的子类对象
     */
    public List listByParent(Object parent);

    /*
    根据父类对象分页查询子类对象。
     */
    public List list(Page page, Object parent);

    /*
    根据父类查询子类的数量
     */
    public int total(Object parent);

    /*
    多条件查询
     */
    public List list(Object ...pairParms);
}
