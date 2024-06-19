/*
	함수 : 전달된 컬럼값을 읽어들여서 함수를 실행한 결과를 반환 
    
    - 단일행 함수 : N개의 값을 읽어서 N개의 결과값 리턴 (매 행마다 함수 실행 결과 반환)
    - 그룹 함수 : N개의 값을 읽어서 1개의 결과값 리턴 (그룹별로 함수 실행 결과 반환)
    
    >> SELECT 절에 단일행 함수와 그룹 함수는 함께 사용하지 못함!
	   WHY? 결과 행의 개수가 다르기 떄문에!
       
	>> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING
*/

-- 단일행 함수 

/*
	문자 처리 함수 
    
    LENGTH() : 해당 문자열값의 BYTE 길이 수 반환
    - 한글 한 글자 -> 3BYTE
    - 영문자, 숫자, 특수문자는 한 글자 -> 1BYTE
    CHAR_LENGTH() : 해당 문자열 값의 글자수 반환 
    
*/
SELECT length('데이터베이스')
	,char_length('데이터베이스')
    ,char_length('database')
    ,length('database');
    
-- 사원명 사원명의 글자수 이메일 이메일의 글자수 조회
SELECT 
	emp_name,
    char_length(emp_name) "사원명의 글자수",
    email,
    char_length(email) "이메일의 글자수"
    
FROM employee;

/*
	INSTR(컬럼|'문자열', '찾으려는 문자열') :
    - 특정 문자열에서 찾고자 하는 문자열의 위치 반환
    - 없으면 0을 반환 
*/

SELECT
	instr('AABBAACAABBAA', 'B') -- 가장 첫번째 위치한것을 반환 
    ,instr('AABBAACAABBAA', 'D'); -- 없어서 0반환 
    
-- 's'가 포함되어있는 이메일중 이메일, 이메일의 @ 위치 조회

SELECT
	instr(email , '@')
    ,email
FROM employee
WHERE email LIKE '%s%' ;

/*
	LPAD|RPAD(컬럼|'문자열', 최종적으로 반환할 문자의 길이, '덧붙이고자 하는 문자')
    - 문자열에 덧붙이고자 하는 문자를 왼쪽 또는 오른쪽에서 덧붙혀서
      최종적으로 반환할 문자의 길이만큼 문자열 반환 
*/

SELECT lpad('hello', 10 ,'*****') ,rpad('hello',10,'+'); -- 각자 좌 우에 추가
    
/*
	TRIM(컬럼|문자열) | TRIM([LEADING|TRAILING|BOTH] 제거하고자하는문자들 FROM 컬럼|'문자열')
    - 문자열의 앞(LEADING)/뒤(TRAILING)/양쪽(BOTH)에 있는 지정한 문자들을 제거한 나머지 문자열 반환
*/

SELECT trim('              K   H          ') -- 기본적으로 양쪽에 공백 제거 
	,trim(BOTH '   ' FROM '              K   H          '); -- BOHT : 앞뒤 문자 제거 
    
SELECT trim(LEADING 'Z' FROM 'ZZZZZKHZZZZZZ') -- 좌측 문자제거는 LEADING 
	,ltrim('              K   H          ') ;-- LTRIM : 앞쪽 공백만 제거 

SELECT trim(TRAILING 'Z' FROM 'ZZZZZKHZZZZZZ') -- 우측 문자제거는 TRAILING 
	,rtrim('              K   H          ') ;-- RTRIM : 뒤쪽 공백만 제거 
    
/*
	SUBSTR|SUBSTRING(컬럼|'문자열', 시작 위치 값. 추출할 문자 개수)
	- 문자열에서 특정 문자열을 추출해서 반환
    
*/
SELECT substr('PROGRAMMING', 5, 2); -- 문자열에서 5번째부터 2개 RA
SELECT substr('PROGRAMMING', 1, 6); -- 문자열에서 1번째부터 6개 PROGRA
SELECT substr('PROGRAMMING', -8, 3); --  -는 뒤에서부터 8번째 3개

