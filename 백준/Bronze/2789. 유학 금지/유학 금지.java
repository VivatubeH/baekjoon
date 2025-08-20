import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!isCambridge(ch)) System.out.print(ch);
        }
    }

    public static boolean isCambridge(char ch) {
        if ("CAMBRIDGE".contains(String.valueOf(ch))) {
            return true;
        }
        return false;
    }
}
