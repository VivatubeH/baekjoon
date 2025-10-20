import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.print(answer);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (!(input = br.readLine()).equals(".")) {
                boolean isBalanced = execute(input);
                if (isBalanced) answer.append("yes");
                else answer.append("no");
                answer.append("\n");
            }
        }
    }

    public static boolean execute(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char currentInStack = stack.pop();
                    if (currentInStack == '[') {
                        if (ch == ')') return false;
                    } else if (currentInStack == '(') {
                        if (ch == ']') return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
