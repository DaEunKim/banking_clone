-- 고객 정보 테이블
DROP TABLE IF EXISTS MEMBER_INFO;
CREATE TABLE MEMBER_INFO
(
	INDEX INT auto_increment not null,
	USER_ID VARCHAR(255), -- 사용자 ID, 중복 없음
	USER_NAME VARCHAR(255), -- 사용자 이름 - 고객 개발 AP에서 받은 정보, 동시 거래 검증에도 필요
	REGIS_NUM VARCHAR(255), -- 주민등록번호 (암호화하여 저장) - 고객 개발 AP에서 받은 정보, 동시 거래 검증에도 필요
	ACCOUNT_NUM VARCHAR(255), -- 계좌 번호 - 수신 개발 AP에서 받을 정보, 동시 거래 검증에도 필요
	ACCOUNT_PW VARCHAR(255),  -- 통장 비밀번호 (암호화하여 저장) - 모바일에서 받은 정보, 수신 개발 AP에 전달할 정보
	IDCARD_IMG VARCHAR(500), -- 신분증 사진 경로 - 모바일에서 받은 정보
	IDCARD_USER_NAME VARCHAR(255), -- 신분증에 있는 이름 - 인증 개발 AP에서 받은 정보
	IDCARD_REGIS_NUM VARCHAR(255), -- 주민등록번호 (암호화하여 저장하기 위해 varchar) - 인증 개발 AP에서 받은 정보
	IDCARD_NUM VARCHAR(255), -- 신분증 면허 번호 (암호화하여 저장하기 위해 varchar) - 인증 개발 AP에서 받은 정보
	IDCARD_REG_DAY DATE, -- 신분증 발급일자 - 인증 개발 AP에서 받은 정보
	primary key (INDEX)
);

-- 계좌 개설 각 단계 세팅 테이블(신분증 인증에 필요한 컬럼만 생성)
-- 중도 취소 경우를 대비한 각 단계 완료 상태 저장하는 테이블
DROP TABLE IF EXISTS SET_ACCOUNT_PROCESS;
CREATE TABLE SET_ACCOUNT_PROCESS
(
	INDEX INT auto_increment not null,
	USER_INFO_PK INT, -- MEMBER_INFO 테이블 pk (유저 정보)
	LAST_PAGE INT, -- 마지막 완료 페이지 번호
	ACCOUNT_TYPE VARCHAR(100), -- 개설 통장 종류
	IDENTI_CHECK VARCHAR(1), -- 신분증 확인 여부 (Y/N)
	primary key (INDEX)
);

-- 계좌 개설 과정 통신 로그 테이블
-- 각 단계의 정상, 오류 상태값 저장
DROP TABLE IF EXISTS OPEN_ACCOUNT_CHECK_LOG;
CREATE TABLE OPEN_ACCOUNT_CHECK_LOG
(
	INDEX INT auto_increment not null,
	SET_ACCOUNT_PROCESS_PK INT, -- SET_ACCOUNT_PROCESS 테이블 PK (계좌 개설 절차 정보)
	STAGE_TYPE VARCHAR(100), -- 로그 타입 (identi, certifiword, transfer)
	STAGE_STATUE VARCHAR(100), -- 정상, 오류 구별 (success, fail)
	LOG_DATETIME DATE, -- 로그 발생 일시
	primary key (INDEX)
);


