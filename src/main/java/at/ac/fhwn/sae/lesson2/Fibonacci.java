package at.ac.fhwn.sae.lesson2;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 48;

        System.out.println(getFibonacci(n));
        System.out.println(getFibonacciRecursiv(n));

    }

    /**
     *  Calculates the Fibonacci number starting with 0 and 1
     *  the method returns the number on the position that gets entered
     *
     *  limits: position must be between 0 und 92
     *
     * @param position the postion of the Fibonacci Number you want to get
     * @return the Fibonacci number on the position you wanted to know
     */
    public static long getFibonacci(int position) {
        int firstNumber = 0, secondNumber = 1, nextNumber = 0;
        switch (position) {
            case 0:
                return firstNumber;
            case 1:
                return secondNumber;
            default:
                for (int i = 1; i < position; i++) {
                    nextNumber = firstNumber + secondNumber;
                    firstNumber = secondNumber;
                    secondNumber = nextNumber;
                }
                return nextNumber;
        }
    }

    /**
     * calculates the Fibonacci number recursive starting with 0 and 1
     *
     * limits = 0 - 46
     * Stack Overflow at  = int 46
     * Variable Overflow = is an overflow that occurs when you want to store in an integer variable a value that is larger than the maximum value that would fit in the variable
     * You can avoid a variable overflow by checking whether the maximum value has already been reached
     *
     * @param position the postion of the Fibonacci Number you want to get
     * @return the Fibonacci number on the position you wanted to know
     */
    public static int getFibonacciRecursiv(int position) {
        if (position == 0) {
            return 0;
        }
        else if (position == 1) {
            return 1;
        }
        else {
            return getFibonacciRecursiv(position-1) + getFibonacciRecursiv(position-2);
        }
    }

}
