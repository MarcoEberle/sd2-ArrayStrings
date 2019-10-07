public interface StringTable {
    /**
     * Die Anzahl enthaltener Strings.
     *
     * @return Anzahl Elemente. Nicht negativ.
     */
    int size();

    /**
     * Das Fassungsvermoegen.
     *
     * @return Maximale Anzahl Elemente. Nicht negativ.
     */
    int getCapacity();

    /**
     * Das Element am gegebenen Index.
     *
     * @param index Index eines Elementes.
     * @return String am Index. Nicht null.
     * @throws IndexOutOfBoundsException wenn der Index zu klein oder zu gross ist.
     */
    String getElement(int index);

    /**
     * Verschiebt ein Element in der Tabelle.
     * Die anderen Elemente schliessen die Luecke beziehungsweise machen Platz.
     *
     * @param fromIndex Alter Index des Elementes.
     * @param toIndex   Neuer Index.
     * @return Diese Tabelle.
     * @throws IndexOutOfBoundsException wenn ein Index zu klein oder zu gross ist.
     */
    StringTable moveElement(int fromIndex, int toIndex);

    /**
     * Schreibt neue Elemente in die Tabelle.
     * Loescht zuerst die alten Elemente ab dem Startindex und fuegt dann die neuen Elemente an.
     * Fuegt die Elemente hinten an, wenn der Index der Anzahl vorhandener Elemente entspricht.
     *
     * @param startIndex Index, an dem das erste Element landet.
     * @param strings    String, die die Tabelle aufnimmt. Keiner null.
     * @return Diese Tabelle.
     * @throws IndexOutOfBoundsException wenn der Index zu klein oder zu gross ist.
     * @throws IllegalArgumentException  wenn die Tabelle zu klein ist.
     * @throws NullPointerException      wenn ein String null ist.
     */
    StringTable setElements(int startIndex, String... strings);

    /**
     * Liefert diese Tabelle als Text mit allen Elememten nacheinander.
     * Nach jedem Element folgt das Abschlusszeichen.
     *
     * @param delimiter Abschlusszeichen.
     * @return Text mit allen Elementen nacheinander.
     * Nicht null.
     */

    default String toText(char delimiter) {
        String result = "";
        for (int index = 0; index < size(); index++)
            result += getElement(index) + delimiter;
        return result;
    }
}
