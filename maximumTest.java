package myApplication;
import java.util.Arrays;

public class maximumTest<T extends Comparable<T>> {

    T x, y, z;

    // Parameterized Constructor for Generic Class
    public maximumTest(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // ************* UC – Generic Maximum Method for 3 variables *************
    public static <T extends Comparable<T>> T maximum(T a, T b, T c) {
        T max = a;

        if (b.compareTo(max) > 0)
            max = b;
        if (c.compareTo(max) > 0)
            max = c;

        return max;
    }

    // ************* UC – Print Max using Generic Method *************
    public static <T> void printMax(T max) {
        System.out.println("Maximum Value = " + max);
    }

    // ************* UC – Test Maximum using instance variables *************
    public T testMaximum() {
        T max = maximumTest.maximum(x, y, z);
        printMax(max);
        return max;
    }

    // ************* UC – Find Maximum of More Than 3 Values using Sorting *************
    @SafeVarargs
    public static <T extends Comparable<T>> T maximum(T... values) {

        Arrays.sort(values); // sorted ascending
        return values[values.length - 1]; // last element is max
    }

    // ************* MAIN TEST CASES *************
    public static void main(String[] args) {

        System.out.println("=== STRING TEST CASES (UC1) ===");

        // Max at 1st position
        System.out.println("Test Case: Max at 1st Position");
        printMax(maximum("Peach", "Apple", "Banana"));

        // Max at 2nd position
        System.out.println("Test Case: Max at 2nd Position");
        printMax(maximum("Apple", "Peach", "Banana"));

        // Max at 3rd position
        System.out.println("Test Case: Max at 3rd Position");
        printMax(maximum("Apple", "Banana", "Peach"));


        System.out.println("\n=== USING GENERIC CLASS (UC2) ===");

        maximumTest<String> stringTest = new maximumTest<>("Apple", "Peach", "Banana");
        stringTest.testMaximum();  // Internally calls static max()


        System.out.println("\n=== UC3: MORE THAN 3 PARAMETERS ===");

        String maxString = maximum("Apple", "Banana", "Peach", "Watermelon", "Grapes");
        printMax(maxString);
    }
}
