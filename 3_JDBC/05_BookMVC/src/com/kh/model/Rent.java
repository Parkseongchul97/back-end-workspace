package com.kh.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class Rent {
	private int rentNum;
	private int rentMemberKey;
	private int rentBookKey;
	private Date rentDate;
}
