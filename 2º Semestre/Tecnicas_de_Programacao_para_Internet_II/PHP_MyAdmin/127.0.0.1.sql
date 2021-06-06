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
-- Banco de Dados: `bdescola`
--
CREATE DATABASE `bdescola` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bdescola`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE IF NOT EXISTS `alunos` (
  `Matricula` varchar(5) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Endereco` varchar(50) NOT NULL,
  `Cidade` varchar(30) NOT NULL,
  `CodCurso` char(2) NOT NULL,
  PRIMARY KEY (`Matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`Matricula`, `Nome`, `Endereco`, `Cidade`, `CodCurso`) VALUES
('', '', '', '', ''),
('10001', 'Andre Moraes da silva', 'Rua Padre Joao, 35', 'Sao paulo', '01'),
('10002', 'Amanda Andrade', 'Rua Ibituruna, 120', 'Rio de janeiro', '01'),
('10003', 'Luiz Lopes', 'Rua Tejupa, 158', 'Rio de janeiro', '01'),
('10004', 'Oseias Pereira Reis', 'Rua Brasil, 522', 'Sao Paulo', '01'),
('10005', 'Oseias Pereira R', 'Rua testeeee', 'Testeee', '02'),
('20001', 'Thiago Henrique', 'Av Aguia de Haia, 205 ', 'Sao paulo', '02'),
('20002', 'Augusto Pereira', 'Estrada Padre Roser, 223', 'Rio de janeiro', '02'),
('30001', 'Carina Lopes Mello', 'Av Guarulhos, 2054', 'Guarulhos', '03'),
('30002', 'Dom Juan Cafajeste', 'Rua DJC, 852', 'DoFunk', '03'),
('40001', 'Henrique Bernardo dos Santos', 'Rua Imalaia, 583', 'Paris', '04'),
('40002', 'Bin Laden', 'Av. Torre Gemeas, 520', 'Noestadosunidos', '04'),
('50001', 'Tomas Ryan Freitas', 'Quadra QR, 121', 'Brasilia', '05'),
('50002', 'Gabriella Bertini Souza', 'Rua Avenida Rua Casa, 7401', 'Estado', '05'),
('60001', 'Paulo Diogo Cesar Castro', 'Rua Henrique Schwambach, 132', 'Blumenau', '06'),
('70001', 'Adriana Ana Ronana', 'Rua  Analia Analista, 951', 'Anapolis', '07'),
('70002', 'Tamara Rodrigues Santos', 'Rua Gabarantes, 951', 'Sao Paulo', '07'),
('80001', 'Mariah Maria Cardoso', 'Rua Josefa Lucio de Oliveira, 362', 'Arapiraca', '08'),
('80002', 'Itamar Franco Freitas', 'Rua Barranceira, 623', 'Sao Paulo', '08'),
('90001', 'Pai de Familia', 'Rua Ahhhhhh Q Delicia, 24', 'Delicia', '09');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `CodCurso` char(2) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `CodDisc1` char(2) NOT NULL,
  `CodDisc2` char(2) NOT NULL,
  `CodDisc3` char(2) NOT NULL,
  PRIMARY KEY (`CodCurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cursos`
--

INSERT INTO `cursos` (`CodCurso`, `Nome`, `CodDisc1`, `CodDisc2`, `CodDisc3`) VALUES
('01', 'Auxiliar de Informatica para Internet', '11', '12', '13'),
('02', 'Auxiliar em Design de Websites', '21', '22', '23'),
('03', 'Engenharia de Controle e Automacao', '15', '24', '20'),
('04', 'Gestao da Tecnologia da Informacao', '21', '22', '19'),
('05', 'Analista Programador Senior', '14', '18', '17'),
('06', 'Redes de Computadores', '16', '23', '20'),
('07', 'Banco de Dados', '24', '11', '15'),
('08', 'Webdesigner', '18', '17', '13'),
('09', 'Jogos Digitais', '23', '21', '24');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplinas`
--

CREATE TABLE IF NOT EXISTS `disciplinas` (
  `CodDisciplina` char(2) NOT NULL,
  `NomeDisciplina` varchar(50) NOT NULL,
  PRIMARY KEY (`CodDisciplina`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `disciplinas`
--

INSERT INTO `disciplinas` (`CodDisciplina`, `NomeDisciplina`) VALUES
('11', 'Gestao de Sistemas Operacionais'),
('12', 'Operacao de Softwares Aplicativos I'),
('13', 'Arquitetura de Computadores'),
('14', 'Computacao Cientifica'),
('15', 'Engenharia de Software'),
('16', 'Inteligencia Artificial'),
('17', 'Projeto e Analise de Algoritmos'),
('18', 'Redes de Computadores'),
('19', 'Empreendedorismo'),
('20', 'Logica para Computacao '),
('21', 'Sistemas Digitais'),
('22', 'Seguranca da Informacao'),
('23', 'Modelagem de Software'),
('24', 'Programacao para Internet');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `login` varchar(10) NOT NULL,
  `senha` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`login`, `senha`) VALUES
('admin', 'adm123');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
