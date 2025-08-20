import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int[] frequency = new int[26];
        while ((str = br.readLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == ' ') continue;
                frequency[ch - 'a']++;
            }
        }
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (max < frequency[i]) {
                max = frequency[i];
            }
        }
        for (int i = 0; i < 26; i++) {
            if (max == frequency[i]) {
                System.out.print((char)(i + 'a'));
            }
        }

    }
}
