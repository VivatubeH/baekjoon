import java.io.*;
import java.util.*;

public class Main {
    public static int[][] bingo; // 빙고판에 들어갈 초기 숫자
    public static int[] nums; // 사회자가 부른 숫자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[5][5];
        // 빙고판에 들어갈 5x5 숫자를 입력받습니다.
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 다음으로 사회자가 부르는 숫자 25개를 순서대로 저장합니다.
        nums = new int[26]; // 출력도 몇 번째 수를 부르는지이니 1크게 만듭니다.
        int count = 1;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nums[count++] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= 25; i++) {
            remove(nums[i]); // i번째 수를 지웁니다.
            if (countBingo() >= 3) {
                System.out.print(i); // i번째 수에서 빙고를 부르고
                break; // 종료
            }
        }
    }

    public static void remove(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == num) {
                    bingo[i][j] = -1;
                }
            }
        }
    }

    // 빙고 개수를 세는 메서드입니다.
    public static int countBingo() {
        // 가로 빙고 수를 체크합니다.
        int rowBingo = countRowBingo();
        // 세로 빙고 수를 체크합니다.
        int colBingo = countColBingo();
        // 대각선 /, \방향 빙고를 체크합니다.
        int slashBingo = countSlashBingo();

        return rowBingo + colBingo + slashBingo;
    }

    public static int countRowBingo() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int check = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == -1) {
                    check++;
                }
            }
            if (check == 5) count++;
        }
        return count;
    }

    public static int countColBingo() {
        int count = 0;
        for (int j = 0; j < 5; j++) {
            int check = 0;
            for (int i = 0; i < 5; i++) {
                if (bingo[i][j] == -1) {
                    check ++;
                }
            }
            if (check == 5) count++;
        }
        return count;
    }

    public static int countSlashBingo() {
        int count = 0;
        int slashCount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == -1) {
                slashCount++;
            }
        }
        if (slashCount == 5) count++;

        int backSlashCount = 0;
        for (int i = 4; i >= 0; i--) {
            if (bingo[i][4-i] == -1) {
                backSlashCount++;
            }
        }
        if (backSlashCount == 5) count++;

        return count;
    }
}
