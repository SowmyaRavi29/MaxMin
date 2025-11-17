package myApplication;

public class maxMin1 {

    // Method to find maximum of 3 integers
    public static Integer findMaximum(Integer a, Integer b, Integer c) {

        Integer max = a;  // assume a is max

        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {

        // Test Case: Max number at 3rd position
        Integer a = 40, b = 70, c = 120;

        Integer result = findMaximum(a, b, c);

        System.out.println("Input: " + a + ", " + b + ", " + c);
        System.out.println("Maximum Returned: " + result);
    }
}
