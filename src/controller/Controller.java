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
//						view.displayInput();
//						String input = reader.next();
//						Multa respuesta = modelo.buscar(input);
//						view.displayInfoComparendo(respuesta.toString());
						view.displayCopyComparendos();
						Comparable<Multa>[] copia_Comparendos = modelo.copiarComparendos();
						int length = copia_Comparendos.length;
						view.displayOp1DataArraySize(length);


						break;
					case 2:
//						//ordenar Shellsort
//						Comparable copiaComparendos [ ] = modelo.copiarComparendos();
//
//						long startTime = System.currentTimeMillis();
//						//copiaComparendos = modelo.shellSort(copiaComparendos);
//						modelo.Shellsort(copiaComparendos);
//						long endTime = System.currentTimeMillis();
//						long duration = endTime - startTime;
//						view.printMessage("Tiempo de ordenamiento: " + duration + " milisegundos\n");
//						view.printMessage("**==========MOSTRANDO LOS 10 PRIMEROS ORDENADOS POR FECHA shellSort==========**\n");
//						for(int i = 0; i<10;i++)
//						{
//							view.displayInfoComparendo(copiaComparendos[i].toString());
//						}
//						view.printMessage("**==========MOSTRANDO LOS 10 ULTIMOS ORDENADOS POR FECHA shellSort==========**\n");
//						int tamaño= copiaComparendos.length-10;
//						for(int j = tamaño; j<copiaComparendos.length;j++)
//						{
//							view.displayInfoComparendo(copiaComparendos[j].toString());
//						}
//						System.out.println("ESTA ORDENADO: "+ modelo.isSorted(copiaComparendos));

						break;
					case 3:
						//ordenar MergeSort
//						Comparable copiaComparendosMerge [ ] = modelo.copiarComparendos();
//						long start = System.currentTimeMillis();
//						modelo.sort(copiaComparendosMerge);
//						long end = System.currentTimeMillis();
//						long dura = end - start;
//						view.printMessage("Tiempo de ordenamiento: " + dura + " milisegundos\n");
//						view.printMessage("**==========MOSTRANDO LOS 10 PRIMEROS ORDENADOS POR FECHA mergesort==========**\n");
//						for(int i = 0; i<10;i++)
//						{
//							view.displayInfoComparendo(copiaComparendosMerge[i].toString());
//						}
//						view.printMessage("**==========MOSTRANDO LOS 10 ULTIMOS ORDENADOS POR FECHA mergesort==========**\n");
//						int tamaño1= copiaComparendosMerge.length-10;
//						for(int j = tamaño1; j<copiaComparendosMerge.length;j++)
//						{
//							view.displayInfoComparendo(copiaComparendosMerge[j].toString());
//						}
//						System.out.println("ESTA ORDENADO: "+ modelo.isSorted(copiaComparendosMerge));


							break;
					case 4:
						//Ordenar QuickSort()
						Comparable copiaComparendosMerge [ ] = modelo.copiarComparendos();
						long startTime = System.currentTimeMillis();
						modelo.sortQ(copiaComparendosMerge);
						long end = System.currentTimeMillis();
						long duracion = end - startTime;
						view.printMessage("Tiempo de Ordenamiento :" +duracion+ " milisegundos\n");
						view.printMessage("**==========MOSTRANDO LOS 10 PRIMEROS ORDENADOS POR FECHA quicksort==========**\n");
						for(int i = 0; i < 10; i++)
						{
							view.displayInfoComparendo(copiaComparendosMerge[i].toString());
						}
						view.printMessage("**==========MOSTRANDO LOS 10 ULTIMOS ORDENADOS POR FECHA quickSort==========**\n");
						int tamano = copiaComparendosMerge.length-10;
						for(int j = tamano; j < copiaComparendosMerge.length; j++)
						{
							view.displayInfoComparendo(copiaComparendosMerge[j].toString());
						}
						//System.out.println("ESTA ORDENADO: "+ modelo.isSorted(copiaComparendosMerge));
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
