package com.sk.msa.springboot.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sk.msa.springboot.repository.rvo.AccountVO;

/**
 * @author 07198
 * Account
 */
@Mapper
public interface IAccountMapper {
	AccountVO findAllAccountInfoByAccountSeq(int accountSeq);
}
