package AD.aufgabe2;

/* Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2
 * TestCalculate.java
 */

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Testclass for Calculate
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class TestCalculate {

    @Test
    public void testCalculate() {

        Stack stack = new Stack(15);
      /* ################## CALCULATE TERMS ##################*/
        System.out.println("Check Term: ((7*7)+(10/3))*25)");
        Calculate.solveTerm(stack, "(((7*7)+(10/3))*25)");
        assertTrue(stack.top().equals("1308.3333"));
        System.out.println(stack.toString());

        //clear Stack:
        System.out.println("Clear Stack" + "\n");
        stack.pop();
        assertTrue(stack.isEmpty());

        System.out.println("Check Term: ((4+4)*(10/66))");
        Calculate.solveTerm(stack, "((4+4)*(10/66))");
        System.out.println(stack.toString());
        assertTrue(stack.top().equals("1.2121212"));

        //clear Stack:
        System.out.println("Clear Stack" + "\n");
        stack.pop();
        assertTrue(stack.isEmpty());

        System.out.println("Check Term: (7/7)");
        Calculate.solveTerm(stack, "(7/7)");
        System.out.println(stack.toString());
        assertTrue(stack.top().equals("1.0"));
        System.out.println(stack.toString());

        System.out.println("Clear Stack" + "\n");
        stack.pop();
        assertTrue(stack.isEmpty());


        /* ################## ILLEGAL TERMS ##################*/
        try {
            System.out.println("Check Term: (7*7*7)");
            Calculate.solveTerm(stack, "(7*7*7)");
            assertTrue(stack.isEmpty());

        } catch (Exception e) {
            System.out.println("Exception found" + "\n");
        }

        try {
            System.out.println("Check Term: ((7*a)+(10/p))*25)");
            Calculate.solveTerm(stack, "((7*a)+(10/p))*25)");
            assertTrue(stack.isEmpty());

        } catch (Exception e) {
            System.out.println("Exception found" + "\n");
        }
    }
}

