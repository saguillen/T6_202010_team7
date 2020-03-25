package controller;

import model.data_structures.HashTLinearProbing;
import model.data_structures.LinkedListImp;
import model.data_structures.Multa;
import model.logic.Modelo;
import view.View;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Controller {


	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	private Scanner reader;
	
	private Comparable[] copia_ComparendosOriginal;

	private Multa m;
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
						HashTLinearProbing<String, LinkedListImp<Multa>> resp = modelo.modeloHashLinear();
						view.displayOp1DataSize(resp.getKeysSize());
						
		  			//	Multa m = resp.toString();
						//for(int i= 0; i < 1; i++)
					//	{
						//	view.displayOp0PrimeroData(resp.get(resp.darKeys()[0]).darPrimero().darValor().toString());
				//		}
						//	String[] keys = resp.darKeys();
						for(int i = 0; i == resp.getKeysSize()-1; i++)
						{
							view.displayOp0UltimoData(resp.toString());
					    }
						String[] llave = new String[resp.getKeysSize()];
							System.arraycopy(resp.darKeys(), 0, llave, 0, resp.getKeysSize());
							for(int i = 0; i<2;i++)
							{
								System.out.println(resp.darKeys()[1]);

							}
						  
							
							



						break;
					case 1:


						break;

//					//Opcion No valida.
					default:
						view.badOption();
						fin = true;

				}
			}
		}
		catch(InputMismatchException e){
			run();
		}
	}
}
