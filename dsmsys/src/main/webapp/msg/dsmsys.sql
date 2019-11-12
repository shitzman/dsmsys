/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : dsmsys

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-11-12 16:46:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adm_id` int(11) NOT NULL,
  `adm_name` varchar(20) DEFAULT NULL,
  `adm_mobile` varchar(255) DEFAULT NULL,
  `adm_password` varchar(255) DEFAULT NULL,
  `adm_access` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '时', '123456789', '123456', '999');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `c_flag` int(255) NOT NULL AUTO_INCREMENT COMMENT '车牌号',
  `c_id` varchar(255) NOT NULL COMMENT '车牌号',
  `c_img` varchar(255) DEFAULT NULL,
  `c_status` int(255) DEFAULT NULL COMMENT '车辆状态(0:不可使用，1：可使用）',
  `c_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_flag`,`c_id`),
  KEY `c_flag` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '京A8888', 'car.jpg', '1', '可用');
INSERT INTO `car` VALUES ('3', '豫A6666', 'car.jpg', '1', '可用');

-- ----------------------------
-- Table structure for exammsg
-- ----------------------------
DROP TABLE IF EXISTS `exammsg`;
CREATE TABLE `exammsg` (
  `e_id` int(255) NOT NULL AUTO_INCREMENT,
  `e_time` date DEFAULT NULL,
  `e_subject` int(2) DEFAULT NULL,
  `e_address` varchar(100) DEFAULT NULL,
  `e_all_num` int(5) DEFAULT NULL COMMENT '可报考人数',
  `e_alr_num` int(5) DEFAULT NULL COMMENT '已报考人数',
  PRIMARY KEY (`e_id`),
  KEY `tr_num` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exammsg
-- ----------------------------
INSERT INTO `exammsg` VALUES ('1', '2019-10-31', '1', '新乡市', '20', '2');
INSERT INTO `exammsg` VALUES ('2', '2019-11-01', '2', '新乡市红旗区', '10', '5');

-- ----------------------------
-- Table structure for examorder
-- ----------------------------
DROP TABLE IF EXISTS `examorder`;
CREATE TABLE `examorder` (
  `s_id` int(11) DEFAULT NULL,
  `e_num` int(11) DEFAULT NULL,
  KEY `testApp_stu` (`s_id`),
  KEY `testApp_testinf` (`e_num`),
  CONSTRAINT `testApp_stu` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE SET NULL,
  CONSTRAINT `testApp_testinf` FOREIGN KEY (`e_num`) REFERENCES `exammsg` (`e_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examorder
-- ----------------------------
INSERT INTO `examorder` VALUES ('2', '1');

-- ----------------------------
-- Table structure for remark
-- ----------------------------
DROP TABLE IF EXISTS `remark`;
CREATE TABLE `remark` (
  `s_id` int(255) NOT NULL,
  `e_id` int(255) NOT NULL,
  `r_status` int(2) DEFAULT NULL,
  `r_score` int(3) DEFAULT NULL,
  `r_remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`s_id`,`e_id`),
  KEY `ti_num` (`e_id`),
  CONSTRAINT `testre_stu` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`),
  CONSTRAINT `testre_testinf` FOREIGN KEY (`e_id`) REFERENCES `exammsg` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remark
-- ----------------------------
INSERT INTO `remark` VALUES ('3', '1', '1', '100', '已过关');
INSERT INTO `remark` VALUES ('4', '2', '0', '0', '待考');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_number` varchar(42) DEFAULT NULL,
  `s_name` varchar(20) DEFAULT NULL,
  `s_sex` varchar(2) DEFAULT NULL,
  `t_id` int(11) DEFAULT NULL,
  `s_mobile` varchar(20) DEFAULT NULL,
  `s_current` int(5) DEFAULT NULL COMMENT '指示当前考试科目',
  `s_account` int(2) DEFAULT NULL COMMENT '当前账户状态（0：不可用，1：管理员审批可用）',
  `s_password` varchar(20) DEFAULT NULL,
  `s_status` int(2) DEFAULT NULL COMMENT '考试状态（0:未约考，1：已申请，2已约考）',
  `s_reg_time` date DEFAULT NULL,
  `s_ex_time` date DEFAULT NULL,
  `s_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `stu_teacher` (`t_id`),
  CONSTRAINT `stu_teacher` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '411452348456', '学员1', '男', '1', '15234685145', '1', '1', '123456', '0', '2019-11-04', '2020-11-19', '新乡');
INSERT INTO `student` VALUES ('3', '1488465241', '学员2', '女', '2', '15845632445', '2', '1', '123456', '1', '2019-10-09', '2021-10-31', '郑州');
INSERT INTO `student` VALUES ('4', '422031548784', '学员3', '男', '2', '15487411545', '2', '1', '123456', '2', '2019-10-09', '2021-10-31', '新乡');
INSERT INTO `student` VALUES ('14', '411423195844951', '时', '男', '0', '15224791863', '1', '1', '123456', '0', '2019-11-04', null, '河南');
INSERT INTO `student` VALUES ('15', '41115454', '15154', '男', '0', 'test', '0', '0', 'test', '0', null, null, 'test');
INSERT INTO `student` VALUES ('16', '1545451515', '测试未申请', '女', '0', '123', '0', '0', '123', '0', null, null, '23');
INSERT INTO `student` VALUES ('17', '123456789123', '测试审批', '男', '0', '123456', '1', '1', '123456', '0', '2019-11-04', null, '123456');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教练id',
  `c_id` varchar(11) DEFAULT NULL COMMENT '车牌号',
  `t_name` varchar(10) DEFAULT NULL,
  `t_sex` varchar(2) DEFAULT NULL,
  `t_subject` int(1) DEFAULT NULL COMMENT '教练所教授科目',
  `t_img` varchar(100) DEFAULT '' COMMENT '教练照片存储路径',
  PRIMARY KEY (`t_id`),
  KEY `teacher_car` (`c_id`),
  CONSTRAINT `teacher_car` FOREIGN KEY (`c_id`) REFERENCES `car` (`c_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '京A8888', '张三', '男', '1', 'teacher.jpg');
INSERT INTO `teacher` VALUES ('2', null, '李四', '男', '2', 'teacher.jpg');
INSERT INTO `teacher` VALUES ('13', '豫A6666', '默认', '默认', '0', 'teacher.jpg');
