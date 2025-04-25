import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hashSet.add(st.nextToken()); // 토큰 단위 문자열을 저장시킵니다.
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) { // M개의 입력을 받아서 줄마다 존재하는지 체크 후 존재하면 1, 존재 x시 0 출력
            int now = Integer.parseInt(st.nextToken());
            if (hashSet.contains(String.valueOf(now))) { // 해당 문자열을 포함하면
                sb.append("1");
            } else { // 해당 문자열을 포함하지 않으면 0을 결합하고
                sb.append("0");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
