-- Characters 테이블에서 배역의 이름 컬럼에서 다쓰 혹은 다스 로 시작되는 배역들만 찾아보자.
SELECT
    character_name
FROM
    characters
WHERE
    character_name LIKE '다스%'
    OR character_name LIKE '다쓰%';

-- email 이 없는 배역들만 조회해 보자

SELECT
    character_name
FROM
    characters
WHERE
    email IS NULL;
    

select a.character_name, b.role_name, a.email
    from characters a Inner join roles b
on a.role_id = b.role_id;

