import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Square square = new Square();

        StringTokenizer st = new StringTokenizer(br.readLine());
        square.height = Integer.parseInt(st.nextToken()); // 높이
        square.length = Integer.parseInt(st.nextToken()); // 길이
        square.time = Integer.parseInt(st.nextToken()); // 시간

        st = new StringTokenizer(br.readLine());
        square.k = Integer.parseInt(st.nextToken()); // 기준 정수 k
        square.min = Integer.parseInt(st.nextToken()); // 최소 기준
        square.max = Integer.parseInt(st.nextToken()); // 최대 기준

        square.checkBoard = new char[square.height + 1][square.length + 1]; // 빈 바둑판을 생성합니다.
        for (int i = 1; i<= square.height; i++) {
            StringBuilder sb = new StringBuilder(br.readLine()).insert(0, " "); // 0번째 인덱스를 뒤로 밀어버립니다. ( 1번부터 담기 위해 )
            for (int j = 1; j <= square.length; j++) {
                square.checkBoard[i][j] = sb.charAt(j); // 인덱스에 맞춰서 담습니다.
            }
        }

        for (int t = 0; t < square.time; t++) { // 바둑판을 t번 변경합니다.
            square.makePrefixSum(); // 누적합을 생성합니다.
            square.changeCheckBoard(); // 누적합을 기준으로 바둑판을 변경합니다. ( 구간합 이용 )
        }

        // t번 변경된 뒤 바둑판을 출력합니다.
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= square.height; i++) {
            for (int j = 1; j <= square.length; j++) {
                result.append(square.checkBoard[i][j]);
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}

class Square {
    public int height; // 바둑판 세로길이
    public int length; // 바둑판 가로길이
    public int time; // 바둑판 관찰 시간
    public int k; // 주위 기준이 되는 정수 k
    public int min; // 주위 기준이 되는 정수 min;
    public int max; // 주위 기준이 되는 정수 msx;

    public char[][] checkBoard; // 바둑판을 저장할 변수
    public int[][] prefixSum; // 누적합을 저장할 변수

    public void makePrefixSum() { // 누적합을 생성하는 메서드입니다.
        prefixSum = new int[height + 1][length + 1];
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= length; j++) {
                // 바둑판의 누적합을 구합니다. ( 자기 자신 + 위쪽 누적합 + 왼쪽 누적합 - 중복된 누적합 )
                prefixSum[i][j] = (checkBoard[i][j] == '*' ? 1 : 0 ) + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }
    }

    public void changeCheckBoard() {
        // 연산과정에서만 쓰일 newCheckBoard를 만듭니다.
        char[][] newCheckBoard = new char[height + 1][length + 1];
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= length; j++) {
                // 구간이 바둑판을 뛰어나가지 못하도록 바운더리를 정해둡니다.
                int left = Math.max(j-k, 1);
                int right = Math.min(j+k, length);
                int top = Math.max(i-k, 1);
                int bottom = Math.min(i+k, height);

                // (top, left) 부터 (bottom, right)까지의 구간합에서 가운데 (i, j)를 뺀 생명의 개수를 토대로 바둑판을 갱신해야 합니다.
                int life = prefixSum[bottom][right] - prefixSum[top - 1][right] - prefixSum[bottom][left - 1] + prefixSum[top-1][left-1];

                if (checkBoard[i][j] == '*') life--; // 기존의 가운데 칸에 생명이 있었으면 중복으로 센 것이니 빼줍니다.

                // 이제 생명의 규칙에 맞게 각 칸을 변경해줘야 합니다. ( 이 때 변경은 초기 칸에 한해서만 이루어져야 합니다. )
                if (checkBoard[i][j] == '*' && life >= min && life <= max) { // 생존 조건입니다.
                    newCheckBoard[i][j] = '*';
                } else if (checkBoard[i][j] == '*' && life < min) { // 고독 조건입니다.
                    newCheckBoard[i][j] = '.';
                } else if (checkBoard[i][j] == '*' && life > max) { // 과밀 조건입니다.
                    newCheckBoard[i][j] = '.';
                } else if (checkBoard[i][j] == '.' && life > min && life <= max) { // 탄생 조건입니다.
                    newCheckBoard[i][j] = '*';
                } else { // 4가지 조건에 다 해당되지 않는 경우 기존 칸 그대로입니다.
                    newCheckBoard[i][j] = checkBoard[i][j];
                }
            }
        }
        checkBoard = newCheckBoard; // 다 완성되면 기존 바둑판을 변경합니다.
    }
}