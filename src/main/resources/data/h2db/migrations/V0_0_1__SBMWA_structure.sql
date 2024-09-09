/*
 * Engine: H2DB
 * Version: 0.0.1
 * Description: Initial database structure
 */

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `city` varchar(255),
  `zipcode` varchar(255)
);

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` VARCHAR(128),
  `email` VARCHAR(128),
  `mobile_number` VARCHAR(128),
  `dob` date DEFAULT NULL,
  `gender` varchar(255) NOT NULL,
  `is_adult` bit(1) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `address_id` bigint(20)
);

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `title` varchar(255) NOT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  KEY `FK5w75tx731o2t3abhgesnobgih` (`person_id`),
  CONSTRAINT `FK5w75tx731o2t3abhgesnobgih` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
);

--
-- Table structure for table `movies`
--


CREATE TABLE `movies` (
  `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `movie_details` varchar(255) NOT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `movies_person_fk` (`person_id`),
  CONSTRAINT `movies_person_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
);


