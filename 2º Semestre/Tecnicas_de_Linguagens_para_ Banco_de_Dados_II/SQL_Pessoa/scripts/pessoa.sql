CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` int(11) NOT NULL DEFAULT '0',
  `primeiro_nome` varchar(10) DEFAULT NULL,
  `nome_do_meio` varchar(10) DEFAULT NULL,
  `ultimo_nome` varchar(10) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `dta_nascimento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
)