package com.example.banking.dao;

import com.example.banking.model.MemberInfo;
import com.example.banking.model.OpenAccountCheckLog;
import com.example.banking.model.SetAccountProcess;

import java.util.HashMap;
import java.util.List;

/**
 * @author : DaEunKim
 * @version : 2020.10.06
 * @Description : 신분증 인증 구현 DAO 인터페이스
 */
public interface ApiDao {
	List<MemberInfo> selectAllMemberInfo();
	List<SetAccountProcess> selectAllSetAccountProcess();
	List<OpenAccountCheckLog> selectAllAccountLog();

	/** @Description : 고객 정보 확인 함수  */
	MemberInfo selectCheckName(String mobileUserInfo);
	/** @Description : 계좌 개설 과정 확인 함수  */
	SetAccountProcess selectAccountProcess(Integer userInfoPK);

	/** @Description : 신분증 정보 일치 여부 update 함수  */
	int updateIdentiCheck(SetAccountProcess setAccountProcess);
	/** @Description : 계좌 개설 과정 로그 정보 insert 함수  */
	int insertIdentiLog(OpenAccountCheckLog openAccountCheckLog);



	int insertMemberInfo(MemberInfo memberInfo);

	int updateIdCardImg(MemberInfo memberInfo);

	int updateIdCardInfo(MemberInfo memberInfo);

	int insertIdentiErrorLog(OpenAccountCheckLog openAccountCheckLog);



}
