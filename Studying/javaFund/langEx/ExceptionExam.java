package javaFund.langEx;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("가위바위보(1,2,3) 입력해 ");

		int input = 0;

		try {
			input = sc.nextInt();
		} catch (InputMismatchException e) {

			System.out.println("예외가 발생함");
			System.out.println(e.getMessage());
//			e.printStackTrace();

		}

		System.out.println(input);

//		파일에 접근하는 API 를 사용하려 함..
		try {
			FileReader fr = new FileReader("message.txt");
			
			while(true) {
				int i = fr.read();
				if(i == -1) 
					break;
				System.out.print((char)i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
