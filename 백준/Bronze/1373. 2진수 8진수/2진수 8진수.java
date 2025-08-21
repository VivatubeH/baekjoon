import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();

        Map<String, String> map = new HashMap<>();
        map.put("000", "0");
        map.put("001", "1");
        map.put("010", "2");
        map.put("011", "3");
        map.put("100", "4");
        map.put("101", "5");
        map.put("110", "6");
        map.put("111", "7");

        StringBuilder oct = new StringBuilder();
        int k = 0;
        if (length % 3 == 1) k = 2;
        if (length % 3 == 2) k = 1;

        for (int i = 0; i < k; i++) {
            oct.append("0");
        }
        oct.append(input);

        int count = length % 3 == 0 ? (length / 3) : (length / 3) + 1;
        int start = 0;

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < count; i++) {
            String sub = oct.substring(start, start + 3);
            answer.append(map.get(sub));
            start += 3;
        }

        System.out.print(answer);
    }
}
