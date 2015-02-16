package AD.aufgabe1;

/**
 * Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1
 * listable.java
 */

/**
 * This represents adt liste
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public interface Listable<T> {

    public Integer find(T element);

    public Object retrieve(int position);

    public void insert(int position, T element);

    public void delete(int position);

    public ListeNeu concat(ListeNeu<T> listPartTwo);
}
