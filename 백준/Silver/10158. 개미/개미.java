import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstToken = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(firstToken.nextToken());
        int h = Integer.parseInt(firstToken.nextToken());

        StringTokenizer secondToken = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(secondToken.nextToken());
        int q = Integer.parseInt(secondToken.nextToken());

        int t = Integer.parseInt(br.readLine());

        int moveTimeX = t % (2*w);
        int moveTimeY = t % (2*h);

        int x = (p + moveTimeX) % (2 * w);
        int y = (q + moveTimeY) % (2 * h);

        if (x > w && x < (2 * w)) {
            x = w - (x % w);
        }
        if (y > h && y < (2 * h)) {
            y = h - (y % h);
        }
        System.out.print(x + " " + y);
    }
}
