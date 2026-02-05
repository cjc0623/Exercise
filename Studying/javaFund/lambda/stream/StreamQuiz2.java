package javaFund.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
*  List 에 저장된 Member 의 평균 나이를 출력하시오.
*/

@AllArgsConstructor
@Data

class Member{
	private String name;
	private int age;
	private String job;
}
public class StreamQuiz2 {

	public static void main(String[] args) {
		List<Member> list = 
				Arrays.asList(new Member("AA", 40, "developer"),
						new Member("BB", 25, "designer"), new Member("CC",37, "developer"));
		
		
//		위 리스트에서 직업이 developer 인 객체만 추려서
//		developers 라는 리스트로 새롭게 생성 후 직업을 출력하시오.
		
		List<Member> developers = list.stream()
				.filter(developer -> developer.getJob().equals("developer"))
				.collect(Collectors.toList());
		
		System.out.println(developers);
		
//		여기에 평균 구하는 코드 작성.. 스트림을 이용합니다.
		double avg = list.stream()
				.mapToInt(member -> member.getAge())
				.average()
				.getAsDouble();
		System.out.println(avg);
		
		
	}

}
