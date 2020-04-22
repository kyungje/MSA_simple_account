package com.sk.msa.springboot.service.implementSrv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.msa.springboot.model.AccountDTO;
import com.sk.msa.springboot.repository.mapper.IAccountMapper;
import com.sk.msa.springboot.repository.rvo.AccountVO;
import com.sk.msa.springboot.service.interfaceSrv.IAccountSearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountSearchImpl implements IAccountSearch {

	@Autowired
	private IAccountMapper accountMapper;
	
	@Override
	public AccountDTO getAllAccountInfo(int accountSeq) {
		log.debug("getAllAccountInfo accountSeq :" + accountSeq);
		AccountDTO accountDTO = new AccountDTO();
		AccountVO accountVO = new AccountVO();
		
		accountVO = accountMapper.findAllAccountInfoByAccountSeq(accountSeq);
		
		log.debug("getAllAccountInfo accountVO :" + accountVO);
		
		accountDTO.setAccountSeq(accountVO.getAccountSeq());
		accountDTO.setAccountName(accountVO.getAccountName());
		accountDTO.setMemberId(accountVO.getMemberId());
		accountDTO.setAmount(accountVO.getAmount());
		
		log.debug("getAllAccountInfo accountDTO :" + accountDTO);
		
		return accountDTO;
	}

}
