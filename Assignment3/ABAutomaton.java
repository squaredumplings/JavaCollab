import java.util.Scanner;
/**
* Automatons A and B.
*
* 
*
* @author Mihnea Buzoiu
* @id 1923552
* @author Nicholas Gurgu
* @id 1952234
*/

class ABAutomaton {
    Scanner scanner = new Scanner(System.in);
    
    // converts from boolean to string for printing
    String genToString(boolean[] gen) {
        String retStr = "";

        for (int i = 0; i < gen.length; i++) {
            if (gen[i]) {
                retStr += "*";
            } else {
                retStr += " ";
            }
        }

        return retStr;
    }

    boolean[] nextGenA(boolean[] gen) {
        // goes through a generation and creates future cells
        boolean[] nextGen = new boolean[gen.length];

        for (int i = 1; i < gen.length - 1; i++) {
            if ((!gen[i - 1] && gen[i] && !gen[i + 1]) 
                || (gen[i - 1] && gen[i] && gen[i + 1]) 
                || (!gen[i - 1] && !gen[i] && !gen[i + 1])) {
                nextGen[i] = false;
            } else {
                nextGen[i] = true;
            }
        }
        return nextGen;
    }

    boolean[] nextGenB(boolean[] gen) {
        // goes through a generation and creates future cells
        boolean[] nextGen = new boolean[gen.length];

        for (int i = 1; i < gen.length - 1; i++) {
            if ((!gen[i - 1] && gen[i] && gen[i + 1])
                || (gen[i - 1] && gen[i] && gen[i + 1]) 
                || (!gen[i - 1] && !gen[i] && !gen[i + 1]) 
                || (gen[i - 1] && !gen[i] && gen[i + 1])) {
                nextGen[i] = false;
            } else {
                nextGen[i] = true;
            }
        }
        return nextGen;
    }

    boolean[] readInitalGeneration(int length) {
        boolean[] initialGen = new boolean[length];
        String textBlock = scanner.next(); 
        textBlock = scanner.next(); // removes init_start
    
        // reads and converts a number from string to int
        while (!textBlock.equals("init_end")) { 
            
            int cellHere = Integer.parseInt(textBlock);

            if ((1 <= cellHere) && (cellHere <= length)) {
                initialGen[cellHere - 1] = true;
            }

            textBlock = scanner.next();
        }
    
        return initialGen;
    }

    void run() {
        
        // Read input to configure the automaton
        String automaton = scanner.next();
        int genLength = scanner.nextInt();
        int numOfGens = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(genLength);

        for (boolean i : initGen) {
            if (i) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }

        // Run the automaton
        boolean[] gen = initGen;
        for (int i = 0; i < numOfGens; i++) {

            // Display the current generation
            System.out.println(genToString(gen));

            // And determine the next generation
            if ("A".equals(automaton)) {
                gen = nextGenA(gen);
            } else {
                // B
                gen = nextGenB(gen);
            }
        }
    }

    public static void main(String[] args) {
        new ABAutomaton().run();
    }
}