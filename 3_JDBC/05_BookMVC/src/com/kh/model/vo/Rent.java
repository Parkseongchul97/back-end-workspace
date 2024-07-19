package com.kh.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class Rent {
	private int rentNum;
	private Member rentMemberKey;
	private Book rentBookKey;
	private Date rentDate;
}
