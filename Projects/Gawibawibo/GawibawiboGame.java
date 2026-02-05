package Project.Gawibawibo;

import javax.swing.JOptionPane;

public class GawibawiboGame {
    private User user; // 현재 게임을 하는 유저

    public GawibawiboGame(User user) {
        this.user = user;
    }

    private int getComVal() {
        return (int) (Math.random() * 3 + 1);
    }

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

    public void play() {
        while (true) {
            String input = JOptionPane.showInputDialog("가위(1), 바위(2), 보(3) 중 입력하세요.");
            if (input == null) break;

            int userVal = convertInput(input);
            if (userVal > 3 || userVal < 1) {
                JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 입력하세요.");
                continue;
            }

            int comVal = getComVal();
            String[] labels = {"", "가위", "바위", "보"};
            String resultMsg = "컴퓨터: " + labels[comVal] + ", 당신: " + labels[userVal] + "\n";

            // 승패 판정 로직 및 User 객체 데이터 업데이트
            if (comVal == userVal) {
                user.setDraw(user.getDraw() + 1);
                resultMsg += "무승부입니다!";
            } else if ((comVal == 1 && userVal == 2) || (comVal == 2 && userVal == 3) || (comVal == 3 && userVal == 1)) {
                user.setWin(user.getWin() + 1); 
                resultMsg += "당신이 승리했습니다!";
            } else {
                user.setLose(user.getLose() + 1);
                resultMsg += "컴퓨터가 승리했습니다!";
            }
            
            // 총 판수 증가 및 승률 갱신 로직
            user.setTotal(user.getTotal() + 1);
            double winRate = (double)user.getWin() / user.getTotal() * 100;
            user.setWinRate(winRate);

            JOptionPane.showMessageDialog(null, resultMsg);

            int choice = JOptionPane.showConfirmDialog(null, "계속하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (choice != JOptionPane.YES_OPTION) break;
        }
    }
}