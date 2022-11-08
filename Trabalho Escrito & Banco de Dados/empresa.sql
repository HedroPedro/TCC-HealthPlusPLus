-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 08-Nov-2022 às 18:39
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `empresa`
--
CREATE DATABASE IF NOT EXISTS `empresa` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `empresa`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_agendamento`
--

CREATE TABLE IF NOT EXISTS `tb_agendamento` (
  `COD` int(11) NOT NULL AUTO_INCREMENT,
  `DATAHORA` datetime NOT NULL,
  `NOME_CLIENTE` varchar(50) COLLATE utf8_bin NOT NULL,
  `COD_CLIENTE` int(11) NOT NULL,
  `TIPO_CONSULTA` int(11) NOT NULL,
  `PRECO` float(5,2) NOT NULL,
  PRIMARY KEY (`COD`),
  KEY `COD_CLIENTE` (`COD_CLIENTE`),
  KEY `TIPO_CONSULTA` (`TIPO_CONSULTA`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_agendamento`
--

INSERT INTO `tb_agendamento` (`COD`, `DATAHORA`, `NOME_CLIENTE`, `COD_CLIENTE`, `TIPO_CONSULTA`, `PRECO`) VALUES
(1, '2022-08-30 12:00:00', 'Carlos', 2, 0, 50.00),
(2, '2022-09-30 12:00:00', 'Carlos', 2, 0, 50.00),
(4, '2022-08-30 13:00:00', 'Pedro', 3, 0, 40.00),
(5, '2022-08-30 09:00:00', 'Carlos', 2, 0, 50.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cliente`
--

CREATE TABLE IF NOT EXISTS `tb_cliente` (
  `COD_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_CLIENTE` varchar(50) COLLATE utf8_bin NOT NULL,
  `END_CLIENTE` varchar(70) COLLATE utf8_bin NOT NULL,
  `TEL_CLIENTE` varchar(15) COLLATE utf8_bin NOT NULL,
  `CPF_CLIENTE` char(14) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`COD_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`COD_CLIENTE`, `NOME_CLIENTE`, `END_CLIENTE`, `TEL_CLIENTE`, `CPF_CLIENTE`) VALUES
(1, 'Antônio Aladin', 'Rua Dom Carlos, n°80', '(14) 9512-6156', '426.894.837-69'),
(2, 'Carlos', 'Rua Almeida', '(14) 9999-9999', '355.725.290-60'),
(3, 'Pedro', 'Rua 4, n° 66', '(14) 7777-7777', '389.748.611-35');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_tiposdeconsulta`
--

CREATE TABLE IF NOT EXISTS `tb_tiposdeconsulta` (
  `COD` int(11) NOT NULL AUTO_INCREMENT,
  `NOMECONSULTA` varchar(100) COLLATE utf8_bin NOT NULL,
  `PRECO` decimal(5,2) NOT NULL,
  PRIMARY KEY (`COD`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_tiposdeconsulta`
--

INSERT INTO `tb_tiposdeconsulta` (`COD`, `NOMECONSULTA`, `PRECO`) VALUES
(0, 'Genérica', '10.00'),
(1, 'Plano único', '150.00'),
(3, 'Plano Família', '75.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuario`
--

CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `COD_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `NIVELDEACESSO` int(11) NOT NULL DEFAULT 0,
  `NOME` varchar(50) COLLATE utf8_bin NOT NULL,
  `SENHA` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`COD_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_usuario`
--

INSERT INTO `tb_usuario` (`COD_USUARIO`, `NIVELDEACESSO`, `NOME`, `SENHA`) VALUES
(1, 1, 'Carlos', 'AaaAa'),
(2, 0, 'Pedro', 'JalILjzU'),
(3, 1, 'Cavalo', 'kx5EXV'),
(4, 1, 'Antônio Baptista', 'kXZx5EXV');

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_agendamento`
--
ALTER TABLE `tb_agendamento`
  ADD CONSTRAINT `tb_agendamento_ibfk_1` FOREIGN KEY (`COD_CLIENTE`) REFERENCES `tb_cliente` (`COD_CLIENTE`),
  ADD CONSTRAINT `tb_agendamento_ibfk_2` FOREIGN KEY (`TIPO_CONSULTA`) REFERENCES `tb_tiposdeconsulta` (`COD`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
