import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 위아래로 보는 개념이 아니라
		// 1번 카드를 제일 앞으로 숫자가 커질수록 뒤로 순차적으로 쌓고
		// 카드를 꺼낼 때 제일 앞 카드를 버리고
		// 그 다음 제일 앞에 있는 카드는 제일뒤로 옮긴다.
		// 이 과정을 하다가 버렸을 때 남은 카드가 1장 되면 종료
		// 이 때 카드를 출력하면 됨
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		
		int start = 1;
		for (int i = 0; i < N; i++) {
			deque.offerLast(start++);
		}
		
		while(true) {
			if (deque.size() == 1) {
				System.out.print(deque.pollFirst());
				break;
			}
			deque.pollFirst();
			if (deque.size() == 1) {
				System.out.print(deque.pollFirst());
				break;
			}
			int num = deque.pollFirst();
			deque.offerLast(num);
		}
	}
}
