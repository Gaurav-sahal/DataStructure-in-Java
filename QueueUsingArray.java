import java.util.Scanner;

public class QueueUsingArray{

	private static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		System.out.println("Set the size of queue");
		int size = sc.nextInt();
		QueueOperation queue = new QueueOperation(size);
		queue.printMenu(sc);
	}
}

class QueueOperation{

	int front, rear, maxSize;
	int queue[];	// = new int[maxSize];

	public QueueOperation(int maxSize){
		front = -1;
		rear = -1;
		queue = new int[maxSize];
		this.maxSize = maxSize;
	}

	public void printMenu(Scanner sc){
		int choice = 0;
		while(choice != 4){
			System.out.println("\n~~~~~~ Queue Using Array ~~~~~~\n");
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
		if(rear == maxSize -1){
			System.out.println("Queue Overflow!\n");
			return;
		}
		System.out.print("Enter a number: ");
		int ele = sc.nextInt();
		if(front == -1 && rear == -1){
			front = 0;
			rear = 0;
		}
		else{
			rear++;
		}
		queue[rear] = ele;
		System.out.println("Element "+ele+" inserted Successfully\n");
	}

	public void delete(){
		if(front == -1 || front > rear){
			System.out.println("Stack Underflow!\n");
			return;
		}
		int ele = queue[front];
		front++;
		if(front > rear){
			front = -1;
			rear = -1;
		}
		System.out.println("Element "+ele+" has deleted\n");
	}

	public void display(){
		if(front == -1 || front > rear){
			System.out.println("Stack Underflow!\n");
			return;
		}
		int i = front;
		System.out.print("Queue elements are: ");
		while(i <= rear){
			System.out.print(queue[i]+" ");
			i++;
		}
		System.out.println();
	}
}