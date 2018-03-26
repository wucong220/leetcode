package DataStructure;

public class BiNode {
	private char value;
	private BiNode leftChild;
	private BiNode rightChild;

	public BiNode(char value, BiNode leftChild, BiNode rightChild) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public BiNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BiNode leftChild) {
		this.leftChild = leftChild;
	}

	public BiNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BiNode rightChild) {
		this.rightChild = rightChild;
	}
}
