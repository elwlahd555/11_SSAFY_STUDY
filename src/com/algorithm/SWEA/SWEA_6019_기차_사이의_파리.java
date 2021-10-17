package com.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6019_기차_사이의_파리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st=new StringTokenizer(br.readLine()," ");
			int D =Integer.parseInt(st.nextToken());
			double A =Double.parseDouble(st.nextToken());
			double B =Double.parseDouble(st.nextToken());
			double F =Double.parseDouble(st.nextToken());
			double mok=D/(A+B);
			double result=mok*F;
			System.out.println("#"+t+" "+result);
		}
	}
}
