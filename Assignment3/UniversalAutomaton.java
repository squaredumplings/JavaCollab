import java.util.Scanner;

/**
 * Universal Automaton.
 * 
 * TODO 3: Fill in your names and student IDs
 * 
 * @author NAME
 * @id ID
 * @author NAME
 * @id ID
 */
class UniversalAutomaton {
    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < gen.length; i++) {
            if (gen[i]) {
                result.append('*');
            } else {
                result.append(' ');
            }
        }
        return result.toString();
    }

    boolean[] nextGen(boolean[] ruleSequence, boolean[] gen) {
        boolean[] nextGen = new boolean[gen.length];
        for (int i = 0; i < gen.length; i++) {
            boolean center = gen[i];
            boolean left = (i > 0) && gen[i - 1];
            boolean right = (i < gen.length - 1) && gen[i + 1];
    
            if (!left && !right && !center) {
                nextGen[i] = ruleSequence[0];
            } else if (!left && right && !center) {
                nextGen[i] = ruleSequence[1];
            } else if (!left && !right && center) {
                nextGen[i] = ruleSequence[2];
            } else if (!left && right && center) {
                nextGen[i] = ruleSequence[3];
            } else if (left && !right && !center) {
                nextGen[i] = ruleSequence[4];
            } else if (left && right && !center) {
                nextGen[i] = ruleSequence[5];
            } else if (left && !right && center) {
                nextGen[i] = ruleSequence[6];
            } else {
                nextGen[i] = ruleSequence[7];
            }
        }
        return nextGen;
    }

    boolean[] readInitialGeneration(int length) {
        boolean[] initialGen = new boolean[length];
    
        while (true) {
            String stop = scanner.next();
            
            if (stop.equals("init_end")) {
                break;
            }
    
            if (!stop.equals("init_start")) {
                int start = Integer.parseInt(stop);
                
                if (valid(start, length)) {
                    initialGen[start - 1] = true;
                }
            }
        }
    
        return initialGen;
    }
    
    boolean valid(int start, int length) {
        return start >= 1 && start <= length;
    }

    boolean[] readRuleSequence() {
        boolean[] ruleSequence = new boolean[8];
        for (int i = 0; i < 8; i++) {
            if (scanner.nextInt() == 1) {
                ruleSequence[i] = true;
            }
            else {
                ruleSequence[i] = false;
            }
        }
        return ruleSequence;
    }

    void run() {
        // Read input to configure the universal automaton
        boolean[] ruleSequence = readRuleSequence();
        int generationLength = scanner.nextInt();
        int numberOfGenerations = scanner.nextInt();
        boolean[] initGen = readInitialGeneration(generationLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numberOfGenerations; i++) {
            // Display the current generation
            System.out.println(genToString(gen));
            // Determine the next generation
            gen = nextGen(ruleSequence, gen);
        }
    }

    public static void main(String[] args) {
        new UniversalAutomaton().run();
    }
}
