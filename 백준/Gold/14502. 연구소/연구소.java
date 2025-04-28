import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 지도의 가로 크기

        // 사용자로부터 지도를 입력받습니다.
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 지도에서 0의 위치를 모두 기억합니다.( 빈 칸의 좌표를 모두 저장합니다. )
        ArrayList<Position> listOfZero = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    listOfZero.add(new Position(i, j)); // 0의 행과 열을 기록해둡니다.
                }
            }
        }

        int maxCount = -1; // 안전 영역의 최대 크기를 저장할 변수입니다.
        // 0인 행과 열을 3개를 조합을 짜면서 안전 영역의 최대 크기를 시뮬레이션을 통해 구합니다.
        int size = listOfZero.size(); // 0의 개수를 저장할 변수입니다.

        // 3중 for문에 대해서 combination을 짤려면
        // 이런 방식으로 짜야합니다. ( 최대 범위 고려해서, 중복 없도록 )
        for (int i = 0; i < size - 2; i++) {
            for (int j = i+1; j < size - 1; j++) {
                for (int k = j+1; k < size; k++) {
                    int[][] copyMap = arrayCopy(map, N, M); // 원본 배열의 손실을 막기 위해 매번 복사해서 사용합니다.
                    // i, j, k 번째에 벽을 세웁니다.
                    copyMap[listOfZero.get(i).row][listOfZero.get(i).col] = 1;
                    copyMap[listOfZero.get(j).row][listOfZero.get(j).col] = 1;
                    copyMap[listOfZero.get(k).row][listOfZero.get(k).col] = 1;

                    // 현재 지도를 기반으로 바이러스를 퍼뜨립니다.
                    copyMap = spreadVirus(copyMap, N, M);

                    // 바이러스가 퍼뜨려진 지도를 기반으로 안전영역의 개수를 counting 합니다.
                    int count = countTotalSafeZone(copyMap, N, M);

                    // 만약 최대 안전 영역의 크기보다 크면 갱신합니다.
                    if (count > maxCount) maxCount = count;
                }
            }
        }

        System.out.println(maxCount);
    }

    public static int[][] arrayCopy(int[][] map, int row, int col) {
        int[][] copyMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copyMap[i][j] = map[i][j]; // 원본 배열을 복사합니다.
            }
        }
        return copyMap;
    }

    public static int[][] spreadVirus(int[][] map, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 바이러스가 있는 지점을 탐색합니다.
                if (map[i][j] == 2) {
                    // 현재 위치와 현재 컬럼을 기반으로 바이러스를 퍼뜨립니다.
                    // 재귀적인 바이러스 퍼뜨림을 위해서입니다.
                    spreadVirusByPosition(map, row, col, i, j);
                }
            }
        }
        return map;
    }

    public static int[][] spreadVirusByPosition(int[][] map, int row, int col, int nRow, int nCol) {
        // 현재 바이러스 위치를 기반으로 해서, 상하좌우로 퍼뜨려야 합니다.
        // 이 때 퍼뜨린 상태에서 다시 재귀적으로 퍼뜨리는 과정을 수행해야 합니다.
        int[] dr = {-1, 1, 0, 0}; // row를 기준으로 상, 하, 좌, 우를 저장합니다.
        int[] dc = {0, 0, -1, 1}; // col을 기준으로 상, 하, 좌, 우를 저장합니다.

        // 4 방향을 다 돌면서 체크하겠습니다.
        for (int d = 0; d < 4; d++) { // 각각의 반복에 따라 상, 하, 좌, 우 이동합니다.
            int newRow = nRow + dr[d]; // 행을 이동하고
            int newCol = nCol + dc[d]; // 열을 이동합니다.

            // 지도 범위를 벗어나지 않아야 합니다.
            if (newRow >= 0 && newCol >= 0 && newRow < row && newCol < col) {
                if (map[newRow][newCol] == 0) { // 빈 칸이면
                    map[newRow][newCol] = 2; // 해당 위치에 바이러스를 퍼뜨립니다.
                    spreadVirusByPosition(map, row, col, newRow, newCol); // 해당 위치에서 다시 재귀적으로 퍼져나가야 합니다.
                }
            }
        }
        return map;
    }

    public static int countTotalSafeZone(int[][] map, int N, int M) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }
}

class Position {
    int row; // 행을 저장하기 위한 변수입니다.
    int col; // 열을 저장하기 위한 변수입니다.

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
