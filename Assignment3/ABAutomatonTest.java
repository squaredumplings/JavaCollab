import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
* Test ABAutomaton.
*
* 
* @author Mihnea Buzoiu
* @id 1923552
* @author Nicholas Gurgu
* @id 1952234
*/

public class ABAutomatonTest {
    ABAutomaton automaton = new ABAutomaton();

    @Test
    public void testGenToString() {
        // simple test to see if it works
        boolean[] input1 = {true, true, false, false, true, true};
        System.out.print(automaton.genToString(input1) + "\n");

        // smallest non-zero input
        boolean[] input2 = {true};
        System.out.print(automaton.genToString(input2) + "\n");

        // large input
        boolean[] input3 = {true, false, false, true, true, false, false, true, 
                            true, false, false, true, true, false, false, true, 
                            true, false, false, true, true, false, false, true, 
                            true, false, false, true, true, false, false, true, 
                            true, false, false, true, true, false, false, true};
        System.out.print(automaton.genToString(input3) + "\n");

        // ??
        boolean[] input4 = {true, true, false, false, true, true};
        System.out.print(automaton.genToString(input4) + "\n");

        // ??
        boolean[] input5 = {true, true, false, false, true, true};
        System.out.print(automaton.genToString(input5) + "\n");
    }

    @Test
    public void testNextGenA() {
        // rule 1
        boolean[] input1 = {false, false, false, false, false, false, false, false, false, false, false};
        System.out.print(automaton.nextGenA(input1) + "\n");

    }
    @Test
    public void testNextGenB() {

    }
}
