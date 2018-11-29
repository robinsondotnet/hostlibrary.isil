create database HostLibrary;
use HostLibrary;

-- Estructura de tabla para la tabla AUTOR
CREATE TABLE `autor` (
  `id_autor` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL
) 

-- Estructura de tabla para la tabla BOLETA
CREATE TABLE `boleta` (
  `id_boleta` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fecha` datetime NOT NULL,
  `dni_cliente` varchar(8) NOT NULL,
  `id_empleado` int(4) NOT NULL
) 

-- Estructura de tabla para la tabla `BOLETA DETALLE`
CREATE TABLE `boleta_detalle` (
  `id_boleta` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id_tienda` int(4) NOT NULL,
  `id_libro` int(4) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_total` double NOT NULL
) 

-- Estructura de tabla para la tabla `cargo`
CREATE TABLE `cargo` (
  `id_cargo` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre_cargo` varchar(50) NOT NULL
) 

-- Estructura de tabla para la tabla `empleado`
CREATE TABLE `empleado` (
  `id_empleado` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60)NOT NULL,
  `direccion` varchar(100)NOT NULL,
  `fec_nacimiento` datetime NOT NULL,
  `id_cargo` int(4) NOT NULL,
`id_tienda` int(4) NOT NULL,
  `remuneracion` double NOT NULL,
  `fec_inicio` datetime NOT NULL,
  `fec_cese` datetime NOT NULL,
  UNIQUE KEY `dni` (`dni`)
) 

-- Estructura de tabla para la tabla `empleado_log`
CREATE TABLE `empleado_log` (
  `id_log` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id_empleado` int(4) NOT NULL,
  `email` varchar(60) NOT NULL,
  `contrasena` varchar(50) NOT NULL
) 


-- Estructura de tabla para la tabla `libro`
CREATE TABLE `libro` (
  `id_libro` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `titulo` varchar(50) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `id_publicador` int(4) NOT NULL,
  `id_autor` int(4) NOT NULL,
  `precio` double NOT NULL,
  `fec_publicacion` datetime NOT NULL,
  `num_paginas` int(5) NOT NULL,
  `pais_publicacion` varchar(30) NOT NULL,
  `stock` int NULL
) 

-- Estructura de tabla para la tabla `publicador`
CREATE TABLE `publicador` (
  `id_publicador` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`ruc` char(11) NOT NULL,
  `raz_social` varchar(60) NOT NULL,
  `telefono` int(9) NOT NULL
)

-- Estructura de tabla para la tabla `tienda`
CREATE TABLE `tienda` (
  `id_tienda` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`ruc` char(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `direccion` varchar(100) NOT NULL
) 

-- --------------------------------------------------- --
ALTER TABLE boleta_detalle ADD FOREIGN KEY (id_tienda) REFERENCES tienda(id_tienda)
ALTER TABLE boleta_detalle ADD FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
ALTER TABLE boleta_detalle ADD FOREIGN KEY (id_boleta) REFERENCES boleta(id_boleta)
ALTER TABLE boleta ADD FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
ALTER TABLE empleado ADD FOREIGN KEY (id_cargo) REFERENCES cargo(id_cargo)
ALTER TABLE empleado ADD FOREIGN KEY (id_tienda) REFERENCES tienda(id_tienda)
ALTER TABLE empleado_log ADD FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
ALTER TABLE libro ADD FOREIGN KEY (id_publicador) REFERENCES publicador(id_publicador)
ALTER TABLE libro ADD FOREIGN KEY (id_autor) REFERENCES autor(id_autor)


create database HostLibrary;
use HostLibrary;

-- Estructura de tabla para la tabla AUTOR
CREATE TABLE `autor` (
  `id_autor` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL
) 

-- Estructura de tabla para la tabla BOLETA
CREATE TABLE `boleta` (
  `id_boleta` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fecha` datetime NOT NULL,
  `dni_cliente` varchar(8) NOT NULL,
  `id_empleado` int(4) NOT NULL
) 

-- Estructura de tabla para la tabla `BOLETA DETALLE`
CREATE TABLE `boleta_detalle` (
  `id_boleta` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id_tienda` int(4) NOT NULL,
  `id_libro` int(4) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_total` double NOT NULL
) 

-- Estructura de tabla para la tabla `cargo`
CREATE TABLE `cargo` (
  `id_cargo` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre_cargo` varchar(50) NOT NULL
) 

-- Estructura de tabla para la tabla `empleado`
CREATE TABLE `empleado` (
  `id_empleado` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60)NOT NULL,
  `direccion` varchar(100)NOT NULL,
  `fec_nacimiento` datetime NOT NULL,
  `id_cargo` int(4) NOT NULL,
`id_tienda` int(4) NOT NULL,
  `remuneracion` double NOT NULL,
  `fec_inicio` datetime NOT NULL,
  `fec_cese` datetime NOT NULL,
  UNIQUE KEY `dni` (`dni`)
) 

-- Estructura de tabla para la tabla `empleado_log`
CREATE TABLE `empleado_log` (
  `id_log` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`id_empleado` int(4) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `contraseÃ±a` varchar(50) NOT NULL,
   UNIQUE KEY `dni` (`dni`)
) 

-- Estructura de tabla para la tabla `libro`
CREATE TABLE `libro` (
  `id_libro` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `titulo` varchar(50) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `id_publicador` int(4) NOT NULL,
  `id_autor` int(4) NOT NULL,
  `precio` double NOT NULL,
  `fec_publicacion` datetime NOT NULL,
  `num_paginas` int(5) NOT NULL,
  `pais_publicacion` varchar(30) NOT NULL,
  `stock` int NULL
) 

-- Estructura de tabla para la tabla `publicador`
CREATE TABLE `publicador` (
  `id_publicador` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`ruc` char(11) NOT NULL,
  `raz_social` varchar(60) NOT NULL,
  `telefono` int(9) NOT NULL
)

-- Estructura de tabla para la tabla `tienda`
CREATE TABLE `tienda` (
  `id_tienda` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`ruc` char(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `direccion` varchar(100) NOT NULL
) 

-- --------------------------------------------------- --
ALTER TABLE boleta_detalle ADD FOREIGN KEY (id_tienda) REFERENCES tienda(id_tienda)
ALTER TABLE boleta_detalle ADD FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
ALTER TABLE boleta_detalle ADD FOREIGN KEY (id_boleta) REFERENCES boleta(id_boleta)
ALTER TABLE boleta ADD FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
ALTER TABLE empleado ADD FOREIGN KEY (id_cargo) REFERENCES cargo(id_cargo)
ALTER TABLE empleado ADD FOREIGN KEY (id_tienda) REFERENCES tienda(id_tienda)
ALTER TABLE empleado_log ADD FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
ALTER TABLE libro ADD FOREIGN KEY (id_publicador) REFERENCES publicador(id_publicador)
ALTER TABLE libro ADD FOREIGN KEY (id_autor) REFERENCES autor(id_autor)
