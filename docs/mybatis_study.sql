/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : localhost:3306
 Source Schema         : mybatis_study

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 28/04/2020 15:47:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `managerId` bigint(20) NULL DEFAULT NULL COMMENT '直属上级id',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `manager_fk`(`managerId`) USING BTREE,
  CONSTRAINT `manager_fk` FOREIGN KEY (`managerId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1087982257332887553, '大boss', 40, 'boss@baomidou.com', NULL, '2019-01-11 14:20:20');
INSERT INTO `user` VALUES (1088248166370832385, '王天风', 25, 'wtf@baomidou.com', 1087982257332887553, '2019-02-05 11:12:22');
INSERT INTO `user` VALUES (1088250446457389058, '李艺伟', 28, 'lyw@baomidou.com', 1088248166370832385, '2019-02-14 08:31:16');
INSERT INTO `user` VALUES (1094590409767661570, '张雨琪', 31, 'zjq@baomidou.com', 1088248166370832385, '2019-01-14 09:15:15');
INSERT INTO `user` VALUES (1094592041087729666, '刘红雨', 32, 'lhm@baomidou.com', 1088248166370832385, '2019-01-14 09:48:16');
INSERT INTO `user` VALUES (1255035918741749761, '郝红梅', 30, NULL, 1088248166370832385, '2020-04-28 15:27:35');
INSERT INTO `user` VALUES (1255037600758312961, '郝红梅', 30, NULL, 1088248166370832385, '2020-04-28 15:34:16');
INSERT INTO `user` VALUES (1255039225669443585, '郝红梅', 30, NULL, 1088248166370832385, '2020-04-28 15:40:43');
INSERT INTO `user` VALUES (1255040456311734274, '郝红梅', 30, NULL, 1088248166370832385, '2020-04-28 15:45:37');

SET FOREIGN_KEY_CHECKS = 1;
