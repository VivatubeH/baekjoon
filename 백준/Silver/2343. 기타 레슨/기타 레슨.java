import java.io.*;
import java.util.*;

public class Main {
    public static int[] lectures;
    public static int N;
    public static int M;
    public static int answer;
    public static int minLength = 0;
    public static int maxLength = 0;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer firstToken = new StringTokenizer(br.readLine());
            N = Integer.parseInt(firstToken.nextToken());
            M = Integer.parseInt(firstToken.nextToken());
            lectures = new int[N];
            StringTokenizer secondToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int currentLength = Integer.parseInt(secondToken.nextToken());
                lectures[i] = currentLength;
                if (currentLength > minLength) {
                    minLength = currentLength;
                }
                maxLength += currentLength;
            }
            binarySearch();
        }
    }

    public static void binarySearch() {
        int lower = minLength;
        int upper = maxLength;

        while (lower <= upper) {
            int mid = (lower + upper) / 2;

            // 해당 길이를 최소로 M개가 가능한지 체크한다.
            int sum = 0;
            int count = 1;

            for (int i = 0; i < N; i++) {
                int current = lectures[i];
                // 녹화 가능한 길이보다 커진다면
                if (current + sum > mid) {
                    count++;
                    sum = current;
                } else {
                    sum += current;
                }
            }

            if (count <= M) {
                answer = mid;
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
    }

    public static void output() {
        System.out.print(answer);
    }
}
