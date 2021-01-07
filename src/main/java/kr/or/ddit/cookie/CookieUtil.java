package kr.or.ddit.cookie;

public class CookieUtil {
	
	/**
	* Method : getCookieValue
	* 작성자 : PC11-PC
	* 변경이력 :
	* @param cookieStr
	* @param cookieName
	* @return
	* Method 설명 : cookieStr에서 cookieName에 해당하는 쿠키 값을 조회
	*/
	
	//cookieStr : userid=brown; rememberme=Y; test=testcookie
	//cookieName : userid, rememberme
	//return : brown, Y
	public static String getCookieValue(String cookieStr, String cookieName) {
		
		String[] cookies = cookieStr.split("; ");
		
		for(String cook : cookies) {
			//cook : 쿠키 이름 = 쿠키값
			String[] cookie = cook.split("=");
			
			//cookie[0] = 쿠키 이름
			if(cookie[0].equals(cookieName)) {
				return cookie[1];
			}
		}
		
		// 내가 한 소스
//		for(int i =0;  i <=cookies.length; i++) {
//			String ck = String.join("=", cookies);
//			System.out.println(ck);
//			}
		
		return "";
	}
}
