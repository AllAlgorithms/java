// Java program to find n-th Fibonacci number 
// Adapted from code by Anant Agarwal.
class Nth_fibonacci_using_goldenratio
{ 
    // Approximate value of golden ratio 
    static double PHI = 1.6180339; 
      
    // Fibonacci numbers upto n = 5 
    static int f[] = { 0, 1, 1, 2, 3, 5 }; 
      
    // Function to find nth 
    // Fibonacci number 
    static int fib (int n) 
    { 
        // Fibonacci numbers for n < 6 
        if (n < 6) 
            return f[n]; 
      
        // Else start counting from  
        // 5th term 
        int t = 5; 
        int fn = 5; 
      
        while (t < n) { 
            fn = (int)Math.round(fn * PHI); 
            t++; 
        } 
      
        return fn;  
    } 
      
    public static void main (String[] args)  
    { 
        int fibNo;
        fibNo = fib(9); //RETURNS 34
        fibNo = fib(8); //RETURNS 21
        fibNo = fib(7); //RETURNS 13
    } 
} 
