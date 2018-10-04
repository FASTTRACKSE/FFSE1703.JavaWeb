-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 03, 2018 lúc 11:04 AM
-- Phiên bản máy phục vụ: 10.1.28-MariaDB
-- Phiên bản PHP: 7.1.11

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
-- Cấu trúc bảng cho bảng `loai_cong_viec`
--

CREATE TABLE `loai_cong_viec` (
  `ID_loai_cong_viec` int(11) NOT NULL,
  `loai_cong_viec` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `loai_cong_viec`
--

INSERT INTO `loai_cong_viec` (`ID_loai_cong_viec`, `loai_cong_viec`) VALUES
(1, 'Code'),
(2, 'UT'),
(3, 'Fix bug'),
(4, 'Test');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai_trang_thai`
--

CREATE TABLE `loai_trang_thai` (
  `ID_loai_trang_thai` int(11) NOT NULL,
  `loai_trang_thai` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `loai_trang_thai`
--

INSERT INTO `loai_trang_thai` (`ID_loai_trang_thai`, `loai_trang_thai`) VALUES
(1, 'Mới'),
(2, 'Đang làm'),
(3, 'Đã xong'),
(4, 'Hủy');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quan_ly_nhiem_vu`
--

CREATE TABLE `quan_ly_nhiem_vu` (
  `ID` int(11) NOT NULL,
  `ma_du_an` int(11) NOT NULL,
  `ID_loai_cong_viec` int(11) UNSIGNED ZEROFILL NOT NULL,
  `ten_cong_viec` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mo_ta` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tg_bat_dau` date NOT NULL,
  `tg_ket_thuc` date NOT NULL,
  `ma_nhan_vien` int(5) UNSIGNED ZEROFILL NOT NULL,
  `tg_du_kien_hoan_thanh` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ID_loai_trang_thai` int(11) UNSIGNED ZEROFILL NOT NULL,
  `is_delete` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `quan_ly_nhiem_vu`
--

INSERT INTO `quan_ly_nhiem_vu` (`ID`, `ma_du_an`, `ID_loai_cong_viec`, `ten_cong_viec`, `mo_ta`, `tg_bat_dau`, `tg_ket_thuc`, `ma_nhan_vien`, `tg_du_kien_hoan_thanh`, `ID_loai_trang_thai`, `is_delete`) VALUES
(1, 1, 00000000004, 'Làm crud', 'Hiếu', '2018-10-11', '2018-10-11', 00001, '3', 00000000004, 1),
(2, 1, 00000000002, 'Làm mới', 'Wed', '2018-10-14', '2018-10-14', 00002, '2h', 00000000002, 1),
(3, 1, 00000000003, 'Sửa code', 'Làm bài', '2018-10-09', '2018-10-09', 00003, '3h', 00000000003, 1),
(4, 1, 00000000004, 'Code', 'php', '2018-10-15', '2018-10-15', 00004, '3h', 00000000004, 1),
(5, 1, 00000000004, 'Làm xóa', 'wed', '2018-10-15', '2018-10-17', 00005, '6h', 00000000004, 1),
(6, 1, 00000000003, 'Thiết kế database', 'wed', '2018-10-01', '2018-10-01', 00006, '2h', 00000000003, 1),
(7, 1, 00000000002, 'Prototype', 'creat', '2018-10-09', '2018-09-09', 00009, '1h', 00000000002, 1),
(8, 1, 00000000002, 'Làm wed', 'update', '2018-10-10', '2018-10-10', 00010, '6h', 00000000001, 1),
(9, 1, 00000000003, 'Commit', 'delete', '2018-09-15', '2018-09-15', 00008, '2h', 00000000003, 1),
(10, 1, 00000000001, 'Update', 'crud', '2018-10-09', '2018-10-09', 00007, '5h', 00000000002, 1),
(11, 1, 00000000001, 'ValueCation', 'Làm value', '2018-10-03', '2018-10-03', 00015, '4', 00000000001, 1),
(12, 1, 00000000003, 'Maxpin', 'Max', '2018-10-04', '2018-10-04', 00012, '4', 00000000001, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `ma_tai_khoan` int(11) NOT NULL,
  `username` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_nhan_vien` int(11) NOT NULL,
  `enabled` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`ma_tai_khoan`, `username`, `password`, `ma_nhan_vien`, `enabled`) VALUES
(1, 'giamdoc', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 1, 1),
(2, 'truongphongduan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 7, 1),
(3, 'truongphongdaotao', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 56, 1),
(4, 'truongphongit', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 16, 1),
(5, 'truongphongketoan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 57, 1),
(6, 'truongphongnhansu', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 42, 1),
(7, 'phophongduan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 101, 1),
(8, 'phophongdaotao', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 35, 1),
(9, 'phophongit', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 28, 1),
(10, 'phophongketoan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 86, 1),
(11, 'phophongnhansu', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 124, 1),
(12, 'phogiamdoc', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 60, 1),
(13, 'nhanvienphongduan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 66, 1),
(14, 'nhanvienphongdaotao', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 69, 1),
(15, 'nhanvienphongit', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 65, 1),
(16, 'nhanvienphongketoan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 74, 1),
(17, 'nhanvienphongnhansu', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 15, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users_roles`
--

CREATE TABLE `users_roles` (
  `ma_tai_khoan` int(11) NOT NULL DEFAULT '0',
  `ma_role` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users_roles`
--

INSERT INTO `users_roles` (`ma_tai_khoan`, `ma_role`) VALUES
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6),
(6, 1),
(6, 7),
(7, 3),
(8, 4),
(9, 5),
(10, 6),
(11, 1),
(11, 7),
(12, 2),
(13, 8),
(14, 8),
(15, 8),
(16, 8),
(17, 1),
(17, 8);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `loai_cong_viec`
--
ALTER TABLE `loai_cong_viec`
  ADD PRIMARY KEY (`ID_loai_cong_viec`);

--
-- Chỉ mục cho bảng `loai_trang_thai`
--
ALTER TABLE `loai_trang_thai`
  ADD PRIMARY KEY (`ID_loai_trang_thai`);

--
-- Chỉ mục cho bảng `quan_ly_nhiem_vu`
--
ALTER TABLE `quan_ly_nhiem_vu`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ma_tai_khoan`),
  ADD UNIQUE KEY `ma_nhan_vien` (`ma_nhan_vien`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `loai_cong_viec`
--
ALTER TABLE `loai_cong_viec`
  MODIFY `ID_loai_cong_viec` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `loai_trang_thai`
--
ALTER TABLE `loai_trang_thai`
  MODIFY `ID_loai_trang_thai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `quan_ly_nhiem_vu`
--
ALTER TABLE `quan_ly_nhiem_vu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `ma_tai_khoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
