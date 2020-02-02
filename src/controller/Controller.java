package controller;

import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.stream.JsonReader;

import model.data_structures.LinkedListImp;
import model.data_structures.Node;
import model.logic.Modelo;
import view.View;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class Controller<T extends Comparable<T>> {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
		JsonReader reader;
		String path = "./data/comparendos_dei_2018_small.geojson";
		Gson gson = new Gson();

		while( !fin ){
			view.printMenu();
			
			System.out.println("--------------------------");
			try {
				reader = new JsonReader(new FileReader(path));
				Type collectionType = new TypeToken<LinkedListImp<String>>(){}.getType(); //Preguntar
				LinkedListImp<String> lista = gson.fromJson(reader, collectionType);      //Preguntar
				System.out.println(Arrays.toString(lista.toArray()));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			

			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
				    int capacidad = lector.nextInt();
				    modelo = new Modelo<String>(); 
				    view.printMessage("Arreglo Dinamico creado");
				    view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 2:
					view.printMessage("--------- \nDar cadena (simple) a ingresar: ");
					dato = lector.next();
//					modelo.agregar(dato); No necesitamos agregar
					view.printMessage("Dato agregado");
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 3:
					view.printMessage("--------- \nDar cadena (simple) a buscar: ");
					dato = lector.next();
					respuesta = modelo.buscarPrimero().toString();  //Esto es valido?
					if ( respuesta != null)
					{
						view.printMessage("Dato encontrado: "+ respuesta);
					}
					else
					{
						view.printMessage("Dato NO encontrado");
					}
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 4:
					view.printMessage("--------- \nDar cadena (simple) a eliminar: ");
					dato = lector.next();
//					respuesta = modelo.eliminar(dato); No necesitamos eliminar
					if ( respuesta != null)
					{
						view.printMessage("Dato eliminado "+ respuesta);
					}
					else
					{
						view.printMessage("Dato NO eliminado");							
					}
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 5: 
					view.printMessage("--------- \nContenido del Arreglo: ");
					view.printModelo(modelo);
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;	
					
				case 6: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
