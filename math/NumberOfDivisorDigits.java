public class NumberOfDivisorDigits {
    
    public static int getNumberOfDivisorDigits(final int number) {
        int mutatedNumber = number;
        int numberOfEvenlyDivides = 0;
        
        while(mutatedNumber > 0) {
            final int digit = mutatedNumber % 10;
            mutatedNumber = mutatedNumber / 10;
            
            if (digit != 0 && number % digit == 0) {
                numberOfEvenlyDivides += 1;
            }
        }
        
        return numberOfEvenlyDivides;
    }
}