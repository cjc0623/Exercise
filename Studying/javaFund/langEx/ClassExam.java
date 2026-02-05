package javaFund.langEx;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassExam {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

//		Class class 는 클래스에 필요한 정보를 관리하는 클래스입니다.
		
		Class cls = Class.forName("javaFund.langEx.ClassExam");
		System.out.println(cls.getName());
		
		Constructor[] cons = cls.getConstructors();
		for(Constructor con : cons) {
			System.out.println(con);
		}
//		메서드 이름을 출력시켜보세요. API를 참조 하세요.
		
		Method[] met = cls.getMethods();
		for(Method name : met) {
			System.out.println(name.getName());
		}
		
	}
	
	
	void a() {
		
	}
	void b() {
		
	}

}
