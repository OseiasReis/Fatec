create database ilibrary;
use ilibrary;

create table localizacao (
cep varchar(9),
endereco varchar(50) not null,
bairro varchar(40),
cidade varchar(40)
) ENGINE=InnoDb;

create table cliente (
registro_cliente varchar(15),
cep varchar(9) not null,
tipo varchar(15) not null,
nome varchar(50) not null,
sexo varchar(9),
data_nasc date,
num_residencia varchar(6) not null,
complemento varchar(30),
telefone varchar(14),
celular varchar(15),
email varchar(50),
responsavel varchar(50),
multa_pendente decimal(7,2),
ativo boolean
) ENGINE=InnoDb;

create table acervo (
cod_acervo varchar(15),
cod_classificacao varchar(15) not null,
tipo_material varchar(15),
titulo varchar(200) not null,
subtitulo varchar(200),
imagem longblob,
idioma varchar(30),
edicao varchar(2),
volume varchar(2),
editora varchar(35),
nome_autor varchar(50),
num_paginas varchar(4),
ano_publicacao varchar(4),
local_publicacao varchar(30),
resumo varchar(2000),
isbn varchar(30),
dimensoes varchar(25),
ativo boolean
) ENGINE=InnoDb;

create table classificacao (
cod_classificacao varchar(15),
assunto varchar(40)
) ENGINE=InnoDb;

create table exemplar (
cod_exemplar varchar(15),
cod_acervo varchar(15) not null,
preco_compra varchar(7),
detalhe_fisico varchar(500),
disponibilidade varchar(11),
emprestado boolean,
ativo boolean    
) ENGINE=InnoDb;

create table emprestimo (
cod_emprestimo bigint,
registro_cliente varchar(15) not null,
cod_exemplar bigint not null,
registro_operador varchar (15) not null,
data_retirada date,
hora_retirada varchar(10),
data_devolucao date,
devolvido boolean
) ENGINE=InnoDb;

create table devolucao (
cod_emprestimo bigint,
registro_operador varchar(15) not null,
data_entrega date,
hora_entrega varchar(10),
termino_susp date,
preco_multa decimal(5,2)
) ENGINE=InnoDb;

create table operador (
registro_operador varchar(15),
privilegio varchar(15) not null,
nome varchar(50),
cep varchar(9) not null,
numero varchar(6),
telefone varchar(14),
celular varchar(15),
senha varchar (10) character set latin1 collate latin1_swedish_ci,
ativo boolean
) ENGINE=InnoDb;


create table penalidade (
suspensao_manual boolean,
suspensao_automatica boolean,
dias_suspensao varchar(2),
multa boolean,
valor_multa decimal(4,2),
emprestar_suspenso boolean,
emprestar_multado boolean

) ENGINE=InnoDb;

create table config (
nome varchar(50),
descricao varchar(50),
logo longblob,
email varchar(30),
telefone varchar(14),
endereco varchar(30)
) ENGINE=InnoDb;




ALTER TABLE localizacao ADD CONSTRAINT pk_localizacao PRIMARY KEY (cep);

ALTER TABLE cliente ADD CONSTRAINT pk_cliente PRIMARY KEY (registro_cliente);

ALTER TABLE acervo ADD CONSTRAINT pk_acervo PRIMARY KEY (cod_acervo);

ALTER TABLE classificacao ADD CONSTRAINT pk_classificacao PRIMARY KEY (cod_classificacao);

ALTER TABLE exemplar ADD CONSTRAINT pk_exemplar PRIMARY KEY (cod_exemplar);
ALTER TABLE exemplar CHANGE cod_exemplar cod_exemplar BIGINT AUTO_INCREMENT;

ALTER TABLE emprestimo ADD CONSTRAINT pk_emprestimo PRIMARY KEY (cod_emprestimo);
ALTER TABLE emprestimo CHANGE cod_emprestimo cod_emprestimo BIGINT AUTO_INCREMENT;

ALTER TABLE operador ADD CONSTRAINT pk_operador PRIMARY KEY (registro_operador);




ALTER TABLE acervo ADD CONSTRAINT fk_acervo FOREIGN KEY (cod_classificacao) REFERENCES classificacao (cod_classificacao);

