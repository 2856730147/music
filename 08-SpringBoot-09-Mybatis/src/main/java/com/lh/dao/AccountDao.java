package com.lh.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AccountDao {
    //加钱
    void increase(@Param("id") Integer id, @Param("monet") Integer monet);

    //减钱
    void  decrease(@Param("id") Integer id,@Param("monet") Integer monet);

}
