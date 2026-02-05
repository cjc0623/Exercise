package Project.Gawibawibo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GameLauncher {
	private UserManager userManager = new UserManager();
	private Scanner scanner = new Scanner(System.in);
	private User loginUser = null;
	private SimpleDateFormat simpledataformat = new SimpleDateFormat("yyyy-MM-dd a HH:mm");

	public void run() {
		while (true) {
			if (loginUser == null) {
				showMainMenu();
			} else {
				showStartMenu();
			}
		}
	}

	private void showMainMenu() {
		System.out.println("=== 가위바위보 게임 ===");
		System.out.println("1. 로그인  2. 회원가입  0. 종료");
		System.out.print("선택 >> ");

		String choice = scanner.nextLine();

		switch (choice) {
		case "1":
			login(); // 로그인 로직 메서드 호출
			break;
		case "2":
			register(); // 회원가입 로직 메서드 호출
			break;
		case "0":
			System.exit(0); // 종료 로직
			break;
		case "999":
			showAdminMenu();
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}
	}

	private void showAdminMenu() {
	    System.out.println("\n" + "=".repeat(80));
	    System.out.printf("%-20s | %-10s | %-5s | %-5s | %-5s | %-10s\n", 
	                      "ID", "PW", "W", "D", "L", "Last Login");
	    System.out.println("-".repeat(80));

	    // 유저 맵의 모든 값 가져오기
	    for (User u : userManager.getUserMap().values()) {
	        System.out.printf("%-20s | %-10s | %-5d | %-5d | %-5d | %-10s\n",
	            u.getEmail(), 
	            u.getPassword(), 
	            u.getWin(), 
	            u.getDraw(), 
	            u.getLose(),
	            simpledataformat.format(u.getLastLogin())
	        );
	    }
	    System.out.println("=".repeat(80)+"\n");
	}

	// 회원가입
	private void register() {
		System.out.print("이메일 ID : ");
		String email = scanner.nextLine();

		System.out.print("비밀번호 : ");
		String password = scanner.nextLine();

		if (Idpassword.isValidEmail(email) && Idpassword.isValidPassword(password)) {
			boolean isSuccess = userManager.register(email, password);

			if (isSuccess) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("이미 존재하는 아이디입니다.");
			}

		} else {
			System.out.println("아이디 또는 비밀번호의 형식이 틀렸습니다.");
		}
	}

//	로그인
	private void login() {
		System.out.print("\n이메일 ID : ");
		String email = scanner.nextLine();

		System.out.print("비밀번호 : ");
		String password = scanner.nextLine();

		User user = userManager.login(email, password);
		if (user != null) {
			System.out.println("\n" + user.getEmail() + " 님 환영합니다.");
			System.out.println("마지막 로그인 시간은 " + simpledataformat.format(user.getLastLogin()) + " 입니다.");
			user.setLastLogin(new Date());
			loginUser = user;
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다. 다시 로그인해주세요.");
		}

	}

//	 메인 메뉴
	private void showStartMenu() {
		System.out.println("\n1. 게임시작  2. 내 전적 보기  3. 전체 랭킹  4. 비밀번호 변경  5. 로그아웃");
		System.out.print("선택 >> ");
		String select = scanner.nextLine();

		switch (select) {
		case "1":
			startGame();
			break;

		case "2":
			showMyRecord();
			break;

		case "3":
			showRanking();
			break;

		case "4":
			changePw();
			break;

		case "5":
			logout();
			break;

		default:
			System.out.println("잘못된 입력입니다. 다시 입력해주세요");
		}

	}

	private void logout() {
		// TODO Auto-generated method stub
		userManager.saveData();
		System.out.println("저장 완료. 로그아웃하였습니다.");
		loginUser = null;
	}

	private void changePw() {
		// TODO Auto-generated method stub

		while (true) {
			System.out.print("새 비밀번호 (변경하지 않으려면 'q' 입력) : ");
			String newPw = scanner.nextLine();

			if (newPw.equals("q")) {
				System.out.println("비밀번호 변경을 취소합니다.");
				break;
			}
			if (Idpassword.isValidPassword(newPw)) {
				loginUser.setPassword(newPw);
				userManager.saveData();
				System.out.println("비밀번호가 변경되었습니다.");
				break;
			} else {
				System.out.println("비밀번호 규칙에 맞지 않습니다. 다시 입력해 주세요\n");
			}
		}

	}

	private void showRanking() {
		System.out.println("\n===== 전체 랭킹 (승률순) =====");
		List<User> userList = new ArrayList<>(userManager.getUserMap().values());

		// 승률 내림차순 정렬
		Collections.sort(userList, (u1, u2) -> Double.compare(u2.getWinRate(), u1.getWinRate()));

		for (int i = 0; i < userList.size(); i++) {
			User u = userList.size() > i ? userList.get(i) : null;
			if (u != null) {
				System.out.printf("%d위. %s (승률: %.2f%%)\n", i + 1, u.getEmail(), u.getWinRate());
			}
		}
	}

	private void showMyRecord() {
		System.out.println("\n=== " + loginUser.getEmail() + " 님의 전적 ===");
		System.out.println("총: " + loginUser.getTotal() + "전");
		System.out.println(loginUser.getWin() + "승 " + loginUser.getDraw() + "무 " + loginUser.getLose() + "패");
		System.out.printf("승률: %.2f%%\n", loginUser.getWinRate());
	}

	private void startGame() {
		GawibawiboGame game = new GawibawiboGame(loginUser);

		// 게임 시작
		game.play();

		// 게임이 종료되면 데이터를 파일에 자동 저장
		userManager.saveData();
		System.out.println("게임 데이터가 저장되었습니다.");
	}

	public static void main(String[] args) {
		new GameLauncher().run();
	}
}
