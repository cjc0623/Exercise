-- 조건절(where) : 데이터를 조회,수정, 삭제, Insert(때에 따라서) 할 때 조건을 나열할 수 있는데, 이 조건은 where 로 표현한다.
-- 조회를 기준으로 Select from where 순으로 나열되미ㅕ, 아래와 같은 구문에서도 사용 가능하다
-- start with, connect by, having .. 이 부분은 나중에 상황되면 확인 예정
-- 조건을 명시할 때는 다양한 연산자를 동반하는데, 다음은 연산자의 종류이다.
-- +,-,*,/,<,>,= 등
-- 컬럼, 숫자나 문자 상수
-- LIKE, IN BETWEEN, EXIST, NOT
-- IS NULL, IS NOT NULL
-- 함수
-- AND, OR, NOT
-- ANY, SOME, ALL

-- 위 연산자등을 이용해서 조건을 나열 할 수 있다.
-- concat 연산자 || 하나 이상의 컬럼을 합쳐서 표현해주는 연산자..

-- 공백이 존재하면 ""으로 묶음.. 만약 공백이 없으면 그냥 적어도 무관함
SELECT
    first_name || last_name "FULL NAME"
FROM
    employees
WHERE
    employee_id = 209;


-- 부서번호가 30번인 사원의 정보를 조회하라
SELECT
    *
FROM
    employees
WHERE
    department_id = 30;

-- 부서번호가 30번인 사원의 정보중 성, 이름을 성명이라는 컬럼으로, salary 는 월급으로, department_id 는 부서번호로 조회하라

SELECT
    first_name || last_name "성명",
    salary                  "월급",
    department_id           "부서번호"
FROM
    employees
WHERE
    department_id = 30;



-- AND 연산자로 조건을 늘릴 수 있음
SELECT
    first_name || last_name "성명",
    salary                  "월급",
    department_id           "부서번호"
FROM
    employees
WHERE
        salary < 10000 -- 월급이 10000 이하인 사원들...
    AND department_id = 30;

-- 위 조건에서 입사 년월이 '1996-01-01' 이후인 사원들의 정보만 추출하라
SELECT
    first_name || last_name "성명",
    salary                  "월급",
    department_id           "부서번호"
FROM
    employees
WHERE
        salary < 10000
    AND department_id = 30
    AND hire_date > '1996-01-01';
    
    
-- 부서번호가 10번 (구매부) 이거나 60번 (IT) 인 사원의 이름, 급여, 부서번호를 추출하라
SELECT
    first_name || last_name "성명",
    salary                  "월급",
    department_id           "부서번호"
FROM
    employees
WHERE
    department_id = 10
    OR department_id = 60;
    
    
-- 구매부서에서 월급이 10000 이하인 사원과 IT 부서에서 월급이 5000 이상인 사원을 조회하라.
SELECT
    first_name || last_name "성명",
    salary                  "월급",
    department_id           "부서번호"
FROM
    employees
WHERE
    ( department_id = 10
      AND salary < 10000 )
    OR ( department_id = 60
         AND salary > 5000 );
         
         
-- 컬럼 BETWEEN 값1 AND 값2 : 컬럼의 값을 값1 과 값2 사이의 값으로 조회한다. >= and <= 와 같다.
-- 사번이 110 ~ 120 사이인 사원의 사번, 성명, 월급, 부서 번호를 조회하라 (Between and 사용)
SELECT
    employee_id             "사번",
    first_name || last_name "성명",
    salary                  "월급",
    department_id           "부서번호"
FROM
    employees
WHERE
    employee_id BETWEEN 110 AND 120; -- 사번이 110 ~ 120 사이인 사람
    

-- 위 조건에서, 월급이 5000 ~ 10000 사이인 사원들을 조회해보세요.
SELECT
    employee_id             "사번",
    first_name || last_name "성명",
    salary                  "월급",
    department_id           "부서번호"
FROM
    employees
WHERE
    ( employee_id BETWEEN 110 AND 120 )
    AND ( salary BETWEEN 5000 AND 10000 );
    
    
-- 사번이 110번 미만이고, 120번 초과인 사원의 정보를 조회해보세요.
SELECT
    employee_id             "사번",
    first_name || last_name "성명",
    salary                  "월급",
    department_id           "부서번호"
FROM
    employees
WHERE
    NOT employee_id BETWEEN 110 AND 120;
--    (employee_id < 110 OR employee_id > 120);


-- 부서번호가 30, 60, 90 인 사원의 정보를 추출하라
SELECT
    *
FROM
    employees
WHERE
    department_id IN ( 30, 60, 90 );
