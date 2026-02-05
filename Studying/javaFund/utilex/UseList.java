package javaFund.utilex;

import java.util.Collections;
import java.util.List;

public class UseList {
	public void showUsers(List<Player> lists) {
		
		Collections.sort(lists, Collections.reverseOrder());
		
		System.out.println(lists);
		
//		list 내부에 있는 플레이어의 정보를 출력 해보세요
		System.out.println(lists.size());

		for (int i = 0; i < lists.size(); i++) {
			Player player = lists.get(i);

			System.out.print("이름: " + player.getName() + " | ");
			System.out.print("PW: " + player.getPw() + " | ");
			System.out.print("ID: " + player.getId() + " | ");
			System.out.println("전적: " + player.getWin() + "승 " + player.getDraw() + "무 " + player.getLose() + "패");
			System.out.printf("승률 : %.2f%%\n ", player.getWinrate());
		}

	}

}
