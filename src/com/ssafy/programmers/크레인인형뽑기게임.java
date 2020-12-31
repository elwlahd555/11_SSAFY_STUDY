package com.ssafy.programmers;

import java.util.LinkedList;

public class 크레인인형뽑기게임 {
	public static void main(String[] args) {
		int [][]board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		int answer=0;
		
		LinkedList<Integer> stack=new LinkedList<Integer>();
		
		
		for (int i = 0; i < moves.length; i++) {
			int temp=0;
			if(!stack.isEmpty()) {
				temp=stack.getLast();
			}
			for (int j = 0; j < board.length; j++) {
				if(board[j][moves[i]-1]!=0) {
					stack.add(board[j][moves[i]-1]);
					board[j][moves[i]-1]=0;
					break;
				}
			}
			if(!stack.isEmpty()&&temp==stack.getLast()) {
				stack.pollLast();
				stack.pollLast();
				answer+=2;
			}
		}
		System.out.println(answer);
	}
}
