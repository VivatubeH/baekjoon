import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader 클래스의 객체를 생성합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 T를 입력받습니다.
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(a+b);
        }
    }
}