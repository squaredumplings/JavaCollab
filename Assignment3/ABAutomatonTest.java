import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
* Test ABAutomaton.
*
* TODO 3: FIll in your names and student IDs
* @author NAME
* @id ID
* @author NAME
* @id ID
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

    // de sapte ori mai scrie

// Add at least 8 test cases.
// Motivate each test case with a line comment like this.
}
@Test
public void testNextGenB() {
// TODO 10:
// Add at least 8 test cases.
// Motivate each test case with a line comment like this.
}
}
