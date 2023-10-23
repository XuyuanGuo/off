package com.example.officemgt.entity;

/**
 * Area类表示一个具体的区域。
 * 包括区域的唯一标识符id和区域的名称name。
 */
public class Area {
    // 区域的唯一标识符
    Integer id;

    // 区域的名称
    String name;

    /**
     * 获取区域的ID。
     *
     * @return 返回区域的唯一标识符。
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置区域的ID。
     *
     * @param id 要设置的区域标识符。
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取区域的名称。
     *
     * @return 返回区域的名称。
     */
    public String getName() {
        return name;
    }

    /**
     * 设置区域的名称。
     *
     * @param name 要设置的区域名称。
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回Area对象的字符串表示形式。
     * 主要用于调试和日志记录。
     *
     * @return 区域的字符串表示形式。
     */
    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}