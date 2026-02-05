package javaFund.utilex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * ArrayList : 컬렉션의 대표적인 클래스, 같은 타입의 객체를 배열처럼 관리하는 자료구조임
 * 
 */
public class ListExam {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList(); // Integer 객체만 요소로 관리하겠다는 의미 <제네릭>
		System.out.println(list.size());
		
		list.add(1); 
//		list.add("이");
		list.add(3);
		System.out.println(list.size());
		
		Integer ig = list.get(0);
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.add(0, 100);
		System.out.println(list);
		
		ArrayList list2 = new ArrayList<Integer>();
		list2.add(300);
		
//		리스트에 리스트 넣기
		list2.addAll(list); // list2에 list 넣기
		System.out.println(list2);
		
		System.out.println(list2.contains(1));
		
		list2.clear();
		System.out.println(list2);
		
//		set() 을 이용해서 1번 요소의 값을 2000으로 대체하세요.
		System.out.println(list);
		list.set(0, 2000);
		System.out.println(list);
		
		
		
//		Player 2명을 생성합니다.
		Player p1 = new Player();
		Player p2 = new Player();

		
		p1.setId("p1");
		p1.setPw("1234");
		p1.setName("게이머1");
		p1.setLose((int)(Math.random() * 10));
		p1.setDraw((int)(Math.random() * 10));
		p1.setWin((int)(Math.random() * 10));
		
		
		p2.setId("p2");
		p2.setPw("3456");
		p2.setName("게이머2");
		p2.setLose((int)(Math.random() * 10));
		p2.setDraw((int)(Math.random() * 10));
		p2.setWin((int)(Math.random() * 10));
		
		List<Player> players = new ArrayList<Player>();
		
		players.add(p1);
		players.add(p2);
		
		new UseList().showUsers(players);
		List<Integer>li = new ArrayList<Integer>();
		li.add((int)(Math.random()*10));
		li.add((int)(Math.random()*10));
		li.add((int)(Math.random()*10));
		li.add((int)(Math.random()*10));
		li.add((int)(Math.random()*10));
		
		System.out.println(li);
//		Collections 라는 클래스의 메서드를 이용해서 정렬합니다.
		Collections.sort(li, Collections.reverseOrder()); //오름차순은 그냥 sort로 내림차순은 reverseOrder()로 
		System.out.println(li);
		
		
	
	}
} 
