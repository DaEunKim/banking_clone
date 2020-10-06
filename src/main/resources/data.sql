-- 고객 개발 AP에서 정보를 받았다는 가정하에 초기 세팅 insert
INSERT INTO MEMBER_INFO (USER_ID, USER_NAME, REGIS_NUM) VALUES ('dani717','김다은', '123-123');
INSERT INTO MEMBER_INFO (USER_ID, USER_NAME, REGIS_NUM) VALUES ('kimdaeun','이다은', '1234-1234');

--  인증 개발 AP에서 정보를 받았다는 가정하에 초기 세팅 update
-- 유저 정보우의 주민번호와 신분증의 주민번호 같은 경우
UPDATE MEMBER_INFO SET IDCARD_USER_NAME='김다은'
, IDCARD_REGIS_NUM='123-123'
, IDCARD_NUM='1111'
, IDCARD_REG_DAY='2020-09-09'
where USER_ID='dani717';

-- 유저 정보우의 주민번호와 신분증의 주민번호 다른 경우
UPDATE MEMBER_INFO SET IDCARD_USER_NAME='이다은'
, IDCARD_REGIS_NUM='123123-123123'
, IDCARD_NUM='2222'
, IDCARD_REG_DAY='2020-09-10'
where USER_ID='kimdaeun';


-- MEMBER_INFO insert 할때 같이 insert 되야 해서 초기 세팅 insert
INSERT INTO SET_ACCOUNT_PROCESS (USER_INFO_PK) VALUES (1);
INSERT INTO SET_ACCOUNT_PROCESS (USER_INFO_PK) VALUES (2);