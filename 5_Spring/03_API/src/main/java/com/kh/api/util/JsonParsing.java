package com.kh.api.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;


public class JsonParsing {

	public static void main(String[] args) {
		String serviceKey = "nNvVK8i9J%2FHzp4dsTJKYOXmUt9KKTpk2HpXqnrE0BrUqMJH0cl7O6NVh0J4FSpFQJjnoBfLBhEk5LdtaI%2BY47w%3D%3D";
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=" + serviceKey +"&numOfRows=10&resultType=json";
		
		try {
			URL requestUrl = new URL(url);
			HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
			urlConnection.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line = null;
			
			StringBuffer responseBuffer = new StringBuffer();
			
			while((line = br.readLine()) != null) {
				responseBuffer.append(line);
			}
			br.close();
			urlConnection.disconnect();
			
			String responseData = responseBuffer.toString();
//			System.out.println(responseData);
			
			JSONObject jsonResponse = new JSONObject(responseData);
			
			JSONObject jsonData = jsonResponse.getJSONObject("getFoodKr");
//			System.out.println(jsonData);
			
			JSONArray items = jsonData.getJSONArray("item");
			
//			for(Object json : items) {  오브젝트로만 뽑기가능해서... 안에꺼 계속 뽑아야하기떄문에 일반 for문 보통 사용
//				System.out.println(json);
//			}
			
			for(int i=0; i< items.length(); i++) {
				JSONObject result = items.getJSONObject(i);
				System.out.println("가게이름 : "+result.getString("MAIN_TITLE"));
				System.out.println("위도 : "+ result.getDouble("LNG"));
				System.out.println("경도 : "+result.getDouble("LAT"));
				System.out.println("매뉴 : "+result.getString("RPRSNTV_MENU").trim());
				System.out.println("-----------------------");
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
