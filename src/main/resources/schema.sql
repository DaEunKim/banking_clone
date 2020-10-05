-- 고객 정보 테이블
DROP TABLE IF EXISTS MEMBER_INFO;
create table MEMBER_INFO
(
	INDEX INT auto_increment not null,
	USER_ID VARCHAR(255), -- 사용자 ID
	USER_NAME VARCHAR(255), -- 사용자 이름
	ACCOUNT_NUM VARCHAR(255), -- 계좌 번호
	ACCOUNT_PW VARCHAR(255),  -- 통장 비밀번호 (암호화하여 저장)
	IDCARD_IMG VARCHAR(500), -- 신분증 사진 경로
	IDCARD_USER_NAME VARCHAR(255), -- 신분증 이름
	REGIS_NUM VARCHAR(255), -- 주민등록번호 (암호화하여 저장)
	IDCARD_NUM VARCHAR(255), -- 신분증 면허 번호 (암호화하여 저장)
	IDCARD_REG_DAY DATE, -- 신분증 발급일자
	primary key (INDEX)
);

-- 계좌 개설 절차 테이블
DROP TABLE IF EXISTS SET_ACCOUNT_PROCESS;
create table SET_ACCOUNT_PROCESS
(
	INDEX INT auto_increment not null,
	user_info_pk INT, -- MEMBER_INFO 테이블 pk (유저 정보)
	last_page INT, -- 마지막 완료 페이지 번호
	account_type VARCHAR(100), -- 개설 통장 종류
	identi_check VARCHAR(1), -- 신분증 확인 여부 (Y/N)
	primary key (INDEX)
);

-- 신분증 확인 오류 로그 테이블
DROP TABLE IF EXISTS OPEN_ACCOUNT_CHECK_LOG;
create table OPEN_ACCOUNT_CHECK_LOG
(
	INDEX INT auto_increment not null,
	set_account_process_PK INT, -- SET_ACCOUNT_PROCESS 테이블 PK (계좌 개설 절차 정보)
	type VARCHAR(100), -- 로그 타입 (identi, certifi, transfer)
	status VARCHAR(100), -- 정상, 오류 구별
	log_datetime DATE, -- 로그  발생 일시
	primary key (INDEX)
);


