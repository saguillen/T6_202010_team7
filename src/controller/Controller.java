package controller;

import model.data_structures.HashTLinearProbing;
import model.data_structures.HashTableSeparateChaining;
import model.data_structures.LinkedListImp;
import model.data_structures.Multa;
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

	private HashTLinearProbing<String, String> copiaLinearProb;
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
						copiaLinearProb = modelo.modeloHashLinear();
						Iterator<String> iter = copiaLinearProb.keys().iterator();
						view.displayOp1DataSize(copiaLinearProb.getKeysSize());
						if(iter.hasNext())
						{
							String m = copiaLinearProb.get(iter.next());
							view.displayOp0PrimeroData(m);
						}

						for(int i = copiaLinearProb.getKeysSize()-1; i < copiaLinearProb.getKeysSize(); i++)
						{
							String m = copiaLinearProb.get(iter.next());
							view.displayOp0UltimoData(m);
						}
						view.printMessage("Numero de duplas SeparateChaining: "+ copiaLinearProb.getKeysSize() );
						view.printMessage("Tamaño inicial del arreglo HTSC: "+ copiaLinearProb.tamanoInicial());
						view.printMessage("Tamaño final del arreglo HTSC (m): "+ copiaLinearProb.tamanoFinal());
						view.printMessage("Factor de carga final: "+ copiaLinearProb.factorDeCargaFinal() );
						view.printMessage("Numero de rehashes:"+ copiaLinearProb.numeroRehashes());
						

						HashTableSeparateChaining<String, String> hashtsc = modelo.modeloHashSeparateC();
						Iterator<String> iter2 = hashtsc.keys().iterator();
						view.displayOp1DataSize(hashtsc.size());
						if(iter2.hasNext())
						{
							String m = hashtsc.get(iter2.next());
							view.displayOp0PrimeroData(m);
						}

						for(int i = hashtsc.size()-1; i < hashtsc.size(); i++)
						{
							String m = hashtsc.get(iter2.next());
							view.displayOp0UltimoData(m);
						}
						view.printMessage("Numero de duplas LinearProbing: "+ hashtsc.size() );
						view.printMessage("Tamaño inicial del arreglo HTLP: "+ hashtsc.tamanoInicial());
						view.printMessage("Tamaño final del arreglo HTLP (m): "+ hashtsc.tamanoFinal());
						view.printMessage("Factor de carga final: "+ hashtsc.factorDeCargaFinal() );
						view.printMessage("Numero de rehashes:"+ hashtsc.numeroRehashes());

						break;
					case 1:
						view.displayInputFecha();
						String in = reader.next();
						view.displayInputClaseVehiculo();
						String in2 = reader.next();
						view.displayInputInfraccion();
						String in3 = reader.next();
						for(int i = 0; i < copiaLinearProb.getKeysSize(); i++)
						{
							String c = copiaLinearProb.get(in+in2+in3);
							view.displayInfoComparendosReq1(c);
						}


						break;

					case 2:
						view.printMessage("Ingrese una fecha/hora\n");
						String pFecha = reader.next();
						view.printMessage("INGRESE LA CLASE DE VEHICULO");
						String pClaseV = reader.next();
						view.printMessage("INGRSE UNA INFRACCION");
						String pInfraccion = reader.next();
						LinkedListImp<String> pInfo1 = modelo.buscarTiemposdeViajeSeparateChaining(pFecha, pClaseV, pInfraccion);
						for(int i = 0; i<pInfo1.size();i++)
						{
							String m = pInfo1.darActual(i).darValor();
							view.displayOp0PrimeroData(m);;
						}
						//	view.displayOp0PrimeroData(pInfo1);;


						//2018-11-01T10:29:42.000Z
						//CAMIONETA
						//C02
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
