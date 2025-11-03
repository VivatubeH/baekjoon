import java.io.*;
import java.util.*;

public class Main {
    public static int N; // 창고의 세로 칸 수
    public static int M; // 창고의 가로 칸 수
    public static int[][] storage; // 토마토 창고
    public static boolean[][] isVisited; // 해당 칸을 체크했는지 여부
    public static int[][] dayPassed; // 해당 칸이 며칠뒤에 익는지 체크하기 위함
    public static Queue<int[]> queue = new ArrayDeque<>(); // bfs 탐색용
    // 상하좌우 방향배열
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        input();
        System.out.print(bfs());
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            // 좌표를 (1,1)부터 사용하기 때문에 1크게 만듭니다.
            storage = new int[N + 1][M + 1];
            isVisited = new boolean[N + 1][M + 1];
            dayPassed = new int[N + 1][M + 1];
            // N칸에 걸쳐 토마토 정보를 입력받습니다.
            // 1 - 익음, 0 - 익지 않음, -1 - 토마토가 없음
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {
                    storage[i][j] = Integer.parseInt(st.nextToken());
                    // 익은 토마토의 주위만 체크하면 됩니다.
                    if (storage[i][j] == 1) { // 만약 익은 토마토면
                        queue.add(new int[]{i, j}); // bfs 탐색후보입니다.
                    }
                }
            }
        }
    }

    // bfs로 익은 토마토를 기준으로 탐색합니다.
    // bfs를 통해 모든 익은 토마토에 대해 체크해야만 종료됩니다.
    // 종료된 결과로 토마토가 익을 때까지 일자를 반환합니다.
    public static int bfs() {
        int maxDay = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0]; // 현재 x좌표
            int cy = current[1]; // 현재 y좌표
            isVisited[cx][cy] = true; // 해당 칸을 체크했다고 표시합니다.

            for (int i = 0; i < 4; i++) { // 해당 칸 주위를 체크합니다.
                int nx = cx + dx[i]; // 다음 x좌표
                int ny = cy + dy[i]; // 다음 y좌표

                // 범위를 벗어나는 좌표에 대해선 체크할 필요가 없습니다.
                if (nx < 1 || nx > N || ny < 1 || ny > M) {
                    continue;
                }

                // 악 익은 토마토이자 체크한 적 없는 토마토일 때만
                if (!isVisited[nx][ny] && storage[nx][ny] == 0) {
                    storage[nx][ny] = 1; // 해당 토마토는 익고
                    queue.offer(new int[]{nx, ny}); // 다음번에 탐색이 필요
                    // 현재칸으로부터 하루가 경과합니다.
                    dayPassed[nx][ny] = dayPassed[cx][cy] + 1;
                }
            }
        }
        // 하나라도 안 익은 토마토가 있다면 -1을 반환
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (storage[i][j] == 0) {
                    return -1;
                }
                // 토마토가 익었다면
                if (storage[i][j] == 1) {
                    // 그 중 가장 오래 걸린 토마토가 익는 기간을 선택합니다.
                    maxDay = Math.max(maxDay, dayPassed[i][j]);
                }
            }
        }
        return maxDay;
    }
}
