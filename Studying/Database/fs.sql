-- CRUD : Create(개체를 생성하고), Record(데이터를 조회하고),
-- Update(데이터를 갱신하고), Delete(개체 및 데이터를 삭제)
-- 를 Query 를 통해서 할 수 있는지를 개념

-- 테이블 생성 쿼리 : create table TableName (컬럼명1 datatype, 컬럼명2 datatype,....)

CREATE TABLE chr_exam2 (
    name1 CHAR(3),
    name2 VARCHAR2(3)
);

-- 데이터 생성(ROW 생성) : INSERT into TableName (컬럼명1,2,...) values (z컬럼명1의 값, 2, ...)
-- 반드시 컬럼명과 값의 객수가 같아야 한다.

-- 만약 모든 컬럼에 값을 넣을 경우엔, 컬럼명 부분을 생략할 수 있다.
INSERT INTO chr_exam1 VALUES ( '최',
                               '최' ); -- 문자열은 ''으로 감싸서 값을 처리해야 한다
INSERT INTO chr_exam2 VALUES ( '최현민',
                               '최현민' );

-- 데이터 조회 Select * or 컬럼명1[alias],2,.... from tableName [where(조건)]...

SELECT
    replace(name1, ' ', 'B'),
    replace(name2, ' ', 'B')
FROM
    chr_exam1;

-- 수치형 데이터 Number (정수부, 소수부 크기) : 두개를 합산한 자릿수가 결정됨.
-- 소수부가 생략되면 0 으로 처리함

CREATE TABLE num_temp1 (
    n1 NUMBER, -- 가장 많이 사용됨.
    n2 NUMBER(9),
    n3 NUMBER(9, 2),
    n4 NUMBER(9, 1),
    n5 NUMBER(7),
    n6 NUMBER(7, - 2),
    n7 NUMBER(6),
    n8 NUMBER(3, 5) -- 주의! 마지막 컬럼에는 , 가 존재하지 않음

);

INSERT INTO num_temp1 (
    n1,
    n2,
    n3,
    n4,
    n5,
    n6
) VALUES ( 1234567.89,
           1234567.89,
           1234567.89,
           1234567.89,
           1234567.89,
           1234567.89 );

SELECT
    *
FROM
    num_temp1;

CREATE TABLE date_temp1 (
    date1 DATE
);
    
-- sysdate 는 시스템의 날짜를 가져오는 함수
INSERT INTO date_temp1 ( date1 ) VALUES ( sysdate );

SELECT
    *
FROM
    date_temp1;

-- 컬럼 속성에 대해서 알아봅니다.
-- 테이블 생성시 컬럼에 대한 속성을 정의 할 수 있는데, 이를 무결성 제약조건 이라고 합니다.
-- 이 말은 데이터가 Insert 시 무결성을 유지하도록 하는데 목적을 두고, 특정 무결성 규칙을 적용해서
-- 데이터의 오류를 미연에 방지하고자 함을 뜻합니다.

-- 1. NULL 여부 : 데이터가 반드시 존재해야 한다면 Not Null 제약조건을 컬럼에 선언해서 무결성을 지켜야 합니다.
-- 2. UNIQUE : 데이터의 중복을 방지하는 제약조건
-- 3. 기본키(Primary Key) : 위 1,2 번을 합친 제약조건. 기본적으로 모든 테이블은 PK를 가지도록 설계하는게 좋음

INSERT INTO telbook (
    last_name,
    first_name,
    tel
) VALUES ( '최',
           '현민',
           '123456789' );

SELECT
    *
FROM
    telbook;

CREATE TABLE unique_test2 (
    col1 VARCHAR2(10) PRIMARY KEY,
    col2 VARCHAR2(10) UNIQUE,
    col3 VARCHAR2(10) NOT NULL,
    col4 VARCHAR2(10) NOT NULL
);

INSERT INTO unique_test VALUES ( 'ee',
                                 'ff',
                                 'CC',
                                 'DD' );

SELECT
    *
FROM
    unique_test;

