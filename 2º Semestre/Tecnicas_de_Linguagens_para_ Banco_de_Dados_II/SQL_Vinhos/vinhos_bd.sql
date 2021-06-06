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
-- Banco de Dados: `vinhos_bd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `casta`
--

CREATE TABLE IF NOT EXISTS `casta` (
  `Casta_ID` int(11) NOT NULL,
  `Design_casta` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Casta_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `casta`
--

INSERT INTO `casta` (`Casta_ID`, `Design_casta`) VALUES
(1, 'Touriga Nacional'),
(2, 'Tinta Roriz'),
(3, 'Tinta Barroca'),
(4, 'Touriga Franca'),
(5, 'Sousão'),
(6, 'Trincadeira'),
(7, 'Tinta Pele'),
(8, 'Castelão'),
(9, 'Moreto'),
(10, 'Cobernet Sauvignon');

-- --------------------------------------------------------

--
-- Estrutura da tabela `casta_vinho`
--

CREATE TABLE IF NOT EXISTS `casta_vinho` (
  `Casta_ID` int(11) NOT NULL DEFAULT '0',
  `Vinho_ID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Casta_ID`,`Vinho_ID`),
  KEY `Vinho_ID` (`Vinho_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `casta_vinho`
--

INSERT INTO `casta_vinho` (`Casta_ID`, `Vinho_ID`) VALUES
(6, 1),
(7, 1),
(10, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtor`
--

CREATE TABLE IF NOT EXISTS `produtor` (
  `Produtor_ID` int(11) NOT NULL DEFAULT '0',
  `Nome_Produtor` varchar(25) NOT NULL,
  `Morada_Produtor` varchar(15) DEFAULT NULL,
  `Telefone` varchar(15) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Regiao_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Produtor_ID`),
  KEY `Regiao_ID` (`Regiao_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtor`
--

INSERT INTO `produtor` (`Produtor_ID`, `Nome_Produtor`, `Morada_Produtor`, `Telefone`, `Email`, `Regiao_ID`) VALUES
(1, 'Qt. Vallado', 'Régua', '+351254323147', 'vallado@mail.telepac.pt', 1),
(3, 'Finagra', 'Reguengos', '+351266509270', 'esporao@esporao.com', 2),
(4, 'Dão Sul', NULL, NULL, NULL, 3),
(6, 'Kolheita Ideias', NULL, '+35125858425', NULL, 1),
(7, 'Zona Sul', NULL, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `regiao`
--

CREATE TABLE IF NOT EXISTS `regiao` (
  `Regiao_ID` int(11) NOT NULL,
  `Desig_regiao` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Regiao_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `regiao`
--

INSERT INTO `regiao` (`Regiao_ID`, `Desig_regiao`) VALUES
(1, 'Douro'),
(2, 'Alentejo'),
(3, 'Dão'),
(4, 'Vinho Verde');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vinho`
--

CREATE TABLE IF NOT EXISTS `vinho` (
  `Vinho_ID` int(11) NOT NULL,
  `Nome_vinho` varchar(20) DEFAULT NULL,
  `Ano_vinho` int(11) DEFAULT NULL,
  `Cor` varchar(10) DEFAULT NULL,
  `Grau` float DEFAULT NULL,
  `Preco` float DEFAULT NULL,
  `Produtor_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Vinho_ID`),
  KEY `Produtor_ID` (`Produtor_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vinho`
--

INSERT INTO `vinho` (`Vinho_ID`, `Nome_vinho`, `Ano_vinho`, `Cor`, `Grau`, `Preco`, `Produtor_ID`) VALUES
(1, 'Esporão Reserva', 2004, 'Tinto', 14.5, 18.5, 3),
(2, 'Quinta do Vallado', 2004, 'Tinto', 14, 6.5, 1),
(3, 'Muros Antigos', 2006, 'Branco', 13, 7.5, 7);

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `casta_vinho`
--
ALTER TABLE `casta_vinho`
  ADD CONSTRAINT `casta_vinho_ibfk_1` FOREIGN KEY (`Vinho_ID`) REFERENCES `vinho` (`Vinho_ID`),
  ADD CONSTRAINT `casta_vinho_ibfk_2` FOREIGN KEY (`Casta_ID`) REFERENCES `casta` (`Casta_ID`);

--
-- Restrições para a tabela `produtor`
--
ALTER TABLE `produtor`
  ADD CONSTRAINT `produtor_ibfk_1` FOREIGN KEY (`Regiao_ID`) REFERENCES `regiao` (`Regiao_ID`);

--
-- Restrições para a tabela `vinho`
--
ALTER TABLE `vinho`
  ADD CONSTRAINT `vinho_ibfk_1` FOREIGN KEY (`Produtor_ID`) REFERENCES `produtor` (`Produtor_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
