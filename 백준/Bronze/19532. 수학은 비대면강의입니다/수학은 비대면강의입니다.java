import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int e = in.nextInt();
		int f = in.nextInt();
		
		int x = (e*c - b*f) / (a*e - b*d);
		int y = (a*f - c*d) / (a*e - b*d);
		
		System.out.println(x + " " + y);
	}
}