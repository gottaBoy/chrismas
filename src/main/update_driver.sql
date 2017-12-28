!-- 添加司机当前位置字段
alter table t_s_driver 
add column address VARCHAR(200) default null COMMENT '位置详情',
add column province VARCHAR(200) default null COMMENT '省',
add column city VARCHAR(30) default null COMMENT '市',
add column district VARCHAR(30) default null COMMENT '区（县）',
add column longitude DECIMAL(10,7) default null COMMENT '经度',
add column latitude DECIMAL(10,7) default null COMMENT '维度',
add column loc_time datetime default null COMMENT '定位时间',
add column loc_type VARCHAR(10) default null COMMENT '定位方式';

!--添加微信司机地理位置
CREATE TABLE wx_driver_loc (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `driver_id` bigint(20) NOT NULL,
  `longitude` decimal(10,7) DEFAULT NULL,
  `latitude` decimal(10,7) DEFAULT NULL,
  `province` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `district` varchar(30) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `street_number` varchar(30) DEFAULT NULL,
  `loc_time` datetime DEFAULT NULL,
  `loc_type` varchar(10) DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;