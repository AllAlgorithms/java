import java.lang.*;
import java.io.*;
class Isogram
 { 
     public static boolean Check(String s){
         HashSet<Character>h=new HashSet<>();
      for(int i=0;i<s.length();i++){
          if(h.contains(s.charAt(i))){
              
              return false;
          }
          else{
              h.add(s.charAt(i));
          }
      }
    return true;
         
     }
	public static void main (String[] args)
	 {
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int []arr;
		try{
		    String st=br.readLine();
		    int t=Integer.parseInt(st);
		    for(int i=0;i<t;i++){
		        String a=br.readLine();
		        boolean l=Check(a);
		        if(l==true){
		            System.out.println(1);
		        }
		        else{
		            System.out.println(0);
		        }
		    }
		   
		}
		catch(IOException e){ }
	 }
}