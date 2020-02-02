package model.logic;


import model.data_structures.LinkedListImp;
import model.data_structures.Node;

/**
 * Definicion del modelo del mundo
 * @param <T>
 *
 */
public class Modelo<T extends Comparable<T>> {
	/**
	 * Atributos del modelo del mundo
	 */
	private LinkedListImp<T> comparendos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		comparendos = new LinkedListImp<T>();
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return comparendos.size();
	}
	
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Node<T> buscarPrimero()
	{
		return comparendos.darPrimero();
	}
	
	public Node<T> buscarUltimo()
	{
		return comparendos.darUltimo();
	}
	



}
