package com.example.banking.dao;

import com.example.banking.model.MemberInfo;
import com.example.banking.model.OpenAccountCheckLog;
import com.example.banking.model.SetAccountProcess;

import java.util.List;

/**
 * @author : DaEunKim
 * @version : 2020.10.06
 * @Description : 신분증 인증 구현 DAO 인터페이스
 */
public interface ApiDao {
	String selectName(MemberInfo memberInfo);

	List<MemberInfo> selectAllMemberInfo();

	List<SetAccountProcess> selectAllSetAccountProcess();

	List<OpenAccountCheckLog> selectAllAccountLog();

	int insertMemberInfo(MemberInfo memberInfo);

	int updateIdCardImg(MemberInfo memberInfo);

	int updateIdCardInfo(MemberInfo memberInfo);

	int insertIdentiErrorLog(OpenAccountCheckLog openAccountCheckLog);
}
