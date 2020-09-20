package stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test2 {
	public static void main(String[] args) {
		Test2 t2 = new Test2();
		int[] progresses = {95,90,99,99,80,99};
		int[] speeds = {1,1,1,1,1,1};
		int[] sol = t2.solution(progresses,speeds);
		
		for(int s : sol) {
			System.out.print(s+" ");
		}
	}
	
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int[] days = new int[progresses.length];
		
		for(int i=0;i<progresses.length;i++) {
			int temp = 100-progresses[i];
			if(temp / speeds[i] == 0) {
				if(temp < 0) days[i] = 0;
				else days[i] = 1;
			}else {
				if(temp % speeds[i] == 0) {
					days[i] = (temp/speeds[i]);
				}else {
					days[i] = (temp/speeds[i])+1;
				}
			}
		}
		
		for(int d : days) {
			System.out.print(d+" ");
			queue.add(d);
		}
		System.out.println();
		
		int cnt = 0;
		int temp = -1;
		ArrayList<Integer> ans = new ArrayList<>();
		while(!queue.isEmpty()) {
			if(temp == -1) {
				temp = queue.poll();
				System.out.println("temp = "+temp);
				cnt++;
				System.out.println("cnt = "+cnt);
			}else if(queue.peek() != null && temp >= queue.peek()) {
				cnt++;
				System.out.println("cnt = "+cnt);
				queue.poll();
			}else {
				System.out.println("ans add = "+cnt);
				ans.add(cnt);
				cnt = 0;
				temp = -1;
			}
		}
		System.out.println("ans add = "+cnt);
		ans.add(cnt);
		
		int[] answer = new int[ans.size()];
		for(int i=0;i<ans.size();i++) {
			answer[i] = ans.get(i);
		}
		
		return answer;
	}
}
