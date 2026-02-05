package javaFund;

import javax.swing.JOptionPane;

public class score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


//		score.java 파일을 생성해서 아래와 같은 결과를 도출하는 로직을 작성하세요
		/*
		 * 학생의 성적을 국,영,수 로 입력받아서, 총점, 평균, 학점(A,B,C,F)를 출력하도록 하는 프로그램입니다.
		 * 프로그램이 시작되면 각 과목을 입력 받도록 한느데, 입력된 점수는 반드시 0 ~ 100 점 사이여야 합니다.
		 * 만약 이 범위를 벗어나면 해당 과목을 다시 입력 받도록 합니다. 다른 과목의 입력으로 넘어가면 안됩니다.
		 * 
		 * 만약 올바른 값이 모두 입력되면, 위 결과를 출력시키세요.
		 * 
		 * 모든 점수는 배역로 관리되어야 합니다. 총점도.
		 * 학점은 90점 이상은 A, 80 이상은 B, 나머진 F 처리하는데, switch case 로 작성하세요
		 */
		
		int scores[] = new int[4]; // [국] [영] [수] [총점]
		String[] subjects = {"국어", "영어", "수학"};
		
		for (int i = 0; i <subjects.length; i++) {
			while (true) {
				String input = JOptionPane.showInputDialog(subjects[i] + " 점수를 입력하세요 (0~100)");
				int tempScore = Integer.parseInt(input);
				
				if (tempScore >= 0 && tempScore <= 100) {
                    scores[i] = tempScore;
                    scores[3] += tempScore; 
                    break;
                } else {
                    System.out.println(subjects[i] + " 점수가 범위를 벗어났습니다. 다시 입력하세요.");
                }
			}
		}
		
		double avg = (double) scores[3]/ 3; 
		
		String grade = "";
        switch ((int) avg / 10) {
            case 10:
            case 9:
                grade = "A";
                break;
            case 8:
                grade = "B";
                break;
            default:
                grade = "F";
                break;
        }
        System.out.println("-------------- 성적 결과 --------------");
        for(int i = 0; i < subjects.length; i++) {
        	System.out.println(subjects[i] + ": " + scores[i] + "점");
        }
        System.out.println("총점: " + scores[3] + "점");
        System.out.printf("평균: %f점\n", avg);
        System.out.println("학점: " + grade);
	}

}
