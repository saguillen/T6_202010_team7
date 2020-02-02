package model.data_structures;

public class LinkedListImp <T extends Comparable<T>>{

	//atributos 
	
	private Node<T> Head;
	
	private Node<T> Tail;
	
	
	//metodos
	
	public Node<T> darPrimero()
	{
		return Head;
	}
	
	public Node<T> darUltimo()
	{
		Node<T> actual = Head;
		while (actual != null && actual.darSiguiente() != null)
		{
			actual = actual.darSiguiente();
		}
		return actual;
	}
	
	public int size()
	{
		Node<T> actual = Head;
		int count = 0;
		while (actual != null)
		{
			count++;
			actual =   actual.darSiguiente();
		}
		return count;
	}	

	
	
	
}
