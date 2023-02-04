//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Linked Node
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
 * This class represents the node objects that is needed in order to
 * build the linked list.
 */
public class LinkedNode <T>{
	private T data;
	private LinkedNode<T> next;
	/*
	 * This method initializes the data field and leaves next null.
	 */
	public LinkedNode(T data) {
		this.data = data;
		this.next = null;
	}
	/*
	 * This method updates the next field to be the provided node that is possibly
	 * null, does not return a value.
	 * 
	 * @param T data is the current data of the node
	 * 
	 * @param LinkedNode<T> next is the next value of the node.
	 */
	public LinkedNode(T data, LinkedNode<T> next) {
		this.data = data;
		this.next = next;
	}
	/*
	 * This method returns a reference to the next node in the list
	 * 
	 * @return a reference to the next node in the list
	 */
	
	public LinkedNode<T> getNext() {
		return this.next;
	}
	/*
	 * This method returns the value of the data instance field.
	 * 
	 * @returns the value of the data instance field.
	 */
	
	public T getData() {
		return this.data;
	}
	/*
	 * This method returns the String representation of the nodes data.
	 * 
	 * @returns the String representation of the nodes data
	 */
	
	@Override
	public String toString() {
		return data.toString();
	}
	/*
	 * This method updates the next field to be the provided node (possibly null);
	 * does not return a value.
	 * 
	 * @param LinkedNode<T> next is the provided code for next field.
	 */
	
	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}
}
