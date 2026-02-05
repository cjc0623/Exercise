package javaFund.lambda.stream;

import java.util.Arrays;

public class StreamEx3 {

	public static void main(String[] args) {
//		요소를 하나씩 처리하는 메서드 peek(), forEach()
		
		int[] intArr = {2,4};
		int total = Arrays.stream(intArr)
		.filter(value -> value % 2 == 0)
		.peek(value -> System.out.println(value))
		.sum();
		
		System.out.println(total);
//		peek() 은 최종 집계나 함수 처리를 해야만 수행 가능
		
		boolean result = Arrays.stream(intArr)
				.allMatch(value -> value %2 == 0); // 모두 일치하는 것만 추출
				
		System.out.println(result);
		
//		noneMatch 를 이용해서 3의 배수가 없는지의 여부를 검증해보세요
		boolean res = Arrays.stream(intArr)
				.noneMatch(value -> value % 3 == 0);
		System.out.println(res);
	}

}
