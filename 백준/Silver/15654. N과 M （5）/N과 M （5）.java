import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] isSelected;
    public static int[] candidate;
    public static int[] selected;
    public static StringBuilder answer = new StringBuilder();
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        input();
        permutation(0);
        System.out.print(answer);
    }

    public static void permutation(int depth) {
        // 종료 조건 ( 종료 시 수행할 작업 + return으로 종료 )
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                answer.append(selected[i]).append(" ");
            }
            answer.append("\n");
            return;
        }
        // 중복은 허용하지 않으므로 해당 원소를 사용했는지 여부 체크.
        // 1, 7 / 7, 1 조합이 둘 다 가능하므로 i = 0부터 다시 탐색
        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) { // 안 뽑은 원소에 대해서만
                isSelected[i] = true; // 뽑고
                selected[depth] = candidate[i]; // 원소를 저장한 다음
                permutation(depth + 1); // 다음 원소를 뽑으러 감
                isSelected[i] = false; // 다음 케이스를 체크하기 위해 복구
            }
        }
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            candidate = new int[N];
            isSelected = new boolean[N];
            selected = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                candidate[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(candidate);
        }
    }
}
