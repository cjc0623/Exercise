package javaFund.ioex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class IOEx3 {

	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("C:/Temp1/test.txt");
		Writer writer = new OutputStreamWriter(os, "UTF-8");
		writer.write(str);
		writer.flush();
		writer.close();
	}

	public static String read() throws Exception {
		InputStream is = new FileInputStream("C:/Temp1/test.txt");
		InputStreamReader reader = new InputStreamReader(is, "UTF-8");

		char[] data1 = new char[100];

		int length = reader.read(data1);

		reader.close(); // 맨 마지막에 꼽은 스트림만 닫으면 내부적으로 다 닫힘..
//		때문에 reader 만 close() 호출함..
		
		String result = new String(data1, 0, length);

		return result;
	}

	public static void main(String[] args) throws Exception {
		write("문자 변환 스트림을 사용하는 예시 입니다.");

		String data = read();
		System.out.println(data);

	}

//	read 메서드를 다음과 같이 정의 하세요
	/*
	 * Reader 에 inputStreamReader 를 꼽고, InputStreamReader 에는 FileInputStream 을 꽂으세요.
	 * 
	 * 이렇게 스트림을 연결한 후, 100 size 의 char 배열을 생성해서 reader 를 이용해서 읽은 데이터를 String 타입의 변수에
	 * 담아서 리턴시키세요.
	 */

}
