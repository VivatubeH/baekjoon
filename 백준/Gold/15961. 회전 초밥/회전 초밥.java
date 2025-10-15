import java.io.*;
import java.util.*;

public class Main {
    public static int[] belts; // 회전 초밥 벨트
    public static int[] frequency; // 초밥의 종류별 등장 빈도 배열
    public static int coupon; // 쿠폰 번호
    public static int N; // 접시의 수
    public static int d; // 초밥의 가짓수
    public static int k; // 연속해서 먹는 접시의 수
    public static int count = 0; // 현재 초밥의 종류 수
    public static int max = 0; // 구하고자 하는 초밥의 최대 가짓수

    public static void main(String[] args) throws IOException {
        input();
        initialize();
        service();
        System.out.print(max);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            d = Integer.parseInt(tokenizer.nextToken());
            k = Integer.parseInt(tokenizer.nextToken());
            coupon = Integer.parseInt(tokenizer.nextToken());
            belts = new int[N + k - 1];
            frequency = new int[d + 1];
            for (int i = 0; i < N; i++) {
                belts[i] = Integer.parseInt(br.readLine());
            }
            for (int i = N; i < N + k - 1; i++) {
                belts[i] = belts[i - N];
            }
        }
    }

    public static void service() {
        for (int i = k; i < N + k - 1; i++) {
            frequency[belts[i - k]]--;
            if (frequency[belts[i - k]] == 0) {
                count--;
            }
            if (frequency[belts[i]] == 0) {
                count++;
            }
            frequency[belts[i]]++;
            if (frequency[coupon] == 0) {
                max = Math.max(count + 1, max);
            } else {
                max = Math.max(count, max);
            }
        }
    }

    public static void initialize() {
        for (int i = 0; i < k; i++) {
            int index = belts[i];
            if (frequency[index] == 0) {
                count++;
            }
            frequency[index]++;
        }
        max = count;
        if (frequency[coupon] == 0) max++;
    }
}
