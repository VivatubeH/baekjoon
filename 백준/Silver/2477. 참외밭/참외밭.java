import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1제곱미터당 참외의 개수입니다.
        int N = Integer.parseInt(br.readLine());

        // 변들을 저장하기 위한 배열입니다.
        ArrayList<Side> sides = new ArrayList<>();

        // 가로인지 세로인지와 길이를 저장합니다.
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            sides.add(new Side(direction, length));
        }

        // 가로 중 최대 길이, 세로 중 최대 길이와 인덱스를 찾습니다.
        int maxWidth = 0;
        int maxWidthIndex = 0;
        int maxHeight = 0;
        int maxHeightIndex = 0;

        for (int i = 0; i < 6; i++) {
            Side side = sides.get(i);
            if (side.direction == 1 || side.direction == 2) { // 가로라면
                if (maxWidth < side.length) { // 최대 길이보다 더 길다면
                    maxWidthIndex = i;
                    maxWidth = side.length;
                }
            }
            if (side.direction == 3 || side.direction == 4) { // 세로라면
                if (maxHeight < side.length) { // 최대 길이보다 더 길다면
                    maxHeightIndex = i;
                    maxHeight = side.length;
                }
            }
        }

        // 최대 가로길이의 2번뒤, 최대 세로길이의 2번 뒤가 잘라내야 할 사각형의 가로길이, 세로길이이므로
        // 인덱스가 범위 초과하는 경우에 대비해서 % 6을 해줍니다.
        int cutHeight = sides.get((maxWidthIndex + 3) % 6).length ;
        int cutWidth = sides.get((maxHeightIndex + 3) % 6).length;

        // 구하고자 하는 넓이는 전체 사각형 넓이 - 잘라내야 할 사각형 넓이입니다.
        int targetSize = maxWidth * maxHeight - (cutWidth * cutHeight);
        int answer = targetSize * N; // 넓이에 제곱미터당 참외의 개수를 곱합니다.
        System.out.print(answer);
    }
}

class Side {
    int direction; // 가로인지 세로인지 저장합니다.
    int length; // 길이를 저장합니다.

    Side(int direction, int length) {
        this.direction = direction;
        this.length = length;
    }
}
