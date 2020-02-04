package model.logic;

import java.io.FileReader;
import com.google.gson.stream.JsonReader;
import model.data_structures.LinkedListImp;
import model.data_structures.Node;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import model.data_structures.LinkedListImp;
import model.data_structures.Node;

/**
 * Definicion del modelo del mundo
 * @param <T>
 *
 */
public class Modelo<T extends Comparable<T>> 
{

	public void m()
	{
		JsonReader reader;
		String path = "./data/comparendos_dei_2018_small.geojson";
		Gson gson = new Gson();

		try {
			//importar arreglo dinamico. multa1.getNombre(); Clase Multa(?)
			reader = new JsonReader(new FileReader(path));
			Type collectionType = new TypeToken<LinkedListImp<String>>(){}.getType(); //Preguntar
			LinkedListImp<String> lista = gson.fromJson(reader, collectionType);      //Preguntar
//			System.out.println(lista.toString(lista.toArray()));//view.

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
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

	//LinkedList<Multa> lista = 
	//Multa head =  listademulta.getHead();
	// head.darNombre();

	public Node<T> buscarUltimo()
	{
		return comparendos.darUltimo();
	}

	public void darNombre(String pNombre)
	{
		//No tiene sentido solo es por poner ahora. 
	}

	public void darTamano(int pSize)
	{
		//^^^
	}

	//Crear Clase Multa???
}


