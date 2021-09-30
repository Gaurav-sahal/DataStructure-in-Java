import java.util.*;

public class JavaLinkedList{

	private static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		LinkedList<Integer> ll = new LinkedList<Integer>();

		int choice = 0;
		while(choice != 34){
			System.out.println("\n~~~~~Java LinkedList Class~~~~~\n");
			System.out.println("1. boolean add(E e)");
			System.out.println("2. void add(int index, E element)");
			System.out.println("3. void addFirst(E e)");
			System.out.println("4. void addLast(E e)");
			System.out.println("5. void clear()");
			System.out.println("6. Object clone()");
			System.out.println("7. boolean contains(Object o)");
			System.out.println("8. Iterator<E> descendingIterator()");
			System.out.println("9. E element()");
			System.out.println("10. E get(int index)");
			System.out.println("11. E getFirst()");
			System.out.println("12. E getLast()");
			System.out.println("13. int indexOf(Object o)");
			System.out.println("14. int lastIndexOf(Object o)");
			System.out.println("15. boolean offer(E e)");
			System.out.println("16. boolean offerFirst(E e)");
			System.out.println("17. boolean offerLast(E e)");
			System.out.println("18. E peek()");
			System.out.println("19. E peekFirst()");
			System.out.println("20. E peekLast()");
			System.out.println("21. E poll()");
			System.out.println("22. E pollFirst()");
			System.out.println("23. E pollLast()");
			System.out.println("24. E pop()");
			System.out.println("25. void push(E e)");
			System.out.println("26. E remove()");
			System.out.println("27. E remove(int index)");
			System.out.println("28. boolean remove(Object o)");
			System.out.println("29. E removeFirst()");
			System.out.println("30. E set(int index, E element)");
			System.out.println("31. Object[] toArray()");
			System.out.println("32. int size()");
			System.out.println("33. Display Items");
			System.out.println("34. Exit");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Enter a choice\n");
			choice = sc.nextInt();
			switch(choice){
				case 1:
						System.out.println("Enter a number");
						int ele = sc.nextInt();
						System.out.println("Insertion Status "+ll.add(ele));
						break;
				case 2:
						System.out.println("Enter a number");
						ele = sc.nextInt();
						System.out.println("Enter an index to insert");
						int index = sc.nextInt();
						try{
							ll.add(index, ele);
						}
						catch(Exception e){
							System.out.println("Index OUT OF RANGE");
							continue;
						}
						System.out.println("Element Inserted Successfull");
						break;
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 11:
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:
				case 17:
				case 18:
				case 19:
				case 20:
				case 21:
				case 22:
				case 23:
				case 24:
				case 25:
				case 26:
				case 27:
				case 28:
				case 29:
				case 30:
				case 31:
				case 32:
				case 33:
						System.out.println(ll);
						break;
				case 34:
						System.out.println("Application Closed!\n");
						break;
				default:
						System.out.println("Invalid Choice");
			}
		}
	}
}