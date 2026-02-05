package javaFund.utilex;

import java.util.HashSet;
import java.util.Set;

/*
 * HashSet 에 Student 를 저장하려 함.. 학번이 같으면 동일한 Student
 * 객체라고 인식해서 중복 저장이 안되도록 하여야 함. Student 의 학번이 hash 코드라고 생각하고
 * Student 클래스를 정의 합니다.
 */
class Student {
	public int studentNum;
	public String name;

	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}

//	여기에 코드를 완성하세요.
	@Override
	public int hashCode() {
		return this.studentNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student target = (Student) obj;
			return target.studentNum == this.studentNum;
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "학번 : " + studentNum + " 이름 : " + name;
	}
}

public class HashSetQuiz {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();

		set.add(new Student(1, "제니"));
		set.add(new Student(2, "로제"));
		set.add(new Student(1, "리사"));

		System.out.println("저장된 객체(학생) 수 : " + set.size());
//		전체 학생의 정보를 출력하는 코드 작성하세요.
		for (Student s : set) {
			System.out.println(s);
		}

	}

}
