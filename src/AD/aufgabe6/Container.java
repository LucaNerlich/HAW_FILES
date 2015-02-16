package AD.aufgabe6;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 6
 * mainNeu.java
 */

/**
 * Generic Container. Can host any data, has a name and a corresponding number.
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Container<T> implements Comparable<Container> {

    private int dataNumber;
    private String name;
    private T data;

    public Container(int dataNumber) {
        this.dataNumber = dataNumber;
    }

    public Container(int dataNumber, String name) {
        this.dataNumber = dataNumber;
        this.name = name;
    }

    public Container(int dataNumber, String name, T data) {
        this.dataNumber = dataNumber;
        this.name = name;
        this.data = data;
    }

    /**
     * Compares two DataNumbers
     *
     * @param container
     * @return
     */
    @Override
    public int compareTo(Container container) {
        if (container.getDataNumber() == this.getDataNumber()) {
            return 0;
        } else if (container.getDataNumber() < this.getDataNumber()) {
            return -1;
        } else if (container.getDataNumber() > this.getDataNumber()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getDataNumber() {
        return dataNumber;
    }

    public void setDataNumber(int dataNumber) {
        this.dataNumber = dataNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