ALTER TABLE cliente ADD CONSTRAINT fk_cliente FOREIGN KEY (cep) REFERENCES localizacao (cep);

ALTER TABLE exemplar ADD CONSTRAINT fk_exemplar FOREIGN KEY (cod_acervo) REFERENCES acervo (cod_acervo);

ALTER TABLE emprestimo ADD CONSTRAINT fk_emprestimo1 FOREIGN KEY (registro_cliente) REFERENCES cliente (registro_cliente);

ALTER TABLE emprestimo ADD CONSTRAINT fk_emprestimo2 FOREIGN KEY (registro_operador) REFERENCES operador (registro_operador);

ALTER TABLE emprestimo ADD CONSTRAINT fk_emprestimo3 FOREIGN KEY (cod_exemplar) REFERENCES exemplar (cod_exemplar);

ALTER TABLE devolucao ADD CONSTRAINT fk_devolucao1 FOREIGN KEY (cod_emprestimo) REFERENCES emprestimo (cod_emprestimo);

ALTER TABLE devolucao ADD CONSTRAINT fk_devolucao2 FOREIGN KEY (registro_operador) REFERENCES operador (registro_operador);

ALTER TABLE operador ADD CONSTRAINT fk_operador FOREIGN KEY (cep) REFERENCES localizacao (cep);




ALTER TABLE cliente MODIFY COLUMN ativo boolean DEFAULT TRUE;

ALTER TABLE cliente MODIFY COLUMN multa_pendente decimal (7,2) DEFAULT 0;




INSERT INTO localizacao ( cep , endereco , bairro , cidade ) VALUES
('aaaaa-aaa', 'Rua Administrador', 'Administrador', 'Administrador' );

INSERT INTO operador ( registro_operador , privilegio , nome , cep , numero ,  telefone , celular , senha , ativo ) VALUES
('admin', 'Administrador', 'Administrador', 'aaaaa-aaa', null , null , null , 'admin' , true);

INSERT INTO penalidade ( suspensao_manual , suspensao_automatica , dias_suspensao , multa , valor_multa ,  emprestar_suspenso , emprestar_multado ) VALUES
(true, false, '5', false, '0.00' , true , true);

