import java.util.*;
public class Next_Small_Palindrome {
	public static int next(int n) {
		List<Integer> list = new ArrayList<Integer> ();
		while(n != 0) {
			list.add(0, n % 10);
			n /= 10;
		}
		int left = list.size() / 2 - 1;
		int right = list.size() % 2 == 0? list.size() / 2 : list.size() / 2 + 1;
		while(left >= 0 && right < list.size() && list.get(left) == list.get(right)) {
			left--;
			right++;
		}
		left = list.size() / 2 - 1;
		if(left < 0) {
			if(list.size() % 2 == 1 && list.get(left + 1) < 9) {
				list.set(left + 1, list.get(left + 1) + 1);
			}
			else {
				if(list.size() % 2 == 1) {
					list.set(left + 1, 0);
				}
		        int carry = (list.get(left) + 1) / 10;
			    list.set(left, (list.get(left) + 1) % 10);
			    left--;
			    while(left >= 0) {
			    	carry = (carry + list.get(left)) / 10;
			    	list.set(left, (list.get(left) + carry) % 10);
			    	left--;
			    }
			    if(carry > 0) {
			    	list.add(0, carry);
			    }
			    left = list.size() / 2 - 1;
			    right = list.size() % 2 == 0? list.size() / 2 : list.size() / 2 + 1;
			    while(left >= 0) {
			    	list.set(right, list.get(left));
			    	left--;
			    	right++;
			    }
			}
		}
		else {
			if(list.get(left) < list.get(right)) {
				list.set(left, list.get(right));
			}
			else if(list.get(left) == list.get(right)) {
				
			}
			else {
				list.set(right, list.get(left));
			}
			left--;
			right++;
			while(left >= 0 && right < list.size()) {
				if(list.get(left) != list.get(right)) {
					list.set(right, list.get(left));
				}
				left--;
				right++;
			}
		}
		int res = 0;
		for(int i = 0; i < list.size(); i++) {
			res *= 10;
			res += list.get(i);
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(next(999));
		System.out.println(next(1234));
		System.out.println(next(1221));
		System.out.println(next(12921));
		System.out.println(next(713322));;
	}
}