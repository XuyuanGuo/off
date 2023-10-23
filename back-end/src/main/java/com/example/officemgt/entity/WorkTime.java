package com.example.officemgt.entity;

import java.sql.Time;

/**
 * WorkTime类代表一个办公室在特定日期的工作时间。
 * 包括日期、办公室ID、开放时间和关闭时间。
 */
public class WorkTime {
    // 表示工作日期的字符串
    private String date;

    // 办公室的ID
    private int office;

    // 办公室的开放时间
    private Time openTime;

    // 办公室的关闭时间
    private Time closeTime;

    // 默认构造方法
    public WorkTime() {
    }

    /**
     * 构造方法，初始化工作时间的所有属性。
     *
     * @param day       工作日期。
     * @param office    办公室ID。
     * @param openTime  办公室的开放时间。
     * @param closeTime 办公室的关闭时间。
     */
    public WorkTime(String day, int office, Time openTime, Time closeTime) {
        this.date = day;
        this.office = office;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    // 获取工作日期
    public String getDate() {
        return date;
    }

    // 设置工作日期
    public void setDate(String date) {
        this.date = date;
    }

    // 获取办公室ID
    public int getOffice() {
        return office;
    }

    // 设置办公室ID
    public void setOffice(int office) {
        this.office = office;
    }

    // 获取办公室的开放时间
    public Time getOpenTime() {
        return openTime;
    }

    // 设置办公室的开放时间
    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    // 获取办公室的关闭时间
    public Time getCloseTime() {
        return closeTime;
    }

    // 设置办公室的关闭时间
    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * 返回WorkTime对象的字符串表示形式。
     * 主要用于调试和日志记录。
     *
     * @return 工作时间的字符串表示形式。
     */
    @Override
    public String toString() {
        return "WorkTime{" +
                "day=" + date +
                ", office=" + office +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                '}';
    }
}