//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Linked Bookshelf
// Course:   CS 300 Fall 2021
//
// Author:   Bill Lee
// Email:    blee266@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Leobardo Guardado JR
// Partner Email:   guardadojr@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         N/A
// Online Sources:  N/A
//
///////////////////////////////////////////////////////////////////////////////
/*
 * This class is a singly linked list of LinkedNodes containing Book objects.
 */
public class LinkedBookshelf {
	private LinkedNode<Book> front;
	private LinkedNode<Book> back;
	private int size;
	private Attribute sortedBy;
	/*
	 * This method creates a new bookshelf object, and initialize the values to
	 * null.
	 */

	public LinkedBookshelf() {
		this.front = null;
		this.back = null;
		this.size = 0;
		this.sortedBy = Attribute.ID;
	}
	/*
	 * This method returns the size of the bookshelf when called.
	 * 
	 * @ returns size
	 */

	public int size() {
		return this.size;
	}
	/*
	 * This method checks whether if the bookshelf is empty or not.
	 * 
	 * @ returns true when size is 0, false otherwise.
	 */

	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}
	/*
	 * This method returns a String representation of the current state of the
	 * shelf, beginning with the current value of sortedBy and followed by each
	 * Books String representation on a separate line in order from front to back.
	 * 
	 * @returns string representation of the current state of the shelf.
	 */

	public String toString() { // x
		String bookShelf = sortedBy.toString();
		LinkedNode<Book> currNode = front;
		while (currNode != null) {
			bookShelf += "\n" + currNode.toString();
			currNode = currNode.getNext();
		}
		return bookShelf;
	}
	/*
	 * This method returns the LinkedNode<Book> at the given index, or throws an
	 * IndexOutOfBoundsException if the index is not in the range 0-(size-1).
	 * 
	 * @param int index is the index of the bookshelf that is being pointing at.
	 * 
	 * @returns LinkedNode<Book> at the given index.
	 * 
	 * @throws IndexOutOfBoundsException if the index is not in the range
	 */

	public LinkedNode<Book> getNode(int index) {
		if (!(index >= 0 && index <= (size - 1)))
			throw new IndexOutOfBoundsException("invalid index");

		int count = 0;
		LinkedNode<Book> curr = front;

		while (curr != null && count < index) {
			count++;
			curr = curr.getNext();
		}
		return curr;
	}
	/*
	 * This method returns the Book at the given index, or throws an
	 * IndexOutOfBoundsException if the index is not in the range.
	 * 
	 * @param int index is the index of the bookshelf that is being pointing at.
	 * 
	 * @returns Book at the given index.
	 * 
	 * @throws IndexOutOfBoundsException if the index is not in the range.
	 */

	public Book get(int index) { // x
		if (!(index >= 0 && index <= (size - 1)))
			throw new IndexOutOfBoundsException("invalid index");

		int count = 0;
		LinkedNode<Book> curr = front;
		
		while (curr != null && count < index) {
			count++;
			curr = curr.getNext();
		}
		return curr.getData();
	}
	/*
	 * This method returns the Book at the front of the list.
	 * 
	 * @returns the Book at the front of the list.
	 */

	public Book getFirst() {
		if (isEmpty())
			return null;
		return this.front.getData();
	}
	/*
	 * This method returns the Book at the back of the list.
	 * 
	 * @returns the Book at the back of the list
	 */

	public Book getLast() {
		if (isEmpty())
			return null;
		return this.back.getData();
	}
	/*
	 * This method restores the shelf to an empty state
	 */

	public void clear() {
		this.front = null;
		this.back = null;
		this.size = 0;
	}
	/*
	 * This method adds the provided Book object to the end of the linked list and
	 * increases the bookshelf size accordingly, does not consider the value of
	 * sortedBy
	 * 
	 * @param Book toAdd is the book object that will be added next.
	 */

	public void appendBook(Book toAdd) {
		LinkedNode<Book> addBook = new LinkedNode<Book>(toAdd);
		if (front == null && back == null) {
			front = addBook;
			back = addBook;
		} else {
			back.setNext(addBook);
			back = addBook;
		}
		size++;
	}
	/*
	 * This method inserts the provided book at the correct location in the list,
	 * which you may assume has been sorted based on the value of sortedBy, and
	 * increases the bookshelf size accordingly
	 * 
	 * @param Book toAdd is the book object that will be added next.
	 */

	public void insertBook(Book toAdd) {
		LinkedNode<Book> addBook = new LinkedNode<Book>(toAdd);

		for (int i = 0; i < size; i++) {
			if (get(i).compareTo(toAdd, sortedBy) < 0) {
				LinkedNode<Book> curr = new LinkedNode<Book>(get(i));
				if (get(i) == getLast())
					appendBook(toAdd);
				else {
					LinkedNode<Book> nextNode = new LinkedNode<Book>(get(i + 1)); // node after toAdd
					curr.setNext(addBook);
					addBook.setNext(nextNode);
				}
			}
		}
	}
	/*
	 * This method runs insertion sort on the provided shelf, using the given
	 * Attribute for comparing Book objects. A list with 0 or 1 Books is already
	 * sorted. For longer lists, it detaches and saves the list beginning from the
	 * second element, and uses insertBook() to add each element in turn to the
	 * sorted portion of the list (with respect to sortedBy).
	 * 
	 * @param LinkedBookshelf b is the bookshelf that is being sorted.
	 * 
	 * @param Attribute sortedBy is the Attribute that b is being sorted by.
	 */

	public static void sort(LinkedBookshelf b, Attribute sortedBy) {

		if (!(b.size == 0 || b.size == 1)) {
			int i;

			for (i = 1;i < b.size; i++) {
				b.insertBook(b.get(i));
			}
		}

	}
}
