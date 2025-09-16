import java.io.*;
import java.util.*;

public class Main {
	public static int[][] prefixSum;
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
			prefixSum = new int[N + 1][N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int current = Integer.parseInt(st.nextToken());
					prefixSum[i + 1][j + 1] = 
							prefixSum[i][j + 1] 
						  + prefixSum[i + 1][j] 
						  - prefixSum[i][j] 
						  + current;
				}
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer query = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(query.nextToken());
				int y1 = Integer.parseInt(query.nextToken());
				int x2 = Integer.parseInt(query.nextToken());
				int y2 = Integer.parseInt(query.nextToken());
				
				int current = prefixSum[x2][y2] 
						- prefixSum[x1 -1][y2] 
						- prefixSum[x2][y1 - 1]
						+ prefixSum[x1 -1][y1 -1];
				
				answer.append(current).append("\n");
			}
		}
	}
	
	public static void output() throws IOException {
		System.out.print(answer);
	}
}
