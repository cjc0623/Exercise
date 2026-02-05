package javaFund.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list2 = new ArrayList<Student>();
		
		list2.add(new Student("학생1", 80, "남"));
		list2.add(new Student("학생2", 90, "여"));
		list2.add(new Student("학생3", 85, "남"));
		list2.add(new Student("학생4", 100, "여"));
//		남학생만 추출해서 maleList 라는 ArrayList 에 담으세요.
		
		List<Student> maleList = new ArrayList<>();
		
		for (Student student : list2) {
			if (student.getSex().equals("남")) {
				maleList.add(student); 
			}
		}
		System.out.println(maleList);
		
		
		
//		collect() 를 이용한 집계
		List<Student> maleList2 = list2.stream()
				.filter(student -> student.getSex().equals("남"))
				.collect(Collectors.toList());
		System.out.println(maleList2);
		
		
		List<Student> maleList3 = list2.stream()
				.filter(student -> student.getSex().equals("남"))
				.toList();
		
		System.out.println(maleList3);
		
		
//		Map 형태로 변형도 가능함...
		Map<String, Integer> map = list2.stream()
			.collect(Collectors.toMap(t -> t.getName(), t -> t.getScore()));
		
		System.out.println(map);
		}

	}

