package com.dearnik1.learnjava.basics.vector;

import com.dearnik1.learnjava.basics.circle.Circle;

public interface Vector {
	/*
	* Implement Vector interface to store
	* references for multiple Circle objects.
	*/
	
	
	/**
	 * Removes all elements from the vector 
	 */
	void clear();
	
	
	/**
	 * Add new element to the vector. 
	 */
	void add(Circle circle);
	
	/**
	 * Returns the number of elements in the vector.
	 * 
	 * @return the number of elements in the vector.
	 */
	int size();
	
	/**
	 * Returns the element at the specified position.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in the vector
	 */
	Circle get(int index);
	
	
	/**
	 * Removes the element at the specified position in the vector. 
	 * 
	 * @param index the index of the element to be removed
	 */
	void remove(int index);
	
	/**
	 * Prints out all elements from the vector to System.out.
	 * 
	 * Format:
	 * 
	 * [index: %index_number%; Circle data: %circle_data%]
	 */
	void printVector();
	
	
	/**
	 *  Returns the index of the first occurrence of the specified element.
	 *  
	 *  @param circle element to search for
	 *  @return the index of the first occurrence of the specified element in
	 *         te vector, or -1 if this list does not contain the element
	 */
	int indexOf(Circle circle);
}
