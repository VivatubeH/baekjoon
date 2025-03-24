import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 성의 크기인 n과 m을 입력받습니다.
        String[] dimensions = br.readLine().split(" "); // 공백 기준 입력된 숫자를 저장합니다.
        int n = Integer.parseInt(dimensions[0]); // 첫 숫자 n을 int로 형변환합니다.
        int m = Integer.parseInt(dimensions[1]); // 두 번째 숫자 m을 int로 형변환합니다.

        // 현재 성의 경비원 상태를 저장하기 위한 char 배열을 생성합니다.
        char[][] guards = new char[n][m];
        // 성의 상태를 2차원 배열로 입력받습니다.
        for (int i = 0; i < n; i++) {
            guards[i] = br.readLine().toCharArray();
        }

        // 행과 열의 경비원 여부를 체크하기 위한 배열을 생성합니다.
        boolean[] isRowGuard = new boolean[n];
        boolean[] isColumnGuard = new boolean[m];

        // 경비원들의 위치를 파악해서 경비원이 있는 경우를 체크합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 경비원이 있는 경우에는
                // 해당 행, 열에 경비원이 존재하므로
                if(guards[i][j] == 'X') {
                    isRowGuard[i] = true;
                    isColumnGuard[j] = true;
                }
            }
        }

        // 비어있는 행의 개수와 비어있는 열의 개수를 저장합니다.
        int nullRow = 0;
        int nullCol = 0;

        // false라면 경비원이 없는 경우니 숫자를 카운트합니다.
        for (int i = 0; i < n; i++) {
            if (isRowGuard[i] == false) {
                nullRow++;
            }
        }

        for (int j = 0; j < m; j++) {
            if (isColumnGuard[j] == false) {
                nullCol++;
            }
        }

        System.out.println(nullRow <= nullCol ? nullCol : nullRow);
    }
}
