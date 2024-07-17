CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20),
    age INT,
    addr VARCHAR(50)
);

SELECT * FROM person; 
CREATE TABLE member(
	id VARCHAR(30) PRIMARY KEY ,
    password VARCHAR(30),
	name VARCHAR(10)
);
Drop table member;


SELECT * FROM member;



INSERT INTO member
VALUES ('qwer1234', '1234', '김철수');