--  department_id = 30 OR department_id = 60 oR department_id = 90;

-- EXISTS : 오직 서브쿼리(결과를 도출하는 하위 쿼리)만을 이용해서 결과를 조건에 매핑하도록 하는 연산자임 
-- 반드시 서브쿼리만 올 수 있음.. 서브쿼리는 나중에 배움
SELECT
    employee_id             "사번",
    first_name || last_name "성명",
    salary                  "월급",
    department_id           "부서번호"
FROM
    employees emp
WHERE
    EXISTS (
        SELECT
            department_id
        FROM
            departments dept
        WHERE
            department_id IN ( 30, 60, 90 )
            AND emp.department_id = dept.department_id
    );
    
    
-- like 연산자 : 특정 패턴을 준비해서 해당 패턴에 데이터가 존재 하는지를 검증해서 결과를 도출하도록 하는 연산자.
-- ex) where full_name like '%동'  => '동' 으로 끝나는 문자열이 존재하는지를 검증함.
-- ex) where full_name like '%동%' => '동' 이 들어가 있는 문자열을 검증함. 이 패턴은 앞뒤 상관없이 '동' 이 있으면 무조건 도출함

SELECT
    employee_id             "사번",
    first_name || last_name "성명",
    salary                  "월급",
    department_id           "부서번호",
    phone_number            "전화번호"
FROM
    employees emp
WHERE
    phone_number NOT LIKE '%515%';

SELECT
    email
FROM
    employees
WHERE
    email LIKE '%S_I%';

SELECT
    *
FROM
    departments;

SELECT
    *
FROM
    locations
WHERE
    state_province IS NOT NULL;

SELECT
    *
FROM
    jobs;

SELECT
    *
FROM
    employees;


-- Inner Join : 관계가 설정된 테이블간의 공통 컬럼을 where 절에서 join 시킨 후
-- select 하는 조인.. 가장 일반적인 조인 형태이다.
-- Inner Join 은 무조건 두 테이블 사이에 서로 연결될 수 있는 데이터를 가진 기둥이 양쪽이 다 가지고 있어야 한다.
SELECT
    first_name,
    last_name,
    dept.department_id,
    dept.department_name,
    emp.job_id
FROM
    employees   emp,
    departments dept,
    jobs        jobs
WHERE
        emp.department_id = dept.department_id
    AND emp.job_id = jobs.job_id;
    
    
-- 어떤 도시(city)에서 근문하는지도 알고 싶다.
SELECT
    first_name,
    last_name,
    dept.department_id,
    dept.department_name,
    emp.job_id,
    loc.city
FROM
    employees   emp,
    departments dept,
    jobs        jobs,
    locations   loc
WHERE
        emp.department_id = dept.department_id
    AND emp.job_id = jobs.job_id
    AND dept.location_id = loc.location_id
--    AND loc.state_province = 'California'
    ;

SELECT
    ROWNUM,
    employee_id
FROM
    employees
WHERE
    ROWNUM < 5;

-- 사원별로 매니저가 누군지 알아보는 쿼리를 만들어보세요.
-- 셀프 조인
SELECT
    emp.employee_id,
    emp.first_name || emp.last_name         "사원 이름",
    manager.manager_id,
    manager.first_name || manager.last_name "매니저 이름"
FROM
    employees emp,
    employees manager
WHERE
    emp.manager_id = manager.employee_id;
    

-- 부서 데이블에서 봄베이(2100) 에 위치한 부서 이외에 모든 부서에 속한 사원의 정보를 추출하시오.
SELECT
    *
FROM
    employees
WHERE
    department_id IN (
        SELECT
            department_id
        FROM
            departments
        WHERE
            NOT location_id = 2100
    );

SELECT
    emp.employee_id,
    emp.last_name
FROM
    employees emp
WHERE
    emp.department_id NOT IN (
        SELECT
            dept.department_id
        FROM
            departments dept, locations loc
        WHERE
                dept.location_id = loc.location_id
            AND loc.city = 'Bombay'
    );
    

-- 모든 사원의 이름, 부서코드, 부서명을 조회하라.
SELECT
    emp.first_name || emp.last_name "성명",
    emp.department_id               "부서 코드",
    dept.department_name            "부서 이름"
FROM
    employees   emp,
    departments dept
WHERE
    emp.department_id = dept.department_id;
    

select count(*) from employees;

-- 조인에 참여하지 않은 ROW 가 하나 있다는 말임
select * from employees where department_id is NUll;

