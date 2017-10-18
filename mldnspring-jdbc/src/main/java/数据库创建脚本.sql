DROP DATABASE mldn ;
CREATE DATABASE mldn CHARACTER SET UTF8 ;
USE mldn ;
CREATE TABLE news(
	nid			BIGINT		AUTO_INCREMENT ,
	title		VARCHAR(50) ,
	pubdate		DATETIME ,
	note		TEXT ,
	price		DOUBLE ,
	readcount	INT ,
	CONSTRAINT pk_nid PRIMARY KEY(nid)
) ;