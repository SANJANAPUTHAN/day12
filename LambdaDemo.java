package day12;

public class LambdaDemo {
public static void main(String[] args) {
	method1(new interfaceclass());
	method1(new interface1(){
		public void display1()
		{
			System.out.println("anonymous inner class...");
		}
	});
	method1(()->{System.out.println("lambda called.......");});
	method2((name,age)->{System.out.println(name +" "+age);});
	System.out.println(method3((name)->{return name;}));
}
public static void method1(interface1 i1)
{
	i1.display1();
}
public static void method2(interface2 i2)
{
	i2.display2("sanjana", 21);
}
public static String method3(interface3 i3)
{
	return i3.display3("anu");
}
}
interface interface1
{
	public void display1();
}
interface interface2
{
	public void display2(String name,int age);
}
interface interface3
{
	public String display3(String name);
}
class interfaceclass implements interface1
{
	 @Override
	public void display1() {
		 	System.out.println("outside block.......");
		
	}
}