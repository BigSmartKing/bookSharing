/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.40 : Database - booksharingdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`booksharingdb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `booksharingdb`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `book_id` int(255) NOT NULL AUTO_INCREMENT,
  `isbn` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `book_name` char(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '书名',
  `book_author` char(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '作者，可以为空',
  `book_location` char(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '拿书地点，可以为空',
  `book_detail` char(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图书描述，如用途',
  `book_status` int(50) DEFAULT '0' COMMENT '0未借出、1已借出',
  `book_owner` int(255) NOT NULL COMMENT '图书上传人',
  `book_count` int(255) NOT NULL COMMENT '图书数量',
  `book_category_id` int(255) NOT NULL COMMENT '图书类别ID',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `book` */

insert  into `book`(`book_id`,`isbn`,`book_name`,`book_author`,`book_location`,`book_detail`,`book_status`,`book_owner`,`book_count`,`book_category_id`) values (1,'1224557','test','test','test','test',0,0,1,1),(2,'978-7-5536-6271-8','小学英语词汇','俞洪敏','未知','单词书',1,0,1,1),(3,'978-7-5536-6261-9','洛洛历险记','张三丰','未知','千千万万',0,0,1,1),(4,'978-7-5536-6251-8','武林外传','张无忌','七管','一本不错的图书',1,0,1,1),(5,'978-7-6654-6251-5','一个人的武林','派伊','八管','挂科必看',1,0,1,1),(6,'978-7-5536-6271-1','考研词汇闪过修改测试','俞洪敏','七管','九成新，七管自取',1,6,1,2),(9,'1563','123','132',NULL,'23',0,132,1321,1),(11,'123456789','图书归还测试','马向宇','图书归还测试','图书归还测试',1,6,1,2),(14,'13','1','测试','测试','1测试',0,1,1,2),(15,'45a\'s','asdsa','撒旦撒旦撒旦撒','我去','娶我去d',0,1,1,2),(17,'1222','12','12','12','12',0,1,1,4),(18,'12','2','12','12','12',1,1,1,4),(19,'12','12','12','12','12',1,1,1,4);

/*Table structure for table `book_category_作废` */

DROP TABLE IF EXISTS `book_category_作废`;

CREATE TABLE `book_category_作废` (
  `book_category_id` int(255) NOT NULL AUTO_INCREMENT,
  `book_id` int(255) NOT NULL,
  `category_id` int(255) NOT NULL,
  PRIMARY KEY (`book_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `book_category_作废` */

insert  into `book_category_作废`(`book_category_id`,`book_id`,`category_id`) values (1,1,1);

/*Table structure for table `book_rent` */

DROP TABLE IF EXISTS `book_rent`;

CREATE TABLE `book_rent` (
  `rent_id` int(255) NOT NULL AUTO_INCREMENT,
  `rent_user_id` int(255) NOT NULL COMMENT '租书人ID',
  `rent_provider_id` int(255) NOT NULL COMMENT '图书提供者ID',
  `rent_begin_date` date NOT NULL COMMENT '租出日期',
  `rent_finish_date` date NOT NULL COMMENT '还书日期',
  `rent_book_id` int(255) NOT NULL COMMENT '租赁的图书',
  `rent_penalty` int(255) NOT NULL DEFAULT '0' COMMENT '要交罚款与否 0不1要',
  `rent_expire` int(255) NOT NULL DEFAULT '0' COMMENT '是否到期 0未1 已',
  `rent_statue` int(255) NOT NULL DEFAULT '0' COMMENT '0在租赁，1归还提交',
  PRIMARY KEY (`rent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `book_rent` */

insert  into `book_rent`(`rent_id`,`rent_user_id`,`rent_provider_id`,`rent_begin_date`,`rent_finish_date`,`rent_book_id`,`rent_penalty`,`rent_expire`,`rent_statue`) values (14,1,7,'2022-02-05','2022-02-05',12,0,0,0),(17,1,7,'2022-02-11','2022-02-12',13,0,0,0),(20,7,1,'2022-02-01','2022-02-02',16,0,0,0),(21,7,1,'2022-02-26','2022-02-27',19,0,0,0),(22,7,1,'2022-02-11','2022-02-12',18,0,0,0);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_id` int(255) NOT NULL AUTO_INCREMENT,
  `category_name` char(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '具体类别',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `category` */

insert  into `category`(`category_id`,`category_name`) values (1,'暂未分类'),(2,'考研'),(3,'CET-4/6'),(4,'考试白皮书'),(5,'娱乐小说');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `notice_id` int(255) NOT NULL AUTO_INCREMENT,
  `notice_time` datetime DEFAULT NULL,
  `notice_title` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `notice_content` mediumtext COLLATE utf8_unicode_ci,
  `notice_read` int(255) DEFAULT '0' COMMENT '通知阅读量',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `notice` */

insert  into `notice`(`notice_id`,`notice_time`,`notice_title`,`notice_content`,`notice_read`) values (1,'2022-02-09 15:08:57','修改测试','修改内容测试',1),(3,'2022-02-09 16:42:13','富文本标题测试','<p>这里是富文本内容，加粗，<strong>加粗了</strong></p>\n\n<table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:500px\">\n	<tbody>\n		<tr>\n			<td>1</td>\n			<td>2</td>\n		</tr>\n		<tr>\n			<td>3</td>\n			<td>4</td>\n		</tr>\n		<tr>\n			<td>5</td>\n			<td>6</td>\n		</tr>\n	</tbody>\n</table>\n\n<p>&nbsp;</p>\n',0);

/*Table structure for table `statistics` */

DROP TABLE IF EXISTS `statistics`;

CREATE TABLE `statistics` (
  `sta_id` int(255) NOT NULL AUTO_INCREMENT,
  `sta_user_count` int(255) DEFAULT NULL COMMENT '当天注册人数',
  `sta_book_count` int(255) NOT NULL COMMENT '当天图书上传数',
  `sta_rent_count` int(255) DEFAULT NULL COMMENT '当天图书租赁数',
  `sta_date` date DEFAULT NULL,
  PRIMARY KEY (`sta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `statistics` */

insert  into `statistics`(`sta_id`,`sta_user_count`,`sta_book_count`,`sta_rent_count`,`sta_date`) values (1,1990,500,480,'2022-02-07'),(2,500,670,458,'2022-02-08'),(3,780,250,120,'2022-02-09'),(4,807,402,120,'2022-02-10'),(5,205,145,350,'2022-02-11'),(6,500,400,350,'2022-02-12'),(7,700,350,580,'2022-02-13'),(8,800,700,700,'2022-02-14');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '学号工号',
  `user_name` char(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `user_pwd` char(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `user_tell` char(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '手机号',
  `user_category` int(255) NOT NULL COMMENT '学院',
  `user_sex` int(255) NOT NULL COMMENT '性别 0 1',
  `user_role` int(255) NOT NULL DEFAULT '1' COMMENT '0管理员 1 用户',
  `user_credit` int(255) DEFAULT '1' COMMENT '0 违约 1 okk',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `users` */

insert  into `users`(`user_id`,`user_name`,`user_pwd`,`user_tell`,`user_category`,`user_sex`,`user_role`,`user_credit`) values (0,'root','ok','14762175389',7,0,0,1),(1,'584820231','ok','14762175389',7,0,1,1),(7,'test','ok','14762145874',6,0,1,1),(8,'584820232','ok','14762175389',1,0,1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
