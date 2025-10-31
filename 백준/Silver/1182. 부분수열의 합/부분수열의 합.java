import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int S;
    public static int[] array;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        input();
        dfs(0, 0);
        if (S == 0) { // edge 케이스 공집합일 때 제거하기
            count -= 1;
        }
        System.out.print(count);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            array = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // index번째 원소를 탐색합니다.
    public static void dfs(int index, int sum) {
        // 이미 모든 원소를 다 봤으면, 재귀 종료
        if (index == N) {
            // 합이 S와 같으면 부분수열을 찾은 것이기 때문에
            if (sum == S) {
                count++; // 개수를 셉니다.
            }
            return;
        }

        // 해당 원소를 포함하는 재귀
        dfs(index + 1, sum + array[index]);

        // 해당 원소를 포함하지 않는 재귀
        dfs(index + 1, sum);
    }
}
