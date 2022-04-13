-- [관리자 계정] member 계정 생성
CREATE USER bdh_member IDENTIFIED BY member1234;

-- [관리자 계정] CONNECT, RESOURCE + CREATE VIEW 권한 부여  +  객체 생성 공간 할당
GRANT CONNECT, RESOURCE, CREATE VIEW TO bdh_member;
ALTER USER bdh_member DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

-- bdh_member 계정 접속 방법 추가

-- [멤버 계정]
CREATE TABLE MEMBER(
    MEMBER_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) NOT NULL,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NM VARCHAR2(30) NOT NULL,
    MEMBER_GENDER CHAR(1) CHECK( MEMBER_GENDER IN ('M', 'F') ),
    ENROLL_DATE DATE DEFAULT SYSDATE,
    SECESSION_FL CHAR(1) DEFAULT 'N' CHECK( SECESSION_FL IN ('Y', 'N') )
);

COMMENT ON COLUMN MEMBER.MEMBER_NO IS '회원 번호(PK)';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원 아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PW IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NM IS '회원 이름';
COMMENT ON COLUMN MEMBER.MEMBER_GENDER IS '회원 성별(M/F)';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '회원 가입일';
COMMENT ON COLUMN MEMBER.SECESSION_FL IS '탈퇴여부(Y/N)';


-- 게시판 테이블
DROP TABLE BOARD;

CREATE TABLE BOARD(
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR2(200) NOT NULL,
    BOARD_CONTENT VARCHAR2(4000) NOT NULL,
    CREATE_DATE DATE DEFAULT SYSDATE,
    READ_COUNT NUMBER DEFAULT 0,
    MEMBER_NO NUMBER REFERENCES MEMBER  -- MEMBER 테이블 PK값 참조
);

COMMENT ON COLUMN BOARD.BOARD_NO        IS '게시글 번호';
COMMENT ON COLUMN BOARD.BOARD_TITLE     IS '게시글 제목';
COMMENT ON COLUMN BOARD.BOARD_CONTENT   IS '게시글 내용';
COMMENT ON COLUMN BOARD.CREATE_DATE     IS '게시글 작성일';
COMMENT ON COLUMN BOARD.READ_COUNT      IS '조회수';
COMMENT ON COLUMN BOARD.MEMBER_NO       IS '회원 번호(작성자)';


-- 댓글 테이블
CREATE TABLE REPLY(
    REPLY_NO NUMBER PRIMARY KEY,
    REPLY_CONTENT VARCHAR2(500) NOT NULL,
    CREATE_DATE DATE DEFAULT SYSDATE,
    MEMBER_NO NUMBER REFERENCES MEMBER, -- MEMBER 테이블 PK 참조
    BOARD_NO NUMBER REFERENCES BOARD -- BOARD 테이블 PK
);



COMMENT ON COLUMN REPLY.REPLY_NO IS '댓글 번호(PK)';
COMMENT ON COLUMN REPLY.REPLY_CONTENT IS '댓글 내용';
COMMENT ON COLUMN REPLY.CREATE_DATE IS '댓글 작성일';
COMMENT ON COLUMN REPLY.MEMBER_NO IS '회원 번호(작성자)';
COMMENT ON COLUMN REPLY.BOARD_NO IS '게시글 번호(어떤 게시글의 댓글인지 확인)';


-- 각 테이블 PK 생성용 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO; -- 1부터 1씩 증가, 반복 X
CREATE SEQUENCE SEQ_BOARD_NO;
CREATE SEQUENCE SEQ_REPLY_NO;



---------------------------------------------------------------------------------

-- 아이디 중복 검사
-- (중복 아이디가 존재해도 탈퇴한 계정이면 중복 처리 x)
SELECT COUNT(*) FROM MEMBER 
WHERE MEMBER_ID = 'user01' 
AND SECESSION_FL = 'N'; -- 탈퇴를 안한 계정

INSERT INTO MEMBER VALUES(1, 'user01', 'pass01', '유저일', 'M', DEFAULT, DEFAULT);

commit;
rollback;


-- 로그인
SELECT MEMBER_NO, MEMBER_ID, MEMBER_NM, MEMBER_GENDER, ENROLL_DATE 
FROM MEMBER
WHERE MEMBER_ID = 'user01'
AND MEMBER_PW = 'pass01'
AND SECESSION_FL = 'N';


ALTER TABLE MEMBER
RENAME COLUMN 이전컬럼명 TO 변경할 컬럼명;


-------------------------------------

-- DB에서 회원 정보 모두 조회(아이디, 이름, 가입일)
-- 단, 탈퇴 회원 제외, 아이디 오름 차순 조회
SELECT MEMBER_ID, MEMBER_NM, ENROLL_DATE
FROM MEMBER
WHERE SECESSION_FL = 'N' -- 탈퇴 안한 사람만 조회
ORDER BY MEMBER_ID;

-- 비밀번호 변경
UPDATE MEMBER SET
MEMBER_PW = ?       -- 새 비밀번호
WHERE MEMBER_NO = ? -- 로그인한 회원 번호
AND MEMBER_PW = ?   -- 현재 비밀번호

-- 회원 탈퇴
UPDATE MEMBER SET
SECESSION_FL = 'Y'
WHERE MEMBER_NO = ? -- 로그인한 회원 번호
AND MEMBER_PW = ? -- 입력 받은 비밀번호
;


--------------------------------------------------------------------------------

