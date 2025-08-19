import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int eatCount = Integer.parseInt(st.nextToken());
            int needCount = Integer.parseInt(st.nextToken());

            if (eatCount >= needCount) answer.append("MMM BRAINS\n");
            else answer.append("NO BRAINS\n");
        }
        System.out.print(answer);
    }
}