package javaFund;

import javax.swing.JOptionPane;

public class Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean gameStart = true;
		String input ="";
		int win = 0, lose = 0, draw = 0, total = 0;
		
		while(gameStart) {
			while (true){
		
			input = JOptionPane.showInputDialog("게임을 시작함");
			System.out.println(input);
			
//			위 입력값이 무엇인지를 찾아 보도록 합니다.
			if(input.equals("1") || input.equals("가위")) {
				System.out.println("가위를 입력했군요");
				break;
			}else if(input.equals("2") || input.equals("바위")) {
				System.out.println("바위를 입력했군요");
				break;
			}else if(input.equals("3") || input.equals("보")) {
				System.out.println("보를 입력했군요");
				break;
			}else {
				System.out.println("올바른 값이 아니군요");
				System.out.println("게임을 종료 합니다.");
				continue;
			}
			
		}
//		게임 플레이를 진행
//		컴퓨터의 랜덤값을 생성
		int com = (int)(Math.random() * 3 + 1);
		System.out.println("컴퓨터: " +com);
		
		int userVal = 0;
		
		switch (input) {
		case "1": case "가위": 
		    userVal = 1;
		    break;
		    
		case "2": case "바위":
		    userVal = 2;
		    break;
		    
		case "3": case "보":
		    userVal = 3;
		    break;
		}
		
		System.out.println(userVal);
		
//		게임의 결과 체크
		if(com == userVal) {
			System.out.println("draw");
			draw++;
			
		}else if((userVal == 1 && com == 3) || (userVal == 2 && com == 1) || (userVal == 3 && com ==2)) {
			System.out.println("win");
			win++;
			
		}else{
			System.out.println("lose");
			lose++;
			
		}
		total++;
		
		String retry = JOptionPane.showInputDialog("게임을 계속 진행하겠습니까? (y/n)");
		if (retry.equals("n")) {
			break;
		}
	}
		double winRate = (double)win / total * 100;
		System.out.println("\n===== 최종 성적 =====");
		System.out.printf("총 전적: %d전 %d승 %d무 %d패\n", total, win, draw, lose);
		System.out.printf("승률: %.2f%%\n", winRate);
	}
}
