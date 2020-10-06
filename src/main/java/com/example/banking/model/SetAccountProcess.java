package com.example.banking.model;

import lombok.Data;

/**
 * @author : DaEunKim
 * @version : 2020.09.21
 * @Description : SET_ACCOUNT_PROCESS 테이블 데이터
 */
@Data
public class SetAccountProcess {
	private Integer index;
	private Integer user_info_pk; // MEMBER_INFO 테이블 pk (유저 정보)
	private Integer last_page; // 마지막 완료 페이지 번호
	private String account_type; // 개설 통장 종류
	private String identi_check; // 신분증 확인 여부 (Y/N)
}
