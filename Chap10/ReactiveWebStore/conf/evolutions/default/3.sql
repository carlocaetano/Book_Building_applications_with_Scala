# --- !Ups

CREATE TABLE Review (ID INT NOT NULL AUTO_INCREMENT,PRODUCT_ID INT NOT NULL,AUTHOR VARCHAR(250),COMMENT VARCHAR(250),PRIMARY KEY ( ID ));

# --- !Downs

# drop table "Review";