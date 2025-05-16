import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        // 입력 시에는 그냥 배열에 입력을 받기에는 공백이 없이 주어지니깐 그러지 말고.
        // 문자열로 입력을 받고, charAt으로 숫자로 변환해서 배열에 담는 게 나을 듯.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        // 배열을 입력받습니다.
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int maxSize = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 내부에서는 길이 len이 0부터 시작해서 길이를 늘려가되
                // i + len도 범위 내, j + len도 범위 내인 동안만 수행해야 합니다.
                for (int len = 0; (i + len) < N && (j +len) < M; len++) {
                    // 수행은 네 점의 좌표가 같은지 비교해야 합니다.
                    if (arr[i][j] == arr[i+len][j] && arr[i+len][j] == arr[i][j+len] && arr[i][j+len] == arr[i+len][j+len]) {
                        // 네 꼭짓점의 좌표가 같을 때만
                        int size = (len + 1) * (len + 1); // 넓이를 구하고
                        if (size > maxSize) maxSize = size; // 최대 넓이와 비교해서 넓을 때만 갱신합니다.
                    }
                }
            }
        }

        System.out.print(maxSize);

    }
}
