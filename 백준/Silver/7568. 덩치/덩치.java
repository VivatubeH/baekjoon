import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());
        int[] height = new int[people]; // 키를 저장하기 위한 배열을 만듭니다.
        int[] weight = new int[people]; // 몸무게를 저장하기 위한 배열을 만듭니다.

        int[] grade = new int[people]; // 등수를 측정하기 위한 배열을 만듭니다.

        for (int i = 0; i < people; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken()); // 몸무게를 입력받습니다.
            height[i] = Integer.parseInt(st.nextToken()); // 키를 입력받습니다.
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < people; i++) {
            for (int j = 0; j < people; j++) {
                if (i == j) continue; // 자기 자신은 체크할 필요 없습니다.

                // 키와 몸무게가 더 큰 ( 덩치가 더 큰 사람의 수를 )
                if (height[i] < height[j] && weight[i] < weight[j]) {
                    grade[i]++; // 체크합니다.
                }
            }
            // 자기보다 덩치가 더 큰사람의 수 + 1이 등수가 됩니다.
            sb.append((grade[i]+1) + " "); // 측정이 끝나면 공백문자를 이어붙여가며 저장합니다.
        }

        System.out.print(sb); // 마지막에 덩치 등수를 출력합니다.
    }
}
