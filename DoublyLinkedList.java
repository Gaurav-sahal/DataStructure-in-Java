import java.util.Scanner;

class Node{
	Node prev;
	int data;
	Node next;

	public Node(int data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

public class DoublyLinkedList{

	public static void main(String args[]){
		new DoublyLLOperations().printMenu();
	}
}

class DoublyLLOperations{

	private static Scanner sc = new Scanner(System.in);
	public Node head = null;
	public Node tail = null;

	public void printMenu(){
		int choice = 0;
		while(choice != 10){
			System.out.println("\n~~~~~ DOUBLY LINKED LIST ~~~~~\n");
			System.out.println("1. Insert in Begining");
			System.out.println("2. Insert at last");
			System.out.println("3. Insert at any random location");
			System.out.println("4. Delete from begining");
			System.out.println("5. Delete from last");
			System.out.println("6. Delete an element");
			System.out.println("7. Search an element");
			System.out.println("8. Display all element from forward");
			System.out.println("9. Display all element from backward");
			System.out.println("10. Exit");
			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();
			switch(choice){
				case 1:
						insertion_beginning();
						break;
				case 2:
						insertion_last();
						break;
				case 3:
						insertion_specified();
						break;
				case 4:
						deletion_beginning();
						break;
				case 5:
						deletion_last();
						break;
				case 6:
						deletion_specified();
						break;
				case 7:
						search();
						break;
				case 8:
						forDisplay();
						break;
				case 9:
						backDisplay();
						break;
				case 10:
						System.out.println("\nApplication Closed!");
						break;
				default:
						System.out.println("Invalid Choice!!");
			}
		}
	}

	public void insertion_beginning(){
		System.out.println("Enter a number to add at HEAD");
		int ele = sc.nextInt();
		Node temp = new Node(ele);
		if(head == null){
			head = temp;
			tail = temp;
		}
		else{
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
		System.out.println("Node Inserted Successfully\n");
	}

	public void insertion_last(){
		System.out.println("Enter a number to add at LAST");
		int ele = sc.nextInt();
		Node temp = new Node(ele);
		if(head == null){
			head = temp;
			tail = temp;
		}
		else{
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
		System.out.println("Node Inserted Successfully\n");
	}

	public void insertion_specified(){
		System.out.println("At which location you want to insert?");
		int loc = sc.nextInt();
		if(loc < 0){
			System.out.println("Please Enter a valid location");
			return;
		}
		if(loc == 0){
			insertion_beginning();
			return;
		}
		Node currNode = head;
		for(int i=0; i<loc-1; i++){
			currNode = currNode.next;
			if(currNode == null){
				System.out.println("location is Out of Range");
				return;
			}
		}
		System.out.println("Enter a number to insert");
		int ele = sc.nextInt();
		Node temp = new Node(ele);
		temp.next = currNode.next;
		temp.prev = currNode;
		if(temp.next == null){
			tail = temp;
		}
		else{
			currNode.next.prev = temp;			
		}
		currNode.next = temp;
		System.out.println("Elemnt Inserted Successfully\n");
	}

	public void deletion_beginning(){
		if(head == null){
			System.out.println("List is Empty");
			return;
		}
		Node temp = head;
		head = head.next;
		if(head == null){
			tail = null;
		}
		else{
			head.prev = null;
		}
		temp.next = null;
		System.out.println("Item deleted Successfully\n");
	}

	public void deletion_last(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		Node temp = tail;
		tail = tail.prev;
		if(tail == null){
			head = null;
		}
		else{
			tail.next = null;
		}
		temp.prev = null;
		System.out.println("Item deleted Successfully\n");
	}

	public void deletion_specified(){
		if(head == null){
			System.out.println("List is Empty");
			return;
		}
		System.out.println("Enter the number which you want to delete: ");
		int ele = sc.nextInt();
		if(head.data == ele){
			head = head.next;
			if(head == null){
				tail = null;
			}
			else{
				head.prev = null;
			}
			System.out.println("Element "+ele+" deleted Successfully");
			return;
		}
		Node temp = head;
		while(temp.next != null){
			if(temp.next.data == ele){
				temp.next = temp.next.next;
				if(temp.next == null){
					tail = temp;
				}
				else{
					temp.next.prev = temp;
				}
				System.out.println("Element "+ele+" deleted Successfully");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Element not found in the list");
	}

	public void search(){
		if(head == null){
			System.out.println("List is Empty");
			return;
		}
		System.out.println("Enter an element to search");
		int ele = sc.nextInt();
		Node temp = head;
		while(temp != null){
			if(temp.data == ele){
				System.out.println("Element "+ele+" FOUND in the List\n");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Element "+ele+" NOT FOUND in the list\n");
	}

	public void forDisplay(){
		if(head == null){
			System.out.println("List is Empty");
			return;
		}
		System.out.print("From forward, List elements are: ");
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void backDisplay(){
		if(tail == null){
			System.out.println("List is Empty");
			return;
		}
		Node temp = tail;
		System.out.print("From backward, List elements are: ");
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.prev;
		}
		System.out.println();
	}

}
