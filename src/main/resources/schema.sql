DROP TABLE IF EXISTS THEATRE;
CREATE TABLE THEATRE (
	id INT AUTO_INCREMENT  PRIMARY KEY,
	name VARCHAR(200) NOT NULL,
	address_id INT(10) NOT NULL,
	show1 INT(10),
	show2 INT(10),
	show3 INT(10)
	--show, show2, show3 contains movieids
);

DROP TABLE IF EXISTS ADDRESS;
CREATE TABLE ADDRESS (
	id INT(10) AUTO_INCREMENT  PRIMARY KEY,
	line1 VARCHAR(200) NOT NULL,
	line2 VARCHAR(200),
	city VARCHAR(80)  NOT NULL,
	state VARCHAR(50)  NOT NULL,
	postal_code VARCHAR(7) NOT NULL,
	country VARCHAR(50)  NOT NULL,
	phone VARCHAr(10)

);


DROP TABLE IF EXISTS MOVIE;
CREATE TABLE MOVIE (
	id INT(10) AUTO_INCREMENT  PRIMARY KEY,
	name VARCHAR(200) NOT NULL,
	language VARCHAR(30) NOT NULL,
	genre VARCHAR(15) NOT NULL,
	duration_in_min INT(3),
	release_date DATE
);

DROP TABLE IF EXISTS SHOW;
CREATE TABLE SHOW (
	id INT(10) AUTO_INCREMENT PRIMARY KEY,
	movie_id INT(10) NOT NULL,
	show_date DATE NOT NULL,
	start_time TIME NOT NULL,
	end_time TIME
);
