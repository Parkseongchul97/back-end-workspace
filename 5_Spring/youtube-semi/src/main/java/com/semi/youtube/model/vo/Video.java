package com.semi.youtube.model.vo;

import java.time.LocalDateTime;
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
	private LocalDateTime videoDate; 
	private String videoDesc;
//	private int channelCode; // 채널
	private Channel channel; 

}
