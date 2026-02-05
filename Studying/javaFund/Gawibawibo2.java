package javaFund;

import javax.swing.JOptionPane;

class GawibawiboGame {
//	승 무 패 총점
    private int win = 0;
    private int draw = 0;
    private int lose = 0;
    private int total = 0;

//  컴퓨터 랜덤값 생성
    private int getComVal() {
        return (int) (Math.random() * 3 + 1);
    }

//	사용자 입력값 변환
    private int convertInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            switch (input) {
                case "가위": return 1;
                case "바위": return 2;
                case "보": return 3;
                default: return 4;
            }
        }
    }

//	게임 실행
    public void play() {
        while (true) {
            String input = JOptionPane.showInputDialog("가위(1), 바위(2), 보(3) 중 입력하세요.");
            if (input == null) break; // 취소 버튼 클릭 시 종료

            int userVal = convertInput(input);
            if (userVal > 3 || userVal < 1) {
                JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 입력하세요.");
                continue;
            }

            int comVal = getComVal();
            String[] labels = {"", "가위", "바위", "보"};
            String resultMsg = "컴퓨터: " + labels[comVal] + ", 당신: " + labels[userVal] + "\n";

            // 승패 판정 로직
            if (comVal == userVal) {
                draw++;
                resultMsg += "무승부입니다!";
            } else if ((comVal == 1 && userVal == 2) || (comVal == 2 && userVal == 3) || (comVal == 3 && userVal == 1)) {
                win++;
                resultMsg += "당신이 승리했습니다!";
            } else {
                lose++;
                resultMsg += "컴퓨터가 승리했습니다!";
            }
            total++;

            JOptionPane.showMessageDialog(null, resultMsg);

            // 재경기 여부 확인
            int choice = JOptionPane.showConfirmDialog(null, "계속하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (choice != JOptionPane.YES_OPTION) break;
        }
        printSummary();
    }

//	최종 결과
    private void printSummary() {
        double winRate = (double)win / total * 100;
        System.out.println("===== 최종 성적 =====");
		System.out.printf("총 전적: %d전 %d승 %d무 %d패\n", total, win, draw, lose);
		System.out.printf("승률: %.2f%%\n", winRate);
    }
}
public class Gawibawibo2 {
    public static void main(String[] args) {
    	
        GawibawiboGame game = new GawibawiboGame();
        
        // 게임 시작
        game.play();
    }
}