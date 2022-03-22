-- 함수 : 컬럼의 값을 읽어서 연산한 결과를 반환

-- 단일행(SINGLE ROW) 함수 : N개의 값을 읽어 N개의 결과 반환

-- 그룹(GROUP) 함수 : N개의 값을 읽어 1개의 결과 반환

-- 함수는 SELECT절, WHERE절, ORDER BY, GROUP BY, HAVING 사용 가능


/*************** 단일행 함수 ***************/

-- LENGTH(문자열 | 컬럼) : 문자열 길이 반환
SELECT LENGTH('HELLO WORLD') FROM DUAL;

-- 12글자인 이메일만 조회
SELECT EMAIL, LENGTH(EMAIL) FROM EMPLOYEE
WHERE LENGTH(EMAIL) = 12;

---------------------------------------------------------------------------------

-- INSTR('문자열' | 컬럼명, '찾을문자', [찾을 위치 시작위치, [순번]])
-- 지정한 위치부터 지정한 순번째로 검색되는 문자의 시작 위치를 반환

-- 문자열에서 맨 앞에있는 B 위치 조회
SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;

-- 문자열에서 5번째 부터 검색해서 맨 앞에있는 B 위치 조회
SELECT INSTR('AABAACAABBAA', 'B', 5) FROM DUAL;


-- EMPLOYEE 테이블에서 사원명, 이메일, 이메일 중 '@'위치 조회
SELECT EMP_NAME, EMAIL, INSTR(EMAIL, '@')
FROM EMPLOYEE;

-----------------------------------------------------------------------------------

-- SUBSTR('문자열' | 컬럼명, 잘라내기 시작할 위치 [, 잘라낼 길이]  )
-- 컬럼이나 문자열에서 지정한 위치부터 지정된 길이만큼 문자열을 잘라내서 반환
--> 잘라낼 길이 생략 시 끝까지 잘라냄

-- EMPLOYEE 테이블에서 사원명, 이메일 중 아이디만 조회   sun_di@or.kr
SELECT EMP_NAME, SUBSTR(EMAIL, 1 , INSTR(EMAIL, '@') -1 ) 아이디
FROM EMPLOYEE
ORDER BY 아이디;

---------------------------------------------------------------------------------

-- TRIM([옵션] '문자열' | 컬럼명 [FROM '문자열'|컬럼명]  )
-- 주어진 컬럼이나 문자열의 앞, 뒤, 양쪽에 있는 지정된 문자를 제거
--> (보통 양쪽 공백 제거에 많이 사용)

-- 옵션 :  LEADING(앞쪽), TRAILING(뒤쪽), BOTH(양쪽, 기본값)

SELECT '     K H     ',  TRIM('     K H     ') FROM DUAL; -- 양쪽 공백 제거 (중간 미포함)

SELECT '---KH---', TRIM(BOTH '-' FROM '---KH---') FROM DUAL;
-- BOTH 또는 생략 시 : 양쪽 '-' 기호 제거
-- LEADING: 앞쪽만 제거
-- TRAILING : 뒤쪽만 제거


----------------------------------------------------------------------------------

/* 숫자 관련 함수 */

-- ABS(숫자 | 컬럼명) : 절대 값
SELECT ABS(10), ABS(-10) FROM DUAL;


-- MOD(숫자 | 컬럼명  ,  숫자 | 컬럼명) : 나머지 값 반환
-- EMPLOYEE 테이블에서 사원의 월급을 100만으로 나눴을 때 나머지 조회
SELECT EMP_NAME, SALARY, MOD(SALARY, 1000000)
FROM EMPLOYEE;


-- ROUND(숫자 | 컬럼명 [,소수점 위치]) : 반올림

SELECT 123.456,  ROUND(123.456) FROM DUAL; -- 소수점 첫째 자리에서 반올림
SELECT 123.456,  ROUND(123.456, 1) FROM DUAL; -- 소수점 첫째 자리까지 출력 == 소수점 둘째 자리 반올림
SELECT 123.456,  ROUND(123.456, 2) FROM DUAL; 

SELECT 123.456,  ROUND(123.456, 0) FROM DUAL; -- 소수점 첫째 자리에서 반올림
SELECT 123.456,  ROUND(123.456, -1) FROM DUAL; -- 소수점 0번째 자리에서 반올림
SELECT 123.456,  ROUND(123.456, -2) FROM DUAL; -- 소수점 -1번째 자리에서 반올림

---------------------------------------------------------------------------------

-- CEIL(숫자 | 컬럼명) : 올림
-- FLOOR(숫자 | 컬럼명) : 내림
--> 둘다 소수점 첫째 자리에서 올림/내림 처리
SELECT 123.5,  CEIL(123.5), FLOOR(123.5) FROM DUAL;


-- TRUNC(숫자 | 컬럼명 [,위치]) : 특정 위치 아래를 버림(절삭)

SELECT TRUNC(123.456, 1), TRUNC(123.456, -1)
FROM DUAL;

-- * 버림, 내림의 차이점
SELECT TRUNC(-123.5), FLOOR(-123.5)
FROM DUAL;


----------------------------------------------------------------------------------
----------------------------------------------------------------------------------

/* 날짜(DATE) 관련 함수 */

-- SYSDATE : 시스템에 현재 시간(년,월,일,시,분,초)을 반환
SELECT SYSDATE FROM DUAL;

-- SYSTIMESTAMP : SYSDATE + MS 단위 추가
SELECT SYSTIMESTAMP FROM DUAL;


-- MONTHS_BETWEEN(날짜, 날짜) : 두 날짜의 개월 수 차이 반환
SELECT ROUND( MONTHS_BETWEEN(SYSDATE, '2022/02/21') ) || '개월' AS 수강기간 FROM DUAL;

-- EMPLOYEE 테이블에서
-- 사원의 이름, 입사일, 근무 개월 수 ,근무 햇수 조회
SELECT EMP_NAME, HIRE_DATE,
  '근무 ' || CEIL( MONTHS_BETWEEN(SYSDATE, HIRE_DATE) ) || '개월 차' "근무 개월 수"  ,
  '근무 ' || CEIL( MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12 ) || '년 차' "근무 햇수"
FROM EMPLOYEE;






