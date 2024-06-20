/*
	JOIN
    - 두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용하는 구문
    - 조회 결과는 하나의 결과물(RESULT SET)으로 나옴
    - 관계형 데이터베이스는 최소한의 데이터로 각각의 테이블에 담고 있음 
		(중복을 최소화 하기위해 최대한 쪼개서 관리)
        부서 데이터는 부서테이블, 사원에 대한 데이터는 사원테이블, 직급 테이블 등... 
        
        만약 어떤 사원이 어떤 부서에 속해있는지 부서명과 같이 조회하고 싶다면?
        
        만약 어떤사원이 어떤 직급인지 직급명과 같이 조회하고 싶다면?
        
        -> 즉 관계형 데이터베이스에서 SQL 문을 이용한 테이블간의 "관계"를 맺어 원하는 데이터만 조회하는 방법 
*/
/*
	1. 내부 조인(INNER JOIN)
	  -연결시키는 컬럼의 값이 일치하는 행들만 조인되어 조회 (일치하는 값이 없는 행은 조회 X)
      
      1) WHERE 구문 
      SELECT 컬럼 ,컬럼, 컬럼...
      FROM 테이블1, 테이블2
      WHERE 테이블1.컬럼 = 테이블2.컬럼;
      
      - FROM 절에 조회하고자 하는 테이블들을 , 로 구분하여 나열
      - WHERE 절에 매칭시킬 컬럼명에 대한 조건 제시 
      
      2) ANSI(미국국립표준협회 : 산업표준을 제정하는 단체) 표준 구문 -> 다른 DB에서도 사용가능 !
      SELECT 컬럼, 컬럼, 컬럼....
      FROM 테이블1
      [INNER] JOIN 테이블2 ON (테이블1.컬럼명 = 테이블2.컬럼명); 여기서 INNER은 생략가능 
      
      - FROM 절에서 기준이 되는 테이블을 기술
      - JOIN 절에서 같이 조회하고자 하는 테이블을 기술 후 매칭 시킬 컬럼에 대한 조건을 기술 (ON, USING)
      - 연결에 사용하려는 컬럼명이 같은 경우 ON 구문 대신 USING(컬럼명) 구문 사용 
*/
-- 1) 연결할 두 컬럼명이 다른 경우 
-- 사번, 사원명, 부서코드 ,부서명 조회 

-- WHERE 구문 
SELECT emp_id,
	emp_name,
    dept_code,
    dept_title
FROM employee, department 
WHERE dept_code = dept_id ;

-- ANSI 구문 
SELECT emp_id,
	emp_name,
    dept_code,
    dept_title
FROM employee 
JOIN department ON(dept_code = dept_id);

-- 일치하는 값이 없는 행은 조회에서 제외된 것 확인 ! 
-- dept_code가 null인 사원 조회 X 

-- 사번, 사원명, 직급코드, 직급명 조회 
SELECT emp_id,
	emp_name,
   employee.job_code,
    job_name
FROM employee, job
-- WHERE job_code = job_code; 면 ambiguous : 애매한, 모호한 에러발생! 같은이름이라 어느 테이블꺼인지 못찾음

-- 해결방법 1) 테이블명 이용 , 참고로 SELECT에 것도 앞에 테이블명 붙혀줘야함 
WHERE employee.job_code = job.job_code;

-- 해결방법 2) 별칭부여  
SELECT emp_id,
	emp_name,
    e.job_code,
    job_name
FROM employee e, job j
WHERE e.job_code = j.job_code;

-- ANSI 구문 
SELECT emp_id,
	emp_name,
   e.job_code,
    job_name
FROM employee e
JOIN job j ON(e.job_code = j.job_code);

-- USING 사용 컬럼명 자체가 정확히 일치하면 사용가능 
SELECT emp_id,
	emp_name,
   job_code,
    job_name
FROM employee 
JOIN job USING(job_code);

