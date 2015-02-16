package AD.aufgabe2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2
 * TestStack.java
 */

/**
 * Testclass for Stack
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class TestStack {

    @Test
    public void testStack() {

        /* ################## SETUP ##################*/
        Stack stack = new Stack(1);

        /* ################## TEST PUSH 1 ##################*/
        stack.push("(((6*(4+2))+(5-1))");
        System.out.println("PUSH FIRST ELEMENT TO STACK: " + stack.top());
        assertTrue(stack.top() == "(((6*(4+2))+(5-1))");

        /* ################## TEST IF EMPTY ##################*/
        System.out.println("CHECK IF STACK IS EMPTY => " + stack.isEmpty() + "\n");
        assertTrue(stack.isEmpty() == false);

        /* ################## TEST POP 1 ##################*/
        System.out.println("POP FIRST ELEMENT FROM STACK");
        stack.pop();
        /* ################## TEST IF EMPTY ##################*/
        System.out.println("CHECK IF STACK IS EMPTY => " + stack.isEmpty() + "\n");
        assertTrue(stack.isEmpty() == true);

        /* ################## TEST PUSH AND EXPAND ##################*/
        stack.push("(((6*(4+3))+(9-2))");
        System.out.println("PUSH FIRST ELEMENT TO STACK: " + stack.top());
        System.out.println("CHECK SIZE OF STACK: " + stack.getSize());
        System.out.println(stack.toString() + "\n");

        stack.push("(((6*(8+2))+(5-2))");
        System.out.println("PUSH SECOND ELEMENT TO STACK: " + stack.top());
        System.out.println("CHECK SIZE OF STACK: " + stack.getSize());
        System.out.println(stack.toString() + "\n");

        stack.push("(((6*(23+2))+(8-1))");
        System.out.println("PUSH THIRD ELEMENT TO STACK: " + stack.top());
        System.out.println("CHECK SIZE OF STACK: " + stack.getSize());
        assertTrue(stack.getSize() == 3);
        System.out.println(stack.toString() + "\n");

    }

}
