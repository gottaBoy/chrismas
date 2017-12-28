create table  city (
  id bigint(20) NOT NULL DEFAULT '0',
  province_id bigint(20) DEFAULT NULL,
  city_name varchar(20) DEFAULT NULL,
  description varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_hhg_info (
  id bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  send varchar(40) DEFAULT NULL,
  arrive varchar(20) DEFAULT NULL,
  publish_time datetime DEFAULT NULL,
  price decimal(20,2) DEFAULT NULL,
  goods_name varchar(20) DEFAULT NULL,
  departInfo varchar(20) DEFAULT NULL,
  departInfo_name varchar(20) DEFAULT NULL,
  departInfo_tel varchar(20) DEFAULT NULL,
  departInfo_more varchar(200) DEFAULT NULL,
  is_in_port bit(1) DEFAULT NULL,
  expire bit(1) DEFAULT NULL,
  creator_id bigint(20) DEFAULT NULL,
  creator_name varchar(20) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  modifier_id bigint(20) DEFAULT NULL,
  modifier_name varchar(20) DEFAULT NULL,
  modify_time datetime DEFAULT NULL,
  remark varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

