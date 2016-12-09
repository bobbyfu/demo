package com.example;

/**
 * Created by bfu on 12/8/16.
 */
public class Node<T> {
    private Node leftNode;
    private Node rightNode;
    T value;

    public Node(T value) {
        this(null, value, null);
    }

    public Node(Node<T> left, T value, Node<T> right) {
        this.leftNode = left;
        this.value = value;
        this.rightNode = right;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    StringBuilder builder;
    public String unparseV1() {
        builder = new StringBuilder();
        traversalV1(this);
        return builder.toString();
    }

    public String unparseV2() {
        builder = new StringBuilder();
        traversalV2(this);
        return builder.toString();
    }

    private void traversalV1(Node root) {
        if (root != null) {
            traversalV1(root.getLeftNode());
            builder.append(root.getValue());
            traversalV1(root.getRightNode());
        }
    }

    private boolean printLeftParam;
    private boolean printRightParam;
    private void traversalV2(Node root) {
        if (root != null) {

            if (root.getValue() == "+" || root.getValue() == "-")
                printLeftParam = true;

            traversalV2(root.getLeftNode());

            if (printLeftParam) {
                builder.append("(");
                printLeftParam = false;
            }

            if (root.getValue() == "+" || root.getValue() == "-")
                printRightParam = true;

            // inorder node
            builder.append(root.getValue());

            traversalV2(root.getRightNode());

            if (printRightParam) {
                builder.append(")");
                printRightParam = false;
            }
        }
    }

    // Version 3 - improvement
    public String unparseV3() {
        if (this.getLeftNode() == null) {
            return (String) this.getValue();
        } else {
            return "(" + this.getLeftNode().unparseV3() + this.getValue() + this.getRightNode().unparseV3() + ")";
        }

    }

    // Version 4 - one line
    public String unparseV4() {
        return (this.getLeftNode() == null)
                ? (String) this.getValue()
                : "(" + this.getLeftNode().unparseV3() + this.getValue() + this.getRightNode().unparseV3() + ")";
    }

    // Version 5 - one line; call V3 function, recursively.
    public String unparseV5() {
        return (this.getLeftNode() == null)
                ? (String) this.getValue()
                : this.getLeftNode().unparseV3() + this.getValue() + this.getRightNode().unparseV3();

    }
}
