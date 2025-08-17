import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String input = br.readLine();
        boolean isOrigin = false;
        for (int i = 0; i <= length - 4; i++) {
            String sub = input.substring(i, i+4);
            if (sub.equals("gori")) {
                isOrigin = true;
                break;
            }
        }
        if (isOrigin) System.out.print("YES");
        else System.out.print("NO");
    }
}
