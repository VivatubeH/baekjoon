import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] cups = new boolean[4];
        cups[1] = true;
        cups[2] = false;
        cups[3] = false;
        int ballIndex = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            boolean temp = cups[first];
            cups[first] = cups[second];
            cups[second] = temp;
        }

        for (int i = 1; i <= 3; i++) {
            if (cups[i]) System.out.println(i);
        }
    }
}
