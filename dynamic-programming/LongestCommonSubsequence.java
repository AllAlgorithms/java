/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestCommonSubsequenc
{
    public static int lcs(char []x,char []y,int m,int n)
    {
        int l[][]= new int[m+1][n+1];
        
        for (int i=0;i<=m ;i++ )
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                {
                    l[i][j] = 0;
                }
                else if(x[i-1] == y[j-1]){
                    l[i][j] = l[i-1][j-1] + 1;
                }
                else{
                    l[i][j]=max(l[i-1][j],l[i][j-1]);
                }
            }
        }
        
        for (int i=0;i<=m ;i++ )
        {
            for(int j=0;j<=n;j++)
            {
                System.out.print(l[i][j]);
            }
            System.out.println();
        }
        return l[m][n];
    }
    
    public static int max(int a,int b)
    {
        return (a > b) ? a : b;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine(); //string 1
		String s2 = br.readLine(); //string 2
		
		char []x=s1.toCharArray();
		char []y=s2.toCharArray();
		
		int m=x.length;
		int n=y.length;
		
		System.out.println(lcs(x,y,m,n)); //gives longest common subsequence of given two strings
	}
}
