package avltree;

public class AVLNode<T extends Comparable<T>> {
	private T data;
	private AVLNode<T> parent;
	private AVLNode<T> left;
	private AVLNode<T> right;

	public AVLNode(T data) {
		this.data = data;
		this.parent = null;
		this.left = null;
		this.right = null;
	}

	public AVLNode(T data, AVLNode<T> left, AVLNode<T> right, AVLNode<T> parent) {
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	public T getData() {return data;}

	public AVLNode<T> getLeftChild() {return left;}

	public AVLNode<T> getRightChild() {return right;}

	public AVLNode<T> getParent() {return parent;}

	public void setData(T data) {this.data = data;}

	public void setLeftChild(AVLNode<T> leftChild) {this.left = leftChild;}

	public void setRightChild(AVLNode<T> rightChild) {this.right = rightChild;}

	public void setParent(AVLNode<T> parent) {this.parent = parent;}
	
	public boolean isLeaf() {
		return (getLeftChild() == null && getRightChild() == null);
	}

	public boolean isRoot() {
		return (getParent() == null);
	}

}
