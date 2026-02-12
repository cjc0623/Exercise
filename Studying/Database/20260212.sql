-- 조건 함수 DECODE : DECODE(표현식, search1, result1, search2, result2,.... 35개 까지 나열, default_result)

SELECT
    sysdate
FROM
    dual;

SELECT
    employee_id,
    first_name
    || ' '
    || last_name "이름",
    decode(
        round((sysdate - hire_date) / 365),
        10,
        '10년 근속함',
        15,
        '15년 근속함',
        20,
        '20년 근속함',
        round((sysdate - hire_date) / 365)
    )            "근속년수"
FROM
    employees;
    
    

/* 
CASE : 얘는 함수보다는 표현식에 가까움.. DECODE 보다 좀 더 확장된 형태의 조건을 나열할 수 있음.

case 대상값 when 비교값 then 처리1,
          when 비교값 then 처리2,
........... else 디폴트 처리
END
*/

INSERT INTO caseex VALUES ( 'd',
                            'ddd',
                            'm' );

SELECT
    *
FROM
    caseex;

SELECT
    c_id,
    c_name,
    decode(gender, 'm', '남성', 'f', '여성') decode_gender,
    CASE gender
        WHEN 'm' THEN
            '남성'
        WHEN 'f' THEN
            '여성'
        ELSE
            ''
    END                                  case_gender
FROM
    caseex;



-- distinct : 중복 제거 키워드.. 컬럼의 중복데이터를 제거 해서 하나의 데이터만 표현해준다.
-- null은 제외한다.

SELECT DISTINCT -- 중복된 데이터를 한개만 남기고 모두 제거한 모든 데이터를 보여줌
    department_id
FROM
    employees;

SELECT ALL -- 중복된 데이터 포함 모든 데이터를 보여줌
    department_id
FROM
    employees;



-- 집계함수인 count
-- count([distinct, all]) : 갯수를 집계해서 리턴하는 함수.

-- 전체 사원의 명 수를 구해보자
SELECT
    COUNT(*)
FROM
    employees;
    
    
    

SELECT
    COUNT(DISTINCT employee_id),
    COUNT(DISTINCT first_name)
FROM
    employees;

SELECT
    COUNT(department_id),
    COUNT(DISTINCT department_id)
FROM
    employees;



-- sum([distinct, all]);
-- 모든 사원의 총 월급 합계를 구해보세요.
SELECT
    SUM(salary)
FROM
    employees;

-- 같은 급여를 받는 사람을 제외한 sum 을 구해보세요.
SELECT
    SUM(DISTINCT salary)
FROM
    employees;



-- min max
SELECT
    MAX(salary),
    MIN(salary)
FROM
    employees;

-- 최대 급여를 받는 사람과, 최소 급여를 받는 사람의 id, 이름을 조회해보세요.
SELECT
    employee_id,
    first_name || last_name "성명",
    salary
FROM
    employees
WHERE
    salary = (
        SELECT
            MAX(salary)
        FROM
            employees
    )
    OR salary = (
        SELECT
            MIN(salary)
        FROM
            employees
    );

SELECT
    employee_id,
    first_name || last_name "성명",
    salary
FROM
    employees
WHERE
    MAX(salary) -- where 절에는 그룹 함수는 허가하지 않음  따라서 오류 발생
    ;
    
    
    
    
-- avg([distinct]) : 평균
-- 급여의 평균 구하기
SELECT
    AVG(salary)
FROM
    employees;



-- GROUP BY 절 : ROW 를 같은 값을 가진 그룹으로 묶은 후 조회에 사용하는 쿼리입니다.
-- 이때 같이 사용하는게 집계 함수들입니다.(MAX, MIN, COUNT, SUM, AVG 등)
-- Group by 절은 from 절 다음에 위치합니다.
SELECT
    department_id
FROM
    employees
GROUP BY
    department_id;
    
    
-- 부서별로 급여 총액을 구해보세요.
SELECT
    department_id,
    SUM(salary)
FROM
    employees
GROUP BY
    department_id;
    
    
-- 부서별 사원 수, 평균 급여를 구해보세요.
SELECT
    department_id,
    round(avg(salary)),
    COUNT(employee_id)
FROM
    employees
GROUP BY
    department_id;
    
    
-- SELECT 절에서 GROUP BY 절을 사용시에는, SELECT 리스트에 있는 항목 중 집계 함수를 제외하고는
-- 모든 항목이 GROUP BY 절에 명시되어야 합니다. 꼭 기억하세요.


-- 위 쿼리를 기준으로 부서별, 직급별(job_id), 월급 내역을 조회해보세요.
SELECT
    department_id,
    job_id,
    SUM(salary)
FROM
    employees
GROUP BY
    department_id,
    job_id
ORDER BY
    department_id,
    job_id;



-- group by where : 그룹을 묶은 후에 조건을 나열할 수 있음...
/*
SELECT 
    FROM 
WHERE 
GROUP BY 
ORDER BY
*/

