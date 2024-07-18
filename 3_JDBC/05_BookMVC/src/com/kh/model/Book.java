package com.kh.model;

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
	private int bookPublisherKey;
	
}
