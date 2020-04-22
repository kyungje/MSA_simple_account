package com.sk.msa.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sk.msa.springboot.model.AccountDTO;
import com.sk.msa.springboot.repository.rvo.AccountVO;
import com.sk.msa.springboot.service.interfaceSrv.IAccountSearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AccountSearchController {

	@Autowired
	IAccountSearch accountSearch;

	@HystrixCommand
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<AccountVO> getEchoAccountInfo(@RequestBody AccountVO accountVO) {
		log.debug("getEchoAccountInfo accountVO : " + accountVO);
		return new ResponseEntity<AccountVO>(accountVO, HttpStatus.OK);
	}

	@HystrixCommand
	@RequestMapping(value = "/account/{accountSeq}", method = RequestMethod.POST)
	public ResponseEntity<AccountDTO> getAllAccountInfo(@PathVariable("accountSeq") int accountSeq) {
		log.debug("getAllAccountInfo accountSeq : " + accountSeq);
		AccountDTO accountDTO = accountSearch.getAllAccountInfo(accountSeq);
		log.debug("getAllAccountInfo accountDTO : " + accountDTO);
		return new ResponseEntity<AccountDTO>(accountDTO, HttpStatus.OK);
	}
}
