package model.data_structures;

public class Node<T extends Comparable<T>> {

	
	
	private Node<T> siguiente;
	
	private Node<T> anterior;

	private int valor;
	
	public Node( int pValor)
	{
		anterior = null;
		siguiente = null;
		valor = pValor;
		
	}
	
	public Node<T> darSiguiente()
	{
		return siguiente;
	}
	
	public Node<T> darAnterior()
	{
		return anterior;
	}
	
	
	
}
