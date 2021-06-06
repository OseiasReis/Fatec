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
-- Banco de Dados: `nomealunojoinunion`
--
CREATE DATABASE `nomealunojoinunion` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `nomealunojoinunion`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `areas_de_atuacao`
--

CREATE TABLE IF NOT EXISTS `areas_de_atuacao` (
  `id` int(11) NOT NULL,
  `nome_area_atuacao` varchar(30) NOT NULL,
  `salmin` float NOT NULL,
  `salmax` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `areas_de_atuacao`
--

INSERT INTO `areas_de_atuacao` (`id`, `nome_area_atuacao`, `salmin`, `salmax`) VALUES
(1, 'Administrador de banco de dado', 3000, 9000),
(2, 'Analista de redes', 3900, 6000),
(3, 'Analista de segurança', 4400, 6400),
(4, 'Analista de sistemas de intern', 6800, 9100),
(5, 'Analista de sistemas', 4700, 7600),
(6, 'Analista de suporte', 1000, 7000),
(7, 'Designer', 3800, 5400),
(8, 'Programador web', 2500, 5000),
(9, 'Programador', 1800, 9000);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
