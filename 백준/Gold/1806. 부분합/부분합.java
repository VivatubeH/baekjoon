import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int S;
    public static int[] array;
    public static int minLength;

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer firstLine = new StringTokenizer(br.readLine());
            StringTokenizer secondLine = new StringTokenizer(br.readLine());

            N = Integer.parseInt(firstLine.nextToken());
            S = Integer.parseInt(firstLine.nextToken());

            array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(secondLine.nextToken());
            }
        }
    }

    public static void twoPointer() {
        int left = 0;
        int right = 0;
        int sum = 0;
        minLength = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                minLength = Math.min(minLength, right - left);
                sum -= array[left];
                left++;
            }
            else if (right == N) break;
            else {
                sum += array[right];
                right++;
            }
        }
    }

    public static void output() {
        if (minLength == Integer.MAX_VALUE) {
            System.out.print(0);
        } else {
            System.out.print(minLength);
        }
    }
}