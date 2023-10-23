package com.example.officemgt.controller;

import com.example.officemgt.entity.WorkTime;
import com.example.officemgt.mapper.WorkTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * WorkTimeController是一个REST控制器，处理与WorkTime实体相关的HTTP请求。
 * 使用Spring Boot的@RestController注解，表明它是一个RESTful的web服务控制器。
 * @CrossOrigin注解允许跨域请求，便于前端应用调用这个API。
 */
@RestController
@CrossOrigin
public class WorkTimeController {
    // 默认的开放和关闭时间
    private static final Time defaultOpenTime = new Time(0);
    private static final Time defaultCloseTime = new Time(9*60*60*1000);

    // 存储办公室ID的数组
    private Integer[] officeId;

    // 自动注入WorkTimeMapper对象，用于与数据库交互
    @Autowired
    private WorkTimeMapper workTimeMapper;

    /**
     * 定义一个GET请求的端点，URL为/workTime。
     * 如果提供了date参数，则返回该日期的所有办公室工作时间数据；
     * 否则返回当前日期的工作时间数据。
     *
     * @param date 查询的日期，可选。
     * @return 返回一个包含工作时间实体的列表。
     */
    @GetMapping("/workTime")
    public List<WorkTime> workTimeQuery(String date) throws ParseException {
        // 如果没有提供日期，则使用当前日期
        if (date == null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(Calendar.getInstance().getTime());
        }
        List<WorkTime> tempList, list = new ArrayList<>();
        for (Integer id : officeId) {
            tempList = workTimeMapper.select(date, id);
            if (tempList.isEmpty()) {
                list.add(new WorkTime(date, id, defaultOpenTime, defaultCloseTime));
            } else {
                list.addAll(tempList);
            }
        }
        return list;
    }

    /**
     * 设置要查询的办公室ID。
     *
     * @param officeId 办公室ID数组。
     * @param request HttpServletRequest对象，此处未使用。
     */
    @PostMapping("/workTime")
    public void setOfficeId(Integer[] officeId, HttpServletRequest request) {
        this.officeId = officeId;
    }

    /**
     * 更新工作时间数据。
     * 首先删除旧数据，然后插入新数据。
     *
     * @param data 新的工作时间数据。
     */
    @PostMapping("/workTime/set")
    public void updateDb(WorkTime data) {
        workTimeMapper.deleteDb(data);
        workTimeMapper.insertDb(data);
        System.out.println(data.toString());
    }
}