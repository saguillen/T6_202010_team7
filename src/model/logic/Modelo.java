package model.logic;

import java.io.FileReader;
import com.google.gson.stream.JsonReader;
import model.data_structures.LinkedListImp;
import model.data_structures.Multa;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo
{
	LinkedListImp<Multa> lista = new LinkedListImp<>();

	private Multa[] multasArr;
	private static Comparable[] aux; 

	public LinkedListImp<Multa> ModeloJSON() throws FileNotFoundException
	{
		String path = "./data/comparendos_dei_2018_small.geojson";
		JsonReader reader;

		try{

			reader = new JsonReader(new FileReader(path));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray features = elem.getAsJsonObject().get("features").getAsJsonArray();
			for(JsonElement e : features)
			{
				JsonElement properties = e.getAsJsonObject().get("properties");

				String id = properties.getAsJsonObject().get("OBJECTID").getAsString();
				String fechaHora = properties.getAsJsonObject().get("FECHA_HORA").getAsString();
				String clase = properties.getAsJsonObject().get("CLASE_VEHI").getAsString();
				String tipo = properties.getAsJsonObject().get("TIPO_SERVI").getAsString();
				String infrac = properties.getAsJsonObject().get("INFRACCION").getAsString();
				String descr = properties.getAsJsonObject().get("DES_INFRAC").getAsString();
				String localidad = properties.getAsJsonObject().get("LOCALIDAD").getAsString();


				List<Double> geo = new ArrayList<>();
				if(e.getAsJsonObject().has("geometry") && !e.getAsJsonObject().get("geometry").isJsonNull())
				{
					for(JsonElement geoElem : e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()){					
						geo.add(geoElem.getAsDouble());
					}
				}

				Multa m = new Multa(clase, tipo, infrac, descr, localidad, fechaHora, geo, id);

				lista.insertarAlFinal(m);
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		copiarComparendos();
		return lista;

	}

	public Comparable<Multa>[] copiarComparendos(){
		multasArr = new Multa[lista.size()];
		for(int i = 0; i < lista.size(); i++)
		{
			Multa multa =lista.darActual(i).darValor();
			multasArr[i]= multa;
		}

		return multasArr;
	}

	public Multa buscar(String id) 
	{
		for(Multa m : lista){
			if(id == null){
				return null;
			}
			else if(m.darId() == id)
			{
				return m;
			}
		}

		return null;
	}


	public void Shellsort(Comparable[] datos) {
		int n = datos.length;
		int h = 1;
		while (h < n/3) h = 3*h + 1; 

		while (h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h && (datos[j].compareTo( datos[j-h])>0); j -= h) {
					Comparable t = datos[j];
					datos[j] = datos[j-h];
					datos[j-h] = t;
				}
			}
			assert isHsorted(datos, h); 
			h /= 3;
		}
		assert isSorted(datos);
	}

	public static void sort(Comparable[] a)   {     
		aux = new Comparable[a.length];    // Allocate space just once.      
		sort(a, 0, a.length - 1);   
	} 

	public static  void merge(Comparable[] a, int lo, int mid, int hi)
	{  // Merge a[lo..mid] with a[mid+1..hi].   
		//		Comparable[] aux = null ;
		int i = lo, j = mid+1;   
		for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].      
		{
			aux[k] = a[k];
		}   
		for (int k = lo; k <= hi; k++)  // Merge back to a[lo..hi].      
		{
			if(i > mid)              
			{
				a[k] = aux[j++];
			}

			else if (j > hi ){              
				{
					a[k] = aux[i++];
				}
			}
			else if ((aux[j].compareTo( aux[i])>0)){ 
				{a[k] = aux[j++];}      }
			else  {                         
				a[k] = aux[i++]; }
		}
	}
	

	private static void sort(Comparable[] a, int lo, int hi)   {  // Sort a[lo..hi].      
		if (hi <= lo) return;      
		int mid = lo + (hi - lo)/2;      
		sort(a, lo, mid);       // Sort left half.      
		sort(a, mid+1, hi);     // Sort right half.      
		merge(a, lo, mid, hi);  // Merge results (code on page 271).   } 
	}


	private static boolean   less(Comparable v, Comparable w)   
	{  return v.compareTo( w) < 0;  }

	private static void exch(Comparable[] a, int i, int j)  
	{  Comparable t = a[i]; a[i] = a[j]; a[j] = t;  } 


	public static boolean isSorted(Comparable<Multa>[] datos)   {  // Test whether the array entries are in order.     
		for (int i = 1; i < datos.length; i++)        
			if (datos[i].compareTo((Multa) datos[i-1])>0)
			{
				return false;    }
		return true;   }

	private static boolean isHsorted(Comparable[] a, int h) {
		for (int i = h; i < a.length; i++)
			if (less(a[i], a[i-h])) return false;
		return true;
	}
}






