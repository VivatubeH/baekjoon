import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] selection; // 각 단계에서 선택된 조합을 고르기 위한 배열입니다.
    static boolean[] isSelected; // 중복 없이 선택하기 위한 boolean 배열입니다.
    static StringBuilder sb = new StringBuilder(); // 출력을 한 번에 처리하기 위해 StringBuilder를 사용합니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selection = new int[M]; // 총 M개를 선택해야 합니다.
        isSelected = new boolean[N+1]; // 1부터 N까지 인덱스를 활용하기 위해 1 크게 만듭니다.
        recur(0); // 처음에는 depth 0부터 시작합니다.
        System.out.print(sb);
    }

    // 몇 번째 자릿수를 선택하는지를 매개변수로 넘깁니다.
    public static void recur(int depth) {
        if (depth == M) { // M개를 다 선택했으면 M개를 출력합니다.
            for (int i = 0; i < M; i++) {
                sb.append(selection[i] + " ");
            }
            sb.append("\n"); // 다 고른 이후에는 줄바꿈을 합니다.
            return; // return을 해야 호출한 위치로 돌아갑니다. -> 초기화
        }

        // 각 자리에 대해서 선택해야 합니다.
        for (int i = 1; i <= N; i++) {
            if (!isSelected[i]) { // 아직 선택되지 않은 자리라면
                isSelected[i] = true; // 해당 수는 선택되었다고 표기하고
                selection[depth] = i; // 해당 수를 추가합니다.
                recur(depth+1); // 그 다음 자릿수 선택을 위해 depth를 늘려서 호출합니다.
                isSelected[i] = false; // 다시 선택되지 않았다고 표시합니다.
            }
        }
    }
}

