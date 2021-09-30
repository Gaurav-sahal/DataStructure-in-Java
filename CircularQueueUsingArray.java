import java.util.Scanner;

public class CircularQueueUsingArray{

	private static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		System.out.print("Enter a size of circular queue: ");
		int size = sc.nextInt();
		CircularQueueOperation cqueue = new CircularQueueOperation(size);
		cqueue.printMenu(sc);
	}
}

class CircularQueueOperation{

	int front, rear, cirQueue[], max;

	public CircularQueueOperation(int size){
		front = -1;
		rear = -1;
		max = size;
		cirQueue = new int[size];
	}

	public void printMenu(Scanner sc){
		int choice = 0;
		while(choice != 4){
			System.out.println("\n~~~~~~ Circular Queue Using Array ~~~~~~\n");
			System.out.println("1. Insert an Element\n2. Delete an Element\n3. Display the Queue\n4. Exit\n");
			System.out.print("Enter your Choice: ");
			choice = sc.nextInt();
			switch(choice){
				case 1:
						insert(sc);
						break;
				case 2:
						delete();
						break;
				case 3:
						display();
						break;
				case 4:
						System.out.println("Application Closed!\n");
						break;
				default:
						System.out.println("Invalid Choice\n");
			}
		}
	}

	public void insert(Scanner sc){
		if((rear+1)%max == front){
			System.out.println("Queue Overflow!\n");
			return;
		}
		System.out.print("Enter an element: ");
		int ele = sc.nextInt();
		if(front == -1 && rear == -1){
			front = 0;
			rear = 0;
		}
		else if(rear == max-1 && front != 0){
			rear = 0;
		}
		else{
			rear = (rear+1) % max;
		}
		cirQueue[rear] = ele;
		System.out.println("Element "+ele+" Inserted Successfully\n");
	}

	public void delete(){
		if(front == -1 && rear == -1){
			System.out.println("Queue Underflow!\n");
			return;
		}
		if(front == rear){
			front = -1;
			rear = -1;
		}
		else if(front == max-1){
			front = 0;
		}
		else{
			front++;
		}
		System.out.println("Element deleted Successfully\n");
	}

	public void display(){
		if(front == -1 && rear == -1){
			System.out.println("Queue Underflow!\n");
			return;
		}
		int i = front;
		System.out.println("Circular Queue Elements are: ");
		while(i != rear){
			System.out.print(cirQueue[i]+" ");
			i++;
			if(i == max){
				i = 0;
			}
		}
		System.out.println(cirQueue[i]);
	}
}