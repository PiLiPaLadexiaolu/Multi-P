
CREATE DATABASE IF NOT EXISTS `citicwx` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `citicwx`;

CREATE TABLE IF NOT EXISTS `test_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `text_one` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `text_two` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `created_time` timestamp NOT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `ver` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
