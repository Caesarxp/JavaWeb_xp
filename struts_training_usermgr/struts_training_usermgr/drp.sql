/*
MySQL Data Transfer
Source Host: localhost
Source Database: drp
Target Host: localhost
Target Database: drp
Date: 2014-2-3 17:41:32
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `contact_tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_user` VALUES ('a0001', 'qwwwww', 'ederfr', 'swdsfdggf', 'dfgfhfhghghg', '2014-02-03 17:36:02');
INSERT INTO `t_user` VALUES ('c33344', '32345454', '123456767', '12345678', 'c333@133.com', '2014-02-03 17:39:47');
