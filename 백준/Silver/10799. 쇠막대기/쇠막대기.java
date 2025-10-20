import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        input();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            int count = countStick(input);
            output(count);
        }
    }

    public static void output(int count) {
        System.out.print(count);
    }

    public static int countStick(String input) {
        int count = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (i == 0) continue;
                else {
                    if (input.charAt(i - 1) == '(') {
                        stack.pop();
                        count += stack.size();
                    } else if (input.charAt(i - 1) == ')') {
                        stack.pop();
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
}