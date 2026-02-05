package Project.Gawibawibo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private String email; // 아이디
	private String password; // 비밀번호
	private int win; // 승
	private int lose; // 패
	private int draw; // 무승부
	private int total; // 총 게임을 한 횟수
	private double winRate; // 승률

	private Date lastLogin; // 유저의 마지막 접속 기록

	public User(String email, String password) {
		this.email = email;
		this.password = password;
		this.win = 0;
		this.draw = 0;
		this.lose = 0;
		this.total = 0;
		this.winRate = 0.0;
		this.lastLogin = new Date(); // 가입 시 현재 시간 저장
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getWinRate() {
		return winRate;
	}

	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public static void main(String[] args) {
		/*
		 * User 클래스에 마지막 접속 시간, 전적이나 승률 등을 저장하는 클래스
		 */
		System.out.print("1. 게임시작\t2. 내 전적 보기\t3. 전체 랭킹\t4. 비밀번호 변경 \t5. 로그아웃");
	}

}
