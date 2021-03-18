package com.test.ssafy;

import java.util.ArrayList;
import java.util.Scanner;

public class 방사선_치료 {
	private static class Point {
		int x1, y1, x2, y2;

		public Point(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Point size = new Point(400, 400, 0, 0);
			ArrayList<Point> arr = new ArrayList<Point>();
			for (int i = 0; i < N; i++) {
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				if (x1 > x2) {
					int temp = x1;
					x1 = x2;
					x2 = temp;
				}
				if (y1 > y2) {
					int temp = y1;
					y1 = y2;
					y2 = temp;
				}
				Point p = new Point(x1, y1, x2, y2);
				arr.add(p);
				size.x1 = Math.min(size.x1, p.x1);
				size.y1 = Math.min(size.y1, p.y1);
				size.x2 = Math.max(size.x2, p.x2);
				size.y2 = Math.max(size.y2, p.y2);
			}

			int maxsize = 300;
			int cnt = 1;
			int result = maxsize;
			while (maxsize >= 1) {
				for (int i = 0; i < cnt; i++) {
					for (int j = 0; j < cnt; j++) {
						int count = 0;
						for (int k = 0; k < arr.size(); k++) {
							Point p = arr.get(k);
							if (p.x1 >= i && p.y1 >= j && p.x2 <= i + maxsize && p.y2 <= j + maxsize) {
								count++;
							}
						}
						if (N - count <= M) {
							result = maxsize;
						}
					}
				}
				cnt++;
				maxsize--;
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
/*
 * 1 50 19 193 32 227 173 271 237 90 151 264 127 151 300 100 148 183 195 149 157
 * 283 297 258 291 42 205 260 275 262 119 281 268 294 93 32 291 23 295 135 252 6
 * 249 5 256 83 162 58 280 295 198 126 75 153 85 167 147 169 70 300 200 152 161
 * 175 277 231 276 195 233 108 14 265 193 172 232 176 127 26 57 281 235 223 124
 * 9 111 251 9 238 136 161 219 101 49 80 234 155 143 285 212 142 223 58 283 264
 * 300 217 211 94 271 27 128 191 145 169 258 147 94 196 235 139 262 117 279 264
 * 205 230 296 170 170 258 18 259 218 245 262 287 136 283 1 96 240 154 237 269
 * 278 275 247 297 218 293 169 236 110 286 117 19 300 174 133 258 298 285 235
 * 162 300 229 13 42 231 268 195 288 131 258 101 282 211 280 151 279 145 271 147
 * 273 274 191 299 179 142 48 271 49 294 22 257 132 187 75 184 159 249 163 147
 * 
 * 
 */
