import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken()); // 온도를 측정한 전체 날의 수
        int K = Integer.parseInt(token.nextToken()); // 합을 구하기 위한 연속적인 날의 수

        int[] temperature = new int[N+1]; // 1번부터 인덱스 활용을 하기 위해 1 크게 만듭니다.

        int max = 0; // 구하려는 온도가 최대가 되는 값입니다.
        int sum = 0; // 온도의 합을 구하기 위한 변수입니다.

        // 먼저 N개의 정수를 온도 배열에 입력받습니다.
        token = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            temperature[i] = Integer.parseInt(token.nextToken());
        }

        // 이제 배열을 순회하면서 구하는데 시간 복잡도를 고려해서 max를 구해야 합니다.
        // 최초 K개의 온도의 합을 최대로 가정하고 문제를 풀어보겠습니다.
        for (int i = 1; i <= K; i++) {
            max += temperature[i];
        }

        sum = max; // 최초의 sum은 max가 됩니다.

        // 이러면 1부터 K까지의 온도가 최대로 할당된 상태입니다.
        // 이후부터는 K 이후부터를 인덱스로 전체 N 이하인 동안에 대해서 1칸씩 이동시킵니다.
        for (int i = K+1; i <= N; i++) {
            // 이렇게 식을 짜면 합에서 가장 앞은 빼고, 가장 뒤는 더하는 식으로 합을 구합니다.
            sum = sum + temperature[i] - temperature[i - K];
            if (sum > max) max = sum; // 만약 합이 더 크면 max를 변경합니다.
        }

        System.out.println(max);
    }
}
