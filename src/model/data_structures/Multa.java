package model.data_structures;

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
	public String darFechaHora(){
		return FECHA_HORA;
	}
	
	//ToString() mismo formato de view. 
	
	public String toString()
	{
		return FECHA_HORA+"\t"+CLASE_VEHICULO+"\t"+TIPO_SERVICIO+"\t"+INFRACCION+"\t"+DES_INFRAC+"\t"+LOCALIDAD+"\t"+GEO;
	}
	
	public String darId()
	{
		return OBJECT_ID;
	}
	
	public List<Double>darGeo()
	{
		return GEO;
	}

	
	@Override
	public int compareTo(Multa o) {
		// TODO Auto-generated method stub
		return 0;
	}	
	
}
