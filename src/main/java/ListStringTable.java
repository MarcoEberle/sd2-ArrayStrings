import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    @Override
    public int size() {
        return stringList.size();
    }

    @Override
    public int getCapacity() {
        return size();
    }

    @Override
    public String getElement(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stringList.get(index);
    }

    @Override
    public StringTable moveElement(int fromIndex, int toIndex) {
        if (toIndex < 0 || toIndex > size()) {
            throw new IndexOutOfBoundsException();
        }
        stringList.add(toIndex, getElement(fromIndex));
        stringList.remove(fromIndex);
        return this;
    }

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
