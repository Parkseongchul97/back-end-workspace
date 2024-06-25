/*
	뷰(View)
    - SELECT 문을 저장할 수 있는 객체 
    - 가상 테이블 (실제 데이터가 담겨 있는 건 X -> 논리적인 테이블) 
    - DML(INSERT, UPDATE, DELETE) 작업 가능 
    
    * 사용 목적
    - 편리성 : SELECT 문의 복잡도 완화
    - 보안성 : 테이블의 특정 열을 노출하고 싶지 않은 경우 

*/

SELECT * FROM employee;
-- 한국에서 근무하는 사원들의 사번, 이름 ,부서명, 급여, 근무국가명 조회 
SELECT emp_id,
	emp_name,
    dept_title,
    salary,
    national_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id= local_code)
    JOIN national USING(national_code)
WHERE national_name = "한국";

-- 러시아에서 근무하는 사원들의 사번, 이름 ,부서명, 급여, 근무국가명 조회 

SELECT emp_id,
	emp_name,
    dept_title,
    salary,
    national_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id= local_code)
    JOIN national USING(national_code)
WHERE national_name = "러시아";

-- 일본에서 근무하는 사원들의 사번, 이름 ,부서명, 급여, 근무국가명 조회

SELECT emp_id,
	emp_name,
    dept_title,
    salary,
    national_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id= local_code)
    JOIN national USING(national_code)
WHERE national_name = "일본";


/*
	1. VIEW 생성 
    CREATE [OR REPLACE] VIEW 뷰명 
    AS 서브쿼리;
    
    - OR REPLACE : 뷰 생성시 기존에 중복된 이름에 뷰가 없다면 새로 뷰 생성,
				   기존에 중복된 이름의 뷰가 있다면 해당 뷰 수정 
*/
CREATE OR REPLACE VIEW vw_employee
AS SELECT emp_id,
	emp_name,
    dept_title,
    salary,
    national_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id= local_code)
    JOIN national USING(national_code);


-- 한국에서 근무하는 사원들의 사번, 이름 ,부서명, 급여, 근무국가명 조회 
SELECT *
FROM vw_employee
WHERE national_name = "한국";

-- 러시아에서 근무하는 사원들의 사번, 이름 ,부서명, 급여, 근무국가명 조회 

SELECT * 
FROM vw_employee
WHERE national_name = '러시아';

-- 일본에서 근무하는 사원들의 사번, 이름 ,부서명, 급여, 근무국가명 조회

SELECT * 
FROM vw_employee
WHERE national_name = '일본';

/*
	2) 뷰 컬럼에 별칭 부여 
    - 서브쿼리의 SELECT 절에 함수식이나 산술연산식이 기술되어 있을 경우 반드시 별칭 지정!
*/

-- 사원의 사번, 사원명, 직급명, 성별(남/여) 근무년수를 조회할수 있는 뷰 생성

SELECT emp_id 사번,
	emp_name 사원명,
    job_name 직급명,
    if(substr(emp_no, 8, 1) = 1 ,  '남',  '여') 성별,
    timestampdiff(year, hire_date, now()) 근무년수
FROM employee
	JOIN job USING(job_code);



CREATE OR REPLACE VIEW vw_emp_job
AS SELECT emp_id 사번,
	emp_name 사원명,
    job_name 직급명,
    if(substr(emp_no, 8, 1) = 1 ,  '남',  '여') 성별,
    timestampdiff(year, hire_date, now()) 근무년수
FROM employee
	JOIN job USING(job_code);

-- 성별이 남자인 사원의 사원명과 직급명 조회 
SELECT 사원명, 직급명
FROM vw_emp_job
WHERE 성별 = '남';

-- 근무년수가 20년 이상인 사원
SELECT *
FROM vw_emp_job
WHERE 근무년수 >= 20;

/*
	3. VIEW를 이용해서 DML(INSERT, UPDATE, DELETE) 사용
    - 뷰를 통해 조작하게 되면 실제 데이터가 담겨있는 테이블에 반영됨 
*/

