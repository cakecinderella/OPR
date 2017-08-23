/**
 * A dynamically growing list.
 * <p>
 * The elements stored in the list are strings. The strings are not necessarily
 * unique throughout the list.
 *
 * @author Claudia
 * @version 1.0
 */
interface List {

	/**
	 * Adds an entry to the list.
	 *
	 * The entry is inserted at the end of the list.
	 *
	 * @param e
	 *            the entry which should be added to the list.
	 */
	void add(String entry);

	/**
	 * Removes strings which are equal to the given value from the list.
	 * <p>
	 * If there are more entries with the same value, all elements with the
	 * value are removed.
	 *
	 * @param value
	 *            all entries equal to this string are to be removed
	 */
	void remove(String value);

	/**
	 * @return the current number of elements in the list.
	 */
	int size();

	/**
	 * @return <code>true</code> if there are no elements in the list,
	 *         <code>false</code> otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns the entry at the given index from the list.
	 *
	 * If the index has no suitable value, the method returns <code>null</code>.
	 *
	 * @param index
	 *            the position of the entry in the list
	 * @return the entry at the given position
	 */
	String get(int index);

	/**
	 * @return the first entry in the list.
	 */
	String getHead();

	/**
	 * @return the last entry in the list.
	 */
	String getTail();

	/**
	 * Removes all entries from the list.
	 */
	void clear();

	/**
	 * @return a <code>String</code> representation of the list.
	 */
	@Override
	String toString();

}
