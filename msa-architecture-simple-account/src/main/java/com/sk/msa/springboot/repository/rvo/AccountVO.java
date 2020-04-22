package com.sk.msa.springboot.repository.rvo;

import lombok.Data;

@Data
public class AccountVO {
	int accountSeq;
	String accountName;
	String memberId;
	int amount;
}
