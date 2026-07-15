public class Recursion {

    public static void main(String[] args) {
        System.out.println(factorialNonTail(5));
        System.out.println(factorialTail(4));
        System.out.println(factorial(3));
    }

    public static int factorialNonTail(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorialNonTail(n - 1);
    }

    // This is optimezed
    public static int factorialTail(int n) {
        return helper(n, 1);
    }

    private static int helper(int n, int answer) {
        if(n == 0) {
            return answer;
        }
        return helper(n - 1, answer * n);
    }

    // Another method as TailRecursion
    private static int factorial(int n) {
        int answer = 1;

        while(n > 0) {
            answer *= n;
            n--;
        }
        return answer;
    }
}
