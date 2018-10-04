-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 02, 2018 lúc 07:42 PM
-- Phiên bản máy phục vụ: 10.1.35-MariaDB
-- Phiên bản PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ffse1703`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `don_nghi`
--

CREATE TABLE `don_nghi` (
  `id_don` int(11) NOT NULL,
  `id_nv` int(11) NOT NULL,
  `phong_ban` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `ten_nv` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ly_do` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `tg_bat_dau` date NOT NULL,
  `tg_ket_thuc` date NOT NULL,
  `ghi_chu` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tinh_trang` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `don_nghi`
--

INSERT INTO `don_nghi` (`id_don`, `id_nv`, `phong_ban`, `ten_nv`, `ly_do`, `tg_bat_dau`, `tg_ket_thuc`, `ghi_chu`, `tinh_trang`) VALUES
(44, 69, 'Phòng Đào tạo', 'Đăng Mỹ Phúc', 'Đau ốm', '2018-10-01', '2018-10-03', 'Xin đi chơi', 4),
(45, 15, 'Phòng Nhân sự', 'Lý Thành Chí', 'Khác', '2018-10-01', '2018-10-03', 'nghỉ mát', 2),
(46, 69, 'Phòng Đào tạo', 'Đăng Mỹ Phúc', 'Đau ốm', '2018-10-03', '2018-10-04', 'Đi nhậu', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `don_nghi`
--
ALTER TABLE `don_nghi`
  ADD PRIMARY KEY (`id_don`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `don_nghi`
--
ALTER TABLE `don_nghi`
  MODIFY `id_don` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
