
///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  MessageLoopEditor.java
// File:             LinkedLoopIterator.java
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

public class LinkedLoopIterator<E> implements Iterator<E> {

	/**
	 * listNode current doubly-linked node numItems number of nodes itrPos
	 * iterator position
	 */
	private DblListnode<E> listNode;
	private int numItems;
	private int itrPos;

	/**
	 * Package-access constructor that takes a DblListnode<E> as a parameter
	 * 
	 * @param listNode
	 *            current node in the doubly-linked loop
	 * @param numItems
	 *            number of nodes in the doubly-linked loop
	 */
	LinkedLoopIterator(DblListnode<E> listNode, int numItems) {
		this.listNode = listNode;
		this.numItems = numItems;
	}

	/**
	 * Determine whether we have more nodes to iterate
	 * 
	 * @return true if there are more, false if there is no more
	 */
	public boolean hasNext() {
		return this.itrPos < this.numItems;
	}

	/**
	 * return the data of the node and move the iterator
	 * 
	 * @return the data of the next node
	 */
	public E next() {

		E data = listNode.getData();
		listNode = listNode.getNext();
		itrPos++;
		return data;
	}

	/**
	 * unimplemented remove method
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
