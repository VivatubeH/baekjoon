import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> results = new ArrayList<>();
	static Deque<Integer> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			String instruction = br.readLine();
			execute(instruction);
		}
		for (Integer num : results) {
			sb.append(num + "\n");
		}
		System.out.print(sb);
	}
	
	public static void execute(String instruction) {
		if (instruction.contains("push")) {
			String[] token = instruction.split(" ");
			int num = Integer.parseInt(token[1]);
			deque.offerLast(num);
		} else if (instruction.equals("pop")) {
			if (deque.size() == 0) {
				results.add(-1);
			} else {
				results.add(deque.pollFirst());
			}
		} else if (instruction.equals("size")) {
			results.add(deque.size());
		} else if (instruction.equals("empty")) {
			if (deque.isEmpty()) {
				results.add(1);
			} else {
				results.add(0);
			}
		} else if (instruction.equals("front")) {
			if (deque.isEmpty()) {
				results.add(-1);
			} else {
				results.add(deque.peekFirst());	
			}
		} else if (instruction.equals("back")) {
			if (deque.isEmpty()) {
				results.add(-1);
			} else {
				results.add(deque.peekLast());
			}
		}
	}
}
