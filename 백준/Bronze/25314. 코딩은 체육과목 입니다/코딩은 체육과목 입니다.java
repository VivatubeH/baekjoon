import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int times = n/4;
				
		String how = "";
		
		for (int i = 1; i <= times; i++) {
			how += "long ";
		}
		System.out.println(how + "int");
	}
}