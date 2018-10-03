-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 03, 2018 at 06:52 AM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ffse1703`
--

-- --------------------------------------------------------

--
-- Table structure for table `cong_viec`
--

CREATE TABLE IF NOT EXISTS `cong_viec` (
  `ID` int(11) NOT NULL,
  `ten_cong_viec` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ID_CV` int(11) NOT NULL,
  `mo_ta` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tg_bat_dau` date NOT NULL,
  `tg_ket_thuc` date NOT NULL,
  `ma_nhan_vien` int(5) unsigned zerofill NOT NULL,
  `tg_du_kien` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `ID_TT` int(11) NOT NULL,
  `ma_du_an` int(11) NOT NULL,
  `is_delete` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cong_viec`
--

INSERT INTO `cong_viec` (`ID`, `ten_cong_viec`, `ID_CV`, `mo_ta`, `tg_bat_dau`, `tg_ket_thuc`, `ma_nhan_vien`, `tg_du_kien`, `ID_TT`, `ma_du_an`, `is_delete`) VALUES
(1, 'Web Front-End', 1, 'Code Web', '2018-09-20', '2018-09-21', 00001, '4', 2, 1, 1),
(2, 'Web Back-End', 2, 'Code Web', '2018-09-13', '2018-09-14', 00002, '4', 1, 1, 0),
(3, 'PHP', 1, 'Quản lí Web', '2018-09-25', '2018-09-27', 00003, '4', 1, 1, 1),
(4, 'IoT', 3, 'test', '2018-09-21', '2018-09-27', 00004, '4', 1, 1, 1),
(5, 'JavaWeb', 4, 'test', '2018-09-21', '2018-09-28', 00001, '4', 1, 1, 1),
(6, 'JavaCore', 1, 'Code', '2018-09-21', '2018-09-28', 00005, '4', 1, 1, 1),
(7, 'JavaSpring', 2, 'test', '2018-10-09', '2018-10-11', 00003, '4', 1, 1, 1),
(8, 'JavaHibenate', 2, 'Code', '2018-10-19', '2018-10-23', 00003, '4', 1, 1, 1),
(9, 'SQL', 3, 'Code', '2018-10-12', '2018-10-17', 00006, '4', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `loai_cong_viec`
--

CREATE TABLE IF NOT EXISTS `loai_cong_viec` (
  `ID_CV` int(11) NOT NULL,
  `loai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `is_delete` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loai_cong_viec`
--

INSERT INTO `loai_cong_viec` (`ID_CV`, `loai`, `is_delete`) VALUES
(1, 'Code', 0),
(2, 'UT', 0),
(3, 'Fix bug', 0),
(4, 'Text', 0);

-- --------------------------------------------------------

--
-- Table structure for table `trang_thai`
--

CREATE TABLE IF NOT EXISTS `trang_thai` (
  `ID_TT` int(11) NOT NULL,
  `Trang_thai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `is_delete` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `trang_thai`
--

INSERT INTO `trang_thai` (`ID_TT`, `Trang_thai`, `is_delete`) VALUES
(1, 'Mới', 0),
(2, 'Đang làm', 0),
(3, 'Đã xong', 0),
(4, 'Hủy', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cong_viec`
--
ALTER TABLE `cong_viec`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `loai_cong_viec`
--
ALTER TABLE `loai_cong_viec`
  ADD PRIMARY KEY (`ID_CV`);

--
-- Indexes for table `trang_thai`
--
ALTER TABLE `trang_thai`
  ADD PRIMARY KEY (`ID_TT`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cong_viec`
--
ALTER TABLE `cong_viec`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `loai_cong_viec`
--
ALTER TABLE `loai_cong_viec`
  MODIFY `ID_CV` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `trang_thai`
--
ALTER TABLE `trang_thai`
  MODIFY `ID_TT` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
