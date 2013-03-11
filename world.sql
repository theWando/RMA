-- MySQL dump 10.9
--
-- Host: localhost    Database: world
-- ------------------------------------------------------
-- Server version	4.1.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `City`
--
USE `rma`;
 
DROP TABLE IF EXISTS `City`;
CREATE TABLE `City` (
  `ID` int(11) NOT NULL auto_increment,
  `Name` char(35) NOT NULL default '',
  `CountryCode` char(3) NOT NULL default '',
  `District` char(20) NOT NULL default '',
  `Population` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `City`
--


INSERT INTO `City` VALUES (3539,'Caracas','VEN','Distrito Federal',1975294);
INSERT INTO `City` VALUES (3540,'MaracaÃ­bo','VEN','Zulia',1304776);
INSERT INTO `City` VALUES (3541,'Barquisimeto','VEN','Lara',877239);
INSERT INTO `City` VALUES (3542,'Valencia','VEN','Carabobo',794246);
INSERT INTO `City` VALUES (3543,'Ciudad Guayana','VEN','BolÃ­var',663713);
INSERT INTO `City` VALUES (3544,'Petare','VEN','Miranda',488868);
INSERT INTO `City` VALUES (3545,'Maracay','VEN','Aragua',444443);
INSERT INTO `City` VALUES (3546,'Barcelona','VEN','AnzoÃ¡tegui',322267);
INSERT INTO `City` VALUES (3547,'MaturÃ­n','VEN','Monagas',319726);
INSERT INTO `City` VALUES (3548,'San CristÃ³bal','VEN','TÃ¡chira',319373);
INSERT INTO `City` VALUES (3549,'Ciudad BolÃ­var','VEN','BolÃ­var',301107);
INSERT INTO `City` VALUES (3550,'CumanÃ¡','VEN','Sucre',293105);
INSERT INTO `City` VALUES (3551,'MÃ©rida','VEN','MÃ©rida',224887);
INSERT INTO `City` VALUES (3552,'Cabimas','VEN','Zulia',221329);
INSERT INTO `City` VALUES (3553,'Barinas','VEN','Barinas',217831);
INSERT INTO `City` VALUES (3554,'Turmero','VEN','Aragua',217499);
INSERT INTO `City` VALUES (3555,'Baruta','VEN','Miranda',207290);
INSERT INTO `City` VALUES (3556,'Puerto Cabello','VEN','Carabobo',187722);
INSERT INTO `City` VALUES (3557,'Santa Ana de Coro','VEN','FalcÃ³n',185766);
INSERT INTO `City` VALUES (3558,'Los Teques','VEN','Miranda',178784);
INSERT INTO `City` VALUES (3559,'Punto Fijo','VEN','FalcÃ³n',167215);
INSERT INTO `City` VALUES (3560,'Guarenas','VEN','Miranda',165889);
INSERT INTO `City` VALUES (3561,'Acarigua','VEN','Portuguesa',158954);
INSERT INTO `City` VALUES (3562,'Puerto La Cruz','VEN','AnzoÃ¡tegui',155700);
INSERT INTO `City` VALUES (3563,'Ciudad Losada','VEN','',134501);
INSERT INTO `City` VALUES (3564,'Guacara','VEN','Carabobo',131334);
INSERT INTO `City` VALUES (3565,'Valera','VEN','Trujillo',130281);
INSERT INTO `City` VALUES (3566,'Guanare','VEN','Portuguesa',125621);
INSERT INTO `City` VALUES (3567,'CarÃºpano','VEN','Sucre',119639);
INSERT INTO `City` VALUES (3568,'Catia La Mar','VEN','Distrito Federal',117012);
INSERT INTO `City` VALUES (3569,'El Tigre','VEN','AnzoÃ¡tegui',116256);
INSERT INTO `City` VALUES (3570,'Guatire','VEN','Miranda',109121);
INSERT INTO `City` VALUES (3571,'Calabozo','VEN','GuÃ¡rico',107146);
INSERT INTO `City` VALUES (3572,'Pozuelos','VEN','AnzoÃ¡tegui',105690);
INSERT INTO `City` VALUES (3573,'Ciudad Ojeda','VEN','Zulia',99354);
INSERT INTO `City` VALUES (3574,'Ocumare del Tuy','VEN','Miranda',97168);
INSERT INTO `City` VALUES (3575,'Valle de la Pascua','VEN','GuÃ¡rico',95927);
INSERT INTO `City` VALUES (3576,'Araure','VEN','Portuguesa',94269);
INSERT INTO `City` VALUES (3577,'San Fernando de Apure','VEN','Apure',93809);
INSERT INTO `City` VALUES (3578,'San Felipe','VEN','Yaracuy',90940);
INSERT INTO `City` VALUES (3579,'El LimÃ³n','VEN','Aragua',90000);


--
-- Table structure for table `Country`
--

DROP TABLE IF EXISTS `Country`;
CREATE TABLE `Country` (
  `Code` char(3) NOT NULL default '',
  `Name` char(52) NOT NULL default '',
  `Continent` enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') NOT NULL default 'Asia',
  `Region` char(26) NOT NULL default '',
  `SurfaceArea` float(10,2) NOT NULL default '0.00',
  `IndepYear` smallint(6) default NULL,
  `Population` int(11) NOT NULL default '0',
  `LifeExpectancy` float(3,1) default NULL,
  `GNP` float(10,2) default NULL,
  `GNPOld` float(10,2) default NULL,
  `LocalName` char(45) NOT NULL default '',
  `GovernmentForm` char(45) NOT NULL default '',
  `HeadOfState` char(60) default NULL,
  `Capital` int(11) default NULL,
  `Code2` char(2) NOT NULL default '',
  PRIMARY KEY  (`Code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Country`
--


INSERT INTO `Country` VALUES ('VEN','Venezuela','South America','South America',912050.00,1811,24170000,73.1,95023.00,88434.00,'Venezuela','Federal Republic','Hugo ChÃ¡vez FrÃ­as',3539,'VE');

--
-- Table structure for table `CountryLanguage`
--

DROP TABLE IF EXISTS `CountryLanguage`;
CREATE TABLE `CountryLanguage` (
  `CountryCode` char(3) NOT NULL default '',
  `Language` char(30) NOT NULL default '',
  `IsOfficial` enum('T','F') NOT NULL default 'F',
  `Percentage` float(4,1) NOT NULL default '0.0',
  PRIMARY KEY  (`CountryCode`,`Language`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CountryLanguage`
--


INSERT INTO `CountryLanguage` VALUES ('VEN','Spanish','T',96.9);
INSERT INTO `CountryLanguage` VALUES ('VEN','Goajiro','F',0.4);
INSERT INTO `CountryLanguage` VALUES ('VEN','Warrau','F',0.1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