CREATE OR REPLACE VIEW vw_job
AS SELECT job_code, job_name
	FROM job;
    
-- 뷰를 통해서 INSERT
INSERT INTO vw_job
VALUES('J8', '인턴');    

-- 뷰를 통해서 UPDATE
UPDATE vw_job
SET job_name = '알바'
WHERE job_code = 'J8';

-- 뷰를 통해서 DELETE
DELETE FROM vw_job
WHERE job_code = 'J8';

SELECT * FROM vw_job; -- 논리적인 테이블 (실제 데이터는 X)
SELECT * FROM job;    -- 베이스 테이블(실제 데이터 O)


/*
	4. DML 구문으로 VIEW 조작이 불가능한 경우 
*/

-- 1) 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우 

CREATE OR REPLACE VIEW vw_job
AS SELECT job_code FROM job;

-- 에러!!!
INSERT INTO vw_job (job_code, job_name)
VALUES ('J8','인턴'); -- job_name이라는 컬럼이 존재하지 않음

INSERT INTO vw_job (job_code)
VALUES ('J8'); -- 가능! job_code만 

UPDATE vw_job
SET job_name = '인턴'
WHERE job_code = 'J8';-- job_name이라는 컬럼이 존재하지 않음

UPDATE vw_job
SET job_code = 'J0'
WHERE job_code = 'J8'; -- 가능!

DELETE FROM vw_job
WHERE job_name = '사원'; -- job_name이라는 컬럼이 존재하지 않음

DELETE FROM vw_job
WHERE job_code = 'J0'; -- 가능! 

-- 2) 뷰에 포함되지 않은 컬럼 중에 베이스가 되는 컬럼이 NOT NULL 제약조건이 지정된 경우 
CREATE OR REPLACE VIEW vw_job
AS SELECT job_name FROM job;


-- job_code가 PRIMARY KEY라 null로 존재할 수 없어서 
INSERT INTO vw_job (job_name)
VALUES ('인턴'); -- 에러!!

UPDATE vw_job
SET job_name = '인턴'
WHERE job_name = '사원'; -- 가능!

-- employee에 foreign키로 연결되어있어서 자식데이터가 있기때문에 
DELETE FROM vw_job
WHERE job_name = '인턴'; -- 에러

SELECT * FROM vw_job;
SELECT * FROM job;

-- 3. 산술표현식 또는 함수식으로 정의된 경우
-- 사번, 사원명, 급여, 연봉 을 조회한 
CREATE OR REPLACE VIEW vw_emp_sal
AS SELECT emp_id 사번,
		emp_name 사원명,
        emp_no 주민번호,
        salary 급여,
        salary * 12 연봉
	FROM employee;

-- 산술연산식으로 정의도니 컬럼은 데이터 추가 불가능
INSERT INTO vw_emp_sal
VALUES (300, '홍길동', 3000000, 36000000);-- 에러 ! 

-- 산술연산식이 들어간 view에는 insert가 절때 불가능!!
INSERT INTO vw_emp_sal (사번, 사원명, 주민번호, 급여)
VALUES (600, '홍길동', '800000-1234567', 3200000); -- 이것도 에러!!

-- 산술연산으로 정의도니 컬럼은 데이터 변경 불가능!
UPDATE vw_emp_sal
SET 연봉 = 80000
WHERE emp_id = 200; -- 에러 !

-- 산술연산과 무관한 컬럼은 데이터 변경 가능! 
UPDATE vw_emp_sal
SET 급여 = 9000000
WHERE 사번 = 200; -- 가능! 연봉도 반영 !

-- DELETE는 가능 
DELETE FROM vw_emp_sal
WHERE 연봉 = 72000000; -- 가능 201 송중기 삭제 


SELECT * FROM vw_emp_sal;
SELECT * FROM employee;

