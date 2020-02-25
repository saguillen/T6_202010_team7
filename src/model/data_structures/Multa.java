package model.data_structures;

import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Multa implements Comparable<Multa>
{
	private String OBJECT_ID;
	
	private String CLASE_VEHICULO;
	
	private String TIPO_SERVICIO;
	
	private String INFRACCION;
	
	private String DES_INFRAC;
	
	private String LOCALIDAD;
	
	private String FECHA_HORA;
	
	private List<Double> GEO;
	
	public Multa(String pClase, String pTipoS, String pInfra, String pDesc, String pLocalidad, String pFechaHora, List<Double> pGeo, String pId)
	{
		CLASE_VEHICULO = pClase;
		TIPO_SERVICIO = pTipoS;
		INFRACCION = pInfra;
		DES_INFRAC = pDesc;
		LOCALIDAD = pLocalidad;
		FECHA_HORA = pFechaHora;
		GEO = pGeo;
		OBJECT_ID = pId;
	}
	
	public String darClase()
	{
		return CLASE_VEHICULO;
	}
	public String darTipoServicio()
	{
		return TIPO_SERVICIO;
	}
	public String darInfraccion() {
		return INFRACCION;
	}
	public String darDescInfr()
	{
		return DES_INFRAC;
	}
	public String darLocalidad()
	{
		return LOCALIDAD;
	}
	public String darFechaHora(){ return FECHA_HORA; }
	
	//ToString() mismo formato de view.
	public String toString()
	{
		return FECHA_HORA+"\t"+CLASE_VEHICULO+"\t"+TIPO_SERVICIO+"\t"+INFRACCION+"\t"+DES_INFRAC+"\t"+LOCALIDAD+"\t"+GEO+"\t"+OBJECT_ID;
	}
	
	public String darId()
	{
		return OBJECT_ID;
	}
	
	public List<Double> darGeo()
	{
		return GEO;
	}

	@Override
//	public int compareTo(Multa pMulta) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String dateP = pMulta.darFechaHora();
//		String date = darFechaHora();
//		int val = 0;
//		try {
//			Date date1 = sdf.parse(dateP);
//			Date date2 = sdf.parse(date);
//			int objId = Integer.parseInt(pMulta.darId());
//			int objId2 = Integer.parseInt(darId());
//
//			if (date1.equals(date2)) {
//				val = Integer.compare(objId, objId2);
//			} else if (date1.before(date2)) {
//				val = 1;
//			} else
//				val = -1;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return val;
//	}
	public int compareTo(Multa pMulta)
	{
		int hora = Integer.parseInt(pMulta.darFechaHora().replaceAll("/",""));
		int hora2 = Integer.parseInt(darFechaHora().replaceAll("/", ""));
		int objId = Integer.parseInt(pMulta.darId());
		int objId2 = Integer.parseInt(darId());
	//	System.out.println(hora);

		if(hora == hora2)
			return Integer.compare(objId, objId2);
		else if(hora < hora2)
			return -1;
		else
			return 1;
		
		
	}

}
