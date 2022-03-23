package com.mxy.booksharing.dao;

import com.mxy.booksharing.pojo.Categories;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(Categories record);

    int insertSelective(Categories record);

    Categories selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(Categories record);

    int updateByPrimaryKey(Categories record);
}