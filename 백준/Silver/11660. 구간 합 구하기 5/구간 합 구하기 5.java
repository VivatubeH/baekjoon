import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int squareSize = Integer.parseInt(st.nextToken()); // 격자 칸의 크기입니다.
        int count = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수입니다.

        // squareSize x squareSize 만큼의 칸에 값을 입력받습니다.
        // 이 때 칸을 squareSize + 1, squareSize + 1로 만들면
        // 어차피 int 배열의 기본값은 0이고, 그렇게 되면
        // (2,1) ~ (3,4)까지의 구간합도 별도 조건 검사 없이
        // (3,4)까지의 누적합 - (2,0)의 누적합으로 처리할 수 있습니다.

        // 만약 (2,2) ~ (2,2)까지의 구간합처럼 둘이 같은 경우라면
        // (2,2)까지의 누적합 - (2,1)까지의 누적합이므로 결국 (2,2)의 구간합
        // 즉 자기 자신이 나오게 됩니다.

        int[][] inputArray = new int[squareSize + 1][squareSize + 1]; // 입력 배열 inputArray 입니다.
        int[][] prefixSum = new int[squareSize + 1][squareSize + 1]; // 누적합 배열 prefixSum 입니다.

        // 시간 복잡도는 O(n^2)이므로 최대 100만번의 연산이 필요합니다.
        for (int i = 1; i <= squareSize; i++) { // 격자 크기 + 1만큼의 인덱스에 사용자의 입력을 각각 받아야 합니다.
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= squareSize; j++) {;
                inputArray[i][j] = Integer.parseInt(st.nextToken());
                // 2차원 배열의 누적합은
                // 끝점 + 위쪽 누적합 + 왼쪽 누적합을 한다음 왼쪽 누적합과 위쪽 누적합에서 겹치는 부분인 [i-1][j-1] 부분을 빼주면 됩니다.
                prefixSum[i][j] = inputArray[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        // 출력을 모아두고 있다가 한 번에 출력하기 위한 sb입니다.
        StringBuilder sb = new StringBuilder();

        // 사용자로부터 이제 count개만큼의 (x1, y1), (x2, y2) 조합이 주어집니다.
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 2차원 배열에서의 구간합은
            // 구간합 = 전체의 누적합 (x2, y2)에서 위쪽 누적합을 빼고 (x1-1, y2) 왼쪽 누적합을 빼고 (x2, y1-1) 그 둘이 겹치는 부분 (x1-1, y1-1)을 다시 더해줍니다.
            sb.append(prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1]).append("\n");
        }

        System.out.print(sb);
    }
}
