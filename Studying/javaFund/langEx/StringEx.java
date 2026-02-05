package javaFund.langEx;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;

public class StringEx {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		/*
		 * 스트링객체는 ""를 이용해서 생성시엔, 공유영역에 저장하고, 같은 값을 가진 문자열을 "" 로 생성하게 되면 같은 객체의 ref 를 되돌려
		 * 줍니다. 즉 같은 객체라는 뜻입니다.
		 * 
		 * 자바에선는 객체간의 비교시 == 의 의미는 같은 객체인지를 물어보는 것입니다. 즉 ref가 같은지를 물어보는 것이지요.
		 * 
		 */
		String a = "hello";
		String b = "hello";

		System.out.println(a == b);

//		생성자를 이용한 문자열 객체 생성하기
		String c = new String("hello");
		System.out.println(a == c);

		String st = new String();

		byte[] bs = { 49, 50, 51 };
//		위 배열의 값을 문자열로 생성함
		st = new String(bs);
		System.out.println(st);

		st = new String(bs, 0, 2, "EUC-KR");
		System.out.println(st);

//		기본 문자셋 정보 얻어내보기
		Charset cset = Charset.defaultCharset();
		System.out.println(cset.toString());

		char[] chArr = { '자', '바', '는', '재', '미' };
		String chStr = new String(chArr, 3, 2);
		System.out.println(chStr);

		System.out.println(chStr.contains("미"));

//		equals(String) : 두 개의 문자열 값이 같으면 true, 아니면 false 를 리턴함
		System.out.println(c.equals(a));

		System.out.println(Arrays.toString("안녕오늘은 뭐해?".getBytes()));

		bs = new byte[] { -20, -107, -120, -21, -123, -107, -20, -104, -92, -21, -118, -104, -20, -99, -128, 32, -21,
				-83, -112, -19, -107, -76, 63 };
		st = new String(bs);
		System.out.println(st);

//		여러분의 이메일을 변수에 담아서, @을 기준으로 id 분리해서 그걸 char 배열로 변환해서
//		그것의 길이와, 값을 출력해보세요.

		String email = "cjc0623@naver.com";

		String id = email.split("@")[0];
		char[] idChar = id.toCharArray();

		System.out.println("아이디 길이 : " + idChar.length);
		System.out.println("아이디 : " + id);

		System.out.print("배열 원소: " + Arrays.toString(idChar));

//		charset 인터페이스에 보면, 문자셋을 리턴하도록 하는 메서드가 있습니다.
//		자바에서 지원하는 문자셋이 무엇인지를 출력하도록 해보세요
//		AI를 이용해도 좋습니다.

		Charset.availableCharsets().forEach((t, u) -> System.out.println(t));

		StringBuilder sb = new StringBuilder("hello");
		System.out.println("내부 버퍼의 크기 : " + sb.capacity());
		
//		문자열을 끝에 추가하는 메서드 append(); 오버로딩 되어 있어서 파라미터 타입에 맞게 사용함.
		sb.append("world");
		System.out.println(sb);
		
//		문자열 중간에 문자 넣기
		sb.insert(1,  "h");
		System.out.println(sb);
		
//		문자열 지우기
		sb.delete(0,3);
		System.out.println(sb);
		
//		o 다음에 공백을 추가해서 llo world 가 되도록 해보세요
		
		sb.insert(sb.indexOf("w"), " ");
		System.out.println(sb);
		
//		sb 객체의 값을 String 객체로 생성해보세요.
		
		System.out.println(sb.toString());
		
		byte[] b1 = "abcde".getBytes();
		byte[] b2 = "jklmn".getBytes();
		System.arraycopy(b1, 0, b2, 0, b1.length);
		System.out.println(Arrays.toString(b2));
		
		System.out.println(new String(b2));
		
		System.out.println(new Date(System.currentTimeMillis()));
		
//		자바프로그램을 강제 종료 시키는 메서드
//		System.exit(0);
		
//		자바의 Wrapper 클래스
//		자바에서 사용되는 모든 Ptype을 클래스로 정의한 클래스
//		이 클래스를 이용하면 ptype 에 관련된 많은 정보를 손쉽게 사용할 수 있다.
	
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Integer.compare(1000, 300));
		
		int i = 10;
		Integer.valueOf(i).byteValue();
		
		System.out.println(Integer.parseInt("10"));
		
		String pass = "AasAdF1dx"; //숫자하나와 대문자가 포함 되어야 한다라고 가정합니다.
		int digitCnt = 0, alphaCnt = 0;
		for(int ii = 0; i<pass.length(); ii++) {
//			문자를 하나씩 분리한다
			char ch = pass.charAt(ii);
			
//			분리된 문자가 대문자인지, 숫자인지 검증한다.
			if(Character.isUpperCase(ch)) {
				alphaCnt++;
			}if(Character.isDigit(ch)) {
				digitCnt++;
			}
			
		}
		
		
		
	
	}

}
