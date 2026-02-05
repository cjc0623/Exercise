package Project.Gawibawibo;

import java.util.regex.Pattern;

public class Idpassword {
	
//	이메일 형식 정규 패턴식
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
	
//	8 ~ 12 사이의 영대문자, 숫자, 특문이 하나 이상 포함된 비밀번호 정규 패턴식
	private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,12}$";
	
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
	
	
//	이메일의 유효성 체크
	public static boolean isValidEmail(String email) {
		if (email == null) {
			return false;
		}
		return EMAIL_PATTERN.matches(EMAIL_REGEX, email);
		
	}
	
//	비밀번호의 유효성 체크
	public static boolean isValidPassword(String password) {
		if (password == null) {
			return false;
		}
		return PASSWORD_PATTERN.matches(PASSWORD_REGEX,password);
		
	}
	
	public static void main(String[] args) {
		/*
		 * 이메일 형식의 ID와 
		 * 8~12 사이의 영대문자,
		 * 숫자,특문 하나가 포함 되어야 하는 비밀번호 정규표현식을 담은 클래스
		 */
		
//		테스트 코드
		
//		String email = "java@test.com";
//        String pw = "Gawi1234!";
//
//        System.out.println("ID(이메일) 유효성: " + isValidEmail(email));
//        System.out.println("비밀번호 유효성: " + isValidPassword(pw));
	}
}
