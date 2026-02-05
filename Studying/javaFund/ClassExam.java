package javaFund;
/*
 * 자바 클래스 : 클래스란, 실제 어플리케이션이 수행 될때 사용되는 객체의 설계도 입니다.
 * 이 설계도에 우리가 목적하는 업무를 정의하고, 이를 객체화 시켜서 수행하도록 하는데 목적이 있습니다.
 * 
 * 때문에 객체지향에서는 클래스의 설계가 무척 중요한데, 클래스의 구조에 대해서 먼저 알아볼게요.
 * 
 * 클래스는 크게 3형식의 구조로 되어 있습니다.
 * 
 * 1. 필드(field) : 멤버 필드라고도 하며, 객체의 상태를 나타내는 변수 입니다. 
 * 이 말은, 이 필드를 가지고 있는 객체의 상태가 어떤것인지를 이변수의 값에 따라서 확인 할 수 있다는 뜻입니다.
 * 이 필드는 클래스로부터 객체가 생성될 때 객체에 복사되어 들어가고, 초기 설정값을 지정하지 않으면 타입의 기본값으로 초기화 되어집니다.
 * 
 * 
 * 2. 생성자(constructor) : 생성자는 메서드의 일종인데, 메서드와는 하는 일이 다릅니다.
 * 형식만 비슷합니다.(단, 리턴타입이 없고, 이름이 클래스명과 반드시 같다라는 특징)
 * 이 생성자가 하는 주 역할은, 클래스를 바탕으로 실제 객체를 생성하는 역할을 하고, 필요에 따라서
 * 객체 초기화 즉 필드 초기화 역할을 합니다. 목적에 따라서는 초기화 메서드를 호출하는 역할도 합니다.
 * 
 * 
 * 3. 메서드(method) : 클래스 또는 객체가 수행할 행위를 이 메서드를 통해서 정의합니다.
 * 객체와의 유기적인 작업은 이 메서드를 이용해서 주로 하며(필요에 따라서는 필드를 통함), 필요에 따라서 getter, setter 를 통해
 * 필드의 값을 set/get 하기도 합니다.
 */

// 우리반 학생들의 객체를 생성해서, 정보를 출력하는 클래스를 정의할 예정입니다.
// 즉 정의된 클래스를 바탕으로 실제 학생 객체를 몇개 생성할 예정이란 뜻입니다.
// 클래스를 정의 시, 이러한 객체들이 공통적으로 가지고 있는 공통 속성을 필드로 추출하는 작업부터 합니다.

class FullStackStudent { // 멤버 필드
	/*
	 * 접근 제어자(Access Modifier) : private < default < protected < public 중 하나로, 클래스에는
	 * default 와 public 만, 나머지 필드, 생성자, 메서드에는 위 중 하나를 선언해서 클래스 내-외부에서 접근하는것을 제어 할 수
	 * 있습니다.
	 * 
	 * 이 중 가장 강력한 접근 제어는 private 으로 오직 자신 클래스에서만 접근 가능합니다. 이를 사용하는 가장 큰 목적은 선언된 구문의
	 * 접근을 오직 자신에게만 국한되게 할 때 사용됩니다. 외부에서 접근시엔 컴파일 에러를 유발합니다.. 이렇게 하는 것을 캡슐화 라고 합니다.
	 */

	private String name;
	private int age;
	private char grade;

//	생성자 : 클래스를 바탕으로 인스턴스를 생성해주는 실제 코드
//	생성자의 문법으로는 [접근 제어자] 클래스명([파라미터]){생성자 코드} 의 형태이다.

//	기본 생성자 : 파라미터는 없고, 필드의 값을 default 로 초기화 해주는 생성자를 말함
//	모든 클래스를 정의 한 후 컴파일 하면, 컴파일러가 자동으로 생성해서 클래스에 넣어줌
//	단!!! 프로그래머가 정의한 생성자가 하나도 없을 경우에만 넣어줌.. 만약 하나라도 프로그래머가 직접 정의하면
//	기본 생성자를 넣어주지 않음.. 꼭 기억하세요

	public FullStackStudent() {
		this.name = null; // 내 자신이 나를 바라보게 만듧
		this.age = 0;
		this.grade = ' ';
	}

//	생성자 오버로딩 : 같은 이름의 생성자를 정의하고, 파라미터의 순서, 갯수, 타입만 변경해서 정의 하면
//	이를 호출할 때 VM이 동적으로 해당되는 생성자 또는 메서드를 호출해서 실행하도록 하는 것.
//	이름나 초기화 하는 생성자 정의
	public FullStackStudent(String name) {
		this();
		this.name = name;

	}

	public FullStackStudent(String name, int age) {
		this(name);
		this.age = age;

	}

	public FullStackStudent(String name, int age, char grade) {
		this(name, age);
		this.grade = grade;

	}

//	이름을 리턴하는 메서드 정의
//	메소드 구문응 음과 같음
//	[접근 제어] [static] return type methodName([파라미터])

	public String getName() {
		return this.name;
	}

	public String getName(String id) {
		return this.name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class ClassExam {
	
	private double r1;
	private double r2;
	
	public ClassExam(double r1, double r2) {
		this.r1 = r1;
		this.r2 = r2;
		
	}
	
//	면적을 구하도록 하는 메서드를 정의 합니다.
	public double getArea() {
		return r1 * r2 * initExam.getPI();
	}
	
	public static void main(String[] args) {
//		학생 클래스를 바탕으로 나(me) 객체를 생성합니다.
//		클래스의 객체를 생성할 때 키워드는 new 입니다.
//		new 다음에 클래스의 생성자를 호출하면, JAVA VM 은
//		프로그램 실행 시에 동적으로 heap 메모리 영역에 객체를 생성하고
//		이를 참조하는(Reference) 참조값을 리턴해줍니다.

		FullStackStudent me = new FullStackStudent();
		FullStackStudent hm = new FullStackStudent("현민");
//		생성자를 호출해서 인스턴스를 발생시키는 과정을 instantiation (클래스의 인스턴스를 생성한다) 라고 합니다.
		System.out.println(me);
		System.out.println(hm.getName());
//		속성을 직접 접근해서 속성의 값을 대입합니다.
//		me.name = "최현민";
//		System.out.println(me.name);

	}

}
