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
-- Cấu trúc bảng cho bảng `tinh_trang_nghi`
--

CREATE TABLE `tinh_trang_nghi` (
  `id_tinh_trang` int(10) NOT NULL,
  `id_nv` int(10) NOT NULL,
  `ngay_da_nghi` int(10) NOT NULL,
  `ngay_con_lai` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tinh_trang_nghi`
--

INSERT INTO `tinh_trang_nghi` (`id_tinh_trang`, `id_nv`, `ngay_da_nghi`, `ngay_con_lai`) VALUES
(5, 69, 5, 7),
(7, 15, 2, 10);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tinh_trang_nghi`
--
ALTER TABLE `tinh_trang_nghi`
  ADD PRIMARY KEY (`id_tinh_trang`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tinh_trang_nghi`
--
ALTER TABLE `tinh_trang_nghi`
  MODIFY `id_tinh_trang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
