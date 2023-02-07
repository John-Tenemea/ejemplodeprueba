package ec.edu.ups.pweb.demojpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;


@Entity
public class Persona implements Serializable{
	

	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="per_cedula")
	private String cedula;
	
	@Column(name="per_nombre")
	private String nombre;
	
	@Column(name="per_anio_nacimiento")
	private int anioNacimiento;

	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}
}
