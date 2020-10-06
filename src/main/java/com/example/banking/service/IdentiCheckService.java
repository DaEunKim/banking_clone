package com.example.banking.service;

import com.example.banking.model.MemberInfo;
import com.example.banking.model.OpenAccountCheckLog;
import com.example.banking.model.SetAccountProcess;

import java.util.List;

/**
 * @author : DaEunKim
 * @version : 2020.10.06
 * @Description : 신분증 인증 구현 서비스 인터페이스
 */
public interface IdentiCheckService {
	String selectName(MemberInfo memberInfo);

	List<MemberInfo> selectAllMemberInfo();

	int insertMemberInfo(MemberInfo memberInfo);

	int updateIdCardImg(MemberInfo memberInfo);

	int updateIdCardInfo(MemberInfo memberInfo);

	String insertLog(OpenAccountCheckLog openAccountCheckLog, SetAccountProcess setAccountProcess);

	List<SetAccountProcess> selectAllSetAccountProcess();

	List<OpenAccountCheckLog> selectAllAccountLog();
}
