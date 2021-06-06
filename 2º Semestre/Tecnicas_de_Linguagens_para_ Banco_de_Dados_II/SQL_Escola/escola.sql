-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 21-Set-2015 às 22:12
-- Versão do servidor: 5.6.15-log
-- PHP Version: 5.5.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `escola`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE IF NOT EXISTS `aluno` (
  `rm_aluno` int(11) NOT NULL DEFAULT '0',
  `nome` varchar(25) NOT NULL,
  `telefone` char(11) NOT NULL,
  `idade` char(3) DEFAULT NULL,
  PRIMARY KEY (`rm_aluno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`rm_aluno`, `nome`, `telefone`, `idade`) VALUES
(0, 'Oseias', '08007777000', '16'),
(1, 'Gabriela', '25621459', '17'),
(2, 'Julia', '23651231', '16'),
(3, 'Nagila', '65234561', '16'),
(4, 'Layra', '22434561', '16'),
(5, 'Mylena', '98536425', '16'),
(6, 'Raissa', '45636425', '16'),
(7, 'Micole', '45634543', '16'),
(8, 'Nicole', '41234543', '16'),
(9, 'Rafaela', '12425335', '16'),
(10, 'Sara', '20425335', '16'),
(11, 'Mayara', '20412335', '16'),
(12, 'Luiza', '23652335', '16');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `registro_func` int(11) NOT NULL DEFAULT '0',
  `nome` varchar(25) NOT NULL,
  `telefone` char(11) NOT NULL,
  `departamento` varchar(20) NOT NULL,
  `salario` char(10) DEFAULT NULL,
  PRIMARY KEY (`registro_func`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`registro_func`, `nome`, `telefone`, `departamento`, `salario`) VALUES
(0, 'Rafaela', '12425335', 'RH', '1500'),
(1, 'Renata', '11453335', 'Juridico', '1800'),
(2, 'Sara', '24145335', 'Marketing', '2000'),
(3, 'Nagila', '52365335', 'Compras', '2100'),
(4, 'Layra', '52363635', 'Vendas', '2000'),
(5, 'Raissa', '21363635', 'Administrativo', '1200'),
(6, 'Giovanna', '25369884', 'Operacional', '3200'),
(7, 'Gabriela', '36526988', 'Financeiro', '3100'),
(8, 'Nicole', '11236335', 'Juridico', '1800'),
(9, 'Samara', '26345335', 'Marketing', '2000'),
(10, 'Natalia', '36253235', 'Compras', '2100'),
(11, 'Laura', '23653635', 'Administrativo', '1200'),
(12, 'Gizele', '25391236', 'Operacional', '3200');

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE IF NOT EXISTS `professor` (
  `rg_prof` int(11) NOT NULL DEFAULT '0',
  `nome` varchar(25) NOT NULL,
  `telefone` char(11) NOT NULL,
  `materia` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`rg_prof`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`rg_prof`, `nome`, `telefone`, `materia`) VALUES
(0, 'Rafaela', '12425335', 'Geografia'),
(1, 'Sandra', '25365335', 'Biologia'),
(2, 'Sara', '23365335', 'Fisica'),
(3, 'Nagila', '86935335', 'Portugues'),
(4, 'Luana', '23655335', 'Matematica'),
(5, 'Larissa', '23658963', 'Ed. Fisica'),
(6, 'Samanta', '23658963', 'Sociologia'),
(7, 'Locao', '12368963', 'Filosofia'),
(8, 'Gabriela', '12345678', 'Artes'),
(9, 'Linda', '98765678', 'Sexologia'),
(10, 'Francine', '26765678', 'Historia'),
(11, 'Fabiana', '26761236', 'Literatura'),
(12, 'Agatha', '21561236', 'Etica');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
