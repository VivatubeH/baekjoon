import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // n이 int범위를 벗어날 수 있으니 long으로 n을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long answer = binarySearch(n);
        System.out.print(answer);
    }

    public static long binarySearch(long n) {
        long left = 0;
        long right = n;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            // 중앙값을 제곱했더니, n보다 크거나 같다면
            // 왼쪽으로 옮겨서 탐색해야 한다.
            if (n <= Math.pow(mid, 2)) {
                answer = mid;
                right = mid -1 ;
            }
            // 중앙값을 제곱했더니, n보다 작다면
            // 우측으로 옮겨서 탐색해야 한다.
            else {
                left = mid + 1;
            }
        }
        return answer;
    }
}

