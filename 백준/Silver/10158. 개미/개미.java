import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        int p = scanner.nextInt();
        int q = scanner.nextInt();

        int t = scanner.nextInt();

        int xPosition = 0;
        int yPosition = 0;

        // x와 y가 실제로 이동하는 시간
        int realtimeX = t % (2 * w);
        int realtimeY = t % (2 * h);

        // 개미가 0에서부터 움직였다고 가정하면
        // p초후에 p위치로 오기 때문에
        // 0부터 p + realtimeX까지 이동한다고 보면 된다.
        int totalmoveX = p + realtimeX;
        int totalmoveY = q + realtimeY;

        // 이 이동거리를 2 * w, 2 * h로 나눈 나머지를 각각 구한다
        int remainderX = totalmoveX % (2 * w);
        int remainderY = totalmoveY % (2 * h);

        // remainder 모든 왕복이 종료된 후, 개미는 0에서
        // remainder 만큼 떨어진 곳에 위치한다.
        // 만약 remainder이 w보다 작거나 같다면 우측으로 이동중이니
        if (remainderX <= w) {
            xPosition = remainderX; // 최종 좌표는 그대로
        } else { // w보다 크다면 우측에서 반대로 이동중이니
            xPosition = w - (remainderX - w);
        }

        if (remainderY <= h) {
            yPosition = remainderY; // 최종 좌표는 그대로
        } else {
            yPosition = h - (remainderY - h);
        }

        System.out.print(xPosition + " " + yPosition);
    }
}
