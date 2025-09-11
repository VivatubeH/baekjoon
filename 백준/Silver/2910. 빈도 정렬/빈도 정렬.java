import java.io.*;
import java.util.*;

public class Main {
	public static Map<Integer, Frequency> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		input();
		output();
	}
	
	public static void input() throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int current = Integer.parseInt(st.nextToken());
				
				if (map.containsKey(current)) {
					map.get(current).increaseFrequency();
				} else {
					map.put(current, new Frequency(current, 1, i));
				}
			}
		}
	}
	
	public static void output() throws IOException {
		List<Frequency> list = new ArrayList<>(map.values());
		Collections.sort(list);
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			for (Frequency frequency : list) {
				for (int i = 0; i < frequency.getFrequency(); i++) {
					bw.write(String.valueOf(frequency.getNum()) + " ");
				}
			}
		}
	}
}

class Frequency implements Comparable<Frequency> {
	private int num;
	private int frequency;
	private int order;
	
	public Frequency(int num, int frequency, int order) {
		this.num = num;
		this.frequency = frequency;
		this.order = order;
	}
	
	public int getNum() {
		return num;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void increaseFrequency() {
		frequency++;
	}
	
	public int compareTo(Frequency other) {
		if (this.frequency != other.frequency) {
			return other.frequency - this.frequency;
		}
		return this.order - other.order;
	}
	
}
