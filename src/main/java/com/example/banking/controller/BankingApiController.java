package com.example.banking.controller;

import com.example.banking.model.MemberInfo;
import com.example.banking.model.OpenAccountCheckLog;
import com.example.banking.model.SetAccountProcess;
import com.example.banking.service.IdentiCheckService;
import com.example.banking.service.IdentiCheckServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * 1. 모바일에서 유저 아이디와 신분증 경로를 알려주면서 인증 요청을 받으면 (내가 개발할 API) - 모바일에게 유저아이디랑 신분증 경로 주세요~ 요청
	 * 2. 유저 정보 요청 API(고객 개발 AP의 API) -> 값을 포함한 응답 정상이면 저장 (sync)(응답 올 때까지 대기)
	 * 3. 인증 개발 AP로 신분증 분석 요청 API(인증 개발 AP의 API) -> 분석 결과 값을 포함한 응답 정상이면 저장 (sync)
	 * 분석 결과 값(주민번호 분석 등) 유저 정보와 비교 로직
	 * 1번 모바일 API 응답(sync)
	 */


	/**
	 * @author : DaEunKim
	 * @Description 고객 개발 AP의 유저 정보와 모바일 앱의 신분증 이미지 저장하는 API
	 */
	@PostMapping(path = "/insertMemberInfo")
	public String insertMemberInfo(@RequestBody MemberInfo memberInfo){
		// 유저 테이블에 고객 정보와 신분증 경로 insert 할때 SET_ACCOUNT_PROCESS 테이블에도 같이 insert 해야함
		identiCheckService.insertMemberInfo(memberInfo);
		identiCheckService.updateIdCardImg(memberInfo);
		return "success";
	}
	/**
	 * @author : DaEunKim
	 * @Description 신분증 분석 정보 비교 및 저장 API
	 * 모바일에서 유저 아이디와 신분증 경로를 포함 데이터를 전송, MEMBER_INFO 테이블엔 user_id 중복 없음
	 */
	@PostMapping(value = "/updateIdCardInfo")
	public MemberInfo updateIdCardInfo(@RequestBody HashMap<String, String> MobileUserInfo) throws Exception{

		// 모바일에서 준 유저 아이디로 고객 정보에서 준 주
		// 유저 테이블에서 유저정보 가져오기 이름과 주민번호
		// 신분증 분석 결과로 나온 유저 이름과 주민번호 가져오기
		// DB 에 저장된 값을 호출해서 두 정보 비교
		// 맞으면 계좌 개설 테이블에 insert, 틀리면 오류 테이블에 insert
		// 응답 return


		log.info("MobileUserInfo " + MobileUserInfo.get("user_ID"));
		MemberInfo userInfo = identiCheckService.selectCheckName(MobileUserInfo.get("user_ID"));


		log.info("userInfo " + userInfo);

		if(userInfo==null){
			// 유저 정보가 존재하지 않습니다.
			log.info("userInfo empty ");
		}
		else{
			if(MobileUserInfo.get("user_ID").equals(userInfo.getIDCARD_USER_NAME())){
				log.info("equal " + userInfo.getUSER_NAME());
//				SET_ACCOUNT_PROCESS 테이블에 Y insert
// 				OPEN_ACCOUNT_CHECK_LOG 기록
//				STAGE_TYPE identi, STAGE_STATUE success, 시간

//				identiCheckService.updateIdCardInfo(memberInfo);
			}
			else{
//				SET_ACCOUNT_PROCESS 테이블에 N insert
//				OPEN_ACCOUNT_CHECK_LOG insert STAGE_TYPE identi, STAGE_STATUE fail, 시
			}
		}

//		log.info("userName"+ user_info);
//		if(userName.equals(memberInfo.getIDCARD_USER_NAME())){
//			identiCheckService.updateIdCardInfo(memberInfo);
//		}
//		else{
//			identiCheckService.insertLog(openAccountCheckLog, setAccountProcess);
//		}
		return userInfo;
	}

	/**
	 * @author : DaEunKim
	 * @Description 각 테이블 모든 데이터 select
	 */
	@GetMapping("/selectAll")
	public Map<String, List> selectAll() {
		Map<String, List> map = new HashMap<>();

		List<MemberInfo> selectAllMemberInfo = identiCheckService.selectAllMemberInfo();
		List<SetAccountProcess> selectAllSetAccountProcess = identiCheckService.selectAllSetAccountProcess();
		List<OpenAccountCheckLog> selectAllAccountLog = identiCheckService.selectAllAccountLog();

		map.put("selectAllMemberInfo",selectAllMemberInfo);
		map.put("selectAllSetAccountProcess", selectAllSetAccountProcess);
		map.put("selectAllAccountLog", selectAllAccountLog);

		return map;
	}

}
