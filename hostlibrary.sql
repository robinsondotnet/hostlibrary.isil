-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-12-2016 a las 03:37:44
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hostlibrary`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `id_autor` int(4) NOT NULL,
  `nombre` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(60) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`id_autor`, `nombre`, `apellido`) VALUES
(1, 'ANONIMO', 'AAVV');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleta`
--

CREATE TABLE `boleta` (
  `id_boleta` int(4) NOT NULL,
  `fecha` datetime NOT NULL,
  `dni_cliente` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `id_empleado` int(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `boleta`
--

INSERT INTO `boleta` (`id_boleta`, `fecha`, `dni_cliente`, `id_empleado`) VALUES
(1, '2016-01-29 00:00:00', '08417266', 2),
(2, '2016-01-28 00:00:00', '62766894', 3),
(3, '2016-01-20 00:00:00', '66874143', 4),
(4, '2016-02-19 00:00:00', '23498673', 5),
(5, '2016-02-18 00:00:00', '96816376', 6),
(6, '2016-02-16 00:00:00', '86547412', 9),
(7, '2016-03-15 00:00:00', '72460476', 10),
(8, '2016-03-20 00:00:00', '08206851', 11),
(9, '2016-04-12 00:00:00', '04821887', 12),
(10, '2016-12-13 00:00:00', '09176854', 16),
(11, '2016-05-28 00:00:00', '08243698', 17),
(12, '2016-06-11 00:00:00', '09185538', 17),
(13, '2016-06-20 00:00:00', '05729311', 18),
(14, '2016-06-01 00:00:00', '98989392', 20),
(15, '2016-07-15 00:00:00', '34234234', 22),
(16, '2016-07-24 00:00:00', '54353452', 22),
(17, '2016-08-24 00:00:00', '23543523', 23),
(18, '2016-08-25 00:00:00', '34654665', 24),
(19, '2016-09-29 00:00:00', '64573223', 27),
(20, '2016-10-20 00:00:00', '31231242', 27),
(21, '2016-10-16 00:00:00', '64565465', 27),
(22, '2016-10-18 00:00:00', '76857463', 27),
(23, '2016-10-17 00:00:00', '87685466', 28),
(24, '2016-10-15 00:00:00', '45334547', 28),
(25, '2016-10-10 00:00:00', '23343333', 28),
(26, '2016-11-13 00:00:00', '32543654', 29),
(27, '2016-11-15 00:00:00', '65765886', 29),
(28, '2016-11-27 00:00:00', '76989789', 30),
(29, '2016-11-29 00:00:00', '86765466', 30),
(30, '2016-12-13 00:00:00', '65765867', 30),
(31, '2016-12-04 17:10:12', '78567654', 2),
(32, '2016-12-04 17:20:31', '78567654', 2),
(33, '2016-12-04 17:23:11', '78567654', 0),
(34, '2016-12-04 17:28:11', '78567654', 3),
(35, '2016-12-04 17:34:49', '78567654', 2),
(36, '2016-12-04 17:36:13', '78567654', 14),
(37, '2016-12-04 17:40:54', '78567654', 14),
(38, '2016-12-04 17:48:16', '78567654', 14),
(39, '2016-12-04 17:56:38', '78567654', 14),
(40, '2016-12-04 19:17:06', '12345678', 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleta_detalle`
--

CREATE TABLE `boleta_detalle` (
  `id_boleta` int(4) NOT NULL,
  `id_tienda` int(4) NOT NULL,
  `id_libro` int(4) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_total` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `boleta_detalle`
--

INSERT INTO `boleta_detalle` (`id_boleta`, `id_tienda`, `id_libro`, `cantidad`, `precio_total`) VALUES
(1, 1, 4, 1, 60),
(2, 1, 8, 1, 55),
(3, 1, 19, 1, 40),
(4, 1, 27, 1, 45),
(5, 1, 2, 1, 60),
(6, 2, 7, 1, 55),
(7, 2, 36, 1, 34),
(8, 2, 47, 1, 60),
(9, 2, 75, 1, 40),
(10, 3, 65, 1, 32),
(11, 3, 44, 1, 30),
(12, 3, 32, 1, 45),
(13, 3, 31, 1, 32),
(14, 4, 23, 1, 25),
(15, 4, 27, 1, 45),
(16, 4, 28, 1, 23),
(17, 4, 45, 1, 60),
(18, 4, 49, 1, 60),
(19, 5, 59, 1, 25),
(20, 5, 50, 1, 60),
(21, 5, 55, 1, 23),
(22, 5, 36, 1, 34),
(23, 5, 28, 1, 23),
(24, 5, 38, 1, 60),
(25, 5, 73, 1, 20),
(26, 5, 63, 1, 45),
(27, 5, 48, 1, 55),
(28, 5, 33, 1, 30),
(29, 5, 22, 1, 70),
(30, 5, 63, 1, 45);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `id_cargo` int(4) NOT NULL,
  `nombre_cargo` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id_cargo`, `nombre_cargo`) VALUES
(1, 'Administrador'),
(2, 'Operador'),
(3, 'Vendedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` int(4) NOT NULL,
  `dni` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `fec_nacimiento` datetime NOT NULL,
  `id_cargo` int(4) NOT NULL,
  `id_tienda` int(4) NOT NULL,
  `remuneracion` double NOT NULL,
  `fec_inicio` datetime NOT NULL,
  `fec_cese` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `dni`, `nombre`, `apellido`, `direccion`, `fec_nacimiento`, `id_cargo`, `id_tienda`, `remuneracion`, `fec_inicio`, `fec_cese`) VALUES
(1, '04736155', 'Jose', 'Benites Silva', 'Los marveles Lote 7 ', '1964-01-19 00:00:00', 1, 1, 4000, '2000-02-28 00:00:00', '2020-02-28 00:00:00'),
(2, '08736155', 'Daniel', 'Jimenez Silva', 'Ms 8 Lote 7 Saumos', '1956-02-28 00:00:00', 2, 1, 3500, '2003-06-20 00:00:00', '2020-06-20 00:00:00'),
(3, '02736155', 'Alejandro', 'Garcia Vasquez', 'Agustin Gamarra 124', '2003-03-20 00:00:00', 2, 1, 3500, '2002-06-20 00:00:00', '2020-06-20 00:00:00'),
(4, '63625187', 'Pedro', 'Cordoba Paredes', 'Av la fontana 1726', '1987-06-20 00:00:00', 3, 1, 2000, '2007-06-20 00:00:00', '2016-06-20 00:00:00'),
(5, '03554877', 'Lucas', 'Dias Moreno', 'Calle Uno Oeste 050,  Urb Corpac', '2000-01-22 00:00:00', 3, 1, 2000, '2008-06-20 00:00:00', '2020-06-20 00:00:00'),
(6, '01654877', 'Santiago', 'Torres Navarro', 'Calle las palmeras 456', '1999-08-31 00:00:00', 3, 1, 2000, '2010-06-20 00:00:00', '2016-06-20 00:00:00'),
(7, '04564877', 'Simon', 'Romero Gutierrez', 'Av javier prado oeste 1234', '1989-09-12 00:00:00', 1, 2, 4000, '2014-06-20 00:00:00', '2016-06-20 00:00:00'),
(8, '03274877', 'Jorge', 'Hernandez Hernandez', 'Calle Morales 213', '1960-11-17 00:00:00', 2, 2, 3500, '2001-06-20 00:00:00', '2020-06-20 00:00:00'),
(9, '09643457', 'Giorgina', 'Alvarado Muñoz', 'Ms 9 Lote 12 Saumos', '1967-03-20 00:00:00', 2, 2, 3500, '2015-01-31 00:00:00', '2015-12-31 00:00:00'),
(10, '09434877', 'Ana Paula', 'Sanchez Salazar', 'Calle Las morongas Lote 1', '1975-02-01 00:00:00', 3, 2, 2000, '2015-11-11 00:00:00', '2020-12-31 00:00:00'),
(11, '07634877', 'Sofia', 'Morales Ortega', 'Ms D Lote 4 Res 1', '1997-02-02 00:00:00', 3, 2, 2000, '2000-02-28 00:00:00', '2020-02-28 00:00:00'),
(12, '02354877', 'Manuel', 'Santos Castillo', 'Calle Las Banderas 435', '1996-03-20 00:00:00', 3, 2, 2000, '2003-06-20 00:00:00', '2020-06-20 00:00:00'),
(13, '23654877', 'Carlos', 'Lozano Cano', 'Av. los proceres 4545', '1996-08-31 00:00:00', 1, 3, 4000, '2002-06-20 00:00:00', '2020-06-20 00:00:00'),
(14, '34524877', 'Marcello', 'Dias Peña', 'Av. Grau 876', '1968-08-19 00:00:00', 2, 3, 3500, '2007-06-20 00:00:00', '2016-06-20 00:00:00'),
(15, '57954877', 'Miguel', 'Cano Guerrero', 'Jiron Peña 2324', '1982-03-24 00:00:00', 2, 3, 3500, '2008-06-20 00:00:00', '2020-06-20 00:00:00'),
(16, '06432877', 'Cesar', 'Vega Santana', 'Jiron 1 de ocutubre 625', '1976-01-19 00:00:00', 3, 3, 2000, '2010-06-20 00:00:00', '2016-06-20 00:00:00'),
(17, '09954877', 'Yanella', 'Hidalgo Silva', 'Pasaje 1 de mayo 324', '1960-11-17 00:00:00', 3, 3, 2000, '2014-06-20 00:00:00', '2016-06-20 00:00:00'),
(18, '75334877', 'Gonzalo', 'Reyes Mora', 'Jiron Gracias 786', '1980-07-27 00:00:00', 3, 3, 2000, '2001-06-20 00:00:00', '2020-06-20 00:00:00'),
(19, '76554877', 'Rodrigo', 'Esteban Parra', 'Av. independencia 2432', '1960-11-17 00:00:00', 1, 4, 4000, '2015-01-31 00:00:00', '2015-12-31 00:00:00'),
(20, '76454877', 'Marco', 'Choquecota Cano', 'Calle aldana 875 lote D', '1960-11-17 00:00:00', 2, 4, 3500, '2015-11-11 00:00:00', '2020-12-31 00:00:00'),
(21, '37654877', 'Benji', 'Gallardo Rojas', 'Matamoros 9826', '1995-08-31 00:00:00', 2, 4, 3500, '2000-02-28 00:00:00', '2020-02-28 00:00:00'),
(22, '47676577', 'David', 'Crespo Pastor', 'Av Jesus Carranza 532', '1950-10-19 00:00:00', 3, 4, 2000, '2003-06-20 00:00:00', '2020-06-20 00:00:00'),
(23, '4676577', 'Paola', 'Roman Soto', 'Prol Iquitos 224', '1990-01-10 00:00:00', 3, 4, 2000, '2002-06-20 00:00:00', '2020-06-20 00:00:00'),
(24, '06654765', 'Sergio', 'Moya Arias', 'Ms 1 Jiron Cascabel', '1956-09-28 00:00:00', 3, 4, 2000, '2007-06-20 00:00:00', '2016-06-20 00:00:00'),
(25, '07623877', 'Gilber', 'Carrasco Santos', 'Calle 8 puntaroca 324', '1989-12-21 00:00:00', 1, 5, 4000, '2008-06-20 00:00:00', '2020-06-20 00:00:00'),
(26, '07214577', 'Cristopher', 'Roman Sotomayor', 'Av Canevaro 432', '1990-01-10 00:00:00', 2, 5, 3500, '2010-06-20 00:00:00', '2016-06-20 00:00:00'),
(27, '06654898', 'Sebastian', 'Chihuan Cordoba', 'Av Circunvalacion 343 Las viñas', '1979-11-22 00:00:00', 2, 5, 3500, '2014-06-20 00:00:00', '2016-06-20 00:00:00'),
(28, '09654821', 'Juan Manuel', 'Roman Benites', 'Jiron Chanca 231', '1978-12-30 00:00:00', 3, 5, 2000, '2001-06-20 00:00:00', '2020-06-20 00:00:00'),
(29, '04554823', 'Lucia', 'Arias Arias', 'Jiron Zepeda 8736', '1990-01-10 00:00:00', 3, 5, 2000, '2015-01-31 00:00:00', '2015-12-31 00:00:00'),
(30, '06454888', 'Guillermo', 'Vargas Saravia', 'Av Carlos Morales 431', '1973-06-28 00:00:00', 3, 5, 2000, '2015-11-11 00:00:00', '2020-12-31 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado_log`
--

CREATE TABLE `empleado_log` (
  `id_log` int(4) NOT NULL,
  `id_empleado` int(4) NOT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `contraseña` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleado_log`
--

INSERT INTO `empleado_log` (`id_log`, `id_empleado`, `email`, `contraseña`) VALUES
(1, 1, 'admin', 'admin'),
(2, 2, 'juan.sil@hotmail.com', '12345'),
(3, 3, 'Alejandro@hotmail.com', '12345'),
(4, 4, 'Pedro@hotmail.com', '12345'),
(5, 5, 'Lucas@hotmail.com', '12345'),
(6, 6, 'Santiago@hotmail.com', '12345'),
(7, 7, 'Simon@hotmail.com', '12345'),
(8, 8, 'Jorge.Jorge@hotmail.com', '12345'),
(9, 9, 'jGiorgina@hotmail.com', '12345'),
(10, 10, 'jAnaPaula@hotmail.com', '12345'),
(11, 11, 'Sofia.sil@hotmail.com', '12345'),
(12, 12, 'Manuel@hotmail.com', '12345'),
(13, 13, 'Carlos@hotmail.com', '12345'),
(14, 14, 'Marcello@hotmail.com', '12345'),
(15, 15, 'Miguel@hotmail.com', '12345'),
(16, 16, 'Cesar@hotmail.com', '12345'),
(17, 17, 'Yanella@hotmail.com', '12345'),
(18, 18, 'Gonzalo.sil@hotmail.com', '12345'),
(19, 19, 'Rodrigoil@hotmail.com', '12345'),
(20, 20, 'juMarco@hotmail.com', '12345'),
(21, 21, 'jBenji@hotmail.com', '12345'),
(22, 22, 'Davidl@hotmail.com', '12345'),
(23, 23, 'jPaolal@hotmail.com', '12345'),
(24, 24, 'Sergiol@hotmail.com', '12345'),
(25, 25, 'Gilber.S@hotmail.com', '12345'),
(26, 26, 'Cristopher.AS@hotmail.com', '12345'),
(27, 27, 'Sebastian.A@hotmail.com', '12345'),
(28, 28, 'juan.Manuel@hotmail.com', '12345'),
(29, 29, 'Lucia.20@hotmail.com', '12345'),
(30, 30, 'Guillermo@hotmail.com', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id_libro` int(4) NOT NULL,
  `titulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `genero` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `id_publicador` int(4) NOT NULL,
  `id_autor` int(4) NOT NULL,
  `precio` double NOT NULL,
  `fec_publicacion` datetime NOT NULL,
  `num_paginas` int(5) NOT NULL,
  `pais_publicacion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `stock` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id_libro`, `titulo`, `genero`, `id_publicador`, `id_autor`, `precio`, `fec_publicacion`, `num_paginas`, `pais_publicacion`, `stock`) VALUES
(1, '1000 PINTURAS DE LOS GRANDES MAESTROS', 'ARTE', 9, 1, 60, '2013-11-29 00:00:00', 120, 'España', 97),
(2, '1001 CAMIONES', 'AUTOS', 25, 1, 60, '2014-11-29 00:00:01', 124, 'España', 100),
(3, '1001 COCHES DEPORTIVOS', 'AUTOS', 25, 1, 60, '2013-11-29 00:00:02', 125, 'España', 100),
(4, '1001 COCHES LEGENDARIOS', 'AUTOS', 25, 1, 60, '2013-11-29 00:00:03', 124, 'España', 96),
(5, '1001 DINOSAURIOS', 'INFANTIL', 25, 1, 60, '2013-11-29 00:00:04', 122, 'España', 100),
(6, '1001 MARAVILLAS', 'INFANTIL', 25, 1, 60, '2013-11-29 00:00:05', 123, 'España', 100),
(7, '101 BELLOS CUENTOS', 'INFANTIL', 3, 1, 55, '2013-11-29 00:00:06', 123, 'España', 100),
(8, '101 BELLOS FABULAS', 'INFANTIL', 3, 1, 55, '2013-11-29 00:00:07', 123, 'España', 100),
(9, '365 CUENTOS PARA NIÑOS', 'INFANTIL', 18, 1, 60, '2013-11-29 00:00:08', 200, 'España', 100),
(10, '365 FABULAS SERVILIBRO', 'INFANTIL', 25, 1, 60, '2013-11-29 00:00:09', 260, 'España', 99),
(11, '365 MENUS', 'COCINA', 25, 1, 60, '2013-11-29 00:00:10', 380, 'España', 100),
(12, '365 PREGUNTAS Y RESPUESTAS', 'INFANTIL', 25, 1, 60, '2013-11-29 00:00:11', 124, 'España', 100),
(13, 'A DIBUJAR MANGAS', 'ARTE', 12, 1, 49, '2013-11-29 00:00:12', 122, 'Perú', 100),
(14, 'ALICIA EN EL PAIS DE LAS MARAVILLAS', 'INFANTIL', 9, 1, 23, '2013-11-29 00:00:13', 123, 'Perú', 100),
(15, 'ANA FRANK', 'GENERAL', 24, 1, 23, '2013-11-29 00:00:14', 123, 'España', 100),
(16, 'ANA KARENINA', 'GENERAL', 14, 1, 23, '2013-11-29 00:00:15', 123, 'Estados Unidos', 100),
(17, 'ANIMALES SALVAJES POP-UP', 'INFANTIL', 15, 1, 23, '2013-11-29 00:00:16', 200, 'Estados Unidos', 100),
(18, 'APRENDE A DECIR NO', 'GENERAL', 23, 1, 23, '2013-11-29 00:00:17', 260, 'Estados Unidos', 100),
(19, 'ARTE MANIA', 'ARTE', 9, 1, 40, '2013-11-29 00:00:18', 200, 'España', 100),
(20, 'BOLSOS', 'ARTE', 17, 1, 20, '2013-11-29 00:00:19', 124, 'España', 100),
(21, 'BUSCA Y ENCUENTRA DINOSAURIOS', 'INFANTIL', 11, 1, 25, '2013-11-29 00:00:21', 123, 'España', 100),
(22, 'CANCER: GUIA TOTAL DE SALUD', 'SALUD', 23, 1, 70, '2013-11-29 00:00:22', 123, 'Perú', 100),
(23, 'CHOCOLATES', 'COCINA', 12, 1, 25, '2013-11-29 00:00:23', 123, 'España', 100),
(24, 'COCINE CON HIERBAS AROMATICAS', 'INFANTIL', 23, 1, 25, '2013-11-29 00:00:24', 200, 'Estados Unidos', 100),
(25, 'COLECCION GRANDES EXITOS DISNEY', 'INFANTIL', 7, 1, 70, '2013-11-29 00:00:25', 260, 'Estados Unidos', 100),
(26, 'COLORES Y FORMAS(BUSCA Y ENCUENTRA LINTERNA)', 'INFANTIL', 11, 1, 45, '2013-11-29 00:00:26', 380, 'Estados Unidos', 100),
(27, 'COMBINA Y APRENDE', 'INFANTIL', 3, 1, 45, '2013-11-29 00:00:27', 200, 'España', 100),
(28, 'CONEJITO JUEGA AL FUTBOL', 'INFANTIL', 10, 1, 23, '2013-11-29 00:00:28', 124, 'España', 100),
(29, 'CONFIANZA EN UNO MISMO Y OTROS ENSAYOS', 'GENERAL', 14, 1, 23, '2013-11-29 00:00:29', 122, 'Canadá', 100),
(30, 'CUENTOS CON ESCALOFRIOS', 'INFANTIL', 15, 1, 32, '2013-11-29 00:00:30', 123, 'España', 100),
(31, 'CUENTOS CON PRINCESAS', 'INFANTIL', 15, 1, 32, '2013-11-29 00:00:31', 123, 'Perú', 100),
(32, 'DINOSAURIOS INCREIBLES POP-UP', 'INFANTIL', 15, 1, 45, '2013-11-29 00:00:32', 123, 'España', 100),
(33, 'DISEÑO MANIA', 'ARTE', 9, 1, 30, '2013-11-29 00:00:33', 200, 'Estados Unidos', 100),
(34, 'DIVERTIDOS CHISTES PARA NIÑOS', 'INFANTIL', 21, 1, 34, '2013-11-29 00:00:34', 260, 'Estados Unidos', 100),
(35, 'EL DIARIO DE ANA FRANK', 'INFANTIL', 24, 1, 22, '2013-11-29 00:00:35', 380, 'Estados Unidos', 100),
(36, 'EL DIARIO DE ANA FRANK Y CORAZON', 'INFANTIL', 24, 1, 34, '2013-11-29 00:00:36', 200, 'España', 100),
(37, 'EL ESPACIO', 'INFANTIL', 15, 1, 20, '2013-11-21 00:00:37', 124, 'España', 100),
(38, 'EL FANTASMA DE LA OPERA Y EL FANTASMA', 'INFANTIL', 24, 1, 60, '2013-11-29 00:00:38', 122, 'Canadá', 100),
(39, 'EL PORQUE DE LAS COSAS', 'GENERAL', 25, 1, 60, '2013-11-29 00:00:39', 123, 'España', 100),
(40, 'EL GRAN LIBRO DE LOS DINOSAURIOS', 'INFANTIL', 25, 1, 20, '2013-11-29 00:00:40', 123, 'Canadá', 100),
(41, 'EL PRINCIPITO Y PETER PAN ', 'INFANTIL', 24, 1, 20, '2013-11-29 00:00:41', 123, 'España', 100),
(42, 'EL REY QUE DESEBAA EL TIEMPO', 'INFANTIL', 5, 1, 60, '2013-11-29 00:00:42', 200, 'Perú', 100),
(43, 'ESTAR SANO DESPUES DE LOS 40', 'GENERAL', 1, 1, 60, '2013-11-29 00:00:43', 260, 'España', 100),
(44, 'FOTO MANIA', 'ARTE', 9, 1, 30, '2013-11-29 00:00:44', 380, 'Estados Unidos', 100),
(45, 'GIRA LA RUEDA ABC', 'INFANTIL', 11, 1, 60, '2013-11-29 00:00:45', 200, 'Estados Unidos', 100),
(46, 'GIRA LA RUEDA ANIMALES', 'INFANTIL', 11, 1, 60, '2013-11-29 00:00:46', 124, 'Estados Unidos', 100),
(47, 'GIRA LA RUEDA PALABRAS', 'INFANTIL', 11, 1, 60, '2013-11-29 00:00:47', 122, 'España', 100),
(48, 'GRAN LIBRO DE COCINA EN BAJA CALORIAS', 'COCINA', 25, 1, 55, '2013-11-29 00:00:48', 123, 'España', 100),
(49, 'GRAN LIBRO DE CUERPO HUMANO', 'INFANTIL', 25, 1, 60, '2013-11-29 00:00:49', 123, 'Canadá', 100),
(50, 'GRAN LIBRO DE GUITARRA', 'MUSICA', 25, 1, 60, '2013-11-29 00:00:50', 123, 'España', 100),
(51, 'GRAN LIBRO DE LA PASTA', 'COCINA', 25, 1, 60, '2013-11-29 00:00:51', 200, 'Canadá', 100),
(52, 'GUIA ESENCIAL DE PAPIROFLEXIA', 'GENERAL', 9, 1, 49, '2013-11-29 00:00:52', 260, 'España', 100),
(53, 'HISTORIA DE 5 MIN. CUENTOS', 'INFANTIL', 11, 1, 23, '2013-11-29 00:00:53', 380, 'Perú', 100),
(54, 'HISTORIAS DE PRINCESAS', 'INFANTIL', 20, 1, 23, '2013-11-29 00:00:54', 124, 'Estados Unidos', 100),
(55, 'INCAS MAYAS Y AZTECAS', 'INFANTIL', 9, 1, 23, '2013-11-29 00:00:55', 122, 'Estados Unidos', 100),
(56, 'LA CIENCIA DE HACERSE RICO', 'GENERAL', 4, 1, 40, '2013-11-29 00:00:56', 123, 'España', 100),
(57, 'LA ENCICLOPEDIA DE MOTOCICLETAS', 'INFANTIL', 9, 1, 20, '2013-11-29 00:00:57', 123, 'España', 100),
(58, 'LOS MISERABLES', 'GENERAL', 9, 1, 70, '2013-11-29 00:00:58', 260, 'España', 100),
(59, 'MANDALAS JAPON', 'GENERAL', 2, 1, 25, '2013-11-29 00:00:00', 100, 'España', 100),
(60, 'MANDALAS MAYAS', 'INFANTIL', 2, 1, 25, '2013-11-29 00:00:01', 100, 'España', 100),
(61, 'METODO DE DUKAN ILUSTRADO', 'GENERAL', 22, 1, 70, '2013-11-29 00:00:02', 124, 'Perú', 100),
(62, 'MI PRIMER LIBRO', 'INFANTIL', 16, 1, 45, '2013-11-29 00:00:03', 122, 'España', 100),
(63, 'MOBY DICK Y LOS VIAJES DE G.', 'INFANTIL', 24, 1, 45, '2013-11-29 00:00:04', 123, 'Estados Unidos', 100),
(64, 'MODA MANIA', 'ARTE', 9, 1, 23, '2013-11-29 00:00:05', 123, 'Estados Unidos', 100),
(65, 'MUJERCITAS', 'INFANTIL', 9, 1, 32, '2013-11-29 00:00:06', 200, 'España', 100),
(66, 'MUSICA MAESTRO', 'MUSICA', 9, 1, 32, '2013-11-29 00:00:07', 260, 'España', 100),
(67, 'OJOS OREJAS NARIZ Y COLA SAFARI POP-UP', 'INFANTIL', 17, 1, 30, '2013-11-29 00:00:08', 123, 'España', 100),
(68, 'ORGULLO Y PREJUICIO', 'GENERAL', 21, 1, 34, '2013-11-29 00:00:09', 120, 'Canadá', 100),
(69, 'PALABRAS Y NUMEROS (BUSCA Y ENCUENTRA LINTERNA)', 'INFANTIL', 11, 1, 34, '2013-11-29 00:00:10', 200, 'Perú', 100),
(70, 'PAPIROFLEXIA PARA TODOS', 'GENERAL', 9, 1, 20, '2013-11-29 00:00:11', 260, 'España', 100),
(71, 'PERRO EN CASA Y GATO EN CASA', 'INFANTIL', 8, 1, 60, '2013-11-29 00:00:12', 280, 'Estados Unidos', 100),
(72, 'PIENSE Y HAGASE RICO', 'GENERAL', 4, 1, 60, '2013-11-29 00:00:13', 60, 'Estados Unidos', 100),
(73, 'QUIERO A MI ROTTWEILER', 'INFANTIL', 6, 1, 20, '2013-11-29 00:00:14', 140, 'Estados Unidos', 100),
(74, 'SENTIDO Y SENSIBILIDAD', 'GENERAL', 9, 1, 18, '2013-11-29 00:00:15', 167, 'España', 100),
(75, 'STAR TREK', 'INFANTIL', 26, 1, 40, '2013-11-29 00:00:16', 289, 'España', 100),
(76, 'SUDOKU', 'GENERAL', 13, 1, 18, '2013-11-29 00:00:17', 138, 'Canadá', 100),
(77, 'THE CAT', 'INFANTIL', 8, 1, 25, '2013-11-29 00:00:18', 82, 'España', 100),
(78, 'WITCH', 'INFANTIL', 19, 1, 18, '2013-11-29 00:00:19', 189, 'Canadá', 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicador`
--

CREATE TABLE `publicador` (
  `id_publicador` int(4) NOT NULL,
  `ruc` char(11) COLLATE utf8_spanish_ci NOT NULL,
  `raz_social` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int(9) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `publicador`
--

INSERT INTO `publicador` (`id_publicador`, `ruc`, `raz_social`, `telefono`) VALUES
(1, '10028671933', 'AMAT', 3451563),
(2, '10028693112', 'ARTE', 5435435),
(3, '10028700046', 'ASTURIAS', 3235236),
(4, '10028712133', 'BIBLOK', 7657657),
(5, '10028712290', 'CLARET', 8768678),
(6, '10028721167', 'DE VECCHI', 3535434),
(7, '10028723658', 'DISNEY', 3453423),
(8, '10028728145', 'EDEBE', 2435434),
(9, '10028760103', 'EDIMAT', 3422222),
(10, '10028761126', 'ELFOS', 5435344),
(11, '10028766276', 'ESTUDIO DIDACTICO', 4364566),
(12, '10028801268', 'EUROMEXICO', 6546477),
(13, '10028825671', 'GAME', 7465666),
(14, '10028837033', 'GRUPO EDITORIAL', 5464563),
(15, '10028842517', 'LATINBOOKS', 3434534),
(16, '10028850668', 'LEXUS', 3242342),
(17, '10028863069', 'NAUMAN', 6765868),
(18, '10028872025', 'PARRAGON', 7879000),
(19, '10028881431', 'PLANETA JUNIOR', 7897800),
(20, '10028884881', 'PLAYBOOK', 6786700),
(21, '10028886620', 'PLUTON', 6786700),
(22, '10028893294', 'RBA', 6865756),
(23, '10028903141', 'ROBINBOOK', 2340800),
(24, '10028906850', 'SELECTOR', 2132144),
(25, '10028918041', 'SERVILIBRO', 2343333),
(26, '10028923665', 'VARIADO', 2342342);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

CREATE TABLE `tienda` (
  `id_tienda` int(4) NOT NULL,
  `ruc` char(11) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tienda`
--

INSERT INTO `tienda` (`id_tienda`, `ruc`, `nombre`, `direccion`) VALUES
(1, '10076333925', 'HostLibrary San Isidro', 'Av. Javier Prado Este 1054 - San isidro'),
(2, '10076333925', 'HostLibrary San Borja', 'Av. Las torres de limatambo 320 - San Borja'),
(3, '10076333925', 'HostLibrary Ate', 'Av. Eloy Ureta 200 - Ate'),
(4, '10076333925', 'HostLibrary La Molina', 'Av. La Molina 980 - La Molina'),
(5, '10076333925', 'HostLibrary Los Olivos', 'Av Los Alisos 356 - Los Olivos');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vw_ventasempleado`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vw_ventasempleado` (
`contador` bigint(21)
,`nombre` varchar(121)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vw_ventasempleado`
--
DROP TABLE IF EXISTS `vw_ventasempleado`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_ventasempleado`  AS  select count(`b`.`id_boleta`) AS `contador`,concat(`e`.`apellido`,' ',`e`.`nombre`) AS `nombre` from (`boleta` `b` join `empleado` `e` on((`b`.`id_empleado` = `e`.`id_empleado`))) group by `b`.`id_empleado` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`id_autor`);

--
-- Indices de la tabla `boleta`
--
ALTER TABLE `boleta`
  ADD PRIMARY KEY (`id_boleta`);

--
-- Indices de la tabla `boleta_detalle`
--
ALTER TABLE `boleta_detalle`
  ADD PRIMARY KEY (`id_boleta`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id_cargo`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `empleado_log`
--
ALTER TABLE `empleado_log`
  ADD PRIMARY KEY (`id_log`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id_libro`);

--
-- Indices de la tabla `publicador`
--
ALTER TABLE `publicador`
  ADD PRIMARY KEY (`id_publicador`);

--
-- Indices de la tabla `tienda`
--
ALTER TABLE `tienda`
  ADD PRIMARY KEY (`id_tienda`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `id_autor` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `boleta`
--
ALTER TABLE `boleta`
  MODIFY `id_boleta` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT de la tabla `boleta_detalle`
--
ALTER TABLE `boleta_detalle`
  MODIFY `id_boleta` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id_cargo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `empleado_log`
--
ALTER TABLE `empleado_log`
  MODIFY `id_log` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id_libro` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;
--
-- AUTO_INCREMENT de la tabla `publicador`
--
ALTER TABLE `publicador`
  MODIFY `id_publicador` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT de la tabla `tienda`
--
ALTER TABLE `tienda`
  MODIFY `id_tienda` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
