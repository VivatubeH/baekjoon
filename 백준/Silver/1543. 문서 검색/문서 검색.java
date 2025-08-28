import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        int count = 0;

        int startIndex = 0;

        while (startIndex != -1) {
            startIndex = doc.indexOf(word, startIndex);

            if (startIndex != -1) {
                count++;
                startIndex += word.length();
            }
        }
        System.out.print(count);
    }
}
