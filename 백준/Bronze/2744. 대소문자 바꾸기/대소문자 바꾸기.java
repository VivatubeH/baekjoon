import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// Scanner 객체를 생성하고 문자열을 입력받는다.
		Scanner in = new Scanner(System.in);
		String str = in.next();
		
		// 1. 문자열의 특정 문자는 소문자, 특정 문자는 대문자이다.
		// 문자열은 불변 객체니 메서드 없이는 각 문자에 접근 불가능하다.
		// 문자열을 문자배열로 변경하자.
		char[] word = str.toCharArray();
		
		// 2. 문자 배열의 시작부터 끝까지 검색해서 소문자는 대문자로, 대문자는 소문자로 바꾼다.
		for(int i = 0; i < str.length(); i++) {
			if (('a' <= word[i]) && (word[i] <= 'z')) { // 소문자이면
				word[i] = (char)(word[i] - ('a'-'A'));
			}
			else if(('A' <= word[i]) && (word[i] <= 'Z')) { // 대문자이면
				word[i] = (char)(word[i] + ('a'-'A'));
			}
		}
		
		// 3. 줄바꿈 없이 문자배열을 그대로 출력한다.
		for(int i = 0; i < word.length; i++) {
			System.out.print(word[i]);
		} 
	}
}