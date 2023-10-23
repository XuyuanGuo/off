package com.example.officemgt.entity;

/**
 * Office类代表一个办公室。
 * 包括办公室的唯一标识符id、名称name、状态state以及关联的区域ID。
 */
public class Office {
    // 办公室的唯一标识符
    private Integer id;

    // 办公室的名称
    private String name;

    // 办公室的状态（例如：是否被使用）
    private boolean state;

    // 与该办公室关联的区域的ID
    private Integer areaId;

    /**
     * 获取办公室的ID。
     *
     * @return 返回办公室的唯一标识符。
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置办公室的ID。
     *
     * @param id 要设置的办公室标识符。
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取办公室的名称。
     *
     * @return 返回办公室的名称。
     */
    public String getName() {
        return name;
    }

    /**
     * 设置办公室的名称。
     *
     * @param name 要设置的办公室名称。
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取办公室的状态。
     *
     * @return 返回办公室的状态。
     */
    public boolean isState() {
        return state;
    }

    /**
     * 设置办公室的状态。
     *
     * @param state 要设置的办公室状态。
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * 获取与该办公室关联的区域的ID。
     *
     * @return 返回关联区域的ID。
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置与该办公室关联的区域的ID。
     *
     * @param areaId 要设置的区域ID。
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 返回Office对象的字符串表示形式。
     * 主要用于调试和日志记录。
     *
     * @return 办公室的字符串表示形式。
     */
    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", areaId=" + areaId +
                '}';
    }
}