-- 월 급여가 가장높은 부서의 총 급여액, 평균값을 구해보세요.

SELECT
    job_id,
    SUM(salary),
    round(avg(salary))
FROM
    employees
WHERE
    department_id = 90
GROUP BY
    job_id
ORDER BY
    job_id;



-- 현재 어느 부서에 몇 명의 사원들이 속해서 근무하고 있는지를 조회하라.
-- 부서를 기준으로 정렬시키세요.
SELECT
    department_id,
    COUNT(*)
FROM
    employees
WHERE
    department_id IS NOT NULL
GROUP BY
    department_id
ORDER BY
    department_id;
     
     
     
-- 위 쿼리를 기준으로 부서에 소속된 사원 수가 5명 미만인 부서만 조회하라
SELECT
    department_id,
    COUNT(*)
FROM
    employees
WHERE
    department_id IS NOT NULL
GROUP BY
    department_id
-- 그룹으로 묶인 데이터에 그룹 조건을 사용시에는 반드시 having 을 사용해야 합니다.     
HAVING
    COUNT(*) < 5
ORDER BY
    department_id;
    
    

-- Sub Query : 쿼리에 쿼리를 넣는것.. 국제 표준이므로 잘 알고 있어야 함.
-- 전체 사원들 중 평균 급여보다 낮은 급여를 받는 사원들의 명단을 알고 싶다....
SELECT -- main query
    employee_id,
    first_name || last_name "성명"
FROM
    employees
WHERE
    salary < (
        SELECT -- sub query
            round(avg(salary))
        FROM
            employees
    );

SELECT
    *
FROM
    employees;

-- 주(state) 가 없는 도시에 위치한 부서의 모든 정보를 조회하라.

SELECT
    *
FROM
    departments
WHERE
    location_id IN (
        SELECT
            location_id
        FROM
            locations
        WHERE
            state_province IS NULL
    );
    
    
-- 서브쿼리의 결과가 단일 ROW, 단일 COL인 경우
-- 대부분 집계 함수가 포함된 경우가 많음.. 이러한 경우는 보통 은 where 절에 조건의 비교값으로
-- 사용되는 경우가 대부분임. 같이 사용되는 연산자도 <,>,= ..... 등 일반 연산자를 많이 사용함.


-- 월급을 가장 많이 받는 사원의 정보와 직급명을 출력하세요.
SELECT
    emp.*,
    job_title
FROM
    employees emp,
    jobs      j
WHERE
        emp.salary = (
            SELECT
                MAX(salary)
            FROM
                employees
        )
    AND emp.job_id = j.job_id;


-- 평균 월급보다 많은 급여를 받는 사원들을 조회하라.
SELECT
    *
FROM
    employees
WHERE
    salary > (
        SELECT
            round(avg(salary))
        FROM
            employees
    );


-- 미국 내에서 근무하는 사원들에 대한 평균 급여보다 많은 급여를 받는 사원들의 정보를 조회하라
SELECT
    *
FROM
    employees
WHERE
    salary > (
        SELECT
            round(avg(salary))
        FROM
            employees   emp,
            departments dept,
            locations   loc
        WHERE
                emp.department_id = dept.department_id
            AND dept.location_id = loc.location_id
            AND country_id = 'US'
    );
    
    
-- 이처럼 단일 컬럼, 단일 로우ㅡㄹ 리턴하는 서브쿼리는 아래의 절에도 올 수 있다.
-- from 절, select, order by 절, having 절....


-- 다중 로우, 단일 컬럼을 리턴하는 서브쿼리에 대해서 알아봅니다.
-- 부서가 30번인 사원들의 월급을 조회하라.
SELECT
    salary
FROM
    employees
WHERE
    department_id = 30;

-- 위 결과를 기준으로 이 사원들 보다 급여를 많이 받은 사원들의 정보를 조회하세요. any / all
SELECT
    salary,
    first_name
FROM
    employees
WHERE
    salary > ANY (
        SELECT
            salary
        FROM
            employees
        WHERE
            department_id = 30
    );


-- 평균 급여보다 높고 최대 급여보다 낮은 워급을 받는 사원 리스트를 작성하라.

SELECT
    first_name,
    salary
FROM
    employees
WHERE
        salary > (
            SELECT
                AVG(salary)
            FROM
                employees
        )
    AND salary < (
        SELECT
            MAX(salary)
        FROM
            employees
    );

SELECT
    *
FROM
    employees a,
    (
        SELECT
            AVG(salary) avgs,
            MAX(salary) maxs
        FROM
            employees
    )         b
WHERE
    a.salary BETWEEN b.avgs AND b.maxs
ORDER BY
    a.salary DESC;
    
    
    
-- 월급을 가장 많이 받는 사원 중 상위 10명만 리스트업 해보자

SELECT
    *
FROM
    (
        SELECT
            first_name,
            salary
        FROM
            employees
        ORDER BY
            salary DESC
    )
WHERE
    ROWNUM < 11;