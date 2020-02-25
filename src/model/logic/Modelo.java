package model.logic;

import java.awt.desktop.SystemSleepEvent;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.data_structures.LinkedListImp;
import model.data_structures.Multa;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import model.data_structures.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	LinkedListImp<Multa> lista = new LinkedListImp<>();
	private Multa[] multasArr;

	public LinkedListImp<Multa> ModeloJSON() throws FileNotFoundException {
		BufferedReader br = null;
		String path = "./data/comparendos_dei_2018_small.geojson";
//		JsonReader reader;

		try {
			FileInputStream inputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			br = new BufferedReader(inputStreamReader);
			FeatureCollection collection = new Gson().fromJson(br, FeatureCollection.class);
			System.out.println();
//			for(int i = 0; i < collection.featureP.length; i++){
//				Features currFeature = collection.featureP[i];
//				lista.insertarAlFinal(new Multa(currFeature.getProperties().);
//
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return lista;
	}


//			reader = new JsonReader(new FileReader(path));
//			JsonElement elem = JsonParser.parseReader(reader);
//			JsonArray features = elem.getAsJsonObject().get("features").getAsJsonArray();
//			for(JsonElement e : features)
//			{
//				JsonElement properties = e.getAsJsonObject().get("properties");
//
//				String id = properties.getAsJsonObject().get("OBJECTID").getAsString();
//				String fechaHora = properties.getAsJsonObject().get("FECHA_HORA").getAsString();
//				String clase = properties.getAsJsonObject().get("CLASE_VEHI").getAsString();
//				String tipo = properties.getAsJsonObject().get("TIPO_SERVI").getAsString();
//				String infrac = properties.getAsJsonObject().get("INFRACCION").getAsString();
//				String descr = properties.getAsJsonObject().get("DES_INFRAC").getAsString();
//				String localidad = properties.getAsJsonObject().get("LOCALIDAD").getAsString();
//
//
//				List<Double> geo = new ArrayList<>();
//				if(e.getAsJsonObject().has("geometry") && !e.getAsJsonObject().get("geometry").isJsonNull())
//				{
//					for(JsonElement geoElem : e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()){
//						geo.add(geoElem.getAsDouble());
//					}
//				}
//
//				Multa m = new Multa(clase, tipo, infrac, descr, localidad, fechaHora, geo, id);
//
//				lista.insertarAlFinal(m);
//
//			}
//		}catch (FileNotFoundException e){
//			e.printStackTrace();
//		}
//
//		return lista;
//
//	}


	public Comparable<Multa>[] copiarComparendos() {
		multasArr = new Multa[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			Multa multa = lista.darActual(i).darValor();
			multasArr[i] = multa;
		}

		return multasArr;
	}


	public Multa buscar(String id) {
		for (Multa m : lista) {
			if (id == null) {
				return null;
			} else if (id.equals(m.darId())) {
				return m;
			}
		}

		return null;
	}


	public void quickSort(Comparable<Multa>[] datos, int principio, int fin) {
		if (principio >= fin) {
			int indiceParticion = partition(datos, principio, fin);
			quickSort(datos, principio, indiceParticion - 1);
			quickSort(datos, indiceParticion - 1, fin);
		}
	}

	public int partition(Comparable<Multa>[] datos, int principio, int fin) {
		Multa key = multasArr[fin];
		int smaller = principio - 1;
		for (int i = principio; i < fin; i++) {
			if (multasArr[i].compareTo(key) <= 0) {
				smaller++;
				exch(datos, smaller, i);
			}
		}
		smaller++;
		exch(datos, fin, smaller);
		return smaller;
	}

	private static void exch(Comparable<Multa>[] a, int i, int j) {
		Comparable<Multa> t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	static class FeatureCollection {
		private String type;
		private String name;
		private CoordinateReferenceSystem[] crs;
		private Features[] featureP;
		private GeometryData geo;
	}

	static class CoordinateReferenceSystem {
		private String type;
		CRSProperty[] properties;
	}

	static class CRSProperty {
		private String name;
	}

	static class FeaturesProperties {
		private String OBJECTID;
		private String FECHA_HORA;
		private String MEDIO_DETE;
		private String CLASE_VEHI;
		private String TIPO_SERVI;
		private String INFRACCION;
		private String DES_INFRAC;
		private String LOCALIDAD;
	}

	static class Features {
		private String type;
		FeaturesProperties[] properties;

		public Object getProperties() {
			return properties;
		}
	}

	static class GeometryData {
		private String type;
		private Double[] coordinates;
	}

}


