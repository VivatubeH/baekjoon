import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Character> open = new ArrayDeque<>();
		
		String str;
		while (true) {
			str = br.readLine();
			
			if (str.equals(".")) {
				break;
			}
			
			boolean isBalanced = true; 
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if (ch == '(' || ch == '[') {
					open.offerLast(ch);
				}
				
				if (ch == ')' || ch == ']') {
					
					if (open.size() == 0) {
						isBalanced = false;
						break;
					}
					
					char last = open.pollLast();
					
					if (last == '(' && ch != ')') {
						isBalanced = false;
						break;
					} 
					if (last == '[' && ch != ']') {
						isBalanced = false;
						break;
					}
				}
			}
			
			if (open.size() != 0) {
				isBalanced = false;
			}
			
			if (isBalanced) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
			open.clear();
		}
		
	}
}
