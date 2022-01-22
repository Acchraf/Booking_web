-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 22 jan. 2022 à 22:26
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `booking_web`
--

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `roomId` int(11) NOT NULL,
  `beginDate` date NOT NULL,
  `endDate` date NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `userId`, `roomId`, `beginDate`, `endDate`, `price`) VALUES
(1, 2, 1, '2022-01-01', '2022-01-03', 125),
(2, 2, 2, '2022-01-18', '2022-01-20', 711),
(3, 4, 2, '2022-01-25', '2022-01-31', 2133),
(4, 6, 2, '2022-01-12', '2022-01-25', 4621.5);

-- --------------------------------------------------------

--
-- Structure de la table `room`
--

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `photo` varchar(4000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `room`
--

INSERT INTO `room` (`id`, `number`, `type`, `price`, `photo`) VALUES
(1, 100, 'Single', 250, 'http://localhost:8080/booking/front/img/rooms/p0.jpg'),
(2, 101, 'Double', 355.5, 'http://localhost:8080/booking/front/img/rooms/p1.jpg'),
(3, 102, 'Triple', 750.9, 'http://localhost:8080/booking/front/img/rooms/p2.jpg'),
(4, 103, 'Quad', 1000.5, 'http://localhost:8080/booking/front/img/rooms/p3.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `state` tinyint(1) NOT NULL,
  `role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `firstname`, `lastname`, `password`, `state`, `role`) VALUES
(1, 'admin@mybooking.com', 'ADMIN', 'ADMIN', 'admin@123', 1, 'admin'),
(2, 'tkross@mybooking.com', 'TONI', 'KROSS', 'toni@123', 1, 'customer'),
(3, 'lmessi@mybooking.com', 'LIONEL', 'MESSI', 'lionel@123', 0, 'customer'),
(4, 'test@test.ma', 'test1', 'test2', 'test@123', 1, 'customer'),
(5, 'test2@test.ma', 'test2', 'test2', 'test2@123', 0, 'customer'),
(6, 'user@booking.ma', 'user', 'user1', 'user@123', 1, 'customer');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`),
  ADD KEY `roomId` (`roomId`);

--
-- Index pour la table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `room`
--
ALTER TABLE `room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`roomId`) REFERENCES `room` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
