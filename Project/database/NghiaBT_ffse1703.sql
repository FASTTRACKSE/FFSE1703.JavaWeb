-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2018 at 12:28 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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

CREATE TABLE `cong_viec` (
  `ID` int(11) NOT NULL,
  `ten_cong_viec` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ID_CV` int(11) NOT NULL,
  `mo_ta` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tg_bat_dau` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tg_ket_thuc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ma_nhan_vien` int(11) UNSIGNED ZEROFILL NOT NULL,
  `tg_du_kien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ID_TT` int(11) NOT NULL,
  `ma_du_an` int(11) NOT NULL,
  `is_delete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cong_viec`
--

INSERT INTO `cong_viec` (`ID`, `ten_cong_viec`, `ID_CV`, `mo_ta`, `tg_bat_dau`, `tg_ket_thuc`, `ma_nhan_vien`, `tg_du_kien`, `ID_TT`, `ma_du_an`, `is_delete`) VALUES
(1, 'Code', 1, 'Code', '2018-09-08', '2018-09-14', 00000000001, '2', 1, 1, 0),
(2, 'Fix', 1, 'test', '2018-09-15', '2018-09-29', 00000000001, '3', 1, 1, 0),
(3, 'test', 1, 'fix bug', '2018-09-20', '2018-09-30', 00000000001, '2', 1, 1, 1),
(4, 'code', 4, 'code', '2018-09-08', '2018-09-29', 00000000012, '24', 1, 1, 0),
(5, 'adc', 3, 'test', '2018-09-14', '2018-09-29', 00000000017, '3', 1, 1, 0),
(6, 'zxc', 2, 'test', '2018-09-01', '2018-09-15', 00000000013, '3', 1, 1, 1),
(7, 'acc', 4, 'code', '2018-09-15', '2018-09-17', 00000000020, '2', 2, 1, 0),
(8, 'xyz', 2, 'code', '2018-09-07', '2018-09-21', 00000000006, '4 ', 1, 1, 0),
(9, 'app', 1, 'code', '2018-09-14', '2018-09-21', 00000000004, '24', 3, 1, 0),
(10, 'web', 1, 'fix', '2018-09-02', '2018-09-07', 00000000009, '2', 1, 1, 0),
(11, 'bigzzz', 1, 'test', '2018-09-05', '2018-09-07', 00000000005, '4', 1, 1, 1),
(12, 'mobile', 1, 'code', '2018-09-06', '2018-09-22', 00000000010, '23', 1, 1, 0),
(13, 'web', 1, 'code', '2018-09-16', '2018-09-07', 00000000001, '15', 2, 1, 0),
(14, 'user', 3, 'code', '2018-09-08', '2018-09-12', 00000000001, '3', 2, 1, 0),
(15, 'zzz', 3, 'test', '2018-09-06', '2018-09-22', 00000000014, '2', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `loai_cong_viec`
--

CREATE TABLE `loai_cong_viec` (
  `ID_CV` int(11) NOT NULL,
  `loai_cong_viec` varchar(255) NOT NULL,
  `is_delete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loai_cong_viec`
--

INSERT INTO `loai_cong_viec` (`ID_CV`, `loai_cong_viec`, `is_delete`) VALUES
(1, 'Code', 0),
(2, 'UT', 0),
(3, 'Fix Bug', 0),
(4, 'Text', 0);

-- --------------------------------------------------------

--
-- Table structure for table `loai_trang_thai`
--

CREATE TABLE `loai_trang_thai` (
  `ID_TT` int(11) NOT NULL,
  `loai_trang_thai` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loai_trang_thai`
--

INSERT INTO `loai_trang_thai` (`ID_TT`, `loai_trang_thai`) VALUES
(1, 'Mới'),
(2, 'Đang làm'),
(3, 'Đã xong'),
(4, 'Hủy');

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
-- Indexes for table `loai_trang_thai`
--
ALTER TABLE `loai_trang_thai`
  ADD PRIMARY KEY (`ID_TT`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cong_viec`
--
ALTER TABLE `cong_viec`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `loai_cong_viec`
--
ALTER TABLE `loai_cong_viec`
  MODIFY `ID_CV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `loai_trang_thai`
--
ALTER TABLE `loai_trang_thai`
  MODIFY `ID_TT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
