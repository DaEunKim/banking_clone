package com.example.banking.controller;

import com.example.banking.dao.ApiDao;
import com.example.banking.model.MemberInfo;
import com.example.banking.model.OpenAccountCheckLog;
import com.example.banking.model.SetAccountProcess;
import com.example.banking.service.IdentiCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * @author : DaEunKim
 * @version : 2020.09.18
 * @Description : 뱅킹 Rest API - 신분증 인증 구현 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/bankingAPI/")
public class BankingApiController {
	@Autowired
	IdentiCheckService identiCheckService;

	/**
	 * @author : DaEunKim
	 * @Description
	 * 1. 유저 정보 요청 API -> 받고 저장 -> 응답 (sync)
	 * 2. 모바일로 신분증 경로 받는 API -> 받고 저장
	 * 3. 인증 개발 AP로 신분증 분석 요청 API -> 분석 결과 받고 저장 -> 응답 (sync)
	 * 분석 결과 값(주민번호 분석 등) 유저 정보와 비교 로직
	 * 1번 API 응답(sync)
	 */


	/**
	 * @author : DaEunKim
	 * @Description 고객 개발 AP의 유저 정보와 모바일 앱의 신분증 이미지 저장하는 API
	 */
	@PostMapping(path = "/insertMemberInfo")
	public String insertMemberInfo(@RequestBody MemberInfo memberInfo){
		identiCheckService.insertMemberInfo(memberInfo);
		identiCheckService.updateIdCardImg(memberInfo);
		return "success";
	}
	/**
	 * @author : DaEunKim
	 * @Description 신분증 분석 정보 비교 및 저장 API
	 */
	@PostMapping(value = "/updateIdCardInfo")
	public String updateIdCardInfo(@RequestBody MemberInfo memberInfo, OpenAccountCheckLog openAccountCheckLog, SetAccountProcess setAccountProcess) {
		//임의로 set_account_process_pk는 1로 설정
		memberInfo.setIndex(1);
		String compName = identiCheckService.selectName(memberInfo);
		if(compName.equals(memberInfo.getIdcard_user_name())){
			identiCheckService.updateIdCardInfo(memberInfo);
		}
		else{
			identiCheckService.insertLog(openAccountCheckLog, setAccountProcess);
		}
		return "send success";
	}

	/**
	 * @author : DaEunKim
	 * @Description MEMBER_INFO 테이블 모든 데이터 select
	 */
	@GetMapping("/selectAll")
	public List selectAll() {
		List<MemberInfo> selectAll = identiCheckService.selectAll();
		return selectAll;
	}

}
