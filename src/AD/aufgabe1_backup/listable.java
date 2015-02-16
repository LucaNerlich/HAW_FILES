package AD.aufgabe1_backup;

import AD.aufgabe1.ListeNeu;
import AD.aufgabe1.Node;

/**
 * Created by Luca on 25.09.2014.
 */
public interface listable<T> {

    public int find(AD.aufgabe1.Node<T> node);

    public AD.aufgabe1.Node<T> retrieve(int position);

    public void insert(int position, Node<T> node);

    public void delete(int position);

    public ListeNeu concat(ListeNeu<T> listPartTwo);
}
