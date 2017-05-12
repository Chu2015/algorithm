package search.hashSearchTable;

public class SequentialSearchST<Key,Value> {
	private class Node{
		Key key;
		Value value;
		Node next;
		public Node(Key key,Value value,Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	private Node first;
	
	public void put(Key key,Value value){
		if(first == null){
			first = new Node(key,value,null);
			return;
		}
		Node move = first;
		while(move != null){
			if(move.key == key){
				move.value = value;
				return;
			}
			move = move.next;
		}
		first = new Node(key,value,first);
	}
	
	public Value get(Key key){
		Node move = first;
		while(move != null && move.key != key){
			move = move.next;
		}
		return move.value;
	}
	
}
