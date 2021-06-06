-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.27-log
-- Versão do PHP: 5.4.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `exemplo1`
--
CREATE DATABASE `exemplo1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `exemplo1`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `idCliente` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `nomeEmpresa` varchar(255) DEFAULT NULL,
  `nomeDiretor` varchar(255) DEFAULT NULL,
  `numEmpregados` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`idCliente`, `nomeEmpresa`, `nomeDiretor`, `numEmpregados`) VALUES
(1, 'Malesuada Inc.', 'Johnny Pedd', 4847),
(2, 'Aliquam Inc.', 'Al Capino', 4135),
(3, 'Union Carbide', 'Robert Ne Diro', 3755),
(4, 'Magma Carta Ltda.', 'Wenzel Dashington', 3071),
(5, 'Nunc Corp.', '', 3859),
(6, 'InCompany', 'Macaulay Bulkin', 4440),
(7, 'GameCorp.', 'Din Viesel', 2071);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
