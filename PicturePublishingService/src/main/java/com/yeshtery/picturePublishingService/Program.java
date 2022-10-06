package com.yeshtery.picturePublishingService;

import java.util.Arrays;

public class Program {
	public static void main(String[] args) {
		int[] nums = { 20, 19, 5, 7, 3, 9, 2 };
		Program prog = new Program();
		prog.nonNegative(nums);
	}

	public int nonNegative(int[] nums) {
		if (nums.length < 2) {
			return -1;
		}
		Arrays.sort(nums);

		System.out.println(nums[nums.length - 2]);

		return nums[nums.length - 2];
	}

	int f(int[] a) {
		int X = 0, Y = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				Y += a[i];
			} else if (a[i] % 2 != 0) {
				X += a[i];
			}
		}

		return X - Y;
	}

	char[] f(char[] a, int start, int len) {
		try {
			char[] b = {};
			if (start < 0) {
				return null;
			}
			for (int i = start; i < len; i++) {
				b[i] = a[i];
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}
}
