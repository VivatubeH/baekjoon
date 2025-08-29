import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        int[] height = new int[20];

        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = 0; j < 20; j++) {
                height[j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < j; k++) {
                    if (height[k] > height[j]) {
                        count++;
                    }
                }
            }
            answer.append(number).append(" ").append(count).append("\n");
        }
        System.out.print(answer);
    }
}
