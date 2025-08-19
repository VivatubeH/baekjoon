import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < testcase; i++) {
            int num = Integer.parseInt(br.readLine());
            makeNumberPairs(num, answer);
        }
        System.out.print(answer);
    }

    public static void makeNumberPairs(int num, StringBuilder answer) {
        answer.append("Pairs for ").append(num).append(": ");
        int left = 1;
        int right = num - 1;
        boolean isFirst = true;
        while (left < right) {
            if (!isFirst) {
                answer.append(", ");
            }
            answer.append(left).append(" ").append(right);
            left++;
            right--;
            isFirst = false;
        }
        answer.append("\n");
    }
}
