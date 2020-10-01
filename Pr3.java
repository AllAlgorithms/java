/* wajp to create a class AreaOverload w two areas circle and rect */

class AreaOverload 
{
public double area(double radius)
{
	double ans=3.14159* radius*radius;
	return ans;
}
public double area(double length,double width)
{
	double ans=length*width;
	return ans;
}}
class Pr3
{
public static void main(String args[])
{
AreaOverload a=new AreaOverload();
System.out.println("area of circle: "+a.area(1.5f,3.6f));
System.out.println("area of rect: "+a.area(2.4f));
}}