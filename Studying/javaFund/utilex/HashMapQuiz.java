package javaFund.utilex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * HashMap 에 ID(String) 와 점수(Integer) 가 저장되어 있음
 * 실행 결과와 같이 평균 점수, 최고 점수, 최고 점수의 ID 를 출력하도록
 * 코드를 완성하세요.
 */
public class HashMapQuiz {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("blue", 96);
		map.put("white", 82);
		map.put("red", 82);

		String name = null; // 최고 점수를 받은 아이디 변수
		int maxScore = 0; // 최고 점수 변수
		int totalScore = 0; // 점수 합계를 저장하는 변수

//		여기에 코드를 입력하세요..
//		Set<String> keySet = map.keySet();
//
//		for(String k : keySet) {
//			int score = map.get(k);
//			totalScore += score;
//		}
//		double avg = totalScore / (double)map.size();
//		for (String k : keySet) {
//			int score = map.get(k);
//			totalScore += score; 
//
//			if (score > maxScore) {
//				maxScore = score;
//				name = k;
//			}
//		}
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> entry : entrySet) {
			if(entry.getValue() > maxScore) {
				name = entry.getKey();
				maxScore = entry.getValue();
			}
			totalScore += entry.getValue();
		}
		
//		결과는
		/*
		 * 평균점수 : ? 최고점수 : ? 최고 점수를 받은 ID : ?
		 * 
		 * 이렇게 나오면 됩니다.
		 */
		
		int avgScore = totalScore / map.size();
		System.out.println("평균 점수 : " + avgScore);
		System.out.println("최고 점수 : " + maxScore);
		System.out.println("최고 점수를 받은 ID : " + name);
	}

}
