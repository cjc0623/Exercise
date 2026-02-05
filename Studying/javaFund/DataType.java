package javaFund;


/*
 * 자바의 데이터 타입 : 크게 Ptype(기본자료형), Rtype(객체형)으로 나뉩니다.
 * 기본 자료형은 다시 Data의 성격에 따라서 아래처럼 구분 됩니다.
 * 
 * 정수형
 * byte(1byte 크기), short(2byte), int(4byte - default), long(8byte)
 * 
 * 실수형
 * float(4byte), double(8byte - default)
 * 
 * 논리형
 * boolean
 * 
 * 문자형(문자열 아님.. 문자 하나만 담을 수 있는 타입, 얘는 내부적으로 정수형을 취함)
 *  char(2byte)
 *  
 *  위에 나열한 타입외에는 전부 Rtype 즉 객체형 타입임. ex) String 객체
 */
public class DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte b = 125;
		int i = 12345;
//		기억하세요... 자바에서 리터럴 데이터가 연산을 하게될 때는 반드시
//		해당 값의 default 타입의 메모리를 먼저 생성하고 값을 넣은후
//		연산을 하게 됩니다.
//		이때 연산자의 피연산항의 타입의 크기가 서로 틀릴 경우엔, 큰 타입으로 변환되어 결과를 냅니다.

		i = b+1;
		
		long lo = 1L;
		
		long in = lo + 1;
		
//		casting 연산자 : 우측의 데이터 타입을 지정된 타입으로 강제 형 변형 시키는 연산자.. 우측 항 하나에만 적용이 된다
		int it = (int)in + 1;
		
//		float : 4byte 정수타입
		float f = 3.14F;
		
		f = in;
		in = (long)f;
		
		double d = 3.14;
		
		double dd = d + 1;
		
/*
 * 		여러분이 과수원을 한다고 가정하에
 * 		배, 오렌지, 사과를 하루에 각 5, 7, 4 를 생산합니다
 * 		하루를 기준으로(24)시간 시간당 총 생산량을 출력시키세요.
 * 		단, 한번의 리터럴데이터와, 케스팅 연산자를 사용하세요.
 */
		int pear = 5; // 24시간동안 5를 생산 => 1시간에 5/24를 생산
		int orange = 7;
		int apple = 4;
		
		int total = pear + orange + apple;
		
		float avg = (float)(total / 24.0);
		System.out.println("시간당 생산량 : " + avg);
		
		
		
//		문자형 데이터 char
//		''를 이용해서 문자 하나만을 담을 수 있음
		char ch1 = 'a';
		char ch2 = '가';
		
//		unicode 문자셋을 이용합니다. 때문에 내부적으로 정수형으로 사용됩니다.
		ch1 = ++ch1;
		System.out.println(ch1);
//		unicode는 0 ~ 65535까지의 문자 주소를 사용하므로, char 는 음수를 표현할 수 없음
		
//		ch2 = -1; 오류 캐스팅 해줘야 됨
		int chInt = ch1;
		System.out.println(chInt);
		System.out.println((char)chInt);
		
//		논리형 boolean true or false 만 가능
		boolean run = true;
		boolean isStop = false;
		
//		println() : 파라미터로 주어지는 값을 콘솔에 출력하는 메서드
//		모드 데이터 타입(Rtype 포함)을 파라미터로 받을 수 있고, 값을 출력한다.
//		리터럴과 변수는 + 를 이용해서 연결한다.
//		\를 이용해서 escpae 문자 사용가능
		String myName = "최현민";
		System.out.println("안녕하세요 \n\t" + myName + "\n님");
		
//		printf(포맷 출력)
//		특정 포맷대로 출력을 지원하는 콘솔 출력 메서드...
//		%b boolean 형식 
//		%d : 정수
//		%o : 8진수 정수
//		%x : 16진수
//		%f : 소수점
//		%c : 문자형식
//		%s : 문자열 형식
		
		int age = 25; String addr = "경기도";
		System.out.printf("내 나이는 %d 입니다. %n", age);
		System.out.printf("내 나이는 %d 이고, 주소는 %s 입니다. %n", age, addr);
		
//		자리수 지정 여부에 따른 결과..
		System.out.printf("자리수 미지정 : %04d%n", 1);
		System.out.printf("자리수 미지정 : %04d%n", 10);
		System.out.printf("자리수 미지정 : %04d%n", 100);
		System.out.printf("자리수 미지정 : %04d%n", 1000);
		
//		소수점 표현법... : .자리수로 소숫점 자리수를 지정할 수 있다.
		float f1 = 1.23456f;
		System.out.printf("소수점 자리수 지정 : %.4f%n",f1);
		
		
	}

}
