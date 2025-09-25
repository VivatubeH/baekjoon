import java.io.*;
import java.util.*;

public class Main {
    public static int K;
    public static int N;
    public static int maxInArray = -1;
    public static int[] lanLines;
    public static long answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        binarySearch();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            lanLines = new int[K];

            for (int i = 0; i < K; i++) {
                int current = Integer.parseInt(br.readLine());

                if (current > maxInArray) maxInArray = current;
                lanLines[i] = current;
            }
        }
    }

    public static void binarySearch() {
        long lower = 1;
        long upper = maxInArray;

        while (lower <= upper) {
            long mid = (lower + upper) / 2;

            long sum = 0;
            for (int i = 0; i < K; i++) {
                if (lanLines[i] < mid) {
                    continue;
                } else {
                    sum += (lanLines[i] / mid);
                }
            }

            if (sum >= N) {
                answer = mid;
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
    }

    public static void output() {
        System.out.print(answer);
    }
}
