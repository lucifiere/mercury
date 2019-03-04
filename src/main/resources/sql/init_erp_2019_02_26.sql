--交易表--
CREATE TABLE `erp_deal` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易编号',
  `begin_deal_date` TIMESTAMP DEFAULT NULL COMMENT '交易开始日期',
  `end_deal_date` TIMESTAMP DEFAULT NULL COMMENT '交易结束日期',
  `need_fetch_goods` INTEGER DEFAULT 0 COMMENT '缺货',
  `need_jg` INTEGER not NULL DEFAULT 0 COMMENT '加工',
  `complete` INTEGER not null default 0 COMMENT '完成',
  `xh_order_id` INTEGER DEFAULT NULL COMMENT '售货订单编号',
  `th_order_id` INTEGER DEFAULT NULL COMMENT '提货单编号',
  `xq_order_id` INTEGER DEFAULT NULL COMMENT '需求单编号',
  `cg_order_id` INTEGER DEFAULT NULL COMMENT '采购单编号',
  `qh_order_id` INTEGER DEFAULT NULL COMMENT '取货单编号',
  `jg_order_id` INTEGER DEFAULT NULL COMMENT '加工单编号',
  `rk_order_id` INTEGER DEFAULT NULL COMMENT '入库单编号',
  `os_order_id` INTEGER DEFAULT NULL COMMENT '出库单编号',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--客户信息表--
create TABLE `erp_customer_info`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `driver_id` integer(11) default 0 COMMENT '客户司机编号',
  `company_name` varchar(32) default null COMMENT '公司名称',
  `company_address` varchar(32) default null COMMENT '公司地址',
  `company_credit` integer(11) default 0 COMMENT '信用度',
  `phone` varchar(32) default null COMMENT '联系方式',
  primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--无货物质价格表/库存物质价格表--
--无货物质价格表：货物库存量为0，货物成本单价，货物加工运输单价，货物税率由采购员根据市面价格做的估价--
CREATE TABLE `erp_price`(
  `id` INTEGER(8) NOT NULL AUTO_INCERMENT COMMENT '货物编号',
  `items_name` VARCHAR(50) DEFAULT NULL COMMENT '货物名称',
  `items_unit` VARCHAR(50) DEFAULT NULL COMMENT '货物单位',
  `items_tax` INTEGER(8) DEFAULT NULL COMMENT '货物税率',
  `items_cost` INTEGER(8) DEFAULT NULL COMMENT '货物成本单价',
  `items_add_tran_cost` INTEGER(8) DEFAULT NULL COMMENT '货物加工运输单价',
  `items_store_counts` INTEGER(8) DEFAULT NULL COMMENT '货物库存量',
  PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--物质明细表--
CREATE TABLE `erp_items_info`(
  `id` INTEGER(8) NOT NULL AUTO_INCREMENT COMMENT '货物编号',
  `items_name` VARCHAR(50) DEFAULT NULL COMMENT '货物名称',
  `items_origin` VARCHAR(50) DEFAULT NULL COMMENT '货物产地',
  `items_scale` VARCHAR(50) DEFAULT NULL COMMENT '货物规格',
  `items_counts` INTEGER(8) DEFAULT 0 COMMENT '货物可供数量',
  `items_order_no` VARCHAR(50) DEFAULT NULL COMMENT '货物采购合同号',
  `items_add_no` VARCHAR(50) DEFAULT NULL COMMENT '货物加工合同号',
  `items_tran_no` VARCHAR(50) DEFAULT NULL COMMENT '货物运输合同号',
  `items_in_store_no` VARCHAR(50) DEFAULT NULL COMMENT '货物入库合同号',
  PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

----
