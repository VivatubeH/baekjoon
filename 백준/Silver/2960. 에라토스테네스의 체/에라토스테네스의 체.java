import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] isDeleted;

    public static void main(String[] args) throws IOException {
        // N과 K를 입력받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 지웠는지를 체크하기 위한 isDeleted 배열
        isDeleted = new boolean[N+1]; // N 인덱스를 그대로 사용하기 위함.
        // 현재 몇 개를 지웠는지 체크하기 위한 변수 count -> count == K가 되면 종료 필요.
        int count = 0;
        int num = 2; // 처음엔 2부터 탐색합니다.
        while (true) {
            // 지워지지 않은 가장 작은 수를 찾습니다.
            int start = findMinValue(num);
            // 그 수부터 지워지지 않은 그 수의 배수를 크기 순으로 지웁니다.
            for (int i = start; i <= N; i++) {
                if (i % start == 0) { // start의 배수에 대해서
                    if (!isDeleted[i]) { // 지워지지 않았으면
                        isDeleted[i] = true; // 지우고
                        count++; // 지운 개수를 체크합니다.
                        if (count == K) { // 다 지웠다면
                            System.out.print(i); // 방금 지운 숫자를 출력하고
                            return; // 프로그램을 종료합니다.
                        }
                    }
                }
            }
            start++; // 다음 수를 지우러 갑니다.
        }

    }
    // 주어진 배열에서 start부터 탐색해서 가장 지워지지 않은 가장 작은 정수를 찾아서 반환합니다.
    public static int findMinValue(int start) {
        for (int i = start; i <= isDeleted.length; i++) {
            if (!isDeleted[i]) { // 지워지지 않았다면
                return i; // 해당 수를 반환합니다.
            }
        }
        return -1; // 다 지워졌다면 -1을 반환합니다. ( 하지만 K < N이므로 무조건 다 지워집니다. )
    }


}
