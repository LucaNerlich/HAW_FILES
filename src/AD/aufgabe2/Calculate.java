package AD.aufgabe2;

/* Praktikum WIAD, WS 2014/2015
 * Gruppe: Luca Nerlich (Lucasteffen.Nerlich@haw-hamburg.de)
 * 		   Daniel Sommerlig (Daniel.Sommerlig@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2
 * Calculate.java
 */

/**
 * This class solves mathematical terms, which are fully surrounded by parentheses (' ( ) ').
 *
 * @author (Daniel.Sommerlig@haw-hamburg.de) &
 *         (Lucasteffen.Nerlich@haw-hamburg.de)
 */
public class Calculate {
    public static void main(String[] args) {

        Stack stack = new Stack(20);
        solveTerm(stack, "((7.9*7.2)+(10.2/3))");
        System.out.println(stack.toString());

    }

    /**
     * Gets a Stack and a String term. Solves this term with the use of clever exceptions and stack mechanics.
     * Complexity: O(n² + n) -> O(n²) : actually a bit less, because our 2nd for loop starts with y = i.
     *
     * @param stack -> pass an empty stack which will be used to store the solution.
     * @param term  -> pass a mathematical term, where each calculations if fully surrounded by parentheses.
     * @throws NullPointerException
     */
    public static void solveTerm(Stack stack, String term) throws NullPointerException {

        if (term.equals("")) {
            throw new IllegalArgumentException("Term cannot be null");
        }

        for (int i = 0; i < term.length(); i++) {
            char element = term.charAt(i); //returns the character located at the String's specified index
            if (element == ' ' || element == '\u0000') { // \u0000 = null
                throw new NumberFormatException("Incorrect value at position: " + i + 1);
            }

            String currentValue = "" + element; // mit "" bauen wir einen String

            /*
            prueft ob das aktuelle Zeichen ein Int ist, wenn ja wirds gemerkt.
            Dann wird der naechste Wert geprueft und auch angehaengt.
            Falls dies kein Int ist, soll er rausspringen und den gemerkten Wert (eventuell >9, also zwei Zeichen) pushen.
             */
            try {
                // int value = Integer.parseInt(term.charAt(i));
                String elementCache = "" + element;
                int value = Integer.parseInt(elementCache);
                currentValue = "" + value;

                // Checkt ob die direkt nachfolgenden Zeichen auch eine Zahl sind.
                try {
                    for (int y = i + 1; y < term.length(); y++) {
                        String nextElementCache = "" + term.charAt(y);
                        if (nextElementCache.equals(".")) {
                            currentValue += ".";
                        } else {
                            int nextValue = Integer.parseInt(nextElementCache);
                            currentValue += nextValue; //alt.: currentValue = currentvalue + "" + nextValue;
                        }
                        i++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    // reached end of array
                } catch (NumberFormatException f) {
                    // NaN
                }

            } catch (NumberFormatException g) {
                // Do nothing
            }

            //until element == ), then:
            if (term.charAt(i) == (')')) {
                String operand2 = stack.top(); //speicher Operand 2 als String
                stack.pop(); //entferne Operand2 aus stack

                String operator = stack.top();
                stack.pop();

                String operand1 = stack.top();
                stack.pop();

                String dummy = stack.top();

                if (!dummy.equals("(")) {
                    throw new IllegalArgumentException("Only two operands allowed!");
                }
                stack.pop(); //deletes unnessessary '('

                float ergebnis = solve(operand1, operator, operand2);
                stack.push("" + ergebnis);
            }
            if (!currentValue.equals(")")) {
                stack.push(currentValue); //push element to string
            }
        }
    }

    /**
     * Helpermethod used by solveTerm(). Does the actual calculation.
     * Complexity: O(n)
     *
     * @param operand1 String -> first operand
     * @param operator String -> operator (+, -, *, /)
     * @param operand2 String -> second operator
     * @return float -> solution of operator(operand1, operand2)
     */
    private static float solve(String operand1, String operator, String operand2) {
        float solution = 0f; //initialisieren der Variable
        try {
            float operandFirst = Float.parseFloat(operand1);
            float operandSecond = Float.parseFloat(operand2);

            switch (operator.charAt(0)) {
                case '+':
                    solution = operandFirst + operandSecond;
                    break;
                case '-':
                    solution = operandFirst - operandSecond;
                    break;
                case '*':
                    solution = operandFirst * operandSecond;
                    break;
                case '/':
                    solution = operandFirst / operandSecond;
                    break;
                default:
                    throw new IllegalArgumentException("Not a valid operator!");
            }

        } catch (NumberFormatException nfe) {
            System.err.println("Could not solve the given term!");
        }
        return solution;
    }
}