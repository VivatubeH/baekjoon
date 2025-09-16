import java.io.*;
import java.util.*;

public class Main {
	public static int[] initialGround;
	public static int[] diff;
	public static int[] prefixSum;
	public static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		inputAndService();
		output();
	}
	
	public static void inputAndService() throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			initialGround = new int[N + 1];
			diff = new int[N + 1];
			prefixSum = new int[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				initialGround[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int height = Integer.parseInt(st.nextToken());
				
				diff[start] += height;
				if (end + 1 <= N) {
					diff[end + 1] -= height;
				}
			}
			for (int i = 1; i <= N; i++) {
				prefixSum[i] = prefixSum[i - 1] + diff[i];
				initialGround[i] += prefixSum[i];
				answer.append(initialGround[i]).append(" ");
			}
		}
	}
	
	public static void output() {
		System.out.print(answer);
	}
}
