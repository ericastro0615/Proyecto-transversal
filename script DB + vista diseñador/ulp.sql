-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-10-2023 a las 03:55:52
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ulp`
--
CREATE DATABASE IF NOT EXISTS `ulp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ulp`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) VALUES
(1, 3581575, 'Gonzales', 'Juana', '2001-04-30', 1),
(6, 34785426, 'Marin', 'Juan Ignacio', '2002-01-30', 1),
(7, 3985427, 'Suarez', 'Maria', '2001-03-11', 1),
(8, 31245125, 'Gomez', 'Patricio', '1992-04-08', 1),
(14, 357452825, 'Gutierrez', 'Maria Agustina', '1998-07-18', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripción`
--

CREATE TABLE `inscripción` (
  `idInscripto` int(11) NOT NULL,
  `nota` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripción`
--

INSERT INTO `inscripción` (`idInscripto`, `nota`, `idAlumno`, `idMateria`) VALUES
(19, 8, 1, 4),
(20, 9, 1, 3),
(21, 10, 6, 3),
(23, 9, 7, 2),
(24, 6, 7, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `anio` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `nombre`, `anio`, `estado`) VALUES
(1, 'Programación 1', 1, 1),
(2, 'Ingles Técnico', 2, 1),
(3, 'Matemática', 1, 1),
(4, 'Practicas profesionales', 3, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `inscripción`
--
ALTER TABLE `inscripción`
  ADD PRIMARY KEY (`idInscripto`),
  ADD UNIQUE KEY `idAlumno` (`idAlumno`,`idMateria`),
  ADD KEY `idMateria` (`idMateria`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `inscripción`
--
ALTER TABLE `inscripción`
  MODIFY `idInscripto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripción`
--
ALTER TABLE `inscripción`
  ADD CONSTRAINT `inscripción_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`),
  ADD CONSTRAINT `inscripción_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