-- 4. 그룹함수나 GROUP BY 절을 포함한 경우 

CREATE OR REPLACE VIEW vw_groupdept
AS SELECT sum(salary) 합계,
		avg(salary) 평균
	FROM employee
    GROUP BY dept_code;
    
SELECT * FROM vw_groupdept;

-- INSERT (에러) UPDATE (에러) DELETE (에러) 모두 안댐 
INSERT INTO vw_groupdept
VALUES ('D11','123', '123'); -- 에러!

UPDATE vw_groupdept
SET 합계 = 800
WHERE dept_code = 'D1';  -- 에러!

DELETE FROM vw_groupdept
WHERE 평균 = 5210000;  -- 에러!

-- 5. DISTINCT 구문이 포함된 경우

-- employee 테이블로 job_code만 중복없이 조회 

CREATE OR REPLACE VIEW vw_dt_job
AS SELECT DISTINCT job_code
	FROM employee;
 
 -- INSERT (에러) UPDATE (에러) DELETE (에러) 모두 안댐 
INSERT INTO vw_dt_job
VALUES ('J8'); -- 에러!

UPDATE vw_dt_job
SET job_code = 'J0'
WHERE job_code = 'J1'; -- 에러!

DELETE FROM vw_dt_job
WHERE job_code = 'J7'; -- 에러!
    
SELECT * FROM vw_dt_job;

-- 6. JOIN을 이용해서 여러 테이블을 연결한 경우 
-- 사원들의 사번 사원명 주민번호 부서명 조회 

CREATE OR REPLACE VIEW vw_joinemp
AS SELECT emp_id 사번,
		emp_name 사원명,
        emp_no 주민번호,
        dept_title 부서명
	FROM employee
		JOIN department ON(dept_code = dept_id);


-- INSERT 에러 !!        
INSERT INTO vw_joinemp
VALUES (300,'송준호','800000-1234567','총무부'); -- 에러! dept_title을 추가할수 없음! 

INSERT INTO vw_joinemp(사번, 사원명, 주민번호)
VALUES (300,'송준호','800000-1234567');  -- 가능! 

-- UPDATE 가능!

UPDATE vw_joinemp
SET 사원명 = '박성철'
WHERE 사번 = 214;  -- 가능!

UPDATE vw_joinemp
SET 부서명 = '회계부'
WHERE 사번 = 214;  -- 같은 dept_title이던 사람들도 모두 회계부로 변함!! 

-- DELETE 에러!

DELETE FROM vw_joinemp
WHERE emp_id = 214;  -- join된 view는 삭제가 불가능!! 에러 !! 
        
SELECT * FROM vw_joinemp;
SELECT * FROM employee;

-- 7. VIEW 옵션 
-- WITH CHECK OPION : 서브쿼리에 기술된 조건에 부합하지 않는 값으로 수정시 에러 발생! 
-- 급여가 300만 이상인 사원들만 조회

 CREATE OR REPLACE VIEW vw_emp
 AS SELECT *
	FROM employee
    WHERE salary >= 3000000;

    
-- 200번 사원의 급여를 200만원으로 변경 

UPDATE vw_emp
SET salary = 2000000
WHERE emp_id = 200; --  WITH CHECK OPTION이 붙기전 가능!!

-- WITH CHECK OPTION 사용! 
 CREATE OR REPLACE VIEW vw_emp
 AS SELECT *
	FROM employee
    WHERE salary >= 3000000
WITH CHECK OPTION;

-- 202번 사원의 급여를 200만원으로 변경 

-- 300만원 이상인 조건이 부합하지 않아서 
UPDATE vw_emp
SET salary = 2000000
WHERE emp_id = 202; -- 에러!! 

-- 300만원 이상인 view의 조건이 부합되어서 가능
UPDATE vw_emp
SET salary = 4000000
WHERE emp_id = 202; -- 성공!! 
    
SELECT * FROM employee;
SELECT * FROM vw_emp;
























