/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : hibernate

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-03-11 00:54:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(255) DEFAULT NULL,
  `cust_source` varchar(255) DEFAULT NULL,
  `cust_industry` varchar(255) DEFAULT NULL,
  `cust_level` varchar(255) DEFAULT NULL,
  `cust_phone` varchar(255) DEFAULT NULL,
  `cust_mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'customer1', null, null, null, null, null);
INSERT INTO `customer` VALUES ('2', 'customer2', null, null, null, null, null);
INSERT INTO `customer` VALUES ('3', 'customer3', null, null, null, null, null);

-- ----------------------------
-- Table structure for `linkman`
-- ----------------------------
DROP TABLE IF EXISTS `linkman`;
CREATE TABLE `linkman` (
  `link_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(255) DEFAULT NULL,
  `link_gender` varchar(255) DEFAULT NULL,
  `link_phone` varchar(255) DEFAULT NULL,
  `link_mobile` varchar(255) DEFAULT NULL,
  `link_email` varchar(255) DEFAULT NULL,
  `link_qq` varchar(255) DEFAULT NULL,
  `link_position` varchar(255) DEFAULT NULL,
  `link_memo` varchar(255) DEFAULT NULL,
  `link_cust_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`link_id`),
  KEY `FKeixto111iws64sd78b4ktip7p` (`link_cust_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of linkman
-- ----------------------------
INSERT INTO `linkman` VALUES ('1', 'linkman1', null, null, null, null, null, null, null, '2');
INSERT INTO `linkman` VALUES ('2', 'linkman2', null, null, null, null, null, null, null, '1');
INSERT INTO `linkman` VALUES ('3', 'linkman3', null, null, null, null, null, null, null, '2');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) NOT NULL COMMENT '角色名称',
  `role_memo` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_code` varchar(32) NOT NULL COMMENT '用户账号',
  `user_name` varchar(64) NOT NULL COMMENT '用户名称',
  `user_password` varchar(32) NOT NULL COMMENT '用户密码',
  `user_state` char(1) NOT NULL COMMENT '1:正常,0:暂停',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
