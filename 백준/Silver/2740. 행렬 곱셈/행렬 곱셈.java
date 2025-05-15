import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 행렬 A의 크기 N과 M이 공백을 기준으로 주어집니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N + 1][M + 1]; // 1번 인덱스부터 활용을 위해 1 크게 만듭니다.
        for (int i = 1; i <= N; i++) { // N개의 줄에 걸쳐서
            st = new StringTokenizer(br.readLine()); // 공백을 기준으로 주어진 원소들을
            for (int j = 1; j <= M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()); // 배열에 저장합니다.
            }
        }
        // 이번에는 행렬 B의 크기 M과 K가 공백을 기준으로 주어집니다.
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // M은 어차피 똑같지만 입력 처리를 위해 그냥 다시 받습니다.
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M + 1][K + 1]; // 마찬가지로 1번 인덱스부터 활용을 위해 1 크게 만듭니다.
        for (int i = 1; i <= M; i++) { // M개의 줄에 걸쳐서
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken()); // 배열에 저장합니다.
            }
        }

        // 배열에 원소를 입력했으면, 반복문을 돌면서 배열을 계산합니다.
        int[][] result = new int[N + 1][K + 1]; // N x M과 M x K의 배열은 N x K가 되고 인덱스는 1부터 쓰겠습니다.

        StringBuilder answer = new StringBuilder();

        // result의 각 원소에 대해
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // result[i][j] 라고 하면 A의 i행을 순회하고, B의 j열을 순회하면서
                // 더해야 합니다.
                for (int k = 1; k <= M; k++) { // M보다 작거나 같은 동안
                    result[i][j] += A[i][k] * B[k][j];
                }
                // 결과를 저장합니다.
                answer.append(result[i][j] + " ");
            }
            answer.append("\n"); // 줄을 바꿉니다.
        }

        System.out.println(answer);
    }
}
