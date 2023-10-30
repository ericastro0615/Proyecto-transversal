-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2023 a las 03:32:29
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
-- Base de datos: `basededatos_g15`
--

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
(10, 398456005, 'Gutierrez', 'Maria Ana', '1997-01-18', 1),
(12, 35975144, 'Gomez', 'Maria', '1991-07-18', 1),
(13, 121418, 'Sosa', 'Juan Carlos', '1988-08-09', 1),
(16, 35916754, 'Benites', 'Gabriel', '1988-02-20', 1),
(17, 141718, ' Rivera', ' Ariel', '2001-12-11', 0),
(18, 1561162, 'Susana', 'Gimenez', '1999-10-06', 1);

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
(22, 10, 10, 5),
(23, 8, 10, 7),
(24, 10, 10, 3);

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
(3, 'matematica computacional', 2, 1),
(4, 'laboratorio 1', 1, 1),
(5, 'ingles computacional', 1, 1),
(7, 'analisis computacional', 3, 1),
(9, 'mat', 4, 1);

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
  ADD UNIQUE KEY `idAlumno_2` (`idAlumno`,`idMateria`),
  ADD KEY `idAlumno` (`idAlumno`),
  ADD KEY `idMateria` (`idMateria`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `inscripción`
--
ALTER TABLE `inscripción`
  MODIFY `idInscripto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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
