import java.io.*;
import java.util.*;

public class HelloWorld {
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("Hello World");
		countDown(10);
		System.out.println(pow(3,4));
		Scanner input = new Scanner(System.in);
		Queue<String> x = new LinkedList<String>();
		x.add("a");
		x.add("b");
		x.add("c");
		mirror(x);
		
		
		System.out.println("names please");
		Stack<String> lastNames = new Stack<String>();
		
		String lastName = input.next();
		while(!lastName.equals("Quit")){
			lastNames.push(lastName);
			lastName = input.next();
		}
		//File in = null;
		//in = new File(fileName);
		//Scanner fileRead = new Scanner(Sys);
	
		/*
		while(fileRead.hasNextLine()){
		lastNames.push(fileRead.nextLine());
		}
		*/
		String store = "";
		Stack<String> lastNammes = new Stack<String>();
		while(!lastNames.isEmpty()){
			store = lastNames.pop();
			System.out.println(store);
			lastNammes.push(store);
			//lastNames.push(store);
		}
		while(!lastNammes.isEmpty()){
		lastNames.push(lastNammes.pop());
		}
		System.out.println("Size of lastnames group: " + lastNames.size());
		System.out.println(lastNames.peek());
	}
	public static void countDown(int x){
		if(x <= 1){
			System.out.println("1");
		}
		else{
			System.out.println(x);
			countDown(x-1);
			
		}
		
	}
	public static void mirror(Queue<String> x){
		Stack<String> store = new Stack<String>();
		Queue<String> orig = x;//new LinkedList<String>();
		//orig = x;
		while(!orig.isEmpty()){
			store.push(orig.remove());
		}
		while(!store.isEmpty()){
			x.add(store.pop());
		}
		int size = x.size(); 
		for(int i = 0; i < size; i++){
			String storage = x.remove();
		System.out.println(storage);
		x.add(storage);
		
		}
		
		
	}
	public static long pow(int x, int n){
		if(n == 0){
		return 1;
		}
		else{
		return x * pow(x, n -1);
		}
	}
	
}
