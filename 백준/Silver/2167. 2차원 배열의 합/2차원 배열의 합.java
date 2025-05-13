import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 사용자로부터 입력을 받기 위한 BufferedReader 클래스를 생성합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N과 M이 공백을 통해 주어집니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // N과 M에 의해 +1씩 큰 배열이 생성되도록 합니다.
        int[][] array = new int[N + 1][M + 1];
        // 합을 빠르게 구하기 위한 누적합 배열을 생성합니다.

        int[][] prefixSum = new int[N + 1][M + 1];
        // 이후 N개의 줄에 M개의 정수로 배열이 주어집니다. ( 인덱스는 둘 다 1부터 )
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                // 누적합 = 지금 원소 + 위쪽 누적합 + 왼쪽 누적합 - 중복되는 부분
                prefixSum[i][j] = array[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        // 정답을 한 번에 출력하기 위해 StringBuilder에 줄바꿈을 통해 이어붙입니다.
        StringBuilder answer = new StringBuilder();

        // 구해야 하는 구간합에 대해서는 누적합을 이용해서 구간합을 구합니다.
        // K개의 테스트 케이스가 주어집니다.
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            // row1, col1, row2, col2가 주어질 때 구간합을 구하면 됩니다.
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());

            // (row1, col1) ~ (row2, col2)의 구간합을 구합니다.
            // 구간합 = 현재까지의 누적합 - 왼쪽 누적합 - 위쪽 누적합 + 중복되는 부분 누적합
            int sectionSum = prefixSum[row2][col2] - prefixSum[row2][col1 - 1] - prefixSum[row1 - 1][col2] + prefixSum[row1 -1][col1 - 1];
            answer.append(sectionSum + "\n");
        }
        // 정답을 출력합니다.
        System.out.print(answer);
    }
}