-- 여자 사원들의 이름 주민등록번호 조회 
--  8번째 자리수가 2또는 4일때  
SELECT
	emp_name
    ,emp_no
FROM employee
WHERE emp_no LIKE '%-2%' or emp_no LIKE '%4______';
  
SELECT
	emp_name
    ,emp_no
FROM employee
WHERE substr(emp_no, 8, 1) LIKE '%2%' or substr(emp_no, 8, 1) LIKE '%4%';

SELECT
	emp_name
    ,emp_no
FROM employee
WHERE substr(emp_no, 8, 1) = 2 or substr(emp_no, 8, 1) = 4;

 
 -- 남자 사원들의 이름, 주민등록번호
 
SELECT
	emp_name
    ,emp_no
FROM employee
WHERE substr(emp_no, (instr(emp_no,'-') + 1 ), 1) IN (1, 3);
-- 주민등록번호 뒷자리의 첫번째 숫자를 instr로 찾고 substr으로 특정함 

/*
	ROWER : 다 소문자로 변경한 문자열 반환 ( 전부다 소문자, 대문자)
    UPPER : 다 대문자로 변경한 문자열 반환 
*/
 
SELECT lower('Welcome TO MySQL'), upper('Welcome TO MySQL');

/*
	REPLACE(컬럼|'문자열', '바꾸고 싶은 문자열', '바꿀 문자열')
    - 특정 문자열로 변경하여 반환 
*/
SELECT replace('서울특별시 강남구 역삼동', '강남구', '서초구'); -- 서울 강남 역삼동이 서울 서초 역삼으로 바뀜

/*
	CONCAT : 문자열을 하나로 합친 후 결과 반환 
*/
SELECT concat('가나다라', 'ABCD', '1234'); -- 가나다라ABCD1234

-- 실습문제 

-- 1. 이메일의 kh.or.kr을 gmail.com으로 변경해서 이름 , 변경전 이메일, 변경후 이메일 조회
SELECT
	emp_name
    ,email 변경전
    ,replace(email, 'kh.or.kr','gamil.com') 변경후
FROM employee;


