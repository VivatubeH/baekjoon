import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		
		long a, b, c;
		Scanner in = new Scanner(System.in);
		
		a = in.nextLong();
		b= in.nextLong();
		c=in.nextLong();
		
		System.out.println(a+b+c);
		in.close();
	}
}