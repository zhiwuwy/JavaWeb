/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50561
 Source Host           : localhost:3306
 Source Schema         : rapoo

 Target Server Type    : MySQL
 Target Server Version : 50561
 File Encoding         : 65001

 Date: 29/10/2018 15:00:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cartid` bigint(20) NOT NULL,
  `cid` bigint(20) NOT NULL,
  `cName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cPrice` decimal(10, 2) NOT NULL,
  `count` int(10) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (2, 1, '雷柏V300C', 79.00, 5);
INSERT INTO `cart` VALUES (2, 2, '雷柏V302', 109.00, 1);
INSERT INTO `cart` VALUES (2, 4, '雷柏VT2000', 399.00, 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `productName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dir_id` bigint(8) NOT NULL,
  `salePrice` decimal(10, 2) NOT NULL,
  `supplier` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `brand` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cutoff` double(10, 2) NOT NULL,
  `costPrice` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '雷柏V300C', 1, 78.00, '雷柏', '雷柏', 0.75, 29.00);
INSERT INTO `product` VALUES (2, '雷柏V302', 1, 109.00, '雷柏', '雷柏', 0.75, 49.00);
INSERT INTO `product` VALUES (3, '雷柏V22', 1, 99.00, '雷柏', '雷柏', 0.75, 39.00);
INSERT INTO `product` VALUES (4, '雷柏VT2000', 1, 399.00, '雷柏', '雷柏', 0.75, 199.00);
INSERT INTO `product` VALUES (5, '雷柏M100', 2, 59.00, '雷柏', '雷柏', 0.75, 19.00);
INSERT INTO `product` VALUES (6, '雷柏M890', 2, 88.00, '雷柏', '雷柏', 0.75, 66.00);
INSERT INTO `product` VALUES (7, '雷柏1620', 2, 59.00, '雷柏', '雷柏', 0.75, 20.00);
INSERT INTO `product` VALUES (8, '雷柏1680', 2, 29.00, '雷柏', '雷柏', 0.75, 9.00);
INSERT INTO `product` VALUES (9, '雷柏V500', 3, 99.00, '雷柏', '雷柏', 0.75, 39.00);
INSERT INTO `product` VALUES (10, '雷柏V700S', 3, 199.00, '雷柏', '雷柏', 0.75, 109.00);
INSERT INTO `product` VALUES (11, '雷柏V500L', 3, 199.00, '雷柏', '雷柏', 0.75, 104.00);
INSERT INTO `product` VALUES (12, '雷柏MT500', 3, 249.00, '雷柏', '雷柏', 0.75, 129.00);
INSERT INTO `product` VALUES (13, '雷柏MT700', 4, 349.00, '雷柏', '雷柏', 0.75, 169.00);
INSERT INTO `product` VALUES (14, '雷柏E6700', 4, 199.00, '雷柏', '雷柏', 0.75, 89.00);
INSERT INTO `product` VALUES (15, '雷柏E1050', 4, 69.00, '雷柏', '雷柏', 0.75, 69.00);
INSERT INTO `product` VALUES (16, '雷柏8900P', 4, 499.00, '雷柏', '雷柏', 0.75, 220.00);
INSERT INTO `product` VALUES (17, '雷柏VM150', 5, 99.00, '雷柏', '雷柏', 0.75, 29.00);
INSERT INTO `product` VALUES (18, '雷柏VH300', 5, 189.00, '雷柏', '雷柏', 0.75, 69.00);
INSERT INTO `product` VALUES (19, '雷柏VH150', 5, 99.00, '雷柏', '雷柏', 0.75, 29.00);
INSERT INTO `product` VALUES (20, '雷柏VH200', 5, 129.00, '雷柏', '雷柏', 0.75, 39.00);
INSERT INTO `product` VALUES (21, '雷柏H6020', 6, 79.00, '雷柏', '雷柏', 0.75, 19.00);
INSERT INTO `product` VALUES (22, '雷柏S200', 6, 149.00, '雷柏', '雷柏', 0.75, 49.00);
INSERT INTO `product` VALUES (23, '雷柏S160', 6, 159.00, '雷柏', '雷柏', 0.75, 52.00);
INSERT INTO `product` VALUES (24, '雷柏S100', 6, 99.00, '雷柏', '雷柏', 0.75, 29.00);

-- ----------------------------
-- Table structure for productdir
-- ----------------------------
DROP TABLE IF EXISTS `productdir`;
CREATE TABLE `productdir`  (
  `did` bigint(10) NOT NULL AUTO_INCREMENT,
  `dirName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` bigint(10) NOT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of productdir
-- ----------------------------
INSERT INTO `productdir` VALUES (1, '有线鼠标', 1);
INSERT INTO `productdir` VALUES (2, '无线鼠标', 1);
INSERT INTO `productdir` VALUES (3, '有线键盘', 2);
INSERT INTO `productdir` VALUES (4, '无线键盘', 2);
INSERT INTO `productdir` VALUES (5, '有线耳机', 3);
INSERT INTO `productdir` VALUES (6, '无线耳机', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `identity` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cartid` bigint(20) NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 'seller', 1);
INSERT INTO `user` VALUES (2, 'whyme', '123456', 'buyer', 2);

SET FOREIGN_KEY_CHECKS = 1;
