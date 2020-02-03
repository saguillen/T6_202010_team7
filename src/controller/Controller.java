package controller;

import model.logic.Modelo;
import view.View;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Controller<T extends Comparable<T>> {

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
					view.displayOp0Menu();
					String info = reader.next();//Esto es input del usuario. Como tener la info del json. 
					modelo.darNombre(info);

					view.displayOp0Data(info);
					break;

				case 1:
					view.displayOp1Menu();

					String info2 = reader.next(); //Lo mismo ^
					modelo.darNombre(info2);//^^^

					view.displayOp1Data(info2);
					break;

				case 2:
					view.displayOp2Menu();
					int size = reader.nextInt();
					modelo.darTamano(size);

					view.displayOp2Data(size);

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
