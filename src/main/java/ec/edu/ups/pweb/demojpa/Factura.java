package ec.edu.ups.pweb.demojpa;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Factura {
	
	@Id
	@GeneratedValue
	private int codigo;
	private String numero;
	private double total;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="per_cedula")
	private Persona cliente;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_factura")
	private List<Detalle> detalles;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	
	
	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	
	
	public void addDetalle(Detalle detalle) {
		if(this.detalles == null)
			this.detalles=new ArrayList<Detalle>();
			
			this.detalles.add(detalle);
	}

}
