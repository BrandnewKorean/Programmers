package hash;

import java.util.HashSet;

public class Test2 {
	public static void main(String[] args) {
		Test2 t2 = new Test2();
		String[] phone_book = {"119","97674223","1195524421"};
		System.out.println(t2.solution(phone_book));
	}
	
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		int i = 0;
		while(answer && i < phone_book.length) {
			HashSet<String> book = new HashSet<>();
			String pivot = phone_book[i];
			book.add(pivot);
			
			for(int j=0;j<phone_book.length;j++) {
				if(phone_book[j].length() >= pivot.length()) {
					if(!phone_book[j].substring(0,pivot.length()).equals(pivot)) {
						book.add(phone_book[j]);
					}
				}else {
					book.add(phone_book[j]);
				}
			}
			
			if(book.size() != phone_book.length) {
				answer = false;
			}
			i++;
		}
		
		return answer;
	}
}
