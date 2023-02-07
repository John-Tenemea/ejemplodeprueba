package ec.edu.ups.pweb.demojpa.services;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.pweb.demojpa.Persona;
import ec.edu.ups.pweb.demojpa.dao.PersonaDAO;


@Path("clientes")
public class ClienteService {
	
	@Inject
	private PersonaDAO daoPersona;
	
	@GET
	@Path("hola")
	@Produces(MediaType.APPLICATION_JSON)
	public String HolaMundo(){
		return "{\"mensaje\":\"hola mundo\"}";
	}
	
	@GET
	@Path("Persona")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona misDatos(){
		Persona p=new Persona();
		p.setCedula("0106840184");
		p.setNombre("John Tenemea");
		p.setAnioNacimiento(1994);
		return p;
	}
	
	
	@GET
	@Path("saludar")
	public String saludar (@QueryParam("name")String nombre) {
		return "hola "+nombre;
	}
	
	@GET
	@Path("sumar")
	public String suma (@QueryParam("a") int a, @QueryParam("b") int b) {
		return "resultado"+(a+b);
		
	}
	
	
	@GET
	@Path("sumar/{a}/{b}")
	public String suma2 (@QueryParam("a") int a, @QueryParam("b") int b) {
		return "resultado"+(a+b);
		
	}
	
	public String guardarPersona (String cedula, String nombre, int anio) {
		Persona p =new Persona();
		p.setCedula(cedula);
		p.setNombre(nombre);
		p.setAnioNacimiento(anio);
		daoPersona.insert(p);
		
		return "insertado";
	}
	
	@POST
	@Path("guardar")
	@Produces("application/json")
	@Consumes("application/json")
	public String guardarPersonaObjeto(Persona p) {
		try {
			daoPersona.insert(p);
		}catch(Exception e){
			return "{\"resultado\":\"ERROR\"}"; 
		}
		return "{\"resultado\":\"ok\"}";
	}
	
	@GET
	@Path("/listarPers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getListadoPersonas(){
		return daoPersona.getList();
	}
}
