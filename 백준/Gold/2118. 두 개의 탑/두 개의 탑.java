import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] distance;
    public static int totalDistance = 0;
    public static int[] prefixSum;
    public static int max = -1;

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            distance = new int[N];
            prefixSum = new int[N + 1];
            for (int i = 0; i < N; i++) {
                distance[i] = Integer.parseInt(br.readLine());
                totalDistance += distance[i];
                prefixSum[i + 1] = prefixSum[i] + distance[i];
            }
        }
    }

    public static void twoPointer() {
        int bound = totalDistance / 2;
        int right = 1;
        for (int left = 0; left < N; left++) {
            while (right < N && prefixSum[right] - prefixSum[left] <= bound) {
                int clockDist = prefixSum[right] - prefixSum[left];
                int reverseDist = totalDistance - clockDist;

                max = Math.max(max, Math.min(clockDist, reverseDist));
                right++;
            }
            int clockDist = prefixSum[right] - prefixSum[left];
            int reverseDist = totalDistance - clockDist;

            max = Math.max(max, Math.min(clockDist, reverseDist));
        }
    }

    public static void output() {
        System.out.print(max);
    }
}
