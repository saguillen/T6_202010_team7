package model.data_structures;

public class LinkedListImp<T extends Comparable<T>> {
	
	/**
	 * Atributos de la clase Doubly Linked List. 
	 */
	
	private Node<T> head;
	
	private Node<T> tail;
	
	
	public LinkedListImp()
	{
	}
	
	
	public Node<T> darPrimero()
	{
		return head;
	}
	
	public Node<T> darUltimo()
	{
		Node<T> actual = head;
		
		while(actual!= null && actual.darSiguiente()!=null) 
		{
			actual = actual.darSiguiente(); 
		}
		
		return actual;
		
	
	}
	
	public int size()
	{
		Node<T> actual = head;
		int contador = 0;
		while(actual.darSiguiente()!=null)
		{
			contador++;
			actual = actual.darSiguiente();
		}
		
		return contador;		
	}


	public long[] toArray() {
		
		return null;
	}
	

}
