import java.io.*;
import java.util.*;

public class Main {
	// 짐이 있는 칸은 '*', 짐이 없는 칸은 '.'
	public static char[][] room;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		room = new char[N + 1][N + 1];
		
		// 짐이 있는 칸을 체크해둡니다.
		for (int i = 1; i <= N; i++) {
			String row = br.readLine();
			for (int j = 1; j <= N; j++) {
				char ch = row.charAt(j - 1);
				room[i][j] = ch;
			} 
		}
		
		// 해당 행을 측정합니다.
		int rowCount = 0;
		for (int i = 1; i <= N; i++) {
			int continuous = 0;
			for (int j = 1; j <= N; j++) {
				if (room[i][j] == '.') {
					continuous++;
				}
				if (room[i][j] == 'X' || j == N) {
					if (continuous >= 2) {
						rowCount++;
					}
					continuous = 0;
				}
			}
		}
		
		// 해당 열을 측정합니다. 
		int colCount = 0;
		for (int j = 1; j <= N; j++) {
			int continuous = 0;
			for (int i = 1; i <= N; i++) {
				if (room[i][j] == '.') {
					continuous++;
				}
				if (room[i][j] == 'X' || i == N) {
					if (continuous >= 2) {
						colCount++;
					}
					continuous = 0;
				}
			}
		}
		
		System.out.print(rowCount + " " + colCount);
	}
}
