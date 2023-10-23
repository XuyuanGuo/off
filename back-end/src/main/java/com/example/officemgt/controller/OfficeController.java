package com.example.officemgt.controller;

import com.example.officemgt.entity.Office;
import com.example.officemgt.mapper.OfficeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * OfficeController是一个REST控制器，处理与Office实体相关的HTTP请求。
 * 使用Spring Boot的@RestController注解，表明它是一个RESTful的web服务控制器。
 * @CrossOrigin注解允许跨域请求，便于前端应用调用这个API。
 */
@RestController
@CrossOrigin
public class OfficeController {
    // 自动注入OfficeMapper对象，用于与数据库交互
    @Autowired
    private OfficeMapper officeMapper;

    /**
     * 定义一个GET请求的端点，URL为/office。
     * 如果提供了value参数（区域ID），则返回该区域的所有办公室数据；
     * 否则返回所有办公室数据。
     *
     * @param value 区域ID，可选。
     * @return 返回一个包含办公室实体的列表。
     */
    @GetMapping("/office")
    public List<Office> officeQuery(Integer value) {
        List<Office> list;
        if (value == null) {
            // 如果value参数为空，查询所有办公室
            list = officeMapper.selectList(null);
        } else {
            // 否则，根据value参数查询特定区域的办公室
            list = officeMapper.selectByArea(value.intValue());
        }
        return list;
    }
}