INSERT INTO config ( nome, descricao, logo, email, telefone, endereco ) VALUES
('Logo', null , 0x89504e470d0a1a0a0000000d49484452000001180000006408060000005d192f820000000473424954080808087c086488000000097048597300002e2300002e230178a53f7600000016744558744372656174696f6e2054696d650030322f32312f3136bb4656380000001c74455874536f6674776172650041646f62652046697265776f726b7320435336e8bcb28c000015b049444154789ced9d7b9064575dc73f27bb21c4246680181e826910790a3bc84b5ea6514b82d16442816c4590e62185ca637cf0284a4c83067928d9288a58407a8d140858cc2a286095f452284142e855241509a417282124c0ac044848b25ffff89dbb7de6cebdb7efedd7cc2cbf4fd5ad99bee7de737ee7dcbedf3e8fdf392748c2711c671e9cb0d506388e73fce202e338cedcd8bdd506941142d86a131cc79912afc1388e33375c601cc7991b2e308ee3cc0d1718c771e6860b8ce33873c305c6719cb9e102e338cedc7081711c676eb8c0388e33375c601cc7991b2e308ee3cc0d1718c771e6860b8ce33873c305c6719cb9e102e338cedc7081711c676eb8c0388e3337b6ed8a76cece43521b6827a7862184de9618e36c0f246dcbc3d95948eaa898de56dbe66c1dde44aa81a4654983dc8bb3266979ab6d9b25319f6bb97c0e24add4b8bdd5f0bcf383c056d754b67b0d46d292a4f5925fe7e1826c287af187923a334ea75f92cf75494b63eeed96dcdb9fa58dcecec26b30e359064e2f093b4b8ba9c5ac00e7e7d3062e9b55025140ce2e093e9d8d7d2b8e538b79084c0bf813e055d84b70bc53f9cbbe83182794c75573d0590cb31e45ba2bf07ae05780db80e7039f07ae023e1dff7e2186393b8bf5ad36c0d979cc526096803761e222601770cf783c315e731b7018b812b802f824f059e0db33b463d68c7bb1060bb162ce8410fa63fabefa0b32c5398e9895c09c8835892e8c9fcbb665dc0dfc783c9e1ecf7d1df86fe01398e87c1af82a26525b4e086120e920c5fd139786108ea75ff64b8197149c3f1842382e84d4592cb3129855e07726bcf7cc7864b59c9b806b245d8109ce55c0352184dba7b672424208ed3862d34a4ef74308fd2d31684e84105625ade1ce72ce8c9885c03c1378c30ce2c9381578783c7e0bb815b84ed255c0c781ff00ae0e21dc34c334c7f283f29245d1ec6fb119ce71c2b402f38bc03be2ffa2bc6934095913e944e07ef1d81bcf7d45d201e0352184afcf304dc77166c83402f348607f8c231397af027f0e5c0dfc0c56d57e0070f204f15789d53db1dacd9958a7b2e338db904905e6fec0e5c019f17300be09fc36f077f1dc5afc7b2fe0d1c0e380c7020f05ee3861ba1959ed6621a34fd1996e95cd7d30dd45a4bf28a2b35d978d3e2f03a03babceec58961decc7674f127424a6b506f426492fc6dd65e49bb48ed93e88e14bd8735cc9a57db069bab2e9136dacac8a9c310f01c318efda84f95902f6b1f17bb72f84b0965cd3c1ca331d8438843573f7851086f1ba7cd910ed5b9d515993a4b99e5ed8f4b8a7a48f4637f0a3894bf82b6ade7f0f491748da27e90a49df4de2389a8bb38a0f4a3aad69c14c82ca5de85717947e991bfe4c47da24f54a92e94d61633f86b72aca31cfbaa4ee04f6e7e78b49d27a0c5b964dafa8626d4cfc2d5919954d1da9a2ab31d32d0ad2db5712d7b26c0acbb8f25c4fe22acb7bbf69398f896f357f6193e30c49ef2988f4a8a403929e20e94e0de3bcbba47324bd5fd2cd630a2c139f2f49badb2405336161963dc8ee82d25f94c094e5b33f858d7dd94ceb495ecabe1abc9415f12cd74dbf24de2595bfec4d1834cc4fd9f35851b19816d18e7155896babae4d31aee58ab8bae9b54da60a9c06fc01f0b47c7af1ef79c0c73047ba83c0c5c0b9c08f8c89f7abc087807f066e1e736d006e019e1a42f85a6dcb9dad64199b3355369fab8ab31935b5a7a13f61fa193d8afd839ab287d98cd0f5d8d8c4ab435539d6992d9fd2a99b4e5d813909eb547d514158606387ec695807ef2b810f00d701ff06bc0e1b753ab3208ec702afc0be04e37e952fc43c819d9dc1342f36c0d9f95fc52db0213fd1741af66c517e7a15619d86719509d2e1bc43661d81d9858dd4fc710303c448284ec104e4e5c007816b317f96d7014fc204e372e0de8c17979703ff0a3c5bd2431ad8e36c4f0e6235de715cd4b41a3f2147f227347eb6fc112c1faf8ec701c6e7a9338971133204f348a7dcae3d75cb379647d924e65ed10de38e736ab6f5a6655c07efdb24ed967465bcee9b92f2cdb5b920ef83e94f63638e4debd8c83a4ff3ebdde4d957c386ba0c64fd422bb2be95ac7fa2db20de9e2ac447d2aaaafb7dc6ce4e57fd4ef1614c6f45f61cb2fe997e814d65d41ab050755f54abe886aae31192be1d6fae3bba330f3e25e954494f9574934662f4d13a85322d7281e94f6363424f159d9c2a1fc5929211918afbebd06b562a9bcaa5a7fabff6552f74b761ba65d4ee38960979693c35e328eb2c2ebcbfaa89746fe07d98eb3eccd64bb709d703cf8853037e1af3ec05388a4d1b707606fb43089d313e17ab14345322a72b8e884c6bc304f7ad6073e5ee1df330ac735308611fe5f999c53a428780765d3f9668f7c192e0b1cd24356d1e512e307702de5511d922b93084704dfcffae98cd0173b2fbc89659e534a1d68b1d5f94aaa6507b0a1b0e4d282e8410d64308fdbac292a3ac6630ed025e478095099ce47a1561e39a499d8ab0c251aa228139059b02f068b67ec984e76143df19eb58cd05ccce9f5bb8454e530e33fe8b9bd2ab086b4f68c3119a0fc56e776ad7a4724c335c5d167eb0cc96bcc09c842d77f9cbf1f356358bc046adde1542b80d40d25d8027306a229d888d4e39db9b61935fd9f8459d75b3a237e1cbb85d39944e1768427c16fb4b82cf5249e7f324cd23d8381769173697e805e3cd9c3bef03de1442f86e72ee9dc0431889decd5833ce39fe1850bcc05753e7b28cb92c0a16fb2cdad85ca1658a05701e6b194f9b9f35e05925611d8a6b9c9d31f115920acc2369e6eb326bb219d903e0a521841b8f05486fc41e645ae3ba1678cf220d7416c6b65d25308a4a3661723bf451362684b026e908c50e7b2b140b4c59f3e840550df584e4ef4b1b59395b3271b90153cae1b100e9d7805fc79a6f2957535e95767636db7279ce38b47c1d366d60478a4b42afe4fca666d298e65165532d139865e0f1597c2cbe73376bf63c071b7a3343a48761b5aa22a5fdd202ec729c6cb2e300b868ab6d9921bd8ab07c0da65372dd116a0acc53184d4a0cd848cdb5c047811b0bee9b15a990bd109bbb6401d2a9c0db817b94dcbb9d7722708e2fd698bcff675b3266ea40be3954d63c1abbce4dd60793769ede0efc0b363bfa56ccf7e489f1f3cfc6cfb32015973f65b4f466c6656cee203bca6872e52933b2c3d97e6c9b4dde64d31aca76bccc388489d03a9b9b77fbd8bee2b40fb8a4e0fce99256625fcdc4cd231809cc1d19f583dc8c4d3ebc35865d0fbc3b1ea7604da95f02ce01ee5b2f1fa58468e41b81ef25e7bbd8520fe930f95bb1ad4eb29efa7b4d99b6b37d291b8eae333172d6742bc20e61ce6ec3b20b54638ac316b246b1c080d55ad6a8681ed5192acf9a48bb9273a2bcf3f43bc087b1651b1e8439e3bd1a5b3ee1d6927bca08c067b0651aae4fceefc596863899512d27dbaf27b5ebc1d8d210cef147598d61b84823e28851d9aff761cc4d7fb83083664cb4fd5049f04aee6f9e5a7e3899c064fd19592de6ce35eebd159b0bd4c584e62158e7d087d9dc3f52d471fc0d4c48ae49ce3d18f8436caddfcc962b808b4308b760d5cf6c7fa40700bf51c34e676b69d59d8c07c7d6ba2da33fbd398d685584cd6c9de22da66c6ac6e971d4ac4c60c7ce6e8791c07c8e9100dc81f16dce3c4731a1b8146b3add077806b600f8f56c5e940a4c1c3e917c3e196b06dd9791b81c019e1b42b841d2895847f409317c37f0e486763a8be72caa472cf2742ac2163d7cddaa081b2ec88679535513291b35dbb4b0541999c0bc1fdb1520602ef87bb19ac44fd63432cf8d98e7ed5e4c6c7e01783356adfc2ee6d7f2dedc3d7f85ed3c002331fad510c2e7e2ff97038f622456df03fe6242fb168a6c0d8d746d90619de9fac711e7abdec2e16daa578febcfc89e5930b656163b48b74d877511b11676a0e16df5a729c8d67d3941b6a0539e5b255d25e9b5921e23e94435df85203d4e95f44305e75fa1d182dfd9ba332f937452b4f155dab8fb8024bd58d242e64a698af56054bd4e4aa766fac7cb7a3003952c09a0f10b73f76ad85046b76959c4f8da93da235bfca92a3ffd1ae94ffc3c9a106d6d426dd1cc4691842d45f9dc82f087c5e365c017b025123e80adb3db74fbd6a2eb2fc0fa6e4e62d434fa5be06d21845b243d25869f9c84bf13784b0861ab677bd7a1aa4fa143b3e6c32626fcb20d42080bd97225c71e60205b9d6e2d8490094e077bc6556bcdf6e66edd66aa9a01cf9234886bbe1c43a3bd97768c53de98a903796a378f6024302733bec37417a32d5c5f88ed0690894d9fc91cf21e08bc86916f4d3617e95521846f4a7a20f0678c3a9db3f01786109a8e5a6d15f3f68168da5f06b690767fd219b953723af6f25da4fa15b00371cfec85124258977490f232be44b6d464e603b38ccd999b7691f1ada06a02644aadcedd8cac0fe6026cb223582de13ae02dc0572aeebd7b34e8bdc017817fc45cfd7fb466da2761e291f6f3dc84f5cf0c25dd019b569ec6b70eec3d4e7aefb79a6ddd37907084c52e929da73b26fc2ccc85e222acff68278a0bd4178e463f4a99c09ccb6832e12dc05f03bf890d059f83ed377dcda6bb479c8639dfbd1d9b6270109b3cf9808a7b2e017e3e77eeb98cb624d90f3c3c17fe4ce0f315713adb8f323f8b3a1ca1c19290f320d69ccad64f396e18337520e35053bf9f4c60eeca6898fa36e0b3f1ffccb1eec5989fcbe381d7b3d11f25cf1db17d91de00fc17e64c7731e62b738778cd8b81e7c7ffb3745fc3481db35f8374798697011f09211c656751d5433f5c9411052ceaa55dc5dc179a9289cb96cfac8e4b6d4e2a32af9ea129f3a63765f86664a3381f4c7a886f92b457d5a341bb243d58d24b257d5cd2f76af63e5f2969bfa4c3f1733662f46ed9b6b4487abaa41b72e17fa305ed435d5246655b6a746adc5b3612b1aefaabd32fa9fe56a175284c5be52341dd1a3696ada0df4acaa16c45fa3cfbd4701fe79846d9739ac97299b2ad4eeae6a1af38da52724faf467a6565daa81fa441fe5aaa1ef96a358d33c83adade84ad6607f07de02f93cf75f831ac29751e567b19270659ad2500ff896dec760dd62ff0f798ef4c36627425706e08e1eb0dec9929b22f7b878dbe0ffdba1d8f1a8d9464ac63cb3836aa4568fa55f5338665555d9968b672d7f6ea445a70ef5abe06125ff6369bfb8086d860c1d819ba15e94ff59c1aa4b3c2a84337659d511e86c9f52d267cfed33c8fa6c4f2fb5649f081104273a196d51ace96f4ad44a9fe57d2433599afcb5d243d4dd2e592aeaf5043c9f65c7abc463e329fc885af4b7ad054a5e6384e2d54bd8f5367d248b326cf3fe522fc96a4b7487ab2a4d326149b53653b43be59d2b5dabc79db73926bdf5590a9f3665b848ee394a1eae6df640bae272ff8e36244f92d5c8f4afab2a4b74a3a770ab1d92de951922e91f43149cf927910676dffefe732f47bb2a16ac771e68ccc93ba8cc9fda51201d825e94515896462f33559a7eb79927e7842b1498f6748fa462e9d776852c59c03b1f007f1d817cff5651d971bc2e291b978f7e3e7b6acb9d78fc7b246eed94b31beac3378394977a8065b9dca84ba9bc4d5ca9def473b335b3af1fc30b32d5eafa27893b2588bf70c14abce497e37c49bc4d19755c1fbf1de2ccde5c4aebeeaed419d4d2b18445b9692b00d65a651c7ec2077be156dee3428df6162eb4a5a56b974d6f2e596c4915ddf8ab6676596c557f48c36954f7cc66b49582bb1e3d8b38fe7f669f41d2df47f52f5b6bd9377926bf3e8d0f9923e539158ca0d92de29eb73b9b39a8bcba324fd4f2ece7f97b4ad16934abf00b973eda2b018aee4ffb6366f44de8df9edc4cfd9036ec7cf9970d5eef0d46681e9a7e78b6c51c54b5010ef92ec8bdfaeca6f2e7f59bafd246f1bd24cc36ae6b39de4ada78de2b7a1cc72791f2636ac2a11839ae966e2b0a29c18e7d219441bab042615e74c305bf9fcc5cf1bca67cc73588b71af2671550ef527f11531953b437ee3b5db31bf8d4760fb405f8cf9bc94f9749f015c886d1ff2c5f8772ff5d693390373b6fb8924fe1bb1290b5fae9d83c53000ba252f415558ca527cd8e97587d8b8b04fea94d6c14624864502568383d85a2c75ee6d45dbc679f776b011927e5160963f8d6a14fb8155d51bde5c8ef7d6b9366589914f4f8792328bf12e31f23dea60deabe7abd97a35ed249d3cad281a4b54cc63ca6cc94683e248db1ad5f3d6d2f2e950f01c623ecec7f2d589a787d1ae6e453e5728f7409e6a3a49d9ded4b7039f047e1f139b87638e705731daba35cfe9c0d3b0cdd08698507580334baebf94d1ce8cd9ace8e7319de7e75c881303d78035e5aaf055613996b061cd7672ae8f7dc157e2ffe9afc50a568e4326dff67415fbb28d7b815a140f1de739f682caaae2036dac99b5e391a537c49cb3eaf86d64c3bead1ad782bd7059dabdf8b7accc3a58f9f64308c3f892ee89d71da659f9b6b1fc15d9d962548645e1e975c3dcb921d5cf292d9f542853b21fa975e266f671b8bc1d8f618980574d7ced55848da54c60526ec7bc712fc2d663d903bc12f814e6f55bc469984fcc6558cde643d88e91778be15dace693f2bbc03fd4377db18410bad8c37d4993b0846108a11baf255ebf86097137fe3fc07e6d96b12f51f6459a4860e264c621e3e7f2f4a36dbd31d70db2b8e2b51bbe9859fe723e365dea89572fdedb1f73dd315b4208ed10c24a9c945855663d36faad642f623be6a976f9c6e7b742f1c4c07ef2835315e70013c8545056a89ebd9d96cfb024fe4c6097496ac721844108a18d954327bd2111db220e4feb43b47bfc251bb81d9b46f0596ccac0fdb17daccfc76a39e9e66859b3e714e049f1e8628273bf5cbc6fc3e6316dcbe517623b7a8889c2a1ba61399692e6d180d12fdc1a26c46bf15c0b7b49d632318a6dfee509dde63bd8e4d52a5a996dd9172ab175985cd707d663cda147ee57bae89ef8f2af6279ac6239764fac4f98cf36056596b323eb836903fb4208bdf882d54e2fdebf4af1b3ce9a48d9b14c41d9465b7a403ffecdc2ab9a2369f9f4621fd21aa3e790c5b31c6b694320eb2bea60cfaecde6c99bad8a34a76a1e41738149398aedae783536efe83e98626633b3f33b3182cd79ca6f7b7210f823b6f72e8dd92fd2805175bf87bd484561b0710e4a765d3bf99cdd3f049e1dbf74fd18decac5b54abd8ddfb3fbb3f8895fb60b1835bf8e8525f7b413dbfad1f6f4733fc695752c2ec763c8a81653784fbcaf177fad87393b337a8c9a6943c6bff0f93c80e5afa8ccd2b4baf16fd6e791954f37694e5491e5b197c49b3de73ea3e6533bae75b34e71d91242588d02d8c6c42eb5339fbf1eb9f209212c2762398ce169ed31fbc11a32fa41eb1488f7007b07f34b52ec67fc4cf2f168fa61e6a2e32c492f90f42149df29e99d96ccbfe6a78ae2701c67e71316f032df0d5b93f7c9c063b0f55d7603ff87cd41fa70a1616121ab613a8e334fe65483293bee22e9b2587b795ed5b58ee3ec7c1651839908afc138cecea7ce30b5e338ce44b8c0388e33375c601cc7991b2e308ee3cc0d1718c771e6860b8ce33873c305c6719cb9e102e338cedc7081711c676eb8c0388e33375c601cc7991b2e308ee3cc0d1718c771e6860b8ce3387363db2ed7e038cecec76b308ee3cc0d1718c771e6860b8ce33873c305c6719cb9e102e338cedc7081711c676efc3f3b672a368b492c410000000049454e44ae426082, 'ilibrary@gmail.com', '12345678', null );