package com.example.officemgt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.officemgt.entity.Area;
import org.apache.ibatis.annotations.Mapper;

/**
 * AreaMapper接口用于定义与Area实体相关的数据库操作。
 * 由于继承了MyBatis-Plus的BaseMapper，所以提供了Area实体的常用CRUD操作。
 * 无需自定义常规的CRUD方法。
 */
@Mapper
public interface AreaMapper extends BaseMapper<Area> {
    // 如果需要，可以在此定义额外的数据库操作方法
}