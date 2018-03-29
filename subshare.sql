CREATE DATABASE subshare DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE  original (
id INT( 11 ) NOT NULL AUTO_INCREMENT ,
champ INT( 100 ) ,
time VARCHAR( 100 )  ,
texteori1 VARCHAR( 200 )  ,
texteori2 VARCHAR( 200 )  ,
 PRIMARY KEY ( id )
) ENGINE = INNODB;

CREATE TABLE  traduction (
id INT( 11 ) NOT NULL AUTO_INCREMENT ,
champ INT( 100 ) ,
time VARCHAR( 100 )  ,
textetrad1 VARCHAR( 200 )  ,
textetrad2 VARCHAR( 200 )  ,
 PRIMARY KEY ( id )
) ENGINE = INNODB;
