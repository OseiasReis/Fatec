CREATE TABLE IF NOT EXISTS `ususario_do_sistema` (
  `id` int(11) NOT NULL DEFAULT '0',
  `nome_de_login` varchar(15) DEFAULT NULL,
  `senha` char(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
)