package com.example.officemgt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.officemgt.entity.Office;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * OfficeMapper接口用于定义与Office实体相关的数据库操作。
 * 由于继承了MyBatis-Plus的BaseMapper，所以默认提供了Office实体的常规CRUD操作。
 * 这里还包括了一个额外的方法来按区域ID查询办公室。
 */
@Mapper
public interface OfficeMapper extends BaseMapper<Office> {
    /**
     * 根据区域ID查询办公室。
     *
     * @param areaId 要查询的区域ID。
     * @return 返回该区域ID对应的办公室列表。
     */
    @Select("select * from office where area_id=#{areaId}")
    public List<Office> selectByArea(int areaId);
}