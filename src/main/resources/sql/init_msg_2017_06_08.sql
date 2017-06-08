CREATE TABLE `msg_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` text COMMENT '消息内容',
  `title` varchar(10) DEFAULT '' COMMENT '消息标题',
  `msg_send_time` datetime DEFAULT NULL COMMENT '消息发送时间',
  `msg_received_time` datetime DEFAULT NULL COMMENT '消息接收时间',
  `send_user_id` bigint(20) DEFAULT NULL COMMENT '发送方ID',
  `received_user_id` bigint(20) DEFAULT NULL COMMENT '接收方ID',
  `is_deleted` bigint(1) DEFAULT '0' COMMENT '是否删除，1为删除',
  `is_top` bigint(1) DEFAULT '0' COMMENT '是否置顶，1为置顶',
  `is_read` bigint(1) DEFAULT '0' COMMENT '是否已读，1为已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
