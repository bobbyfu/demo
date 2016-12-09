package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		// 2 * ( 3 + 4)
		System.out.println(create1().unparseV1());
		System.out.println(create1().unparseV2());
		System.out.println(create1().unparseV3());
		System.out.println(create1().unparseV4());
		System.out.println(create1().unparseV5());
//		unparseV1(create1());
//		System.out.println();
//		unparseV2(create1());
//		System.out.println();

		// (1 + 2) * (3 - 4)
		System.out.println(create2().unparseV1());
		System.out.println(create2().unparseV2());
		System.out.println(create2().unparseV3());
		System.out.println(create2().unparseV4());
		System.out.println(create2().unparseV5());

//		unparseV1(create2());
//		System.out.println();
//		unparseV2(create2());
//		System.out.println();

		//SpringApplication.run(DemoApplication.class, args);
	}

	public static void unparseV1(Node<String> root) {
		if (root != null) {
			unparseV1(root.getLeftNode());
			System.out.print(root.getValue());
			unparseV1(root.getRightNode());
		}
	}

	public static boolean left;
	public static boolean right;
	public static void unparseV2(Node<String> root) {
		if (root != null) {

			if (root.getValue() == "+" || root.getValue() == "-")
				left = true;

			unparseV2(root.getLeftNode());

			if (left) {
				System.out.print("(");
				left = false;
			}

			if (root.getValue() == "+" || root.getValue() == "-")
				right = true;

			// inorder node
			System.out.print(root.getValue());

			unparseV2(root.getRightNode());

			if (right) {
				System.out.print(")");
				right = false;
			}
		}
	}

	// 2 * ( 3 + 4)
	private static Node<String> create1() {

		Node<String> n2 = new Node<String>("2");
		Node<String> n3 = new Node<String>("3");
		Node<String> n4 = new Node<String>("4");
		Node<String> add = new Node<String>(n3, "+", n4);
		return new Node<String>(n2, "*", add);
	}

	// (1 + 2) * (3 - 4)
	private static Node<String> create2() {

		Node<String> n1 = new Node<String>("1");
		Node<String> n2 = new Node<String>("2");
		Node<String> n3 = new Node<String>("3");
		Node<String> n4 = new Node<String>("4");
		Node<String> add = new Node<String>(n1, "+", n2);
		Node<String> sub = new Node<String>(n3, "-", n4);
		return new Node<String>(add, "*", sub);
	}
}