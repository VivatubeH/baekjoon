import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1. N과 M을 토큰 단위로 입력받는다. ( int로 변환 )
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();
        int hdSum = 0;

        // 2. N개의 줄에 걸쳐서 DNA를 입력받는다.
        char[][] DNA = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                DNA[i][j] = line.charAt(j);
            }
        }

        // 3. 반복문을 돌면서 1 ~ M-1번째 글자까지 체크한다.
        for (int j = 0; j < M; j++) {

            int countA = 0;
            int countC = 0;
            int countG = 0;
            int countT = 0;

            // 각 열에 대한 빈도를 저장한다.
            for (int i = 0; i < N; i++) {
                char ch = DNA[i][j];

                if (ch == 'A') countA++;
                else if (ch == 'C') countC++;
                else if (ch == 'G') countG++;
                else if (ch == 'T') countT++;
            }
            int max = 0;
            char maxCharacter = ' ';
            // A -> C -> G -> T 순서로 비교 갱신한다.
            if (max < countA) {
                max = countA;
                maxCharacter = 'A';
            }
            if (max < countC) {
                max = countC;
                maxCharacter = 'C';
            }
            if (max < countG) {
                max = countG;
                maxCharacter = 'G';
            }
            if (max < countT) {
                max = countT;
                maxCharacter = 'T';
            }
            // Hamming Distance를 누적하고 DNA를 구한다.
            hdSum += (N - max);
            answer.append(maxCharacter);
        }

        // 정답을 출력합니다.
        System.out.println(answer);
        System.out.print(hdSum);

    }

}
