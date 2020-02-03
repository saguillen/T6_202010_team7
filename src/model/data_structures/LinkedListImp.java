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
	
	public int size()//Cuando se agrega uno aumentar 1 .
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
	
	public void agregarDatos()
	{
		
	}
	
	public void insertarAlInicio()
	{

	
	}
	
	public void insertarAlFinal() //noc
	{
		Node<T> actual = head;
		Node<T> aInsertar;
		
		while(actual!=null)
		{
			if(actual.darAnterior()!=null && actual.darSiguiente()==null)
				aInsertar = actual;
			actual = actual.darSiguiente();
		}
		
	}
	
	//Metodo agregar Datos.
	//La carga de datos se sube a un objeto de JSON.
	//Objetos multa que se meten en un nodo.
	//Lista encadenada maneja los objetos por dentro.
	//Apuntador a la cola. Agregar a la cola, para que se puedan agregar los datos. 
	
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
