package javaFund.lambda.stream;

import java.util.Arrays;
import java.util.List;

/*
 * List 에 저장되어 있는 String 요소에서 대소문자와 상관없이 
 * java 라는 단어가 포함된 영문자만 필터링해서 출력 할거임
 * 빈칸 코드를 채워주길 바람...
 */
public class StreamQuiz1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("This is a Java class"
				,"Lambda 표현식을 배웁니다.", "java8 부터 람다가 지원됩니다.");
		
		List<String> List = list.stream()
	            .filter(t -> t.toLowerCase().contains("java"))
	            .toList();
		
		System.out.println(List);
	}

}
