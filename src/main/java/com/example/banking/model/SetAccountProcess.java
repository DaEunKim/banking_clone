package com.example.banking.model;

import lombok.Data;

/**
 * @author : DaEunKim
 * @version : 2020.09.21
 * @Description : SET_ACCOUNT_PROCESS 테이블 데이터
 */
@Data
public class SetAccountProcess {
	private Integer INDEX;
	private Integer USER_INFO_PK;   // MEMBER_INFO 테이블 pk (유저 정보)
	private Integer LAST_PAGE;      // 마지막 완료 페이지 번호
	private String ACCOUNT_TYPE;    // 개설 통장 종류
	private String IDENTI_CHECK;    // 신분증 확인 여부 (Y/N)
}
