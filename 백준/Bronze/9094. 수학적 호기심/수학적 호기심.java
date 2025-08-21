import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            answer.append(countOrderedPair(n, m)).append("\n");
        }
        System.out.print(answer);
    }

    public static int countOrderedPair(int n, int m) {
        int count = 0;
        for (int a = 1; a < n; a++) {
            for (int b = a+1; b < n; b++) {
                if ((a*a + b*b + m) % (a*b) == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
