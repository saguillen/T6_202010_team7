package view;

import model.logic.Modelo;



public class View 
{
	private static final String RESET = "\u001B[0m";
	private static final String BLUE = "\u001B[34m";
	private static final String DYELLOW = "\u001B[38;5;214m";
	private static final String PINK = "\u001B[38;5;205m";
	private static final String WEIRDRED = "\u001B[38;5;203m";
	private static final String ORANGE = "\u001B[38;5;208m";
	private static final String LIGHTBLUE = "\u001B[38;5;50m";
	private static final String GREEN = "\u001B[38;5;84m";
	private static final String PRETTYPURPLE = "\u001B[38;5;213m";
	private static final String BBLUE = "\u001B[38;5;87m";
	private static final String DARKORANGE = "\u001B[38;5;202m";

	/**
	 * Metodo constructor
	 */
	public View()
	{

	}

	/**
	 * Implementacion del menu. Esta implementacion fue realizada por Ándres Ortiz. Monitor del curso, el cual
	 * incentivo el uso de este para que el usuario tenga una mejor interaccion con el proyecto. 
	 */
	public void printMenu()
	{
		System.out.println(DYELLOW + " **==========================**");
		System.out.println(DYELLOW + " ||      ==== MENU ====      ||");

		System.out.println(DYELLOW + " ||" + BBLUE + " 0. Info Primer Comparendo .  " + DYELLOW + "     ||");
		System.out.println(DYELLOW + " ||" + GREEN + " 1. Info Ultimo Comparendo . " + DYELLOW + "      ||");
		System.out.println(DYELLOW + " ||" + PINK +  " 2. List Size.  " + DYELLOW + "             ||");
		System.out.println(DYELLOW + " **==========================**\n");

		// display hint
		this.displayHint();
		System.out.print(BLUE + "Input -> \n\n" + RESET);
	}

	/**
	 * Displays an error message to the user if the option selected is invalid.
	 */
	public void badOption() {
		System.out.println("\u001B[31m########## \n?Invalid option !! \n########## \u001B[0m");
	}

	/**
	 * Print a hint to the user to select an option.
	 */
	public void displayHint() {
		System.out.println(
				BLUE + "Enter the number corresponding to the option, the press the Return "
						+ "key: (e.g ., 1,2..):\n" + RESET);
	}

	// -------------------------------------------------------------
	// Option 0
	// -------------------------------------------------------------

	/**
	 * Print option 0 menu.
	 */
	public void displayOp0Menu() {
		System.out.println(DYELLOW + "====== Informacion Primer Comparendo ======");

	}

	/**
	 * Print option 0 data.
	 */
	public void displayOp0Data(String pInfo) {
		System.out.println(LIGHTBLUE + "FECHA: " + RESET + pInfo.split("-")[0]);
		System.out.println(LIGHTBLUE + "CLASE DE VEHICULO: " + RESET + pInfo.split("-")[1]);
		System.out.println(LIGHTBLUE + "TIPO DE SERVICIO: " + RESET + pInfo.split("-")[2]);
		System.out.println(LIGHTBLUE + "INFRACCION: " + RESET + pInfo.split("-")[3]);
		System.out.println(LIGHTBLUE + "DESCRIPCION DE INFRACC.: " + RESET + pInfo.split("-")[4]);
		System.out.println(LIGHTBLUE + "LOCALIDAD: " + RESET + pInfo.split("-")[5]);
		System.out.println(DYELLOW + "===========================\n");

	}

	// -------------------------------------------------------------
	// Option 1
	// -------------------------------------------------------------

	/**
	 * Print option 1 menu.
	 */
	public void displayOp1Menu() {
		System.out.println(DYELLOW + "====== Informacion Ultimo Comparendo  ======");

	}

	/**
	 * Print option 1 data.
	 */
	public void displayOp1Data(String pInfo) {
		System.out.println(LIGHTBLUE + "FECHA: " + RESET + pInfo.split("-")[0]);
		System.out.println(LIGHTBLUE + "CLASE DE VEHICULO: " + RESET + pInfo.split("-")[1]);
		System.out.println(LIGHTBLUE + "TIPO DE SERVICIO: " + RESET + pInfo.split("-")[2]);
		System.out.println(LIGHTBLUE + "INFRACCION: " + RESET + pInfo.split("-")[3]);
		System.out.println(LIGHTBLUE + "DESCRIPCION DE INFRACC.: " + RESET + pInfo.split("-")[4]);
		System.out.println(LIGHTBLUE + "LOCALIDAD: " + RESET + pInfo.split("-")[5]);
		System.out.println(DYELLOW + "======================\n");

	}

	// -------------------------------------------------------------
	// Option 2
	// -------------------------------------------------------------

	/**
	 * Print option 2 menu.
	 */
	public void displayOp2Menu() {
		System.out.println(DYELLOW + "====== List Size ======");
	}

	/**
	 * Print option 2 data.
	 */
	public void displayOp2Data(int pSize) {

		System.out.println(LIGHTBLUE + "SIZE: " + RESET + pSize);
		System.out.println(DYELLOW + "======================\n");
		

	}
}
