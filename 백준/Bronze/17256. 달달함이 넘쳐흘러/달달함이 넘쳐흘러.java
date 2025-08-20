import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer aToken = new StringTokenizer(br.readLine());
        StringTokenizer cToken = new StringTokenizer(br.readLine());

        int ax = Integer.parseInt(aToken.nextToken());
        int ay = Integer.parseInt(aToken.nextToken());
        int az = Integer.parseInt(aToken.nextToken());

        int cx = Integer.parseInt(cToken.nextToken());
        int cy = Integer.parseInt(cToken.nextToken());
        int cz = Integer.parseInt(cToken.nextToken());

        int bx = cx - az;
        int by = cy / ay;
        int bz = cz - ax;

        System.out.print(bx + " " + by + " " + bz);
    }
}