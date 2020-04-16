package test.data_structures;

import model.data_structures.Multa;
import model.data_structures.Node;
import model.data_structures.RedBlackBST;
import model.logic.Modelo;
import org.junit.Test;

import java.util.ArrayList;
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
        Multa m = new Multa("CAMIONETA","Particular", "C35", "NO REALIZAR LA REVISIﾓN TECNICOMECﾁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHﾍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECﾁNICAS O DE EMISIONES CONTAMINANTES, AﾚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMﾁS EL VEHﾍC", "TUNJUELITO", "2018/01/17", null, "509329", "");
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
        Multa m1 = new Multa("AUTOMﾃ天IL", "Particular", "C02", "ESTACIONAR UN VEHﾍCULO EN SITIOS PROHIBIDOS.", "USAQUEN", "2018-10-11T14:30:00.000Z", geoM1, "12345", "LAPIZ");
        Multa m2 = new Multa("AUTOMﾃ天IL", "Particular", "D04", "NO REALIZAR LA REVISIﾓN TECNICOMECﾁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHﾍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECﾁNICAS O DE EMISIONES CONTAMINANTES, AﾚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMﾁS EL VEHﾍC", "TEUSAQUILLO", "2018-11-17T02:50:00.000Z", geoM2, "387430", "");
        Multa m3 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIﾓN TECNICOMECﾁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHﾍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECﾁNICAS O DE EMISIONES CONTAMINANTES, AﾚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMﾁS EL VEHﾍCULO SERﾁ INMOVILIZADO.", "TUNJUELITO", "2018-05-25T15:20:00.000Z", geoM3, "217406", "LAPIZ");

        String llave1 = m1.darFechaHora() + m1.darClase() + m1.darInfraccion();
        String llave2 = m2.darFechaHora() + m2.darClase() + m2.darInfraccion();
        String llave3 = m3.darFechaHora() + m3.darClase() + m3.darInfraccion();

        String valores1 = m1.darId()+"\t"+ m1.darFechaHora()+"\t"+ m1.darClase()+"\t"+m1.darTipoServicio()+"\t"+m1.darInfraccion()+"\t"+m1.darDescInfr()+"\t"+m1.darLocalidad()+"\t"+m1.darGeo()+"\t"+m1.darMedioDeteccion();
        String valores2 = m2.darId()+"\t"+ m2.darFechaHora()+"\t"+ m2.darClase()+"\t"+m2.darTipoServicio()+"\t"+m2.darInfraccion()+"\t"+m2.darDescInfr()+"\t"+m2.darLocalidad()+"\t"+m2.darGeo()+"\t"+m2.darMedioDeteccion();
        String valores3 = m3.darId()+"\t"+ m3.darFechaHora()+"\t"+ m3.darClase()+"\t"+m3.darTipoServicio()+"\t"+m3.darInfraccion()+"\t"+m3.darDescInfr()+"\t"+m3.darLocalidad()+"\t"+m3.darGeo()+"\t"+m3.darMedioDeteccion();

        redBlackBST.put(llave1, valores1);
        redBlackBST.put(llave2, valores2);
        redBlackBST.put(llave3, valores3);
        assertFalse(redBlackBST.isEmpty());
        assertEquals(3, redBlackBST.size());

    }
    @Test
    public void testSize()
    {
        testPut();
        assertEquals(3, redBlackBST.size());
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
        Multa m = new Multa("AUTOMﾃ天IL", "Particular", "C02", "ESTACIONAR UN VEHﾍCULO EN SITIOS PROHIBIDOS.", "USAQUEN", "2018-10-11T14:30:00.000Z", geoM1, "12345", "LAPIZ");
        String llave = m.darFechaHora() + m.darClase() + m.darInfraccion();
        String m2 = redBlackBST.get(llave);
        assertEquals(m.toStringTest(), m2 );
    }

    @Test
    public void testGetHeight()
    {

    }

    @Test
    public void testContains()
    {
        testPut();
        Multa m = new Multa("AUTOMﾃ天IL", "Particular", "C02", "ESTACIONAR UN VEHﾍCULO EN SITIOS PROHIBIDOS.", "USAQUEN", "2018-10-11T14:30:00.000Z", geoM1, "12345", "LAPIZ");
        String llave = m.darFechaHora() + m.darClase() + m.darInfraccion();
        assertTrue(redBlackBST.contains(llave));
    }

    @Test
    public void testHeight()
    {
        redBlackBST.height();
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
        Multa m1 = new Multa("AUTOMﾃ天IL", "Particular", "C02", "ESTACIONAR UN VEHﾍCULO EN SITIOS PROHIBIDOS.", "USAQUEN", "2018-10-11T14:30:00.000Z", geoM1, "12345", "LAPIZ");
        Multa m2 = new Multa("AUTOMﾃ天IL", "Particular", "D04", "NO REALIZAR LA REVISIﾓN TECNICOMECﾁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHﾍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECﾁNICAS O DE EMISIONES CONTAMINANTES, AﾚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMﾁS EL VEHﾍC", "TEUSAQUILLO", "2018-11-17T02:50:00.000Z", geoM2, "387430", "");
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
        Multa m1 = new Multa("AUTOMﾃ天IL", "Particular", "C02", "ESTACIONAR UN VEHﾍCULO EN SITIOS PROHIBIDOS.", "USAQUEN", "2018-10-11T14:30:00.000Z", geoM1, "12345", "LAPIZ");
        Multa m2 = new Multa("AUTOMﾃ天IL", "Particular", "D04", "NO REALIZAR LA REVISIﾓN TECNICOMECﾁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHﾍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECﾁNICAS O DE EMISIONES CONTAMINANTES, AﾚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMﾁS EL VEHﾍC", "TEUSAQUILLO", "2018-11-17T02:50:00.000Z", geoM2, "387430", "");
        String valores1 = m1.darId()+"\t"+ m1.darFechaHora()+"\t"+ m1.darClase()+"\t"+m1.darTipoServicio()+"\t"+m1.darInfraccion()+"\t"+m1.darDescInfr()+"\t"+m1.darLocalidad()+"\t"+m1.darGeo()+"\t"+m1.darMedioDeteccion();
        String valores2 = m2.darId()+"\t"+ m2.darFechaHora()+"\t"+ m2.darClase()+"\t"+m2.darTipoServicio()+"\t"+m2.darInfraccion()+"\t"+m2.darDescInfr()+"\t"+m2.darLocalidad()+"\t"+m2.darGeo()+"\t"+m2.darMedioDeteccion();

        String llave1 = m1.darId();
        String llave2 = m2.darId();

        redBlackBST.put(llave1, valores1);
        redBlackBST.put(llave2, valores2);

        assertEquals(redBlackBST.max(), llave2);

    }

}
