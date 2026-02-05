package javaFund.ioex;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class IOEx2 {

	public static void main(String[] args) {
		
		/*
		 * 문자를 쓰고 읽는데 특화된 Reader, Writer
		 * 대표적인 메서드인 write(int character) 가 있고, 이 외에 문자열을
		 * 직접 쓸 수도 있도록 메서드가 정의되어짐.
		 * 어디에 쓸것인지는 자식 클래스로 객체 생성해서 대상을 지정함.
		 * 
		 */
		
		try {
			
			/*
			 * 다음과 같은 로직을 작성하시오.
			 * 1. read() 를 이용해서 test.txt 파일을 읽어서 콘솔에 출력하는 로직 작성
			 * 2. read(char[] arr) 을 이용해서 위 chArr 을 이용, test.txt 파일을
			 * 읽어서 콘솔에 출력하는 로직을 작성하시오
			 * 
			 * 결과는 test.txt 파일의 내용이 두 번 출력 되어야 합니다.
			 */
			
			Reader reader = new FileReader("C:/Temp1/test.txt");
			int data;
			while((data = reader.read())!=-1) {				
				char c = (char)data;
				System.out.println(c);
			}
			reader.close();
			
			
			Reader reader1 = new FileReader("C:/Temp1/test.txt");
			char[] chArr = new char[10];
			
			while(true) {
				int data1 = reader1.read(chArr);
				if (data1 == -1) break;
				
				String str = new String(chArr,0,data1);
				System.out.println(str);
			}
			reader1.close();
			
			
		
			
			
			
//			문자 기반 출력 스트림 생성함
//			Writer writer = new FileWriter("C:/Temp1/test.txt");
//			
//			char a = 'A';
//			writer.write(a);
//			char b = 'B';
//			writer.write(b);
//			
////			char 배열 출력
//			char[] arr = {'c','d','e'};
//			writer.write(arr);
//			
////			문자열 출력
//			writer.write("FGHI");
//			
////			버퍼에 잔류한 데이터를 출력하고 버퍼 닫음
//			writer.flush();
//			writer.close();
//			
			}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
