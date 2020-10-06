package testes;
/**
 * Java implementation of recursive factorial
 * @author @joao-vieira
 */

public class RecursiveFactorial {

    public int recursiveFactorial(int n) {
        if(n <= 1) return 1;
        return n * recursiveFactorial(n-1);
    }
    
    public static void main(String[] args) {
        // Test
        int number = 3;
        System.out.println(number + "! = " + new RecursiveFactorial().recursiveFactorial(number));
    }
    
}
