/*
SQLyog Ultimate v12.08 (32 bit)
MySQL - 8.0.18 : Database - meeting
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`meeting` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `meeting`;

/*Table structure for table `counter` */

DROP TABLE IF EXISTS `counter`;

CREATE TABLE `counter` (
  `visitcount` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `counter` */

insert  into `counter`(`visitcount`,`id`) values (105,1);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `departmentid` int(16) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`departmentid`,`departmentname`) values (13,'技术部'),(14,'财务部'),(15,'市场部'),(16,'商务部'),(17,'销售部'),(20,'生产部');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employeeid` int(16) NOT NULL AUTO_INCREMENT,
  `employeename` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `departmentid` int(16) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`employeeid`,`employeename`,`username`,`phone`,`email`,`status`,`departmentid`,`password`,`role`) values (8,'王晓华','wangxh','13671075406','wang@qq.com','1',13,'1','1'),(9,'林耀坤','linyk','13671075406','yang@qq.com','1',13,'1','2'),(10,'熊杰文','xiongjw','134555555','xiong@qq.com','1',13,'1','2'),(11,'王敏','wangmin','1324554321','wangm@qq.com','1',15,'1','2'),(15,'黄美玲','huangml','huangml@qq.com','13567898765','1',15,'1','2'),(20,'王敏','wangmin002','13454332334','wang@qq.com','1',15,'1','2'),(21,'陈敏','chenm','13559994444','www@aa.com','0',15,'1','2'),(23,'陈晨','wangm','22·2','11','1',14,'1','2'),(25,'王晓华','wangxh222','111','1','1',14,'1','2'),(27,'张三','zhangsan','122','22','1',16,'1','2'),(28,'李四','lisi','1','1','1',16,'1','2'),(29,'王五','wangwu','1','1','1',17,'1','2'),(30,'赵六','zhaoliu','1','1','1',13,'1','2'),(32,'冯七','fengqi','1','1','1',13,'1','2'),(33,'马八','maba','1','1','1',13,'1','2'),(34,'钱十','qianshi','1','1','2',13,'1','2'),(35,'周十一','zhoushiyi','1','1','1',13,'1','2'),(36,'wushier','wushier','1','1','0',13,'1','2');

/*Table structure for table `meeting` */

DROP TABLE IF EXISTS `meeting`;

CREATE TABLE `meeting` (
  `meetingid` int(16) NOT NULL AUTO_INCREMENT,
  `meetingname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roomid` int(16) DEFAULT NULL,
  `reservationistid` int(16) DEFAULT NULL,
  `numberofparticipants` int(16) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `reservationtime` datetime DEFAULT NULL,
  `canceledtime` datetime DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `canceledreason` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `meeting` */

insert  into `meeting`(`meetingid`,`meetingname`,`roomid`,`reservationistid`,`numberofparticipants`,`starttime`,`endtime`,`reservationtime`,`canceledtime`,`description`,`status`,`canceledreason`) values (25,'ces',5,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-10 23:02:39','2017-08-23 14:48:40',NULL,'0','aaaaaaaaaaaaaaa'),(26,'测测',7,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-17 23:04:18','2015-01-11 01:06:20',NULL,'0',NULL),(27,'我看看',6,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-10 23:06:33','2015-01-11 01:01:42','我看看','0',NULL),(28,'运营会',5,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-10 23:26:26','2017-08-23 14:49:06','测试','0','ppppppppppppppppppppp'),(29,'市场部会议',6,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-10 23:44:41',NULL,'市场部','0',NULL),(30,'内部会议',10,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-10 23:56:20',NULL,'内部会议','0',NULL),(31,'我的会议',9,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-11 16:35:11',NULL,'测试','0',NULL),(32,'我的会议哈哈',5,8,10,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-11 16:40:50',NULL,'','0',NULL),(33,'哈哈',6,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-11 16:42:09','2015-01-12 11:44:57','你好','0',NULL),(34,'我的会议3',8,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-11 16:42:51',NULL,'测试','0',NULL),(35,'我的会议',7,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-11 16:44:35',NULL,'','0',NULL),(36,'我问问',7,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-11 16:57:56','2015-01-11 16:59:57','地点','0',NULL),(37,'我的会议4',7,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-11 16:59:49',NULL,'我的会议','0',NULL),(38,'班会',9,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-12 11:49:17','2015-01-12 11:49:37','班会','1',NULL),(39,'测试会议',5,8,12,'2017-08-25 12:00:00','2017-08-30 12:00:00','2015-01-14 14:44:07',NULL,'ss','0',NULL),(40,'市场研究会议',5,8,99,'2017-08-25 12:00:00','2017-08-30 12:00:00','2017-08-16 21:23:45',NULL,'222222222222222222222','0',NULL),(41,'哈哈哈',17,8,99,'2017-08-25 12:00:00','2017-08-30 12:00:00','2017-08-21 14:28:36',NULL,'aaaaaaaaaaaaaaaaaaa','0',NULL);

/*Table structure for table `meetingparticipants` */

DROP TABLE IF EXISTS `meetingparticipants`;

CREATE TABLE `meetingparticipants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(16) NOT NULL,
  `employeeid` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `meetingparticipants` */

insert  into `meetingparticipants`(`id`,`meetingid`,`employeeid`) values (1,28,13),(2,28,23),(3,28,27),(4,28,16),(5,29,16),(6,29,13),(7,29,8),(8,30,15),(9,30,13),(10,30,8),(11,30,23),(12,27,8),(13,26,8),(14,25,8),(15,28,8),(16,31,8),(17,31,17),(18,31,23),(19,32,8),(20,32,17),(21,33,15),(22,34,8),(23,34,17),(24,35,8),(25,36,9),(26,36,8),(27,37,8),(28,37,23),(29,38,11),(30,38,16),(31,38,20),(32,39,13),(33,40,10),(34,40,8),(35,40,9),(36,41,10),(37,41,8),(38,41,9);

/*Table structure for table `meetingroom` */

DROP TABLE IF EXISTS `meetingroom`;

CREATE TABLE `meetingroom` (
  `roomid` int(16) NOT NULL AUTO_INCREMENT,
  `roomnum` int(16) NOT NULL,
  `roomname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `capacity` int(16) DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`roomid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `meetingroom` */

insert  into `meetingroom`(`roomid`,`roomnum`,`roomname`,`capacity`,`status`,`description`) values (5,101,'第一会议室',15,'0','公共会议室'),(6,102,'第二会议室',5,'0','管理部门会议室'),(7,103,'第三会议室',12,'0','市场部专用会议室'),(8,401,'第四会议室',15,'0','公共会议室'),(9,201,'第五会议室',15,'0','最大会议室'),(10,601,'第六会议室',12,'0','需要提前三天预定'),(15,999,'第999会议室',99,'0','第999会议室，哈哈哈哈哈'),(16,998,'第998会议室',98,'1','第998会议室，哈哈哈哈哈'),(17,996,'第996会议室',96,'0','第996666666666666666666666666会议室顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
