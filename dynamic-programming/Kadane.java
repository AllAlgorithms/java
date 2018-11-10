package AlgorithmsAndDS;

public class Kadane {

	public static void main(String[] args) {
		int[] arr= {2,3,-6,1,2,3,-4,5};
		System.out.println(maximumSubArraySum(arr));
		//System.out.println(kadaneSum(arr));
	}
	public static int maximumSubArraySum(int[] arr) {
		int osum=arr[0];
		int csum=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(csum+arr[i]<arr[i]) {
				csum=arr[i];
			}
			else {
				csum+=arr[i];
			}
			if(csum>osum) {
				osum=csum;
			}
		}		
		return osum;
	}
	
	
	
	
	public static int kadaneSum(int[] arr) {
		int osum=arr[0];
		int csum=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(csum+arr[i]<arr[i]) {
				csum=arr[i];
			}
			else
			{
				csum+=arr[i];
			}
			if(csum>osum) {
				osum=csum;
			}
		}
		
		return osum;
	}
}
