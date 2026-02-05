package javaFund.ioex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOEx4 {

//	BuferedReader and Writer.. 버퍼를 이용해서 읽어온 데이터를 버퍼메모리에 담은 후
//	프로그래머는 이 버퍼메모리의 데이터를 읽거나 쓴다.
//	효율적인 입출력을 위해서는 반드시 사용해야 한다.

	public static void main(String[] args) throws IOException {

//		같은 클래스 path 에 있는 이미지 접근해보기
		String originalFilePath = IOEx4.class.getResource("org.png").getPath();
		System.out.println(originalFilePath);

//		복사할 경로 및 파일명 path 초기화
		String targetFilePath1 = "C:/Temp/targetFile1.jpg";

//		in-output stream 연결
		FileInputStream fis = new FileInputStream(originalFilePath);
		FileOutputStream fos = new FileOutputStream(targetFilePath1);

//		이번엔 버퍼스트림을 이용한 스트림 생성...
		String originalFilePath2 = IOEx4.class.getResource("org.png").getPath();
		String targetFilePath2 = "C:/Temp/targetFile2.jpg";

		FileInputStream fis2 = new FileInputStream(originalFilePath2);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

//		버퍼를 사용하지 않고 복사하도록 메서드 호출함.
		long noneBufferTime = copy(fis, fos);
		System.out.println("버퍼 미사용시 : " + noneBufferTime + "ns"); // 22311900ns
		
		System.out.println("버퍼 사용시 : " + copy(bis, bos) + "ns");

	}

	private static long copy(InputStream fis, OutputStream fos) throws IOException {
		long start = System.nanoTime();
//		1바이트를 읽고 1 바이트를 출력
		while(true) {
			int data = fis.read();
			if(data == -1) break;
			fos.write(data);
		}
		fos.flush();
		long end = System.nanoTime();
		return (end - start); // 파일을 읽고 쓰는 시간의 편차 리턴
	}

}
 