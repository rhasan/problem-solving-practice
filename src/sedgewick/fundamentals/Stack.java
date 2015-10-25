package sedgewick.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;




public class Stack<Item> implements Iterable<Item> {
	private Node<Item> first;
	private int N;
	
	@SuppressWarnings("hiding")
	private class Node<Item> {
		private Item item;
		private Node<Item> next;
	}
	
	public Stack() {
		first = null;
		N = 0;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		Node<Item> node = new Node<Item>();
		node.item = item;
		node.next = first;
		N++;
		first = node;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node<Item> current = first;
		
		@Override
		public boolean hasNext() {
			return current.next != null;
		}

		@Override
		public Item next() {
			
			if(!hasNext()) {
				throw new NoSuchElementException("There is no next element");
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }	

}
