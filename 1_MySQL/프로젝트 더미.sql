

INSERT INTO sign_up
VALUES("asd123", '123','서울','010-0000-0000', "asd123@naver.com" ,"홍길동", 20, 'M', true);

INSERT INTO sign_up
VALUES("asd1123", '123','부산','010-0000-0001', "asd1123@naver.com" ,"임꺽정", 20, 'M', false);

INSERT INTO sign_up
VALUES("asd1223", '123','경기','010-0000-0001', "asd1223@naver.com" ,"자두", 25, 'F', true);

INSERT INTO sign_up
VALUES("asd1323", '123','대전','010-0000-0001', "asd1323@naver.com" ,"수박", 26, 'M', true);

INSERT INTO sign_up
VALUES("asd5123", '123','대구','010-0000-0001', "asd5123@naver.com" ,"딸기", 30, 'F', true);

INSERT INTO sign_up
VALUES("asd1823", '123','광주','010-0000-0001', "asd1823@naver.com" ,"메론", 45, 'M', true);

INSERT INTO sign_up
VALUES("asd1173", '123','서울','010-0000-0001', "asd1173@naver.com" ,"망고", 27, 'F', true);


INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd123" , "홍시" , "축구" , "안녕하세요 축구를 좋아하는 홍시입니다", "서울 강남", "#축구 #농구");

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd1223" , "자두에이드" , "맛집탐방" , "안녕하세요 음료를 좋아하는 자두에이드입니다", "경기 성남", "#커피 #에이드");

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd1323" , "수박무침" , "맛집탐방" , "안녕하세요 먹을것을 좋아하는 수박무침입니다", "대전 유성", "#돈까스 #제육");

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd5123" , "일본딸기" , "여행" , "안녕하세요 일본여행을 좋아하는 홍시입니다", "대구 중구", "#일본 #오사카");

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd1823" , "메로나" , "야구" , "안녕하세요 야구를 좋아하는 메로나입니다", "광주 서구", "#야구");

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd1173" , "애플망고" , "과일" , "안녕하세요 과일을 좋아하는 애플망고입니다", "서울 강북", "#과일 #비건");


INSERT INTO membership(membership_Name, membership_img, membership_info, membership_max )
VALUES("대한축구협회" , "/1q2w3e.png" , "축구를 좋아하는 사람들의 모임입니다" , 10);

INSERT INTO membership(membership_Name, membership_img, membership_info, membership_max )
VALUES("대한맛집탐방협회" , "/1q2w3e3.png" , "맛집을 좋아하는 사람들의 모임입니다" , 15);

INSERT INTO membership(membership_Name, membership_img, membership_info, membership_max )
VALUES("해외여행장려협회" , "/1q2w1233e.png" , "해외여행을 좋아하는 사람들의 모임입니다" , 100);



INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("호스트", 1 , 1);

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("호스트", 2 , 2);

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("일반회원", 3 , 2);

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("호스트", 4 , 3);

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("비회원", 5 , 1);

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("관리자", 6 , 2);



INSERT INTO location_category_large (loc_la_name)VALUES("서울");
INSERT INTO location_category_large (loc_la_name)VALUES("경기");
INSERT INTO location_category_large (loc_la_name)VALUES("부산");
INSERT INTO location_category_large (loc_la_name)VALUES("대구");

INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("강남구",1);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("서초구",1);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("강북구",1);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("안양",2);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("수원",2);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("안산",2);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("해운대구",3);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("중구",3);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("북구",3);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("달서구",4);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("수성구",4);
INSERT INTO location_category_small (loc_s_name, loc_la_code)VALUES("중구",4);

INSERT INTO type_category_large(type_la_name) VALUES("운동");
INSERT INTO type_category_large(type_la_name) VALUES("여행");
INSERT INTO type_category_large(type_la_name) VALUES("맛집");
INSERT INTO type_category_large(type_la_name) VALUES("스터디");
INSERT INTO type_category_large(type_la_name) VALUES("반려동물");
INSERT INTO type_category_large(type_la_name) VALUES("예술");
INSERT INTO type_category_large(type_la_name) VALUES("엑티비티");

INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("축구",1);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("농구",1);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("야구",1);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("국내여행",2);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("해외여행",2);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("일식",3);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("중식",3);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("한식",3);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("영어",4);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("공무원",4);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("코딩",4);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("반려견",5);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("반려묘",5);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("기타 반려동물",5);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("락",6);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("미술",6);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("힙합",6);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("클라이밍",7);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("레프팅",7);
INSERT INTO   type_category_small(type_s_name,type_la_code) VALUES ("페러글라이딩",7);

INSERT INTO membership_location(loc_s_code , membership_code) VALUES (1,1);
INSERT INTO membership_location(loc_s_code , membership_code) VALUES (2,1);
INSERT INTO membership_location(loc_s_code , membership_code) VALUES (1,2);
INSERT INTO membership_location(loc_s_code , membership_code) VALUES (5,2);
INSERT INTO membership_location(loc_s_code , membership_code) VALUES (6,2);
INSERT INTO membership_location(loc_s_code , membership_code) VALUES (10,3);

INSERT INTO membership_type(type_s_code , membership_code) VALUES (1,1);
INSERT INTO membership_type(type_s_code , membership_code) VALUES (6,2);
INSERT INTO membership_type(type_s_code , membership_code) VALUES (7,2);
INSERT INTO membership_type(type_s_code , membership_code) VALUES (8,2);
INSERT INTO membership_type(type_s_code , membership_code) VALUES (5,3);

SELECT * FROM membership_location;
SELECT * FROM type_category_small;
SELECT * FROM location_category_small;
SELECT * FROM membership;
SELECT * FROM membership_user_list;

SELECT user_code, user_name, membership_name, list_grade, user_manner,  user_hobby, user_type
FROM membership_user_list
JOIN user USING(user_code)
JOIN membership USING(membership_code)
JOIN sign_up USING(id)
WHERE membership_code = 1 AND list_grade != "비회원";

SELECT membership_code, membership_Name,  type_s_name, loc_s_name
FROM membership
JOIN membership_location USING(membership_code)
JOIN membership_type USING (membership_code)
JOIN type_category_small USING (type_s_code)
JOIN location_category_small USING (loc_s_code) 
WHERE loc_s_name = "강남구";

SELECT user_name, list_grade, membership_code, membership_Name, membership_info, type_s_name, loc_s_name
FROM membership
JOIN membership_location USING(membership_code)
JOIN membership_type USING (membership_code)
JOIN type_category_small USING (type_s_code)
JOIN location_category_small USING (loc_s_code) 
JOIN membership_user_list USING(membership_code)
JOIN user USING(user_code)
;

SELECT * FROM sign_up;

SELECT * FROM user;

SELECT * 
FROM sign_up
JOIN user USING(id);

