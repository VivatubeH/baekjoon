import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // hashMap에 n개의 정수를 입력하겠습니다.
            int currentNum = Integer.parseInt(st.nextToken());
            // 이렇게 설정하면 해당 키값이 존재하면 해당 해당 키값 + 1을
            // 해당 키값이 존재하지 않으면 기본값 0 + 1인 1을 집어넣게 됩니다.
            hashMap.put(currentNum, hashMap.getOrDefault(currentNum, 0) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) { // M개의 정수를 key로 해서 value를 조회합니다.
            int currentNum = Integer.parseInt(st.nextToken());
            int result = hashMap.getOrDefault(currentNum, 0); // 지금 key가 존재하면 value를 가져오고 아니면 0을 가져옵니다.
            answer.append(result + " "); // 점수에다가 공백을 더합니다.
        }

        System.out.println(answer);
    }
}
