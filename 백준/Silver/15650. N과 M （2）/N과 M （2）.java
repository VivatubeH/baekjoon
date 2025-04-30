import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] selected; // 하나의 수열을 완성하기 위한 배열
    static boolean[] isSelected; // 중복을 체크하기 위한 배열
    static StringBuilder sb = new StringBuilder(); // 출력은 builder에 담아서 한번에 처리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        isSelected = new boolean[N+1]; // 1부터 N까지 인덱스 활용이 필요

        recur(0); // 0번째 자리부터 depth를 키워가면서 sb에 재귀적으로 쌓습니다.
        System.out.println(sb);
    }

    // 재귀적으로 해당 수열을 구해보겠습니다.
    public static void recur(int depth) {
        if (depth == M) { // M개를 다 골랐을 때는
            for (int i = 0; i < M; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return; // 메서드를 종료합니다.
        }
        for (int i = 1; i <= N; i++) { // N개의 수에 대해서
            if (depth == 0) { // depth가 0, 즉 이전 수가 없을 때는 -> 선택되지 않은 수에 대해 조건 없이 선택하고 다음 수 선택
                if (!isSelected[i]) { // 아직 선택되지 않은 수의 경우
                    selected[depth] = i; // depth 번째 수를 선택하고
                    isSelected[i] = true; // 해당 수를 선택했다고 표시한 다음
                    recur(depth + 1); // 다음 수를 선택하러 가야 합니다.
                    // 핵심 : 이 지점으로 돌아오는 경우는 depth == M, 즉 M개의 수로 수열을 만들고
                    // 해당 수열에 대한 실질적인 출력까지 완료된 경우니 새로운 조합을 찾아야 합니다.
                    isSelected[i] = false; // 그렇기 위해 가장 마지막의 선택을 취소합니다. -> 그래야 끝자리가 바뀜
                }
            } else { // 이전 수가 있을 때는
                if (!isSelected[i]) { // 아직 선택되지 않은 수에 대해서
                    if (i > selected[depth - 1]) { // 오름 차순이 될 때만
                        selected[depth] = i; // depth 번째 수를 선택하고
                        isSelected[i] = true; // 해당 수를 선택했다고 표시한 다음
                        recur(depth + 1); // 다음 수를 선택하러 가야 합니다.
                        // 핵심 : 이 지점으로 돌아오는 경우는 depth == M, 즉 M개의 수로 수열을 만들고
                        // 해당 수열에 대한 실질적인 출력까지 완료된 경우니 새로운 조합을 찾아야 합니다.
                        isSelected[i] = false; // 그렇기 위해 가장 마지막의 선택을 취소합니다. -> 그래야 끝자리가 바뀜
                    }
                }
            }
        }
    }
}
