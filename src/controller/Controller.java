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
//					view.displayInput();
//					String input = reader.next();
//					Multa respuesta = modelo.buscar(input);
//					view.displayInfoComparendo(respuesta.toString());
					view.displayCopyComparendos();
					Comparable copia_Comparendos [ ] = modelo.copiarComparendos();
					int length = copia_Comparendos.length;
					view.displayOp1DataArraySize(length);
					
					
					break;
				case 2:
					//ordenar Shellsort
					Comparable<Multa> copiaComparendos [ ] = modelo.copiarComparendos();
					
					long startTime = System.currentTimeMillis();
					//copiaComparendos = modelo.shellSort(copiaComparendos);
					 modelo.shellSort(copiaComparendos);
					long endTime = System.currentTimeMillis();
					long duration = endTime - startTime; 
					view.printMessage("Tiempo de ordenamiento: " + duration + " milisegundos");
					for(int i = 0; i<10;i++)
					{
						view.displayInfoComparendo(copiaComparendos[i].toString());
						}
					System.out.println("ESTA ORDENADO: "+ modelo.isSorted(copiaComparendos));
					
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
