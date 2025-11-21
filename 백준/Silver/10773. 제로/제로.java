import java.io.*;
import java.util.*;

public class Main {
    public static Deque<Integer> stack = new ArrayDeque<>();
    public static int sum = 0;

    public static void main(String[] args) throws IOException {
        input();
        System.out.print(sum);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < K; i++) {
                int num = Integer.parseInt(br.readLine());
                execute(num);
            }
        }
    }

    public static void execute(int num) {
        if (num == 0) {
            int minus = stack.pop();
            sum -= minus;
        } else {
            stack.push(num);
            sum += num;
        }
    }
}