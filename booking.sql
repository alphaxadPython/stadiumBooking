-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2021 at 01:49 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `booking`
--

-- --------------------------------------------------------

--
-- Table structure for table `eventbook`
--

CREATE TABLE `eventbook` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `event` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `phone` varchar(100) NOT NULL,
  `seat` varchar(11) NOT NULL,
  `receipt` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `eventbook`
--

INSERT INTO `eventbook` (`id`, `username`, `event`, `date`, `phone`, `seat`, `receipt`) VALUES
(1, 'alex jozee', NULL, NULL, '12345678', '23', 'BTXCV44324'),
(2, 'juma', NULL, NULL, '987654321', '45', 'BNH76767676'),
(3, 'demoo', NULL, NULL, '3213232', '34', 'gthtg4324');

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `seats` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `accNo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `name`, `location`, `date`, `seats`, `price`, `accNo`) VALUES
(5, 'Diamond Party', 'uwanja wa mkapa', '2021-07-16', 12345678, 3000, '12300GHFV');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`id`, `username`, `password`, `phone`) VALUES
(1, 'admin', '123', '1234556789');

-- --------------------------------------------------------

--
-- Table structure for table `stadvenu`
--

CREATE TABLE `stadvenu` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL,
  `seats` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `cartegory` varchar(100) NOT NULL,
  `accNo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stadvenu`
--

INSERT INTO `stadvenu` (`id`, `name`, `location`, `seats`, `price`, `capacity`, `cartegory`, `accNo`) VALUES
(1, 'kapa', 'dar', 12333, 5000, 1223, 'Stadium', 'ASD54345');

-- --------------------------------------------------------

--
-- Table structure for table `stadvenubook`
--

CREATE TABLE `stadvenubook` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `stadVenu` varchar(100) DEFAULT NULL,
  `phone` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `receipt` varchar(100) NOT NULL,
  `satatus` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stadvenubook`
--

INSERT INTO `stadvenubook` (`id`, `username`, `stadVenu`, `phone`, `date`, `receipt`, `satatus`) VALUES
(1, 'alpha', NULL, '123456', '2021-07-06', 'BVG123456', NULL),
(2, 'james', NULL, '1234555666', '2021-07-02', 'ssdssd3434', NULL),
(3, 'sdasd', NULL, '3213213', '2021-07-21', '123ererqer', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `eventbook`
--
ALTER TABLE `eventbook`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `signup`
--
ALTER TABLE `signup`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stadvenu`
--
ALTER TABLE `stadvenu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stadvenubook`
--
ALTER TABLE `stadvenubook`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `eventbook`
--
ALTER TABLE `eventbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `signup`
--
ALTER TABLE `signup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `stadvenu`
--
ALTER TABLE `stadvenu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `stadvenubook`
--
ALTER TABLE `stadvenubook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
