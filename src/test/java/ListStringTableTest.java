import org.junit.Test;

import static org.junit.Assert.*;

public class ListStringTableTest {

    private final StringTable sut = makeSUT();

    private static StringTable makeSUT() {
        return new ListStringTable();
    }

    @Test(timeout = 1_000)
    public void test30() {
        assertEquals("", sut.toText('x'));
        assertEquals(0, sut.size());
    }

    @Test(timeout = 1_000)
    public void test32() {
        assertEquals("", sut.toText('x'));
        assertEquals(0, sut.size());
    }

    @Test(timeout = 1_000, expected = java.lang.IndexOutOfBoundsException.class)
    public void test33() throws java.lang.IndexOutOfBoundsException {
        sut.getElement(0);
    }

    @Test(timeout = 1_000, expected = java.lang.IndexOutOfBoundsException.class)
    public void test34() throws java.lang.IndexOutOfBoundsException {
        sut.getElement(-1);
    }

    @Test(timeout = 1_000)
    public void test36() {
        sut.setElements(0, "abc");
        assertEquals("abcx", sut.toText('x'));
        assertEquals(1, sut.size());
        assertEquals("abc", sut.getElement(0));
    }

    @Test(timeout = 1_000, expected = java.lang.IndexOutOfBoundsException.class)
    public void test37() throws java.lang.IndexOutOfBoundsException {
        sut.setElements(0, "abc");
        assertEquals("abcx", sut.toText('x'));
        assertEquals(1, sut.size());
        sut.getElement(1);
    }

    @Test(timeout = 1_000)
    public void test38() {
        sut.setElements(0, "abc", "def");
        assertEquals("abcxdefx", sut.toText('x'));
        assertEquals("abc", sut.getElement(0));
        assertEquals("def", sut.getElement(1));
        assertEquals(2, sut.size());
    }

    @Test(timeout = 1_000, expected = java.lang.NullPointerException.class)
    public void test40() throws java.lang.NullPointerException {
        sut.setElements(0, (String) null);
    }

    @Test(timeout = 1_000, expected = java.lang.NullPointerException.class)
    public void test41() throws java.lang.NullPointerException {
        sut.setElements(0, "abc", null);
    }

}