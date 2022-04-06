package com.uphill.web.util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Date;

public class SHA256Encoder {
		
	public static String encode(String source, String salt){ // soure: 암호화되기 전 비번
		String result = "";
		
		try {
			byte[] saltByte = salt.getBytes(); //salt를 바이트로 변경
			byte[] sourceByte = source.getBytes("utf-8");//암호화되기 전 비번(source)도 바이트로 변경			
			
			/*
			 * 기본값으로 채워진 byte객체에 바이트로 변경된 소금값과 비번으로 채움
			 */
			byte[] saltSource = new byte[saltByte.length + sourceByte.length]; 
			
			//소금값을 암호 앞, 뒤 어느쪽에 붙여도 상관 없다. 비밀번호 앞에 사용하는게 좀 더 일반적이긴 하다.
			//void arraycopy(원본, 원본의 시작 index, 도착지, 도착지의 시작index, 복사할 개수)
			System.arraycopy(saltByte, 0, saltSource, 0, saltByte.length);//saltSource [앞] : 바이트로 변경된 "salt값"			
			System.arraycopy(sourceByte, 0, saltSource, saltByte.length, sourceByte.length);//saltSource [뒤] : 바이트로 변경된 암호화되기 전 "비번"
			//즉, saltSource [앞] : 바이트로 변경된 "salt값" + [뒤] : 바이트로 변경된 암호화되기 전 "비번"
			
			/* 'SHA-256알고리즘'을 사용하기 위해 먼저,import java.security.MessageDigest;
			 * new 생성자를 따로 쓸 필요 없이 아래와 같이 하면 자동으로 객체 생성됨
			 */
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			//md.update(byte[] input)가 바로 입력한 문자열을 해싱하는 함수다. 이 때 문자열은 바이트배열이어야 한다.
			md.update(saltSource);
			
			byte[] saltSourceDigest =  md.digest();//md객체의 다이제스트를 얻어 password를 갱신한다.
					
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<saltSourceDigest.length ;i++) {
				/* 1.saltSourceDigest의 하나하나의 byte를 16진수로 변경 ->2."16진수" -> 3.StringBuffer에 추가
				 * byte를 16진수로 변경하는 이유?
				 * 기본적으로 데이터는 binary data로 전달된다.
				 * 16진수 배열로 만들 경우 데이터의 손실없이 유지할 수 있는 장점이 있다.
				 * 꼭 16진수로 변환하지 않고 Base64 같은 64진수로도 표현되기도 한다.
				 */
				//1.saltSourceDigest의 하나하나의 byte를 16진수로 변경 ->2."16진수" -> 3.StringBuffer에 추가
				sb.append(Integer.toString((saltSourceDigest[i]&0xFF)+0x100, 16).substring(1));
			}
			result = sb.toString(); // StringBuffer안의 값을 String객체 생성
		
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return result;
	}
	
	/*
	 * 임시 비밀번호 생성
	 * getRamdomPassword(8)를 호출하면 8 글자의 임시비밀번호가 생성됩니다.
	 * (1.'영어대소문자+숫자+특수문자'가 결합된 8 글자의 임시비밀번호 생성됨)
	 * (2.'영어대소문자+숫자'가 결합된 8 글자의 임시비밀번호 생성됨)
	 */
	public static String getRandomPassword(int size){
		//1.'영어대소문자+숫자+특수문자'가 결합된 8 글자의 임시비밀번호
		/*
		char[] charSet = new char[] { 
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
				'!', '@', '#', '$', '%', '^', '&' }; 
		*/
		
		//2.'영어대소문자+숫자'가 결합된 8 글자의 임시비밀번호
		char[] charSet = new char[] { 
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
		         };//특수문자 제외
		
		StringBuffer sb = new StringBuffer(); 
		SecureRandom sr = new SecureRandom(); 
		sr.setSeed(new Date().getTime()); 
		
		int idx = 0; 
		int len = charSet.length; 
		for (int i=0; i<size; i++) { 
			// idx = (int) (len * Math.random()); 
			idx = sr.nextInt(len); // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다. 
			sb.append(charSet[idx]); 
		} 
		return sb.toString(); 
	}
}
