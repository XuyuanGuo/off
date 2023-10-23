package com.example.officemgt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.officemgt.entity.WorkTime;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * WorkTimeMapper接口用于定义与WorkTime实体相关的数据库操作。
 * 除了从MyBatis-Plus的BaseMapper继承的常规CRUD操作，这里还定义了
 * 根据日期和办公室ID查询、按条件删除和插入新的工作时间的特定方法。
 */
@Mapper
public interface WorkTimeMapper extends BaseMapper<WorkTime> {
    /**
     * 根据指定的日期和办公室ID查询工作时间。
     *
     * @param date    要查询的日期。
     * @param officeId 要查询的办公室ID。
     * @return 返回匹配的工作时间列表。
     */
    @Select("select * from work_time where date=#{date} and office=#{officeId}")
    public List<WorkTime> select(String date, int officeId);

    /**
     * 根据给定的工作时间数据（主要是日期和办公室）删除记录。
     *
     * @param data 要删除的工作时间数据。
     */
    @Delete("delete from work_time where date=#{date} and office=#{office}")
    public void deleteDb(WorkTime data);

    /**
     * 根据给定的工作时间数据插入新的记录。
     *
     * @param data 要插入的工作时间数据。
     */
    @Insert("insert into work_time (date,office,open_time,close_time) values (#{date},#{office},#{openTime},#{closeTime})")
    public void insertDb(WorkTime data);
}