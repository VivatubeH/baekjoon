import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] array;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
        System.out.print(count);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            array = new int[N];
            StringTokenizer numberToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(numberToken.nextToken());
            }
        }
    }

    public static void twoPointer() {
        int left = 0;
        int right = 0;
        int sum = 0;

        for (right = 0; right < N; right++) {
            sum += array[right];

            while (sum >= M) {
                if (sum == M) {
                    count++;
                }
                sum -= array[left];
                left++;
            }
        }
    }
}
