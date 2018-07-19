-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 27, 2018 lúc 06:01 PM
-- Phiên bản máy phục vụ: 10.1.28-MariaDB
-- Phiên bản PHP: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `student`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student_record`
--

CREATE TABLE `student_record` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `gender` varchar(1) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `student_record`
--

INSERT INTO `student_record` (`id`, `name`, `email`, `password`, `gender`, `address`) VALUES
(1, 'John', 'johnCamp@jcg.com', '12345', 'M', 'America'),
(2, 'Monica', 'monica@gmail.com', '12345', 'F', 'Iceland'),
(6, 'May', 'may2017@gmail.com', '12345', 'M', 'Finland'),
(10, 'tung tung', 'trntung@gmail.com', '1234566666', 'M', 'Viet Nam'),
(13, 'LongPhi', 'Ronglon@gmail.com', '12345', 'M', 'Quang Nam'),
(19, 'Ant', 'Ant@yahoo.com', 'iloveyou', 'F', 'NewYork'),
(20, 'trntung', 'tgr@gmaiil.com', 'iloveyou', 'M', 'Viet Nam'),
(22, 'TungTr', 'tungtt@st.ffse.edu.vn', '871721', 'M', 'Da Nang'),
(23, 'LongPhi', 'ronglon@gmail.com', '12345', 'M', 'Quang Nam'),
(24, 'Vuna', 'vuto@gmail.com', '1212121', 'M', 'Da Nang');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `student_record`
--
ALTER TABLE `student_record`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `student_record`
--
ALTER TABLE `student_record`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
