package com.kh.map;

import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/*
 * Properties
 * - HashMap 구버전인 HashTable(Object, Object)을 상속받아 구현한 것
 * - (String, String) 형태로 단순화된 컬렉션 클래스
 * - 주로 환경설정과 관련된 속성(property)을 저장하는데 사용 
 * */
public class B_Properties {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		// 키값 중복 X 순서 X 같은 키 나중에 추가면 수정 
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop);
		
		Enumeration en = prop.propertyNames();
		while(en.hasMoreElements()) { // 다음요소가 있는지?
			String key = (String)en.nextElement();
			String val = (String)prop.get(key);
			System.out.println(key + " : " + val);
		}
		
		Set<Entry<Object, Object>> entlySet = prop.entrySet();
		for(Entry<Object, Object> entry : entlySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