-- Outer Join(외부 조인) : 조인시 조인에 참여하지 않는 ROW 도 필요에 따라서 조인 조건에 참여 시켜야 한다.
-- 이때 사용하는 조인이다. 우리가 지금 하는 조인은 모두 오라클에서만 지원하는 조인이다.(ANSI JOIN 은 국제 표준임)
-- 따라서 오라클에서만 사용되는 문법이니 구분짓도록 하낟.
-- 조인에 미참여한느 ROW 에 대해선느 데이터를 모두 가지고 있는 컬럼에 (+) 붙여주면 join에 참여하게 된다.
-- 조인에 참여는 하지만, 즉 ROW 는 도출이 되지만, 데이터는 여전히 null 로 되어진다.
SELECT
    emp.employee_id,
    emp.first_name || emp.last_name "성명",
    emp.department_id               "부서 코드",
    dept.department_name            "부서 이름"
FROM
    employees   emp,
    departments dept
WHERE
    emp.department_id = dept.department_id(+)
ORDER by emp.employee_id asc; -- desc 는 내림차순

-- 여기에 부서가 위치한 도시명도 알 수 있도록 쿼리를 추가해보자

SELECT
    emp.employee_id,
    emp.first_name || emp.last_name "성명",
    emp.department_id               "부서 코드",
    dept.department_name            "부서 이름",
    loc.city
    
FROM
    employees   emp,
    departments dept,
    locations loc
WHERE
    emp.department_id = dept.department_id(+)
AND dept.location_ID = loc.location_id(+)
    
ORDER by emp.employee_id asc;



select * from job_history;

-- 모든 사원을 조회하는데, 직책변동 기록이 있는 사원이라면, 그 변동 내역까지 조회하는 쿼리를 작성해보자.

select * from employees emp, job_history his
where emp.employee_id = his.employee_id(+);


-- ANSI JOIN : 국제 표준 조인 방식입니다. 앞으로 여러분이 할 스프링부트에서는 이 조인방식을 사용하니 잘 이해 바랍니다.
-- Inner Join(내부 조인) : 공통되는 컬럼을 기준으로 조인을 하는 방식을 말합니다.
-- 문법은 두 가지가 있는데, 편한 것을 사용하세요.

-- 1.
SELECT
    *
FROM
    employees  emp,
    departments dept
WHERE
    emp.department_id = dept.department_id; -- 오라클 inner join

-- 2.
SELECT
    emp.employee_id, emp.first_name, dept.department_id
FROM
         employees emp
    INNER JOIN departments dept ON emp.department_id = dept.department_id;
    
    
-- USING 사용 예시
SELECT
    emp.employee_id, emp.first_name, dept.department_name, department_id
FROM
         employees emp
    INNER JOIN departments dept
USING(department_id);




select * 
    from employees emp, job_history job
where emp.employee_id = job.employee_id(+)
order by job.employee_id;

-- 위 조인은 Left Outer JOIN (ANSI) 로 변경하면 다음처럼 됨. left/right/full
select job.employee_id, emp.first_name
    from employees emp left outer join job_history job
on emp.employee_id = job.employee_id
order by job.employee_id; -- order by : 정렬할 때 사용 default 는 asc로 오름차순, desc는 내림차순



-- 문자형 함수
select concat('a','b') from dual; -- concat : 두 개의 문자열을 연결 || 와 같음

select initcap('ABCDE') from dual; -- initcap : 단어의 첫 글자를 대문자로 나머지 글자를 소문자로 변환

select lower('ABCD') from dual; -- lower : 대문자를 솜누자로 변환

select LPAD('abc', 7) from dual; --전체 7자리 중에서 오른 쪽 끝에 abc를 두고 남은 왼쪽 4자리를 공백으로 채움

select LPAD('abc', 7, '#') from dual; -- abc를 #로 변환



select salary, employee_id, first_name, salary * commission_pct
    from employees
where salary * commission_pct < 1000;

-- NVL(컬럼, 대체값)
select salary, employee_id, first_name, salary * NVL(commission_pct, 0) -- 커미션이 NULL 이면 0으로 바꿔서 계산
    from employees
where salary * NVL(commission_pct,0) < 1000;


/*
 NVL2(표현식1, 표현식2, 표현식3) : 표현식1 이 NULL 이면 표현식3 을 아니면 표현식 2 를 반환하는 함수
 NVL 을 확장한건데, 3항 연산자라고 생각하면 됨.
*/

select employee_id, first_name, salary,
    salary + salary * commission_pct total_salary1,
    NVL2(commission_pct, salary+(salary*commission_pct), salary) total_salary2 
    -- 커미션이 있으면 salary+(salary*commission_pct) 반환 null 이면 salary 반환
    from employees;