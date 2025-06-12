import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. N과, 새로운 점수, P가 첫 줄에 주어진다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken());
        int newScore = Integer.parseInt(firstLine.nextToken());
        int P = Integer.parseInt(firstLine.nextToken());
        // 2. 둘째 줄은 N이 0보다 큰 경우에만 주어진다.
        ArrayList<Integer> scores = new ArrayList<>();
        if (N > 0) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scores.add(Integer.parseInt(token.nextToken()));
            }
        }
        // 새로운 점수를 가지고 등수를 계산한다.
        checkRank(N, P, newScore, scores);
    }
    // 3. 새로운 점수를 가지고 등수를 계산한다.
    // 메서드로 구현한다.
    // 인수로는 N, P, newScore, scores가 주어진다.
    public static void checkRank(int N, int P, int newScore, ArrayList<Integer> scores) {
        // N == 0 -> 둘째 줄이 주어지지 않았음
        // P가 10보다 크거나 같으므로 무조건 1등 그대로 출력. 종료
        if (N == 0) {
            System.out.println(1);
            return;
        }

        // N == P -> 가장 마지막보다 낮거나 같으면 -1을 출력한다. 종료
        if (N == P) {
            if (newScore <= scores.get(scores.size() - 1)) {
                System.out.println(-1);
                return;
            }
        }

        // 자기보다 큰 점수의 개수를 구한다. ( 기본값 1로해서 더해서 등수 )
        // 자기보다 작거나 같다면 break
        // 반복문이 종료되고 개수를 출력하고 종료.
        int count = 1;
        for (Integer integer : scores) {
            if (integer > newScore) {
                count++;
            } else {
                break;
            }
        }
        System.out.print(count);
        return;
    }


}
