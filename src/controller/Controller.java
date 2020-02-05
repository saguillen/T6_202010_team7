package controller;

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

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() throws InputMismatchException 
	{
		try
		{
			boolean fin = false;
			Scanner reader = new Scanner(System.in);

			while( !fin ){
				view.printMenu();
				int option = reader.nextInt();
				switch(option){
				case 0:
					//Despliega Menu Opcion 0.
//					view.displayOp0Menu();
//					String info = reader.next();//Esto es input del usuario. Como tener la info del json. 
					try {
						
						
						LinkedListImp<Multa> respuesta = modelo.ModeloJSON();
						String info = (respuesta.darPrimero().darValor().toString());
						view.displayOp0PrimeroData(info);
						
						info = (respuesta.darUltimo().darValor().toString());
						view.displayOp0UltimoData(info);
						
						int pSize = respuesta.size();
						view.displayOp0sizeData(pSize);
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;

				case 1:
					
					view.displayInput();
					String input = reader.next();
					Multa respuesta = modelo.buscar(input);
					view.displayInfoComparendo(respuesta.toString());
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
		}
	}
}
