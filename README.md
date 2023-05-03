# COMP5521-Project
COMP5521 Project for Blockchain

Database operation：

MySQL：

Create tables：

Table name: user_info:
-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_ID` int NOT NULL,
  `user_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_pw` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_status` int DEFAULT NULL,
  `user_code` int DEFAULT NULL,
  `btc_wallet_id` int DEFAULT NULL,
  `btc_balance` double DEFAULT NULL,
  `eth_wallet_id` int DEFAULT NULL,
  `eth_balance` double DEFAULT NULL,
  `ltc_wallet_id` int DEFAULT NULL,
  `ltc_balance` double DEFAULT NULL,
  `stellar_wallet_id` int DEFAULT NULL,
  `stellar_balance` double DEFAULT NULL,
  `xrp_wallet_id` int DEFAULT NULL,
  `xrp_balance` double DEFAULT NULL,
  `fiat_wallet_id` int DEFAULT NULL,
  `fiat_balance` double DEFAULT NULL,
  PRIMARY KEY (`user_ID`)
)

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES (110, 'TYG', NULL, 'TYG123', NULL, NULL, NULL, 0, NULL, 0, NULL, 0, NULL, 0, NULL, 0, NULL, 0);
INSERT INTO `user_info` VALUES (123, 'WHL', NULL, 'whl123', NULL, NULL, NULL, 0, NULL, 0, NULL, 0, NULL, 0, NULL, 0, NULL, 0);
INSERT INTO `user_info` VALUES (123456, 'Test', 'polyu@gmail.com', 'asd123', NULL, NULL, 1, 5, 1, 2, 1, 4, 1, 2, 1, 1, 1, 8);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;






Table name: order_info:
-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_ID` varchar(20) NOT NULL,
  `user_ID` int DEFAULT NULL,
  `order_time` varchar(20) DEFAULT NULL,
  `order_type` varchar(10) DEFAULT NULL,
  `order_origin` varchar(20) DEFAULT NULL,
  `order_destination` varchar(20) DEFAULT NULL,
  `order_amount` double DEFAULT NULL,
  `order_fee` double DEFAULT NULL,
  `order_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`order_ID`),
  KEY `user_ID` (`user_ID`),
  CONSTRAINT `order_info_ibfk_1` FOREIGN KEY (`user_ID`) REFERENCES `user_info` (`user_ID`)
)

-- ----------------------------
-- Records of order_info
-- ----------------------------
BEGIN;
INSERT INTO `order_info` VALUES ('Test202305031', 123, '2023-05-03 11:20:06', 'buy', '123', '123456', 10, 1, 'success');
INSERT INTO `order_info` VALUES ('Test202305032', 123, '2023-05-03 11:20:06', 'sell', '123', '123456', 20, 2, 'success');
INSERT INTO `order_info` VALUES ('Test202305033', 123, '2023-05-03 11:20:06', 'convert', '123', '123456', 30, 3, 'success');
INSERT INTO `order_info` VALUES ('Test202305034', 123, '2023-05-03 11:20:06', 'convert', '123', '123456', 40, 4, 'pending');
INSERT INTO `order_info` VALUES ('Test202305035', 123, '2023-05-03 11:20:06', 'convert', '123', '123456', 50, 5, 'fail');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