-- 2. 사원명과 주민등록번호 (앞자리-0**** 이런식으로 조회
SELECT
	emp_name
    ,replace(emp_no, substr(emp_no,(instr(emp_no,'-') + 2 ),6),'******') 뒷자리가리기 -- 뒷자리를 별로 교체
    ,rpad(substr(emp_no, 1, 8), char_length(emp_no), "*") 
    -- rpad로 우측부터 채우는데 emp_no에서 앞자리만 추출한후 최대 글자수를 length로 구한후 뒤를 *로 채움
    ,concat(substr(emp_no, 1, 8),"******")
    
FROM employee;



-- 3. 사원명, 이메일 , 이메일에서 추출한 아이디 조회
SELECT
	emp_name
    ,email
    ,trim(TRAILING '@kh.or.kr' FROM email) 아이디
    ,replace(email, '@kh.or.kr', '')
    ,substr(email, 1, instr(email, '@')-1)
FROM employee;

/*
	숫자 처리 함수
    
    ABS : 절대값 반환 (0에서 부터의 거리)
*/
SELECT abs(5.6),abs(-15); -- 5.6, 15

/*
	숫자 DIV 숫자 = 숫자 / 숫자  div는 소숫점 잘라줌
    숫자 MOD 숫자 = 숫자 % 숫자 = MOD(숫자,숫자)
*/
SELECT 10 div 3 , 10 / 3 , 10 MOD 3, 10 % 3;

/*
	ROUND(숫자, 소숫점 n번째 자리이고 - 면 정수자리)
    - 반올림한 결과를 반환 
    CEIL(숫자)
    - 올림 처리해서 반환 
    FLOOR(숫자)
    - 버림 처리해서 반환
    
*/
SELECT round(123.567), round(123.567, -2);

SELECT ceil(123.123),
	floor(123.923);
    
/*
	TRUNCATE(숫자, 위치)
    - 위치 지정하여 버림 처리해서 반환
*/
SELECT truncate(123.456, 2); -- 123.45

/*
	날짜 처리 함수 
	NOW, CURRENT_TIMESTAMP : 현재 날짜와 시간 반환 
    CURADATE, CURRENT_DATE : 현재 날짜 반환 
    CURTIME, CURRENT_TIME : 현재 시간 반환 
*/
SELECT now(), CURRENT_TIMESTAMP(),
	curdate(), CURRENT_DATE(),
    curtime(), CURRENT_TIME();

/*
	DAYOFYEAR : 날짜가 해당 연도에서 몇 번째 날인지 반환 
    DAYOFMONTH : 날짜가 해당 월에서 몇 번쨰 날인지 반환
	DAYOFWEEK : 날짜가 해당 주에서 몇 번째 날인지 반환(일요일 = 1, 토요일 = 7)
*/
SELECT dayofyear(now()),dayofmonth(now()),dayofweek(now());

/*
	PERIOD_DIFF(날짜, 날짜) : 두 기간의 차이를 숫자로 반환 
    DATEDIFF(날짜, 날짜) : 두 날짜 사이의 일수를 숫자로 반환 
    TIMEDIFF(날짜, 날짜) : 두 시간의 차이를 날짜 형식으로 반환
    TIMESTAMPDIFF(날짜단위, 날짜, 날짜) : 두 날짜 사이의 기간을 날짜 단위에 따라 변환
    
    * 날짜단위 : year(연도), quarter(분기), month(월), week(주), day(일), hour(시간), minute(분), second(초)
*/
SELECT
	period_diff(202406, 202411), -- -5 앞 빼기 뒤 느낌 
    period_diff(202412, 202406), -- 6
    datediff('2024-12-31', now()), 
    timediff('2025-01-01 00:00:00', now());

-- 직원명, 입사일 , 근무 일 수 , 근무 개월수 ,근무 년수

SELECT
	emp_name
    ,hire_date
    ,datediff(now(), hire_date) "근무 일 수"
    ,timestampdiff(month, hire_date, now()) "근무 개월 수"
    ,timestampdiff(year, hire_date, now()) "근무 년 수"
    ,timestampdiff(year, hire_date, now())+1 "근무 년차"
    
FROM employee;
/*
	ADDDATE(날짜, INTERVAL 숫자 날짜단위)
    ADDTIME(날짜, 시간정보)
    - 특정 날짜에 입력받은 정보만큼 더한 날짜를 반환 
    
    SUBDATE(날짜, interval 숫자 날짜단위)
    SUBTIME(날짜, 시간정보)
    - 특정 날짜에 입력받은 정보만큼 뺀 날짜를 반환 
*/

SELECT now(), adddate(now(), interval 10 day),
	adddate(now(), interval 10 year), -- 뒤에 단위만큼 더함
    subdate(now(), interval 10 day),
    subdate(now(), interval 50 year), -- 뒤에 단위만큼 뺌
    addtime(now(), "01:00:00"), -- 시간추가
    subtime(now(), "03:00:00"); -- 시간빼기
    
-- 직원명, 입사일 , 입사후 6개월 날짜
SELECT 
	emp_name,
    hire_date,
    adddate(hire_date, interval 6 month) "입사후 6개월뒤 시점"
FROM employee;

/*
	LAST_DAY : 해당 월의 마지막 날짜를 반환 
*/
SELECT last_day(now());

/*
	YEAR, MONTH, DAY, HOUR, MINUTE, SECOND
    - 특정 날짜에 연도, 월, 일, 시간, 분, 초 정보를 각각 추출해서 반환 
*/
SELECT year(now()),
	month(now()),
	day(now()),
    hour(now()),
    minute(now()),
    second(now());
    
-- 연도별 오래된 순으로 직원명, 입사년도 , 입사월, 입사일 조회 

SELECT
	emp_name,
    hire_date,
    year(hire_date) 입사년도,
    month(hire_date) 입사월,
    day(hire_date) 입사일
FROM employee
ORDER BY 3, 4, 5;

/*
	포맷 함수
    FORMAT(숫자, 위치) : 숫자에 3단위씩 콤마 추가해서 반환 
    DATE_FORMAT(날짜 ,포맷형식) : 날짜 형식을 변경해서 반환 
    * 포맷형식 %Y.%m.%d
*/
SELECT 
	salary, 
	format(salary, 0),
    now(),
    date_format(now(), '%Y.%m.%d'), -- %Y : 년도 %m : 월, %d : 일
    date_format(now(), '%Y.%m.%d %T') -- %T : 시간전체, %H : 시간, %i : 분, %s : 초 
FROM employee;

-- 직원명, 입사일(2024년 06월 19일 14시 05분 30초) 조회
SELECT
	emp_name,
    hire_date,
    date_format(hire_date, '%Y년 %m월 %d일 %H시 %i분 %s초')
FROM employee;

/*
	null 처리 함수 
    
    COALESCE|IFNULL(값, 값이 NULL일 경우 반환할 값)
*/
SELECT
	emp_name,
    ifnull(bonus, 0)
FROM employee;

SELECT
	emp_name 이름,
    ifnull(bonus, 0) 보너스,
    format(salary, 1)급여,
    format(((salary + salary*ifnull(bonus, 0)) *12), 1) 연봉
FROM employee
ORDER BY 4 DESC;

-- 직원명, 부서코드 조회 부서코드 없을시 부서없음
SELECT
	emp_name,
    ifnull(dept_code,'부서없음') 부서코드
FROM employee;

/*
	NULLIF(값1,값2)
    - 두 개의 값이 동일하면 null 반환, 두 개의 값이 동일하지 않으면 값 1반환 
*/
SELECT nullif('123','123'), -- null
	nullif('123','456'); -- 123  
    
/*
	IF(값1, 값2, 값3) | IF(조건, 조건이true인 경우, 조건이 false인 경우)
    - 값1이 null이 아니면 값2 반환, null이면 값 3 반환
	- 조건에 해당하면 두번째 값 반환, 해당하지 않으면 마지막 값 반환 
*/    
SELECT emp_name,
	bonus,
	if(bonus, ROUND(bonus+ 0.7,3) , 0.1)
FROM employee;

-- 직원명, 부서코드가 있으면 부서있음 없으면 부서없음
SELECT emp_name,
	dept_code,
	if(dept_code is not null, '부서있음','부서없음')
--  if(dept_code is null, '부서없음' ,'부서있음')
FROM employee;

-- 사번, 사원명 주빈번호, 성별 조회

SELECT emp_name 성명,
    emp_id 사번,
    emp_no 주민등록번호, 
	if(substr(emp_no, 8 , 1) = 1, '남자','여자') 성별
FROM employee;

-- 사원명 집급코드 기존급여 인상된 급여 조회 
-- 정렬은 직급코드 j1부터 인상된 급여 높은순서대로 
-- 직급코드가 j7인 사원은 10%
-- 직급코드가 j6은 15% j5는 20%인상 그외 직급은 5%인상 
SELECT emp_name 이름,
    job_code 직급코드,
    salary 기존급여, 
    format(if(job_code = 'J7', salary * 1.1, 
		if(job_code = 'J6', salary * 1.15, 
			if(job_code = 'J5', salary * 1.2, salary * 1.05))), 0) 인상급여
    -- j7이면 1.1배 아니면 (j6이면 1.15배 아니면(j5면 1.2배 아니면(1.05배))) 
    -- 이런식으로 if안에 if 걸어서 해결
FROM employee
ORDER BY 2 ,4 DESC;

/*
	CASE WHEN 조건식 1 THEN 결과값 1
		 WHEN 조건식 2 THEN 결과값 2
         .....
         ELSE 결과값 N
	END
    -> if ~ else if 문과 같음 
*/

SELECT emp_name 이름,
    job_code 직급코드,
    salary 기존급여, 
    format(
    case when job_code = 'J7' then salary * 1.1 
		 when job_code = 'J6' then salary * 1.15
         when job_code = 'J5' then salary * 1.2
		 else salary * 1.05
		 end , 0) 인상급여
    -- case when 문으로 else if 처럼 해결 
FROM employee
ORDER BY 2 ,4 DESC;

-- 사원명, 급여, 급여 등급 1~4등급 조회 
-- salary 값이 500 초과 1등급 500~350 2등급 350~200이면 3등급 나머지는 4등급 
SELECT emp_name 이름,
    salary 급여, 
    case when salary > 5000000 then '1등급' 
		 when salary > 3500000  then '2등급'
         when salary > 2000000 then '3등급'
		 else '4등급'
		 end 등급
    -- case when 문으로 else if 처럼 해결 
FROM employee;

-- 그룹함수(집계함수)-------------------

/*
	그룹함수 -> 결과값 단 1개
    - 대량의 데이터로 집계나 통계 같은 작업을 처리해야 하는 경우 사용되는 함수들
    - 모든 그룹 함수는 NULL 값을 자동으로 제외하고 값이 있는 것들만 계산 
    
    SUM : 해당 컬럼 값들의 총 합계 반환 
*/
SELECT 
	sum(salary) "회사 한달 인건비"
FROM employee;

-- 부서코드가 D5인 사원들의 총 연봉 조회
SELECT
	sum(salary)*12 "D5부서 연봉"
FROM employee
WHERE dept_code = "D5";

SELECT
	sum(if(dept_code = "D5", salary*12, 0)) "D5부서 연봉"
FROM employee;

SELECT 
sum(
    case when dept_code = 'D5' then salary*12
		 else 0
		 end) "D5부서 연봉"
FROM employee;

SELECT
       sum((salary+(salary*(if(bonus, bonus , 0))))*12) "D5부서의 보너스 포함 연봉"
FROM employee
WHERE dept_code = "D5";

/*
	AVG
    - 해당 컬럼 값들의 평균값을 반환 
    - 모든 그릅 함수는 NULL 값을 자동으로 제외하기 때문에
      AVG 함수를 사용할 때는 IFNULL 함수와 함깨 사용하는 걸 권장 
*/
-- 전체 사원의 평균 급여와 평균 보너스율 
SELECT
	avg(salary),
    avg(bonus),
    avg(ifnull(salary, 0)), 
    avg(ifnull(bonus, 0))
FROM employee;

/*
	MIN : 해당 컬럼 값들 중에 가장 작은값 반환 
    MAX : 해당 컬럼 값들 중에 가장 큰 값 반환 
*/
SELECT
	min(emp_name), min(salary), min(hire_date),
    max(emp_name), max(salary), max(hire_date),
    max(salary)-min(salary)
FROM employee;

/*
	COUNT
    - 컬럼 또는 행의 개수를 세서 반환 
    
    * : 조회 결과에 해당하는 모든 행 개수 반환
    컬럼 : 해당 컬럼 값이 NULL이 아닌 행 개수 반환
    distinct 컬럼 : 해당 컬럼값의 중복을 제거한 행 개수 반환
*/


SELECT
-- 전체 사원 수 조회 , 전체에 조건을 걸어서 해당 값이 null이 아닌걸 is not null로도 찾기가능 
	count(*),
-- 보너스를 받은 사원 수 조회
    count(bonus)
FROM employee;

SELECT
	count(distinct dept_code) -- 중복 제거로 dept_code가 몇종류 있는지 확인 
FROM employee;

-- 퇴사한 직원의 수 조회 

SELECT
	count(ent_date)
FROM employee;  
SELECT
	count(*)
FROM employee 
WHERE ent_yn = 'Y';



-- 실습문제

    
    
    
    
    
    

