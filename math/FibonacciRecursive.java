class FibonacciSequence {

    private void ValidateNumber(int Number) {

        if (Number <= 0)
            throw new IllegalArgumentException("Unable to process input");
    } 

    public int GetFibonacciNumber(int Position) {
        
        ValidateNumber(Position);

        if (Position == 1 || Position == 2)
            return 1;

        
        return GetFibonacciNumber(Position - 1) + GetFibonacciNumber(Position - 2);
    }
}

class TestFibonacci {

    private FibonacciSequence fibonacci;

    public TestFibonacci() {

        fibonacci = new FibonacciSequence();
    }

    public void Test_GetFibonacciNumber() {

        assert fibonacci.GetFibonacciNumber(3) == 2;
        assert fibonacci.GetFibonacciNumber(12) == 144;
        assert fibonacci.GetFibonacciNumber(5) == 5;
        assert fibonacci.GetFibonacciNumber(9) == 34;
    }
}

public class FibonacciRecursive {

    private static TestFibonacci testing = new TestFibonacci();

    public static void main(String[] args) {

        testing.Test_GetFibonacciNumber();
    }
}