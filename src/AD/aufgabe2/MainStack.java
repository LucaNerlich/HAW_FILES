package AD.aufgabe2;

/* Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2
 * MainStack.java
 */

/**
 * Application class for our Stack
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class MainStack {

    public static void main(String[] args) {
        Stack stack = new Stack(1);
        System.out.println("FIRST ELEMENT IN STACK");
        stack.push("(ELEMENT1)");
        System.out.println("SECOND ELEMENT IN STACK");
        stack.push("(Element2)");
        System.out.println("THIRD ELEMENT IN STACK");
        stack.push("(Element3)");

        System.out.println(stack.toString());
        System.out.println("Top: " + stack.top());
        System.out.println("Empty? " + stack.isEmpty());
        System.out.println("TAKE LAST ELEMENT FROM STACK");
        stack.pop();
        System.out.println("Empty? " + stack.isEmpty());
        System.out.println("Top: " + stack.top());
        System.out.println(stack.toString());
    }
}
