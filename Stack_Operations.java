import java.util.Scanner;

public class Stack_Operations{

	public static void main(String args[]){
		StackClass stack = new StackClass();
		Scanner sc = new Scanner(System.in);
		int choice =0;
		while(choice != 5){
			System.out.println("~~~~~~Stack Operations Using Arrays~~~~~~\n");
			System.out.println("1. Push\n2. Pop\n3. Peek\n4. Show\n5. Exit\n");
			System.out.println("Enter your Choice: ");
			choice = sc.nextInt();
			switch(choice){
				case 1:
						stack.push(sc);
						break;
				case 2:
						stack.pop();
						break;
				case 3:
						stack.peek();
						break;
				case 4:
						stack.show();
						break;
				case 5:
						System.out.println("Application Closed!");
						break;
				default:
						System.out.println("Invalid Choice");
			}
		}
	}
}


class StackClass{

	int top, maxSize = 10;
	int arr[] = new int[maxSize];

	public StackClass(){
		top = -1;
	}

	public void push(Scanner sc){
		if(top == maxSize-1){
			System.out.println("Stack Overflow!");
			return;
		}
		System.out.println("Enter an element to PUSH");
		int ele = sc.nextInt();
		top++;
		arr[top] = ele;
		System.out.println("Element Inserted Successfully");
	}

	public void pop(){
		if(top == -1){
			System.out.println("Stack Underflow!");
			return;
		}
		top--;
		System.out.println("Item Popped Successfully");
	}

	public void peek(){
		if(top == -1){
			System.out.println("Stack Underflow!");
			return;
		}
		System.out.println("Top element of Stack is: "+arr[top]+"\n");
	}

	public void show(){
		if(top == -1){
			System.out.println("Stack is empty!");
			return;
		}
		int i = top;
		System.out.print("Stack elements are: ");
		while(i >= 0){
			System.out.print(arr[i]+" ");
			i--;
		}
		System.out.println();
	}
}