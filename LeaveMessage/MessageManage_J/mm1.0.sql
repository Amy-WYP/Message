/*
Navicat MySQL Data Transfer

Source Server         : MMTest
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : mm

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-08-20 22:53:30
*/

SET FOREIGN_KEY_CHECKS=0;

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
  CONSTRAINT `ID` FOREIGN KEY (`user_id`) REFERENCES `留言` (`user_id`)
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
INSERT INTO `user` VALUES ('1725121000', '1', '管理员', '123456', null);
INSERT INTO `user` VALUES ('1725121001', '0', '用户1号', '888888', null);

-- ----------------------------
-- Table structure for 留言
-- ----------------------------
DROP TABLE IF EXISTS `留言`;
CREATE TABLE `留言` (
  `user_id` int(10) NOT NULL COMMENT '账号',
  `source` varchar(20) DEFAULT NULL COMMENT '判断留言来源',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `time` datetime DEFAULT NULL COMMENT '留言时间',
  `message` varchar(500) DEFAULT NULL COMMENT '留言信息',
  `messageType` int(2) DEFAULT NULL COMMENT '留言类型',
  `emo` blob COMMENT '表情',
  `background` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '留言板背景',
  `fontColor` varchar(10) DEFAULT NULL COMMENT '字体颜色',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of 留言
-- ----------------------------
INSERT INTO `留言` VALUES ('1725121000', '1', '管理员', null, '生活不易生活不易', null, null, null, null);
INSERT INTO `留言` VALUES ('1725121001', '0', '用户1号', null, '不脱发！', null, null, null, null);
