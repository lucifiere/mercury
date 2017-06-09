CREATE TABLE `admin_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '模块名称',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  `sort_id` int(11) DEFAULT NULL COMMENT '排序',
  `url` text COMMENT 'url',
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT'创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='系统模块信息表';

INSERT INTO admin_module (name, remark, sort_id, url) VALUES ('个人信息', '查看个人信息', 1, '/');
INSERT INTO admin_module (name, remark, sort_id, url) VALUES ('备忘事项', '查看个人备忘录', 2, '/');
INSERT INTO admin_module (name, remark, sort_id, url) VALUES ('测试模块', '测试', 3, '/');

CREATE TABLE `admin_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(10) DEFAULT '' COMMENT '菜单编号，唯一键',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名字',
  `remark` varchar(200) DEFAULT '' COMMENT '菜单描述',
  `url` text COMMENT 'url',
  `level` smallint(6) DEFAULT NULL COMMENT '级别',
  `parent_code` varchar(10) DEFAULT '' COMMENT '父编号',
  `sort_id` int(11) DEFAULT NULL COMMENT '排序',
  `is_valid` tinyint(3) unsigned NOT NULL COMMENT '是否有效',
  `is_visible` tinyint(3) unsigned DEFAULT NULL COMMENT '是否可见',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_code` (`code`) USING BTREE,
  KEY `index_module_id` (`code`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='系统菜单信息表';

INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('100000000', '安全管理', '管理用户、角色、权限等认证信息', '/', 1, '', 999, 1, 1);
INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('100100000', '用户管理', '管理用户的增删改查', '/', 2, '100000000', 1, 1, 1);
INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('100200000', '角色管理', '管理角色的增删改查', '/', 2, '100000000', 2, 1, 1);
INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('100300000', '权限管理', '为资源配置权限', '/', 2, '100000000', 3, 1, 1);

INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('200000000', '发布管理', '发表日志等', '/', 1, '', 1, 1, 1);
INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('200100000', '日志管理', '日志的增删改查', '/', 2, '200000000', 1, 1, 1);

INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('300000000', '消息中心', '消息的发送和接受', '/', 1, '', 2, 1, 1);
INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('300100000', '发件箱', '发送消息', '/', 2, '300000000', 1, 1, 1);
INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('300200000', '收件箱', '接收消息', '/', 2, '300000000', 2, 1, 1);

-- 2017.6.9
INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('400000000', '系统管理', '管理菜单、模块等基础信息', '/', 1, '', 3, 1, 1);
INSERT INTO admin_menu (code, name, remark, url, level, parent_code, sort_id, is_valid, is_visible) VALUES
  ('400100000', '菜单管理', '菜单的增删改查', '/menu/list', 2, '400000000', 1, 1, 1);

