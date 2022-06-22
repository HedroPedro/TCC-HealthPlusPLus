-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22-Jun-2022 às 19:49
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
  `COD_USUARIO` int(11) NOT NULL,
  `PRECO` float NOT NULL,
  `COD_CLIENTE` int(11) NOT NULL,
  PRIMARY KEY (`COD`),
  KEY `COD_CLIENTE` (`COD_CLIENTE`),
  KEY `COD_USUARIO` (`COD_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cliente`
--

CREATE TABLE IF NOT EXISTS `tb_cliente` (
  `COD_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `END_CLIENTE` varchar(70) NOT NULL,
  `TEL_CLIENTE` varchar(13) NOT NULL,
  `RG_CLIENTE` char(9) NOT NULL,
  `CPF_CLIENTE` char(11) NOT NULL,
  PRIMARY KEY (`COD_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`COD_CLIENTE`, `NOME`, `END_CLIENTE`, `TEL_CLIENTE`, `RG_CLIENTE`, `CPF_CLIENTE`) VALUES
(1, 'Pedro Henrique', 'Rua Carlos Andrômeda, nº 69', '5514997155472', '111111111', '222222222'),
(2, 'Zecão Pica de Mel', 'Rua Texeira Pica de Mel, n° 51', '551499789102', '123456789', '123426789'),
(3, 'rafael', 'rua asda', '11203812093', '123123123', '12312312312'),
(4, 'Rafael ', 'Rua POees', '1239890', '123123213', '12312312312'),
(5, 'Pedro', 'Rua Carla Da Xuxupana, n° 51', '99751481', '102345678', '12345678000');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuario`
--

CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `COD_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `SENHA` varchar(30) NOT NULL,
  PRIMARY KEY (`COD_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_usuario`
--

INSERT INTO `tb_usuario` (`COD_USUARIO`, `NOME`, `SENHA`) VALUES
(1, 'Nero', 'Carl'),
(2, 'Pedro', 'Carlos');

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_agendamento`
--
ALTER TABLE `tb_agendamento`
  ADD CONSTRAINT `tb_agendamento_ibfk_1` FOREIGN KEY (`COD_CLIENTE`) REFERENCES `tb_cliente` (`COD_CLIENTE`),
  ADD CONSTRAINT `tb_agendamento_ibfk_2` FOREIGN KEY (`COD_USUARIO`) REFERENCES `tb_usuario` (`COD_USUARIO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
