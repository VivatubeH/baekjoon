import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String password;
		
		for (;;) {
			password = br.readLine();
			
			if (password.equals("end")) break;
			
			// a, e, i, o, u 포함하는지 -> 포함하면 true
			// 모음이 3개 or 자음이 3개 연속인지 -> 오면 false
			// 같은 글자가 연속으로 오는지 -> 오면 false ( ee와 oo는 허용 )
			if (isValidPassword(password)) {
				System.out.println("<" + password + "> " + "is acceptable.") ;
			} else {
				System.out.println("<" + password + "> " + "is not acceptable.");
			}
		}
	}
	
	public static boolean isValidPassword(String password) {
		boolean condition1 = false;
		boolean condition2 = true;
		boolean condition3 = true;
		
		// 모음 하나를 포함하는지 검증합니다.
		// 포함하면 조건 1 통과 
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			
			if (isAEIOU(ch)) {
				condition1 = true;
				break;
			}
		}
		
		// 모음이 3개 연속 or 자음이 3개 연속인지 확인합니다.
		// 3개의 논리연산 결과가 같으면 -> 자음이거나 모음이 연속 3개 
		// 연속이 아니면 조건 2 통과 
		for (int i = 0; i < password.length() - 2; i++) {
			char ch1 = password.charAt(i);
			char ch2 = password.charAt(i + 1);
			char ch3 = password.charAt(i + 2);
			
			if (isAEIOU(ch1) == isAEIOU(ch2) && isAEIOU(ch2) == isAEIOU(ch3)) {
				condition2 = false;
				break;
			} 
		}
		
		// 같은 글자가 연속으로 2번 오는지 확인합니다.
		// 연속 2번 오고 oo나 ee가 아니면 false
		// 연속 2번 오는 ee나 oo가 아닌 문자가 으면 true
		for (int i = 0; i < password.length() - 1; i++) {
			char ch1 = password.charAt(i);
			char ch2 = password.charAt(i + 1);
			
			if ((ch1 != 'e' && ch1 != 'o') && (ch1 == ch2)) {
				condition3 = false;
				break;
			}
		}
		
		if (condition1 && condition2 && condition3) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean isAEIOU(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}
		return false;
	}
}
