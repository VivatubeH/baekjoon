import java.io.*;
import java.util.*;

public class Main {
	public static int[] prefixSumXOR;
	public static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		inputAndService();
		output();
	}
	
	public static void inputAndService() throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N  = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			prefixSumXOR = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				prefixSumXOR[i + 1] = prefixSumXOR[i] ^ Integer.parseInt(st.nextToken()); 
			}
			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine());
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				
				int current = prefixSumXOR[right] ^ prefixSumXOR[left - 1];
				answer ^= current;
			}
		}
	}
	
	public static void output() {
		System.out.print(answer);
	}
}
