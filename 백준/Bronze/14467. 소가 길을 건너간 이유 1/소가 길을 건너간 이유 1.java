import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int minCount = 0; // 소의 최소 이동 거리를 세기 위한 변수
        int[] cowPosition = new int[11]; // 인덱스 활용을 위해 11로 만들고
        for (int i = 1; i <= 10; i++) {
            cowPosition[i] = -1; // 위치로 0과 1을 활용하기 위해 처음에 -1을 대입.
        }

        for (int i = 0; i < N; i++) { // N줄을 입력받습니다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()); // 소의 번호
            int position = Integer.parseInt(st.nextToken()); // 소의 위치

            if (cowPosition[number] == -1) { // 현재 위치가 초기화되지 않은 소라면 초기화만 하고
                cowPosition[number] = position;
            } else { // 현재 위치가 초기화된 소라면
                if (cowPosition[number] != position) { // 소의 위치가 다를 때만
                    cowPosition[number] = position; // 소의 위치를 변경하고
                    minCount++; // 최소 횟수를 추가시킵니다.
                }
            }
        }

        System.out.println(minCount); // 최소 횟수 출력
    }
}
