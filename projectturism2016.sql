-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-05-2016 a las 07:44:43
-- Versión del servidor: 10.1.10-MariaDB
-- Versión de PHP: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `projectturism2016`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idCategoria` int(10) NOT NULL,
  `nombreCategoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`idCategoria`, `nombreCategoria`) VALUES
(1, 'Centro Comercial'),
(2, 'Hotel'),
(3, 'Restaurante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `idComentario` int(10) NOT NULL,
  `textComentario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contenidos_multimedia`
--

CREATE TABLE `contenidos_multimedia` (
  `idContenido` int(2) NOT NULL,
  `idSitiosc` int(2) NOT NULL,
  `correoCuentasc` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `correoCuenta` varchar(30) NOT NULL,
  `passwordCuenta` varchar(30) NOT NULL,
  `nombreCuenta` varchar(50) NOT NULL,
  `apellidoCuenta` varchar(50) NOT NULL,
  `celularCuenta` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`correoCuenta`, `passwordCuenta`, `nombreCuenta`, `apellidoCuenta`, `celularCuenta`) VALUES
('cristian.trujillov@gmail.com', 'tTovKl0fsLJjskSjo2u4mQ==', 'Cristian Alejandro', 'Trujillo Vargas', '3002434693'),
('root', 'gQMaNlhvdHg=', 'root', 'root', 'root');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagenes`
--

CREATE TABLE `imagenes` (
  `idImagen` int(10) NOT NULL,
  `nombreImagen` varchar(50) NOT NULL,
  `descripcionImagen` varchar(50) DEFAULT NULL,
  `fechaImagen` varchar(20) NOT NULL,
  `imagen` longblob NOT NULL,
  `idContenidoMultimediaI` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registros_visitas`
--

CREATE TABLE `registros_visitas` (
  `codigoVisita` int(10) NOT NULL,
  `fechaVisita` datetime NOT NULL,
  `idSitios` int(10) NOT NULL,
  `correoCuentas` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sitios_interes`
--

CREATE TABLE `sitios_interes` (
  `idSitio` int(10) NOT NULL,
  `nombreSitio` varchar(50) NOT NULL,
  `direccionSitio` varchar(50) NOT NULL,
  `calificacionSitio` int(2) NOT NULL,
  `reseñaSitio` varchar(50) NOT NULL,
  `horarioSitio` varchar(20) NOT NULL,
  `infoAdicionalSitio` varchar(50) DEFAULT NULL,
  `idCategoriaS` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sitios_interes`
--

INSERT INTO `sitios_interes` (`idSitio`, `nombreSitio`, `direccionSitio`, `calificacionSitio`, `reseñaSitio`, `horarioSitio`, `infoAdicionalSitio`, `idCategoriaS`) VALUES
(1, 'Prueba CC', 'Lunes a viernes', 2, 'Holi', 'Lunes a viernes', '', 1),
(2, 'Prueba Hotel', 'Lunes a Viernes', 2, 'Holi', 'Lunes a Viernes', 'Holi2', 2),
(3, 'Prueba Restaurante', 'Lunes a Viernes', 2, 'Holi', 'Lunes a Viernes', 'Holi3', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videos`
--

CREATE TABLE `videos` (
  `idVideos` int(10) NOT NULL,
  `nombreVideo` varchar(50) NOT NULL,
  `descripcionVideo` varchar(50) DEFAULT NULL,
  `fechaVideo` varchar(20) NOT NULL,
  `video` longblob NOT NULL,
  `idContenidoMultimediaV` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`idComentario`);

--
-- Indices de la tabla `contenidos_multimedia`
--
ALTER TABLE `contenidos_multimedia`
  ADD PRIMARY KEY (`idContenido`),
  ADD KEY `FKidSitiosc` (`idSitiosc`),
  ADD KEY `FKcorreoCuentasc` (`correoCuentasc`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`correoCuenta`);

--
-- Indices de la tabla `imagenes`
--
ALTER TABLE `imagenes`
  ADD PRIMARY KEY (`idImagen`),
  ADD KEY `idContenidoMultimediaI` (`idContenidoMultimediaI`);

--
-- Indices de la tabla `registros_visitas`
--
ALTER TABLE `registros_visitas`
  ADD PRIMARY KEY (`codigoVisita`),
  ADD KEY `FKSitios` (`idSitios`),
  ADD KEY `FKCuenta` (`correoCuentas`);

--
-- Indices de la tabla `sitios_interes`
--
ALTER TABLE `sitios_interes`
  ADD PRIMARY KEY (`idSitio`),
  ADD KEY `fkidCategoria` (`idCategoriaS`);

--
-- Indices de la tabla `videos`
--
ALTER TABLE `videos`
  ADD PRIMARY KEY (`idVideos`),
  ADD KEY `idContenidoMultimediaV` (`idContenidoMultimediaV`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idCategoria` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `contenidos_multimedia`
    MODIFY `idCategoria` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `idComentario` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `imagenes`
--
ALTER TABLE `imagenes`
  MODIFY `idImagen` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `registros_visitas`
--
ALTER TABLE `registros_visitas`
  MODIFY `codigoVisita` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sitios_interes`
--
ALTER TABLE `sitios_interes`
  MODIFY `idSitio` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `videos`
--
ALTER TABLE `videos`
  MODIFY `idVideos` int(10) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contenidos_multimedia`
--
ALTER TABLE `contenidos_multimedia`
  ADD CONSTRAINT `FKcorreoCuentasc` FOREIGN KEY (`correoCuentasc`) REFERENCES `cuentas` (`correoCuenta`),
  ADD CONSTRAINT `FKidSitiosc` FOREIGN KEY (`idSitiosc`) REFERENCES `sitios_interes` (`idSitio`);

--
-- Filtros para la tabla `imagenes`
--
ALTER TABLE `imagenes`
  ADD CONSTRAINT `FKimagenes` FOREIGN KEY (`idContenidoMultimediaI`) REFERENCES `contenidos_multimedia` (`idContenido`);

--
-- Filtros para la tabla `registros_visitas`
--
ALTER TABLE `registros_visitas`
  ADD CONSTRAINT `FKCuenta` FOREIGN KEY (`correoCuentas`) REFERENCES `cuentas` (`correoCuenta`),
  ADD CONSTRAINT `FKSitios` FOREIGN KEY (`idSitios`) REFERENCES `sitios_interes` (`idSitio`);

--
-- Filtros para la tabla `sitios_interes`
--
ALTER TABLE `sitios_interes`
  ADD CONSTRAINT `fkidCategoria` FOREIGN KEY (`idCategoriaS`) REFERENCES `categorias` (`idCategoria`);

--
-- Filtros para la tabla `videos`
--
ALTER TABLE `videos`
  ADD CONSTRAINT `FKVideos` FOREIGN KEY (`idContenidoMultimediaV`) REFERENCES `contenidos_multimedia` (`idContenido`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
