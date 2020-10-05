package com.basicsstrong.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

class Node
{
	int data;
	Node left = null, right = null;

	Node(int data) {
		this.data = data;
	}
}

public class BinarySubtree {


		public static void main(String[] args) {

		/*
		 * 			1 
		 * 		   / \ 
		 * 		  2   3 
		 * 		 / \ / \ 
		 * 		4  5 6  7
		 */
		
		//that's the tree, that we are constructing here.
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		/*
		 * 			4 
		 * 		   / \ 
		 * 		  5   6 
		 */
		Node root2 = new Node(4);
		root2.left = new Node(5);
		root2.right = new Node(6);

		System.out.println(checkSubtree(root,root.left));	//true
		System.out.println(checkSubtree(root,root2));	//false
		
	}
	
	// Function to store in-order traversal of the tree in a list
	public static void inorder(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}
		inorder(node.left, list);
		list.add(node.data);
		inorder(node.right, list);
	}

	// Function to store pre-order traversal of the tree in a list
	public static void preorder(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}
		list.add(node.data);
		preorder(node.left, list);
		preorder(node.right, list);
	}

	//Create a function to check if given tree is subtree or not: 
	//as arguments, we'll pass given two trees.
	public static boolean checkSubtree(Node tree, Node sub) {

		//the case if tree sub is null, return true as subtree may be empty
		if (sub == null)
			return true;
		
		//and if tree is null, sub cannot be subtree of it - so return false
		if (tree == null)
			return false;

		//now we store in-order traversal of both trees in first and second respectively
		List<Integer> first = new ArrayList<>();
		inorder(tree, first);

		List<Integer> second = new ArrayList<>();
		inorder(sub, second);	
		
		//Now we return false if second list is not a sub-list of first list
		if(!listToString(first).contains(listToString(second)))
			return false;

		//otherwise we continue to check whether preOrder traversal of subtree is also subset of preOrder of tree
		
		//removing data from these lists.
		first.clear();
		second.clear();
		
		//and storing preOrder traversal into them
		preorder(tree, first);
		preorder(sub, second);
		
		//at last we return the result, that will be true if first contains second else false.
		return (listToString(first).contains(listToString(second)));
	}

	//utility method to convert list to string, by using list.toString and replacing brackets and commas
	private static String listToString(List<Integer> list) {
		return list.toString().replace("[", "").replace("]", "").replace(",", "");
	}
	
}

