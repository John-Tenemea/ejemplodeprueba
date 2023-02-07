package ec.edu.ups.pweb.demojpa.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pweb.demojpa.Producto;

@Stateless
public class ProductoDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	public void insert (Producto producto) {
		em.persist(producto);
	}
	public Producto read (int codigo) {
		Producto p=em.find(Producto.class, codigo);
		return p;
		
	}
	public void update (Producto producto) {
		em.merge(producto);
	}
	public void delete (int codigo) {
		Producto p=em.find(Producto.class, codigo);
		em.remove(p);
	}
	
	public List<Producto> getList(){
		String jsql = "SELECT p FROM Producto p";
				Query query = em.createQuery(jsql, Producto.class);
				List<Producto> lista = query.getResultList();
						return lista;
	}
	/*public List<Persona> getListXAnio(int anio){
		String jsql = "SELECT p FROM Persona p WHERE anioNacimiento > :anio";
				Query query = em.createQuery(jsql, Persona.class);
				query.setParameter("anio", anio);
				List<Persona> lista = query.getResultList();
						return lista;
	*/


}