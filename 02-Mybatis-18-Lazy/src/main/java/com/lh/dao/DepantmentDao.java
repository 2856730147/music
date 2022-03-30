package com.lh.dao;

import org.apache.ibatis.annotations.Param;

import java.text.DecimalFormat;

public interface DepantmentDao {
    DecimalFormat dindById(@Param("id") Integer id);
}
