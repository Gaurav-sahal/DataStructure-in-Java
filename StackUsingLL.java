import java.util.Scanner;

public class StackUsingLL{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		StackAsLL stack = new StackAsLL();
		int choice = 0;
		while(choice != 7){
			System.out.println("\n~~~~~~ Stack Implementation Using LinkedList ~~~~~~\n");
			System.out.println("1. isEmpty()\n2. push(E item)\n3. pop()\n4. peek()\n5. search(Object o)\n6. Display Stack Element\n7. Exit\n");
			System.out.print("Enter your Choice: ");
			choice = sc.nextInt();
			switch(choice){
				case 1:
						stack.isEmpty();
						break;
				case 2:
						stack.push(sc);
						break;
				case 3:
						stack.pop();
						break;
				case 4:
						stack.peek();
						break;
				case 5:
						stack.search(sc);
						break;
				case 6:
						stack.display();
						break;
				case 7:
						System.out.println("Application Closed!\n");
						break;
				default:
						System.out.println("Invalid Choice");
			}
		}
		
	}
}

class StackNode{
	int data;
	StackNode next;

	public StackNode(int data){
		this.data = data;
		this.next = null;
	}
	
}

class StackAsLL{

	public StackNode top = null;

	public void isEmpty(){
		if(top == null){
			System.out.println("Yes, the Stack is Empty");
		}
		else{
			System.out.println("No, the Stack is not Empty");
		}
	}

	public void push(Scanner sc){
		System.out.println("Enter a number to PUSH");
		int ele = sc.nextInt();
		StackNode node = new StackNode(ele);
		if(top == null){
			top = node;
		}
		else{
			node.next = top;
			top = node;
		}
		System.out.println("Element "+ele+" Pushed");
	}

	public void pop(){
		if(top == null){
			System.out.println("Stack UnderFlow!");
			return;
		}
		StackNode node = top;
		top = top.next;
		node.next = null;
		System.out.println("Item Poped!\n");
	}

	public void peek(){
		if(top == null){
			System.out.println("Stack UnderFlow!");
			return;
		}
		System.out.println("Top Element is: "+top.data+"\n");
	}

	public void search(Scanner sc){
		if(top == null){
			System.out.println("Stack UnderFlow! Can't Search element");
			return;
		}
		System.out.println("Enter an element to SEARCH");
		int ele = sc.nextInt();
		StackNode temp = top;
		while(temp != null){
			if(temp.data == ele){
				System.out.println("Element "+ele+" is present in the Stack");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Element NOT FOUND\n");
	}

	public void display(){
		if(top == null){
			System.out.println("Stack UnderFlow!\n");
			return;
		}
		StackNode temp = top;
		System.out.print("Stack elements are: ");
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}