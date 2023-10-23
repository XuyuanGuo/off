# 营业厅管理系统

## 一、需求分析

基础要求:  
为m个地区的n个营业厅提供营业时间管理系统，要求可以设定每个营业厅的工作日和节假日的营业时间。  
特殊要求:  
1.每个营业厅要求可以设置状态，包括“正常营业”和“暂停营业”，暂停营业的营业厅不可编辑时间。  
2.每个营业厅可以随时进行临时调休，调整其营业时间。  

## 二、模块设计

前端部分：  
设计前端页面，分别实现营业厅的营业时间管理和营业时间查询。  

1. 营业厅管理页面要求可以显示和编辑每个营业厅的营业时间，营业状态。  

为实现编辑和查询，页面采取如下策略：

1. 管理页面具有筛选功能，能够显示全部营业厅，或筛选出指定营业厅。
2. 按下编辑按钮后，弹出编辑后台信息的对话框。  

数据库部分:  
创建数据库  

    create 
创建地区、营业厅、日历、时间四张表,同时向表中添加一定量基础数据  
地区表

    create table `area`(
        `id` int primary key,
        `name` varchar(20)
    );

营业厅表

    create table `office`(
        `id` int primary key,
        `name` varchar(20),
        `state` boolean,
        `areaId` int,
        foreign key (`areaId`) references area(`id`)
    );

日历表

    create table `calendar`(
        `id` int primary key,
        `day` date
    );

时间表

    create table `time`(
        `day` int primary key,
        `office` int primary key,
        `openTime` time,
        `closeTime` time,
        foreign key 
    );

后端部分：  
负责查询数据库并将数据返回给前端。  
