/*
 * Engine: MySQL
 * Version: 0.0.1
 * Description: Sample Data
 */

--
-- Data for table `address`
--

INSERT INTO `address` (`city`,`zipcode`) VALUES ('address one','101-101');
INSERT INTO `address` (`city`,`zipcode`) VALUES ('address two','102-102');
INSERT INTO `address` (`city`,`zipcode`) VALUES ('address three','103-103');
INSERT INTO `address` (`city`,`zipcode`) VALUES ('address four','104-104');
INSERT INTO `address` (`city`,`zipcode`) VALUES ('address five','105-105');

--
-- Data for table `person`
--

INSERT INTO `person` (`name`,`email`,`mobile_number`,`gender`,`age`,`is_adult`,`dob`,`address_id`) VALUES ('Zoe','example1@domain.com','1111111111','FEMALE',6,0,'2015-10-21',1);
INSERT INTO `person` (`name`,`email`,`mobile_number`,`gender`,`age`,`is_adult`,`dob`,`address_id`) VALUES ('John','example2@domain.com','2222222222','MALE',19,1,'2002-12-21',2);
INSERT INTO `person` (`name`,`email`,`mobile_number`,`gender`,`age`,`is_adult`,`dob`,`address_id`) VALUES ('Adam','example3@domain.com','3333333333','MALE',5,0,'2016-10-23',3);
INSERT INTO `person` (`name`,`email`,`mobile_number`,`gender`,`age`,`is_adult`,`dob`,`address_id`) VALUES ('Lacy','example4@domain.com','4444444444','FEMALE',18,1,'2003-12-24',4);
INSERT INTO `person` (`name`,`email`,`mobile_number`,`gender`,`age`,`is_adult`,`dob`,`address_id`) VALUES ('Jane','example5@domain.com','5555555555','FEMALE',5,0,'2016-11-25',5);

--
-- Data for table `books`
--

INSERT INTO `books` (`title`,`person_id`) VALUES ('user1-book1',1);
INSERT INTO `books` (`title`,`person_id`) VALUES ('user1-book2',1);
INSERT INTO `books` (`title`,`person_id`) VALUES ('user2-book1',2);
INSERT INTO `books` (`title`,`person_id`) VALUES ('user3-book1',3);
INSERT INTO `books` (`title`,`person_id`) VALUES ('user3-book2',3);
INSERT INTO `books` (`title`,`person_id`) VALUES ('user4-book1',4);
INSERT INTO `books` (`title`,`person_id`) VALUES ('user5-book1',5);

--
-- Data for table `movies`
--

INSERT INTO `movies` (`movie_details`,`person_id`) VALUES ('Tenet',1);
INSERT INTO `movies` (`movie_details`,`person_id`) VALUES ('Inception',1);
INSERT INTO `movies` (`movie_details`,`person_id`) VALUES ('Fight Club',2);
INSERT INTO `movies` (`movie_details`,`person_id`) VALUES ('Life Is Beautiful',2);
INSERT INTO `movies` (`movie_details`,`person_id`) VALUES ('Interstellar',4);
INSERT INTO `movies` (`movie_details`,`person_id`) VALUES ('Tenet',5);
