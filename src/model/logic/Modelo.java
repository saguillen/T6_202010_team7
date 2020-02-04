package model.logic;

import java.io.FileReader;
import com.google.gson.stream.JsonReader;
import model.data_structures.LinkedListImp;
import model.data_structures.Multa;
import model.data_structures.Node;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


	public void ModeloJSON()
	{
		String path = "./data/comparendos_dei_2018_small.geojson";
		Gson gson = new Gson();
		JsonReader reader;
		try {
			LinkedListImp<T> lista = new LinkedListImp<>();
			//importar arreglo dinamico. multa1.getNombre(); Clase Multa(?)
			reader = new JsonReader(new FileReader(path));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray f = null;
			if(elem.getAsJsonObject().has("features") && !elem.getAsJsonObject().isJsonNull())
			{
				for(JsonElement featuresE: elem.getAsJsonObject().get("features").getAsJsonArray())
				{
					f.add(featuresE);
				}
			}
			for(JsonElement e : f)
			{
				String FechaHora = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();
				String Clase = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TipoS =  e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String Infra =  e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String Desc =  e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRA").getAsString();
				String Localidad =  e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				List<Double> geo = new ArrayList<>();
				if(e.getAsJsonObject().has("geometry") && !e.getAsJsonObject().get("geometry").isJsonNull())
				{
					for(JsonElement geoElem: e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray())
					{
						geo.add(geoElem.getAsDouble());
					}
					Multa m = new Multa(Clase, TipoS, Infra, Desc, Localidad, FechaHora, geo);
					lista.insertarAlInicio((T) m);
				}
			}

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


}



