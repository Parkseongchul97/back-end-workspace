package controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ModelAndView {
	
	private String path; // 보내는 링크 
	private boolean isRedirect; // 포워드인지 리다이렉트인지 체크
	
	// path 만 가지는 생성자 
	public ModelAndView(String path) {
		this.path = path;
		this.isRedirect = false;
	}

}
