package com.basicsstrong.algorithm.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCode {


	static Map<Character, String> charBinaryMapping = new HashMap<>();

	public static void main(String[] args) {

		String str = "ABBCCCCGGGGDEAAAEDBBBDFAGG";

		String code = encode(str);

		System.out.println("Final coded String = " + code);

	}

	private static String encode(String str) {

		Map<Character, Integer> f = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {

			if (!f.containsKey(str.charAt(i))) {
				f.put(str.charAt(i), 0);
			}
			f.put(str.charAt(i), f.get(str.charAt(i)) + 1);
		}

		HuffmanNode root = generateTree(f);

		setBinaryCode(root, new StringBuilder());

		System.out.println("Binary Codes " + charBinaryMapping);

		StringBuilder s = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);
			s.append(charBinaryMapping.get(c));

		}

		return s.toString();
	}

	private static void setBinaryCode(HuffmanNode node, StringBuilder str) {

		if (node != null) {

			if (node.left == null && node.right == null) {
				charBinaryMapping.put(node.data, str.toString());
			}

			str.append('0');
			setBinaryCode(node.left, str);
			str.deleteCharAt(str.length() - 1);

			str.append('1');
			setBinaryCode(node.right, str);
			str.deleteCharAt(str.length() - 1);

		}
	}

	private static HuffmanNode generateTree(Map<Character, Integer> f) {

		PriorityQueue<HuffmanNode> priorityQ = new PriorityQueue<HuffmanNode>();

		Set<Character> keySet = f.keySet();

		for (Character character : keySet) {

			HuffmanNode node = new HuffmanNode();

			node.data = character;
			node.freq = f.get(character);
			node.left = null;
			node.right = null;

			priorityQ.add(node);

		}

		while (priorityQ.size() > 1) {

			HuffmanNode first = priorityQ.peek();
			priorityQ.poll();

			HuffmanNode second = priorityQ.peek();
			priorityQ.poll();

			HuffmanNode mergeNode = new HuffmanNode();

			mergeNode.left = first;
			mergeNode.right = second;
			mergeNode.freq = first.freq + second.freq;
			mergeNode.data = '-';
			priorityQ.add(mergeNode);
		}

		return priorityQ.poll();
	}
}

class HuffmanNode implements Comparable<HuffmanNode> {
	int freq;
	char data;
	HuffmanNode left, right;

	@Override
	public int compareTo(HuffmanNode o) {
		return freq - o.freq;
	}

}