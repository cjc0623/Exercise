package javaFund;

import javax.swing.JOptionPane;

public class Gawibawibo {

   private static int getComVal() {
      return (int)(Math.random() * 3 + 1);
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      boolean isInputOk = false;
      
      JOptionPane.showMessageDialog(null,"게임을 시작함\n가위(1),바위(2),보(3)");
      String input = null;
      int userVal;
      
      int win=0,draw=0,lose=0,total= 0;
      
      double rate;
      //boolean isCotinue;
      int comVal;
      
      while(!isInputOk) {
         input = JOptionPane.showInputDialog("값 입력하세요");
         System.out.println(input);
         try {
            userVal = Integer.parseInt(input);
         }catch (Exception e) {
            //가위바위보 문자열이 들어왔으므로..예외가 발생함.
            switch (input) {
            case "가위": 
               userVal = 1;  
               break;
            case "바위":
               userVal = 2;
               break;
            case "보":
               userVal = 3;
               break;   
            default :
               userVal = 4;
               break;
            }
         }
         if(userVal > 3) {
            JOptionPane.showMessageDialog(null,"잘못된 값입니다. 다시 입력 바람");
            continue;
         }
         comVal = getComVal();
         
         if(comVal == userVal) {
            draw++;//사용자 승 체크
         }else if((comVal == 1 && userVal == 2) || (comVal == 2 && userVal == 3) || (comVal == 3 && userVal == 1)) {
            win++;
         }else {
            lose++;
         }
         total++;
         System.out.println("컴 " + comVal + "user" + userVal);
         System.out.println(win + " : " + draw + " : " + lose);
         
      }
      
      // 게임 플레이를 진행 해야죠..
      // 컴퓨터의 랜덤값을 생성합니다.

      
      
      /*
       * 사용자는 가위,바위,보 대신 1,2,3 을 값으로 낼수 있습니다.
       * 그럼 프로그램은 이 값을 분석해서 랜덤한 컴퓨터의 값(Math.random())
       * 으로 게임을 진행시키고, 결과를 다음처럼 출력 시키세요
       * 컴 : 가위, 당신 : 보
       * 컴 승리!
       * 
       * 위처럼 결과를 출력후, 게임을 다시 할건지를 물어봅니다.
       * ex>게임을 계속 할래요? 이때 사용자는 y or n 를 입력 하게 되고
       * 이에 따라서 게임이 계속되거나 끝나거나 합니다.
       * 
       * 단 게임이 끝날때는 총전적, 승,패,무, 승률(소수점 2자리까지)을
       * 출력 시키고 게임을 종료시킵니다.
       */
      
      
      
   }

}
