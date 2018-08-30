-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2018 at 01:51 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ffse1703014`
--

-- --------------------------------------------------------

--
-- Table structure for table `sinhvien_spring`
--

CREATE TABLE `sinhvien_spring` (
  `id` int(11) NOT NULL,
  `MaSV` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSV` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `NamSinh` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `LopHoc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Avatar` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sinhvien_spring`
--

INSERT INTO `sinhvien_spring` (`id`, `MaSV`, `TenSV`, `NamSinh`, `Email`, `DiaChi`, `LopHoc`, `Avatar`) VALUES
(8, 'FFSE1703014', 'Võ Phi Tuấn', '1999', 'ffse1703014@st.fasttrack.edu.vn', 'Quảng Bình', 'FFSE1703', '02141927082018_715422.spgbdw13cif1.n3.jpg'),
(11, 'FFSE1703017', 'Võ Phi Tuấn', '1999', 'ffse1703015@fasttrack.edu.vn', 'Quảng Bình', 'FFSE1703', '02141127082018_763d605a521901578244e6f50e473de6.jpg'),
(16, 'FFSE1703015', 'Ngô Minh Tuấn', '1999', 'ffse1703015@fasttrack.edu.vn', 'Quảng Bình', 'FFSE1703', '02370921082018_729680_anime-romance-hd-wallpapers-and-backgrounds_1920x1080_h.jpg'),
(17, 'FFSE1703018', 'Ngô Minh Tuấn', '1999', 'ffse1703015@fasttrack.edu.vn', 'Quảng Bình', 'FFSE1703', '04113221082018_sky-wallpaper-blue-hdblue.jpg'),
(21, 'FFSE1703016', 'Võ Phi Tuấn', '1999', 'ffse1703014@st.fasttrack.edu.vn', 'Quảng Bình', 'FFSE1703', '04192021082018_wallpaper.wiki-Nature-wallpapers-nature-full-hd-1080p-1-PIC-WPE0014597.jpg'),
(22, 'FFSE1703020', 'Võ Phi Tuấn', '1999', 'vophituan.qb@icloud.com', 'Quảng Bình', 'FFSE1703', '04194121082018_p3HjAFU.jpg'),
(23, 'FFSE1703021', 'Võ Phi Tuấn', '1999', 'ffse1703015@fasttrack.edu.vn', 'Quảng Bình', 'FFSE1703', '04225921082018_sky-wallpaper-blue-hdblue.jpg'),
(24, 'FFSE1703013', 'Võ Phi Tuấn', '1999', 'ffse1703015@fasttrack.edu.vn', 'Quảng Bình', 'FFSE1703', '02123927082018_763d605a521901578244e6f50e473de6.jpg'),
(25, 'FFSE1703012', 'Võ Phi Tuấn', '1999', 'ffse1703015@fasttrack.edu.vn', 'Quảng Bình', 'FFSE1703', '02132127082018_763d605a521901578244e6f50e473de6.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sinhvien_spring`
--
ALTER TABLE `sinhvien_spring`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sinhvien_spring`
--
ALTER TABLE `sinhvien_spring`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
