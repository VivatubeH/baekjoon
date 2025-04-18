import java.util.*;
import java.io.*;
/*
    아이디어
    -> 이 별찍기 문제는 1부터 100까지의 자연수가 주어질 때,
    -> 그에 상응하는 패턴을 찾아서 패턴에 맞게 별을 찍는 문제입니다.
    -> 그래서 메서드로 만들고 메서드를 호출하는 방식으로 풀어보겠습니다.
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        printStarByNumber(N);
    }

    /**
     * 주어진 자연수 n을 기반으로 패턴을 분석해서 별을 찍는 메서드입니다.
     * @param n 별찍기 패턴 계산에 사용될 자연수 n
     */
    public static void printStarByNumber(int n) {
        // 가장 외곽 사각형을 고려했을 때 판의 크기는 4n - 3이 됩니다.
        // n에 따라 다르지만 테두리에만 별을 찍는다고 생각하면 됩니다.
        char[][] square = new char[4*n - 3][4*n - 3];
        int start = 0; // n일 때 시작점은 0입니다.
        int end = 4*n - 4; // n일 때 끝점은 4*n - 4입니다.

        int level = n;

        while (level >= 1) { // n이 1까지만 별을 찍어야 합니다.
            // start 행에서는 전부 별을 찍고
            // 그 외의 행에서는 start와 end 일 때만 별을 찍습니다.
            // end 행에서도 전부 별을 찍고
            for (int i = start; i <= end; i++) { // 행을 찍습니다.
                for (int j = start; j <= end; j++) { // 열을 찍습니다.
                    // 테두리에만 별을 찍어야 합니다.

                    if (i == start || i == end) square[i][j] = '*';
                    else if (j == start || j == end) square[i][j] = '*'; // 그 외 행에서는 시작열이나 끝열에만 별을 찍고
                    else square[i][j] = ' '; // 그 외는 전부 공백 문자를 찍어서 공백 칸을 만들어줍니다.
                }
            }
            level--; // n이 줄어들 때,
            start += 2; // 시작점은 2만큼 뒤로 가고
            end -= 2; // 끝점은 2만큼 앞으로 갑니다.
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4*n - 3; i++) {
            for (int j = 0; j < 4*n -3; j++) {
                sb.append(square[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
