import java.util.Scanner;

class Node{
	int data;
	Node next;

	public Node(int data){
		this.data = data;
		this.next = null;
	}
}

public class SinglyLinkedList{

	private static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){

		SinglyLinkedList sList = new SinglyLinkedList();
		int choice = 0;
		while(choice != 5){
			System.out.println();
			System.out.println("\t~~~~~ SinglyLinkedList ~~~~~\t");
			System.out.println("1. Element Insertion at Beginning");
			System.out.println("2. Insert Element at a location");
			System.out.println("3. Add Element to end");
			System.out.println("4. Display Linkedlist Items");
			System.out.println("5. Exit");
			System.out.println("6. Delete head Item");
			System.out.println("7. Delete last Item");
			System.out.println("8. Delete an element");
			System.out.println("9. Show Head element");
			System.out.println("10. Show Tail element");
			System.out.println("11. Search an Element");
			System.out.println("12. Search an Nth index");
			System.out.println("13. Find number of Occurance of an element");
			System.out.println("14. Min & Max Element");
			System.out.print("\nEnter your Choice: ");
			choice = sc.nextInt();
			switch(choice){
				case 1:
						sList.begInsert();
						break;
				case 2:
						sList.insert();
						break;
				case 3:
						sList.addNode();
						break;
				case 4:
						sList.display();
						break;
				case 5:
						System.out.println("Application Closed!");
						break;
				case 6:
						sList.begin_delete();
						break;
				case 7:
						sList.last_delete();
						break;
				case 8:
						sList.delete();
						break;
				case 9:
						if(sList.head == null){
							System.out.println("List is empty");
							continue;
						}
						System.out.println("Head item is: "+sList.head.data);
						break;
				case 10:
						if(sList.tail == null){
							System.out.println("List is empty");
							continue;
						}
						System.out.println("Tail item is: "+sList.tail.data);
						break;
				case 11:
						sList.search();
						break;
				case 12: 
						sList.search(0);
						break;
				case 13: 
						sList.countOccurances();
						break;
				case 14: 
						sList.min_max();
						break;
				default:
						System.out.println("Error Choice: Try Again");
			}
		}
		
	}

	public Node head = null;
	public Node tail = null;

	public void begInsert(){
		System.out.println("Insertion in Begining\n");
		System.out.print("Enter an element: ");
		int ele = sc.nextInt();
		Node temp = new Node(ele);
		temp.next = head;
		head = temp;
		if(head.next == null){
			tail = head;
		}
		System.out.println("Element Inserted Successfully");
	}

	public void addNode(){
		System.out.println("Enter an element to add");
		int ele = sc.nextInt();
		Node temp = new Node(ele);

		if(head == null){
			head = temp; 
			tail = temp;
		}
		else{
			tail.next = temp;
			tail = temp;
		}
		System.out.println("Element added Successfully");
	}

	public void insert(){
		System.out.println("Enter an element to Insert");
		int ele = sc.nextInt();
		Node temp = new Node(ele);
		System.out.println("Enter a location to insert the Item");
		int loc = sc.nextInt();
		Node currNode = head;
		if(loc == 0){
			temp.next = head;
			head = temp;
			System.out.println("Element Inserted Successfully");
		}
		else if(loc > 0){
			for(int i=0; i<loc-1; i++){
				currNode = currNode.next;
				if(currNode == null){
					System.out.println("Element can't be inserted");
					return;
				}
			}
			temp.next = currNode.next;
			currNode.next = temp;
			if(temp.next == null){
				tail = temp;
			}
			System.out.println("Element Inserted Successfully");
		}
		else{
			System.out.println("Location not found");
		}
	}

	public void begin_delete(){
		if(head == null){
			System.out.println("List is Empty");
			return;
		}
		head = head.next;
		System.out.println("Head element Deleted\n");
	}

	public void last_delete(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		else if(head.next == null){
			head = null;
			tail = null;
			System.out.println("Element deleted Successfully");
		}
		else{
			Node temp = head;
			while(temp.next != tail){
				temp = temp.next;
			}
			temp.next = null;
			tail = temp;
			System.out.println("Element deleted Successfully");
		}
	}

	public void delete(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		System.out.println("Enter the element which you want to delete");
		int ele = sc.nextInt();
		Node temp = head;
		if(head.data == ele){
			if(head.next == null){
				tail = null;
			}
			head = head.next;
			System.out.println("Element "+ele+" deleted Successfully");
			return;
		}
		while(temp != null){
			if(temp.next.data == ele){
				if(temp.next == tail){
					tail = temp;
				}
				temp.next = temp.next.next;
				System.out.println("Element "+ele+" deleted Successfully");				
				return;
			}
			temp = temp.next;
		}
		System.out.println("The element "+ele+" is not present in the list");
	}

	public void search(){
		if(head == null){
			System.out.println("List is Empty, Can't Search anything");
			return;
		}
		System.out.println("Enter an element to search");
		int ele = sc.nextInt();
		Node temp = head;
		while(temp != null){
			if(temp.data == ele){
				System.out.println("Element "+ele+" is present in the list");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Element is not present in the List");
	}

	public void search(int n){
		if(head == null){
			System.out.println("List is Empty, Can't Search anything");
			return;
		}
		System.out.println("Enter Nth index: ");
		int ind = sc.nextInt();
		Node temp = head;
		for(int i=0; temp != null; temp=temp.next, i++){
			if(i==ind){
				System.out.println("Node Present at index = "+ind +", Node data: "+ temp.data);
				return;
			}
		}
		System.out.println("Node not found!");
	}

	public void display(){
		Node current = head;

		if(head == null){
			System.out.println("List is Empty");
			return;
		}
		System.out.print("Nodes of SinglyLinkedList are: ");
		while(current != null){
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}

	public void countOccurances(){
		if(head == null){
			System.out.println("List is Empty");
			return;
		}
		System.out.println("Enter an element to find its occurances");
		int ele = sc.nextInt();
		Node temp = head;
		int count = 0;
		while(temp != null){
			if(temp.data == ele){
				count++;
			}
			temp = temp.next;
		}
		System.out.println("Occurence of element "+ele +" = "+ count);
	}

	public void min_max(){
		if(head == null){
			System.out.println("List is Empty");
			return;
		}
		Node temp = head;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		while(temp != null){
			if(temp.data>)
			temp = temp.next;
		}
	}

}