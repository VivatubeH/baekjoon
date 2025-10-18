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
            int testCase = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCase; i++) {
                boolean isVPS = checkVPS(br.readLine());
                if (isVPS) answer.append("YES").append("\n");
                else answer.append("NO").append("\n");
            }
        }
    }
    
    public static boolean checkVPS(String str) {
        int length = str.length();
        boolean isVPS = true;
        Deque<Character> openStack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            char current = str.charAt(i);
            if (current == '(') {
                openStack.push('(');
            } else if (current == ')') {
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!openStack.isEmpty()) return false;
        return true;
    }
}
