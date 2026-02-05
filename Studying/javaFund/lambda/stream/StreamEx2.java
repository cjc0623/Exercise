package javaFund.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamEx2 {
	
	public static void main(String[] args) {
		
//		Student 객체 3개를 ArrayList list2 에 담아보세요.
		List<Student> list2 = new ArrayList<Student>();
		list2.add(new Student("학생1", 80, "남"));
		list2.add(new Student("학생2", 90, "여"));
		list2.add(new Student("학생3", 85, "남"));
		
		list2.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(t -> System.out.println(t));
		
		
		
		
		List<String> list1 = new ArrayList<String>();
		list1.add("자바 수업중");
		list1.add("빠르면 말해주세요.");
		
		list1.stream()
		.flatMap(t -> Arrays.stream(t.split(" ")))
		.forEach(word -> System.out.println(word));
		
		
//		List<String> list2 = Arrays.asList("10", "20", "30", "40", "50");
//		list2.stream()
//		.flatMapToInt(data -> {
//			String[] strArr = data.split(",");
//			int[] intArr = new int[strArr.length];
//			for(int i = 0; i<strArr.length; i++) {
//				intArr[i] = Integer.parseInt(strArr[i].trim());
//			}
//			return Arrays.stream(intArr);
//		}).forEach(number -> System.out.println(number));
		
		
		
		
		
		
		
		
		
		
		List<Student> list = new ArrayList<Student>();
		
//		list.add(new Student("홍길동", 85));
//		list.add(new Student("아이언맨", 90));
//		list.add(new Student("일지매", 95));
		
//		Student 를 Score 스트림으로 변환.
		list.stream()
		.mapToInt(value -> value.getScore())
		.forEach(value -> System.out.println(value));
	}

}
