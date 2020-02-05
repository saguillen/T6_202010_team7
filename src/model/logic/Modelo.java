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
import java.util.Iterator;
import java.util.List;

public class Modelo 
{
	LinkedListImp<Multa> lista = new LinkedListImp<>();

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
		return lista;

	}

	public Multa buscar(String id) 
	{
		for(Multa m: lista){}
		for(Iterator<Multa> i = lista.iterator(); i.hasNext();)
		{
			Multa m = i.next();
			if(m.darId() == id)
			{
				return m;
			}
		}
		
		return null;
	}
}




