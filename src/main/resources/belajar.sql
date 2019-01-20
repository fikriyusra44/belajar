/*
 Navicat Premium Data Transfer

 Source Server         : LOCAL
 Source Server Type    : MariaDB
 Source Server Version : 100213
 Source Host           : localhost:3306
 Source Schema         : belajar

 Target Server Type    : MariaDB
 Target Server Version : 100213
 File Encoding         : 65001

 Date: 04/09/2018 13:10:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for table_students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_students
-- ----------------------------
BEGIN;
INSERT INTO `students` VALUES (1, 'Student 1', 'Yogyakarta');
INSERT INTO `students` VALUES (2, 'Student 2', 'Bantul');
COMMIT;
