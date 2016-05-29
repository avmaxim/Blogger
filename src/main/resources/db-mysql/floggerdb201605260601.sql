-- MySQL dump 10.13  Distrib 5.6.10, for Win32 (x86)
--
-- Host: localhost    Database: floggerdb
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `advertisement`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `advertisement` (
  `AdvertisementID` int(11) NOT NULL AUTO_INCREMENT,
  `Header` varchar(100) NOT NULL,
  `Contents` text NOT NULL,
  `ArticleID` int(11) NOT NULL,
  PRIMARY KEY (`AdvertisementID`),
  UNIQUE KEY `AdvertisementID_UNIQUE` (`AdvertisementID`),
  KEY `fk_Advertisement_Article1_idx` (`ArticleID`),
  CONSTRAINT `fk_Advertisement_Article1` FOREIGN KEY (`ArticleID`) REFERENCES `article` (`ArticleID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisement`
--

INSERT INTO `advertisement` (`AdvertisementID`, `Header`, `Contents`, `ArticleID`) VALUES (1,'Want to skill urself up? But dunno where to start?','Welcome to our whecked-out conspiracy aka DummiesBummies!!',1),(2,'Online Java courses for 1 weak.','We\'re waiting 4 u =) Go over this link to learn how to persue our courses: https://www.udemy.com',1);

--
-- Table structure for table `article`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `article` (
  `ArticleID` int(11) NOT NULL AUTO_INCREMENT,
  `Header` varchar(100) NOT NULL,
  `Contents` text NOT NULL,
  `LikesCount` int(11) NOT NULL DEFAULT '0',
  `DateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UserID` int(11) NOT NULL,
  PRIMARY KEY (`ArticleID`),
  UNIQUE KEY `ArticleID_UNIQUE` (`ArticleID`),
  KEY `fk_Article_User1_idx` (`UserID`),
  CONSTRAINT `fk_Article_User1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`ArticleID`, `Header`, `Contents`, `LikesCount`, `DateTime`, `UserID`) VALUES (1,'Java vs Javascript 2016. Still stumped? ','in the nutshell, java is mostly used for back, js for front',0,'2016-05-26 12:30:29',1);

--
-- Table structure for table `comment`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `comment` (
  `CommentID` int(11) NOT NULL AUTO_INCREMENT,
  `Contents` text NOT NULL,
  `DateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ArticleID` int(11) NOT NULL,
  PRIMARY KEY (`CommentID`),
  UNIQUE KEY `CommentID_UNIQUE` (`CommentID`),
  KEY `fk_Comment_Article1_idx` (`ArticleID`),
  CONSTRAINT `fk_Comment_Article1` FOREIGN KEY (`ArticleID`) REFERENCES `article` (`ArticleID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`CommentID`, `Contents`, `DateTime`, `ArticleID`) VALUES (1,'Nice, i loved it. I haven\'t even come across any articles yet where they would reveal the difference and similarity between these 2 languages in such a way.','2016-05-26 12:34:35',1),(2,'Awesome!!! Looking forward to ur future posts. I loooove it!.','2016-05-26 12:34:35',1);

--
-- Table structure for table `permission`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `permission` (
  `NamePermission` int(11) NOT NULL,
  PRIMARY KEY (`NamePermission`),
  UNIQUE KEY `NamePermission_UNIQUE` (`NamePermission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--


--
-- Table structure for table `role`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `role` (
  `NameRole` varchar(50) NOT NULL,
  PRIMARY KEY (`NameRole`),
  UNIQUE KEY `NameRole_UNIQUE` (`NameRole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`NameRole`) VALUES ('Admin'),('Manager'),('User');

--
-- Table structure for table `user`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(100) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `NameRole` varchar(50) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `UserID_UNIQUE` (`UserID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  KEY `fk_User_Role1_idx` (`NameRole`),
  CONSTRAINT `fk_User_Role1` FOREIGN KEY (`NameRole`) REFERENCES `role` (`NameRole`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `Email`, `Username`, `Password`, `NameRole`) VALUES (1,'avmax19@gmail.com','avmax19','123','User'),(2,'roma36@gmail.com','roma36','qwe','Admin'),(3,'dimagurin@gmail.com','gurind','iop','Manager'),(4,'sbgraf@gmail.com','sgraf','890','User'),(5,'n3m8tz@gmail.com','n3m8tz','021','User');
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-26  6:01:20
