import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> stack = new ArrayDeque<>();
		boolean isAvailable = true; // 기본은 가능하다는 쪽으로 둡니다.
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] numArray = new int[n]; // 수열을 일단 입력받는다
		
		for (int i = 0; i < n; i++) {
			numArray[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 1; // 현재 숫자를 체크하기 위한 카운트 변수, 1부터 스택에 넣는다.
		
		for (int i = 0; i < n; i++) {
			int findNum = numArray[i]; // 이 숫자를 스택에서 찾아야 합니다.
			
			while (findNum >= count) { // count가 찾으려는 숫자보다 작거나 같은동안  
				stack.offerLast(count); // 그 숫자를 추가하고
				sb.append("+\n"); // + 기호로 표시합니다.
				count++; // 그리고 넣어야 할 숫자를 키워줍니다.
			}
			
			// 스택 최상단 숫자가 찾는 숫자와 일치하면 빼줍니다.
			if (stack.peekLast() == findNum) {
				stack.pollLast();
				sb.append("-\n");
			} else { // 일치 하지 않으면 
				isAvailable = false;
				break;
			}
		
		}
		
		if (isAvailable) {
			System.out.print(sb);
		} else {
			System.out.print("NO");
		}
		
	}
}