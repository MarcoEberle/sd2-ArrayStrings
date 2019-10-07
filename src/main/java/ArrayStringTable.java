import java.util.Objects;

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
     * Eine neue, leere Tabelle.
     *
     * @param capacity Kapazitaet der Tabelle. Nicht negativ.
     */
    public ArrayStringTable(int capacity) {
        strings = new String[capacity];
        assert invariantHolds();
    }

    @Override
    public int size() {
        return used;
    }

    @Override
    public int getCapacity() {
        return strings.length;
    }

    @Override
    public String getElement(int index) {
        if (index < size())
            return strings[index];
        throw new IndexOutOfBoundsException();
    }

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
