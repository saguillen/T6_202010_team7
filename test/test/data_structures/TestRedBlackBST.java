package test.data_structures;

import model.data_structures.Multa;
import model.data_structures.Node;
import model.data_structures.RedBlackBST;
import model.logic.Modelo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class TestRedBlackBST<T extends Comparable<T>> {

    private RedBlackBST<String, String> redBlackBST;
    private Modelo modelo;


    public TestRedBlackBST()
    {
        redBlackBST = new RedBlackBST<>();
    }
    public void setUp1()
    {
        redBlackBST = new RedBlackBST<>();
    }

    public void setUp2()
    {
        setUp1();
        Multa m = new Multa("CAMIONETA","Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329", "");
        String llave = m.darFechaHora() + m.darClase() + m.darInfraccion();
        String valores = m.darId() + "\t" + m.darFechaHora() + "\t" + m.darClase() + "\t" + m.darTipoServicio() + "\t" + m.darInfraccion() + "\t" + m.darDescInfr() + "\t" + m.darLocalidad() + "\t" + m.darMedioDeteccion();

        redBlackBST.put(llave, valores);
        redBlackBST.put(llave, valores);
        redBlackBST.put(llave, valores);
    }

    @Test
    public void testPut()
    {
        List<Double> geoM1 = new ArrayList<>();
        geoM1.add(-74.03103799999997);
        geoM1.add(4.692781120000063);
        List<Double> geoM2 = new ArrayList<>();
        geoM2.add(-74.08803099999994);
        geoM2.add(4.616017200000044);
        List<Double> geoM3 = new ArrayList<>();
        geoM3.add(-74.08784599999996);
        geoM3.add(4.615945300000021);

        setUp1();
        assertTrue(redBlackBST.isEmpty());
        Multa m1 = new Multa("AUTOMÃ“VIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "USAQUEN", "2018-10-11T14:30:00.000Z", geoM1, "12345", "LAPIZ");
        Multa m2 = new Multa("AUTOMÃ“VIL", "Particular", "D04", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TEUSAQUILLO", "2018-11-17T02:50:00.000Z", geoM2, "387430", "");
        Multa m3 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍCULO SERÁ INMOVILIZADO.", "TUNJUELITO", "2018-05-25T15:20:00.000Z", geoM3, "217406", "LAPIZ");
        Multa m4 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍCULO SERÁ INMOVILIZADO.", "TUNJUELITO", "2018-05-25T15:20:00.000Z", geoM3, "453635", "LAPIZ");

        String llave1 = m1.darId();
        String llave2 = m2.darId();
        String llave3 = m3.darId();
        String llave4 = m4.darId();
        
        String valores1 = m1.toString();
        String valores2 = m2.toString();
        String valores3 = m3.toString();
        String valores4 = m4.toString();

        redBlackBST.put(llave1, valores1);
        redBlackBST.put(llave2, valores2);
        redBlackBST.put(llave3, valores3);
        redBlackBST.put(llave4, valores4);
        
        assertFalse(redBlackBST.isEmpty());
        assertEquals(4, redBlackBST.size());
        
    }
    @Test
    public void testSize()
    {
        testPut();
        assertEquals(4, redBlackBST.size());
    }

    @Test
    public void testIsEmpty()
    {
        setUp1();
        assertTrue(redBlackBST.isEmpty());
        assertEquals(0, redBlackBST.size());
    }
    @Test
    public void testGet()
    {
        setUp1();
        testPut();
        List<Double> geoM1 = new ArrayList<>();
        geoM1.add(-74.03103799999997);
        geoM1.add(4.692781120000063);
        Multa m = new Multa("AUTOMÃ“VIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "USAQUEN", "2018-10-11T14:30:00.000Z", geoM1, "12345", "LAPIZ");
        String llave = m.darId();
        String m2 = redBlackBST.get(llave);
        assertEquals(m.toStringTest(), m2 );
    }

    @Test
    public void testGetHeight()
    {
    	setUp1();
    	testPut();
    	assertEquals(-1, redBlackBST.getHeight("6942069"));//no existe entonces manda -1
    	assertEquals(4, redBlackBST.size());
    	int height = redBlackBST.height();
    	assertEquals(2, height );
    	int getheight = redBlackBST.getHeight("387430");//id de la multa m2
    	assertEquals(2, getheight );

    }

    @Test
    public void testContains()
    {
    	setUp1();
    	testPut();
    	assertFalse(redBlackBST.contains("6942069"));//no existe
    	assertTrue(redBlackBST.contains("217406")); // sí existe

    }

    @Test
    public void testHeight()
    {
    	setUp1();
    	testPut();
    	assertEquals(-1, redBlackBST.getHeight("6942069"));//no existe entonces manda -1
    	assertEquals(4, redBlackBST.size());
    	int height = redBlackBST.height();
    	assertEquals(2, height );
    }

    @Test
    public void testMin()
    {
        setUp1();
        List<Double> geoM1 = new ArrayList<>();
        geoM1.add(-74.03103799999997);
        geoM1.add(4.692781120000063);
        List<Double> geoM2 = new ArrayList<>();
        geoM2.add(-74.08803099999994);
        geoM2.add(4.616017200000044);
        Multa m1 = new Multa("AUTOMÃ“VIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "USAQUEN", "2018-10-11T14:30:00.000Z", geoM1, "12345", "LAPIZ");
        Multa m2 = new Multa("AUTOMÃ“VIL", "Particular", "D04", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TEUSAQUILLO", "2018-11-17T02:50:00.000Z", geoM2, "387430", "");
        String valores1 = m1.darId()+"\t"+ m1.darFechaHora()+"\t"+ m1.darClase()+"\t"+m1.darTipoServicio()+"\t"+m1.darInfraccion()+"\t"+m1.darDescInfr()+"\t"+m1.darLocalidad()+"\t"+m1.darGeo()+"\t"+m1.darMedioDeteccion();
        String valores2 = m2.darId()+"\t"+ m2.darFechaHora()+"\t"+ m2.darClase()+"\t"+m2.darTipoServicio()+"\t"+m2.darInfraccion()+"\t"+m2.darDescInfr()+"\t"+m2.darLocalidad()+"\t"+m2.darGeo()+"\t"+m2.darMedioDeteccion();

        String llave1 = m1.darId();
        String llave2 = m2.darId();

        redBlackBST.put(llave1, valores1);
        redBlackBST.put(llave2, valores2);

        assertEquals(redBlackBST.min(), llave1);


    }

    @Test
    public void testMax()
    {

        setUp1();
        List<Double> geoM1 = new ArrayList<>();
        geoM1.add(-74.03103799999997);
        geoM1.add(4.692781120000063);
        List<Double> geoM2 = new ArrayList<>();
        geoM2.add(-74.08803099999994);
        geoM2.add(4.616017200000044);
        Multa m1 = new Multa("AUTOMÃ“VIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "USAQUEN", "2018-10-11T14:30:00.000Z", geoM1, "12345", "LAPIZ");
        Multa m2 = new Multa("AUTOMÃ“VIL", "Particular", "D04", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TEUSAQUILLO", "2018-11-17T02:50:00.000Z", geoM2, "387430", "");
        String valores1 = m1.darId()+"\t"+ m1.darFechaHora()+"\t"+ m1.darClase()+"\t"+m1.darTipoServicio()+"\t"+m1.darInfraccion()+"\t"+m1.darDescInfr()+"\t"+m1.darLocalidad()+"\t"+m1.darGeo()+"\t"+m1.darMedioDeteccion();
        String valores2 = m2.darId()+"\t"+ m2.darFechaHora()+"\t"+ m2.darClase()+"\t"+m2.darTipoServicio()+"\t"+m2.darInfraccion()+"\t"+m2.darDescInfr()+"\t"+m2.darLocalidad()+"\t"+m2.darGeo()+"\t"+m2.darMedioDeteccion();

        String llave1 = m1.darId();
        String llave2 = m2.darId();

        redBlackBST.put(llave1, valores1);
        redBlackBST.put(llave2, valores2);

        assertEquals(redBlackBST.max(), llave2);


    }
    
	@Test
	public void testKeys()
	{
		setUp1();
		testPut();
		boolean estaDentro = false;
		Iterator<String> iter = redBlackBST.keys().iterator();	
		int keysSize = 0;
		while(iter.hasNext())
		{
			iter.next();
			keysSize++;
			if(iter.equals("217406"));
			{
				estaDentro= true;
			}
		}
		assertEquals(4, keysSize);
		assertTrue(estaDentro);
		
	}
	@Test
	public void testCheck()
	{
		setUp1();
		testPut();
		assertTrue(redBlackBST.check());
	}
	@Test
	public void testValuesInRange()
	{
		setUp1();
		testPut();
		boolean estaDentro = false;
		String k1 = "217406";
		String k2 = "453635";
		Iterator<String> iter = redBlackBST.values(k1, k2).iterator();
		int keysSize = 0;
		while(iter.hasNext())
		{
			iter.next();
			keysSize++;
			if(iter.equals("217406	2018-05-25T15:20:00.000Z	LAPIZ	CAMIONETA	Particular	C35	NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍCULO SERÁ INMOVILIZADO.	TUNJUELITO	[-74.08784599999996, 4.615945300000021]"));
			{
				estaDentro= true;
			}
		}
		assertEquals(3, keysSize);
		assertTrue(estaDentro);

	}
	@Test
	public void testKeysInRange()
	{
		setUp1();
		testPut();
		boolean estaDentro = false;

		String k1 = "217406";
		String k2 = "453635";
		Iterator<String> iter = redBlackBST.keys(k1, k2).iterator();
		int keysSize = 0;
		while(iter.hasNext())
		{
			iter.next();
			keysSize++;
			if(iter.equals("387430"));
			{
				estaDentro= true;
			}
		}
		assertEquals(3, keysSize);
		assertTrue(estaDentro);

	}
}
