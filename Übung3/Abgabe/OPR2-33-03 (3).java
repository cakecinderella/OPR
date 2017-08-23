/**
 * 
 * @author Theresa Steinmetz
 *
 */
public interface Dequeue {
	
	/**
	 * Adds an entry to the list.
	 * The entry is inserted at the begin of the list.
	 *
	 * @param entry
	 *            the entry which should be added to the list.
	 */
	public void addAtBegin(String entry);
	
	/**
	 * Adds an entry to the list.
	 * The entry is inserted at the end of the list.
	 *
	 * @param entry
	 *            the entry which should be added to the list.
	 */
	public void addAtEnd(String entry);
	
	/**
	 * Remove the first element in the array.
	 */
	public void removeAtBegin();
	
	/**
	 * Remove the last element in the array.
	 */
	public void removeAtEnd();
	
	/**
	 * @return the first entry in the list.
	 */
	public String getHead();
	
	/**
	 * @return the last entry in the list.
	 */
	public String getTail();
	
	
}
