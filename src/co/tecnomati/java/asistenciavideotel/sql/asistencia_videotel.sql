-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-08-2014 a las 23:29:02
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `asistencia_videotel`
--
CREATE DATABASE IF NOT EXISTS `asistencia_videotel` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `asistencia_videotel`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE IF NOT EXISTS `asistencia` (
  `AID` int(11) NOT NULL,
  `EID` tinyint(3) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `MCONTADOR` tinyint(2) DEFAULT NULL,
  `NTURNO` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`AID`),
  KEY `EID` (`EID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE IF NOT EXISTS `comentario` (
  `CID` tinyint(3) NOT NULL,
  `SID` tinyint(3) DEFAULT NULL,
  `DESCRIPCION` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `EID` tinyint(3) NOT NULL,
  `SID` tinyint(3) DEFAULT NULL,
  `DNI` int(9) DEFAULT NULL,
  `TELEFONO` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `APELLIDO` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FOTO` blob,
  `ESTADO` bit(1) DEFAULT NULL,
  `ADMINISTRADOR` bit(1) DEFAULT NULL,
  `CLAVE` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`EID`),
  KEY `SID` (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `ID` tinyint(3) NOT NULL,
  `NOMBRE` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TELEFONO` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DOMICILIO` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `LOGO` blob,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE IF NOT EXISTS `horario` (
  `HID` tinyint(3) NOT NULL,
  `TID` tinyint(3) DEFAULT NULL,
  `EID` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`HID`),
  KEY `TID` (`TID`),
  KEY `EID` (`EID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcacion`
--

CREATE TABLE IF NOT EXISTS `marcacion` (
  `MAID` int(11) NOT NULL,
  `AID` int(11) DEFAULT NULL,
  `ENTRADA` date DEFAULT NULL,
  `SALIDA` date DEFAULT NULL,
  `ETOLERANCIA` tinyint(3) DEFAULT NULL,
  `STOLERANCIA` tinyint(3) DEFAULT NULL,
  `MODIFICADO` bit(1) DEFAULT NULL,
  `FMODIFICADO` date DEFAULT NULL,
  `ESTADO` bit(1) DEFAULT NULL,
  PRIMARY KEY (`MAID`),
  KEY `AID` (`AID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sector`
--

CREATE TABLE IF NOT EXISTS `sector` (
  `SID` tinyint(3) NOT NULL,
  `ID` tinyint(3) DEFAULT NULL,
  `DESCRIPCION` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`SID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tcategoria`
--

CREATE TABLE IF NOT EXISTS `tcategoria` (
  `TCID` tinyint(3) NOT NULL,
  `DESCRIPCION` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`TCID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE IF NOT EXISTS `turno` (
  `TID` tinyint(3) NOT NULL,
  `TCID` tinyint(3) DEFAULT NULL,
  `ENTRADA` date DEFAULT NULL,
  `SALIDA` date DEFAULT NULL,
  `DIAS` varchar(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ETOLERANCIA` date DEFAULT NULL,
  `STOLERANCIA` date DEFAULT NULL,
  `NTURNO` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`TID`),
  KEY `TCID` (`TCID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `asistencia_ibfk_1` FOREIGN KEY (`EID`) REFERENCES `empleado` (`EID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `sector` (`SID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `horario_ibfk_1` FOREIGN KEY (`TID`) REFERENCES `turno` (`TID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `horario_ibfk_2` FOREIGN KEY (`EID`) REFERENCES `empleado` (`EID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `marcacion`
--
ALTER TABLE `marcacion`
  ADD CONSTRAINT `marcacion_ibfk_1` FOREIGN KEY (`AID`) REFERENCES `asistencia` (`AID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `sector`
--
ALTER TABLE `sector`
  ADD CONSTRAINT `sector_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `empresa` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `turno_ibfk_1` FOREIGN KEY (`TCID`) REFERENCES `tcategoria` (`TCID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
