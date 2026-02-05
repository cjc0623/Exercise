package Project.Gawibawibo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> userMap = new HashMap<>();
    private final String FILE_NAME = "userData.dat";

    // 생성자에서 예외를 직접 처리(try-catch)하면 호출하는 쪽이 편해집니다.
    public UserManager() {
        try {
            loadData();
        } catch (Exception e) {
            System.out.println("초기 데이터 로딩 중 알 수 없는 오류 발생");
        }
    }

    // loadData에서도 throws를 제거하고 내부에서 catch 하세요.
    private void loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                userMap = (Map<String, User>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("회원 데이터를 불러오는 중 오류가 발생했습니다.");
        }
    }
	public void saveData() { // 외부(로그아웃 등)에서도 부를 수 있게 public 권장
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
	        oos.writeObject(userMap);
	    } catch (IOException e) {
	        System.out.println("데이터 저장 중 오류 발생: " + e.getMessage());
	        }
	    }
	public boolean register(String email, String pw) {
		if(userMap.containsKey(email)) {
			System.out.println("이미 존재하는 ID 입니다.");
			return false;
		}
		User newUser = new User(email,pw);
		userMap.put(email, newUser);
		saveData();
		return true;
	}
	
	public User login(String email, String pw) {
		User user = userMap.get(email);
		if(user != null && user.getPassword().equals(pw)) {
			return user;
		}
		return null;
	}
	
	public Map<String, User> getUserMap(){
		return userMap;
	}



	public static void main(String[] args) {
		/*
		 * 회원가입한 유저 저장 및 로그인 확인 클래스
		 */
	}

}
