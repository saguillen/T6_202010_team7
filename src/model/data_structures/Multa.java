package model.data_structures;

public class Multa {
	
	private String CLASE_VEHICULO;
	
	private String TIPO_SERVICIO;
	
	private String INFRACCION;
	
	private String DES_INFRAC;
	
	private String LOCALIDAD;
	
	private String FECHA_HORA;
	
	
	public Multa(String pClase, String pTipoS, String pInfra, String pDesc, String pLocalidad, String pFechaHora)
	{
		CLASE_VEHICULO = pClase;
		TIPO_SERVICIO = pTipoS;
		DES_INFRAC = pDesc;
		LOCALIDAD = pLocalidad;
		FECHA_HORA = pFechaHora;
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
		return FECHA_HORA + "-"+ CLASE_VEHICULO + "-" + TIPO_SERVICIO + "-" + INFRACCION + "-" + DES_INFRAC + "-" + LOCALIDAD;
	}
	
	
	
	
}
