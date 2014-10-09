/*
 * The goal here is to assign each letter a digit from 0 to 9 so that the arithmetic works out correctly. The rules are that all occurrences of a letter must be assigned the same digit, and no digit can be assigned to more than one letter.
 */
import java.util.*;
public class crypuzzel {
	public static boolean puzzel(String s1, String s2, String s3) {
		Map<Character, Integer> map = new HashMap<Character, Integer> ();
		for(int i = 0; i < s1.length(); i++) {
			map.put(s1.charAt(i), -1);
		}
		for(int i = 0; i < s2.length(); i++) {
			map.put(s2.charAt(i), -1);
		}
		for(int i = 0; i < s3.length(); i++) {
			map.put(s3.charAt(i), -1);
		}
		if(puzzel(s1, s2, s3, new boolean[10], 0, map, map.keySet().toArray(new Character[map.keySet().size()]))) {
			for(Character c : map.keySet()) {
				System.out.print(c + " " + map.get(c) + " ");
			}
			System.out.println();
			return true;
		}
		return false;
	}
	public static boolean puzzel(String s1, String s2, String s3, boolean[] mark, int index, Map<Character, Integer> map, Character[] keys) {
		if(index == keys.length) {
			if(valid(s1, s2, s3, map)) {
				return true;
			}
			return false;
		}
		for(int i = 0; i < mark.length; i++) {
			if(!mark[i]) {
				mark[i] = true;
				map.put(keys[index], i);
				if(puzzel(s1, s2, s3, mark, index+1, map, keys)) {
					return true;
				}
				mark[i] = false;
			}
		}
		return false;
	}
	public static boolean valid(String s1, String s2, String s3, Map<Character, Integer> map) {
		int carry = 0;
		for(int i = 0; i < s3.length(); i++) {
			int num1 = s1.length() - 1 - i >= 0? map.get(s1.charAt(s1.length() - 1 - i)) : 0;
			int num2 = s2.length() - 1 - i >= 0? map.get(s2.charAt(s2.length() - 1 - i)) : 0;
			int num3 = map.get(s3.charAt(s3.length() - 1 - i));
			if(num3 != num1 + num2 + carry) {
				return false;
			}
			carry = (num1 + num2) / 10;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(puzzel("BASE", "BALL", "GAMES"));
	}
}
