DROP DATABASE IF EXISTS `spider`;
CREATE DATABASE `spider`;
USE `spider`;

DROP TABLE IF EXISTS `district`;
CREATE TABLE `district` (
  `id` VARCHAR(50) NOT NULL COMMENT 'ID',
  `province` varchar(20) NOT NULL COMMENT '省',
  `city` varchar(20) NOT NULL COMMENT '市',
  `district` varchar(20) COMMENT '区',
  `village` varchar(50) COMMENT '小区',
  `url` varchar(100) COMMENT '链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地区表';

DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` varchar(20) NOT NULL COMMENT '编号',
  `districtId` varchar(50) NOT NULL COMMENT '地区编号',
  `status` enum('ON_SALE', 'SELL_OUT', 'WITHDRAW') NOT NULL COMMENT '状态',
  `unitPrice` double NOT NULL COMMENT '单价',
  `squareMeasure` double NOT NULL COMMENT '面积',
  `type` varchar(10) NOT NULL COMMENT '房型',
  `totalPrice` double NOT NULL COMMENT '总价',
  `launchTime` datetime(3) NOT NULL COMMENT '上架时间',
  `withdrawTime` datetime(3) COMMENT '下架时间',
  `url` varchar(100) COMMENT '链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房源表';

DROP TABLE IF EXISTS `box`;
CREATE TABLE `box` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `districtId` varchar(50) NOT NULL COMMENT '地区编号',
  `date` datetime(3) COMMENT '日期',
  `status` enum('ON_SALE', 'SELL_OUT', 'WITHDRAW') NOT NULL COMMENT '状态',
  `amount` int(11) NOT NULL default 0 COMMENT '数量',
  `bottomBorder` double NOT NULL COMMENT '下边界',
  `firstQuarter` double NOT NULL COMMENT '下四分位数',
  `middle` double NOT NULL COMMENT '中位数',
  `thirdQuarter` double NOT NULL COMMENT '上四分位数',
  `topBorder` double NOT NULL COMMENT '上边界',
  `bottomErrPrev` double NOT NULL COMMENT '下界异常率',
  `topErrPrev` double NOT NULL COMMENT '上界异常率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='箱线数据表';
