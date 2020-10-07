package com.example.banking.model;

import lombok.Data;

/**
 * @author : DaEunKim
 * @version : 2020.09.20
 * @Description : OPEN_ACCOUNT_CHECK_LOG 테이블 데이터
 */
@Data
public class OpenAccountCheckLog {
	private Integer INDEX;
	private Integer SET_ACCOUNT_PROCESS_PK; // SET_ACCOUNT_PROCESS 테이블 PK (계좌 개설 절차 정보)
	private String STAGE_TYPE;              //  로그 타입 (identi, certifi, transfer)
	private String STAGE_STATUE;            // 정상, 오류 구별 (success, error)
	private String LOG_DATETIME;              // 로그 발생 일시
}
