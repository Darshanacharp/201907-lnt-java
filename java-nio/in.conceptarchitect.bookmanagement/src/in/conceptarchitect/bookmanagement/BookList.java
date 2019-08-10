package in.conceptarchitect.bookmanagement;

public class BookList {
	
	
	class Node {
		
		public Book item;
		public Node next;
		public Node previous;

		public Node(Book item) {
			this.item=item;
		}
		

	}

	Node first,last;
	int count;
	public static final int POS_END=-1; 
	
	public void add(Book item) {
		Node node=new Node(item);
		node.next=null; // it will be the last node
		node.previous=last; //whoever is current last (may even be null for empty list)
		
		if(count==0)
			first=node; //this node is the first, last and the only node
		else
			last.next=node; //new node comes next to current last node
		
		last=node; //new node is now the last node of the list
		count++;
	}
	
	private Node locate(int pos) {
		if(pos<POS_END|| pos>=count)
			throw new IndexOutOfBoundsException("Invalid Index "+pos);
		
		if(pos==0)
			return first;
		else if(pos==count-1 || pos==-1)
			return last;
		
		Node n=first;
		
		for(int i=0;i<pos;i++)
			n=n.next;
		
		return n;
		
		
	}

	public Book get(int pos) {
		return locate(pos).item;
	}
	
	public void set(int pos, Book item) {
		locate(pos).item=item;
	}
	
	public Book remove(int pos) {
		
		
		
		Node d=locate(pos);  //find the node to be deleted
		
		if(d==first)
			first=d.next; //first will refere to next node
		else
			d.previous.next=d.next; //previous of deleted node shall point to next of deleted node
		
		if(d==last)
			last=d.previous; //last will be the second last node
		else
			d.next.previous=d.previous; //next of deleted node should point to previous of deleted node
		
		
		count--;
		
		return d.item; //return the value of deleted node.
		
		
		
	}
	
	public int size() {
		return count;
	}
	
	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		builder.append("StringList(\t");
		for(Node n=first;n!=null;n=n.next) {
			builder.append( n.item+"\t");
		}
		builder.append(")");
		return builder.toString();
	}
	
}
