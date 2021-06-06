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
-- Banco de Dados: `escola`
--
CREATE DATABASE `escola` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `escola`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos_aprovados`
--

CREATE TABLE IF NOT EXISTS `alunos_aprovados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `ende` varchar(50) DEFAULT NULL,
  `num` smallint(3) DEFAULT NULL,
  `cidade` varchar(15) DEFAULT NULL,
  `UF` smallint(2) DEFAULT NULL,
  `telefone` char(8) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `tel_cel` char(9) DEFAULT NULL,
  `bicho_est` varchar(20) DEFAULT NULL,
  `time_cora` varchar(20) DEFAULT NULL,
  `cpf` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `alunos_aprovados`
--

INSERT INTO `alunos_aprovados` (`id`, `nome`, `ende`, `num`, `cidade`, `UF`, `telefone`, `email`, `sexo`, `tel_cel`, `bicho_est`, `time_cora`, `cpf`) VALUES
(1, 'Oseias', 'Rua Taiguaratorro', 37, 'Sao Paulo', 0, '20145236', 'oseiasreis77@hotmail.com', 'Masculino', '98632145', 'Rodrigo', 'Coracao', '85274196375'),
(2, 'Sara', 'Rua Caeiras', 38, 'Sao Paulo', 0, '20879236', 'sara@hotmail.com', 'Feminino', '959363215', 'Cachorro', 'Corinthians', '98632514896'),
(3, 'Julia', 'Rua Espinosa', 25, 'Sao Paulo', 0, '20152365', 'julia@hotmail.com', 'Feminino', '998765432', 'Dorgado', 'corinthians', '85624196375'),
(4, 'Deadpool', 'Rua X-men', 99, 'Nova York', 0, '86523651', 'peidei_sai_@hotmail.com', 'Masculino', '98636145', 'Cega', 'São Paulo', '85274196392'),
(5, 'Catarina', 'Rua Catarananense', 88, 'Sao Paulo', 0, '20625236', 'catarinaaaa@hotmail.com', 'Feminino', '92232145', 'Spick', 'Palmeiras', '85274182375'),
(6, 'Samara', 'Rua PQVoceMeTrai', 51, 'Sao Paulo', 0, '20995236', 'chorando@hotmail.com', 'Feminino', '98635245', 'Lucas', 'santos', '85574196375');
--
-- Banco de Dados: `exemplo`
--
CREATE DATABASE `exemplo` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `exemplo`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `testes`
--

CREATE TABLE IF NOT EXISTS `testes` (
  `nome` char(15) DEFAULT NULL,
  `endereco` char(50) DEFAULT NULL,
  `email` char(30) DEFAULT NULL,
  `telefone` char(8) DEFAULT NULL,
  `nascimento` date NOT NULL DEFAULT '0000-00-00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
