-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th6 30, 2023 lúc 07:41 AM
-- Phiên bản máy phục vụ: 10.5.20-MariaDB
-- Phiên bản PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `id20969708_androidnetwordking`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `MyProduct`
--

CREATE TABLE `MyProduct` (
  `id` int(11) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `category` varchar(200) NOT NULL,
  `price` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `MyProduct`
--

INSERT INTO `MyProduct` (`id`, `fullname`, `category`, `price`) VALUES
(1, 'Doe hihi', 'do gia dung', 200),
(2, 'chuot', 'dientu', 120),
(4, 'chuot', 'dientu', 120),
(5, 'chuot22', 'dientu', 180);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `MyProduct`
--
ALTER TABLE `MyProduct`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `MyProduct`
--
ALTER TABLE `MyProduct`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
