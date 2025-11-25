import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder answer = new StringBuilder();
    public static int current = 1;
    public static boolean isPossible = true;
    public static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                isPossible(Integer.parseInt(br.readLine()));
                if (!isPossible) break;
            }
            if (isPossible) System.out.print(answer);
            else System.out.print("NO");
        }
    }

    public static void isPossible(int num) {
        while (current <= num) {
            stack.push(current);
            answer.append("+").append("\n");
            current++;
        }
        if (!stack.isEmpty() && stack.peek() == num) {
            stack.pop();
            answer.append("-").append("\n");
        } else {
            isPossible = false;
            return;
        }
    }
}