-- 자연조인(NATURAL JOIN) : 각 테이블 마다 동일한 커럼이 한 개만 존재할 경우 
-- 주의사항! 사용 X 정확히 모든게 일치해야함 
SELECT emp_id,
	emp_name,
   job_code,
    job_name
FROM employee
NATURAL JOIN job;


-- 직급이 데리인 사원의 사번 이름 직급명 급여

-- WHERE 구문  
SELECT emp_id,
	emp_name,
    job_name,
    salary
FROM employee e , job j 
WHERE  e.job_code = j.job_code
	and job_name = '대리';

-- ANSI 구문 

SELECT emp_id,
	emp_name,
    job_name,
    salary
FROM employee
JOIN job USING(job_code)
WHERE job_name = '대리';

SELECT emp_id,
	emp_name,
    job_name,
    salary
FROM employee e
JOIN job j ON(e.job_code = j.job_code)
WHERE job_name = '대리';

-- 실습문제 
-- 1.부서가 인사관리부인 사원들의 사번 이름 보너스 조회 (employlee department)
SELECT emp_id,
	emp_name,
    bonus
FROM employee 
	JOIN department ON(dept_code = dept_id)
WHERE dept_title = '인사관리부' ;


-- 2.전체 부서의 부서코드, 부서명, 지역코드 ,지역명 조회  (department, location)
SELECT dept_id,
	dept_title,
    location_id,
    local_name
FROM department 
	JOIN location ON(location_id = local_code);


-- 3.보너스를 받는 사원들의 사번, 사원명, 보너스 , 부서명 조회 (employlee department)
SELECT emp_id,
	emp_name,
    bonus,
    dept_title
FROM employee
	JOIN department ON(dept_code = dept_id)
WHERE bonus is not null;



-- 4.부서가 총무부가 아닌 사원들의 사원명, 급여 조회(employlee department)
SELECT 
	emp_name,
    salary
FROM employee 
	left JOIN department ON(dept_code = dept_id)
WHERE ifnull(dept_title,'부서없음') != '총무부' ;

-- 각 부서별 보너스 포함 평균연봉
SELECT 
	ifnull(dept_title ,'부서없음') "부서",
	-- ifnull(dept_code,'부서없음'), 뎁스코드가 dept_id는 null이라 매칭자체가안댐
    
    format(avg((salary*(ifnull(bonus, '0'))+salary)*12),0) "각 부서별 평균연봉"
FROM employee 
	LEFT JOIN department ON(dept_code = dept_id)
GROUP BY dept_title
ORDER BY 2 DESC;

-- 일괄 적으로 보너스를 10%를 추가 해 줬을때 각 사원들의 이름과 보너스와 그달 월급 

SELECT
	emp_name "사원명",
    round(if(bonus is null , 10 , (bonus + 0.1) *100),0) "이번달 보너스",
    format(salary,0) "저번달 월급",
    format((if(bonus is null , 0.1 , bonus + 0.1)*salary)+salary,0 )"이번달 월급"
FROM employee
ORDER BY (if(bonus is null , 0.1 , bonus + 0.1)*salary)+salary DESC;
-- ORDER BY 4; format에는 콤마가 있기대문에 숫자가아니라 문자열 취급이라 순서가 꼬임

/*
	2. 외부 조인(OUTER JOIN) : MySQL은 ANSI 구문만 가능
	- 두 테이블 간의 JOIN 시 일치하지 않는 행도 포함시켜서 조회가 가능하다.
    - 단 반드시 기준이 되는 테이블(컬럼) 을 지정해야 한다. (LEFT, RIGHT, FULL)
*/

SELECT 
	emp_name,
	dept_title "부서",
    salary,
    salary*12
FROM employee 
	JOIN department ON(dept_code = dept_id);

-- 사원명, 부서명, 급여, 연봉(급여 * 12) 조회
-- 부서배치가 안된 사원 2명에 대한 정보 조회 X
-- 부서에 배정된 사원이 없는 부서도 정보 조회 X 

-- 1) LEFT JOIN : 두 테이블 중 왼쪽에 기술된 테이블을 기준으로 JOIN    
SELECT 
	emp_name,
    dept_title,
    salary,
    salary*12
