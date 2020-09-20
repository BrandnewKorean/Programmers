package hash;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		System.out.println(t1.solution(participant,completion));
	}
	
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		
		Map<String, Integer> part = new HashMap<>();
		
		for(int i=0;i<participant.length;i++) {
			if(part.get(participant[i]) == null) {
				part.put(participant[i], 0);
			}else {
				part.put(participant[i], part.get(participant[i])+1);
			}
		}
				
		for(int i=0;i<completion.length;i++) {
			part.put(completion[i], part.get(completion[i])-1);
		}
				
		for(int i=0;i<participant.length;i++) {
			if(part.get(participant[i]) == 0) answer = participant[i];
		}
		
        return answer;
    }
}
