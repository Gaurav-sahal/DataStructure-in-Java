import java.util.Scanner;

class Node{
	int data;
	Node next;
	public Node(int data){
		this.data = data;
		this.next = null;
	}
}

public class QueueUsingLL{

	private static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		QueueOperationLL queue = new QueueOperationLL();
		queue.printMenu(sc);
	}
}

class QueueOperationLL{
	Node front, rear;

	public QueueOperationLL(){
		this.front = null;
		this.rear = null;
	}

	public void printMenu(Scanner sc){
		int choice = 0;
		while(choice != 4){
			System.out.println("\n~~~~~~ Queue Using LinkedList ~~~~~~\n");
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
		System.out.print("Enter an element to INSERT: ");
		int ele = sc.nextInt();
		Node temp = new Node(ele);
		if(front == null){
			front = temp;
			rear = temp;
		}
		else{
			rear.next = temp;
			rear = temp;
		}
		System.out.println("Element "+ele+" Inserted Succesfully\n");
	}

	public void delete(){
		if(front == null){
			System.out.println("Queue Underflow!\n");
			return;
		}
		Node temp = front;
		front = front.next;
		if(front == null){
			rear = null;
		}
		temp.next = null;
		System.out.println("Element "+temp.data+" deleted Successfully\n");
	}

	public void display(){
		if(front == null){
			System.out.println("Queue Underflow! Can't display anything\n");
			return;
		}
		Node temp = front;
		System.out.print("Queue Items are: ");
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}