package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import model.data_structures.LinkedListImp;
import model.data_structures.Node;

import model.data_structures.LinkedListImp;
import model.data_structures.Multa;

import model.logic.Modelo;
import view.View;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Controller {

	//Debe ser un switch grande, no va Jsonreader, va en modelo.
	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	private Scanner reader;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

		
//	public void run() 
//	{
//		Gson gson = new Gson();
//		
//		String path = "./data/comparendos_dei_2018_small-geojson";
//		JsonReader reader;
//		try {
//			reader = new JsonReader(new FileReader(path));
//			Type collectionType = new TypeToken<LinkedListImp<String>>(){}.getType();
//			LinkedListImp<Node> lista = gson.fromJson(reader, collectionType);
//			System.out.println(Arrays.toString(lista.toArray()));
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		
//		Scanner lector = new Scanner(System.in);
//		boolean fin = false;
//		String dato = "";
//		String respuesta = "";
//
//		while( !fin ){
//			view.printMenu();
//
//			int option = lector.nextInt();
//			switch(option){
//				case 1:
//					view.printMessage("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
//				    int capacidad = lector.nextInt();
//				    modelo = new Modelo(capacidad); 
//				    view.printMessage("Arreglo Dinamico creado");
//				    view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
//					break;
//
//				case 2:
//					view.printMessage("--------- \nDar cadena (simple) a ingresar: ");
//					dato = lector.next();
//					modelo.agregar(dato);
//					view.printMessage("Dato agregado");
//					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
//					break;
//
//				case 3:
//					view.printMessage("--------- \nDar cadena (simple) a buscar: ");
//					dato = lector.next();
//					respuesta = modelo.buscar(dato);
//					if ( respuesta != null)
//					{
//						view.printMessage("Dato encontrado: "+ respuesta);
//					}
//					else
//					{
//						view.printMessage("Dato NO encontrado");
//					}
//					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
//					break;
//
//				case 4:
//					view.printMessage("--------- \nDar cadena (simple) a eliminar: ");
//					dato = lector.next();
//					respuesta = modelo.eliminar(dato);
//					if ( respuesta != null)
//					{
//						view.printMessage("Dato eliminado "+ respuesta);
//					}
//					else
//					{
//						view.printMessage("Dato NO eliminado");							
//					}
//					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
//					break;
//
//				case 5: 
//					view.printMessage("--------- \nContenido del Arreglo: ");
//					view.printModelo(modelo);
//					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
//					break;	
//					
//				case 6: 
//					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
//					lector.close();
//					fin = true;
//					break;	
//
//				default: 
//					view.printMessage("--------- \n Opcion Invalida !! \n---------");
//					break;
//			}
//		}
		
//	}	


	public void run() throws InputMismatchException 
	{
		reader = new Scanner(System.in);
		try
		{
			boolean fin = false;
			while( !fin ){
				view.printMenu();
				int option = reader.nextInt();
				switch(option){
				case 0: 
					try {

						LinkedListImp<Multa> respuesta = modelo.ModeloJSON();
						String info = (respuesta.darPrimero().darValor().toString());
						view.displayOp0PrimeroData(info);

						info = (respuesta.darUltimo().darValor().toString());
						view.displayOp0UltimoData(info);

						int pSize = respuesta.size();
						view.displayOp0sizeData(pSize);

					} catch (FileNotFoundException e) {

						e.printStackTrace();
					}
					break;

				case 1:
					
					view.displayInput();
				String input = reader.next();
				System.out.println(input);
					LinkedListImp<Multa> Respuesta = modelo.ModeloJSON();
					
					
					
					String info = Respuesta.darPorId("29042").darValor().toString();
				System.out.println(info);
					view.displayInfoComparendo(info.toString());
					break;

					//Opcion No valida.
				default: 
					view.badOption();
					fin = true;

					break;
				}
			}
		}
		catch(InputMismatchException e){
			run();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