-- 게시글 목록 조회 + 댓글 개수(상관 서브쿼리 + 스칼라 서브쿼리)
-- BOARD테이블 :  BOARD_NO, BOARD_TITLE, BOARD_CONTENT, CREATE_DATE, READ_COUNT, MEMBER_NO

SELECT BOARD_NO, BOARD_TITLE, CREATE_DATE, READ_COUNT, MEMBER_NM,
    (SELECT COUNT(*) FROM REPLY R
     WHERE R.BOARD_NO = B.BOARD_NO) REPLY_COUNT
FROM BOARD B
JOIN MEMBER USING(MEMBER_NO)
ORDER BY BOARD_NO DESC ;


-- 댓글 개수 조회(특정 게시글만)
SELECT COUNT(*) FROM REPLY
WHERE BOARD_NO = 3;



-- 게시글 번호가 크다 == 최신 글이다

-- BOARD 테이블 샘플 데이터
INSERT INTO BOARD 
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 게시글 1', '샘플1 내용입니다.', DEFAULT, DEFAULT, 1);

INSERT INTO BOARD 
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 게시글 2', '샘플2 내용입니다.', DEFAULT, DEFAULT, 1);

INSERT INTO BOARD 
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 게시글 3', '샘플3 내용입니다.', DEFAULT, DEFAULT, 1);

COMMIT;


-- 댓글 샘플 데이터 삽입
-- REPLY_NO, REPLY_CONTENT, CREATE_DATE, MEMBER_NO, BOARD_NO
INSERT INTO REPLY
VALUES(SEQ_REPLY_NO.NEXTVAL, '샘플1의 댓글1', DEFAULT, 1, 1);

INSERT INTO REPLY
VALUES(SEQ_REPLY_NO.NEXTVAL, '샘플1의 댓글2', DEFAULT, 1, 1);

INSERT INTO REPLY
VALUES(SEQ_REPLY_NO.NEXTVAL, '샘플1의 댓글3', DEFAULT, 1, 1);

COMMIT;


-- 특정 게시글 상세 조회
SELECT B.* , MEMBER_NM
FROM BOARD B
JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO)
WHERE BOARD_NO = 1;

-- 특정 게시글의 댓글 목록 조회
SELECT R.*, MEMBER_NM
FROM REPLY R
JOIN MEMBER M ON(R.MEMBER_NO = M.MEMBER_NO)
WHERE BOARD_NO = 1
--ORDER BY REPLY_NO DESC; -- 최근 댓글이 상단
ORDER BY REPLY_NO; -- 최근 댓글이 하단

-- 댓글 목록에서 최근에 작성한 글은     제일 위?         제일 아래?
--                                      SNS, 기사      카페, 커뮤니티


-- 게시글 수 증가
-- 이전 조회수 + 1 을 조회수 컬럼에 대입
UPDATE BOARD SET
READ_COUNT = READ_COUNT + 1   
WHERE BOARD_NO = 1;

rollback;


-- 게시글 삭제
COMMIT;

DELETE FROM BOARD WHERE BOARD_NO = 1;
ROLLBACK;
-- ORA-02292: 무결성 제약조건(BDH_MEMBER.SYS_C009776)이 위배되었습니다- 자식 레코드가 발견되었습니다

SELECT * FROM BOARD WHERE BOARD_NO = 1; -- BOARD 테이블 1번 게시글
SELECT * FROM REPLY WHERE BOARD_NO = 1; -- REPLY 테이블에서 BOARD 테이블 1번 게시글을 참조하는 댓글
--> 기본적으로 삭제 불가 
--> 삭제 옵션을 추가하면 가능
-- ON DELETE SET NULL(자식 컬럼 NULL)   /  ON DELETE CASCADE(참조하던 자식 행도 삭제)

-- 제약조건은 ALTER(변경) 없음 -> 삭제 후 다시 추가

-- 기존 REPLY 테이블 FK 제약조건 삭제
ALTER TABLE REPLY DROP CONSTRAINT SYS_C009776;

-- 삭제 옵션이 추가된 FK를 다시 추가
ALTER TABLE REPLY 
ADD FOREIGN KEY(BOARD_NO) 
REFERENCES BOARD 
ON DELETE CASCADE;
-- Table REPLY이(가) 변경되었습니다.

-- 다시 1번 게시글 삭제 시도
DELETE FROM BOARD WHERE BOARD_NO = 1;

SELECT * FROM BOARD WHERE BOARD_NO = 1; 
SELECT * FROM REPLY WHERE BOARD_NO = 1;

ROLLBACK;


-- 게시글 수정
UPDATE BOARD SET
BOARD_TITLE = ?,
BOARD_CONTENT = ?
WHERE BOARD_NO = ?

;

-- 게시글 검색
SELECT BOARD_NO, BOARD_TITLE, CREATE_DATE, READ_COUNT, MEMBER_NM,
    (SELECT COUNT(*) FROM REPLY R
     WHERE R.BOARD_NO = B.BOARD_NO) REPLY_COUNT
FROM BOARD B
JOIN MEMBER USING(MEMBER_NO)

--WHERE BOARD_TITLE LIKE '%' || ? || '%' -- 제목 검색
--WHERE BOARD_CONTENT LIKE '%' || ? || '%' -- 내용 검색       

--WHERE BOARD_TITLE LIKE '%' || ? || '%'
--OR    BOARD_CONTENT LIKE '%' || ? || '%' -- 제목 + 내용 검색

WHERE MEMBER_NM LIKE '%' || ? || '%'  -- 작성자 검색
                       
ORDER BY BOARD_NO DESC ;







