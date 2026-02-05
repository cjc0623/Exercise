package javaFund;

 public class initExam {
	
	public initExam() {
		System.out.println("생성자 호출");
	}

//	static 초기화 블락...
	static {
		System.out.println("클래스의 static 초기화 블락 수행됨");
	}
	{
		System.out.println("인스턴스의 초기화 블락 수행됨");
	}
	void doSome() {
		System.out.println("인스턴스의 doSome 메서드 수행됨");
	}
	
	double getCircle(double r, double r2) {
		return getPI() * r * r;
	}
	
	public static double getPI() {
		return Math.PI;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메인 메서드 실행됨");
		new initExam();
		getPI();
	}

}
