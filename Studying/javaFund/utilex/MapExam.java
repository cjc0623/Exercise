package javaFund.utilex;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map : 데이터를 key:value 구조로 저장함.
 * 모든 요소는 반드시 객체 이어야 함.
 * 같은 key 는 나중에 추가한 key 로 덮어씀.
 * 대표적인 클래스로는 HashMap 을 사용함
 */
public class MapExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new HashMap();
		
//		데이터 추가..
		map.put("a", 40);
		map.put("b", 80);
		map.put("c", 60);
		map.put("d", 100);
		System.out.println("총 entry 수 : " + map.size());
		System.out.println();
		
		String key = "a";
		int value = map.get(key);
		System.out.println(key + " : " + value);
		System.out.println();
		
//		Map 은 컬렉션의 자식이 아니므로, 직접적으로 Collection 타입의 구조로
//		변환 불가능함..(생성자 등...)
//		하지만 내부 메서드를 통해서 set 으로 변환이 가능함..
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIter = keySet.iterator();
		while(keyIter.hasNext()) {
			String k = keyIter.next();
			Integer v = map.get(k);
			System.out.println(k+ " : " + v);
			
		}
		System.out.println();
		
//		entrySet 을 이용한 key:value Entry 객체 얻어내기
		Set<java.util.Map.Entry<String,Integer>> entrySet = map.entrySet();
		Iterator<java.util.Map.Entry<String, Integer>> entryIt = entrySet.iterator();
		
		while(entryIt.hasNext()) {
			java.util.Map.Entry<String, Integer> entry = entryIt.next();
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println("k " +k+ " : " + "v " + v);
			}
	}

}
