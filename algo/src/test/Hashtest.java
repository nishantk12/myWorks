package test;

import java.util.HashMap;
import java.util.Map;

public class Hashtest {
	public static void main(String[] args) {
		Map<Integer,Integer> test = new HashMap<Integer,Integer>();
		test.put(1, 0);
		System.out.println(test.remove(2));
		System.out.println(test.get(2));
	}

}
