/**
 * 
 * @author Theresa Steinmetz
 *
 */
public class ArrayList implements List, Dequeue {
	//TODO think about numberOfElements
	int numberOfElements = 0;
	String[] list = new String[4];
	String head = list[0];
	String tail = list[numberOfElements - 1];
	
	/**
	 * This method add an element to the array by the method addAtEnd.
	 * {@link addAtEnd()}
	 */
	@Override
	public void add(String entry) {
		addAtEnd(entry);
	}
	
	/**
	 * Adds an element to the end of the array, if the array is full,
	 * the array get resized {@link resize()}to the double size of the array.
	 * 
	 * @param entry
	 * 				is a object or String that should be added to the array.
	 */
	public void addAtEnd(String entry){
		if(numberOfElements<list.length - 1){
			list[numberOfElements++] = entry;
		} else {
			resize();
			list[numberOfElements++] = entry;
		} 
	}
	
	/**
	 * Is a method to resize the array to the double size of itself. 
	 */
	public void resize(){
		String[] newList = new String[list.length * 2];
		System.arraycopy(list, 0, newList, 0, list.length);
		list = newList;
	}
	
	/**
	 * Adds an element to the beginning of the array, if the array is full,
	 * the array get resized {@link resize()} to the double size of the array.
	 * 
	 * @param entry
	 * 				is a object or String that should be added to the array.
	 */
	public void addAtBegin(String entry){
		if(numberOfElements<list.length - 1){
			String[] newList = new String[list.length + 1];
			newList[0] = entry;
			System.arraycopy(list, 0, newList, 1, list.length);
			list = newList;
			numberOfElements++;
		} else {
			resize();
			String[] newList = new String[list.length + 1];
			newList[0] = entry;
			System.arraycopy(list, 0, newList, 1, list.length);
			list = newList;
			numberOfElements++;
		} 
	}
	
	/**
	 * This Method deletes an element of an array if it is the same
	 * as the parameter which is given to the method.
	 * If there are more then one they also get deleted.
	 * 
	 *  @param value
	 *  			every element of the array get compared to this parameter.
	 */
	@Override
	public void remove(String value) {
		int counter = 0;
		for(int i = 0; i <= numberOfElements; i++){
			String[] newList = new String[list.length];
			if(value.equals(list[i]) == true){
				numberOfElements--;
			} else {
				newList[counter] = list[i];
				counter++;
			}
		}
	}
	
	/**
	 * Remove the first element in the array.
	 */
	public void removeAtBegin(){
		for(int i = 1; i < numberOfElements - 1; i++){
			list[i] = list[i - 1];
		}
		list[numberOfElements - 1] = null;
		numberOfElements--;
	}
	
	/**
	 * Remove the last element in the array.
	 */
	public void removeAtEnd(){
		list[numberOfElements - 1] = null;
		numberOfElements--;
	}
	
	/**
	 * This method give back the actual number of elements in the list.
	 * 
	 * @return numberOfElements
	 */
	@Override
	public int size() {
		return numberOfElements;
	}
	
	/**
	 * This method checks if the array contains any elements.
	 * 
	 * @return true for an empty array or false for an array containing elements.
	 */
	@Override
	public boolean isEmpty() {
		if(numberOfElements == 0){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 *Returns the entry at the given index from the list.
	 *
	 * If the index has no suitable value, the method returns <code>null</code>.
	 *
	 * @param index
	 *            the position of the entry in the list
	 * @return the entry at the given position
	 */
	@Override
	public String get(int index) {
		if(index < numberOfElements){
			return list[index];
		} else {
		return null;
		}
	}
	
	/**
	 * @return the first entry in the list.
	 */
	@Override
	public String getHead() {
		return list[0];
	}

	/**
	 * @return the last entry in the list.
	 */
	@Override
	public String getTail() {
		return list[numberOfElements];
	}
	
	/**
	 *  Removes all entries from the list.
	 */
	@Override
	public void clear() {
		numberOfElements = 0;
	}
}
