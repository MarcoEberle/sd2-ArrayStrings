import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a String table consisting of an ArrayList.
 */
public class ListStringTable implements StringTable {

    /**
     * Liste, in der die Strings gespeichert werden.
     */
    private final List<String> stringList;

    /**
     * Konstruktor erzeugt eine neue leere Liste.
     */
    public ListStringTable() {
        this.stringList = new ArrayList<>();
    }

    /**
     * Method that returns the size of the table.
     *
     * @return - Returns current size of the String table.
     */
    @Override
    public int size() {
        return stringList.size();
    }

    /**
     * Method that returns the capacity of the String table.
     *
     * @return - Returns the capacity of the String table.
     */
    @Override
    public int getCapacity() {
        return size();
    }

    /**
     * Method that returns the element on a specific size.
     *
     * @param index - Index of the element to return.
     * @return - Returns the element at index.
     */
    @Override
    public String getElement(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stringList.get(index);
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
        if (toIndex < 0 || toIndex > size()) {
            throw new IndexOutOfBoundsException();
        }
        stringList.add(toIndex, getElement(fromIndex));
        stringList.remove(fromIndex);
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
        final int oldSize = size();
        if (startIndex > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (size() > startIndex + strings.length) {
            throw new IllegalArgumentException("table overflow");
        }
        for (String each : strings) {
            Objects.requireNonNull(each);
        }
        for (int indexTable = startIndex; indexTable < oldSize; indexTable++) {
            stringList.remove(indexTable);
        }
        stringList.addAll(Arrays.asList(strings));
        return this;
    }
}
