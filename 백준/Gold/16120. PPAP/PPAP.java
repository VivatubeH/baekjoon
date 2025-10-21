import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        input();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            boolean isPPAP = checkPPAP(br.readLine());
            if (isPPAP) System.out.print("PPAP");
            else System.out.print("NP");
        }
    }

    public static boolean checkPPAP(String string) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            stack.push(ch);
            if (i < 3) continue;

            if (stack.size() >= 4) {
                char fourth = stack.pop();
                char third = stack.pop();
                char second = stack.pop();
                char first = stack.pop();
                if (fourth == 'P' && third == 'A' && second == 'P' && first == 'P') {
                    stack.push('P');
                } else {
                    stack.push(first);
                    stack.push(second);
                    stack.push(third);
                    stack.push(fourth);
                }
            }
        }
        if (stack.size() == 1 && stack.peek() == 'P') return true;
        return false;
    }
}
