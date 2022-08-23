-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Ago-2022 às 19:37
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
CREATE DATABASE IF NOT EXISTS `empresa` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `empresa`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_agendamento`
--

DROP TABLE IF EXISTS `tb_agendamento`;
CREATE TABLE `tb_agendamento` (
  `COD` int(11) NOT NULL,
  `DATAHORA` datetime NOT NULL,
  `COD_CLIENTE` int(11) NOT NULL,
  `TIPO_CONSULTA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
CREATE TABLE `tb_cliente` (
  `COD_CLIENTE` int(11) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `END_CLIENTE` varchar(70) NOT NULL,
  `TEL_CLIENTE` varchar(13) NOT NULL,
  `CPF_CLIENTE` char(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_tiposdeconsulta`
--

DROP TABLE IF EXISTS `tb_tiposdeconsulta`;
CREATE TABLE `tb_tiposdeconsulta` (
  `COD` int(11) NOT NULL,
  `NomeConsulta` varchar(100) COLLATE utf8_general_ci NOT NULL,
  `Preco` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
CREATE TABLE `tb_usuario` (
  `COD_USUARIO` int(11) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `SENHA` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `tb_usuario`
--

INSERT INTO `tb_usuario` (`COD_USUARIO`, `NOME`, `SENHA`) VALUES
(1, 'Nero', 'Carl'),
(2, 'Pedro', 'Carlos');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_agendamento`
--
ALTER TABLE `tb_agendamento`
  ADD PRIMARY KEY (`COD`),
  ADD KEY `COD_CLIENTE` (`COD_CLIENTE`);

--
-- Índices para tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`COD_CLIENTE`);

--
-- Índices para tabela `tb_tiposdeconsulta`
--
ALTER TABLE `tb_tiposdeconsulta`
  ADD PRIMARY KEY (`COD`);

--
-- Índices para tabela `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`COD_USUARIO`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_agendamento`
--
ALTER TABLE `tb_agendamento`
  MODIFY `COD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `COD_CLIENTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tb_tiposdeconsulta`
--
ALTER TABLE `tb_tiposdeconsulta`
  MODIFY `COD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `COD_USUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
