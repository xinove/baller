package modelos;

// Generated 21-feb-2012 17:01:18 by Hibernate Tools 3.4.0.CR1

/**
 * Nacionalidad generated by hbm2java
 */
public class Nacionalidad implements java.io.Serializable {

	private Integer idNacionalidad;
	private String nacionalidad;
	private String pais;
	private Integer frecuencia;

	public Nacionalidad() {
	}

	public Nacionalidad(String nacionalidad, String pais, Integer frecuencia) {
		this.nacionalidad = nacionalidad;
		this.pais = pais;
		this.frecuencia = frecuencia;
	}

	public Integer getIdNacionalidad() {
		return this.idNacionalidad;
	}

	public void setIdNacionalidad(Integer idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getFrecuencia() {
		return this.frecuencia;
	}

	public void setFrecuencia(Integer frecuencia) {
		this.frecuencia = frecuencia;
	}

}
