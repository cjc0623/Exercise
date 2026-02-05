package javaFund.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Stream : 그룹핑 되어 있는 요소들(배열, collection, map 등)
 * 을 빠른 속도로 접근 하여 다음 작업들로 연결 할 수 있는 기능을 가진 인터페이스
 * 
 * 이 스트림을 이용하면, 기존방식 for, Iterator 등으로만 처리했던 방식을
 * 대체하면서 다양한 중간 처리 방식을 적용할 수 있다.
 * 속도도 매우 빠르다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// 정렬기능을 구현하기 위해 Compareable 을 구현한다.
class Student implements Comparable<Student>{
	private String name;
	private int score;
	private String sex;
	
	@Override
	public int compareTo(Student o) {
		return Integer.compare(score, o.score);
	}
}

@Data
@AllArgsConstructor
class Product{
	private int pno;
	private String name;
	private String company;
	private int price;
}
public class StreamEx1 {
	
	static int sum = 0;

	public static void main(String[] args) {
		
		
		
		List<String> lt = new ArrayList<String>();
		lt.add("홍길동");
		lt.add("홍길동B");
		lt.add("홍길동C");
		lt.add("홍길동");
		
		lt.stream().distinct().forEach(t -> System.out.println(t)); // 중복 제거
		
		
		
		List<Product> li = new ArrayList<Product>();
		for(int i = 0; i<5; i++) {
			Product p = new Product(i, "상품" + i, "삼성", (int)(Math.random() * 10000));
			
			li.add(p);
					
		}
		
		li.stream().filter(t -> t.getPrice() > 5000).forEach(t -> System.out.println(t));
		
		
		
		
		
		
//		위 li 를 스트림으로 생성해서 내부의 Product 를 모두 출력하라.
//		forEach 이용하라는 뜻임
		
		li.forEach(p -> System.out.println(p));
		
		System.out.println(new Product(1, "상품1", "삼성", 10000));
		
		
//		특정 정수 범위만큼의 스트림을 생성해서 값출력해보기
		IntStream.rangeClosed(0, 100)
		.forEach(i -> sum += i);
		System.out.println(sum);
		
		
		
		
		
		
		
//		List<Student> list = Arrays.asList(
//				new Student("AA",10),
//				new Student("BB",20),
//				new Student("CC",30)
//		);
//		
//		Stream<Student> str = list.stream();
//		IntStream is = str.mapToInt(student -> student.getScore());
//		OptionalDouble od = is.average(); // 학생 점수 스트림에서 평균을 구한다.
//		double avg = od.getAsDouble(); // od 객체에서 평균 값을 리턴받는다.
//		double avg2 = list.stream().mapToInt(std -> std.getScore()).average().getAsDouble();
		
		
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		set.add("A");
		set.add("B");
		set.add("C");
		
		for(String s : set) {
			System.out.println(s);
		}
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Stream<String> stream = set.stream();
		stream.forEach(t -> System.out.println(t));
		 
	}

}
