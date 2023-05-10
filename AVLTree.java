package avltree;

import java.util.*;

public class AVLTree<T extends Comparable<T>> {
	private AVLNode<T> root;
	private int size, height;
	/**
	 * creates an empty AVL tree
	 */
	public AVLTree() {
		root = null;
		height = 0;
	}
	/**
	 * returns a node containing item in the AVL tree
	 * if item is not in the tree, throws NoSuchElementException
	 */
	public AVLNode<T> find(T item) {return find(item, getRoot());}

	public AVLNode<T> find(T item, AVLNode<T> node) {
		if(node.getData() == item)
			return node;
		find(item, node.getLeftChild());
		find(item, node.getRightChild());
		return null;
	}
	/**
	 * adds a new item to the AVL tree
	 * duplicates are allowed
	 */
	public AVLNode<T> insert(T item) {
		if(getRoot() == null) {
			size++;
			height = 1;
			return root = new AVLNode<>(item);
		}
		AVLNode<T> node = insert(item, getRoot());
		balance(node);
		this.size++;
		this.updateHeight();
		return node;
	}

	public void balance(AVLNode<T> node) {
		if (node == null)
			return;
		int balanceFactor = getBalanceFactor(node);
		if (balanceFactor == 2) {
			if (getBalanceFactor(node.getLeftChild()) < 0)
				rotateLeft(node.getLeftChild());
			rotateRight(node);
		} else if (balanceFactor == -2) {
			if (getBalanceFactor(node.getRightChild()) > 0)
				rotateRight(node.getRightChild());
			rotateLeft(node);
		}
		balance(node.getParent());
	}

	private int getBalanceFactor(AVLNode<T> node) {
		if (node == null)
			return 0;
		return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
	}

	private void rotateLeft(AVLNode<T> node) {
		AVLNode<T> rightChild = node.getRightChild();
		node.setRightChild(rightChild.getLeftChild());
		if (rightChild.getLeftChild() != null)
			rightChild.getLeftChild().setParent(node);
		rightChild.setParent(node.getParent());
		if (node.getParent() == null)
			root = rightChild;
		else if (node == node.getParent().getLeftChild())
			node.getParent().setLeftChild(rightChild);
		else
			node.getParent().setRightChild(rightChild);
		rightChild.setLeftChild(node);
		node.setParent(rightChild);
	}

	private void rotateRight(AVLNode<T> node) {
		AVLNode<T> leftChild = node.getLeftChild();
		node.setLeftChild(leftChild.getRightChild());
		if (leftChild.getRightChild() != null)
			leftChild.getRightChild().setParent(node);
		leftChild.setParent(node.getParent());
		if (node.getParent() == null)
			root = leftChild;
		else if (node == node.getParent().getRightChild())
			node.getParent().setRightChild(leftChild);
		else
			node.getParent().setLeftChild(leftChild);
		leftChild.setRightChild(node);
		node.setParent(leftChild);
	}

	public AVLNode<T> insert(T item, AVLNode<T> node) {
		AVLNode<T> newNode = new AVLNode<T>(item);
		if (root == null)
			return newNode;
		AVLNode<T> currentNode = root;
		while (true)
			if (currentNode.getData().compareTo(item) > 0) {
				if (currentNode.getLeftChild() == null) {
					newNode.setParent(currentNode);
					currentNode.setLeftChild(newNode);
					break;
				}
				else
					currentNode = currentNode.getLeftChild();
			}
			else {
				if (currentNode.getRightChild() == null) {
					newNode.setParent(currentNode);
					currentNode.setRightChild(newNode);
					break;
				}
				else
					currentNode = currentNode.getRightChild();
			}
		return newNode;
	}

	/**
	 * remove item from the AVL tree
	 * if item is not in the tree, throws NoSuchElementException
	 */
	public void remove(T item) {
		// TODO implement me
	}

	/**
	 * returns the height of the tree in O(1) time
	 */
	public int height() {return this.height;}
	public int getHeight(AVLNode<T> node) {
		if (node == null)
			return -1;
		else
			return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
	}
	public void updateHeight() {this.height = getHeight(getRoot());}

	/**
	 * returns the size of the tree in O(1) time
	 */
	public int size() {return this.size;}

	/**
	 * returns the minimal element of the tree in O(1) time
	 */
	public T getMin() {
		// TODO implement me in O(1) time
		return null;
	}

	/**
	 * returns a collection of all elements in the tree for which
	 * element.compareTo(k) < 0
	 * If the list is empty, returns an empty list 
	 */
	public Collection<T> lessThanK(T k) {
		// TODO implement me
		return null;
	}

	public AVLNode<T> getRoot() {return root;}

	public void printPreOrder(AVLNode node){
		if(node == null)
			return;
		System.out.println(node.getData());
		printPreOrder(node.getLeftChild());
		printPreOrder(node.getRightChild());
	}
}
