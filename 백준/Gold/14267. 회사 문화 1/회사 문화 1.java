import java.io.*;
import java.util.*;

public class Main {
    public static int N; // 회사의 직원 수
    public static int[] praiseCounting; // 최초 칭찬받은 정도를 저장할 배열
    public static List<List<Integer>> tree = new ArrayList<>();
    public static int M; // 최초의 칭찬 횟수

    public static void main(String[] args) throws IOException {
        input();
        dfs(1);
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // 트리 초기화
            for (int i = 0; i <= N; i++) {
                tree.add(new ArrayList<>());
            }
            praiseCounting = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            // 1번부터 n번까지 자신의 상사의 번호가 주어짐.
            for (int i = 1; i <= N; i++) {
                int superior = Integer.parseInt(st.nextToken());
                if (superior != -1) { // -1의 직속부하는 없는 경우니 제외
                    tree.get(superior).add(i); // superior의 직속부하가 i번이다.
                }
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                // 같은 직원이 여러번 칭찬받기도 가능! 
                praiseCounting[index] += w;
            }
        }
    }

    // 상사부터 부하 순으로 칭찬 점수를 누적
    // 즉, 부하 직원들은 다 직속 상사가 받은 칭찬을 똑같이 받아야함.
    public static void dfs(int current) {
        for (int next : tree.get(current)) {
            praiseCounting[next] += praiseCounting[current];
            dfs(next);
        }
    }

    public static void output() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 1; i <= N; i++) {
                bw.write(praiseCounting[i] + " ");
            }
            bw.flush();
        }
    }
}
