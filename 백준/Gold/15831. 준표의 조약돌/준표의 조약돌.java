import java.io.*;
import java.util.*;

public class Main {
    public static int answer;
    public static int B;
    public static int W;
    public static char[] road;
    public static int maxLength = 0;

    public static void main(String[] args) throws IOException {
        input();
        service();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer firstToken = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(firstToken.nextToken());
            B = Integer.parseInt(firstToken.nextToken());
            W = Integer.parseInt(firstToken.nextToken());
            road = new char[N];
            String roadString = br.readLine();
            for (int i = 0; i < N; i++) {
                road[i] = roadString.charAt(i);
            }
        }
    }

    public static void service() {
        int leftIndex = 0;
        int white = 0;
        int black = 0;

        for (int rightIndex = 0; rightIndex < road.length; rightIndex++) {
            if (road[rightIndex] == 'B') black++;
            else white++;

            while (black > B) {
                if (road[leftIndex] == 'B') black--;
                else white--;
                leftIndex++;
            }

            if (white >= W) {
                maxLength = Math.max(rightIndex - leftIndex + 1, maxLength);
            }
        }
    }

    public static void output() {
        System.out.print(maxLength);
    }
}
