package com.soma.ques3;

public class Node {
	private String _value;
	private Node _left;
	private Node _right;

	public Node() {
		super();
	}

	public Node(String _value) {
		super();
		this._value = _value;
	}

	public String get_value() {
		return _value;
	}

	public void set_value(String _value) {
		this._value = _value;
	}

	public Node get_left() {
		return _left;
	}

	public void set_left(Node _left) {
		this._left = _left;
	}

	public Node get_right() {
		return _right;
	}

	public void set_right(Node _right) {
		this._right = _right;
	}

}
