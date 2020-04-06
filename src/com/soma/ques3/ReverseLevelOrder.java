package com.soma.ques3;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrder {

	private static Node generateTree() {
		Node root = new Node("A");

		root.set_left(new Node("B"));
		root.set_right(new Node("E"));

		root.get_left().set_left(new Node("C"));
		root.get_left().set_right(new Node("D"));

		root.get_right().set_left(new Node("F"));
		root.get_right().set_right(new Node("G"));

		root.get_right().get_right().set_right(new Node("H"));

		return root;
	}

	private static String getReverseLevelOrder(Node root) {
		
		String order = "";
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		Node currentNode = null;
		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			if(order.equals(""))
				order = currentNode.get_value();
			else
				order = currentNode.get_value() + "\n" + order;
			
			if(currentNode.get_left() != null)
				queue.offer(currentNode.get_left());
			
			if(currentNode.get_right() != null)
				queue.offer(currentNode.get_right());
		}
		
		return order;
	}

	public static void main(String[] args) {

		Node root = generateTree();
		System.out.println(getReverseLevelOrder(root));
	}

}
