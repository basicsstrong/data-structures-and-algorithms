package com.basicsstrong.algorithm.recursion;

public class StringSubsequence {

	public static void main(String[] args) {

		String word = "wxyzabc";

		String subsequence = getSubsequence(word);

		System.out.println(subsequence);

	}

	private static String getSubsequence(String word) {

		if (word.isEmpty()) {
			return "";
		}

		char first = word.charAt(0);
		String rest = getSubsequence(word.substring(1));

		String result = "";

		for (String subseq : rest.split(",", -1)) {

			result += "," + first + subseq;
			result += "," + subseq;

		}

		return result.substring(1);

	}

}
