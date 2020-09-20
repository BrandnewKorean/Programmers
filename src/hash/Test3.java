package hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test3 {
	public static void main(String[] args) {
		Test3 t3 = new Test3();
		String[][] clothes = {
			{"yellow_hat","face"},
			{"blue_sunglasses","face"},
			{"green_turban","headgear"},
			{"green_turban","headgear"},
			{"green_turban","headgear"},
			{"pants1","pants"},
			{"pants2","pants"},
			{"pants3","pants"},
		};
		
		System.out.println(t3.solution(clothes));
	}
	
	public int solution(String[][] clothes) {
		int answer = 1;
		Map<String,Integer> clothesMap = new HashMap<>();
		
		for(int i=0;i<clothes.length;i++) {
			if(clothesMap.get(clothes[i][1]) != null) {
				clothesMap.put(clothes[i][1],clothesMap.get(clothes[i][1])+1);
			}else {
				clothesMap.put(clothes[i][1],1);
			}
		}
		
		Set<String> keyset = clothesMap.keySet();
		Iterator<String> keyiter = keyset.iterator();
		
		for(int i=0;i<keyset.size();i++) {
			answer *= clothesMap.get(keyiter.next())+1;
		}
		
		answer -= 1;
		
		return answer;
    }
}