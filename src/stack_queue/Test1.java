package stack_queue;

public class Test1 {
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		int[] prices = {1,2,3,2,3};
		int[] sol = t1.solution(prices);
		
		for(int s : sol) {
			System.out.print(s+" ");
		}
	}
	
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		int cnt = 0;
		for(int i=0;i<prices.length;i++) {
			for(int j=i+1;j<prices.length;j++) {
				cnt++;
				if(prices[i] > prices[j]) break;
			}
			answer[i] = cnt;
			cnt = 0;
		}
		
		return answer;
	}
}