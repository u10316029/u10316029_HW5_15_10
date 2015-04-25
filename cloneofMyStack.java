/*U10316029
 * 郭政慶
 */
import java.util.ArrayList;

public class cloneofMyStack{
	/**main method*/
	public static void main(String[] args){
		MyStack test = new MyStack();//New a type of MyStack object
		
		test.push(new Fruit("apple", "Taiwan", 10));//Add a new element
		test.push(new Fruit("banana", "Japan", 20));//Add a new element
		test.push(new Fruit("cherry", "China", 30));//Add a new element
		
		MyStack cloneoftest = new MyStack();//New another type of MyStack object
		
		cloneoftest = (MyStack) test.clone();//Clone the object "test"
		
		System.out.println("list中的所有elements :");
		
		System.out.println(test.list.toString());//Display the every element in the test
		
		System.out.println("list在element=0時顯示 :");
		
		System.out.println(test.list.get(0).toString());//Display the String where element is 0 in the test
		
		System.out.println("深層複製的list2 :");
		
		System.out.println(cloneoftest.list.get(0).toString());//Display the String in the clone of test
		
		test.list.get(0).price = 99;//Change the "price" in the test
		
		System.out.println("list改變其element=0中的price時顯示 :");
		
		System.out.println(test.list.get(0).toString());//Display the String where element is 0 in the test after it changes
		
		System.out.println("list2不會受影響 :");
		
		System.out.println(cloneoftest.list.get(0).toString());//Display the String in the clone of test
		if(test.list!=cloneoftest.list){//Judge whether both memory address are the same
			System.out.println("\nlist和list2在記憶體的位置不同");
		}
	}
}
class MyStack implements Cloneable{
	
	ArrayList<Fruit> list = new ArrayList<Fruit>();//Create a arraylist
	
	public int getSize(){
		return list.size();
	}
	public Object peek(){
		return list.get(getSize()-1);
	}
	public Object pop(){
		Object a =list.get(getSize()-1);
		list.remove(getSize()-1);
		return a;
	}
	public void push(Fruit a){
		list.add(a);
	}
	@Override
	public Object clone(){
		try{
			MyStack clone1 = (MyStack)super.clone();
			clone1.list =  (ArrayList<Fruit>)this.list.clone();//Clone the list
			for(int i=0; i<list.size(); i++){//Clone the every element in the arraylist
				clone1.list.set(i, new Fruit(this.list.get(i).name, this.list.get(i).country, this.list.get(i).price));
			}
			return clone1;
			}
		catch (Exception e){
				return null;
		 }
	}
}

class Fruit {
	String country;
	String name;
	int price;
	Fruit(){}//A no-arg constructor
	Fruit(String name,String country,int price){//Create a constructor with specific name,country,price
		this.name = name;
		this.country = country;
		this.price = price;
	}
	@Override
	public String toString(){
		return "The fruit is " + name+", and it is from "+country+". The price : "+price+" dollars。";
	}
}
