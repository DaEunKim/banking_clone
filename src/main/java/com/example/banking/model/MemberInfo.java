package com.example.banking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

/**
 * @author : DaEunKim
 * @version : 2020.09.11
 * @Description : Member_Info 테이블 데이터
 */

@Data
public class MemberInfo {
	private Integer INDEX;
	private String USER_ID;             // 사용자 ID
	private String USER_NAME;           // 사용자 이름 - 고객 개발 AP에서 받은 정보, 동시 거래 검증에도 필요
	private String REGIS_NUM;           // 주민등록번호 (암호화하여 저장) - 고객 개발 AP에서 받은 정보, 동시 거래 검증에도 필요
	private String ACCOUNT_NUM;         // 계좌 번호 - 수신 개발 AP에서 받을 정보, 동시 거래 검증에도 필요
	private String ACCOUNT_PW;          // 통장 비밀번호 (암호화하여 저장) - 모바일에서 받은 정보, 수신 개발 AP에 전달할 정보
	private String IDCARD_IMG;          // 신분증 사진 경로 - 모바일에서 받은 정보
	private String IDCARD_USER_NAME;    // 신분증에 있는 이름 - 인증 개발 AP에서 받은 정보
	private String IDCARD_REGIS_NUM;    // 주민등록번호 (암호화하여 저장하기 위해 varchar) - 인증 개발 AP에서 받은 정보
	private String IDCARD_NUM;          // 신분증 면허 번호 (암호화하여 저장하기 위해 varchar) - 인증 개발 AP에서 받은 정보
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date IDCARD_REG_DAY;        // 신분증 발급일자 - 인증 개발 AP에서 받은 정보


}