FROM employee 
	LEFT JOIN department ON(dept_code = dept_id);

-- 2) RIGHT JOIN : 두 테이블 중 오른쪽에 기술된 테이블을 기준으로 JOIN
SELECT 
	emp_name,
    dept_title,
    salary,
    salary*12
FROM employee 
	RIGHT JOIN department ON(dept_code = dept_id);

-- 3) FULL JOIN : 두 테이블이 가진 모든 행을 조회 가능 MySQL X 

/*
	3. 비등가 조인 (NON EQUAL JOIN)
    - 매칭시킬 컬럼에 대한 조건작성시 '=' 등호를 사용하지 않는 조인문
    - 값의 범위에 포함되는 행들을 연결하는 방식 
    - ANSI 구문으로는 JOIN ON만 사용가능! (USING 사용 불가) 
*/

SELECT * -- salary와 연관 추측 
FROM  employee;

SELECT * -- 급여 등급 테이블 : sal_level, min_sal, max_sal -> salary와 연관
FROM  sal_grade;

-- 사원명, 급여, 급여 레벨 조회 
SELECT 
	emp_name,
    salary,
    sal_level
FROM employee
	JOIN sal_grade ON( min_sal <= salary and salary <= max_sal)
ORDER BY 3  ;

/*
	4. 자체 조인(SELF JOIN)
    - 같은 테이블을 다시 한번 조인하는 경우(자기 자신과 조인)
*/
SELECT * FROM employee;

SELECT 
	e.emp_id 사번,
	e.emp_name 이름,
    ifnull(e.dept_code, '부서없음') 부서,
    ifnull(e.manager_id, '사수없음' )사수사번,
    m.emp_name 사수이름,
    m.dept_code 사수부서
FROM employee e
	left join employee m ON(e.manager_id = m.emp_id) ;

/*
	5. 카테시안곱(CARTESIAN PRODUCT) / 교차 조인(CROSS JOIN)
    - 조인되는 모든 테이블의 각 행들이 서로서로 모두 매핑된 테이터가 검색된다. (곱집합)
    - 두 테이블의 행들이 모두 곱해진 행들의 조합이 출력 -> 방대한 데이터 출력 -> 과부화 위험!
*/
-- 사원명: employee.emp_name, 부서명 : departmen.dept_title
-- >> where
SELECT emp_name, dept_title
FROM employee, department;

-- >> ANSI 구문
SELECT emp_name, dept_title
FROM employee 
	CROSS JOIN department ;
-- 모든 행을 곱해서 쓸모도없고 과부화만 걸림 

/*
	6. 다중 JOIN
    - 여러개의 테이블을 조인하는 경우 
*/

-- 사번 사원명 부서명 직급명
SELECT * FROM employee; -- emp_id, emp_name, dept_code ,job_code
SELECT * FROM department; --  dept_title      dept_id
SELECT * FROM job; --  job_name                         job_code

SELECT 
	emp_id,
    emp_name,
    dept_title,
    job_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN job USING(job_code);
    
-- 실습 문제 ---
-- 1. 직급이 대리면서 ASIA 지역에서 근무하는 직원들의 사번, 직원명, 직급명, 부서명, 근무지역 ,급여 조회

SELECT 
	emp_id,
    emp_name,
    job_name,
    dept_title,
    local_name,
    salary
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN job USING(job_code)
    JOIN location ON ( location_id= local_code)
WHERE job_name = "대리" and local_name LIKE '%ASIA%';


-- 2. 70년대 생이면서 여자이고, 성이 전씨인 직원들의 직원명, 주민번호,부서명, 직급명 조회

SELECT 
    emp_name,
    emp_no,
    dept_title,
    job_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN job USING(job_code)
WHERE emp_name LIKE '전%' and emp_no LIKE '7%' and substr(emp_no, 8, 1) = 2;


