import java.util.*;

public class JavaStack{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		Stack stack = new Stack();
		int choice = 0;
		while(choice != 9){
			System.out.println("\n~~~~~~ Java Stack Class ~~~~~~\n");
			System.out.println("1. empty()\n2. push(E item)\n3. pop()\n4. peek()\n5. search(Object o)\n6. Display (iterator())\n7. Display (forEach())\n8. Display (listIterator())\n9. Exit\n");
			System.out.print("Enter your Choice: ");
			choice = sc.nextInt();
			switch(choice){
				case 1:
						System.out.println("Stack Empty Status: "+ stack.empty()+"\n");
						break;
				case 2:
						System.out.print("Enter an element: ");
						int ele = sc.nextInt();
						stack.push(ele);
						System.out.println("Element Pushed Successfully\n");
						break;
				case 3:
						try{
							System.out.println("Element poped Successfully: "+stack.pop()+"\n");
						}
						catch(Exception e){
							System.out.println("Stack Underflow!\n");
						}
						break;
				case 4:
						try{
							System.out.println("Top element is: "+stack.peek()+"\n");
						}
						catch(Exception e){
							System.out.println("Stack Underflow!\n");
						}
						break;
				case 5:
						if(stack.empty()){
							System.out.println("Stack Underflow!\n");
							continue;
						}
						System.out.print("Enter an element to Search: ");
						ele = sc.nextInt();
						if(stack.search(ele) == -1){
							System.out.println("Element NOT found!");
						}
						else{
							System.out.println("Element FOUND");
						}
						break;
				case 6:
						if(stack.empty()){
							System.out.println("Stack Underflow!\n");
							continue;
						}
						System.out.print("[Iterator Method] Stack elements are: ");
						Iterator iterator = stack.iterator();  
						while(iterator.hasNext())  
						{  
							Object values = iterator.next();  
							System.out.print(values+" ");   
						}     
						System.out.println();
						break;
				case 7:
						if(stack.empty()){
							System.out.println("Stack Underflow!\n");
							continue;
						}
						System.out.print("[For Each Method] Stack elements are: ");
						stack.forEach(n ->{
							System.out.print(n+" ");
						});
						System.out.println();
						break;
				case 8:
						if(stack.empty()){
							System.out.println("Stack Underflow!\n");
							continue;
						}
						System.out.print("[listIterator Method] Stack elements are: ");
						ListIterator listIter = stack.listIterator(stack.size());
						while(listIter.hasPrevious()){
							Object values = listIter.previous();
							System.out.print(values+" ");
						}
						System.out.println();
						break;
				case 9:
						System.out.println("Application Closed!\n");
						break;
				default:
						System.out.println("Invalid Choice");
			}
		}
	}
}