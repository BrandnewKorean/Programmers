package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test4 {
	class Pair{
		int values;
		int index;
		
		Pair(int values, int index){
			this.values = values;
			this.index = index;
		}
	}
	
	class keyPair{
		String key;
		int sum;
		
		keyPair(String key, int sum){
			this.key = key;
			this.sum = sum;
		}
	}
	
	public static void main(String[] args) {
		Test4 t4 = new Test4();
		String[] genres = {"classic","pop","classic","classic","pop"};
		int[] plays = {500, 600, 501, 800, 900};
		
		int[] solution = t4.solution(genres,plays);
		for(int s : solution) {
			System.out.print(s+" ");
		}
	}
	
	public int[] solution(String[] genres, int[] plays) {
		Map<String,ArrayList<Pair>> list = new HashMap<>();
		
		for(int i=0;i<genres.length;i++) {
			if(list.get(genres[i]) != null) {
				list.get(genres[i]).add(new Pair(plays[i],i));
			}else {
				list.put(genres[i],new ArrayList<Pair>());
				list.get(genres[i]).add(new Pair(plays[i],i));
			}
		}
		
		Set<String> keyset = list.keySet();
		Iterator<String> keyiter = keyset.iterator();
		
		ArrayList<keyPair> keylist = new ArrayList<>();
		DescPair descpair = new DescPair();
		
		for(int i=0;i<keyset.size();i++) {
			String key = keyiter.next();
			Collections.sort(list.get(key), descpair);
		}
		
		Iterator<String> keyiter2 = keyset.iterator();
		for(int i=0;i<keyset.size();i++) {
			String key = keyiter2.next();
			int sum = 0;
			for(int j=0;j<list.get(key).size();j++) {
				sum += list.get(key).get(j).values;
			}
			
			keylist.add(new keyPair(key,sum));
		}
		DesckeyPair desckeypair = new DesckeyPair();
		Collections.sort(keylist, desckeypair);
				
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for(int i=0;i<keylist.size();i++) {
			for(int j=0;j<(list.get(keylist.get(i).key).size() >= 2 ? 2 : 1);j++) {
				ans.add(list.get(keylist.get(i).key).get(j).index);
			}
		}
		
		int[] answer = new int[ans.size()];
		
		for(int i=0;i<ans.size();i++) {
			answer[i] = ans.get(i);
		}
		
		return answer;
    }
	
	class DescPair implements Comparator<Pair>{

		@Override
		public int compare(Pair o1, Pair o2) {
			Integer a = o1.values;
			Integer b = o2.values;
			if(a != b)	return b.compareTo(a);
			else {
				Integer c = o1.index;
				Integer d = o2.index;
				
				return c.compareTo(d);
			}
		}
	}
	
	class DesckeyPair implements Comparator<keyPair>{

		@Override
		public int compare(keyPair o1, keyPair o2) {
			Integer a = o1.sum;
			Integer b = o2.sum;
			return b.compareTo(a);
		}
	}
}
