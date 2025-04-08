import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken()); // 수의 개수 N이 주어집니다.
        int M = Integer.parseInt(st1.nextToken()); // 합을 구해야 하는 횟수 M이 주어집니다.

        int[] array = new int[N+1]; // 인덱스 활용을 위해 크기를 기존 크기 +1로 만듭니다.
        int[] prefixSum = new int[N+1]; // 누적합 저장을 위한 배열을 만듭니다.

        prefixSum[0] = 0; // prefixSum[i-1]을 조건 검사 없이 활용하기 위해 추가합니다.

        // 배열에 값을 입력하면서, 동시에 누적합을 구합니다.
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        // 시간 복잡도 O(n)이므로 입력 크기 20만개에 대해 시간 내에 수행 가능합니다.
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st2.nextToken());
            array[i] = num;
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }

        StringBuilder sb = new StringBuilder();
        // M번 입력을 받습니다. ( 시간 복잡도 O(M) 역시 최대 연산 20만회이므로 실행 가능합니다.
        for (int k = 0; k < M; k++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            // 매 토큰에 대해 i와 j를 공백을 기준으로 해서 숫자로 입력받습니다.
            int i = Integer.parseInt(st3.nextToken());
            int j = Integer.parseInt(st3.nextToken());
            // 출력은 S[a, b]라면 S[b] - S[a-1]이 되기 때문에 이를 출력해주면 됩니다. ( index 조회를 하기 때문에 O(1)에 가능합니다. )
            sb.append(prefixSum[j] - prefixSum[i - 1] + "\n");
        }

        // 10만개의 숫자에 대해서 각각이 1000보다 작거나 같으므로
        // 최댓값도 1억 이하이므로 overflow도 생각할 필요 없습니다.
        System.out.print(sb);
    }
}
