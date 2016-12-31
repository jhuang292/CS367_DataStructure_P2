
///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  MessageLoopEditor.java
// File:             LinkedLoop.java
// Semester:         (CS367) Summer 2016
//
// Author:           Junxiong Huang/ jhuang292@wisc.edu
// CS Login:         junxiong
// Lecturer's Name:  Amanda Strominger
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     Kathleen Jackie Roush
// Email:            kroush@wisc.edu
// CS Login:         kathleen
// Lecturer's Name:  Amanda Strominger
//
////////////////////////////////////////////////////////////////////////////////
import java.util.*;

public class LinkedLoop<E> implements Loop<E> {

	/**
	 * Linked Loop implementation uses a doubly-linked chain of nodes
	 */
	private DblListnode<E> currNode;
	private int numItems;

	/**
	 * The LinkedLoop Constructor creates an empty loop
	 */
	public LinkedLoop() {
		currNode = null;
		numItems = 0;
	}

	/**
	 * Returns the current item. If the Loop is empty, an
	 * <tt>EmptyLoopException</tt> is thrown.
	 * 
	 * @return the current item
	 */
	public E getCurrent() {
		if (numItems == 0) {
			throw new EmptyLoopException();
		}

		return currNode.getData();
	}

	/**
	 * Adds the given <tt>item</tt> immediately <em>before</em> the current
	 * item. After the new item has been added, the new item becomes the current
	 * item.
	 * 
	 * @param item
	 *            the item to add
	 */
	public void insert(E item) {
		if (currNode == null) {
			currNode = new DblListnode<E>(item);

			currNode.setNext(currNode);
			currNode.setPrev(currNode);
		} else {
			DblListnode<E> newNode = new DblListnode<E>(item);

			newNode.setNext(currNode);
			newNode.setPrev(currNode.getPrev());
			currNode.getPrev().setNext(newNode);
			currNode.setPrev(newNode);

			currNode = newNode;
		}
		numItems++;
	}

	/**
	 * Removes and returns the current item. The item immediately <em>after</em>
	 * the removed item then becomes the current item. If the Loop is empty
	 * initially, an <tt>EmptyLoopException</tt> is thrown.
	 * 
	 * @return the removed item
	 * @throws EmptyLoopException
	 *             if the Loop is empty
	 */
	public E removeCurrent() {
		if (numItems == 0) {
			throw new EmptyLoopException();
		}

		DblListnode<E> removeNode = currNode;
		if (numItems == 1) {
			currNode = null;
		} else {
			currNode = removeNode.getNext();
			currNode.setPrev(removeNode.getPrev());
			removeNode.getPrev().setNext(currNode);
		}
		numItems--;
		return removeNode.getData();
	}

	/**
	 * Advances the current item forward one item resulting in the item that is
	 * immediately <em>after</em> the current item becoming the current item. If
	 * the Loop is empty initially, an <tt>EmptyLoopException</tt> is thrown.
	 *
	 * @throws EmptyLoopException
	 *             if the Loop is empty
	 */
	public void forward() {
		if (numItems == 0) {
			throw new EmptyLoopException();
		}

		currNode = currNode.getNext();
	}

	/**
	 * Moves the current item backward one item resulting in the item that is
	 * immediately <em>before</em> the current item becoming the current item.
	 * If the Loop is empty initially, an <tt>EmptyLoopException</tt> is thrown.
	 *
	 * @throws EmptyLoopException
	 *             if the Loop is empty
	 */
	public void backward() {
		if (numItems == 0) {
			throw new EmptyLoopException();
		}

		currNode = currNode.getPrev();
	}

	/**
	 * Returns the number of items in this Loop.
	 * 
	 * @return the number of items in this Loop
	 */
	public int size() {
		return numItems;
	}

	/**
	 * Returns true if this Loop is empty and false otherwise.
	 * 
	 * @return true if this Loop is empty; false otherwise.
	 **/
	public boolean isEmpty() {
		if (numItems == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns an iterator for this Loop.
	 * 
	 * @return an iterator for this Loop
	 */
	public Iterator<E> iterator() {
		return new LinkedLoopIterator<E>(currNode, numItems);
	}

}
