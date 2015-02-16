package AD.aufgabe7;
/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 7
 * Container.java
 */

/**
 * Generic Container. Can host any data, has a name and a corresponding number.
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Container<T> implements Comparable<Container>, Sortable {

    private int key;
    private String name;
    private T data;

    public Container(int key) {
        this.key = key;
    }

    public Container(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public Container(int key, String name, T data) {
        this.key = key;
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
        if (container.getKey() == this.getKey()) {
            return 0;
        } else if (container.getKey() < this.getKey()) {
            return -1;
        } else if (container.getKey() > this.getKey()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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
