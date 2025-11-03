import java.io.*;
import java.util.*;

public class Main {
    public static int R; // 미로의 행
    public static int C; // 미로의 열
    public static char[][] maze; // 초기 미로 상태
    public static int[] initialJihun; // 초기 지훈의 좌표
    public static int[][] fireMinute; // 불의 변화량
    public static int[][] jihunMinute; // 지훈의
    public static boolean[][] isJihunChecked; // 지훈이 체크 여부
    public static boolean[][] isFireChecked; // 불의 체크 여부
    public static int min = Integer.MAX_VALUE; // 지훈이의 미로 탈출 최소시간
    public static Queue<int[]> fireQueue = new ArrayDeque<>(); // 불 bfs용 큐
    // 이동은 상하좌우로만 가능합니다.
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        input();
        bfsFire();
        int time = bfsJihun();
        if (time == -1) {
            System.out.print("IMPOSSIBLE");
        } else {
            System.out.print(time);
        }
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            // 배열 생성
            maze = new char[R + 1][C + 1];
            fireMinute = new int[R + 1][C + 1];
            jihunMinute = new int[R + 1][C + 1];
            isJihunChecked = new boolean[R + 1][C + 1];
            isFireChecked = new boolean[R + 1][C + 1];

            for (int i = 1; i <= R; i++) {
                String line = br.readLine();
                for (int j = 1; j <= C; j++) {
                    char ch = line.charAt(j - 1);
                    maze[i][j] = ch;
                    // 불이 난 시간이 0과, 구분하기 위해
                    // 불이 아닌 건 전부 다른 값을 넣습니다.
                    if (ch != 'F') {
                        fireMinute[i][j] = Integer.MAX_VALUE;
                    }
                    // 초기 지훈의 좌표 저장
                    if (ch == 'J') {
                        initialJihun = new int[]{i, j};
                    }
                    // 초기 불의 좌표 저장
                    if (ch == 'F') {
                        fireQueue.offer(new int[]{i, j});
                    }
                }
            }
        }
    }

    // 불에 대한 BFS 탐색을 시작합니다.
    public static void bfsFire() {
        while (!fireQueue.isEmpty()) { // 탐색 가능한 불에 대해 모두 탐색
            // 현재 불을 꺼냅니다.
            int[] current = fireQueue.poll();
            int cx = current[0]; // 현재 x좌표
            int cy = current[1]; // 현재 y좌표
            isFireChecked[cx][cy] = true; // 현재 칸은 방문체크합니다.

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; // 다음 x좌표
                int ny = cy + dy[i]; // 다음 y좌표

                // 범위를 벗어난 좌표에 대해서는 체크할 필요가 없습니다.
                if (nx < 1 || nx > R || ny < 1 || ny > C) {
                    continue;
                }
                // 해당 칸이 벽도 아니고, 불이 아닐때 퍼집니다.
                if (maze[nx][ny] != '#' && fireMinute[nx][ny] == Integer.MAX_VALUE) {
                    isFireChecked[nx][ny] = true; // 방문 체크하고,
                    fireMinute[nx][ny] = fireMinute[cx][cy] + 1; // 1초 뒤 체크
                    fireQueue.offer(new int[]{nx, ny}); // 해당 칸은 다음번 검사합니다.
                }
            }
        }
    }

    // 지훈이의 이동에 대한 BFS 탐색을 시작합니다.
    public static int bfsJihun() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(initialJihun); // 초기 지훈이의 좌표부터 큐에 넣습니다.
        int initialX = initialJihun[0];
        int initialY = initialJihun[1];

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 검사할 지점입니다.
            int cx = current[0]; // 현재 x좌표
            int cy = current[1]; // 현재 y좌표
            isJihunChecked[cx][cy] = true; // 해당 지점을 체크합니다.

            // 현재 위치가 가장자리면 다음 턴에 탈출 가능합니다.
            if (cx == 1 || cx == R || cy == 1 || cy == C) {
                return jihunMinute[cx][cy] + 1; // 지금 지점 1초 뒤 탈출
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; // 다음 x좌표
                int ny = cy + dy[i]; // 다음 y좌표

                // 벽이거나 이미 체크한 칸일 때는 체크할 필요가 없습니다.
                if (maze[nx][ny] == '#' || isJihunChecked[nx][ny]) {
                    continue;
                }

                // 이동할 수 없다면 이동하지 않습니다.
                if (nx < 1 || nx > R || ny < 1 || ny > C) {
                    continue;
                }

                // 지훈이가 불보다 먼저 도착할 수 있으면
                // 즉 1초 뒤에도 불붙는 시간 이전이면 이동 가능
                if (jihunMinute[cx][cy] + 1 < fireMinute[nx][ny]) {
                    isJihunChecked[nx][ny] = true;
                    jihunMinute[nx][ny] = jihunMinute[cx][cy] + 1; // 1초 뒤 해당 칸 이동
                    queue.offer(new int[]{nx, ny}); // 큐에 넣습니다.
                }
            }
        }
        return -1; // BFS 이후에도 탈출 불가하면 -1입니다.
    }
}
