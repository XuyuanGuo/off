package com.example.officemgt.controller;

import com.example.officemgt.entity.Area;
import com.example.officemgt.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AreaController是一个REST控制器，处理与Area实体相关的HTTP请求。
 * 使用Spring Boot的@RestController注解，表明它是一个RESTful的web服务控制器。
 * @CrossOrigin注解允许跨域请求，便于前端应用调用这个API。
 */
@RestController
@CrossOrigin
public class AreaController {
    // 自动注入AreaMapper对象，用于与数据库交互
    @Autowired
    private AreaMapper areaMapper;

    /**
     * 定义一个GET请求的端点，URL为/area。
     * 当收到GET请求时，它将返回所有的Area数据。
     *
     * @return 返回一个包含所有Area实体的列表。
     */
    @GetMapping("/area")
    public List<Area> areaQuery() {
        // 使用AreaMapper的selectList方法查询所有区域，参数为null表示没有查询条件
        List<Area> list = areaMapper.selectList(null);
        return list;
    }
}