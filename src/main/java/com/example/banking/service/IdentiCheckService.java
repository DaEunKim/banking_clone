package com.example.banking.service;

import com.example.banking.model.MemberInfo;
import com.example.banking.model.OpenAccountCheckLog;
import com.example.banking.model.SetAccountProcess;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author : DaEunKim
 * @version : 2020.10.06
 * @Description : 신분증 인증 구현 서비스 인터페이스
 */

public interface IdentiCheckService {

	/** @Description : MEMBER_INFO 테이블 데이터 확인 함수 */
	List<MemberInfo> selectAllMemberInfo();
	/** @Description : SET_ACCOUNT_PROCESS 테이블 데이터 확인 함수 */
	List<SetAccountProcess> selectAllSetAccountProcess();
	/** @Description : OPEN_ACCOUNT_CHECK_LOG 테이블 데이터 확인 함수 */
	List<OpenAccountCheckLog> selectAllAccountLog();

	/** @Description : 고객 정보 확인 함수  */
	MemberInfo selectCheckName(String mobileUserInfo);

	int insertMemberInfo(MemberInfo memberInfo);

	int updateIdCardImg(MemberInfo memberInfo);

	int updateIdCardInfo(MemberInfo memberInfo);

	String insertLog(OpenAccountCheckLog openAccountCheckLog, SetAccountProcess setAccountProcess);


}
