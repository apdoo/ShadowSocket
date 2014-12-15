/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.6.15 : Database - shadow
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/shadow /*!40100 DEFAULT CHARACTER SET utf8 */;

USE shadow;

/*Table structure for table server */

DROP TABLE IF EXISTS server;

CREATE TABLE server (
  id int(6) NOT NULL AUTO_INCREMENT,
  ip varchar(40) NOT NULL COMMENT 'IP',
  addr varchar(50) NOT NULL COMMENT '地区',
  encryption varchar(40) NOT NULL COMMENT '加密方式',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table server */

insert  into server(id,ip,addr,encryption) values (1,'1.1.1.1','美国','aes-256-cfb'),(2,'202.2.2.2','中国','aes-256-cfb'),(3,'3.3.3.3','日本','aes-256-cfb');

/*Table structure for table user */

DROP TABLE IF EXISTS user;

CREATE TABLE user (
  uid int(11) NOT NULL AUTO_INCREMENT,
  user_name varchar(128) NOT NULL COMMENT '登录用户名',
  email varchar(32) NOT NULL COMMENT '邮箱',
  pass varchar(32) NOT NULL COMMENT '登录密码',
  passwd varchar(16) NOT NULL COMMENT 'ss密码，要明文',
  t int(11) NOT NULL DEFAULT '0' COMMENT '最后使用时间',
  u bigint(20) NOT NULL COMMENT '上传',
  d bigint(20) NOT NULL COMMENT '下载',
  transfer_enable bigint(20) NOT NULL COMMENT '流量限止，字节为单位',
  port int(11) NOT NULL COMMENT 'ss端口，不能有重复',
  switch tinyint(4) NOT NULL DEFAULT '1',
  enable tinyint(4) NOT NULL DEFAULT '1',
  type tinyint(4) NOT NULL DEFAULT '1',
  last_get_gitf_time int(11) NOT NULL DEFAULT '0',
  last_rest_pass_time int(11) NOT NULL DEFAULT '0',
  reg_date datetime NOT NULL COMMENT '注册时间',
  server varchar(20) DEFAULT NULL COMMENT '服务器ID',
  priv tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否为管理员，1管理员，0普通',
  PRIMARY KEY (uid)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table user */

insert  into user(uid,user_name,email,pass,passwd,t,u,d,transfer_enable,port,switch,enable,type,last_get_gitf_time,last_rest_pass_time,reg_date,server,priv) values (1,'user','test@test.com','9003d1df22eb4d3820015070385194c8','0000000',1410609560,3,4,30000000000,50000,1,1,7,0,0,'2014-11-07 00:00:00','1,2,3',0);

-----管理员
insert  into user(uid,user_name,email,pass,passwd,t,u,d,transfer_enable,port,switch,enable,type,last_get_gitf_time,last_rest_pass_time,reg_date,server,priv) values (0,'admin','admin@admin.com','9003d1df22eb4d3820015070385194c8','0000000',1410609560,3,4,30000000000,50000,1,1,7,0,0,'2014-11-07 00:00:00','1,2,3',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
