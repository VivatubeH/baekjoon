import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long count = 0; // 누적된 구간합이 M으로 나눠떨어지는 개수를 체크하겠습니다.
        long[] prefixSum = new long[N+1]; // 누적합을 구하기 위한 변수입니다.
        long[] modCount = new long[M]; // 0 ~ M-1까지의 나머지의 개수를 counting 배열을 생성합니다.

        st = new StringTokenizer(br.readLine());

        // 사용자로부터의 입력을 통해 누적합을 구합니다.
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
        }

        // 해당 누적합에 대해서 나머지의 개수를 세서 counting 합니다.
        for (int i = 1; i <= N; i++) {
           long mod = prefixSum[i] % M;
           if (mod == 0) count++;
           modCount[(int)mod]++;
        }

        // 같은 나머지 2개를 순서를 고려하지 않고 고를 수 있으면 나누어 떨어지는 것입니다.
        // 만약 같은 나머지가 k개라면 그 중 순서를 고려하지 않고 고르는 경우의 수는
        // kC2이고 이는 k * (k-1) / 2가 됩니다.
        for (int i = 0; i <= M-1; i++) {
            long k = modCount[i];
            k = k * (k-1) / 2;
            count += k;
        }

        System.out.println(count);
    }
}
