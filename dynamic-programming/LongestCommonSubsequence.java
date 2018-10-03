// Finding Longest Common Subsequence of Two Strings Using Dynamic Programming
import java.util.Scanner;
public class LongestCommonSubsequence
{
	int lcs(char[] X, char[] Y, int m, int n) 
	{
		int DP[][] = new int[m+1][n+1];
		// Bottom-Up Approach for dp 
		for(int i=0;i<=m;i++) 
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0 || j==0)
					DP[i][j]=0; 
				else if(X[i-1]==Y[j-1]) 
					DP[i][j]=DP[i-1][j-1]+1; 
			        else
					DP[i][j] = max(DP[i-1][j], DP[i][j-1]); 
			}
		}
		return DP[m][n]; 
	}
	int max(int a, int b) 
	{
		if(a>b)
			return a;
		else
			return b;
	} 
	public static void main(String[] args)
	{ 
		LongestCommonSubsequence obj=new LongestCommonSubsequence();
		String s1="",s2="";
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter 1st String");
		s1=scan.next();
		System.out.println("Enter 2nd String");
		s2=scan.next();
	  	char[] X=s1.toCharArray(); 
		char[] Y=s2.toCharArray(); 
		int m=X.length; 
		int n=Y.length; 
	  	System.out.println("Length of Longest Common Subsequence is: "+obj.lcs(X,Y,m,n)); 
	}  
} 