-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2022 at 12:41 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbomysql`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `username` varchar(10) NOT NULL,
  `katasandi` varchar(100) NOT NULL,
  `role` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`username`, `katasandi`, `role`) VALUES
('135792468', 'sapadunia', 'Student'),
('222011647', 'helloworld', 'Student'),
('admin', 'adminmcu', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `mhs`
--

CREATE TABLE `mhs` (
  `nim` varchar(9) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jk` varchar(10) NOT NULL,
  `prodi` varchar(30) NOT NULL,
  `kelas` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mhs`
--

INSERT INTO `mhs` (`nim`, `nama`, `jk`, `prodi`, `kelas`) VALUES
('112011440', 'Mayrlan Rante Palalangan', 'Perempuan', 'D-III Statistika', '1D310'),
('123456789', 'Annisa Jasmine Raudhina', 'Perempuan', 'D-IV Komputasi Statistik', '2KS5'),
('135792468', 'User Dummy', 'Laki-laki', 'D-IV Statistika', '2ST10'),
('212011523', 'Norvan Bagus Ramadhan', 'Laki-laki', 'D-IV Statistika', '2ST7'),
('212011782', 'Andre Halim Prasetio ', 'Laki-laki', 'D-IV Statistika', '2ST1'),
('222011647', 'Alfian Rizky Al Majid', 'Laki-laki', 'D-IV Komputasi Statistik', '2KS5');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `mhs`
--
ALTER TABLE `mhs`
  ADD PRIMARY KEY (`nim`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
