package dfs_bfs;

import java.util.Stack;

public class Test1 {
	
	class test{
		int current;
		int depth;
		
		test(int current, int depth){
			this.current = current;
			this.depth = depth;
		}
	}
	
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		System.out.println(t1.solution(numbers,target));
	}
	
	
	public int solution(int[] numbers, int target) {
		int answer = 0;
		Stack<test> stack = new Stack<>();
		stack.push(new test(numbers[0],0));
		stack.push(new test(-numbers[0],0));
		
		while(!stack.isEmpty()) {
			test t = stack.pop();
			
			if(t.depth == numbers.length-1) {
				if(t.current == target) {
					answer += 1;
				}
				continue;
			}
			
			int c1 = t.current + numbers[t.depth+1];
			int c2 = t.current - numbers[t.depth+1];
			
			stack.push(new test(c1,t.depth+1));
			stack.push(new test(c2,t.depth+1));
		}
		
		return answer;
    }
}
