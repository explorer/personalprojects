/*
Navicat MySQL Data Transfer

Source Server         : wuyaowen
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : plane

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-06-18 15:15:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rank`
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank` (
  `username` varchar(10) NOT NULL,
  `score` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank
-- ----------------------------
INSERT INTO `rank` VALUES ('111', '3300');
INSERT INTO `rank` VALUES ('123456', '18800');
INSERT INTO `rank` VALUES ('zhangsan', '500');
INSERT INTO `rank` VALUES ('嗯', '7100');
