//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Linked Bookshelf Tester
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
 * This class is the tester class that tests the methods in LinkedBookshelf
 * and LinkedNode class.
 */
public class LinkedBookshelfTester {
	/*
	 * This method tests the constructor, setNext(), and getNext() method from
	 * LinkedNode class.
	 * 
	 * @returns true if the methods output is the expected, false otherwise.
	 */

	public static boolean testLinkedNode() {
		LinkedNode<String> a;

		// test 1: check if constructor with one argument works
		a = new LinkedNode<String>("i don't like this");

		if (a.getData() != "i don't like this" && a.getNext() != null) {
			return false;
		}

		// Test 2: check if the right data is returned from getNext()
		LinkedNode<String> expected = new LinkedNode<String>("tail");
		a = new LinkedNode<String>("whatever", expected);
		if (a.getNext() != expected)
			return false;

		// Test 3: check mutator setNext()
		expected = new LinkedNode<String>("tail");
		a = new LinkedNode<String>("whatever");
		a.setNext(expected);
		if (a.getNext() != expected)
			return false;

		return true;
	}
	/*
	 * This method tests the correctness of LinkedBookshelfs clear() method.
	 * 
	 * @returns true if the methods output is the expected, false otherwise.
	 */

	public static boolean testClear() {
		try {
			// Test 1: Add two books
			LinkedBookshelf e = new LinkedBookshelf();
			Book b1 = new Book("50 Shades of Grey", 400, "Grey", "Barry");
			Book b2 = new Book("Got Nothing", 300, "Leo", "Jr");
			e.appendBook(b1);
			e.appendBook(b2);
			e.clear();
			if (e.getFirst() != null && e.getLast() != null && e.size() != 0)
				return false;

			// Test 2: Add no books
			e = new LinkedBookshelf();
			e.clear();
			if (e.getFirst() != null && e.getLast() != null && e.size() != 0)
				return false;
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
			return false;
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	/*
	 * This method tests the correctness of LinkedBookshelfs appendBook() method.
	 * 
	 * @returns true if the methods output is the expected, false otherwise.
	 */

	public static boolean testAddBooks() {
		LinkedBookshelf e = new LinkedBookshelf();
		Book b1 = new Book("50 Shades of Grey", 400, "Grey", "Barry");
		Book b2 = new Book("Got Nothing", 300, "Leo", "Jr");
		Book b3 = new Book("Animals gone wild", 500, "McDonold", "Mickey");
		e.appendBook(b1);
		e.appendBook(b2);
		e.appendBook(b3);

		if (!(e.size() != 3 && b1 != e.getFirst() && b3 != e.getLast()))
			return false;

		return true;
	}
	/*
	 * This method tests the correctness of LinkedBookshelfs sort() method
	 * 
	 * @returns true if the methods output is the expected, false otherwise.
	 */

	public static boolean testSortBooks() {

		// Test 1: test if array is sorted for page count
		LinkedBookshelf e = new LinkedBookshelf();
		Book b1 = new Book("50 Shades of Grey", 400, "Grey", "Barry");
		Book b2 = new Book("Got Nothing", 300, "Leo", "Jr");
		Book b3 = new Book("Animals gone wild", 500, "McDonold", "Mickey");
		e.appendBook(b1);
		e.appendBook(b2);
		e.appendBook(b3);

		LinkedBookshelf.sort(e, Attribute.PAGECOUNT);

		if (e.getFirst() != b2 && e.getLast() != b3) {
			return false;
		}

		return true;
	}
	/*
	 * This method runs all test methods and returns true if all test methods return
	 * true.
	 * 
	 * @returns true if the all the method outputs are true, false otherwise.
	 */

	public static boolean runAllTests() {
		if (!testLinkedNode()) {
			System.out.print("Error in get LinkedNode Class");
			return false;
		}
		if (!testClear()) {
			System.out.print("Error in clear method");
			return false;
		}
		if (!testAddBooks()) {
			System.out.print("Error in add books method");
			return false;
		}
		if (!testSortBooks()) {
			System.out.print("Error in sort books method");
			return false;
		}
		System.out.println("All tests passed");
		return true;
	}

	public static void main(String[] args) {
		runAllTests();
	}

}
