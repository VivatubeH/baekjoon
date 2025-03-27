import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 T를 입력받습니다.

        // T개의 테스트 케이스를 입력받아야 합니다.
        for (int i = 0; i < T; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(tokenizer.nextToken()); // 층수 H를 입력받습니다.
            int W = Integer.parseInt(tokenizer.nextToken()); // 방 개수 W를 입력받습니다.
            int N = Integer.parseInt(tokenizer.nextToken()); // 몇 번째 손님인지를 입력받습니다.

            System.out.println(assignACMHotelRoom(H, W, N));
        }
    }

    // 호텔의 층수, 방의 개수, 손님의 번호를 입력받아서 방을 배정해주는 메서드를 만듭니다.
    public static int assignACMHotelRoom(int height, int width, int no){
        // 방 배정 우선순위는 1순위가 걷는 거리, 2순위가 아래층 방입니다.
        // 즉 1호실을 전부 나눠주면, 2호실을 나눠주는 방식으로 진행됩니다.

        // 그렇다면 손님이 배정받는 층수는 no % height가 되야 하고

        // 손님이 배정받는 층수는
        // no % height == 0 이라면 height인 꼭대기 층을 배정받아야 합니다.
        // 아니라면 나머지 만큼의 층수를 배정받게 됩니다.

        // 손님이 배정받는 호수는
        // no % height == 0(해당 층을 채울 수 있는 경우)라면 no/height가 그대로 ( 해당 라인의 꼭대기 호실에 들어갑니다. )
        // (no / height) + 1이 되야 합니다. (해당 층을 채울 수 없다면) 다음 라인으로 넘어갑니다.
        int designatedHeight = no % height == 0 ? height : no % height; // 지정된 층수를 저장합니다.
        int designatedWidth = no % height == 0 ? no/height : no/height + 1; // 지정된 호수를 저장합니다.

        // 그리고 지정된 방 번호는 층수 x 100 + 호수입니다.
        int realRoomNo = designatedHeight * 100 + designatedWidth;

        return realRoomNo;
    }
}
