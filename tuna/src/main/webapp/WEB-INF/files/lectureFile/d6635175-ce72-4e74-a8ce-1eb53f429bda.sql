CREATE TABLE member
(userid     NUMBER(6) PRIMARY KEY,
 username VARCHAR2(10) CONSTRAINT member_username_nn NOT NULL,
 passwd    VARCHAR2(10) CONSTRAINT member_passwd_nn NOT NULL,
 idnum     VARCHAR2(13) CONSTRAINT member_id_num_uk UNIQUE,
 phone     VARCHAR2(13),
 address   VARCHAR2(25),
 regdate   DATE,
 interest   VARCHAR2(15));
 
CREATE TABLE board
(no number(4) PRIMARY KEY,
 subject VARCHAR2(50) CONSTRAINT board_subject_nn NOT NULL,
 content VARCHAR2(1000),
 rdate DATE,
 userid NUMBER(6) CONSTRAINT board_userid_fk REFERENCES MEMBER(userid));
 
CREATE SEQUENCE board_no_seq
INCREMENT BY 1
START WITH 1
NOCACHE
NOCYCLE;

INSERT INTO member
VALUES ('101','송성광','1234','7906021234567', '051-123-1234','부산 수정동',sysdate,'DB');
INSERT INTO member
VALUES ('102','김영균','2345','7903022341567','051-321-1234','창원 사림동',sysdate,'internet');
INSERT INTO member
VALUES ('103','전인하','3456','7901041324668','051-345-3456','부산 동삼동',sysdate,'java');