-- 3. 보너스를 받은 직원들의 직원명, 보너스, 연봉, 부서명, 근무지역 조회 
SELECT 
    emp_name,
    bonus,
    format(((salary*ifnull(bonus, 0))+salary)*12,0) 연봉,
    dept_title,
    local_name
    
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN job USING(job_code)
    JOIN location ON ( location_id= local_code)
WHERE bonus is not null;


-- 4. 한국과 일본에서 근무하는 직원들의 직원명, 부서명, 근무지역, 근무국가 조회
SELECT 
    emp_name,
    dept_title,
    local_name,
    national_name
FROM employee
	JOIN department ON (dept_code = dept_id)
	JOIN location ON ( location_id= local_code)
    JOIN national using(national_code)
WHERE national_name in ('한국', '일본');

-- 5. 각 부서별 평균 급여를 조회하여 부서명, 평균급여 조회 

SELECT 
	ifnull(dept_title ,'부서 X'),
    format(avg(salary*(ifnull(bonus, '0'))+salary),0) "각 부서별 평균급여"
FROM employee 
	LEFT JOIN department ON(dept_code = dept_id)
GROUP BY dept_title
ORDER BY 2 DESC;

-- 6. 각 부서별 총 급여의 합이 1000만원 이상인 부서명, 급여 합 조회 
SELECT 
	dept_title,
    format(sum(salary),0) "각 부서별 급여합"
FROM employee 
	LEFT JOIN department ON(dept_code = dept_id)
GROUP BY dept_title 
HAVING sum(salary) >= 10000000
ORDER BY sum(salary) DESC;

 
-- 7. 사번, 직원명, 직급명, 급여등급, 구분조회 
-- 이때 구분에 해당하는 값은 급여등급이 S1,S2 = 고급 3,4 는 중급 5,6은 초급
SELECT 
	emp_id,
    emp_name,
    job_name,
    if (sal_level = 'S1'or sal_level = 'S2', '고급', 
		if (sal_level = 'S3'or sal_level = 'S4', '중급',
			if (sal_level = 'S5'or sal_level = 'S6', '초급' , ''))) 급여등급
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN job USING(job_code)
	JOIN sal_grade ON (min_sal <= salary and salary <= max_sal);
    

-- 8. 보너스를 받지 않는 직원들 중 직급코드가 J4 or J7 인 직원들의 직원명 , 직급명, 급여 조회
SELECT 
    emp_name,
    job_name,
    salary
FROM employee
    JOIN job USING(job_code)
WHERE (bonus is null) and (job_code = 'J4' or job_code = 'J7'); 


-- 9. 부서가 있는 직원들의 직원명, 직급명, 부서명, 근무지역 조회 
SELECT 
    emp_name,
    job_name,
    dept_title,
    local_name
FROM employee
	JOIN department ON(dept_code = dept_id)
    JOIN job USING(job_code)
    JOIN location ON ( location_id= local_code)

WHERE dept_title is not null;


-- 10. 해외 영업팀에 근무하는 직원들의 직원명, 직급명, 부서코드, 부서명 조회 

SELECT 
    emp_name,
    job_name,
    dept_code,
    dept_title
FROM employee
	JOIN department ON(dept_code = dept_id)
    JOIN job USING(job_code)
    JOIN location ON ( location_id= local_code)
WHERE dept_title LIKE '해외영업%';


-- 11. 이름에 '형' 이 들어있는 직원들의 사번 직원명 직급명 조회 
SELECT 
	emp_id,
    emp_name,
    job_name
FROM employee
    JOIN job USING(job_code)
    
WHERE emp_name LIKE '%형%';

-- 12. 사번,사원명,부서명,직급명,지역명,국가명,급여등급 조회 

SELECT 
	emp_id,
    emp_name,
    dept_title,
    local_name,
    national_name,
    sal_level
FROM employee
	LEFT JOIN department ON(dept_code = dept_id)
    LEFT JOIN job USING(job_code)
    LEFT JOIN location ON ( location_id= local_code)
    LEFT JOIN national using(national_code)
    LEFT JOIN sal_grade ON (min_sal <= salary and salary <= max_sal);

    


