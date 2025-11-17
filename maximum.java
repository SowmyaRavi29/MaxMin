package myApplication;
public class maximum {

    // Generic method to find maximum of 3 variables
    public static <T extends Comparable<T>> T maximum(T a, T b, T c) {

        T max = a;  // Assume a is max

        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }

        return max;
    }

    // Print max using generic method
    public static <T> void printMax(T max) {
        System.out.println("Maximum value = " + max);
    }

    // Testing code
    public static void main(String[] args) {

        System.out.println("=== Integer Test Cases ===");

        // Max at 1st position
        System.out.println("Test Case: Max at 1st Position");
        Integer max1 = maximum(30, 20, 10);
        printMax(max1);

        // Max at 2nd position
        System.out.println("Test Case: Max at 2nd Position");
        Integer max2 = maximum(10, 40, 20);
        printMax(max2);

        // Max at 3rd position
        System.out.println("Test Case: Max at 3rd Position");
        Integer max3 = maximum(10, 20, 50);
        printMax(max3);


        System.out.println("\n=== Float Test Cases ===");

        // Max at 1st position
        System.out.println("Test Case: Max at 1st Position");
        Float fmax1 = maximum(9.9f, 3.2f, 2.1f);
        printMax(fmax1);

        // Max at 2nd position
        System.out.println("Test Case: Max at 2nd Position");
        Float fmax2 = maximum(3.5f, 8.8f, 6.4f);
        printMax(fmax2);

        // Max at 3rd position
        System.out.println("Test Case: Max at 3rd Position");
        Float fmax3 = maximum(3.1f, 4.2f, 9.7f);
        printMax(fmax3);
    }
}
