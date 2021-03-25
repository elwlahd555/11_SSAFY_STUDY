package com.algorithm.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_3954_Brainfuck인터프리터 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			char code[] = bf.readLine().toCharArray();
			char arr[] = bf.readLine().toCharArray();
			int point = 0;
			int number = 0;
			int check = 0;
			int mem[] = new int[N];
			int arrnumber = 0;
			
            Stack<Integer> stack = new Stack<>();
            int[] bracket = new int[C]; // 서로 연결되어있는 괄호의 위치.
            for (int i = 0; i < C; i++) {
                char c = code[i];
 
                if (c == '[') {
                    stack.push(i);
                } else if (c == ']') { // 닫는 괄호와 여는 괄호를 서로 연결시켜 줌.
                    int temp = stack.peek();
                    bracket[i] = temp; // 여는 괄호에는 닫는 괄호의 위치를
                    bracket[temp] = i; // 닫는 괄호에는 여는 괄호의 위치를 저장함.
                    stack.pop();
                }
            }
            int maxCloseBracket = 0; // 이것을 사용하는 이유는 아래에서 기술함.
			
			while (number < 50000000) {
				switch (code[check]) {
				case '+':

					mem[point] = (mem[point] + 1) > 255 ? 0 : (mem[point] + 1);
					break;
				case '-':
					mem[point] = (mem[point] - 1) < 0 ? 255 : (mem[point] - 1);
					break;
				case '<':
					if (point == 0) {
						point = N - 1;
					} else {
						point--;

					}
					break;
				case '>':
					if (point == N - 1) {
						point = 0;
					} else {

						point++;
					}
					break;
				case '[':
					if (mem[point] == 0) {
						check=bracket[check];
					}
					break;
				case ']':
					if (mem[point] != 0) {
						maxCloseBracket = Math.max(maxCloseBracket, check);
						check=bracket[check];
					}
					break;
				case '.':

					break;
				case ',':
					if (arrnumber < size) {
						mem[point] = arr[arrnumber];

					} else {
						mem[point] = 255;
					}
					arrnumber++;
					break;
				}

				check++;
				if (check >= C)
					break;
				number++;
			}
			if (number != 50000000) {
				System.out.println("Terminates");
			} else {
				System.out.println("Loops " + bracket[maxCloseBracket] + " " + maxCloseBracket);
			}
		}
	}
}
