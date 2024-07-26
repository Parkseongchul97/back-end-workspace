CREATE SCHEMA club;

CREATE TABLE big_tag(
	big_tag_no INT PRIMARY KEY AUTO_INCREMENT,
    big_tag_name VARCHAR(20) NOT NULL UNIQUE
);

DROP TABLE big_tag;

CREATE TABLE small_tag(
	small_tag_no INT PRIMARY KEY AUTO_INCREMENT,
    small_tag_name VARCHAR(20) NOT NULL UNIQUE,
    big_tag_no INT NOT NULL,
    FOREIGN KEY (big_tag_no) REFERENCES big_tag(big_tag_no)
);

DROP TABLE small_tag;

CREATE TABLE main_club(
	club_no INT PRIMARY KEY AUTO_INCREMENT,
    small_tag_no INT NOT NULL,
    club_name VARCHAR(20) NOT NULL UNIQUE,
    club_info VARCHAR(50),
    FOREIGN KEY (small_tag_no) REFERENCES small_tag(small_tag_no)
);

DROP TABLE main_club;

SELECT * FROM big_tag;
SELECT * FROM small_tag;
SELECT * FROM main_club;

INSERT INTO big_tag(big_tag_name)
VALUES ('스포츠');

INSERT INTO big_tag(big_tag_name)
VALUES ('여가');

INSERT INTO big_tag(big_tag_name)
VALUES ('음식');

INSERT INTO big_tag(big_tag_name)
VALUES ('여행');

INSERT INTO small_tag(small_tag_name, big_tag_no)
VALUES ('야구', 1);

INSERT INTO small_tag(small_tag_name, big_tag_no)
VALUES ('축구', 1);

INSERT INTO small_tag(small_tag_name, big_tag_no)
VALUES ('농구', 1);

INSERT INTO small_tag(small_tag_name, big_tag_no)
VALUES ('빵', 3);

INSERT INTO small_tag(small_tag_name, big_tag_no)
VALUES ('밥', 3);

INSERT INTO small_tag(small_tag_name, big_tag_no)
VALUES ('커피', 3);

INSERT INTO small_tag(small_tag_name, big_tag_no)
VALUES ('영화', 2);

INSERT INTO small_tag(small_tag_name, big_tag_no)
VALUES ('국내', 4);

INSERT INTO small_tag(small_tag_name, big_tag_no)
VALUES ('해외', 4);

INSERT INTO main_club(small_tag_no ,club_name ,club_info)
VALUES (4, '빵 사랑단' , "빵을 사랑하는 사람의 모임입니다");

INSERT INTO main_club(small_tag_no ,club_name )
VALUES (4, '호빵맨' );

SELECT *
FROM main_club
JOIN small_tag USING(small_tag_no)
JOIN big_tag USING(big_no);