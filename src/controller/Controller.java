package controller;


import model.data_structures.LinkedListImp;
import model.data_structures.Multa;
import model.data_structures.RedBlackBST;
import model.logic.Modelo;
import view.View;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class Controller {


	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	private Scanner reader;
	
	private Comparable[] copia_ComparendosOriginal;

	private Multa m;

	private RedBlackBST<String, String> copiaRedBlack;
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
						copiaRedBlack = modelo.modeloRedBlackBST();
						Iterator<String> iter = copiaRedBlack.keys().iterator();
						view.displayOp1DataSize(copiaRedBlack.size());
						view.printMessage("VALOR MINIMO OBJECTID: "+ copiaRedBlack.min());
						view.printMessage("VALOR MAXIMO OBJECTID: "+ copiaRedBlack.max()+"\n");
						view.printMessage("*================================================*\n" );

						break;
					case 1:
							
						view.displayInput();
						String pId = reader.next();
						String pInfo = modelo.compPorId(pId);
						if(pInfo==null)
							view.printMessage("NO HAY COMPARENDO CON EL ID: "+pId);
						else{
						view.displayInfoComparendosReq1(pInfo);}
						
						break;

<<<<<<< HEAD

					case 2:
						view.printMessage("INGRESE LA ID INFERIOR");
						String idInf = reader.next();

						view.printMessage("INGRESE LA ID SUPERIOR");
						String idSup = reader.next();
						Iterator<String> iter2 = modelo.compPorIdRango(idInf, idSup);
						while(iter2.hasNext())
						{
							String m = iter2.next();
							view.displayInfoComparendosReq1(m);
						}


=======
//						}
						view.displayInput();
						String pId = reader.next();
						String pInfo = modelo.compPorId(pId);
						if(pInfo==null)
							view.printMessage("NO HAY COMPARENDO CON EL ID: "+pId);
						else{
						view.displayInfoComparendosReq1(pInfo);}
						
>>>>>>> 5e0c2e9d44b0373e46738bb5161dd8b84b85f7ab
						break;
					case 3:
						
						int cantidadNodos = copiaRedBlack.size();
						
						view.printMessage("La cantidad de nodos es:"+cantidadNodos+"");
				
						break;

					case 4:
						int altura = copiaRedBlack.height();
						
						view.printMessage("La altura del arbol es:"+altura+"");
				
						break;

					case 5:
						Iterator<String> iterator = copiaRedBlack.keys().iterator();
						float valor = 0.0f;
						while(iterator.hasNext())
						{
							valor += copiaRedBlack.getHeight(iterator.next());
							float valorT = (float) (valor/ copiaRedBlack.size());
							view.printMessage(" es:"+valorT+"");
						}
						view.printMessage(""+copiaRedBlack.getHeight("99999"));
					//Opcion No valida.//
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
