create database `office_mgt`;
use `office_mgt`;

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

show tables;

insert into `area` (`id`,`name`)
values (1,"东城区"),(2,"西城区"),(3,"朝阳区"),(4,"海淀区"),(5,"丰台区"),
(6,"石景山区"),(7,"门头沟区"),(8,"房山区"),(9,"通州区"),(10,"顺义区"),(11,"昌平区");

insert into `office` (`id`,`name`,`state`,`area_id`)
values (1,"中国银行北京东安门支行",true,1),(2,"中国银行北京和平里支行",true,1),(3,"中国银行北京安贞桥支行",true,1),(4,"中国银行北京安定门外支行",true,1),(5,"中国银行北京金宝街支行",true,1),
(6,"中国银行北京大成大厦支行",true,2),(7,"中国银行北京西城支行",true,2),(8,"中国银行北京丰盛支行",true,2),(9,"中国银行北京三里河支行",true,2),(10,"中国银行北京金科新区支行",true,2),
(11,"中国银行北京主媒体中心支行",true,3),(12,"中国银行北京冬（残）奥村支行",true,3),(13,"中国银行北京西坝河南路支行",true,3),(14,"中国银行北京安苑路支行",true,3),(15,"中国银行北京幸福广场支行",true,3),
(16,"中国银行北京苏州桥支行",true,4),(17,"中国银行北京清华东路支行",true,4),(18,"中国银行北京西三环北路支行",true,4),(19,"中国银行北京上地支行",true,4),(20,"中国银行北京香山支行",true,4),
(21,"中国银行北京宋家庄支行",true,5),(22,"中国银行北京方庄支行",true,5),(23,"中国银行北京科丰桥南支行",true,5),(24,"中国银行北京西罗园支行",true,5),(25,"中国银行北京总部基地东区支行",true,5);

insert into `work_time` (`date`,`office`,`open_time`,`close_time`)
values ('2023-09-01',5,'10:00:00','15:00:00');