package javaFund.utilex;

import java.util.ArrayList;
import java.util.List;

/*
 * Board 객체의 getBoardList() 를 호출하면 List<Board> 타입의
 * 컬렉션을 리턴함.. ListExam의 실행 결과를 보고, BoardDao 클래스와
 * getBoardList() 메서드를 작성하시오..
 */

class Board {
	private String title;
	private String content;

	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

}

class BoardDao {

	public List<Board> getBoardList() {
		List<Board> list = new ArrayList<>();

		list.add(new Board("제목1", "내용1"));
		list.add(new Board("제목2", "내용2"));
		list.add(new Board("제목3", "내용3"));

		return list;

	}

}

class ListExam1 {
	public void doSome() {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for (Board b : list) {
			System.out.println(b.getTitle() + " = " + b.getContent());
		}
	}
}

public class Quiz1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		실행결과는 아래와 같음
		/*
		 * 제목1 = 내용1 제목2 = 내용2 제목3 = 내용3
		 */
		ListExam1 exam = new ListExam1();
		exam.doSome();
	}

}
