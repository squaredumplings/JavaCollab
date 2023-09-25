import java.util.Scanner;
/**
* Automatons A and B.
*
* TODO 3: FIll in your names and student IDs:
*
* @author NAME
* @id ID
* @author NAME
* @id ID
*/
class ABAutomaton {
    Scanner scanner = new Scanner(System.in);
    
    String genToString(boolean[] gen) {
        String retStr = "";

        for (int i = 0; i < gen.length; i++){
            if (gen[i] == false){
                retStr += " ";
            } else {
                retStr += "*";
            }
        }

        return retStr;
    }

    boolean[] nextGenA(boolean[] gen) {
        // goes through a generation and creates future cells
        boolean[] nextGen = new boolean[gen.length];

        for (int i = 1; i < gen.length - 1; i++){
            if ((!gen[i - 1] && gen[i] && !gen[i + 1]) ||
                (gen[i - 1] && gen[i] && gen[i + 1]) ||
                (!gen[i - 1] && !gen[i] && !gen[i + 1])) {
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

        for (int i = 1; i < gen.length-1; i++){
            if ((!gen[i-1] && gen[i] && !gen[i+1]) ||
                (gen[i-1] && gen[i] && gen[i+1]) ||
                (!gen[i-1] && !gen[i] && !gen[i+1]) ||
                (gen[i-1] && gen[i] && gen[i+1])) {
                nextGen[i] = false;
            } else {
                nextGen[i] = true;
            }
        }
        return nextGen;
    }

    boolean[] readInitalGeneration(int length) {
        boolean[] initialGen = new boolean[length];
        String textBlock = scanner.next(); // removes init_start
    
        while (!textBlock.equals("init_end")) { 
            // reads and converts a number from string to int
            textBlock = scanner.next(); 
            int cellHere = Integer.parseInt(textBlock);

            if ((1 <= cellHere) && (cellHere <= length)) {
                initialGen[cellHere - 1] = true;
            }
        }
    
        return initialGen;
    }

    void run() {
        
        // Read input to configure the automaton
        String automaton = scanner.next();
        int genLength = scanner.nextInt();
        int numOfGens = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(genLength);

        System.out.print(automaton + " ");
        System.out.print(genLength + " ");
        System.out.print(numOfGens + "\n");
        System.out.print(initGen + "\n");

/* 
B 61 20
init_start 20 40 init_end
*/

        /*
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
        }*/
    }
    public static void main(String[] args) {
    new ABAutomaton().run();
    }
}