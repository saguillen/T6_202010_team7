package controller;

import model.data_structures.HashTLinearProbing;
import model.data_structures.HashTableSeparateChaining;
import model.data_structures.LinkedListImp;
import model.data_structures.Multa;
import model.data_structures.Queue;
import model.logic.Modelo;
import view.View;

import java.io.FileNotFoundException;
import java.util.Arrays;
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
	 *
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
						HashTLinearProbing<String, String> resp = modelo.modeloHashLinear();
						Iterator<String> iter = resp.keys().iterator();
						view.displayOp1DataSize(resp.getKeysSize());
						if(iter.hasNext())
						{
							String m = resp.get(iter.next());
							view.displayOp0PrimeroData(m);
//							view.displayOp0PrimeroData(m);
						}

						for(int i = resp.getKeysSize()-1; i < resp.getKeysSize(); i++)
						{
							String m = resp.get(iter.next());
							view.displayOp0UltimoData(m);
						}
						
						
						HashTableSeparateChaining<String, String> hashtsc = modelo.modeloHashSeparateC();
						Iterator<String> iter2 = resp.keys().iterator();
						view.displayOp1DataSize(resp.getKeysSize());
						if(iter.hasNext())
						{
							String m = hashtsc.get(iter2.next());
							view.displayOp0PrimeroData(m);
//							view.displayOp0PrimeroData(m);
						}

						for(int i = hashtsc.size()-1; i < hashtsc.size(); i++)
						{
							String m = hashtsc.get(iter2.next());
							view.displayOp0UltimoData(m);
						}
						view.printMessage("Numero de duplas SeparateChaining: "+ hashtsc.size() );
						view.printMessage("Tama�o inicial del arreglo HTSC: "+ hashtsc.tama�oInicial());
						view.printMessage("Tama�o final del arreglo HTSC (m): "+ hashtsc.tama�oFinal());
						view.printMessage("Factor de carga final: "+ hashtsc.factorDeCargaFinal() );
						view.printMessage("Numero de rehashes:"+ hashtsc.numeroRehashes());

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
		//
	}
}
