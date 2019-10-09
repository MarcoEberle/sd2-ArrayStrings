import java.util.Objects;

/**
 * This class represents a String table consisting of an array.
 */
public class ArrayStringTable implements StringTable {
    /**
     * Nimmt die Elemente auf.
     */
    private final String[] strings;

    /**
     * Anzahl gueltiger Elemente im Array.
     */
    private int used;

    /**
     * Constructor for a new ArrayStringTable.
     *
     * @param capacity - Capacity of the Table.
     */
    public ArrayStringTable(int capacity) {
        strings = new String[capacity];
        assert invariantHolds();
    }

    /**
     * Method that returns the size of the table.
     *
     * @return - Returns current size of the String table.
     */
    @Override
    public int size() {
        return used;
    }

    /**
     * Method that returns the capacity of the String table.
     *
     * @return - Returns the capacity of the String table.
     */
    @Override
    public int getCapacity() {
        return strings.length;
    }

    /**
     * Method that returns the element on a specific size.
     *
     * @param index - Index of the element to return.
     * @return - Returns the element at index.
     */
    @Override
    public String getElement(int index) {
        if (index < size())
            return strings[index];
        throw new IndexOutOfBoundsException();
    }

    /**
     * Method that moves an element from one index to another.
     *
     * @param fromIndex - Old index of the element.
     * @param toIndex   - New index of the element.
     * @return - Return this StringTable.
     */
    @Override
    public StringTable moveElement(int fromIndex, int toIndex) {
        final String movedString = getElement(fromIndex);
        final int elementsShifted = toIndex - fromIndex - 1;
        if (fromIndex < toIndex)
            System.arraycopy(strings, fromIndex + 1, strings, fromIndex, elementsShifted);
        else if (fromIndex > toIndex)
            System.arraycopy(strings, fromIndex, strings, fromIndex + 1, elementsShifted);
        strings[toIndex] = movedString;
        assert invariantHolds();
        return this;
    }

    /**
     * Method that adds new elements and replaces the old one.
     * Size of the ArrayStringTable keeps the same.
     *
     * @param startIndex - Index, where the new elements gets added.
     * @param strings    String, that gets added to the StringTable.
     * @return - Return this StringTable with new elements.
     */
    @Override
    public StringTable setElements(int startIndex, String... strings) {
        if (startIndex + strings.length > this.strings.length)
            throw new IllegalArgumentException("table overflow");
        if (startIndex > size())
            throw new IndexOutOfBoundsException();
        for (String string : strings)
            Objects.requireNonNull(string);
        System.arraycopy(strings, 0, this.strings, startIndex, strings.length);
        used = startIndex + strings.length;
        assert invariantHolds();
        return this;
    }

    private boolean invariantHolds() {
        assert used <= strings.length;
        assert used >= 0;
        for (int index = 0; index < size(); index++)
            assert getElement(index) != null;
        return true;
    }
}
