import java.io.*;
import java.util.*;

public class Main {
    public static int[] regions;
    public static int max = 0;
    public static int sum = 0;
    public static int answer = 0;
    public static int total = 0;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            regions = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int current = Integer.parseInt(st.nextToken());
                sum += current;
                if (max < current) max = current;

                regions[i] = current;
            }
            total = Integer.parseInt(br.readLine());
            if (total >= sum) answer = max;
            else answer = binarySearch();
        }
    }

    public static int binarySearch() {
        int lower = 1;
        int upper = max;
        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            int sum = 0;

            for (int i = 0; i < regions.length; i++) {
                if (mid <= regions[i]) {
                    sum += mid;
                } else {
                    sum += regions[i];
                }
            }

            if (sum <= total) {
                answer = mid;
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return answer;
    }

    public static void output() {
        System.out.print(answer);
    }
}