ALTER TABLE unique_test ADD CONSTRAINT "unique_test_PK" PRIMARY KEY ( col1 );
    
    
-- 외래키(Foreign Key) : 테이블간의 연관성을 나타내는 키값
-- 예를 들자면, 모든 사원은 부서에 소속되어 일을 합니다.
-- 사원정보와 부서정보는 서로 다른 Entity 이기 때문에 각각 정보를 관리할 테이블이 생성되어야 합니다.
-- 이때 사원이 특정 부서에 소속되어 있다는걸 사원 테이블에 저장을 해야 테이블 간의 연계(관계)가 이뤄집니다.
-- 이럴때, 부서 테이블의 PK 를 사원 테이블에서 가져다 사용하는 행태를 외래키(Foreign Key) 라고 합니다.

CREATE TABLE check_test (
    gender VARCHAR2(10) NOT NULL
        CONSTRAINT check_gender CHECK ( gender IN ( '남성', '여성' ) )
);

INSERT INTO check_test VALUES ( '중성' );

-- default : 이건 제약은 아니지만, 많이 사용됨.
-- 특정 컬럼의 값을 명시적으로 넣지 않는 경우, 자동으로 기본값이 생성되도록 하는데 있음.
-- 주의 해야할 문법으로는 null or not null 앞에 선언되어야 함...

-- 기존 테이블 또는 개체의 수정을 할때는 alter 라는 명령어를 사용합니다.
-- 아래는 alter 를 사용해서 컬럼의 제약을 수정하고, 컬럼을 새롭게 추가하는 작업을 해봅니다.

ALTER TABLE check_test
    -- 컬럼 수정시엔 MODIFY 키워드 사용함.

 MODIFY
    gender DEFAULT '남성';
    
-- 날짜 컬럼을 추가하고, default 로 시스템의 현재 시간값을 생성하도록 함.
ALTER TABLE check_test
-- 컬럼 및 제약 추가는 ADD
 ADD insert_date DATE DEFAULT sysdate;

ALTER TABLE check_test ADD test VARCHAR2(10) NULL;

SELECT
    *
FROM
    check_test;

-- Default 선언된 컬럼을 제외한 컬럼만 Insert 해본다.
INSERT INTO check_test ( test ) VALUES ( 'aaa' );

SELECT
    *
FROM
    check_test;


-- 테이블 복사.. 기존의 테이블을 그대로 복사하는 문법에 대해 알아봅니다.
-- 조건은 테이블 이름이 중복되지 않게 하고, 데이터까지 모두 복제 하는것입니다.
-- create table "스키마명.테이블명" AS Select 컬럼 리스트, from 원본 테이블명

CREATE TABLE telbook_copy
    AS
        SELECT
            *
        FROM
            telbook;


-- hr 스키마의 Employees 테이블을 복제 하여, Employees_copy 테이블을 생성하라

CREATE TABLE employees_copy
    AS
        SELECT
            *
        FROM
            hr.employees;

CREATE TABLE star_wars (
    episode_id   NUMBER(5, 0) PRIMARY KEY,
    episode_name VARCHAR2(50),
    open_year    NUMBER(5, 0)
);

CREATE TABLE characters (
    character_id   NUMBER(5, 0) PRIMARY KEY,
    character_name VARCHAR2(30 BYTE),
    master_id      NUMBER(5, 0),
    role_id        NUMBER(5, 0),
    email          VARCHAR2(40 BYTE)
);

CREATE TABLE casting (
    episode_id   NUMBER(5, 0) NOT NULL,
    character_id NUMBER(5, 0) NOT NULL,
    real_name    VARCHAR2(30 BYTE),
    CONSTRAINT pk_casting PRIMARY KEY ( episode_id ),
    CONSTRAINT fk_casting_character FOREIGN KEY ( character_id )
        REFERENCES characters ( character_id )
);

INSERT INTO star_wars (
    episode_id,
    episode_name,
    open_year
) VALUES ( '4',
           '새로운 희망(A New Hope',
           '1977' );

INSERT INTO star_wars (
    episode_id,
    episode_name,
    open_year
) VALUES ( '5',
           '제국의 역습(The Empire Strikes Back)',
           '1980' );

INSERT INTO star_wars (
    episode_id,
    episode_name,
    open_year
) VALUES ( '6',
           '제다이의 귀환(Return of the Jedi)',
           '1983' );

