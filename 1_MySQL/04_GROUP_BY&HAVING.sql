

/*
	GROUP BY
    - 그룹 기준을 제시할 수 있는 구문 
    - 여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용 
*/
-- 각 부서별 조회 
SELECT dept_code, 
	count(*) "부서별 사원수",
   format(sum(salary),0) "부서별 직원들의 총 급여",
    format(avg(salary),0) "부서별 직원들의 평균 급여",
    min(salary) "각부서별 최저급여",
    max(salary) "각부서별 최고급여"
FROM employee
GROUP BY dept_code;

-- 직급코드 별 사원수 조회 

-- GROUP BY로 묶을시 그룹함수 OR 묶은 컬럼만 셀렉트에 가능 
SELECT job_code,
	count(emp_name) "직급별 사원수",
     format(avg(salary),0) '직급별 평균 월급'
FROM employee
GROUP BY job_code;

-- 성별별 사원수 조회 
SELECT if ((substr(emp_no, 8, 1) = 1), '남자' , '여자' ) "성별" , count(*) "인원수"
FROM employee
GROUP BY 성별;

/*
	HAVING
	- 그룹에 대한 조건을 제시할 때 사용하는 구문 
    
    5 SELECT   *| 조회하고자 하는 컬럼명 as 별칭 | 함수
    1 FROM 	 조회하고자 하는 테이블명 
    2 WHERE	 조건식 (연산자들 가지고 기술)
    3 GROUP BY 그룹 기준에 해당하는 컬럼명 | 함수
    4 HAVING	 조건식 (그룹 함수를 가지고 기술)
    6 ORDER BY 컬럼명 | 컬럼순번 | 별칭 [ ASC | DESC ]
    7 LIMIT    최대 출력하고 싶은 숫자
*/

-- 부서별 평균 급여가 300만원 이상인 부서의 평균급여 조회 
SELECT dept_code 부서코드, 
	format(avg(salary),0) "부서평균급여"
FROM employee
GROUP BY dept_code
HAVING avg(salary) >= 3000000 ;

-- 직급별 총 급여의 합이 1000만 이상인 직급만 조회
SELECT 
	job_code 직급 ,
    sum(salary) 직급별총급여
FROM employee
GROUP BY job_code
HAVING sum(salary) >= 10000000 ;

-- 부서별 보너스를 받는 사원이 없는 부서만 조회
SELECT 
	dept_code 부서 ,count(bonus)
FROM employee
GROUP BY dept_code
HAVING count(bonus) = 0;


-- 부서별 보너스를 받는 사원들의 수 조회 8 9 1 6 1 5

SELECT
	dept_code 부서, count(bonus) 
FROM employee
GROUP BY dept_code
HAVING count(bonus) != 0;
-- 위는 그룹함수에 조건거는거라 HAVING

SELECT dept_code 부서, 
	count(*)  -- 보너스가 null이 아닌경우 
FROM employee
WHERE bonus is not null
GROUP BY dept_code;
-- 아래는 그룹함수가 아닌거에 조건거는거라 WHERE

/*
	rollup|cube(컬럼1, 컬럼2) (cube는 MySQL에서 X) - 실제 볼일은 없는 집계 함수
    - 그룹별 산출한 결과 값의 중간 집계를 계산 해주는 함수 
    - rollup : 컬럼1을 가지고 다시 중간집계를 내는 함수 
    - cube : 컬럼 1을 가지고 중간 집계도 내고, 컬럼2를 가지고 중간집계를 냄 
    
    MySQL 에서의 rollup
    컬럼1, 컬럼2 with rollup 
    
    grouping : rollup이나 cube에 의해 산출된 값이 해당 컬럼의 집합의 산출물이면 0, 아니면 1
    -> 집계된 값인지, 아닌지 정도만 구분 
    
    SQLD 자격증 시험에서 꼭 이상하게 나오지만 실제 사용 X     
*/
-- 부서별, 직급별 급여 합 조회 
SELECT dept_code , 
	job_code,
	sum(salary)
FROM employee
GROUP BY dept_code, job_code
	with rollup;

/*
	집합 연산자 
    - 여러 개의 쿼리문을 하나의 쿼리문으로 만드는 연산자 
    - 여러개의 쿼리문에서 조회하려고 하는 컬럼의 개수와 이름이 같아야 사용할 수 있다.
    
    주의! ORDER BY 절은 쓸때 마지막에만 기술 가능 
    
    UNION (합집합) : 두 쿼리문을 수행한 결과값을 하나로 합쳐서 추출 (중복되는 행 제거)
    UNION ALL (합집합) : 두 쿼리문을 수행한 결과값을 하나로 합쳐서 추출(중복되는 행 제거 X)
	INTERSECT (교집합) : 두 쿼리문을 수행한 결과값에 중복된 결과값을 추출 (MySQL X)
    MINUS (차집합) : 선행 쿼리문의 결과값에서 후행 쿼리문의 결과값을 뺀 나머지 결과값만 추출 (MySQL X)
    
    UNION,UNION ALL은 WHERE 절에서 or 연산자로 처리가능 
    INTERSECT,MINUS는 WHERE 절에서 and 연산자로 처리가능
*/
-- 1.NUION
-- 부서 코드가 D5인 사원들의 사번 사원명 부서코드 급여 조회

SELECT emp_id 사번,
    emp_name 이름,
    dept_code 부서코드,
    format(salary ,0) 급여
FROM employee
WHERE dept_code = 'D5'
-- 세미클론 사이에 넣으면댐 
UNION
-- 급여가 300만원 초과인 사원들의 사번 사원명 부서코드 급여 조회
SELECT emp_id 사번,
    emp_name 이름,
    dept_code 부서코드,
    format(salary ,0) 급여
FROM employee
WHERE salary > 3000000
ORDER BY 1;

-- 2. UNION ALL

SELECT emp_id 사번,
    emp_name 이름,
    dept_code 부서코드,
    format(salary ,0) 급여
FROM employee
WHERE dept_code = 'D5'
-- 세미클론 사이에 넣으면댐 
UNION ALL
-- 급여가 300만원 초과인 사원들의 사번 사원명 부서코드 급여 조회
SELECT emp_id 사번,
    emp_name 이름,
    dept_code 부서코드,
    format(salary ,0) 급여
FROM employee
WHERE salary > 3000000
ORDER BY 1;

-- 아래 문구와 UNION이 같아서 안씀그냥
-- 위 쿼리문 대신 WHERE에 or 넣으면 끝 
SELECT emp_id 사번,
    emp_name 이름,
    dept_code 부서코드,
    format(salary ,0) 급여
FROM employee
WHERE salary > 3000000 or dept_code ='D5'
ORDER BY 1;


















