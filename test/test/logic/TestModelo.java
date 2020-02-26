package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Multa;
import model.logic.Modelo;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class TestModelo<T extends Comparable<T>> {
	
	private Modelo modelo;
	private Comparable<Multa>[] datos;
//	private static int CAPACIDAD=100; No se
	
	@Before
	public void setUp1() {
		Multa m1 = new Multa("AUTOMÓVIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345");
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329");
		Multa m3 = new Multa("AUTOMÓVIL", "Particula", "C31", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/11/26", null, "12345");
		Multa m4 = new Multa("AUTOMÓVIL", "Particular", "B02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/09/10", null, "12345");
		Multa m5 = new Multa("AUTOMÓVIL", "Particular", "A08", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/04/06", null, "12345");
		Multa m6 = new Multa("AUTOMÓVIL", "Particular", "C14", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/09/26", null, "12345");
		Multa m7 = new Multa("AUTOMÓVIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/02/22", null, "12345");
		Multa m8 = new Multa("AUTOMÓVIL", "Particular", "C31", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/08/08", null, "12345");
		datos = new Comparable[]{m1, m2, m3, m4, m5, m6, m7, m8};
	}
	@Test
	public void testQuickSort(){
		setUp1();
		modelo.sortQ(datos);

	}

//	public void setUp2() {
//		for(int i =0; i< CAPACIDAD;i++){
//			modelo.agregar(""+i);
//		}
//	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
//		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		// TODO
	}


	@Test
	public void testBuscarPrimero() {
//		setUp2();
		// TODO Completar la prueba
	}
	
	public void testBuscarUltimo() {
		//TODO Completar la prueba
	}



}
