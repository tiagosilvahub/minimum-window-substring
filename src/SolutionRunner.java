package src;

import src.solutions.SlidingWindow;
import src.solutions.Solution;

import java.util.Arrays;

public class SolutionRunner {
    public static void main(String[] args) {
        Solution[] solutions =
            new Solution[]{
                new SlidingWindow()
            };

        // add test cases
        var input = new String[][]{
            new String[]{
                "ADOBECODEBANC", "ABC"
            },
            new String[]{
                "A", "A"
            },
            new String[]{
                "ADOBECODEBANC", "ADOBECODEBANC"
            },
            new String[]{
                "AAFLSLFLSLDKALSKAAA", "AAA"
            },
            new String[]{
                "AAFLSLFLSLDKALSK", "AA"
            },
            new String[]{
                "A", "AA"
            },
            new String[]{
                "AAAA", "B"
            }
        };

        String result;
        int errors = 0;
        int nTestCases = input.length;
        var output = Arrays.asList("BANC", "A", "ADOBECODEBANC", "AAA", "AA", "", "");

        assert(output.size() == nTestCases);

        for (Solution s : solutions) {
            for (int i = 0; i < nTestCases; i++) {

                result = s.minWindow(input[i][0], input[i][1]);

                if( !output.get(i).equals(result)) {
                    System.out.println("Solution " + s.getClass().getCanonicalName() + " wrong for input " + Arrays.toString(input[i]));
                    System.out.println("Expected: " + output.get(i) + " but got: " + result);
                    System.out.println();
                    errors++;
                }
            }
        }
        printResults(errors, nTestCases);
    }

    private static void printResults(int errors, int nTestCases) {
        if(errors == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(nTestCases - errors + " tests passed.");
        }
        System.out.println(errors + " tests failed.");
        System.out.println((0.0 + nTestCases - errors) / nTestCases * 100  + "% of tests passed.");
    }
}

