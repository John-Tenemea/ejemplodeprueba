package ec.edu.ups.pweb.demojpa.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pweb.demojpa.Factura;

@Stateless
public class FacturaDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert (Factura factura) {
		em.persist(factura);
	}
	
	public Factura read (int codigo) {
		Factura p=em.find(Factura.class, codigo);
		return p;
		
	}
	public void update (Factura factura) {
		em.merge(factura);
	}
	
	public void delete (int codigo) {
		Factura p=em.find(Factura.class, codigo);
		em.remove(p);
	}
	
	public List<Factura> getList(){
		String jsql = "SELECT p FROM Factura p";
		Query query = em.createQuery(jsql, Factura.class);
		List<Factura> lista = query.getResultList();
		return lista;
	}
	
	public List<Factura> getListCompleta(){
		String jsql = "SELECT p FROM Factura p";
		Query query = em.createQuery(jsql, Factura.class);
		List<Factura> lista = query.getResultList();
		if(lista.size()>0) {
			lista.get(0).getCliente().getCedula();
		}
		return lista;
	}
	
	
}