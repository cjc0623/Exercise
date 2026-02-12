-- 부서 코드만 조회해 볼게요
select department_id from departments;

select Employee_id, department_id from employees where employee_id = 178;

-- Update 테이블명 SET 컬럼명 = 값 where[조건]...

Update employees 
    SET department_id = 280 -- 외래키 위반
where employee_id = 178;

-- Delete from tableName where 조건...

Delete from departments where department_id = 10;

-- check 제약 조건 : 데이터가 입력되는 시점에 일정한 값을 체크하여 조건에 해당하는 값만 입력될 수 있도록 하는 제약임




-- VIEW : 특정 테이블의 결과셋이나, 부분셋을 뷰로 생성한 후 특정 사용자에게 오픈하여 사용토록 하는 일종의
-- 가상 테이블이다. 이렇게 하므로써. 원본 테이블의 손상을 막고, 필요한 사용자에게 데이터를 오픈 할 수 있는
-- 장점이 생긴다.

-- 생성문법 : create [or replace] View viewNAME Select 문장

Select * from EMP_DETAILS_VIEW;

Create OR REPLACE VIEW v_emp1 AS
-- firstname, lastname, email, hire_date 를 추출하는데
-- 사원테이블에서 추출합니다. 단 부서가 20번인 경우만 추출합니다.
    SELECT first_name,last_name,email,hire_date FROM EMPLOYEES WHERE department_ID = 20;
    
SELECT * FROM v_emp1; 

-- 부서 번호가 10,20,50 번 사원들의 모든 정보를 추출해서 v_emp1 이란 뷰로 생성하라
CREATE OR REPLACE VIEW v_emp1 AS
    SELECT * FROM EMPLOYEES WHERE department_ID IN (10,20,50);
    
    
    
    
SELECT employee_id from employees;

create SEQUENCE MYSEQ
    MINVALUE 1
    MAXVALUE 999999999999999
    INCREMENT BY 1
    START WITH 1
    NOCACHE
    NOORDER
    NOCYCLE;
    
-- 시퀀스에는 현재 값과 다음값을 리턴하는 컬럼이 있는데, currval 과 nextval 입니다.
-- 주의 !! 시퀀스를 한번 사용하면, 궈리에 오류가 있다해도 무효화 할 수 없습니다.

-- 프로그래머가 테스트용으로 사용할 수 있는 가상 테이블인 dual 이라는 테이블을 이용,
-- 시퀀스를 시험해봅니다. dual 테이블은 테스트용으로 주로 사용합니다.

Select 10*20 retult from dual;

SELECT MYSEQ.NEXTVAL FROM DUAL;
SELECT MYSEQ.CURRVAL FROM DUAL;

select * from employees where employee_id = 200;

-- employee_seq 를 이용해서 사번이 200번인 사원의 정보를 기준으로 여러분의 정보를 신규 insert 하세요.
-- 단 입사일자(hire_date) 는 sysdate 함수를 사용합니다.

INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id) 
VALUES (EMPLOYEES_SEQ.NEXTVAL, '현민', '최', 'test@naver.com', '123456789', sysdate, 'AD_ASST', 4400, 101,10);

select * from employees;