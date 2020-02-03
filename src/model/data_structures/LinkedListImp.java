package model.data_structures;

import java.util.Currency;

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
