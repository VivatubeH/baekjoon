import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] clouds = new char[H + 1][W + 1];
        for (int i = 1; i <= H; i++) {
            String str = br.readLine();
            for (int j = 1; j <= W; j++) {
                clouds[i][j] = str.charAt(j-1); // 이렇게 해야 0번 인덱스를 1번으로 저장합니다.
            }
        }
        int[][] result = new int[H + 1][W + 1]; // 판별결과는 int 배열에 저장하겠습니다.
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (clouds[i][j] == 'c') { // 자기 자신이 구름인 경우 0이 됩니다.
                    result[i][j] = 0;
                } else { // 자기 자신이 구름이 아닌 경우
                    boolean hasCloudsOnLeft = false;
                    int maxIndex = -1;
                    for (int k = 1; k < j; k++) { // 자신의 왼쪽을 체크합니다.
                        if (clouds[i][k] == 'c') { // 자신의 왼쪽에 구름이 있으면
                            hasCloudsOnLeft = true; // 왼쪽에 구름이 있다고 체크하고
                            if (maxIndex < k) { // 가장 우측 인덱스를
                                maxIndex = k; // 기록해둡니다.
                            }
                        }
                    }
                    // 판별이 끝난 다음 왼쪽에 구름이 없는 경우는 결과로 -1을
                    if (!hasCloudsOnLeft) {
                        result[i][j] = -1;
                    } else { // 왼쪽에 구름이 있는 경우는 현재 위치 빼기 - 최대 인덱스 ( 경과 시간 )
                        result[i][j] = j - maxIndex;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
