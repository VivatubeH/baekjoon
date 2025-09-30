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
                int current = Integer.parseInt(br.readLine());
                boolean isPalindrome = bruteForce(current);

                if (isPalindrome) answer.append("1").append("\n");
                else answer.append("0").append("\n");
            }
        }
    }

    public static boolean bruteForce(int number) {
        for (int i = 2; i <= 64; i++) {
            int current = number;
            List<Integer> list = new ArrayList<>();

            while (current >= i) {
                int r = current % i;
                list.add(r);
                current /= i;
            }
            list.add(current);

            boolean isPalindrome = true;

            for (int left = 0; left < list.size(); left++) {
                if (list.get(left) != list.get(list.size() - 1 - left)) {
                    isPalindrome = false;
                }
            }

            if (isPalindrome) return true;
        }
        return false;
    }
}
