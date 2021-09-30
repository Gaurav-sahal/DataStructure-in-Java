import java.util.Scanner;

class treeNode{
	treeNode left;
	int data;
	treeNode right;

	public treeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinarySearchTree{

	private static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		BinarySearchTreeOperation bst = new BinarySearchTreeOperation();
		bst.printMenu(sc);
	}
}

class BinarySearchTreeOperation{

	treeNode root;

	public BinarySearchTreeOperation(){
		this.root = null;
	}

	public void printMenu(Scanner sc){
		int choice = 0;
		while(choice != 4){
			System.out.println("\n~~~~~~ Binary Search Tree using LinkedList ~~~~~~\n");
			System.out.println("1. Insert an Element\n2. Delete an Element\n3. Inorder Traversal\n4. Exit\n5. Preorder Traversal\n6. Postorder Traversal\n7. Search a key");
			System.out.print("Enter your Choice: ");
			choice = sc.nextInt();
			switch(choice){
				case 1:
						insert(sc);
						break;
				case 2:
						delete(sc);
						break;
				case 3:
						inorderTraversal(this.root);
						break;
				case 4:
						System.out.println("Application Closed!\n");
						break;
				case 5:
						preorderTraversal(this.root);
						break;
				case 6:
						postorderTraversal(this.root);
						break;
				case 7:
						search(sc);
						break;
				default:
						System.out.println("Invalid Choice\n");
			}
		}
	}

	public void insert(Scanner sc){
		System.out.print("Enter a number: ");
		int ele = sc.nextInt();
		root = add(root, ele);
		System.out.println("Element "+ele+" Inserted Successfully\n");
	}

	private treeNode add(treeNode Root, int data){
		if(Root == null){
			Root = new treeNode(data);
			return Root;
		}
		if(data < Root.data){
			Root.left = add(Root.left, data);
		}
		else if(data > Root.data){
			Root.right = add(Root.right, data);
		}
		return Root;
	}

	public void inorderTraversal(treeNode root){
		if(root == null){
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);
	}

	public void preorderTraversal(treeNode root){
		if(root == null){
			return;
		}
		System.out.print(root.data+" ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	public void postorderTraversal(treeNode root){
		if(root == null){
			return;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data+" ");
	}

	public void search(Scanner sc){
		System.out.print("Enter an element to Search: ");
		int ele = sc.nextInt();
		if(search(root,ele) != null){
			System.out.println("Element "+ele+" found!");
		}
		else{
			System.out.println("Element NOT found!");
		}
	}

	private treeNode search(treeNode root, int ele){
		if(root == null || root.data == ele){
			return root;
		}
		if(ele < root.data) {
			return search(root.left, ele);
		}
		return search(root.right, ele);
	}

	public void delete(Scanner sc){
		System.out.print("Enter an element to delete: ");
		int ele = sc.nextInt();
		if(search(root, ele) != null){
			delete(root, ele);
			System.out.println("Element "+ele+" deleted Successfully");
		}
		else{
			System.out.println("Error Occured!");
		}
	}

	private treeNode delete(treeNode root, int ele){
		if(root == null){
			return root;
		}
		if(ele < root.data){
			root.left = delete(root.left, ele);
		}
		else if(ele > root.data){
			root.right = delete(root.right, ele);
		}
		else{
			if(root.left == null){
				return root.right;
			}
			else if(root.right == null){
				return root.left;
			}
			root.data = minVal(root.right);
			root.right = delete(root.right, root.data);
		}
		return root;
	}

	private int minVal(treeNode root){
		int minval = root.data;
		while(root.left != null){
			minval = root.left.data;
			root = root.left;
		}
		return minval;
	}
}