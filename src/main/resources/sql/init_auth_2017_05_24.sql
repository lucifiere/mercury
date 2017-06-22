drop table if exists auth_permission;
drop table if exists auth_role;
drop table if exists auth_re_role_and_permission;
drop table if exists auth_user;
drop table if exists auth_re_user_and_role;

-- 权限表
CREATE TABLE `auth_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT '功能描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `u_role`;

-- 角色表
CREATE TABLE `auth_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` SMALLINT (10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 角色权限关系表
CREATE TABLE `auth_re_role_and_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 用户表
CREATE TABLE `auth_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) DEFAULT NULL COMMENT '秘钥',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` bigint(1) DEFAULT '0' COMMENT '冗余字段',
  `is_valid` bigint(1) DEFAULT '1' COMMENT '0:删除，1:正常',
  `is_locked` bigint(1) DEFAULT '0' COMMENT '1:锁定，0:正常',
  UNIQUE KEY `nickname` (`nickname`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

insert into auth_user (nickname, email, password, create_time, last_login_time, status) VALUES
  ('xd.wang', 'lucifiere@126.com','123', now(), now(), 1);
insert into auth_user (nickname, email, password, create_time, last_login_time, status) VALUES
  ('c.liu', 'sb1@qq.com','456', now(), now(), 1);
insert into auth_user (nickname, email, password, create_time, last_login_time, status) VALUES
  ('xl.ma', 'sb2@qq.com','789', now(), now(), 1);

-- 用户角色关系表
CREATE TABLE `auth_re_user_and_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
