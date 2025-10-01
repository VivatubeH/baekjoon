import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] array;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }
        }
    }

    public static void twoPointer() {
        Arrays.sort(array);
        int left = 0;
        int right = 0;

        while (left <= right && right < N) {
            int diff = Math.abs(array[right] - array[left]);

            if (diff >= M) {
                min = Math.min(min, diff);
                left++;
            } else {
                right++;
            }
        }
    }

    public static void output() {
        System.out.print(min);
    }
}
