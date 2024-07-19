package com.kh.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class Book {
	private int bookNum;  
	private String bookTitle;
	private String bookAuthor;
	private int	bookPrice;	
	private Publisher publisher;

	
}
