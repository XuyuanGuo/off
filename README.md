# 营业厅时间管理与分配系统

## 一、项目背景与需求分析

项目背景：
随着全球化的趋势和城市化进程，企业经常在多个地区和城市设有营业厅或办事处。为了确保各个营业厅能够准确、高效地为顾客提供服务，需要有一个系统来管理这些营业厅的营业时间。本项目的愿景是为企业提供一个灵活、可扩展且集成性强的营业时间管理系统，既可以满足现有的需求，又能为未来的智能视频分析工作提供支持。  

基础要求:  
使用BS架构模式，为m个地区的n个营业厅提供营业时间管理系统，要求可以设定每个营业厅的工作日和节假日的营业时间。后期该系统会被用于管理营业厅进行智能视频分析的时间。  
特殊要求:  
1.每个营业厅要求可以设置状态，包括“正常营业”和“暂停营业”，暂停营业的营业厅不可编辑时间。2.每个营业厅可以随时进行临时调休，调整其营业时间。  

## 二、模块设计

### 前端部分

设计前端页面，分别实现营业厅的营业时间管理和营业时间查询。  

1. 营业厅管理页面要求可以显示和编辑每个营业厅的营业时间，营业状态。

为实现编辑和查询，页面采取如下策略：

1. 管理页面具有筛选功能，能够显示全部营业厅，或筛选出指定营业厅。
2. 按下编辑按钮后，弹出编辑后台信息的对话框。

### 后端部分

后端负责响应前端的网络请求、查询数据库并将数据返回给前端。  
该项目后端使用Java为开发语言，使用Java Spring框架，使用Apache-maven进行项目构建和依赖管理，使用mybatis和mybatis-plus进行数据库的连接。  
后端工具介绍：  

1. Java Spring：Spring Framework 是 Java 社区中最受欢迎和广泛使用的应用开发框架，能够轻松集成各种企业服务，例如 JMS、JPA 和 JNDI。此外，它与其他流行的 Java 框架（如 Hibernate、MyBatis 和 Quartz）完美集成。
2. Apache-maven: Maven 定义了一个清晰的生命周期，确保项目在不同环境中以一致的方式构建，通过中央仓库，Maven 可以自动下载项目所需的库和插件，并处理依赖关系，简化了版本控制和库的管理。
3. Mybatis和Mybatis-plus: MyBatis 专为确保直观、清晰和灵活的数据库交互而设计，与其他 ORM 框架不同，MyBatis 允许开发者编写原生 SQL，为复杂查询和优化提供了更大的控制力。此外，Mybatis支持自动将 SQL 查询结果转换为 Java 对象，减少了样板代码。

后端结构介绍：  
表示层：通常与前端交互，负责处理HTTP请求和返回响应。在本项目中，表示层文件位于com/example/officemgt/controller文件夹下。其中AreaController是一个REST控制器，处理与Area实体相关的HTTP请求（如areaQuery方法返回一个地点列表，用于前端查询地点的选择）。OfficeController和WorkTimeController分别负责Office实体和WorkTime实体相关的请求。  
实体层：定义了与数据库表对应的Java实体。在本项目中，实体层文件位于com/example/officemgt/entity文件夹下。本项目主要定义了三个实体：Area、Office和WorkTime。  
DAO层：直接与数据库交互，负责数据的CRUD操作。在本项目中，实体层文件位于com/example/officemgt/mapper文件夹下。本项目定义了AreaMapper、OfficeMapper和WorkTimeMapper这三个接口，用于处理与对应实体相关的数据库操作。  

### 数据库部分

该项目的数据库定义了area、office、work_time三个表，fen'biafenbia：

```SQL
create table `area`(
        `id` int primary key,
        `name` varchar(20)
);

create table `office`(
        `id` int primary key,
        `name` varchar(20),
        `state` boolean,
        `area_id` int,
        foreign key (`area_id`) references `area`(`id`) on delete cascade
);

create table `work_time`(
        `date` varchar(20),
        `office` int,
        `open_time` time,
        `close_time` time,
        primary key (`date`,`office`),
        foreign key (`office`) references `office`(`id`) on delete cascade
);
```

数据库ER图如下：  
![Alt text](image.png)
