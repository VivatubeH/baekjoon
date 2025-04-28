import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] isRemoved = new boolean[N+1]; // 1번부터 N번 인덱스를 이용하기 위해 크기를 1 크게 만듭니다.

        int totalRemoved = 0; // N개를 모두 제거하면 프로그램을 종료해야 합니다.
        StringBuilder sb = new StringBuilder("<"); // 요세푸스 순열의 출력을 위해 기본으로 <로 시작합니다.
        int currentIndex = 1; // 현재 인덱스로 사용하기 위한 변수입니다. ( 프로그램 시작에서는 1부터 )

        while (totalRemoved != N) { // N개를 제거하기 전까지 반복을 통해 요세푸스 순열을 구합니다.
            int count = 0; // 내부 반복을 결정지을 변수 count입니다. ( count가 K가 될 때마다 제거합니다. )
            while (true) {
                if (!isRemoved[currentIndex]) { // 만약 현재 위치가 제거 되지 않은 상태라면
                    // 개수를 세고 다음 위치를 검사해야 합니다. -> 제거되지 않은 k번째를 제거합니다.
                    count++;
                    if (count == K) { // 만약에 K번째이면 제거하고, 개수를 세고, 다음 반복으로 넘깁니다.
                        isRemoved[currentIndex] = true; // 제거합니다.
                        totalRemoved++; // 전체 제거한 개수를 체크합니다.
                        if (totalRemoved == N) { // 만약 N개를 다 제거했으면
                            sb.append(currentIndex + ">"); // 닫아줍니다.
                        } else { // 그 전에는 ,를 뒤에 붙여야합니다.
                            sb.append(currentIndex + ", ");
                        }
                        break; // 다음 반복으로 넘기기 위해 반복을 종료합니다.
                    }
                }
                currentIndex++;
                if (currentIndex > N) currentIndex = 1; // 만약 끝점을 넘어가면 1부터 시작입니다.
            }
        }
        System.out.println(sb);
    }
}
