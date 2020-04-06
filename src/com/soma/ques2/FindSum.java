package com.soma.ques2;

import java.util.ArrayList;
import java.util.List;

public class FindSum {

	public static void findSubArrayUsingSubset(int[] array, int sum) {
		int n = array.length;

		int currentSum = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < (1 << n); i++) {
			// sub array start
			
			for (int j = 0; j < n; j++)
				if ((i & (1 << j)) > 0) {
					list.add(array[j]);
					currentSum += array[j];
				}

			// sub array end
			if(currentSum == sum) {
				System.out.println(list);
				return;
			}
			list.clear();
			currentSum = 0;
		}
	}

	public static void main(String[] args) {
		findSubArrayUsingSubset(new int[] { 10, 0, -1, 20, 25, 30 }, 45);
		System.out.println();
		findSubArrayUsingSubset(new int[] { 10, 0, -1, 20, 25, 30 }, 59);
		System.out.println();
		findSubArrayUsingSubset(new int[] { 10, 0, -1, 20, 25, 30 }, 60);
	}

}
