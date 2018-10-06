-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2018 at 08:07 AM
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
-- Database: `ffse1703`
--

-- --------------------------------------------------------

--
-- Table structure for table `danh_gia_ban_than`
--

CREATE TABLE `danh_gia_ban_than` (
  `id` int(11) NOT NULL,
  `ma_ky_danh_gia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ma_phong_ban` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nhan_vien` int(5) UNSIGNED ZEROFILL NOT NULL,
  `ky_luat_cong_viec_danh_gia` int(1) NOT NULL,
  `ky_luat_cong_viec_mo_ta` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tinh_than_lam_viec_danh_gia` int(1) NOT NULL,
  `tinh_than_lam_viec_mo_ta` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `khoi_luong_cong_viec_danh_gia` int(1) NOT NULL,
  `khoi_luong_cong_viec_mo_ta` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ket_qua_cong_viec_danh_gia` int(1) NOT NULL,
  `ket_qua_cong_viec_mo_ta` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ky_nang_tich_luy_danh_gia` int(1) NOT NULL,
  `ky_nang_tich_luy_mo_ta` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dinh_huong` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `danh_gia_tong_the` int(1) NOT NULL,
  `ma_trang_thai` int(1) NOT NULL,
  `is_delete` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `danh_gia_ban_than`
--

INSERT INTO `danh_gia_ban_than` (`id`, `ma_ky_danh_gia`, `ma_phong_ban`, `nhan_vien`, `ky_luat_cong_viec_danh_gia`, `ky_luat_cong_viec_mo_ta`, `tinh_than_lam_viec_danh_gia`, `tinh_than_lam_viec_mo_ta`, `khoi_luong_cong_viec_danh_gia`, `khoi_luong_cong_viec_mo_ta`, `ket_qua_cong_viec_danh_gia`, `ket_qua_cong_viec_mo_ta`, `ky_nang_tich_luy_danh_gia`, `ky_nang_tich_luy_mo_ta`, `dinh_huong`, `danh_gia_tong_the`, `ma_trang_thai`, `is_delete`) VALUES
(1, 'QI2018', 'PNS', 00015, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 3, 0),
(2, 'QI2018', 'PNS', 00026, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 3, 0),
(3, 'QI2018', 'PNS', 00042, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(4, 'QI2018', 'PNS', 00005, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(5, 'QI2018', 'PNS', 00013, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(6, 'QI2018', 'PNS', 00040, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(7, 'QI2018', 'PNS', 00053, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(8, 'QI2018', 'PNS', 00063, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(9, 'QI2018', 'PNS', 00067, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(10, 'QI2018', 'PNS', 00075, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 3, 0),
(11, 'QI2018', 'PNS', 00078, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(12, 'QI2018', 'PNS', 00080, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(13, 'QI2018', 'PNS', 00084, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(14, 'QI2018', 'PNS', 00091, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(15, 'QI2018', 'PNS', 00094, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(16, 'QI2018', 'PNS', 00095, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(17, 'QI2018', 'PNS', 00095, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(18, 'QI2018', 'PNS', 00097, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(19, 'QI2018', 'PNS', 00099, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0),
(20, 'QI2018', 'PNS', 00100, 4, 'Luôn chấp hành nghiêm ngặt', 5, 'Hăng say làm việc hết mình', 5, 'Nhận bao nhiêu làm bấy nhiêu', 5, 'Luôn hoàn thành tốt nhiệm vụ được giao', 5, 'Càng ngày càng thêm nhiều kinh nghiệm', 'Sẽ tiếp tục cố gắng thêm', 5, 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `danh_gia_nhan_vien`
--

CREATE TABLE `danh_gia_nhan_vien` (
  `id` int(11) NOT NULL,
  `ma_ky_danh_gia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ma_phong_ban` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nhan_vien_danh_gia` int(5) UNSIGNED ZEROFILL NOT NULL,
  `nhan_vien` int(5) UNSIGNED ZEROFILL NOT NULL,
  `ky_luat_cong_viec` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tinh_than_lam_viec` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `khoi_luong_cong_viec` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ket_qua_cong_viec` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ky_nang_tich_luy` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dinh_huong` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `xep_loai` int(1) NOT NULL,
  `is_delete` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `danh_gia_nhan_vien`
--

INSERT INTO `danh_gia_nhan_vien` (`id`, `ma_ky_danh_gia`, `ma_phong_ban`, `nhan_vien_danh_gia`, `nhan_vien`, `ky_luat_cong_viec`, `tinh_than_lam_viec`, `khoi_luong_cong_viec`, `ket_qua_cong_viec`, `ky_nang_tich_luy`, `dinh_huong`, `xep_loai`, `is_delete`) VALUES
(1, 'QI2018', 'PNS', 00015, 00026, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(2, 'QI2018', 'PNS', 00015, 00040, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(3, 'QI2018', 'PNS', 00015, 00053, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(4, 'QI2018', 'PNS', 00015, 00063, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(5, 'QI2018', 'PNS', 00015, 00067, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(6, 'QI2018', 'PNS', 00026, 00040, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(7, 'QI2018', 'PNS', 00026, 00053, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(8, 'QI2018', 'PNS', 00026, 00063, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(9, 'QI2018', 'PNS', 00026, 00067, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(10, 'QI2018', 'PNS', 00026, 00075, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(11, 'QI2018', 'PNS', 00005, 00013, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(12, 'QI2018', 'PNS', 00005, 00015, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(13, 'QI2018', 'PNS', 00005, 00026, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(14, 'QI2018', 'PNS', 00005, 00040, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(15, 'QI2018', 'PNS', 00005, 00053, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(16, 'QI2018', 'PNS', 00013, 00015, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(17, 'QI2018', 'PNS', 00013, 00026, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(18, 'QI2018', 'PNS', 00013, 00040, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(19, 'QI2018', 'PNS', 00013, 00053, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(20, 'QI2018', 'PNS', 00013, 00063, 'Cần nghiêm túc làm việc hơn', 'Có tinh thần tự giác cao', 'Đảm đương phần khó cho team', 'khá thành công tuy chưa trọn vẹn', 'kĩ năng càng ngày càng cao', 'Cần tiếp tục phát huy thêm', 5, 0),
(21, 'QII2018', 'PNS', 00015, 00026, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0),
(22, 'QII2018', 'PNS', 00015, 00040, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0),
(23, 'QII2018', 'PNS', 00015, 00053, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0),
(24, 'QII2018', 'PNS', 00015, 00063, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0),
(25, 'QII2018', 'PNS', 00015, 00067, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ky_danh_gia`
--

CREATE TABLE `ky_danh_gia` (
  `ma_ky_danh_gia` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ten_ky_danh_gia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `is_delete` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ky_danh_gia`
--

INSERT INTO `ky_danh_gia` (`ma_ky_danh_gia`, `ten_ky_danh_gia`, `is_delete`) VALUES
('QI2018', 'Quý I - 2018', 0),
('QI2019', 'Quý I - 2019', 0),
('QII2018', 'Quy II - 2018', 0),
('QII2019', 'Quý II - 2019', 0),
('QIII2018', 'Quý III - 2018', 0),
('QIII2019', 'Quý III - 2019', 0),
('QIV2018', 'Quý IV - 2018', 0);

-- --------------------------------------------------------

--
-- Table structure for table `lich_danh_gia`
--

CREATE TABLE `lich_danh_gia` (
  `id` int(11) NOT NULL,
  `ma_ky_danh_gia` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ma_phong_ban` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `is_active` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `lich_danh_gia`
--

INSERT INTO `lich_danh_gia` (`id`, `ma_ky_danh_gia`, `ma_phong_ban`, `is_active`) VALUES
(1, 'QI2018', 'PDA1', 0),
(2, 'QI2018', 'PDA2', 0),
(3, 'QI2018', 'PDA3', 0),
(4, 'QI2018', 'PGD', 1),
(5, 'QI2018', 'PNS', 2),
(6, 'QI2018', 'PIT', 0),
(7, 'QI2018', 'PKT', 0),
(8, 'QII2018', 'PNS', 1);

-- --------------------------------------------------------

--
-- Table structure for table `trang_thai_danh_gia`
--

CREATE TABLE `trang_thai_danh_gia` (
  `ma_trang_thai` int(11) NOT NULL,
  `ten_trang_thai` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `mo_ta` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `is_delete` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `trang_thai_danh_gia`
--

INSERT INTO `trang_thai_danh_gia` (`ma_trang_thai`, `ten_trang_thai`, `mo_ta`, `is_delete`) VALUES
(1, 'Nháp', 'Bản nháp', 0),
(2, 'Chờ duyệt', 'Chờ phê duyệt', 0),
(3, 'Đã duyệt', 'Đã được phê duyệt', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danh_gia_ban_than`
--
ALTER TABLE `danh_gia_ban_than`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `danh_gia_nhan_vien`
--
ALTER TABLE `danh_gia_nhan_vien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ky_danh_gia`
--
ALTER TABLE `ky_danh_gia`
  ADD PRIMARY KEY (`ma_ky_danh_gia`),
  ADD UNIQUE KEY `ma_ky_danh_gia` (`ma_ky_danh_gia`),
  ADD UNIQUE KEY `ma_ky_danh_gia_2` (`ma_ky_danh_gia`);

--
-- Indexes for table `lich_danh_gia`
--
ALTER TABLE `lich_danh_gia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trang_thai_danh_gia`
--
ALTER TABLE `trang_thai_danh_gia`
  ADD PRIMARY KEY (`ma_trang_thai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danh_gia_ban_than`
--
ALTER TABLE `danh_gia_ban_than`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `danh_gia_nhan_vien`
--
ALTER TABLE `danh_gia_nhan_vien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `lich_danh_gia`
--
ALTER TABLE `lich_danh_gia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `trang_thai_danh_gia`
--
ALTER TABLE `trang_thai_danh_gia`
  MODIFY `ma_trang_thai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
