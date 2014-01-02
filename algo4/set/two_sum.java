package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class two_sum {
	public static class Pair {
		final int first;
		final int second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	public static int[] twoSumUsingSort(int[] numbers, int target) {
		assert numbers.length > 0;
	
		ArrayList<Pair> pairList = new ArrayList<Pair>(numbers.length);
		for (int i = 0; i < numbers.length; i++) {
			pairList.add(new Pair(numbers[i], i + 1));
		}
		Collections.sort(pairList, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.first < o2.first) {
					return -1;
				} else if (o1.first == o2.first) {
					return 0;
				} else {
					return 1;
				}
			}
		});

		int l = 0;
		int r = numbers.length - 1;
		while (l <= r) {
			int sum = pairList.get(l).first + pairList.get(r).first;
			if (sum == target) {
				int[] result = new int[2];
				result[0] = pairList.get(l).second;
				result[1] = pairList.get(r).second;
				return result;
			} else if (sum < target){
				l++;
			} else {
				r--;
			}
		}
		return null;
	}
	
	/**
	 * Contract: we will have exactly one answer; return value should never
	 * be {@code null}.
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] numbers, int target) {
		assert numbers.length > 0;

		HashMap<Integer, Integer> targetMap  = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; ++i) {
			targetMap.put(numbers[i], i + 1);
		}

		for (int i = 0; i < numbers.length; ++i) {
			if (targetMap.containsKey(target - numbers[i])) {
				int[] result = new int[2];
				result[0] = i + 1;
				result[1] = targetMap.get(target - numbers[i]);
				return result;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int []numbers = {2, 7, 11, 15};
		int []result = twoSumUsingSort(numbers, 9);
		System.out.println(result[0] + " and " + result[1]);
	}
}
