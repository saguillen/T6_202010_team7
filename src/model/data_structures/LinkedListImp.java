package model.data_structures;


public class LinkedListImp<T extends Comparable<T>> {
	
	/**
	 * Atributos de la clase Doubly Linked List. 
	 */
	
	private Node<T> head;
	
	private Node<T> tail;
	
	private int size;
	
	private LinkedListImp<T> multas = new LinkedListImp<>();
	
	public LinkedListImp<T> darMultas()
	{
		return multas;
	}
	
	public void setMultas(LinkedListImp<T> multa)
	{
		this.multas = multa;
	}
	
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
	
	//Implementar, puede ser usado en otros talleres y proyectos.
	public void eliminar()
	{
		//Falta implementacion
		size--;
	}

	public Object toArray() {
		// TODO Auto-generated method stub
		return null;
	}


}
