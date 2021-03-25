package com.test.line;

import java.util.ArrayList;
import java.util.LinkedList;

public class 프로그래밍3 {
	public static void main(String[] args) {
		int[] enter= {1,3,2};
		int[] leave= {1,2,3};
        int[] answer = {};
        ArrayList<Integer> leavelist=new ArrayList<Integer>();
        LinkedList<Integer> answerlist=new LinkedList<Integer>();
        int enternum=0;
        int leavenum=0;
        while(true) {
        	answerlist.add(enter[enternum]);
        	if(leave[leavenum]==enter[enternum]) {
        		answerlist.poll();
        		leavenum++;
        	}
        	enternum++;
        }
	}

}
