package com.sk.msa.springboot.model;

import lombok.Data;

@Data
public class AccountDTO {
	int accountSeq;
	String accountName;
	String memberId;
	int amount;
}
