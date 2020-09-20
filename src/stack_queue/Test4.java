package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Test4 {
	class Document{
		int priorities;
		int location;
		
		Document(int priorities, int location){
			this.priorities = priorities;
			this.location = location;
		}
	}
	public static void main(String[] args) {
		Test4 t4 = new Test4();
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		
		System.out.println(t4.solution(priorities, location));
	}
	
	public int solution(int[] priorities, int location) {
		Queue<Document> printer = new LinkedList<>();
		int answer = 0;
		
		for(int i=0;i<priorities.length;i++) {
			printer.add(new Document(priorities[i],i));
		}
		
		Document printed = new Document(-1,-1);
		
		while(printed.location != location) {
			Document j = printer.poll();
			
			if(isfirst(j, printer)) {
				printed = j;
				answer++;
			}else {
				printer.add(j);
			}
		}
		
		return answer;
	}
	
	public static boolean isfirst(Document p, Queue<Document> e) {
		int size = e.size();
		boolean isf = true;
		
		for(int i=0;i<size;i++) {
			Document temp = e.poll();
			e.add(temp);
			if(p.priorities < temp.priorities) {
				isf = false;
			}
		}
		return isf;
	}
}
