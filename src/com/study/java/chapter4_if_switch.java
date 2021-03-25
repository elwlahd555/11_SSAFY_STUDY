package com.study.java;

import java.util.Scanner;

public class chapter4_if_switch {
	public static void main(String[] args) {
		String a= "true";
		int num=10;
		char c='T';
		
		if(a.equals("true")) {
			System.out.println("true입니다.");
		}else if(a.equals("false")) {
			System.out.println("false입니다.");
		}else {
			System.out.println("둘다 아닙니다.");
		}
		if(num>10) {
			System.out.println("10보다 큽니다.");
		}else if(num==10) {
			System.out.println("10과 같습니다.");
		}else {
			System.out.println("10보다 작습니다.");
		}
		if(c>'A'&&c<'Z') {
			System.out.println("A와 Z사이에 있습니다.");
		}else {
			System.out.println("A와 Z사이에 없습니다.");
		}
		
		Scanner sc= new Scanner(System.in);
		int number=sc.nextInt();
		switch(number) {
		case 0:
			System.out.println(number+"이 입력됬습니다.");
			break;
		case 1:
			System.out.println("케이스 1");
			System.out.println(number+"이 입력됬습니다.");
		case 2:
			System.out.println("케이스 2");
			System.out.println(number+"이 입력됬습니다.");
		case 3:
			System.out.println("케이스 3");
			System.out.println(number+"이 입력됬습니다.");
			break;
		case 4:
			System.out.println("케이스 4");
			System.out.println(number+"이 입력됬습니다.");
			break;
		default:
			System.out.println("예외처리");
			System.out.println("해당하는 값이 없을 경우");
			break;
		}
	}
}
