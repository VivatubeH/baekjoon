import java.util.Scanner;
class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		int x = in.nextInt();
		int y = in.nextInt();
		
		in.close();
		int temp = y;
		int num_100 = temp/100;
		temp %= 100;
		int num_10 = temp/10;
		temp %= 10;
		int num_1 = temp/1;
		
		System.out.println(x*num_1);
		System.out.println(x*num_10);
		System.out.println(x*num_100);
		System.out.println(x*num_1 + x*num_10*10 + x*num_100*100);
	}
}
