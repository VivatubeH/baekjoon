import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String original = br.readLine();
            if (original.equals("0")) {
                break;
            }
            StringBuilder change = new StringBuilder(original);
            change = change.reverse();
            String after = String.valueOf(change);
            if (original.equals(after)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
