package ec.edu.ups.pweb.demojpa.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pweb.demojpa.Persona;

@Stateless
public class PersonaDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	public void insert (Persona persona) {
		em.persist(persona);
	}
	public Persona read (String cedula) {
		Persona p=em.find(Persona.class, cedula);
		return p;
		
	}
	public void update (Persona persona) {
		em.merge(persona);
	}
	public void delete (String cedula) {
		Persona p=em.find(Persona.class, cedula);
		em.remove(p);
	}
	
	public List<Persona> getList(){
		String jsql = "SELECT p FROM Persona p";
				Query query = em.createQuery(jsql, Persona.class);
				List<Persona> lista = query.getResultList();
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
