import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int C;
    public static int[] array;
    public static int lower;
    public static int upper = 1;
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
            C = Integer.parseInt(st.nextToken());
            array = new int[N];
            for (int i = 0; i < N; i++) {
                int current = Integer.parseInt(br.readLine());
                array[i] = current;
            }
            Arrays.sort(array);
            upper = array[N - 1] - array[0];
        }
    }

    public static void binarySearch() {
        while (lower <= upper) {
            int mid = (lower + upper) / 2;

            int before = array[0];
            long count = 1;

            for (int i = 1; i < N; i++) {
                if (array[i] - before >= mid) {
                    count++;
                    before = array[i];
                }
            }

            if (count >= C) {
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
