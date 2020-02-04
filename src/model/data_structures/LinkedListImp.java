package model.data_structures;


public class LinkedListImp<T extends Comparable<T>> {
	
	/**
	 * Atributos de la clase Doubly Linked List. 
	 */
	
	private Node<T> head;
	
	private Node<T> tail;
	
	private int size;
	
	
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
		return size;		
	}
	
	public void insertarAlInicio(T nuevo)
	{
		if(head == null)
		{
			head = new Node<T>(nuevo, head, null);
			tail = head;
		}
		else
		{
			Node<T> aInsertar = new Node<T>(nuevo, head, null);
			aInsertar.cambiarSiguiente(head);
			head = aInsertar;
		}
		size++;
	}
	
	public void insertarAlFinal(T nuevo) 
	{
		if(head == null){
			head = new Node<T>(nuevo, null, null); 
			tail = head;
		}
		
		else
		{
			
			Node<T> aInsertar = new Node<T>(nuevo, null, tail);
			tail.cambiarSiguiente(aInsertar);
			aInsertar.cambiarAnterior(tail);
			tail = aInsertar;
		}
		size++;
	}
	
	public void eliminar()
	{
		
	}
	@Override
	//Implementation idea taken from:
	//https://stackoverflow.com/questions/19283083/printing-out-a-linked-list-using-tostring
	public String toString()
	{
		String result = "";
		Node<T> actual = head;
		while(actual.darSiguiente()!=null)
		{
			result += actual.darValor();
			if(actual.darSiguiente()!=null){
				result += ", ";
			}
			actual = actual.darSiguiente();
		}
		
		return "List: "+result;
		
	}

	public T toArray(T[] a) {
		
		return null;
	}
	

}
