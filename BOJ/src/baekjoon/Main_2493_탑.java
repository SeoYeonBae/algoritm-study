package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> tops = new Stack<>();
		Stack<Integer> idx = new Stack<>();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		tops.push(Integer.parseInt(st.nextToken()));
		idx.push(1);
		sb.append(0).append(" ");
		
		for(int i = 2; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(!tops.isEmpty()) {
				if(tops.peek() < num) {
					tops.pop();
					idx.pop();
				}
				if(tops.isEmpty()) {
					sb.append(0).append(" ");
					tops.push(num);
					idx.push(i);
					break;
				}
				if(tops.peek() >= num) {
					sb.append(idx.peek()).append(" ");
					tops.push(num);
					idx.push(i);
					break;
				}
			}
		}	
		System.out.println(sb);
		in.close();
	}
}
