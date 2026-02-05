package javaFund.utilex;

import java.util.NavigableSet;
import java.util.TreeSet;

/*
 * 정렬과, 검색 기능을 특화한 API TreeSet, TreeMap...
 */
public class TreeSetExam {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));

		
//		지정된 Integer 객체를 하나씩 get..
		for(Integer i : scores) {
			System.out.println(i+" : ");
		}
		System.out.println();
		
//		메서드를 이용해서 가장 낮은 점수부터, 상대 점수까지 get 해보기
		System.out.println(scores.first()); // 제일 처음 나오는 점수 즉 가장 낮은 점수
		System.out.println(scores.last()); // 제일 마지막에 나오는 점수 즉 가장 높은 점수
		System.out.println("95점 아래 점수 : " + scores.lower(95));
		System.out.println("95점 위 점수 : " + scores.higher(95));
		System.out.println("95점 이거나 아래 점수 : " + scores.floor(95));
		System.out.println("95점 이거나 위 점수 : " + scores.ceiling(95));
		
		NavigableSet<Integer> navigableSet = scores.descendingSet();
		for(Integer i : navigableSet) {
			System.out.println(i);
		}
		System.out.println();
		
//		tailSet() : 80<= 범위의 값을 생성합니다.
		NavigableSet<Integer> rangeSet = scores.tailSet(80,true);
		for(Integer i : rangeSet) {
			System.out.println(i);
		}
		System.out.println();
		
//		범위검증 2..subSet(범위1,포함여부,범위2,포함여부)
//		범위1 <= 값 < 범위2
		
		NavigableSet<Integer> bSet = scores.subSet(70, true, 90, true);
		for(Integer i : bSet) {
			System.out.println(i);
		}
	}

}
