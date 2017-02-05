package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterate over all the elements in the collection without knowing the structure
 * of the collection.
 * 
 * @author Patcharapol Nirunpornputta
 *
 * @param <T>
 *            the type of thing in the ArrayIterator.
 * 
 */
public class ArrayIterator<T> implements Iterator<T> {
	/** attribute for the array we want to iterate over */
	private T[] array;
	/** position of element */
	private int cursor = 0;
	/** Control a use of remove() */
	private boolean delete = false;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;

	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (this.hasNext() == true) {
			cursor++;
			delete = true;
			return array[cursor - 1];

		} else
			throw new NoSuchElementException();

	}

	/**
	 * Show the users true if next element isn't null and show false if next
	 * element is null
	 * 
	 * @return true if next element isn't null. false if next element is null.
	 * 
	 */
	@Override
	public boolean hasNext() {
		for (int i = cursor; i < array.length; i++) {
			if (array[i] != null) {
				cursor = i;
				return true;
			}
		}
		return false;

	}

	/**
	 * Remove a recent element that have been return by a program
	 * 
	 * @throws IllegalStateException
	 *             if the next method has not yet been called, or the remove
	 *             method has already been called after the last call to the
	 *             next method
	 */

	@Override
	public void remove() {
		if (delete == true) {
			array[cursor - 1] = null;
			delete = false;
		} else
			throw new IllegalStateException();
	}

}