INSERT INTO star_wars (
    episode_id,
    episode_name,
    open_year
) VALUES ( '1',
           '보이지 않는 위험(The Phantom Menace)',
           '1999' );

INSERT INTO star_wars (
    episode_id,
    episode_name,
    open_year
) VALUES ( '2',
           '클론의 습격(Attack of the Clones)',
           '2002' );

INSERT INTO star_wars (
    episode_id,
    episode_name,
    open_year
) VALUES ( '3',
           '시스의 복수(Revenge of the Sith)',
           '2005' );

COMMIT;

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 1,
           '루크 스카이워커',
           'luke@jedai.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 2,
           '한 솔로',
           'solo@alliance.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 3,
           '레이아 공주',
           'leia@alliance.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 4,
           '오비완 케노비',
           'Obi-Wan@jedai.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 5,
           '다쓰 베이더',
           'vader@sith.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 6,
           '다쓰 베이더(목소리)',
           'vader-voice@alliance.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 7,
           'C-3PO',
           'c3po@alliance.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 8,
           'R2-D2',
           'r2d2@alliance.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 9,
           '츄바카',
           'Chewbacca@alliance.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 10,
           '랜도 칼리시안',
           'Chewbacca@alliance.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 11,
           '요다(목소리)',
           'yoda@jedai.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 12,
           '다스 시디어스',
           NULL );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 13,
           '아나킨 스카이워커',
           'Anakin@jedai.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 14,
           '콰이곤 진',
           NULL );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 15,
           '아미달라 여왕',
           NULL );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 16,
           '아나킨 어머니',
           NULL );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 17,
           '자자빙크스(목소리)',
           'jaja@jedai.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 18,
           '다스 몰',
           NULL );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 19,
           '장고 펫',
           NULL );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 20,
           '마스터 윈두',
           'windu@jedai.com' );

INSERT INTO characters (
    character_id,
    character_name,
    email
) VALUES ( 21,
           '듀크 백작',
           'dooku@jedai.com' );

COMMIT;

create table ROLES(
    ROLE_ID NUMBER(5,0) NOT NULL,
    ROLE_NAME VARCHAR2(50 byte),
    CONSTRAINT ROLES_PK PRIMARY KEY (ROLE_ID));

INSERT INTO ROLES(ROLE_ID, ROLE_NAME) VALUES ('1001','제다이');
INSERT INTO ROLES(ROLE_ID, ROLE_NAME) VALUES ('1002','시스');
INSERT INTO ROLES(ROLE_ID, ROLE_NAME) VALUES ('1003','반란군');

COMMIT;

ALTER table CHARACTERS
--    제약 추가를 위한 키워드
    ADD CONSTRAINT CHARACTERS_FK FOREIGN KEY (ROLE_ID)
    REFERENCES ROLES(ROLE_ID);
    
UPDATE CHARACTERS
    SET ROLE_ID = 1001
    WHERE character_id IN (1,4,11,13,14,20,21);
    
UPDATE CHARACTERS
   SET ROLE_ID = 1002
 WHERE CHARACTER_ID IN (5, 6, 12, 18);

UPDATE CHARACTERS
   SET ROLE_ID = 1003
 WHERE CHARACTER_ID IN (2, 3, 7, 8, 9);

COMMIT;

UPDATE CHARACTERS
   SET MASTER_ID = 4
 WHERE CHARACTER_ID = 13;
 
UPDATE CHARACTERS
   SET MASTER_ID = 4
 WHERE CHARACTER_ID = 1;
 
UPDATE CHARACTERS
   SET MASTER_ID = 11
 WHERE CHARACTER_ID = 20; 
 
UPDATE CHARACTERS
   SET MASTER_ID = 11
 WHERE CHARACTER_ID = 21;  
 
UPDATE CHARACTERS
   SET MASTER_ID = 12
 WHERE CHARACTER_ID = 5;  

UPDATE CHARACTERS
   SET MASTER_ID = 12
 WHERE CHARACTER_ID = 18;  
 
UPDATE CHARACTERS
   SET MASTER_ID = 14
 WHERE CHARACTER_ID = 4;  
 
UPDATE CHARACTERS
   SET MASTER_ID = 21
 WHERE CHARACTER_ID = 14;  

COMMIT;