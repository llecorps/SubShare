CREATE DATABASE subshare DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE  original (
id INT( 11 ) NOT NULL AUTO_INCREMENT ,
champ INT( 100 ) ,
datedeb VARCHAR( 100 )  ,
datefin VARCHAR( 100 )  ,
texteori VARCHAR( 200 )  ,
 PRIMARY KEY ( id )
) ENGINE = INNODB;


CREATE TABLE  traduction (
id INT( 11 ) NOT NULL AUTO_INCREMENT ,
champ INT( 100 ) ,
datedeb VARCHAR( 100 )  ,
datefin VARCHAR( 100 )  ,
textetrad VARCHAR( 200 )  ,
 PRIMARY KEY ( id )
) ENGINE = INNODB;
