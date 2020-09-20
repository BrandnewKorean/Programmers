package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Test3 {
	class truck{
		int weight;
		int time;
		
		truck(int weight, int time){
			this.weight = weight;
			this.time = time;
		}
	}
	public static void main(String[] args) {
		Test3 t3 = new Test3();
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};
		
		System.out.println(t3.solution(bridge_length, weight, truck_weights));
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		int onbridge = 0;
		
		Queue<truck> bridge = new LinkedList<>();
		
		int t = 0;
		
		if(t < truck_weights.length) {
			onbridge += truck_weights[t];
			bridge.add(new truck(truck_weights[t],0));
			t++;
		}
		
		while(!bridge.isEmpty()) {
			time++;
			
			if(t < truck_weights.length) {
				if(bridge.isEmpty() || (onbridge + truck_weights[t]) <= weight) {
					onbridge += truck_weights[t];
					bridge.add(new truck(truck_weights[t],0));
					t++;
				}
			}
			
			if(bridge.peek().time >= bridge_length) {
				onbridge -= bridge.peek().weight;
				bridge.poll();
				if(t < truck_weights.length) {
					if(bridge.isEmpty() || (onbridge + truck_weights[t]) <= weight) {
						onbridge += truck_weights[t];
						bridge.add(new truck(truck_weights[t],0));
						t++;
					}
				}
			}
			
			for(int i=0;i<bridge.size();i++) {
				truck temp = bridge.poll();
				temp.time++;
				bridge.add(temp);
			}
		}
		
		return time;
    }
}
