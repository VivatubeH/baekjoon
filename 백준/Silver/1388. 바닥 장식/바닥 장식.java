import java.io.*;
import java.util.*;

public class Main {
    public static char[][] field;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        // 1. N과 M에 따라 char로 field를 생성하고, 기록한다.
        field = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                field[i][j] = line.charAt(j);
            }
        }

        // 가로 개수, 세로 개수를 구하기 위한 메서드
        int totalCount = 0;
        int widthCount = 0;
        int heightCount = 0;

        // 2. 가로 측정 메서드를 통해 가로 개수를 구한다.
        widthCount = countWidth(N, M);
        // 3. 세로 측정 메서드를 통해 세로 개수를 구한다.
        heightCount = countHeight(N, M);

        // 4. 나무판자 개수를 출력한다.
        System.out.print(widthCount + heightCount);
    }

    public static int countWidth(int N, int M) {
        //
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            boolean isChecked = false;
            for (int j = 0; j < M; j++) {
                if (field[i][j] == '-' && !isChecked) {
                    count++;
                    isChecked = true;
                }
                if (field[i][j] == '|') {
                    isChecked = false;
                }
            }
            sum += count;
        }
        return sum;
    }

    public static int countHeight(int N, int M) {
        //
        int sum = 0;
        for (int i = 0; i < M; i++) {
            int count = 0;
            boolean isChecked = false;
            for (int j = 0; j < N; j++) {
                if (field[j][i] == '|' && !isChecked) {
                    count++;
                    isChecked = true;
                }
                if (field[j][i] == '-') {
                    isChecked = false;
                }
            }
            sum += count;
        }
        return sum;
    }
}