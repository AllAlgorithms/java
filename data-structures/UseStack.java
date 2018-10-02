class Stack
{
	int stcksize=100;
	int stck[] = new int[stcksize];
	int tos;
	Stack() 
	{
		tos=-1;
	}
	void push(int item) 
	{
		if(tos==stcksize-1)
			System.out.println("Stack Overflow");
		else
			stck[++tos]=item;
	}
	int pop()
	{
		if(tos<0)
		{
			System.out.println("Stack Underflow.");
			return 0;
		}
		else
			return stck[tos--];
	}
}
public class UseStack
{
	public static void main(String args[])
	{
		Stack s=new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.pop(); // return 3 as it was the last inserted element
	}
}