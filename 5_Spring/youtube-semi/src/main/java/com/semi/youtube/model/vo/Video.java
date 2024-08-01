package com.semi.youtube.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Video {
	private int videoCode;
	private String videoUrl,
					videoImg,
					videoTitle;
	private int videoCount ; 
	private Date videoDate; 
	private String videoDesc;
//	private int channelCode; // 채널
	private Channel channel; 

}
