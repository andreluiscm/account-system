
public class List
{
	
	Node head;

	public List()
	{
		super();
		
		System.out.println("An empty list " + this + " has been created");
	}
	
	void insertHead(Account account)
	{
		this.head = new Node(account , this.head);
		
		System.out.println("Account " + account + " has been inserted into the beginning of the list " + this);
	}
	
	void print()
	{
		System.out.println("Printing list " + this);
		
		if (isEmpty())
		{
			System.out.println("This list is empty");
		}
		else
		{
			for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.next)
			{
				if (currentNode.account instanceof LoyaltyAccount)
				{
					System.out.println("Node: " + currentNode + "\tAccount: " + (LoyaltyAccount) currentNode.account + "\tAccount Number: " + ((LoyaltyAccount) currentNode.account).number + "\tBalance: " + ((LoyaltyAccount) currentNode.account).balance + "\tBonus: " + ((LoyaltyAccount) currentNode.account).bonus);
				}
				else
				{
					System.out.println("Node: " + currentNode + "\tAccount: " + currentNode.account + "\tAccount Number: " + currentNode.account.number + "\tBalance: " + currentNode.account.balance);
				}
			}
		}
	}
	
	void recursivePrint(Node currentNode)
	{	
		if (this.head == currentNode)
		{
			System.out.println("Printing list " + this + " recursively");
			
			if (isEmpty())
			{
				System.out.println("This list is empty");
			}
		}
		
		if (currentNode != null)
		{
			if (currentNode.account instanceof LoyaltyAccount)
			{
				System.out.println("Node: " + currentNode + "\tAccount: " + (LoyaltyAccount) currentNode.account + "\tAccount Number: " + ((LoyaltyAccount) currentNode.account).number + "\tBalance: " + ((LoyaltyAccount) currentNode.account).balance + "\tBonus: " + ((LoyaltyAccount) currentNode.account).bonus);
			}
			else
			{
				System.out.println("Node: " + currentNode + "\tAccount: " + currentNode.account + "\tAccount Number: " + currentNode.account.number + "\tBalance: " + currentNode.account.balance);
			}
			
			recursivePrint(currentNode.next);
		}
	}
	
	void reversePrint(Node currentNode)
	{
		if (this.head == currentNode)
		{
			System.out.println("Printing reverse list " + this);
			
			if (isEmpty())
			{
				System.out.println("This list is empty");
			}
		}
		
		if (currentNode != null)
		{
			reversePrint(currentNode.next);
			
			if (currentNode.account instanceof LoyaltyAccount)
			{
				System.out.println("Node: " + currentNode + "\tAccount: " + (LoyaltyAccount) currentNode.account + "\tAccount Number: " + ((LoyaltyAccount) currentNode.account).number + "\tBalance: " + ((LoyaltyAccount) currentNode.account).balance + "\tBonus: " + ((LoyaltyAccount) currentNode.account).bonus);
			}
			else
			{
				System.out.println("Node: " + currentNode + "\tAccount: " + currentNode.account + "\tAccount Number: " + currentNode.account.number + "\tBalance: " + currentNode.account.balance);
			}
		}
	}
	
	boolean isEmpty()
	{
//		System.out.println("Is this list empty?");
		
		if (this.head == null)
		{
			return true;
		}
		
		return false;
	}
	
	Node search(String accountNumber, boolean showMessage)
	{
		if (showMessage)
		{
			System.out.println("Looking for account with number " + accountNumber + " in list " + this);
			
			if (isEmpty())
			{
				System.out.println("This list is empty");
			}
		}
		
		for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.next)
		{
			if (currentNode.account.number.equals(accountNumber))
			{
				if (showMessage)
				{
					System.out.println("Found");
					
					if (currentNode.account instanceof LoyaltyAccount)
					{
						System.out.println("Node: " + currentNode + "\tAccount: " + (LoyaltyAccount) currentNode.account + "\tAccount Number: " + ((LoyaltyAccount) currentNode.account).number + "\tBalance: " + ((LoyaltyAccount) currentNode.account).balance + "\tBonus: " + ((LoyaltyAccount) currentNode.account).bonus);
					}
					else
					{
						System.out.println("Node: " + currentNode + "\tAccount: " + currentNode.account + "\tAccount Number: " + currentNode.account.number + "\tBalance: " + currentNode.account.balance);
					}
				}
				
				return currentNode;
			}
		}
		
		if (showMessage)
		{
			System.out.println("Not found");
		}
		
		return null;
	}
	
	Node getPreviousNode(Node nextNode)
	{
		for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.next)
		{
			if (currentNode.next == nextNode)
			{
				return currentNode;
			}
		}
		
		return null;
	}
	
	void remove(String accountNumber)
	{
		System.out.println("Looking for account with number " + accountNumber + " to be removed from the list " + this);
		
		if (isEmpty())
		{
			System.out.println("This list is empty");
		}
		else
		{
			Node nodeToRemove = search(accountNumber, false);
			
			if (nodeToRemove != null)
			{
				if (nodeToRemove == this.head)
				{
					this.head = this.head.next;
				}
				else
				{
					Node fatherNode = getPreviousNode(nodeToRemove);
					fatherNode.next = nodeToRemove.next;					
				}
				
				System.out.println("Found");
				
				if (nodeToRemove.account instanceof LoyaltyAccount)
				{
					System.out.println("Node: " + nodeToRemove + "\tAccount: " + (LoyaltyAccount) nodeToRemove.account + "\tAccount Number: " + ((LoyaltyAccount) nodeToRemove.account).number + "\tBalance: " + ((LoyaltyAccount) nodeToRemove.account).balance + "\tBonus: " + ((LoyaltyAccount) nodeToRemove.account).bonus);
				}
				else
				{
					System.out.println("Node: " + nodeToRemove + "\tAccount: " + nodeToRemove.account + "\tAccount Number: " + nodeToRemove.account.number + "\tBalance: " + nodeToRemove.account.balance);
				}
				
				nodeToRemove = null;
			}
			else
			{
				System.out.println("Not found");
			}
		}
	}
	
	void recursiveRemove(String accountNumber, Node previousNode, Node currentNode)
	{
		if (this.head == currentNode)
		{
			System.out.println("Looking for account with number " + accountNumber + " to be removed recursively from the list " + this);			
		}
		
		if (isEmpty())
		{
			System.out.println("This list is empty");
		}
		else
		{
			if (currentNode != null)
			{
				if (currentNode.account.number.equals(accountNumber))
				{
					if (previousNode == null)
					{
						this.head = currentNode.next;
					}
					else
					{
						previousNode.next = currentNode.next;
					}
					
					System.out.println("Found");
					
					if (currentNode.account instanceof LoyaltyAccount)
					{
						System.out.println("Node: " + currentNode + "\tAccount: " + (LoyaltyAccount) currentNode.account + "\tAccount Number: " + ((LoyaltyAccount) currentNode.account).number + "\tBalance: " + ((LoyaltyAccount) currentNode.account).balance + "\tBonus: " + ((LoyaltyAccount) currentNode.account).bonus);
					}
					else
					{
						System.out.println("Node: " + currentNode + "\tAccount: " + currentNode.account + "\tAccount Number: " + currentNode.account.number + "\tBalance: " + currentNode.account.balance);
					}
					
					currentNode = null;
				}
				else
				{
					recursiveRemove(accountNumber, currentNode, currentNode.next);
				}
			}
			else
			{
				System.out.println("Not found");
			}
		}
	}
	
	List free()
	{
		System.out.println("Deallocating memory from the list " + this);

		Node previousNode;
		Node currentNode = this.head;
		
		while (currentNode != null)
		{
			previousNode = currentNode;
			
			currentNode = currentNode.next;
			
			previousNode = null;
		}

		return null;
	}
	
}
