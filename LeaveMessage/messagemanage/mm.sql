/*
Navicat MySQL Data Transfer

Source Server         : MMTest
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : mm

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-08-24 11:34:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `user_id` int(10) NOT NULL COMMENT '账号',
  `source` varchar(20) DEFAULT NULL COMMENT '判断留言来源',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `time` datetime DEFAULT NULL COMMENT '留言时间',
  `message` varchar(500) DEFAULT NULL COMMENT '留言信息',
  `messageType` int(2) DEFAULT NULL COMMENT '留言类型',
  `emo` blob COMMENT '表情',
  `background` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '留言板背景',
  `fontColor` varchar(10) DEFAULT NULL COMMENT '字体颜色',
  PRIMARY KEY (`user_id`),
  KEY `source` (`source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1000', '1', '管理员', null, '生活不易生活不易', '1', null, null, null);
INSERT INTO `message` VALUES ('1002', '0', '用户1号', null, '不脱发！', '1', null, null, null);
INSERT INTO `message` VALUES ('1003', '0', '头疼', null, '活着码不容易啊', '0', null, null, null);

-- ----------------------------
-- Table structure for uerinfo
-- ----------------------------
DROP TABLE IF EXISTS `uerinfo`;
CREATE TABLE `uerinfo` (
  `user_id` int(10) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `icon` blob,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `ID` FOREIGN KEY (`user_id`) REFERENCES `message` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of uerinfo
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL COMMENT '账号',
  `type` varchar(10) DEFAULT NULL COMMENT '类型',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `icon` blob COMMENT '头像',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1000', '1', '管理员', '123', null);
INSERT INTO `user` VALUES ('1002', '0', '用户1号', '666', null);
INSERT INTO `user` VALUES ('1003', '0', '头疼', '111', null);

-- ----------------------------
-- View structure for 用户留言
-- ----------------------------
DROP VIEW IF EXISTS `用户留言`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `用户留言` AS select `留言`.`source` AS `source`,`留言`.`time` AS `time`,`留言`.`message` AS `message`,`留言`.`messageType` AS `messageType`,`uerinfo`.`name` AS `name`,`uerinfo`.`user_id` AS `user_id`,`uerinfo`.`type` AS `type`,`uerinfo`.`icon` AS `icon` from (`用户表` join (`留言` join `uerinfo` on((`uerinfo`.`user_id` = `留言`.`user_id`)))) ;
