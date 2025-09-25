import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] moneyToUsePerDay;
    public static int min = 0;
    public static int max = 0;

    public static int answer;

    public static void main(String[] args) throws IOException {
        input();
        binarySearch();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            moneyToUsePerDay = new int[N];
            for (int i = 0; i < N; i++) {
                int current = Integer.parseInt(br.readLine());
                if (min < current) min = current;
                max += current;

                moneyToUsePerDay[i] = current;
            }
        }
    }

    public static void binarySearch() {
        while (min <= max) {
            int mid = (min + max) / 2;

            long count = 0;
            long wallet = 0;
            for (int i = 0; i < N; i++) {
                int current = moneyToUsePerDay[i];

                if (wallet >= current) {
                    wallet -= current;
                } else {
                    wallet = mid - current;
                    count++;
                }
            }

            if (count <= M) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
    }

    public static void output() {
        System.out.print(answer);
    }
}
