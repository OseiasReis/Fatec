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
-- Banco de Dados: `banco1`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `carro`
--

CREATE TABLE IF NOT EXISTS `carro` (
  `id_carro` int(11) NOT NULL AUTO_INCREMENT,
  `modelo` varchar(50) DEFAULT NULL,
  `cor` varchar(15) DEFAULT NULL,
  `ano` smallint(4) DEFAULT NULL,
  PRIMARY KEY (`id_carro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `carro`
--

INSERT INTO `carro` (`id_carro`, `modelo`, `cor`, `ano`) VALUES
(1, 'Corsa', 'Vermelho', 2003),
(2, 'Fusca', 'Branco', 1966),
(3, 'Palio', 'Prata', 2009),
(4, 'Gol', 'Branco', 2008);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
