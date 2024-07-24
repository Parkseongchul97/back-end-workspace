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

CREATE TABLE bank(
	name VARCHAR(20),
    balance INT
);
INSERT INTO bank
VALUES ('동엽' , 100000);

INSERT INTO bank
VALUES ('동호' , 0);

DROP TABLE bank;

SELECT * FROM bank;




INSERT INTO member
VALUES ('qwer1234', '1234', '김철수');

SELECT *
FROM book
LEFT Join publisher ON (pub_no = bk_pub_no);

SELECT * FROM book; /*bk_no 프라이머리키 */
SELECT * FROM member; /*member_no 프라이머리키 */
SELECT * FROM publisher; /*pub_no(프라이머리키) = book.bk_pub_no  */
SELECT * FROM rent; /* rent_no 프라이머리 
					rent_mem_no =   member_no
					rent_book_no = bk_no */

SELECT * FROM member.member;

SELECT rent_no, bk_title, bk_author , adddate(rent_date, interval 14 day) as return_date
FROM rent
JOIN book ON (rent_book_no = bk_no)
WHERE rent_mem_no = 5 ;

SELECT rent_no FROM rent WHERE rent_no = 2;

delete from member.member
WHERE id = "";
