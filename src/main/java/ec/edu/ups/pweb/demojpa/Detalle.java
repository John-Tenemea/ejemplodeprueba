package ec.edu.ups.pweb.demojpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Entity
public class Detalle {
	
	
	@Id
	@GeneratedValue
	private int codigo;
	private String nombreProducto;
	private int cantidad;
	private double precioUnitario;
	private double susbtotal;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public double getSusbtotal() {
		return susbtotal;
	}
	public void setSusbtotal(double susbtotal) {
		this.susbtotal = susbtotal;
	}
	

}
