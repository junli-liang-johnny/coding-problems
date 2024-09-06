public class ArrayList {
	private String[] elements;
	private int lastInsertedIndex;

	public ArrayList() {
		elements = new String[10];
		lastInsertedIndex = 0;
	}

	public void add(String element) {
		if (lastInsertedIndex == elements.length) {
			String[] temp = elements;
			elements = new String[temp.length * 2];

			for (int i = 0; i < temp.length - 1; i++) {
				elements[i] = temp[i];
			}
		}

		elements[lastInsertedIndex++] = element;
	}

	/*
	 * 1. handle shifting elements to the right
	 * 2. check if resizing is necessary when the elements has value occupied at the
	 * provided index
	 * 3. don't handle insertion when the provided index is out of bound.
	 */
	public void add(int index, String element) {
		// copy using built-in function
		if (index > lastInsertedIndex || index < 0) {
			return;
		}

		// need to resize
		if (lastInsertedIndex == elements.length) {
			String[] newElements = new String[elements.length * 2];
			System.arraycopy(elements, 0, newElements, 0, elements.length);
			elements = newElements;
		}

		System.arraycopy(elements, index, elements, index + 1, lastInsertedIndex - index);
		elements[index] = element;
		lastInsertedIndex++;
	}

	public void clear() {
		elements = new String[10];
		lastInsertedIndex = 0;
	}

	public boolean contains(String element) {
		for (int i = 0; i <= lastInsertedIndex; i++) {
			if (elements[i].equals(element)) {
				return true;
			}
		}

		return false;
	}

	public String get(int index) {
		if (index >= lastInsertedIndex || index < 0) {
			return null;
		}

		return elements[index];
	}

	public void set(int index, String element) {
		if (index >= lastInsertedIndex || index < 0) {
			return;
		}

		elements[index] = element;
	}

	public int size() {
		return lastInsertedIndex;
	}
}
