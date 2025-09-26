import java.io.*;
import java.util.*;

public class Main {
    public static int[] array;
    public static int answer1;
    public static int answer2;

    public static void main(String[] args) throws IOException {
        input();
        service();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            array = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void service() {
        Arrays.sort(array);
        binarySearch();
    }

    public static void binarySearch() {
        // 갱신를 위해서 최솟값을 최대한 크게 설정한다.
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            int current = array[i];

            // current와 더했을 때의 절댓값이 최소인 수를 이분탐색
            int lower = 0;
            int upper = array.length - 1;

            while (lower <= upper) {
                int mid = (lower + upper) / 2;

                int sum = current + array[mid];
                int abs = Math.abs(sum);

                // 합의 절댓값이 지금까지 최소합보다 작거나 같으면
                if (abs <= minSum && (mid != i)) {
                    minSum = abs;
                    answer1 = current;
                    answer2 = array[mid];
                }

                // 합의 절댓값이 최소합보다 작든 크든 탐색은 지속
                if (sum > 0) { // 더 작은데서 찾기
                    upper = mid - 1;
                } else { // 더 큰데서 찾기
                    lower = mid + 1;
                }
            }
        }
    }

    public static void output() {
        System.out.print(Math.min(answer1, answer2) + " " + Math.max(answer1, answer2));
    }
}
