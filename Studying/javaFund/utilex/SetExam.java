package javaFund.utilex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MyCls {
	public String name;
	public int age;

	public MyCls(String string, int i) {
		this.name = string;
		this.age = i;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
//		파라미터로 오는 obj 의 속성 값을 비교해서 결과를 boolean 으로 리턴하는 로직을 작성한다.
//		여기서는 두개의 필드값이 같은 경우 중복이라고 정의해서 두 필드의 값이 같으지를 연산해서 결과를 리턴 시킨다.
		if (obj instanceof MyCls) {
			MyCls target = (MyCls) obj;
			return target.name.equals(name) && (target.age == age);
		} else {
			return false;
		}
	}

	public class SetExam {

		public static void main(String[] args) {

//		Set 은 데이터 저장시 hash 값을 기준으로 저장함
//		따라서 같은 hash 가 존재하면 중복저장을 하지 않음
//		대표적 클래스로는 HashSet 를 주로 사용함
//		정렬을 고려할 때는 TreeSet 도 사용함.

			Set<String> set = new HashSet<String>();

			set.add("java");
			set.add("jdbc");
			set.add("jsp");
			set.add("java");
			set.add("spring boot");

			System.out.println(set.size());

			set.clear();

			MyCls my1 = new MyCls("홍길동", 30);
			MyCls my2 = new MyCls("홍길동", 30);
			MyCls my3 = new MyCls("아이언맨", 40);
			HashSet<MyCls> set2 = new HashSet<MyCls>();
			set2.add(my1);
			set2.add(my2);
			set2.add(my3);
			System.out.println(set2.size());

//		set 은 index 로 데이터를 저장하지 않습니다.
//		때문에 전체를 get 하는 방법에는 다음과 같은 방법으로 합니다.
			for (MyCls e : set2) {
				System.out.println(e);
			}

//		Iterator 로 변환해서 모든 요소를 get 하는 방법
			Iterator<MyCls> iterator = set2.iterator();
			while (iterator.hasNext()) {
				MyCls m = iterator.next();
				System.out.println(m.name);
				System.out.println(m.age);
			}
			
//			List 에 담아서 추출 하는 방법도 있음.
			ArrayList<MyCls> myList = new ArrayList<MyCls>(set2);
			for(int i = 0; i<myList.size(); i++) {
				System.out.println(myList.get(i).name);
			}
		}
	}
}
